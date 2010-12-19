package com.pillartechnology.samples;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Exercise 1
 * 
 * A.) Make these tests pass
 * B.) Rewrite these tests with Hamcrest coolness
 *  
 */
public class CrappyJUnitExample {

	@Test
	public void nullObjectsAreNull() {
		Object obj = null;
		assertEquals(null, obj);
	}

	@Test
	public void matchingListContentsIsEasy() {
		List<String> coders = Arrays.asList("Justin", "Magnus", "Todd", "Patrick");
		
		assertTrue(coders.contains("Magnus"));
		assertTrue(coders.contains("Justin"));
	}
		
	@Test
	public void referencesPointToStuff() {
		Object a = new Object();
		Object b = a;
		
		assertTrue(b == a);
	}

	@Test
	public void oneOfManyOptionsIsSometimesHard() {
		String currentSpeaker = "Todd";
		
		List<String> potentials = Arrays.asList("Todd", "Justin", "Magnus", "Patrick");
		assertTrue(potentials.contains(currentSpeaker));
	}
	
	@Test
	public void stringCheckingDoesntStink() {
		String statement = "Bananas taste YUMMY";
		assertTrue(statement.startsWith("B"));
		assertTrue(statement.equalsIgnoreCase("bananas taste yummy"));
		assertEquals("Bananas    \n\t  taste       \n   YUMMY".replaceAll("\\s", ""), statement.replaceAll("\\s", ""));
		assertTrue(statement.endsWith("YUMMY"));
	}
	
}
