/**
 * 
 */
package de.bretfeld.ilst.funk.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Die Schnittstelle für sämtliche Alarmierungen. Sie muss für jede Art von
 * Alarmierungstypen implementiert werden.
 * 
 * @author Mark Bretfeld
 */
public interface Alarmierung {

	/**
	 * Erzeugt die Toene für die jeweiligen Alarmschleifen, die alarmiert werden
	 * sollen.
	 * 
	 * @param Alarmschleife
	 *            der zu alarmierenden Einheit
	 */
	public void alarmierungstonErzeugen(Alarmschleife alarmschleife,
			ByteArrayOutputStream stream);

}
