package com.pillartechnology.speakerrate.acceptance.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

	private WebDriverProvider driverProvider;
	private Home home;
	private PresentationsIndex presentationsIndex;

	public Pages(WebDriverProvider driverProvider) {
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}

	public PresentationsIndex presentationsIndex() {
		if (presentationsIndex == null) {
			presentationsIndex = new PresentationsIndex(driverProvider);
		}
		return presentationsIndex;
	}

}
