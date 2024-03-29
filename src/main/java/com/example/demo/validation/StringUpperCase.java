package com.example.demo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringUpperCaseValidator.class)
public @interface StringUpperCase {
	String message() default "text must be all uppercase";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
