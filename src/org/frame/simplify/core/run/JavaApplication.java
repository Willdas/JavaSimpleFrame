package org.frame.simplify.core.run;

import java.lang.annotation.Annotation;
import org.frame.simplify.beans.factory.annotation.ComponentScan;
import org.frame.simplify.beans.factory.parsing.ClassObservable;
import org.frame.simplify.beans.factory.parsing.ClassObserver;
import org.frame.simplify.util.Assert;

/** 
* @ClassName: JavaApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author fsjohnhuang
* @date 2018年10月17日 下午5:07:10 
* 
* @param <T> 
*/
/**
 * @ClassName: JavaApplication
 * @Description: TODO(主程序)
 * @author wangzewen
 * @date 2018年10月17日 下午5:07:14
 * 
 * @param <T>
 */
public class JavaApplication {
	
	private Class<?> clazz = null;

	public JavaApplication() {
		super();
	}

	public JavaApplication(Class<?> clazz) {
		Assert.notNullObject(clazz, "PrimarySources must not be null");
		this.clazz = clazz;
	}

	public static void run(Class<?> clazz) {
		new JavaApplication(clazz).init();
	}
	
	/**
	 * 
	 * @Title: init
	 * @Description: TODO(初始化扫描包下的所有对象)
	 * @return void 返回类型
	 * @param clazz
	 */
	private void init() {
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof ComponentScan) {
				String packagename = ((ComponentScan) annotation).basePackages();
				init(packagename);
			}
		}
	}
	
	private void init(String packagename){
		ClassObservable classUtil = new ClassObservable();
		classUtil.addObserver(new ClassObserver());
		classUtil.parseAllClass(packagename);
	}
}
