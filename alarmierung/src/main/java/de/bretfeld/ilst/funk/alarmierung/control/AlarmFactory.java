package de.bretfeld.ilst.funk.alarmierung.control;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Erzeugt verschiedene Alarmierungstypen basierend auf den Eingangsparametern.
 * 
 * @author Mark Bretfeld
 */
public class AlarmFactory {

	/**
	 * Erzeugt aus der gegebenen {@link Alarmschleife} den entsprechenden
	 * Alarmierungstypen.
	 * 
	 * @param schleife
	 *            die {@link Alarmschleife}
	 * @return {@link Alarmierung}.
	 */
	public static Alarmierung createAlarmierung(Alarmschleife schleife) {

		final Alarmierung alarmierung;

		if (schleife.isFeueralarm()) {
			alarmierung = new FeueralarmAnalog();
		} else if (schleife.isProbealarm()) {
			alarmierung = new ProbealarmAnalog();
		} else if (schleife.isZivilschutzalarm()) {
			alarmierung = new ZivilschutzalarmAnalog();
		} else if (schleife.isZivilschutzentwarnung()) {
			alarmierung = new ZivilschutzentwarnungAnalog();
		} else if (schleife.isZivilschutzwarnung()) {
			alarmierung = new ZivilschutzwarnungAnalog();
		} else if (schleife.isWeckton()) {
			alarmierung = new FMEAlarmMitWeckton();
		} else {
			alarmierung = new AlarmAnalog();
		}

		return alarmierung;
	}

}
