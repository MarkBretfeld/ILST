/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

/**
 * @author Mark
 * 
 */
public class Stadtteil {

	private String name;
	private String plz;
	private Stadt stadt;

	public Stadtteil() {
	}

	public String getName() {
		return name;
	}

	public String getPlz() {
		return plz;
	}

	public Stadt getStadt() {
		return stadt;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == name ? 0 : name.hashCode());
		hash = 31 * hash + (null == plz ? 0 : plz.hashCode());
		hash = 31 * hash + (null == stadt ? 0 : stadt.hashCode());

		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		Stadtteil other = (Stadtteil) obj;
		return (name == other.name || (name != null && name.equals(other.name)))
				&& ((plz == other.plz || (plz != null && plz.equals(other.plz))) && ((stadt == other.stadt) || stadt != null
						&& stadt.equals(other.stadt)));
	}

}
