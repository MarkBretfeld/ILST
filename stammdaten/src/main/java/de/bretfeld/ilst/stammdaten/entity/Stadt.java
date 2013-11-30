/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import application.AbstractEntity;

/**
 * Die Stadt in der verschiedene Objekte liegen.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 */
@Entity
public class Stadt extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/** Der Name der Stadt. */
	@Column(name = "NAME")
	private String name;

	protected Stadt() {

	}

	public Stadt(String name) {
		super();
		this.name = name;
	}

	/** {@link #name} */
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
