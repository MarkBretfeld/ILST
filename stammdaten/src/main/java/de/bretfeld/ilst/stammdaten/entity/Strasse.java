package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import application.AbstractEntity;

/**
 * Die Strasse muss eigentlich nicht weiter erklärt werden.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
@Entity
public class Strasse extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/** Der Name der Strasse */
	@Column(name = "NAME")
	private String name;

	/** Der Stadtteil, in dem die Strasse liegt */
	@ManyToOne
	@JoinColumn(name = "STADTTEIL_ID", referencedColumnName = "ID")
	private Stadtteil stadtteil;

	protected Strasse() {
	}

	public Strasse(String name, Stadtteil stadtteil) {
		super();
		this.name = name;
		this.stadtteil = stadtteil;
	}

	/** {@link #name} */
	public String getName() {
		return name;
	}

	/** {@link #stadtteil} */
	public Stadtteil getStadtteil() {
		return stadtteil;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == name ? 0 : name.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		Strasse strasse = (Strasse) obj;
		return name == strasse.name || name != null
				&& name.equals(strasse.name);
	}

}
