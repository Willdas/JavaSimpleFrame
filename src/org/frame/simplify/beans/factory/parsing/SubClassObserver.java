package org.frame.simplify.beans.factory.parsing;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.frame.simplify.beans.factory.BeanFactory;

/**
 * 
 * @ClassName: ImplClassObserver
 * @Description: TODO(解析实现类)
 * @author willdas
 * @date 2018年10月19日 下午2:22:20
 *
 */
public class SubClassObserver implements Observer {

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		BeanFactory.injectionBean((ArrayList<Object>)arg);
	}

}
