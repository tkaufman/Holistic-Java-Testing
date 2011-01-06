package com.pillartechnology.speakerrate.persistence;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Speaker;

@Transactional
@ContextConfiguration(locations={"/spring/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpeakerRepositoryIntegrationTest {

	private JpaSpeakerRepository sut = new JpaSpeakerRepository();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Before
	public void setupRepository() {
		sut.setEntityManager(entityManager);
	}
	
	@Test
	public void shouldFindZeroSpeakers() {
		Set<Speaker> results = sut.findAll();
		
		assertThat(results.size(),is(0));
	}
	
	@Test
	public void shouldPersistASpeakerAndThenFindIt() {
		Speaker speaker = buildSpeakerFixture();
		sut.persist(speaker);
		
		assertThat(speaker.getId(),is(not(0l)));
		assertThat(sut.findById(speaker.getId()),is(not(nullValue())));
	}

	@Test
	public void shouldRemoveASpeakerAndThenNotFindIt() {
		Speaker speaker = buildSpeakerFixture();
		sut.persist(speaker);
		
		sut.remove(speaker);
		
		assertThat(sut.findById(speaker.getId()), is(nullValue()));
	}

	private Speaker buildSpeakerFixture() {
		Speaker speaker = new Speaker();
		speaker.setFirstName("John");
		speaker.setLastName("Doe");
		speaker.setEmail("JD@JD.com");
		return speaker;
	}

}
