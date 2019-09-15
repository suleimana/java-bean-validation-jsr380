package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringUpperCaseValidator implements ConstraintValidator<StringUpperCase, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		boolean hasLowerCase = value.chars().anyMatch(Character::isLowerCase);
		return !hasLowerCase;
	}
	

}
