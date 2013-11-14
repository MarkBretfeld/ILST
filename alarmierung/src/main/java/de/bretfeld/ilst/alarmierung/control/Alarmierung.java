/**
 * 
 */
package de.bretfeld.ilst.alarmierung.control;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.alarmierung.boundary.exception.AlarmierungException;
import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Die Schnittstelle für sämtliche Alarmierungen. Sie muss für jede Art von
 * Alarmierungstypen implementiert werden.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public interface Alarmierung {

	/**
	 * Erzeugt die Toene für die jeweiligen Alarmschleifen, die alarmiert werden
	 * sollen.
	 * 
	 * @param Alarmschleife
	 *            der zu alarmierenden Einheit
	 * @return der Stream mit den erzeugten Toenen.
	 */
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream);

	/**
	 * Führt die Alarmierung der zusammengestellten Schleifen aus. Dazu wird der
	 * Stream mit den erzeugten Tönen abgespielt.
	 * 
	 * @param Die
	 *            zu alarmierenden Schleifen
	 * @throws AlarmierungException
	 *             wenn bei der Alarmierung etwas schief läuft.
	 */
	public void alarmieren(ByteArrayOutputStream stream)
			throws AlarmierungException;

}
