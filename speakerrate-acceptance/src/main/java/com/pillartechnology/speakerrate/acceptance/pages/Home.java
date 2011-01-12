package com.pillartechnology.speakerrate.acceptance.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://localhost:4011/speakerrate/");
		manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Override
	public void pageIsShown() {
		findElement(By.className("home-page"));
	}

	public void clickManagePresentations() {
		findElement(By.className("presentations-index-link")).click();
	}

}
