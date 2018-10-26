package org.frame.simplify.beans.factory.util;

import org.frame.simplify.beans.factory.BeanMap;

/**
 * 
 * @ClassName: ObjectInit
 * @Description: TODO(创建对象)
 * @author willdas
 * @date 2018年10月16日 下午3:38:52
 *
 */
public class SingletonBeanFactory {

	/**
	 * 
	 * @Title: getInstance
	 * @Description: TODO(创建单例对象)
	 * @return Object 返回类型
	 * @param clazz
	 * @return
	 */
	public static Object getInstance(Class<?> clazz) {
		Object object = null;
		object = BeanMap.getObj(clazz);
		if (object == null) {
			synchronized (clazz) {
				if (object == null) {
					object = createBean(clazz);
					BeanMap.putObj(clazz, object);
				}
			}
		}
		return object;
	}

	/**
	 * 
	 * @Title: createBean
	 * @Description: TODO(创建对象)
	 * @return Object 返回类型
	 * @return
	 */
	private static Object createBean(Class<?> clazz) {
		Object object = null;
		try {
			object = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}

}
