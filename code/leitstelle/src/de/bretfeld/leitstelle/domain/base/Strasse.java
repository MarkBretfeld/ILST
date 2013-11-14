package de.bretfeld.leitstelle.domain.base;

public class Strasse {

	private String name;
	
	public String getName() {
		return name;
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
