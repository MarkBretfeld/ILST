package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.bretfeld.ilst.stammdaten.entity.Alarmgruppe;

/**
 * Hier werden Alarmierung nach dem ZVEI-Standard ausgef�hrt. Die Klasse erh�lt
 * eine Liste an zu alarmierenden {@link Alarmgruppe}en und zieht sich aus
 * diesen die jeweiligen Alarmschleifen. Diese Schleifen werden dann �ber eine
 * SourceDataLine ausgegeben.
 * 
 * @author Mark Bretfeld
 */
public abstract class AbstractAnalogAlarmierung extends AbstractTonerzeuger implements Alarmierung {
	
	final Map<Character, Integer> frequencies = new HashMap<>();

	public AbstractAnalogAlarmierung() {
		super();
		frequencies.clear();
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

	/**
	 * Generiert aus der �bergebene 5-Tonfolge die entsprechenden Frequenzen,
	 * die zur Erzeugung der T�ne verwendet werden. Die Frequenzen entsprechen
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
