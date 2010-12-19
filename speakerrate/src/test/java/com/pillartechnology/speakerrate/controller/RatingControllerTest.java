package com.pillartechnology.speakerrate.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pillartechnology.speakerrate.model.Presentation;
import com.pillartechnology.speakerrate.model.Rating;
import com.pillartechnology.speakerrate.persistence.PresentationRepository;
import com.pillartechnology.speakerrate.persistence.RatingRepository;

@RunWith(MockitoJUnitRunner.class)
public class RatingControllerTest {

	private static long PRESENTATION_ID = 5689l;
	private static long RATING_ID = 422342l;
	
	@InjectMocks private RatingController sut = new RatingController();
	
	@Mock private PresentationRepository presentationRepository;
	@Mock private RatingRepository ratingRepository;
	
	@Mock private Model model;
	@Mock private Rating rating;
	@Mock private Presentation presentation;
	@Mock private BindingResult bindingResult;

	@Before
	public void setupDefaultStubbing() {
		when(rating.getId()).thenReturn(RATING_ID);
		when(presentation.getId()).thenReturn(PRESENTATION_ID);
		when(rating.getPresentation()).thenReturn(presentation);
	}
	
	@Test
	public void showShouldReturnShow() {
		String result = sut.show(RATING_ID, model);
		
		assertThat(result, is("ratings/show"));
	}

	@Test
	public void showShouldSetRatingOnTheModel() {
		when(ratingRepository.findById(RATING_ID)).thenReturn(rating);
		
		sut.show(RATING_ID, model);
		
		verify(model).addAttribute("rating", rating);
	}
	
	@Test
	public void newShouldReturnPathToJsp() {
		String result = sut.newForm(PRESENTATION_ID,model);
		
		assertThat(result,is("ratings/new"));
	}
	
	@Test
	public void newShouldInstantiateANewRating() {
		sut.newForm(PRESENTATION_ID,model);
		
		verify(model).addAttribute(isA(Rating.class));
	}
	
	@Test
	public void createShouldPersist() {
		sut.create(PRESENTATION_ID, rating,bindingResult);
		
		verify(ratingRepository).persist(rating);
	}

	@Test
	public void createShouldAssignPresentationToRating() {
		when(presentationRepository.findById(PRESENTATION_ID)).thenReturn(presentation);
		
		sut.create(PRESENTATION_ID, rating,bindingResult);
		
		verify(rating).setPresentation(presentation);
	}
	
	@Test
	public void createShouldReturnToTheNewFormWhenValidationFails() {
		when(bindingResult.hasErrors()).thenReturn(true);
		
		String result = sut.create(PRESENTATION_ID, rating,bindingResult);
		
		assertThat(result,is("ratings/new"));
	}
	
	@Test
	public void createShouldRedirect() {
		String expected = "redirect:../../"+PRESENTATION_ID;

		String result = sut.create(PRESENTATION_ID,rating,bindingResult);
		
		assertThat(result,is(expected));
	}
	
}
