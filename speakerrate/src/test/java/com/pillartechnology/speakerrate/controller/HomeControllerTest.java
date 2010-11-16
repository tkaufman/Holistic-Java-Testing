package com.pillartechnology.speakerrate.controller;

import org.junit.Test;

import com.pillartechnology.speakerrate.controller.HomeController;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class HomeControllerTest {

	private HomeController sut = new HomeController();
	
	@Test
	public void shouldReturnHomeToRenderHomeJsp() {
		String result = sut.view();
		
		assertThat(result,is("home"));
	}
	
}
