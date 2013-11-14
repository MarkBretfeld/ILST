/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

/**
 * @author Mark
 * 
 */
public class Stadt {

	private String name;

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + ((null == name) ? 0 : name.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		Stadt other = (Stadt) obj;
		return (name == other.name || (name != null && name.equals(other.name)));
	}

}
