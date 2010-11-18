package com.pillartechnology.samples;

import static com.pillartechnology.samples.IsNotANumber.notANumber;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class HamcrestSugarTest {

	@Test
	public void isMakesForGoodEnglish() {
		String theBestStout = "guinness";

		// Typical
		assertEquals(theBestStout, "guinness");

		assertThat(theBestStout, equalTo("guinness"));

		assertThat(theBestStout, is(equalTo("guinness")));

		assertThat(theBestStout, is("guinness"));
		// Removing parens and other ceremony produces:
		// assert that the best stout is "guinness"
	}

	@Test
	public void negationsDoNotSuck() {
		String theBestStout = "guinness";

		// Typical
		assertNotSame(theBestStout, "murphys");

		assertThat(theBestStout, is(not("murphys")));
		// assert that the best stout is not "murphys"
	}

	@SuppressWarnings("unchecked")
	@Test
	public void anyOfIsNotThatDescriptive() {
		String theBestStout = "guinness";

		assertThat(theBestStout, anyOf(is("guinness"), is("murphys")));
		// assert that the best stout any of is "guinness" is "murphys"?

		// Coming soon?
		// assertThat(theBestStout, either(is("guinness")).or(is("murphys")));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void neitherIsAllOf() {
		String theBestStout = "guinness";

		assertThat(theBestStout, allOf(is("guinness"), containsString("ness")));
		// assert that the best stout all of is "guinness" contains string "ness"?
	}

	@Test
	public void stringUtilsAreNice() {
		String theMessage = "A good guinness pour takes time";

		// Typical
		assertTrue(theMessage.indexOf("guinness") > -1);

		assertThat(theMessage, containsString("guinness"));
		// assert that the message contains string "guinness"

		assertThat(theMessage, startsWith("A"));
		// assert that the message contains string "guinness"

		assertThat(theMessage, endsWith("time"));
		// assert that the message ends with "time"

		assertThat(theMessage, is(equalToIgnoringCase("a good guinness pour takes time")));
		// assert that the message is equal to ignoring case "..."

		assertThat(theMessage, is(equalToIgnoringWhiteSpace("A     good    guinness pour takes time")));
		// assert that the message is equal to ignoring white space "..."
	}

	@Test
	public void collectionUtilsAreCoolToo() {
		List<String> theGoodBreweryList = 
			Arrays.asList("Bells", "Great Lakes", "Founders", "Rogue", "Dogfish Head", "Stone", "Barleys");

		// Typical
		assertTrue(theGoodBreweryList.contains("Bells"));

		assertThat(theGoodBreweryList, hasItem("Bells"));
		// assert that the good brewery list has item "bells"

		assertThat(theGoodBreweryList, hasItems("Bells", "Dogfish Head"));
		// assert that the good brewery list has items "bells", "Dogfish Head"
	}

	@Test
	public void arrayTestingDoesntNeedToSuck() {
		String[] theGoodBreweryArray = { "Bells", "Great Lakes", "Founders",
				"Rogue", "Dogfish Head", "Stone", "Barleys" };

		// Typical ?
		assertTrue(Arrays.asList(theGoodBreweryArray).contains("Bells"));

		assertThat(theGoodBreweryArray, hasItemInArray("Bells"));
		// assert that the good brewery array has item in array "bells"
	}

	@Test
	public void mapsArentLeftOutEither() {
		Map<String, Integer> theBeersInToddsFridge = new HashMap<String, Integer>();
		theBeersInToddsFridge.put("Guinness", 8);
		theBeersInToddsFridge.put("Pabst", 12);

		// Typical
		assertTrue(theBeersInToddsFridge.containsKey("Guinness"));

//		assertThat(theBeersInToddsFridge, hasKey("Guinness"));
		// assert that the beers in todds fridge has key "guinness"

//		assertThat(theBeersInToddsFridge, hasValue(8));
		// assert that the beers in todds fridge has value 8

		assertThat(theBeersInToddsFridge, hasEntry("Guinness", 8));
		// assert that the beers in todds fridge has entry "guinness", 8
	}

	@SuppressWarnings("unchecked")
	@Test
	public void numberTestingIsAsYouWouldThink() {
		int theNumberOfBeersIveConsumed = 2;

		// Typical is actually pretty readable
		assertTrue(theNumberOfBeersIveConsumed >= 1);

		assertThat(theNumberOfBeersIveConsumed, is(greaterThanOrEqualTo(1)));
		// assert that the number of beers ive consumed is greater than or equal
		// to 1

		assertThat(theNumberOfBeersIveConsumed, is(lessThan(8)));
		// assert that the number of beers ive consumed is less than 8

		assertThat(theNumberOfBeersIveConsumed, is(allOf(greaterThan(0), lessThanOrEqualTo(3))));
		// meh
	}

	@Test
	public void customMatchersOpenTheDoors() {
		double theResult = Math.sqrt(-1);

		assertThat(theResult, is(notANumber()));
		// assert that the result is not a number
	}
}
