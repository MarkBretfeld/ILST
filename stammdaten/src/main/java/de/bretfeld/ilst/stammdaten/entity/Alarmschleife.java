package de.bretfeld.ilst.stammdaten.entity;

import de.bretfeld.ilst.stammdaten.control.AlarmTyp;

/**
 * Die Klasse beschreibt den Aufbau der Alarmschleife und mit welchen Zus�tzen
 * alarmiert werden soll.
 * 
 * @author Mark Bretfeld
 */
public class Alarmschleife {

	/** Alarmschleife */
	private String schleife;

	/** Beschreibt den Alarmierungstyp. */
	private AlarmTyp alarmTyp;

	public Alarmschleife(String schleife, AlarmTyp alarmTyp) {
		super();
		this.schleife = schleife;
		this.alarmTyp = alarmTyp;
	}

	/**
	 * {@link #schleife}
	 * 
	 * @return the schleife
	 */
	public String getSchleife() {
		return schleife;
	}

	/**
	 * {@link #alarmTyp}
	 * @return {@link AlarmTyp}.
	 */
	public AlarmTyp getAlarmTyp() {
		return alarmTyp;
	}

}
