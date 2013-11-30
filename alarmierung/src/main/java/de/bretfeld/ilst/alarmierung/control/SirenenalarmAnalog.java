package de.bretfeld.ilst.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Diese Klasse kümmert sich um die analoge Sirenenalarmierung.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public class SirenenalarmAnalog extends AlarmAnalog {

	@Override
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream) {

		stream = super.alarmierungstonErzeugen(alarmschleife, stream);
		if (alarmschleife.isFeueralarm())
			stream = createFeueralarm(50, stream);
		else if (alarmschleife.isProbealarm())
			stream = createProbealarm(50, stream);
		else if (alarmschleife.isZivilschutzalarm())
			stream = createZivilschutzalarm(50, stream);
		else if (alarmschleife.isZivilschutzentwarnung())
			stream = createZivilschutzentwarnung(50, stream);
		else if (alarmschleife.isZivilschutzwarnung())
			stream = createZivilschutzwarnung(50, stream);
		stream = generatePause(600, 0, stream);

		return stream;
	}

	private ByteArrayOutputStream createFeueralarm(int volume,
			ByteArrayOutputStream stream) {
		return erzeugeToene(5000, volume, stream, 675.0, 1240.0);
	}

	private ByteArrayOutputStream createProbealarm(int volume,
			ByteArrayOutputStream stream) {
		return erzeugeToene(5000, volume, stream, 675.0, 1860.0);
	}

	private ByteArrayOutputStream createZivilschutzalarm(int volume,
			ByteArrayOutputStream stream) {
		return erzeugeToene(5000, volume, stream, 675.0, 825.0);
	}

	private ByteArrayOutputStream createZivilschutzwarnung(int volume,
			ByteArrayOutputStream stream) {
		return erzeugeToene(5000, volume, stream, 675.0, 2280.0);
	}

	private ByteArrayOutputStream createZivilschutzentwarnung(int volume,
			ByteArrayOutputStream stream) {
		return erzeugeToene(5000, volume, stream, 675.0, 1010.0);
	}

}
