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

		Alarmierung alarmierung = null;

		switch (schleife.getAlarmTyp()) {
		case FME:
			alarmierung = new AlarmAnalog();
			break;
		case FUNK:
			break;
		case FEUERALARM:
			alarmierung = new FeueralarmAnalog();
			break;
		case PROBEALARM:
			alarmierung = new ProbealarmAnalog();
			break;
		case ZIVILSCHUTZALARM:
			alarmierung = new ZivilschutzalarmAnalog();
			break;
		case ZIVILSCHUTZENTWARNUNG:
			alarmierung = new ZivilschutzentwarnungAnalog();
			break;
		case ZIVILSCHUTZWARNUNG:
			alarmierung = new ZivilschutzwarnungAnalog();
			break;
		case WECKTON:
			alarmierung = new FMEAlarmMitWeckton();
			break;
		default:
			alarmierung = new AlarmAnalog();
			break;
		}

		return alarmierung;
	}

}
