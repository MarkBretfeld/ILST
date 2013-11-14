package de.bretfeld.ilst.alarmierung.boundary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;

/**
 * Hier werden Alarmierung nach dem ZVEI-Standard ausgef�hrt. Die Klasse erh�lt
 * eine Liste an zu alarmierenden {@link Einsatzeinheit}en und zieht sich aus
 * diesen die jeweiligen Alarmschleifen. Diese Schleifen werden dann �ber eine
 * SourceDataLine ausgegeben.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public abstract class AbstractAnalogAlarmierung implements Alarmierung {

	private static final int FREQUENCY = 44100;

	private ArrayList<Double> fiveToneList = new ArrayList<Double>();

	public AbstractAnalogAlarmierung() {
		super();
	}

	/**
	 * Generiert einen Ton.
	 * 
	 * @param herz
	 *            Basisfrequenz des Tones.
	 * @param milliseconds
	 *            Dauer der Abspiell�nge.
	 * @param volume
	 *            Ton von 0 (stumm) bis 100 (max.).
	 * @param buf
	 * @param stream2
	 * @param sirene
	 *            Whether to add an harmonic, one octave up.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	private ByteArrayOutputStream generateWeckton(int milliseconds, int volume,
			ByteArrayOutputStream stream) {

		for (int j = 0; j < 11; j++) {
			stream = generateToneToStream(milliseconds, volume, stream, 2600.0,
					0.0);

			// Pause wird beim letzten Mal weggelassen
			if (j < 10)
				stream = generatePause(250, volume, stream);
		}

		return stream;

	}

	@Override
	public void alarmieren(ByteArrayOutputStream stream) {

		AudioFormat af = new AudioFormat(FREQUENCY, 8, 2, true, false);

		try (SourceDataLine sdl = AudioSystem.getSourceDataLine(af)) {

			sdl.open();
			sdl.start();

			// if (weckton) {
			// generateWeckton(210, 50, buf, stream);
			// generatePause(600, volume, buf, stream);
			// }
			//
			// if (sirene) {
			// createSirenenton(volume, buf, stream);
			// generatePause(600, volume, buf, stream);
			// }

			sdl.write(stream.toByteArray(), 0, stream.toByteArray().length);

			stream.flush();

			sdl.drain();
			sdl.stop();

		} catch (IOException e) {
			// throw new AlarmierungException(e);
		} catch (LineUnavailableException e1) {
			// throw new AlarmierungException(e1);
		}
	}

	protected ByteArrayOutputStream createFuenftonFolge(
			ArrayList<Double> soundValues, int milliseconds, int volume,
			ByteArrayOutputStream stream) {

		if (stream == null) {
			stream = new ByteArrayOutputStream();
		}

		for (int i = 0; i < 2; i++) {
			for (Double herz : soundValues) {
				generateToneToStream(milliseconds, volume, stream, herz, 0.0);
			}
			generatePause(600, volume, stream);
		}

		return stream;
	}

	protected ByteArrayOutputStream generateToneToStream(int milliseconds,
			int volume, ByteArrayOutputStream stream, Double herz, double herz1) {

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
		stream = generateToneToStream(milliseconds, volume, stream, 0.0, 0.0);
		return stream;
	}

	/**
	 * Liest eine 5-Tonfolge ein und �bersetzt die Ziffern in Frequenzen nach
	 * dem ZVEI-Standard.
	 * 
	 * @param tone
	 *            - die 5-Tonfolge
	 * @return fiveToneList
	 */
	protected ArrayList<Double> getAlarmToene(String fiveTone) {
		fiveToneList.clear();

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
			fiveToneList.add(freq);
			cTemp = c;
		}
		return fiveToneList;
	}

	/*********************************************************************************************
	 * End of class Analogalarmierung.class
	 * 
	 * @throws AlarmierungException
	 *             *
	 *********************************************************************************************/

}
