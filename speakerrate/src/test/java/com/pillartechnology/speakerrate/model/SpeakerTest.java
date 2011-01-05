package com.pillartechnology.speakerrate.model;

import static com.pillartechnology.speakerrate.matchers.ValidationMatcher.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SpeakerTest {
	
	private Speaker sut = new Speaker();
	
	@Before
	public void setupDefaults() {
		sut.setFirstName("Todd");
		sut.setLastName("Pants");
		sut.setEmail("todd@toddpants.com");
	}
	
	@Test
	public void defaultsShouldBeValid() {
		assertThat(sut, is(valid()));
	}

	@Test
	public void nullFirstNameIsNotValid() {
		sut.setFirstName(null);
		
		assertThat(sut, is(not(valid())));
	}
	
	@Test
	public void nullLastNameIsNotValid() {
		sut.setLastName(null);
		
		assertThat(sut, is(not(valid())));
	}
	
	@Test
	public void nullEmailIsNotValid() {
		sut.setEmail(null);
		
		assertThat(sut, is(not(valid())));
	}
	
	@Test
	public void malformedEmailIsNotValid() {
		sut.setEmail("pants");
		
		assertThat(sut, is(not(valid())));
	}
}
