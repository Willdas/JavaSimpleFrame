package org.frame.simplify.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: Bean
 * @Description: TODO(申明为对象)
 * @author willdas
 * @date 2018年10月17日 上午10:37:33
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BeanObj {
	
}
