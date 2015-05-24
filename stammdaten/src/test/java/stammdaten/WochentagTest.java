package stammdaten;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import de.bretfeld.ilst.stammdaten.control.Wochentag;

public class WochentagTest {

	@Test
	public void testCreateWochentagSchluesselValid() {
		String wochentagSchluesselSunday = "1001000";
		Wochentag sonntag = new Wochentag(wochentagSchluesselSunday);
		assertEquals(wochentagSchluesselSunday, sonntag.getWochentagSchluessel());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidWochentagschluessel_Null() {
		new Wochentag(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidWochentagschluessel_WrongLength() {
		new Wochentag("1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidWochentagschluessel_NoDigit() {
		new Wochentag("AAAAAAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidWochentagschluessel_WrongDigit() {
		new Wochentag("0101013");
	}
	
	@Test
	public void testIsValidToday() {
		int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

		StringBuilder lBuilder = new StringBuilder();
		
		for (int i = 0; i < 7; i++) 
		{
			if (dayOfWeek == i) {
				lBuilder.append("1");
			} else {
				lBuilder.append("0");
			}
		}
		
		Wochentag sonntag = new Wochentag(lBuilder.toString());
		assertTrue(sonntag.isValidToday());
	}
	
	@Test
	public void testIsValidTomorrow() {
		Wochentag montag = new Wochentag("0010000");
		assertTrue(montag.isValidOnDay(DateUtils.addDays(new Date(), 1)));
	}
	
	@Test
	public void testIsValidTomorrow_Negative() {
		Wochentag dienstag = new Wochentag("0001000");
		assertFalse(dienstag.isValidOnDay(DateUtils.addDays(new Date(), 1)));
	}
	
}
