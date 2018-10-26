package org.frame.simplify.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.frame.simplify.beans.factory.annotation.Autoload;
import org.frame.simplify.beans.factory.parsing.ClassObserver;
import org.frame.simplify.beans.factory.util.ClassUtil;
import org.frame.simplify.util.Assert;

/**
 * 
 * @ClassName: ReflectionUtil
 * @Description: TODO(反射工具类)
 * @author willdas
 * @date 2018年10月19日 上午11:06:16
 *
 */
public class ReflectionUtil {

	private static final Field[] NO_FIELDS = {};

	private static final Map<Class<?>, Field[]> declaredFieldsCache = new ConcurrentHashMap<>(256);

	/**
	 * 
	 * @Title: findField
	 * @Description: TODO(获取单个字段)
	 * @return Field 返回类型
	 * @param clazz
	 * @return
	 */
	public static Field findField(Class<?> clazz, Class<?> type) {
		Assert.notNullObject(clazz, "Class must not be null");
		Class<?> searchType = clazz;
		Field[] fields = getDeclaredFields(searchType);
		for (Field field : fields) {
			if (field != null && type.equals(field.getType())) {
				return field;
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: getDeclaredFields
	 * @Description: TODO(获取所有字段)
	 * @return Field[] 返回类型
	 * @param clazz
	 * @return
	 */
	public static Field[] getDeclaredFields(Class<?> clazz) {
		Assert.notNullObject(clazz, "Class must not be null");
		Field[] result = declaredFieldsCache.get(clazz);
		if (result == null) {
			try {
				result = clazz.getDeclaredFields();
				declaredFieldsCache.put(clazz, (result.length == 0 ? NO_FIELDS : result));
			} catch (Throwable ex) {
				throw new IllegalStateException("Failed to introspect Class [" + clazz.getName()
						+ "] from ClassLoader [" + clazz.getClassLoader() + "]", ex);
			}
		}
		return result;
	}

	/**
	 * 
	 * @Title: setField
	 * @Description: TODO(为字段赋值)
	 * @return void 返回类型
	 * @param field
	 * @param target
	 * @param value
	 */
	public static void setField(Field field, Object target, Object value) {
		try {
			field.setAccessible(true);
			field.set(target, value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getFieldType
	 * @Description: TODO(获取字段类型)
	 * @return void 返回类型
	 * @param clazz
	 */
	public static void getFieldType(Class<?> clazz) {
		Field[] fields = getDeclaredFields(clazz);
		for (Field field : fields) {
			Class<?> classType = field.getType();
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof Autoload) {
					ArrayList<Object> fieldTypeList = new ArrayList<Object>();
					fieldTypeList.add(0,clazz);
					fieldTypeList.add(1,field);
					fieldTypeList.add(2,classType);
					if (classType.isInterface()) {
						fieldTypeList = ClassUtil.findImplClass(fieldTypeList);
					}
					new ClassObserver(fieldTypeList);
				}
			}
		}
	}

}
