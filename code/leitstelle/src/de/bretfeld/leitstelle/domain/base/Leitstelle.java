/**
 * 
 */
package de.bretfeld.leitstelle.domain.base;

/**
 * This class represents the Leitstelle itself.
 * 
 * @author Mark
 * 
 */
public class Leitstelle extends Adressobjekt {

	private String funkrufName;

	public String getFunkrufName() {
		return funkrufName;
	}

	@Override
	public int hashCode() {

		int hash = 7;
		hash = 31 * hash + (null == funkrufName ? 0 : funkrufName.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		Leitstelle other = (Leitstelle) obj;
		return funkrufName == other.funkrufName
				|| (funkrufName != null && funkrufName
						.equals(other.funkrufName));

	}
}
