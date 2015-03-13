/**
 * 
 */
package de.bretfeld.ilst.funk.alarmierung.control;

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
    public void alarmierungstonErzeugen(
            Alarmschleife alarmschleife, ByteArrayOutputStream stream) {

        generatePause(600, 0, stream);
        String schleife = alarmschleife.getSchleife();
        List<Integer> alarmToene = ermittleAlarmToene(schleife);
        createFuenftonFolge(alarmToene, 70, 50, stream);
    }

}
