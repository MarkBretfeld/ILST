package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

/**
 * Generiert Töne mit verschiedenen Frequenzen.
 * 
 * @author Mark Bretfeld
 *
 */
public abstract class AbstractTonerzeuger {
	
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

}