package com.pillartechnology.samples;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrettyHamcrestExample {

	@Test
	public void nullObjectsAreNull() {
		Object obj = null;
		assertThat(obj, is(nullValue()));
	}
	
	@Test
	public void matchingListContentsIsEasy() {
		List<String> coders = Arrays.asList("Justin", "Magnus", "Todd", "Patrick");
		
		assertThat(coders,  hasItems("Magnus", "Justin"));
	}
		
	@Test
	public void referencesPointToStuff() {
		Object a = new Object();
		Object b = a;
		
		assertThat(b, sameInstance(a));
	}
	
	@Test
	public void oneOfManyOptionsIsSometimesHard() {
		String currentSpeaker = "Todd";
		
		assertThat(currentSpeaker, isOneOf("Todd", "Justin", "Magnus", "Patrick"));
	}
	
	@Test
	public void stringCheckingDoesntStink() {
		String statement = "Bananas taste YUMMY";
		assertThat(statement, startsWith("B"));
		assertThat(statement, equalToIgnoringCase("bananas taste yummy"));
		assertThat(statement, equalToIgnoringWhiteSpace("Bananas    \n\t  taste       \n   YUMMY"));
		assertThat(statement, endsWith("YUMMY"));
	}
	
}
