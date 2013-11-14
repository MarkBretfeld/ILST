/**
 * 
 */
package de.bretfeld.ilst.alarmierung.boundary;

import java.io.ByteArrayOutputStream;

import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;

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
	 * Erzeugt die Toene für die jeweiligen Einsatzeinheiten, die alarmiert werden sollen.
	 * @param einsatzeinheit die zu alarmierende Einsatzeinheit.
	 * @return der Stream mit den erzeugten Toenen.
	 */
	public ByteArrayOutputStream alarmierungstonErzeugen(Einsatzeinheit einsatzeinheit);
	
	/**
	 * Führt die Alarmierung der zusammengestellten Schleifen aus.
	 * Dazu wird der Stream mit den erzeugten Tönen abgespielt.
	 * 
	 * @param Die zu alarmierenden Schleifen
	 */
	public void alarmieren(ByteArrayOutputStream stream);

}
