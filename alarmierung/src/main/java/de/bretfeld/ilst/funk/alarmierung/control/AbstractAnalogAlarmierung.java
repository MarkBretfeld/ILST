package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;

/**
 * Hier werden Alarmierung nach dem ZVEI-Standard ausgeführt. Die Klasse erhält
 * eine Liste an zu alarmierenden {@link Einsatzeinheit}en und zieht sich aus
 * diesen die jeweiligen Alarmschleifen. Diese Schleifen werden dann über eine
 * SourceDataLine ausgegeben.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public abstract class AbstractAnalogAlarmierung implements Alarmierung {

	private static final int FREQUENCY = 44100;
	
	public AbstractAnalogAlarmierung() {
		super();
	}

	protected ByteArrayOutputStream createFuenftonFolge(
			List<Double> soundValues, int milliseconds, int volume,
			ByteArrayOutputStream stream) {

		if (stream == null) {
			stream = new ByteArrayOutputStream();
		}

		for (int i = 0; i < 2; i++) {
			for (Double herz : soundValues) {
				stream = erzeugeToene(milliseconds, volume, stream, herz, 0.0);
			}
			stream = generatePause(600, volume, stream);
		}

		return stream;
	}

	protected ByteArrayOutputStream erzeugeToene(double milliseconds,
			int volume, ByteArrayOutputStream stream, Double herz, Double herz1) {

		byte[] buf = new byte[2];

		for (int j = 0; j < milliseconds * FREQUENCY / 1000; j++) {
			double angle = j / (FREQUENCY / herz) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * volume);

			if (buf.length == 2) {
				double angle1 = j / (FREQUENCY / herz1) * 2.0 * Math.PI;
				buf[1] = (byte) (Math.sin(angle1) * volume);
			}
			stream.write(buf, 0, buf.length);
		}
		return stream;
	}

	protected ByteArrayOutputStream generatePause(int milliseconds, int volume,
			ByteArrayOutputStream stream) {
		stream = erzeugeToene(milliseconds, volume, stream, 0.0, 0.0);
		return stream;
	}

	/**
	 * Generiert aus der übergebene 5-Tonfolge die entsprechenden
	 * Frequenzen, die zur Erzeugung der Töne verwendet werden. Die Frequenzen
	 * entsprechen den ZVEI-Standard.
	 * 
	 * @param fiveTone die 5-Tonfolge
	 * @return Eine Liste mit den generierten Frequenzen der 5-Tonfolge.
	 */
	protected List<Double> getAlarmToene(String fiveTone) {
		List<Double> fuenfToene = new ArrayList<>();

		double freq = 0;
		char cTemp = 0;

		// Zuweisung der Frequenzen zu den Ziffern
		for (char c : fiveTone.toCharArray()) {

			// wenn zwei gleiche Zahlen hintereinander kommen, muss eine andere
			// Frequenz wiedergegeben werden.
			if (c == cTemp) {
				c = 'd';
			}

			switch (c) {
			case '1':
				freq = 1060;
				break;

			case '2':
				freq = 1160;
				break;

			case '3':
				freq = 1270;
				break;

			case '4':
				freq = 1400;
				break;

			case '5':
				freq = 1530;
				break;

			case '6':
				freq = 1670;
				break;

			case '7':
				freq = 1830;
				break;

			case '8':
				freq = 2000;
				break;

			case '9':
				freq = 2200;
				break;

			case '0':
				freq = 2400;
				break;

			case 'd':
				freq = 2600;
				break;
			}
			fuenfToene.add(freq);
			cTemp = c;
		}
		return fuenfToene;
	}

	/*********************************************************************************************
	 * End of class Analogalarmierung.class
	 * 
	 * @throws AlarmierungException
	 *             *
	 *********************************************************************************************/

}
