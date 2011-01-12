package com.pillartechnology.speakerrate.acceptance.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class NewRating extends AbstractPage {

	public NewRating(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void pageIsShown() {
		findElement(By.className("ratings-new-page"));
	}


}
