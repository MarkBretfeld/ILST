/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

/**
 * This class represents an object in the area of the Leitstelle
 * 
 * @author Mark
 * 
 */
public abstract class Adressobjekt {

	private String name;
	private Strasse strasse;
	private Stadt stadt;
	private Stadtteil stadtteil;

	public String getName() {
		return name;
	}

	public Strasse getStrasse() {
		return strasse;
	}

	public Stadt getStadt() {
		return stadt;
	}

	public String getPlz() {
		return stadtteil.getPlz();
	}

	public Stadtteil getStadtteil() {
		return stadtteil;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		Adressobjekt adressobjekt = (Adressobjekt) obj;
		boolean isEqual = name == adressobjekt.name
				|| (name != null && name.equals(adressobjekt.name));
		isEqual = isEqual
				&& (strasse == adressobjekt.strasse || (strasse != null && strasse
						.equals(adressobjekt.strasse)));
		isEqual = isEqual
				&& (stadt == adressobjekt.stadt || (stadt != null && stadt
						.equals(adressobjekt.stadt)));
		isEqual = isEqual
				&& (stadtteil == adressobjekt.stadtteil || (stadtteil != null && stadtteil
						.equals(adressobjekt.stadtteil)));
		return isEqual;

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == name ? 0 : name.hashCode());
		hash = 31 * hash + (null == strasse ? 0 : strasse.hashCode());
		hash = 31 * hash + (null == stadt ? 0 : stadt.hashCode());
		hash = 31 * hash + (null == stadtteil ? 0 : stadtteil.hashCode());
		return hash;
	}
}
