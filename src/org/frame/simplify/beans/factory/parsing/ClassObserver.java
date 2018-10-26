package org.frame.simplify.beans.factory.parsing;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.frame.simplify.beans.factory.BeanFactory;
import org.frame.simplify.beans.factory.BeanMap;
import org.frame.simplify.core.util.ReflectionUtil;

/**
 * 
 * @ClassName: ClassObserver
 * @Description: TODO(解析所有包下的类)
 * @author willdas
 * @date 2018年10月19日 下午2:06:29
 *
 */
public class ClassObserver extends Observable implements Observer {

	public ClassObserver() {
		super();
	}

	public ClassObserver(ArrayList<Object> subClass) {
		this.addObserver(new SubClassObserver());
		this.setChanged();
		this.notifyObservers(subClass);
	}

	/**
	 * 开始初始化对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		BeanFactory.initBean((ArrayList<Class<?>>) arg);
		parseSubclass();
	}

	/**
	 * 
	 * @Title: parseSubclass
	 * @Description: TODO(解析子类)
	 * @return void 返回类型
	 */
	public void parseSubclass() {
		BeanMap.getMap().forEach((k, v) -> ReflectionUtil.getFieldType((Class<?>) k));
	}

}
