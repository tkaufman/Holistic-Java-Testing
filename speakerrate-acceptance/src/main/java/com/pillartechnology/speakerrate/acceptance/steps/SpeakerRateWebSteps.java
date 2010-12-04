package com.pillartechnology.speakerrate.acceptance.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pillartechnology.speakerrate.acceptance.pages.Pages;

public class SpeakerRateWebSteps {

	private Pages pages;

	public SpeakerRateWebSteps(Pages pages) {
		this.pages = pages;
	}

	@Given("user is on the Home page")
	public void userIsOnHomePage() {
		pages.home().open();
	}

	@When("user opens the Manage Presentations page")
	public void userClicksOnFindSteps() {
		pages.presentationsIndex().open();
	}

	@Then("the Manage Presentations page is shown")
	public void findStepsPageIsShown() {
		pages.presentationsIndex().pageIsShown();
	}

}
