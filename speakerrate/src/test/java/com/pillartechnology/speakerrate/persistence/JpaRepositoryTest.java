package com.pillartechnology.speakerrate.persistence;

import static com.google.common.collect.ImmutableList.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JpaRepositoryTest {

	private class Entity{}
	
	@InjectMocks JpaRepository<Entity> sut = new JpaRepository<Entity>(){};
	
	/* (from Mockito Docs) WARNING: This feature should rarely be required for regular clean code! Leave it
	 * 		for legacy code. Mocking a mock to return a mock, to return a mock, (...), to return something 
	 * 		meaningful hints at violation of Law of Demeter... */
	@Mock(answer=Answers.RETURNS_DEEP_STUBS) EntityManager entityManager;
	
	@Mock Entity entity;
	
	@Test
	public void findAllShouldInferTypeArgumentForFindAllQuery() {
		sut.findAll();
		
		verify(entityManager.getCriteriaBuilder()).createQuery(Entity.class);
	}
	
	@Test
	public void findAllShouldSetRootTypeOnQuery() {
		sut.findAll(); 
		
		verify(entityManager.getCriteriaBuilder().createQuery(Entity.class)).from(Entity.class);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void findAllShouldPassThroughResult() {
		when(entityManager.createQuery(isA(CriteriaQuery.class)).getResultList()).thenReturn(of(entity));
		
		Set<Entity> results = sut.findAll();
		
		assertThat(results,hasItem(entity));
	}
	
	@Test
	public void findByIdShouldDelegateToEntityManager() {
		resetEntityManagerToDefaultAnswer();
		long id = 8934l;
		when(entityManager.find(Entity.class, 8934l)).thenReturn(entity);
		
		Entity result = sut.findById(id);
		
		assertThat(result,is(entity));
	}
	
	@Test
	public void persistCallsPersist() {
		sut.persist(entity);
		
		verify(entityManager).persist(entity);
	}
	
	@Test
	public void removeCallsRemove() {
		sut.remove(entity);
		
		verify(entityManager).remove(entity);
	}

	private void resetEntityManagerToDefaultAnswer() {
		//Deep stubs can result in several un-stubbable situations
		entityManager = mock(EntityManager.class);
		sut.setEntityManager(entityManager);
	}
	
}
