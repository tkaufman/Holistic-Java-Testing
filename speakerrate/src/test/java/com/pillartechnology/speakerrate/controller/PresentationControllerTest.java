package com.pillartechnology.speakerrate.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.pillartechnology.speakerrate.model.Presentation;
import com.pillartechnology.speakerrate.persistence.PresentationRepository;

@RunWith(MockitoJUnitRunner.class)
public class PresentationControllerTest {

	private static long PRESENTATION_ID = 29813l;
	
	@InjectMocks private PresentationController sut = new PresentationController();

	@Mock private PresentationRepository presentationRepository;
	@Mock private Model model;
	
	@Mock private Presentation presentation;
	private Set<Presentation> presentations;
	
	@Before
	public void buildPresentations() {
		presentations = new HashSet<Presentation>();
		presentations.add(presentation);
	}

	@Test
	public void indexShouldRedirectToIndex() {
		String result = sut.index(model);
		
		assertThat(result, is("presentations/index"));
	}
	
	@Test
	public void indexShouldSetPresentationsOnTheModel() {
		when(presentationRepository.findAll()).thenReturn(presentations);
		
		sut.index(model);
		
		verify(model).addAttribute("presentations",presentations);
	}
	
	@Test
	public void showShouldReturnShow() {
		String result = sut.show(PRESENTATION_ID, model);
		
		assertThat(result,is("presentations/show"));
	}
	
	@Test
	public void showShouldSetPresentationOnTheModel() {
		when(presentationRepository.findById(PRESENTATION_ID)).thenReturn(presentation);
		
		sut.show(PRESENTATION_ID,model);
		
		verify(model).addAttribute("presentation",presentation);
	}
	
	@Test
	public void newShouldReturnNew() {
		String result = sut.newForm(model);
		
		assertThat(result,is("presentations/new"));
	}
	
	@Test
	public void showShouldAddPresentationToTheModel() {
		sut.newForm(model);
		
		verify(model).addAttribute(isA(Presentation.class));
	}
	
	@Test
	public void createShouldRedirectToNewPresentationId() {
		when(presentation.getId()).thenReturn(PRESENTATION_ID);
		
		String result = sut.create(presentation, null);
		
		assertThat(result,is("redirect:presentations/"+PRESENTATION_ID));
	}
	
	@Test
	public void shouldPersistNewPresentation() {
		sut.create(presentation, null);
		
		verify(presentationRepository).persist(presentation);
	}
	
}
