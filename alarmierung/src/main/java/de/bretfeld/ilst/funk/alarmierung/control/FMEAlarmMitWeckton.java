package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Erzeugt einen normalen {@link AlarmAnalog} mit zusätzlichem Weckton.
 * 
 * @author Mark Bretfeld
 */
public class FMEAlarmMitWeckton extends AlarmAnalog {

	@Override
	public void alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream) {
		super.alarmierungstonErzeugen(alarmschleife, stream);
		createWeckton(210, 50, stream);
	}

	private void createWeckton(int milliseconds, int volume,
			ByteArrayOutputStream stream) {

		for (int j = 0; j < 11; j++) {
			erzeugeToene(milliseconds, volume, stream, 2600, 0);

			if (j < 10)
				generatePause(250, volume, stream);
		}

		// Zum Abschluss wieder die übliche Pause
		generatePause(600, 0, stream);
	}

}
