package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Klasse zur Erzeugung eines Feueralarms (Sirene) nach ZVEI-Standard.
 * 
 * @author Mark Bretfeld
 */
public final class FeueralarmAnalog extends AlarmAnalog {

	@Override
	public void alarmierungstonErzeugen(Alarmschleife alarmschleife,
			ByteArrayOutputStream stream) {
		super.alarmierungstonErzeugen(alarmschleife, stream);
		createFeueralarm(50, stream);
		generatePause(600, 0, stream);
	}

	private void createFeueralarm(int volume, ByteArrayOutputStream stream) {
		erzeugeToene(5000, volume, stream, 675, 1240);
	}

}
