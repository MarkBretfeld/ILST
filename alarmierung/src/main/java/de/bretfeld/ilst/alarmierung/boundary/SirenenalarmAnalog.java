package de.bretfeld.ilst.alarmierung.boundary;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;
import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;
import de.bretfeld.ilst.stammdaten.entity.Einsatzmittel;

/**
 * Diese Klasse kümmert sich um die analoge Sirenenalarmierung.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public class SirenenalarmAnalog extends AbstractAnalogAlarmierung {

	private ByteArrayOutputStream stream;

	public SirenenalarmAnalog(ByteArrayOutputStream stream) {
		this.stream = stream;
	}

	@Override
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Einsatzeinheit einsatzeinheit) {

		for (Alarmschleife alarmschleife : einsatzeinheit.getAlarmschleifen()) {

			String schleife = alarmschleife.getSchleife();
			ArrayList<Double> alarmToene = getAlarmToene(schleife);
			stream = createFuenftonFolge(alarmToene, 70, 50, stream);
			stream = createProbealarm(50, stream);
			stream = generatePause(600, 0, stream);
		}

		return stream;
	}

	private ByteArrayOutputStream createFeueralarm(int volume,
			ByteArrayOutputStream stream) {
		return generateToneToStream(5000, volume, stream, 675.0, 1240.0);
	}

	private ByteArrayOutputStream createProbealarm(int volume,
			ByteArrayOutputStream stream) {
		return generateToneToStream(5000, volume, stream, 675.0, 1860.0);
	}

	private ByteArrayOutputStream createZivilschutzalarm(int volume,
			ByteArrayOutputStream stream) {
		return generateToneToStream(5000, volume, stream, 675.0, 825.0);
	}

	private ByteArrayOutputStream createZivilschutzwarnung(int volume,
			ByteArrayOutputStream stream) {
		return generateToneToStream(5000, volume, stream, 675.0, 2280.0);
	}

	private ByteArrayOutputStream createZivilschutzentwarnung(int volume,
			ByteArrayOutputStream stream) {
		return generateToneToStream(5000, volume, stream, 675.0, 1010.0);
	}

	public static void main(String[] args) {
		SirenenalarmAnalog analog = new SirenenalarmAnalog(null);

		List<Alarmschleife> schleifen = new ArrayList<>();
		schleifen.add(new Alarmschleife("58622"));
		schleifen.add(new Alarmschleife("58623"));

		ByteArrayOutputStream alarmieren = analog
				.alarmierungstonErzeugen(new Einsatzeinheit("Test",
						new ArrayList<Einsatzmittel>(), schleifen));
		analog.alarmieren(alarmieren);

	}

}
