/**
 * 
 */
package de.bretfeld.leitstelle.domain.base;

/**
 * @author Mark
 * 
 */
public class Einsatzmittel {

	private String name;
	private String funkrufName;
	private String aktuellerStandort;
	private int besatzung;
	private FMSStatus fmsStatus;

	public Einsatzmittel(String name, String funkrufName,
			String aktuellerStandort, int besatzung) {
		this.name = name;
		this.funkrufName = funkrufName;
		this.aktuellerStandort = aktuellerStandort;
		this.besatzung = besatzung;
	}

	public FMSStatus getFunkStatus() {
		if (fmsStatus == null) {
			fmsStatus = FMSStatus.STATUS_2;
		}
		return fmsStatus;
	}

	public void setFunkStatus(FMSStatus funkStatus) {
		this.fmsStatus = funkStatus;
	}

	public String getName() {
		return name;
	}

	public String getFunkrufName() {
		return funkrufName;
	}

	public String getAktuellerStandort() {
		return aktuellerStandort;
	}

	public int getBesatzung() {
		return besatzung;
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
				+ ((funkrufName == null) ? 0 : funkrufName.hashCode());
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
		if (funkrufName == null) {
			if (other.funkrufName != null) {
				return false;
			}
		} else if (!funkrufName.equals(other.funkrufName)) {
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

}
