package com.glqdlt.ex.reflectionwithannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author glqdlt
 * 2019-02-19
 */
@Target(ElementType.ANNOTATION_TYPE.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IndexAnnotation {
    String getMethodNamePrefix() default "get";
    boolean parseSkip() default false;
}
