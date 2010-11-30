package com.pillartechnology.speakerrate.matchers;

import java.util.*;

import javax.validation.*;

import org.hamcrest.*;

public class ValidationMatcher extends TypeSafeMatcher<Object> {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	private Set<String> validationMessages = new HashSet<String>();

	@Override
	public boolean matchesSafely(Object bean) {
		Set<ConstraintViolation<Object>> violations = validator.validate(bean);
		for (ConstraintViolation<Object> constraintViolation : violations) {
			validationMessages.add(constraintViolation.getPropertyPath().toString() + " " + constraintViolation.getMessage());
		}
		return violations.size() == 0;
	}

	public void describeTo(Description description) {
		description.appendText("invalid with errors: ");
		for (String msg : validationMessages) {
			description.appendText(msg + "\n");
		}
	}

	@Factory
	public static <T> Matcher<Object> valid() {
		return new ValidationMatcher();
	}
}
