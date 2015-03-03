package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;

/**
 * Hier werden Alarmierung nach dem ZVEI-Standard ausgeführt. Die Klasse erhält
 * eine Liste an zu alarmierenden {@link Einsatzeinheit}en und zieht sich aus
 * diesen die jeweiligen Alarmschleifen. Diese Schleifen werden dann über eine
 * SourceDataLine ausgegeben.
 * 
 * @author Mark Bretfeld
 */
public abstract class AbstractAnalogAlarmierung implements Alarmierung {
	
	final Map<Character, Integer> frequencies = new HashMap<>();

	public AbstractAnalogAlarmierung() {
		super();
		fillFrequencies();
	}

	protected ByteArrayOutputStream createFuenftonFolge(
			List<Integer> soundValues, int milliseconds, int volume,
			ByteArrayOutputStream stream) {

		if (stream == null) {
			stream = new ByteArrayOutputStream();
		}

		for (int i = 0; i < 2; i++) {
			for (Integer herz : soundValues) {
				erzeugeToene(milliseconds, volume, stream, herz, 0);
			}
			generatePause(600, volume, stream);
		}

		return stream;
	}

	protected ByteArrayOutputStream erzeugeToene(double milliseconds,
			int volume, ByteArrayOutputStream stream, double herz, double herz1) {

		byte[] buf = new byte[2];

		for (int j = 0; j < milliseconds * FunkComponentConstants.FREQUENCY
				/ 1000; j++) {
			double angle = j / (FunkComponentConstants.FREQUENCY / herz) * 2.0
					* Math.PI;
			buf[0] = (byte) (Math.sin(angle) * volume);

			if (buf.length == 2) {
				double angle1 = j / (FunkComponentConstants.FREQUENCY / herz1)
						* 2.0 * Math.PI;
				buf[1] = (byte) (Math.sin(angle1) * volume);
			}
			stream.write(buf, 0, buf.length);
		}
		return stream;
	}

	protected ByteArrayOutputStream generatePause(int milliseconds, int volume,
			ByteArrayOutputStream stream) {
		return erzeugeToene(milliseconds, volume, stream, 0, 0);
	}

	/**
	 * Generiert aus der übergebene 5-Tonfolge die entsprechenden Frequenzen,
	 * die zur Erzeugung der Töne verwendet werden. Die Frequenzen entsprechen
	 * den ZVEI-Standard.
	 * 
	 * @param fiveTone
	 *            die 5-Tonfolge
	 * @return Eine Liste mit den generierten Frequenzen der 5-Tonfolge.
	 */
	protected List<Integer> ermittleAlarmToene(String fiveTone) {
		List<Integer> fuenfToene = new ArrayList<>();

		char cTemp = 0;

		// Zuweisung der Frequenzen zu den Ziffern
		for (char c : fiveTone.toCharArray()) {

			// wenn zwei gleiche Zahlen hintereinander kommen, muss eine andere
			// Frequenz wiedergegeben werden.
			if (c == cTemp) {
				c = 'R';
			}
			
			fuenfToene.add(frequencies.get(c));
			cTemp = c;
		}
		return fuenfToene;
	}
	

	private void fillFrequencies() {
		frequencies.put('1', 1060);
		frequencies.put('2', 1160);
		frequencies.put('3', 1270);
		frequencies.put('4', 1400);
		frequencies.put('5', 1530);
		frequencies.put('6', 1670);
		frequencies.put('7', 1830);
		frequencies.put('8', 2000);
		frequencies.put('9', 2200);
		frequencies.put('0', 2400);
		frequencies.put('R', 2600);
	}
	
}
