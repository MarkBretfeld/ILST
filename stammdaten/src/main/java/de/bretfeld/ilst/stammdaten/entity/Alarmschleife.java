package de.bretfeld.ilst.stammdaten.entity;

public class Alarmschleife {

	private String schleife;
	private boolean isSirene;
	private boolean isWeckton;

	public Alarmschleife(String schleife) {
		this.schleife = schleife;
		dertermineOptionalToDos();
	}

	private void dertermineOptionalToDos() {
		if (this.schleife.endsWith("S")) {
			this.isSirene = true;
		} else if (this.schleife.endsWith("W")) {
			this.isWeckton = true;
		}

	}

	public String getSchleife() {
		return schleife.substring(0, 5);
	}

	public boolean isSirene() {
		return isSirene;
	}

	public boolean isWeckton() {
		return isWeckton;
	}

}
