package com.pillartechnology.speakerrate.controller;

import static com.google.common.collect.ImmutableSet.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pillartechnology.speakerrate.model.Speaker;
import com.pillartechnology.speakerrate.persistence.SpeakerRepository;

@RunWith(MockitoJUnitRunner.class)
public class SpeakerControllerTest {

	@InjectMocks private SpeakerController sut = new SpeakerController();

	@Mock private SpeakerRepository speakerRepo;
	@Mock private Speaker speaker;
	@Mock private Model model;
	@Mock private BindingResult bindingResult;
	
	@Test
	public void indexShouldReturnIndex() {
		String result = sut.index(model);
		
		assertThat("speakers/index", is(result));
	}

	@Test
	public void indexShouldPopulateAListOfSpeakers() {
		Set<Speaker> expected = of(speaker);
		when(speakerRepo.findAll()).thenReturn(expected);
		
		sut.index(model);
		
		verify(model).addAttribute("speakers", expected);
	}
	
	@Test
	public void showShouldReturnShow() {
		String result = sut.show(1l, model);
		
		assertThat("speakers/show", is(result));
	}

	@Test
	public void showShouldPopulateTheModel() {		
		when(speakerRepo.findById(anyLong())).thenReturn(speaker);
		
		sut.show(1l, model);
		
		verify(model).addAttribute("speaker", speaker);
	}

	@Test
	public void newFormShouldReturnCreate() {
		String result = sut.newForm(model);
		
		assertThat(result, is("speakers/new"));
	}

	@Test
	public void newFormShouldPopulateBlankSpeaker() {
		sut.newForm(model);
		
		verify(model).addAttribute(isA(Speaker.class));
	}

	@Test
	public void createShouldReturnShow() {
		String result = sut.create(speaker, bindingResult);

		assertThat(result, is("speakers/show"));
	}
	
	@Test
	public void createShouldPersistTheSpeaker() {
		sut.create(speaker, bindingResult);
		
		verify(speakerRepo).persist(speaker);
	}
	
}
