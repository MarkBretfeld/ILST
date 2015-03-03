package de.bretfeld.ilst.funk.basic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import de.bretfeld.ilst.funk.alarmierung.control.FunkComponentConstants;
import de.bretfeld.ilst.funk.basic.exception.TonePlayerException;

/**
 * Gibt Töne für entsprechende {@link ByteArrayOutputStream} aus. Dazu wird eine
 * {@link SourceDataLine} verwendet, welche den {@link ByteArrayOutputStream}
 * entgegennimmt und herausschreibt.
 * 
 * @author Mark Bretfeld
 */
public final class TonePlayer {

	/**
	 * Read out of given stream and generate tones out of it.
	 * @param stream to generate
	 * @throws TonePlayerException
	 */
	public static void playTones(ByteArrayOutputStream stream)
			throws TonePlayerException {

		AudioFormat af = new AudioFormat(FunkComponentConstants.FREQUENCY, 8, 2, true,
				false);

		try (SourceDataLine sdl = AudioSystem.getSourceDataLine(af)) {

			sdl.open();
			sdl.start();

			sdl.write(stream.toByteArray(), 0, stream.toByteArray().length);

			stream.flush();

			sdl.drain();
			sdl.stop();

		} catch (IOException e) {
			throw new TonePlayerException(e);
		} catch (LineUnavailableException e1) {
			// throw new AlarmierungException(e1);
		}
	}

}
