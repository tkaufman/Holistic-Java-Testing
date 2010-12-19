package com.pillartechnology.speakerrate.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.pillartechnology.speakerrate.model.Rating;
import com.pillartechnology.speakerrate.persistence.RatingRepository;

@RunWith(MockitoJUnitRunner.class)
public class RatingControllerTest {

	private static long RATING_ID = 422342l;
	
	@InjectMocks private RatingController sut = new RatingController();
	
	@Mock private RatingRepository ratingRepository;
	@Mock private Model model;
	@Mock private Rating rating;

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
}
