/**
 * 
 */
package de.bretfeld.ilst.alarmierung.control;

import java.io.ByteArrayOutputStream;
import java.util.List;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Diese Klasse kümmert sich um das Generieren von Alarmtönen ohne Zusätze.
 * 
 * @author Mark Bretfeld
 * 
 */
public class AlarmAnalog extends AbstractAnalogAlarmierung {

	@Override
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream) {

		String schleife = alarmschleife.getSchleife();
		List<Double> alarmToene = getAlarmToene(schleife);
		stream = createFuenftonFolge(alarmToene, 70, 50, stream);

		return stream;
	}

}
