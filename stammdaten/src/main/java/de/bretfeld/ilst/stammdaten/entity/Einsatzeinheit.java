package de.bretfeld.ilst.stammdaten.entity;

import java.util.Set;

public class Einsatzeinheit {

	private String name;
	private Set<Einsatzmittel> einsatzmittelListe;
	private Set<Alarmschleife> alarmschleifen;

	public Einsatzeinheit(String name, Set<Einsatzmittel> einsatzMittelListe, Set<Alarmschleife> alarmschleifen) {
		this.name = name;
		this.einsatzmittelListe = einsatzMittelListe;
		this.alarmschleifen = alarmschleifen;
	}

	public String getName() {
		return name;
	}

	public Set<Einsatzmittel> getEinsatzmittelListe() {
		return einsatzmittelListe;
	}
	
	public Set<Alarmschleife> getAlarmschleifen() {
		return alarmschleifen;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == name ? 0 : name.hashCode());
		hash = 31
				* hash
				+ (null == einsatzmittelListe ? 0 : einsatzmittelListe
						.hashCode());

		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		Einsatzeinheit other = (Einsatzeinheit) obj;
		return (name == other.name)
				|| (name != null && name.equals(other.name))
				&& ((einsatzmittelListe == other.einsatzmittelListe) || (einsatzmittelListe
						.equals(other.einsatzmittelListe)));

	}
}
