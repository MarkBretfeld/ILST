/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

import de.bretfeld.ilst.stammdaten.control.FMSStatus;

/**
 * Ein Einsatzmittel behandelt ein Fahrzeug einer jeweiligen {@link Einsatzeinheit}.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public class Einsatzmittel {

	/** Der Name des {@link Einsatzmittel}s. */
	private String name;
	
	/** Der Funkrufname des {@link Einsatzmittel}s. */
	private String funkrufName;
	
	/** Der aktuelle Standort des jeweiligen {@link Einsatzmittel}s. Dieser wird über GPS mitgeteilt. */
	private String aktuellerStandort;
	
	/** Noch nicht sicher, ob dieses Attribut benötigt wird. */
	private int besatzung;
	
	/** Der aktuelle {@link FMSStatus} dieses {@link Einsatzmittel}s. Das setzen erfolgt über die Funkkomponente
	 * oder durch das manuelle Setzen des Disponenten.
	 */
	private FMSStatus fmsStatus = FMSStatus.STATUS_2;
	
	/** Legt fest, ob das {@link Einsatzmittel} zur Feuerwehr gehört. */
	private boolean isFeuerwehrThw;
	
	/** Legt fest, ob das {@link Einsatzmittel} zum Rettungsdienst gehört. */
	private boolean isRettungsdienst;
	
	/** Legt fest, ob das {@link Einsatzmittel} zur Polizei gehört. */
	private boolean isPolizei;

	public Einsatzmittel(String name, String funkrufName,
			String aktuellerStandort, int besatzung, boolean isFeuerwehrThw, boolean isRettungsdienst, boolean isPolizei) {
		this.name = name;
		this.funkrufName = funkrufName;
		this.aktuellerStandort = aktuellerStandort;
		this.besatzung = besatzung;
		this.isFeuerwehrThw = isFeuerwehrThw;
		this.isRettungsdienst = isRettungsdienst;
		this.isPolizei = isPolizei;
	}

	/** {@link #fmsStatus} */
	public FMSStatus getFunkStatus() {
		return fmsStatus;
	}

	/** {@link #fmsStatus} */
	public void setFunkStatus(FMSStatus funkStatus) {
		this.fmsStatus = funkStatus;
	}

	/** {@link #name} */
	public String getName() {
		return name;
	}

	/** {@link #funkrufName} */
	public String getFunkrufName() {
		return funkrufName;
	}

	/** {@link #aktuellerStandort} */
	public String getAktuellerStandort() {
		return aktuellerStandort;
	}

	/** {@link #besatzung} */
	public int getBesatzung() {
		return besatzung;
	}
	
	/** {@link #fmsStatus} */
	public FMSStatus getFmsStatus() {
		return fmsStatus;
	}
	
	/**
	 * Gibt die Beschreibung für den {@link FMSStatus} dieses {@link Einsatzmittel}s zurück.
	 * @return die Beschreibung des {@link FMSStatus}
	 */
	public String getFmsStatusBeschreibung() {
		return fmsStatus.getBeschreibungByEinsatzmittel(this);
	}
	
	/** {@link #isFeuerwehrThw} */
	public boolean isFeuerwehrThw() {
		return isFeuerwehrThw;
	}
	
	/** {@link #isRettungsdienst} */
	public boolean isRettungsdienst() {
		return isRettungsdienst;
	}
	
	/** {@link #isPolizei} */
	public boolean isPolizei() {
		return isPolizei;
	}

}
