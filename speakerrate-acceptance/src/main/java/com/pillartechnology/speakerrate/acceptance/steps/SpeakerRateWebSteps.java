package com.pillartechnology.speakerrate.acceptance.steps;

import java.util.Date;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pillartechnology.speakerrate.acceptance.pages.Home;
import com.pillartechnology.speakerrate.acceptance.pages.NewPresentation;
import com.pillartechnology.speakerrate.acceptance.pages.PageRetriever;
import com.pillartechnology.speakerrate.acceptance.pages.PresentationsIndex;
import com.pillartechnology.speakerrate.acceptance.pages.ShowPresentation;

public class SpeakerRateWebSteps {

	private PageRetriever pages;

	public SpeakerRateWebSteps(PageRetriever pages) {
		this.pages = pages;
	}

	@Given("I open the SpeakerRate app")
	public void openPage() {
		pages.retrievePage(Home.class).open();
	}
	
	@When("I open the Manage Presentations page")
	public void userClicksOnFindSteps() {
		pages.retrievePage(Home.class).clickManagePresentations();
	}

	@When("I click \"Create new presentation\"")
	public void newPresentation() {
		pages.retrievePage(PresentationsIndex.class).clickCreateNewPresentation();
	}
	
	@When("I enter \"$title\" into the Title field")
	public void enterTitle(String title) {
		pages.retrievePage(NewPresentation.class).enterTitle(title + " " + (new Date()).getTime());
	}
	
	@When("I enter \"$date\" into the Date field")
	public void enterDate(String date) {
		pages.retrievePage(NewPresentation.class).enterDate(date);
	}
	
	@When("I click \"Submit\"")
	public void clickSubmit() {
		pages.retrievePage(NewPresentation.class).clickSubmit();
	}
	
	@When("I click \"Rate this presentation\"")
	public void clickRatePresentation() {
		pages.retrievePage(ShowPresentation.class).clickRateThisPresentation();
	}
	
	
	@Then("I am on the $name page")
	public void userIsOnPage(String name) {
		pages.retrievePage(name).pageIsShown();;
	}
	
	/**
	 * newPresentationPage = presentationsPage.createNewPresentation.clickToNewPage();
    assertTrue(newPresentationPage.titleField.isVisible());
    assertTrue(newPresentationPage.dateField.isVisible());
    
    newPresentationPage.titleField.enter("Why Statics In Java Are Really, Really Evil" + Math.random());
    newPresentationPage.dateField.enter("01/30/2011");
    Presentation newPresentationSummaryPage = newPresentationPage.submit.clickToNewPage();
    assertTrue(newPresentationSummaryPage.containsText("Rate this presentation"));
    
    PresentationRating ratingPage = newPresentationSummaryPage.rateThisPresentation.clickToNewPage();
	 */
	
}
