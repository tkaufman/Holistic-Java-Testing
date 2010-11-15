package com.pillartechnology.speakerrate;

import org.junit.Test;
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
