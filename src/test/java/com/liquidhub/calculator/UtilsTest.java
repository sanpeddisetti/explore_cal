package com.liquidhub.calculator;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class UtilsTest {

	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	@Test
	public void testCalculateAgeValid() throws ParseException {
		Date dateOfBirth = format.parse("01/14/2001");
		Date depatureDate = format.parse("06/15/2015");
		int expectedAge = 14;
		int actualAge = Utils.calculateAge(dateOfBirth, depatureDate);
		assertEquals(expectedAge, actualAge);

	}

	@Test
	public void testTalculateAgeIncludeDepatureDate() throws ParseException {
		Date dateOfBirth = format.parse("06/14/2014");
		Date depatureDate = format.parse("06/14/2015");
		int expectedAge = 1;
		int actualAge = Utils.calculateAge(dateOfBirth, depatureDate);
		assertEquals(expectedAge, actualAge);

	}

	@Test
	public void testTalculateAgeLessThanDepatureDate() throws ParseException {
		Date dateOfBirth = format.parse("06/15/2014");
		Date depatureDate = format.parse("06/14/2015");
		int expectedAge = 0;
		int actualAge = Utils.calculateAge(dateOfBirth, depatureDate);
		assertEquals(expectedAge, actualAge);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateAgeInvalid() throws ParseException {
		Date dateOfBirth = format.parse("06/14/2016");
		Date depatureDate = format.parse("06/13/2015");

		Utils.calculateAge(dateOfBirth, depatureDate);

	}
}
