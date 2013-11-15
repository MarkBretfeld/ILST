/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import application.AbstractEntity;

/**
 * This class represents an object in the area of the Leitstelle
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
@MappedSuperclass
public abstract class Adressobjekt extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "OBJEKT_NAME", unique = true)
	private String objektName;

	@ManyToOne
	@JoinColumn(name = "STRASSE_ID", referencedColumnName = "ID")
	private Strasse strasse;

	@Column(name = "HAUSNUMMER")
	private String hausnummer;

	@ManyToOne
	@JoinColumn(name = "STADTTEIL_ID", referencedColumnName = "ID")
	private Stadtteil stadtteil;

	/** Wenn >true<, dann hat das Objekt eine BMA */
	@Column(name = "HAS_BMA")
	private boolean hasBma;

	protected Adressobjekt() {

	}

	public Adressobjekt(String objektName, Strasse strasse, String hausnummer,
			Stadtteil stadtteil) {
		super();
		this.objektName = objektName;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.stadtteil = stadtteil;
	}

	public String getName() {
		return objektName;
	}

	public Strasse getStrasse() {
		return strasse;
	}

	public Stadt getStadt() {
		return stadtteil.getStadt();
	}

	public String getPlz() {
		return stadtteil.getPlz();
	}

	public Stadtteil getStadtteil() {
		return stadtteil;
	}

	public String getHausnummer() {
		return hausnummer;
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
		result = prime * result
				+ ((hausnummer == null) ? 0 : hausnummer.hashCode());
		result = prime * result
				+ ((objektName == null) ? 0 : objektName.hashCode());
		result = prime * result
				+ ((stadtteil == null) ? 0 : stadtteil.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		if (!(obj instanceof Adressobjekt)) {
			return false;
		}
		Adressobjekt other = (Adressobjekt) obj;
		if (hausnummer == null) {
			if (other.hausnummer != null) {
				return false;
			}
		} else if (!hausnummer.equals(other.hausnummer)) {
			return false;
		}
		if (objektName == null) {
			if (other.objektName != null) {
				return false;
			}
		} else if (!objektName.equals(other.objektName)) {
			return false;
		}
		if (stadtteil == null) {
			if (other.stadtteil != null) {
				return false;
			}
		} else if (!stadtteil.equals(other.stadtteil)) {
			return false;
		}
		if (strasse == null) {
			if (other.strasse != null) {
				return false;
			}
		} else if (!strasse.equals(other.strasse)) {
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
		return "Adressobjekt [objektName=" + objektName + ", strasse="
				+ strasse + ", hausnummer=" + hausnummer + ", stadtteil="
				+ stadtteil + "]";
	}

}
