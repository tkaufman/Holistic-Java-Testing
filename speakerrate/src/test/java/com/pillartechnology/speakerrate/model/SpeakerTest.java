package com.pillartechnology.speakerrate.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;


public class SpeakerTest {
	
	private static Validator validator;

	private Speaker sut = new Speaker();
	
	@BeforeClass
	public static void createValidator() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void nullFirstNameIsNotValid() {
		sut.setFirstName(null);
		
		Set<ConstraintViolation<Speaker>> violations = validator.validate(sut);
		
		assertThat(violations.size(),is(1));
	}
	
	@Test
	public void populatedFirstNameIsValid() {
		sut.setFirstName("pants");
		
		Set<ConstraintViolation<Speaker>> violations = validator.validate(sut);
		
		assertThat(violations.size(),is(0));	
	}
	

}
