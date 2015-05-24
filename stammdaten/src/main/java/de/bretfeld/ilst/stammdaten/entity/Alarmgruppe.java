package de.bretfeld.ilst.stammdaten.entity;

import java.util.Date;
import java.util.Set;

import application.AbstractEntity;

public class Alarmgruppe extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private Set<Alarmschleife> alarmschleifen;
	private Date gueltigVon;
	private Date gueltigBis;

	protected Alarmgruppe() {
		
	}
	
	public Alarmgruppe(String name, Set<Alarmschleife> alarmschleifen,
			Date gueltigVon, Date gueltigBis) {
		super();
		this.name = name;
		this.alarmschleifen = alarmschleifen;
		this.gueltigVon = gueltigVon;
		this.gueltigBis = gueltigBis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Alarmschleife> getAlarmschleifen() {
		return alarmschleifen;
	}

	public void setAlarmschleifen(Set<Alarmschleife> alarmschleifen) {
		this.alarmschleifen = alarmschleifen;
	}

	public Date getGueltigVon() {
		return gueltigVon;
	}

	public void setGueltigVon(Date gueltigVon) {
		this.gueltigVon = gueltigVon;
	}

	public Date getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(Date gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alarmschleifen == null) ? 0 : alarmschleifen.hashCode());
		result = prime * result
				+ ((gueltigBis == null) ? 0 : gueltigBis.hashCode());
		result = prime * result
				+ ((gueltigVon == null) ? 0 : gueltigVon.hashCode());
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
		Alarmgruppe other = (Alarmgruppe) obj;
		if (alarmschleifen == null) {
			if (other.alarmschleifen != null)
				return false;
		} else if (!alarmschleifen.equals(other.alarmschleifen))
			return false;
		if (gueltigBis == null) {
			if (other.gueltigBis != null)
				return false;
		} else if (!gueltigBis.equals(other.gueltigBis))
			return false;
		if (gueltigVon == null) {
			if (other.gueltigVon != null)
				return false;
		} else if (!gueltigVon.equals(other.gueltigVon))
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
		return "Alarmgruppe [name=" + name + ", alarmschleifen="
				+ alarmschleifen + ", gueltigVon=" + gueltigVon
				+ ", gueltigBis=" + gueltigBis + "]";
	}

}
