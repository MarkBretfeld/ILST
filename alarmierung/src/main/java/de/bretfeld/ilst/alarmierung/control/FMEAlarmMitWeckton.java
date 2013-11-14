package de.bretfeld.ilst.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

public class FMEAlarmMitWeckton extends AlarmAnalog {

	@Override
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream) {
		stream = super.alarmierungstonErzeugen(alarmschleife, stream);
		return createWeckton(210, 50, stream);
	}

	private ByteArrayOutputStream createWeckton(int milliseconds, int volume,
			ByteArrayOutputStream stream) {

		for (int j = 0; j < 11; j++) {
			stream = erzeugeToene(milliseconds, volume, stream, 2600.0, 0.0);

			if (j < 10)
				stream = generatePause(250, volume, stream);
		}

		// Zum Abschluss wieder die übliche Pause
		stream = generatePause(600, 0, stream);

		return stream;

	}

}
