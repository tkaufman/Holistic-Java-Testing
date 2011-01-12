package com.pillartechnology.speakerrate.acceptance.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class ShowPresentation extends AbstractPage {

	public ShowPresentation(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void pageIsShown() {
		findElement(By.className("presentations-show-page"));
	}

	public void clickRateThisPresentation() {
		findElement(By.className("ratings-new-link")).click();
	}

}
