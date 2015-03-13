package de.bretfeld.ilst.stammdaten.entity;

import javax.persistence.Entity;

import application.AbstractEntity;

@Entity
public class Einsatzeinheit extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private Alarmschleife alarmschleife;

	public Einsatzeinheit(String name, Alarmschleife alarmschleife) {
		super();
		this.name = name;
		this.alarmschleife = alarmschleife;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alarmschleife == null) ? 0 : alarmschleife.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Einsatzeinheit other = (Einsatzeinheit) obj;
		if (alarmschleife == null) {
			if (other.alarmschleife != null)
				return false;
		} else if (!alarmschleife.equals(other.alarmschleife))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Einsatzeinheit [name=" + name + ", alarmschleife="
				+ alarmschleife + "]";
	}

}
