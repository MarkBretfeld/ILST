package de.bretfeld.ilst.stammdaten.control;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.time.DateUtils;

/**
 * Represents the days of the week. Representation is like '0101000', beginning
 * with Sunday.
 * 
 * @author Mark Bretfeld
 *
 */
public class Wochentag {

	DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

	private String wochentagSchluessel;

	/**
	 * Ctor.
	 * 
	 * @param wochentagSchluessel
	 *            the keys of the weekdays.
	 */
	public Wochentag(String wochentagSchluessel) {
		isValid(wochentagSchluessel);
		this.wochentagSchluessel = wochentagSchluessel;
	}

	private void isValid(String wochentagSchluessel) {
		if (wochentagSchluessel == null) {
			throw new IllegalArgumentException(
					"wochentagSchluessel must not be null");
		}

		if (wochentagSchluessel.length() != 7) {
			throw new IllegalArgumentException(
					"wochentagSchluessel must have a length of 7");
		}

		try {
			Integer.parseInt(wochentagSchluessel);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(
					"The given text must only contain numbers");
		}

		if (!wochentagSchluessel.matches("[01]+")) {
			throw new IllegalArgumentException(
					"The given text must only contain 0 and 1");
		}
	}

	/**
	 * @return the Wochentag key.
	 */
	public String getWochentagSchluessel() {
		return wochentagSchluessel;
	}

	/**
	 * Checks if the given {@link Date} is valid today.
	 * 
	 * @param pDate
	 *            the date to check, if it is today.
	 */
	public boolean isValidToday() {
		int dayOfWeek = Calendar.getInstance(Locale.GERMAN).get(
				Calendar.DAY_OF_WEEK);
		return this.wochentagSchluessel.charAt(dayOfWeek) == '1';
	}
	
	public boolean isValidOnDay(Date dateToCheck) {
		Calendar calendar = Calendar.getInstance(Locale.GERMAN);
		calendar.setTime(dateToCheck);
		int dayOfWeekFromDate = calendar.get(Calendar.DAY_OF_WEEK);
		
		return this.wochentagSchluessel.charAt(dayOfWeekFromDate) == '1';
	}

}
