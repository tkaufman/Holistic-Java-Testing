package com.pillartechnology.speakerrate.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class HomeControllerTest {

	private HomeController sut = new HomeController();
	
	@Test
	public void shouldReturnHomeToRenderHomeJsp() {
		String result = sut.view();
		
		assertThat(result,is("home"));
	}
	
	
}
