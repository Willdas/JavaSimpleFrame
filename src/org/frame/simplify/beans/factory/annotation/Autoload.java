package org.frame.simplify.beans.factory.annotation;

import java.lang.annotation.Target;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autoload {
	
	String name() default "";
	
}
