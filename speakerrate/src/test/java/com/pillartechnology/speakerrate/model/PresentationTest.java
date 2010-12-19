package com.pillartechnology.speakerrate.model;

import static com.google.common.collect.ImmutableSet.*;
import static com.pillartechnology.speakerrate.matchers.ValidationMatcher.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PresentationTest {
	
	private Presentation sut = new Presentation();
	
	@Mock private Rating firstRating;
	@Mock private Rating secondRating;
	private Set<Rating> ratings;
	
	@Before
	public void setupDefaults() {
		ratings = of(firstRating,secondRating);
		sut.setRatings(ratings);
		sut.setTitle("title");
		sut.setPresentedAt(new Date());
	}
	
	@Test
	public void defaultSetupIsValid() {
		assertThat(sut,is(valid()));	
	}

	@Test
	public void blankTitleIsNotValid() {
		sut.setTitle("");

		assertThat(sut, is(not(valid())));
	}
	
	@Test
	public void nullPresentedAtIsInvalid() {
		sut.setPresentedAt(null);
		
		assertThat(sut, is(not(valid())));
	}
	
	@Test
	public void computesAverageContentScore() {
		when(firstRating.getContentScore()).thenReturn(25);
		when(secondRating.getContentScore()).thenReturn(75);
		double expected = 50;
		
		double result = sut.getAverageContentScore();
		
		assertThat(result,is(expected));
	}

	@Test
	public void computesAverageDeliveryScore() {
		when(firstRating.getDeliveryScore()).thenReturn(10);
		when(secondRating.getDeliveryScore()).thenReturn(17);
		double expected = 13.5;
		
		double result = sut.getAverageDeliveryScore();
		
		assertThat(result,is(expected));
	}
}