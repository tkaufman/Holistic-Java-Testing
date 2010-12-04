package com.pillartechnology.speakerrate.acceptance.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class PresentationsIndex extends AbstractPage {

	public PresentationsIndex(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		findElement(By.className("presentations-index-link")).click();
	}

	public void pageIsShown() {
		findElement(By.className("presentations-index"));
	}

}
