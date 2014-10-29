package de.bretfeld.ilst.alarmierung.boundary;

import java.io.ByteArrayOutputStream;
import java.util.Queue;

import de.bretfeld.ilst.alarmierung.boundary.exception.AlarmierungException;
import de.bretfeld.ilst.alarmierung.control.AlarmAnalog;
import de.bretfeld.ilst.alarmierung.control.Alarmierung;
import de.bretfeld.ilst.alarmierung.control.FMEAlarmMitWeckton;
import de.bretfeld.ilst.alarmierung.control.SirenenalarmAnalog;
import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;
import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;

/**
 * Der {@link AlarmGenerator} bekommt eine Liste mit den zu alarmierenden
 * Einheiten und delegiert dann an die entsprechenden Alarmierungstypen.
 * 
 * ACHTUNG: Singleton
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public final class AlarmGenerator {

	private static final AlarmGenerator alarmGenerator = new AlarmGenerator();

	public static synchronized AlarmGenerator getInstance() {
		return alarmGenerator;
	}

	public void alarmieren(Queue<Einsatzeinheit> einsatzeinheiten) throws AlarmierungException {

		if (einsatzeinheiten == null || einsatzeinheiten.isEmpty()) {
			throw new IllegalArgumentException(
					"List von Einsatzeinheiten darf nicht leer oder null sein");
		}

		ByteArrayOutputStream alarmierungStream = new ByteArrayOutputStream();
		Alarmierung alarmierung = null;
		
		for (Einsatzeinheit einsatzeinheit : einsatzeinheiten) {

			for (Alarmschleife alarmschleife : einsatzeinheit
					.getAlarmschleifen()) {

				if (alarmschleife.isSirene()) {
					alarmierung = new SirenenalarmAnalog();
				} else if (alarmschleife.isWeckton()) {
					alarmierung = new FMEAlarmMitWeckton();
				} else {
				    alarmierung = new AlarmAnalog();
				}

				alarmierungStream = alarmierung.alarmierungstonErzeugen(alarmschleife, alarmierungStream);
			}

		}
		alarmierung.alarmieren(alarmierungStream);
	}

	
	
}
