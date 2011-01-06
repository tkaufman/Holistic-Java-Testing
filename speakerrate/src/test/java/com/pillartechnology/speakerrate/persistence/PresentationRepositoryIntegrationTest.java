package com.pillartechnology.speakerrate.persistence;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Presentation;
import com.pillartechnology.speakerrate.model.Rating;

@Transactional
@ContextConfiguration(locations={"/spring/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PresentationRepositoryIntegrationTest {

	private JpaPresentationRepository sut = new JpaPresentationRepository();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Before
	public void setupRepository() {
		sut.setEntityManager(entityManager);
	}

	@Test
	public void shouldFindGoodPresentations() {
		Presentation goodPresentation = buildPresentationFixture();
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.add(buildRatingFixture(goodPresentation, 100, 100));
		sut.persist(goodPresentation);
		
		assertThat(sut.findRecommendedPresentations(80), is(not(nullValue())));
	}
		
	@Test
	public void shouldFindNoBadPresentations() {
		Presentation badPresentation = buildPresentationFixture();
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.add(buildRatingFixture(badPresentation, 1, 1));
		sut.persist(badPresentation);
		
		assertThat(sut.findRecommendedPresentations(80).size(), is(0));
	}
		
	private Rating buildRatingFixture(Presentation presentation, int contentScore, int deliveryScore) {
		Rating rating = new Rating();
		rating.setContentScore(contentScore);
		rating.setDeliveryScore(deliveryScore);
		rating.setEmail("toddkaufman@gmail.com");
		rating.setPresentation(presentation);
		return rating;
	}

	private Presentation buildPresentationFixture() {
		Presentation presentation = new Presentation();
		presentation.setTitle("The Pres");
		presentation.setPresentedAt(new Date());
		return presentation;
	}

}
