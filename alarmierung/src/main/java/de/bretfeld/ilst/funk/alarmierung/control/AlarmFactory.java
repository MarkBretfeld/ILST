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

		Alarmierung alarmierung = new AlarmAnalog();

		if (schleife.isSirene()) {
			alarmierung = new SirenenalarmAnalog();
		} else if (schleife.isWeckton()) {
			alarmierung = new FMEAlarmMitWeckton();
		}

		return alarmierung;
	}


}
