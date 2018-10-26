package org.frame.simplify.beans.factory.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.frame.simplify.beans.factory.BeanFactory;
import org.frame.simplify.beans.factory.BeanMap;
import org.frame.simplify.beans.factory.annotation.BeanObj;
import org.frame.simplify.core.util.ReflectionUtil;

/**
 * 
 * @ClassName: BeanUtil
 * @Description: TODO(Bean对象工具类)
 * @author willdas
 * @date 2018年10月19日 上午11:39:13
 *
 */
public class BeanUtil {

	/**
	 * 
	 * @Title: createBean
	 * @Description: TODO(创建对象)
	 * @return void 返回类型
	 * @param clazz
	 */
	public static void createBean(Class<?> clazz) {
		if (!clazz.isInterface()) {
			BeanObj beanObj = clazz.getAnnotation(BeanObj.class);
			if (beanObj instanceof BeanObj) {
				new BeanFactory().initBean(clazz);
			}
		}
	}

	/**
	 * 
	 * @Title: injectionBean
	 * @Description: TODO(注入对象)
	 * @return void 返回类型
	 * @param objList
	 */
	public static void injectionBean(ArrayList<Object> objList) {
		Class<?> clazz = (Class<?>) objList.get(objList.size()-1);
		Object obj = BeanMap.getObj(clazz);
		Object tatget = BeanMap.getObj(objList.get(0));
		if (obj == null) {
			obj = SingletonBeanFactory.getInstance(clazz);
		}
		ReflectionUtil.setField((Field)objList.get(1), tatget, obj);
	}
}
