/**
 * 
 */
package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import application.AbstractEntity;

/**
 * Das Stadtteil ist Teil einer Stadt
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
@Entity
public class Stadtteil extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/** Der Name des Stadtteils */
	@Column(name = "NAME")
	private String name;

	/** Die Postleitzahl des Stadtteils */
	@Column(name = "PLZ")
	private String plz;

	/** Die Stadt, in dem das Stadtteil liegt */
	@ManyToOne
	@JoinColumn(name = "STADT_ID", referencedColumnName = "ID")
	private Stadt stadt;

	protected Stadtteil() {
	}

	public Stadtteil(String name, String plz, Stadt stadt) {
		super();
		this.name = name;
		this.plz = plz;
		this.stadt = stadt;
	}

	/** {@link #name} */
	public String getName() {
		return name;
	}

	/** {@link #plz} */
	public String getPlz() {
		return plz;
	}

	/** {@link #stadt} */
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
