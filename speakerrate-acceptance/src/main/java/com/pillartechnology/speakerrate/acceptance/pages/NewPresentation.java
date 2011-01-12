package com.pillartechnology.speakerrate.acceptance.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class NewPresentation extends AbstractPage {

	public NewPresentation(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void pageIsShown() {
		findElement(By.className("presentations-new-page"));
	}

	public void enterTitle(String title) {
		findElement(By.id("title")).sendKeys(title);
	}
	
	public void enterDate(String date) {
		findElement(By.id("presentedAt")).sendKeys(date);
	}
	
	public void clickSubmit() {
		findElement(By.tagName("button")).click();
	}

}
