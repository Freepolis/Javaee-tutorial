package com.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy = {EqualValidator.class})
@Documented 
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD }) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface Equal {
	String message() default "密码不匹配不正确"; 
}
