package de.bretfeld.leitstelle.domain.base;

import java.util.List;

public class Einsatzeinheit {

	private String name;
	private List<Einsatzmittel> einsatzmittelListe;
	private Alarmschleife alarmschleife;

	public Einsatzeinheit(String name, List<Einsatzmittel> einsatzMittelListe, Alarmschleife alarmschleife) {
		this.name = name;
		this.einsatzmittelListe = einsatzMittelListe;
		this.alarmschleife = alarmschleife;
	}

	public String getName() {
		return name;
	}

	public List<Einsatzmittel> getEinsatzmittelListe() {
		return einsatzmittelListe;
	}
	
	public Alarmschleife getAlarmschleife() {
		return alarmschleife;
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
