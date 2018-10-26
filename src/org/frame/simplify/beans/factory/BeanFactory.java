package org.frame.simplify.beans.factory;

import java.util.ArrayList;
import org.frame.simplify.beans.factory.util.BeanUtil;
import org.frame.simplify.beans.factory.util.SingletonBeanFactory;

/**
 * 
 * @ClassName: BeanFactory
 * @Description: TODO(Bean创建工厂)
 * @author willdas
 * @date 2018年10月16日 下午3:48:05
 *
 */
public class BeanFactory implements InitializationBean {

	public BeanFactory() {
		super();
	}

	@Override
	public void initBean(Class<?> clazz) {
		SingletonBeanFactory.getInstance(clazz);
	}

	/**
	 * 
	 * @Title: initBean
	 * @Description: TODO(创建对象)
	 * @return void 返回类型
	 * @param objList
	 */
	public static void initBean(ArrayList<Class<?>> objList) {
		objList.forEach(n -> BeanUtil.createBean((Class<?>) n));
	}

	/**
	 * 
	 * @Title: injectionBean
	 * @Description: TODO(注入对象)
	 * @return void 返回类型
	 * @param clazz
	 */
	public static void injectionBean(ArrayList<Object> objList) {
		BeanUtil.injectionBean(objList);
	}
	
}
