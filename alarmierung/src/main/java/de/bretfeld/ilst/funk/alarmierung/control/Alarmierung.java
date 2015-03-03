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
 */
public interface Alarmierung {

	/**
	 * Erzeugt die Toene f�r die jeweiligen Alarmschleifen, die alarmiert werden
	 * sollen.
	 * 
	 * @param Alarmschleife
	 *            der zu alarmierenden Einheit
	 */
	public void alarmierungstonErzeugen(Alarmschleife alarmschleife,
			ByteArrayOutputStream stream);

}
