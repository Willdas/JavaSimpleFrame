package org.frame.simplify.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

/**
 * 
 * @ClassName: ComponentScan
 * @Description: TODO(组件扫描)
 * @author willdas
 * @date 2018年10月17日 上午10:35:52
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ComponentScan {

	String basePackages() default "";
}
