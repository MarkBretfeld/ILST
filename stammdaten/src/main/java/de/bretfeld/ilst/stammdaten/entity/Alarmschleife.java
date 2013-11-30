package de.bretfeld.ilst.stammdaten.entity;

/**
 * Die Klasse beschreibt den Aufbau der Alarmschleife und mit welchen Zus�tzen
 * alarmiert werden soll.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public class Alarmschleife {

	/** Alarmschleife */
	private String schleife;

	/** Spezifischer Sirenenalarm f�r Feueralarm */
	private boolean isFeueralarm;

	/** Spezifischer Sirenenalarm f�r Probealarm */
	private boolean isProbealarm;

	/** Spezifischer Sirenenalarm f�r Zivilschutzalarm */
	private boolean isZivilschutzalarm;

	/** Spezifischer Sirenenalarm f�r Zivilschutzwarnung */
	private boolean isZivilschutzwarnung;

	/** Spezifischer Sirenenalarm f�r Zivilschutzentwarnung */
	private boolean isZivilschutzentwarnung;

	/** Weckton/Kanalbelegton bei FME-Alarmierung */
	private boolean isWeckton;

	public Alarmschleife(String schleife, boolean isFeueralarm,
			boolean isProbealarm, boolean isZivilschutzalarm,
			boolean isZivilschutzwarnung, boolean isZivilschutzentwarnung,
			boolean isWeckton) {
		super();
		this.schleife = schleife;
		this.isFeueralarm = isFeueralarm;
		this.isProbealarm = isProbealarm;
		this.isZivilschutzalarm = isZivilschutzalarm;
		this.isZivilschutzwarnung = isZivilschutzwarnung;
		this.isZivilschutzentwarnung = isZivilschutzentwarnung;
		this.isWeckton = isWeckton;
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
	 * {@link #isFeueralarm}
	 * 
	 * @return the isFeueralarm
	 */
	public boolean isFeueralarm() {
		return isFeueralarm;
	}

	/**
	 * {@link #isProbealarm}
	 * 
	 * @return the isProbealarm
	 */
	public boolean isProbealarm() {
		return isProbealarm;
	}

	/**
	 * {@link #isZivilschutzalarm}
	 * 
	 * @return the isZivilschutzalarm
	 */
	public boolean isZivilschutzalarm() {
		return isZivilschutzalarm;
	}

	/**
	 * {@link #isZivilschutzwarnung}
	 * 
	 * @return the isZivilschutzwarnung
	 */
	public boolean isZivilschutzwarnung() {
		return isZivilschutzwarnung;
	}

	/**
	 * {@link #isZivilschutzentwarnung}
	 * 
	 * @return the isZivilschutzentwarnung
	 */
	public boolean isZivilschutzentwarnung() {
		return isZivilschutzentwarnung;
	}

	/**
	 * {@link #isWeckton}
	 * 
	 * @return the isWeckton
	 */
	public boolean isWeckton() {
		return isWeckton;
	}

	/** Berechnet, ob es sich um einen Sirenenalarm handelt */
	public boolean isSirene() {
		return isFeueralarm || isProbealarm || isZivilschutzalarm
				|| isZivilschutzentwarnung || isZivilschutzwarnung;
	}

}
