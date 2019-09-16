package com.example.demo;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.User;
import com.example.demo.validation.ContactInfoGroup;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(Application.class) ;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();		
		Validator validator = factory.getValidator();	
		Set<ConstraintViolation<User>> violations= null;
		User user = new User(); 				

		user.setUsername("Johnsmith");
		user.setEmail("johmATgmail.com");
		user.setActive(false);
		user.setPhone("000-444-5555");
		user.setFirstName(null);
		user.setDateOfBirth(LocalDate.of(2016, 5, 7));
		user.setAge(125);
		user.setBio("somthing about me");
		
		violations = validator.validate(user);		
		printValidationResult(violations);			

		//Validate a subset of constraints using groups  
		violations = validator.validate(user, ContactInfoGroup.class);		
		printValidationResult(violations);
				
		
		// Object that pass all validation checks 
		
		user.setUsername("JOHNSMITH");
		user.setEmail("johm@gmail.com");
		user.setActive(true);
		user.setPhone("333-444-5555");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setDateOfBirth(LocalDate.of(1999, 5, 7));
		user.setHobbies(Arrays.asList("Gaming"));
		user.setAge(25);
		user.setBio("somthing about me that is between 45 and 200 characters.");
		
		violations = validator.validate(user);		
		printValidationResult(violations);					
		
		
	}

	private void printValidationResult(Set<ConstraintViolation<User>> violations) {
		log.info("#################################################################");
		log.info("You have {} violations ",violations.size());
		
		if(!violations.isEmpty()) {			
			log.info("Validation Result:-");
			violations.forEach(constraintViolation ->{
				log.error("- Filed Name: [{}], Field Value: [{}], Error Message: [{}] ",constraintViolation.getPropertyPath().toString(),constraintViolation.getInvalidValue(), constraintViolation.getMessage());				
			});			
		}else {
			log.info("Passed all validations!! ");
		}
		

	}
		

}
