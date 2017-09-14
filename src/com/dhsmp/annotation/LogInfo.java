package com.dhsmp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 
 * @version 1.0,2017年9月13日 下午7:34:32,Denghs
 * @remark 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogInfo {

	/** 属性对应数据库表字段的中文名*/
	String name() default "";

	/** 用于格式化Date类型的属性*/
	String pattern() default "";
}