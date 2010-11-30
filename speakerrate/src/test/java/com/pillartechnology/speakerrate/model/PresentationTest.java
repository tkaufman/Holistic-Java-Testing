package com.pillartechnology.speakerrate.model;

import static com.pillartechnology.speakerrate.matchers.ValidationMatcher.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class PresentationTest {
	
	private Presentation sut = new Presentation();
	
	@Test
	public void nullTitleIsNotValid() {
		sut.setTitle(null);
		
		assertThat(sut, is(not(valid())));
	}
	
	@Test
	public void populatedFirstNameIsValid() {
		sut.setTitle("pants");
		
		assertThat(sut,is(valid()));	
	}
	

}