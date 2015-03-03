package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Klasse zur Erzeugung einer Zivilschutzwarnung (Sirene) nach ZVEI-Standard.
 * 
 * @author Mark Bretfeld
 */
public final class ZivilschutzwarnungAnalog extends AlarmAnalog {

	@Override
	public void alarmierungstonErzeugen(Alarmschleife alarmschleife,
			ByteArrayOutputStream stream) {
		super.alarmierungstonErzeugen(alarmschleife, stream);
		createZivilschutzalarm(50, stream);
		generatePause(600, 0, stream);
	}

	private void createZivilschutzalarm(int volume, ByteArrayOutputStream stream) {
		erzeugeToene(5000, volume, stream, 675, 825);
	}

}
