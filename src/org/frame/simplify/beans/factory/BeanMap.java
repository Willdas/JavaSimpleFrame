package org.frame.simplify.beans.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @ClassName: ObjectMapUtil
 * @Description: TODO(存放Bean对象)
 * @author willdas
 * @date 2018年10月16日 下午3:40:21
 *
 */
public class BeanMap {

	private static HashMap<Object, Object> objMap = new HashMap<Object, Object>();

	public BeanMap() {
		super();
	}

	public static Object putObj(Object key, Object object) {
		return objMap.put(key, object);
	}

	public static Object getObj(Object key) {
		return objMap.get(key);
	}

	@SuppressWarnings("rawtypes")
	public static void putAll(Map t) {
		Iterator it = t.keySet().iterator();
		while (it.hasNext()) {
			Object key = (Object) it.next();
			putObj(key, t.get(key));
		}
	}

	public static int size() {
		return objMap.size();
	}

	public static boolean isEmpty() {
		return objMap.size() == 0;
	}

	public static Map<Object, Object> getMap() {
		return objMap;
	}
}
