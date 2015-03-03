/**
 * 
 */
package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Die Schnittstelle f�r s�mtliche Alarmierungen. Sie muss f�r jede Art von
 * Alarmierungstypen implementiert werden.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public interface Alarmierung {
	
	int FREQUENCY = 44100;

	/**
	 * Erzeugt die Toene f�r die jeweiligen Alarmschleifen, die alarmiert werden
	 * sollen.
	 * 
	 * @param Alarmschleife
	 *            der zu alarmierenden Einheit
	 * @return der Stream mit den erzeugten Toenen.
	 */
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream);


}
