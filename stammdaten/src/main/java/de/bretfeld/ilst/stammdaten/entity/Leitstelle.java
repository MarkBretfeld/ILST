/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Die Leitstelle ist die Zentrale, welche Notrufe entgegennimmt und die
 * entsprechenden Einsatzmittel alarmiert. Sie wird in ILST auch als
 * Adressobjekt benutzt, z.B. für das Abholen der Schlüssel bei Hausnotrufen.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
@Entity
@Table(name = "LEITSTELLE")
public class Leitstelle extends Adressobjekt {

	private static final long serialVersionUID = 1L;

	/** Der Funkrufname der Leitstelle */
	@Column(name = "FUNKRUF_NAME")
	private String funkrufName;

	protected Leitstelle() {
	}

	public Leitstelle(String objektName, String funkrufName, Strasse strasse,
			String hausnummer, Stadtteil stadtteil) {
		super(objektName, strasse, hausnummer, stadtteil);

		this.funkrufName = funkrufName;
	}

	/** {@link #funkrufName} */
	public String getFunkrufName() {
		return funkrufName;
	}

	public void setFunkrufName(String funkrufName) {
		this.funkrufName = funkrufName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((funkrufName == null) ? 0 : funkrufName.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Leitstelle)) {
			return false;
		}
		Leitstelle other = (Leitstelle) obj;
		if (funkrufName == null) {
			if (other.funkrufName != null) {
				return false;
			}
		} else if (!funkrufName.equals(other.funkrufName)) {
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
		return "Leitstelle [funkrufName=" + funkrufName + "]";
	}

}
