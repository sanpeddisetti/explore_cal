package com.liquidhub.calculator;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Years;

public class Utils {

	public static int calculateAge(Date dateOfBirth, Date depatureDate)
			throws IllegalArgumentException {
		DateTime dateTimeFordateOfBirth = new DateTime(dateOfBirth);
		DateTime dateTimeForDepatureDate = new DateTime(depatureDate);
		Years y = Years.yearsBetween(dateTimeFordateOfBirth,
				dateTimeForDepatureDate);
		if (y.getYears() < 0) {
			throw new IllegalArgumentException(
					"DOB should not be morethan depatureDate. Verify your input");
		}
		return y.getYears();

	}

	
}
