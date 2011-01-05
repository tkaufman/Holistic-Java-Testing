package com.pillartechnology.speakerrate.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RatingTest {
	
	private static Validator validator;

	private Rating sut = new Rating();
	
	@BeforeClass
	public static void createValidator() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Before
	public void setupDefaults() {
		sut.setComment("blah");
		sut.setEmail("toddkaufman@gmail.com");
		sut.setPresentation(new Presentation());
	}
	
	@Test
	public void nullEmailIsNotValid() {
		sut.setEmail(null);
		
		Set<ConstraintViolation<Rating>> violations = validator.validate(sut);
		
		assertThat(violations.size(),is(1));
	}
	
	@Test
	public void populatedEmailIsValid() {

		Set<ConstraintViolation<Rating>> violations = validator.validate(sut);
		
		assertThat(violations.size(),is(0));	
	}
	
	//TODO: Other fields...
}
