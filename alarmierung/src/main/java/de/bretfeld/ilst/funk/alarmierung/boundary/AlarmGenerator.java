package de.bretfeld.ilst.funk.alarmierung.boundary;

import java.io.ByteArrayOutputStream;
import java.util.Queue;

import de.bretfeld.ilst.funk.alarmierung.control.AlarmFactory;
import de.bretfeld.ilst.funk.alarmierung.control.Alarmierung;
import de.bretfeld.ilst.funk.basic.control.TonePlayer;
import de.bretfeld.ilst.funk.basic.exception.TonePlayerException;
import de.bretfeld.ilst.funk.fms.boundary.FMSTonCreator;
import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;
import de.bretfeld.ilst.stammdaten.entity.Alarmgruppe;

/**
 * Der {@link AlarmGenerator} bekommt eine Liste mit den zu alarmierenden
 * Einheiten und delegiert dann an die entsprechenden Alarmierungstypen.
 *
 * ATTENTION: Singleton
 *
 * @author Mark Bretfeld
 *
 */
public class AlarmGenerator {

    private static AlarmGenerator alarmGenerator;

    public static AlarmGenerator getInstance() {
        if (alarmGenerator == null) {
            alarmGenerator = new AlarmGenerator();
        }
        return alarmGenerator;
    }

    private AlarmGenerator() {
        // defeat direct instantiation
    }

    public void alarm(Queue<Alarmgruppe> einsatzeinheiten) throws TonePlayerException {

        if (einsatzeinheiten == null || einsatzeinheiten.isEmpty()) {
            throw new IllegalArgumentException(
                    "List von Einsatzeinheiten darf nicht leer oder null sein");
        }

        for (Alarmgruppe einsatzeinheit : einsatzeinheiten) {

            FMSTonCreator fmsTon = FMSTonCreator.getInstance();
            for (Alarmschleife alarmschleife : einsatzeinheit
                    .getAlarmschleifen()) {

                fmsTon.createFMSTonLeitstelle("796782823");
                fmsTon.createFMSTonFahrzeug("7967828215");
            }

            for (Alarmschleife alarmschleife : einsatzeinheit
                    .getAlarmschleifen()) {

                ByteArrayOutputStream alarmierungStream = new ByteArrayOutputStream();

                Alarmierung alarmierung = AlarmFactory.createAlarmierung(alarmschleife);

                alarmierung.alarmierungstonErzeugen(alarmschleife, alarmierungStream);
                TonePlayer.playTones(alarmierungStream);
            }

        }
    }

}
