package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Klasse zur Erzeugung eines Probealarms (Sirene) nach ZVEI-Standard.
 * 
 * @author Mark Bretfeld
 */
public final class ProbealarmAnalog extends AlarmAnalog {

	@Override
	public void alarmierungstonErzeugen(Alarmschleife alarmschleife,
			ByteArrayOutputStream stream) {
		super.alarmierungstonErzeugen(alarmschleife, stream);
		createProbealarm(50, stream);
		generatePause(600, 0, stream);
	}

	private void createProbealarm(int volume, ByteArrayOutputStream stream) {
		erzeugeToene(5000, volume, stream, 675, 1860);
	}

}
