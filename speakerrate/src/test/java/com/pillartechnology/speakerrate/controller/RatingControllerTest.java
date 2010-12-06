package com.pillartechnology.speakerrate.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;
import org.springframework.ui.*;

import com.pillartechnology.speakerrate.model.*;
import com.pillartechnology.speakerrate.persistence.*;

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
