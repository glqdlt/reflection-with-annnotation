package com.glqdlt.ex.reflectionwithannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author glqdlt
 * 2019-02-19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IndexAnnotation {
    String customeColumnName() default "";
    String getMethodNamePrefix() default "";
    boolean parseSkip() default false;
}
