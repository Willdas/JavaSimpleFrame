package org.frame.simplify.beans.factory.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.stream.Stream;
import org.frame.simplify.util.Assert;

/**
 * 
 * @ClassName: ClassUtil
 * @Description: TODO(扫描所有需要被创建的类)
 * @author willdas
 * @date 2018年10月18日 上午11:39:32
 *
 */
public class ClassUtil {

	private String packagename;

	public ClassUtil() {
		super();
	}

	public ClassUtil(String packagename) {
		Assert.notNullString(packagename, "Packagename must not be null");
		this.packagename = packagename;
	}

	/**
	 * 
	 * @Title: findClass
	 * @Description: TODO(扫描所有包下的类)
	 * @return ArrayList<Class<?>> 返回类型
	 * @param packagename
	 * @return
	 */
	public static ArrayList<Class<?>> findClass(String packagename) {
		return new ClassUtil(packagename).findClass();
	}

	/**
	 * 
	 * @Title: findClass
	 * @Description: TODO(从一个指定路径下查找所有的类)
	 * @return void 返回类型
	 */
	public ArrayList<Class<?>> findClass() {
		ArrayList<Class<?>> objList = new ArrayList<Class<?>>();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			String path = packagename.replace('.', '/');
			Enumeration<URL> enumeration = classLoader.getResources("../bin/" + path);
			File file = new File(enumeration.nextElement().getFile());
			objList.addAll(findClass(file, packagename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objList;
	}

	/**
	 * 
	 * @Title: findClass
	 * @Description: TODO(查找包下的所有类)
	 * @return ArrayList<Object> 返回类型
	 * @param file
	 * @param packagename
	 * @return
	 */
	private static ArrayList<Class<?>> findClass(File file, String packagename) {
		ArrayList<Class<?>> list = new ArrayList<Class<?>>();
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				findClass(file2, packagename, list);
			}
		}
		return list;
	}

	private static void findClass(File file, String packagename, ArrayList<Class<?>> list) {
		try {
			if (file.isDirectory()) {
				if (!file.getName().contains(".")) {
					list.addAll(findClass(file, packagename + "." + file.getName()));
				}
			} else if (file.getName().endsWith(".class")) {
				list.add(Class.forName(packagename + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: findImplClass
	 * @Description: TODO(查找接口下的所有实现类)
	 * @return ArrayList<Class<?>> 返回类型
	 * @param classType
	 * @return
	 */
	public static ArrayList<Object> findImplClass(ArrayList<Object> fieldTypeList) {
		ArrayList<Class<?>> allClass = findClass(((Class<?>) fieldTypeList.get(2)).getPackage().getName());
		Stream<Class<?>> filter = allClass.stream()
				.filter(n -> ((Class<?>) fieldTypeList.get(2)).isAssignableFrom(n))
				.filter(m -> !((Class<?>) fieldTypeList.get(2)).equals(m));
		Iterator<Class<?>> iterator = filter.iterator();
		while (iterator.hasNext()) {
			Class<?> clazz = (Class<?>) iterator.next();
			fieldTypeList.add(clazz);
		}
		return fieldTypeList;
	}
}
