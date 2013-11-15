/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import application.AbstractEntity;
import de.bretfeld.ilst.stammdaten.control.FMSStatus;

/**
 * Ein Einsatzmittel behandelt ein Fahrzeug einer jeweiligen
 * {@link Einsatzeinheit}.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
@Entity
public class Einsatzmittel extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/** Der Name des {@link Einsatzmittel}s. */
	@Column(name = "NAME")
	private String name;

	/** Der Funkrufname des {@link Einsatzmittel}s. */
	@Column(name = "FUNKRUF_NAME")
	private String funkrufName;

	/**
	 * Der aktuelle Standort des jeweiligen {@link Einsatzmittel}s. Dieser wird
	 * über GPS mitgeteilt.
	 */
	@Column(name = "AKTUELLER_STANDORT")
	private String aktuellerStandort;

	/** Noch nicht sicher, ob dieses Attribut benötigt wird. */
	private int besatzung;

	/**
	 * Der aktuelle {@link FMSStatus} dieses {@link Einsatzmittel}s. Das setzen
	 * erfolgt über die Funkkomponente oder durch das manuelle Setzen des
	 * Disponenten.
	 */
	@Column(name = "FMS_STATUS")
	private FMSStatus fmsStatus = FMSStatus.STATUS_2;

	/** Legt fest, ob das {@link Einsatzmittel} zur Feuerwehr gehört. */
	@Column(name = "IS_FEUERWEHR_THW")
	private boolean isFeuerwehrThw;

	/** Legt fest, ob das {@link Einsatzmittel} zum Rettungsdienst gehört. */
	@Column(name = "IS_RETTUNGSDIENST")
	private boolean isRettungsdienst;

	/** Legt fest, ob das {@link Einsatzmittel} zur Polizei gehört. */
	@Column(name = "IS_POLIZEI")
	private boolean isPolizei;

	protected Einsatzmittel() {

	}

	public Einsatzmittel(String name, String funkrufName,
			String aktuellerStandort, int besatzung, boolean isFeuerwehrThw,
			boolean isRettungsdienst, boolean isPolizei) {
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
	 * Gibt die Beschreibung für den {@link FMSStatus} dieses
	 * {@link Einsatzmittel}s zurück.
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((aktuellerStandort == null) ? 0 : aktuellerStandort
						.hashCode());
		result = prime * result + besatzung;
		result = prime * result
				+ ((fmsStatus == null) ? 0 : fmsStatus.hashCode());
		result = prime * result
				+ ((funkrufName == null) ? 0 : funkrufName.hashCode());
		result = prime * result + (isFeuerwehrThw ? 1231 : 1237);
		result = prime * result + (isPolizei ? 1231 : 1237);
		result = prime * result + (isRettungsdienst ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Einsatzmittel)) {
			return false;
		}
		Einsatzmittel other = (Einsatzmittel) obj;
		if (aktuellerStandort == null) {
			if (other.aktuellerStandort != null) {
				return false;
			}
		} else if (!aktuellerStandort.equals(other.aktuellerStandort)) {
			return false;
		}
		if (besatzung != other.besatzung) {
			return false;
		}
		if (fmsStatus != other.fmsStatus) {
			return false;
		}
		if (funkrufName == null) {
			if (other.funkrufName != null) {
				return false;
			}
		} else if (!funkrufName.equals(other.funkrufName)) {
			return false;
		}
		if (isFeuerwehrThw != other.isFeuerwehrThw) {
			return false;
		}
		if (isPolizei != other.isPolizei) {
			return false;
		}
		if (isRettungsdienst != other.isRettungsdienst) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Einsatzmittel [name=" + name + ", funkrufName=" + funkrufName
				+ ", aktuellerStandort=" + aktuellerStandort + ", besatzung="
				+ besatzung + ", fmsStatus=" + fmsStatus + ", isFeuerwehrThw="
				+ isFeuerwehrThw + ", isRettungsdienst=" + isRettungsdienst
				+ ", isPolizei=" + isPolizei + "]";
	}

}
