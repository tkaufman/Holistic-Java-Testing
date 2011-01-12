package com.pillartechnology.speakerrate.acceptance.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class PresentationsIndex extends AbstractPage {

	public PresentationsIndex(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void pageIsShown() {
		findElement(By.className("presentations-index-page"));
	}

	public void clickCreateNewPresentation() {
		findElement(By.className("presentations-new-link")).click();
	}

}
