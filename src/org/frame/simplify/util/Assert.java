package org.frame.simplify.util;

/**
 * 
 * @ClassName: Assert
 * @Description: TODO(断言工具类)
 * @author willdas
 * @date 2018年10月16日 下午5:41:30
 *
 */
public abstract class Assert {

	/**
	 * 
	 * @Title: notNull
	 * @Description: TODO(判断对象是否为空)
	 * @return void 返回类型
	 * @param object
	 * @param message
	 */
	public static void notNullObject(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 
	 * @Title: notNullString
	 * @Description: TODO(判断字符串是否为空)
	 * @return void 返回类型
	 * @param string
	 * @param message
	 */
	public static void notNullString(String string, String message) {
		if (string == null || string.length() <= 0) {
			throw new IllegalArgumentException(message);
		}
	}
}
