package org.frame.simplify.beans.factory.parsing;

import java.util.ArrayList;
import java.util.Observable;

import org.frame.simplify.beans.factory.util.ClassUtil;

/**
 * 
 * @ClassName: ClassObservable
 * @Description: TODO(解析所有包下的类)
 * @author willdas
 * @date 2018年10月19日 下午2:02:27
 *
 */
public class ClassObservable extends Observable {

	/**
	 * 
	 * @Title: parse
	 * @Description: TODO(解析查找所有类)
	 * @return void 返回类型
	 * @param packagename
	 */
	public void parseAllClass(String packagename) {
		ArrayList<Class<?>> classes = ClassUtil.findClass(packagename);
		if (classes.size() != 0) {
			this.setChanged();
			this.notifyObservers(classes);
		}
	}

}
