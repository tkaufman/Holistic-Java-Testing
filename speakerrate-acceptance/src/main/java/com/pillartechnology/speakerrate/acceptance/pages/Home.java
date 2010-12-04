package com.pillartechnology.speakerrate.acceptance.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverProvider;

public class Home extends AbstractPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://localhost:8080/speakerrate/");
		manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
