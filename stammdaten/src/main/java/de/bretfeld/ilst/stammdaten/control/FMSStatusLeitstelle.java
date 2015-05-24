package de.bretfeld.ilst.stammdaten.control;

/**
 * Die Klasse {@link FMSStatusFahrzeug} enth�lt alle nach BOS gültigen
 * FMS-Status für die Richtung Leitstelle --> Einsatzeinheit. Die Unterteilung
 * zwischen Rettungsdienst, Feuerwehr und Polizei ist nötig, da hier jeweils
 * andere Möglichkeiten der Benutzung vorgegeben sind.
 *
 * @author Mark Bretfeld
 *
 */
public enum FMSStatusLeitstelle {

	// Meldeweg Leitstelle --> Einsatzeinheit
	STATUS_0(0, "0", "Statusabfrage", "Statusabfrage", "Statusabfrage"), //
	STATUS_A(1, "A", "Sammelruf (An Alle)", "Sammelruf (An Alle)",
			"Sammelruf (An Alle)"), //
	STATUS_E(2, "E", "Einrücken", "Einrücken", "Eigensicherung"), //
	STATUS_C(3, "C", "Melden Sie sich f�r Einsatzübernahme",
			"Melden Sie sich für Einsatz�bernahme", "Fremdhörer ausschalten"), //
	STATUS_F(4, "F", "Kommen Sie über Draht", "Kommen Sie über Draht",
			"Kommen Sie über Draht"), //
	STATUS_H(5, "H", "Fahren Sie Wache an", "Fahren Sie Wache an", "Haftbefehl"), //
	STATUS_J(6, "J", "Sprechaufforderung", "Sprechaufforderung",
			"Sprechaufforderung"), //
	STATUS_L(7, "L", "Geben Sie Lagemeldung", "Geben Sie Lagemeldung",
			"Geben Sie Lagemeldung"), //
	STATUS_P(8, "P", "Einsatz mit POL", "", ""), //
	STATUS_U(9, "U", "Unerlaubte Statusfolge", "", ""), //
	STATUS_c(10, "c", "Status korrigieren", "Status korrigieren", ""), //
	STATUS_d(11, "d", "Transportziel durchgeben", "", ""), //
	STATUS_h(12, "h", "Zielklinik verständigt", "", ""), //
	STATUS_o(13, "o", "Warten, alle Abfrageplätze belegt",
			"Warten, alle Abfrageplätze belegt", ""), //
	STATUS_u(14, "u", "Verstanden", "Verstanden", ""), //
	STATUS_QUITTUNG(15, "15", "automatische selektive Quittung",
			"automatische selektive Quittung",
			"automatische selektive Quittung"); //

	private final Integer statusNummer;
	private final String status;
	private final String beschreibungRettungsdienst;
	private final String beschreibungFeuerwehr;
	private final String beschreibungPolizei;

	private FMSStatusLeitstelle(Integer statusNummer, String status,
			String beschreibungRettungsdienst, String beschreibungFeuerwehr,
			String beschreibungPolizei) {
		this.statusNummer = statusNummer;
		this.status = status;
		this.beschreibungRettungsdienst = beschreibungRettungsdienst;
		this.beschreibungFeuerwehr = beschreibungFeuerwehr;
		this.beschreibungPolizei = beschreibungPolizei;
	}

	public Integer getStatusNummer() {
		return statusNummer;
	}

	/**
	 * Gibt den Status als Zahl zur�ck. Verwendung f�r UI-Anzeige.
	 *
	 * @return den FMS Status als Zahl.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return Beschreibung für den Status im Rettungsdienst.
	 */
	public String getBeschreibungRettungsdienst() {
		return beschreibungRettungsdienst;
	}

	/**
	 * @return Beschreibung für den Status bei der Feuerwehr.
	 */
	public String getBeschreibungFeuerwehr() {
		return beschreibungFeuerwehr;
	}

	/**
	 * @return Beschreibung für den Status bei der Polizei.
	 */
	public String getBeschreibungPolizei() {
		return beschreibungPolizei;
	}

}
