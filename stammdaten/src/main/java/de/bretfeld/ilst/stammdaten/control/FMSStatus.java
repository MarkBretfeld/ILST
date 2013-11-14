package de.bretfeld.ilst.stammdaten.control;

import de.bretfeld.ilst.stammdaten.entity.Einsatzmittel;

/**
 * Die Klasse {@link FMSStatus} enthält alle nach BOS gültigen FMS-Status
 * für die Richtung Leitstelle --> Einsatzeinheit und Einsatzeinheit --> Leitstelle.
 * Die Unterteilung zwischen Rettungsdienst, Feuerwehr und Polizei ist nötig, da hier
 * jeweils andere Möglichkeiten der Benutzung vorgegeben sind.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public enum FMSStatus {

	// Meldeweg Einsatzeinheit --> Leitstelle
	// Für die Werte müssen die Status an sich verwendet werden, da es hier pro Orga eine andere
	// Belegung gibt.
	
	STATUS_1("1", "Einsatzbereit über Funk", "Einsatzbereit über Funk", "Einsatzbereit über Funk"), 
	STATUS_2("2", "Einsatzbereit auf Wache", "Einsatzbereit auf Wache", "Einsatzbereit auf Wache"),
	STATUS_3("3", "Einsatz übernommen", "Einsatz übernommen", "Einsatz übernommen"),
	STATUS_4("4", "Ankunft am Einsatzort", "Ankunft am Einsatzort", "Ankunft am Einsatzort"),
	STATUS_5("5", "Sprechwunsch", "Sprechwunsch", "Sprechwunsch"),
	STATUS_6("6", "Nicht einsatzbereit", "Nicht einsatzbereit", "Temporär ausbuchen"),
	STATUS_7("7", "Patient aufgenommen", "", "Infowunsch"),
	STATUS_8("8", "am Transportziel", "", "Einsatz übernommen"),
	STATUS_9("9", "Handquittung", "Handquittung", "Handquittung"),
	STATUS_0("0", "Notruf", "Notruf", "Notruf"),

	// Meldeweg Leitstelle --> Einsatzeinheit
	
	STATUS_A("A", "Sammelruf (An Alle)", "Sammelruf (An Alle)", "Sammelruf (An Alle)"),
	STATUS_E("E", "Einrücken", "Einrücken", "Eigensicherung"),
	STATUS_C("C", "Melden Sie sich für Einsatzübernahme", "Melden Sie sich für Einsatzübernahme", "Fremdhörer ausschalten"),
	STATUS_F("F", "Kommen Sie über Draht", "Kommen Sie über Draht", "Kommen Sie über Draht"),
	STATUS_H("H", "Fahren Sie Wache an", "Fahren Sie Wache an", "Haftbefehl"),
	STATUS_J("J", "Sprechaufforderung", "Sprechaufforderung", "Sprechaufforderung"),
	STATUS_L("L", "Geben Sie Lagemeldung", "Geben Sie Lagemeldung", "Geben Sie Lagemeldung"),
	STATUS_P("P", "Einsatz mit POL", "", ""),
	STATUS_U("U", "Unerlaubte Statusfolge", "", ""),
	STATUS_c("c", "Status korrigieren", "Status korrigieren", ""),
	STATUS_d("d", "Transportziel durchgeben", "", ""),
	STATUS_h("h", "Zielklinik verständigt", "", ""),
	STATUS_o("o", "Warten, alle Abfrageplätze belegt", "Warten, alle Abfrageplätze belegt", ""),
	STATUS_u("u", "Verstanden", "Verstanden", "");

	private String status;
	private String beschreibungRettungsdienst;
	private String beschreibungFeuerwehr;
	private String beschreibungPolizei;

	private FMSStatus(String status, String beschreibungRettungsdienst,
			String beschreibungFeuerwehr, String beschreibungPolizei) {
		this.status = status;
		this.beschreibungRettungsdienst = beschreibungRettungsdienst;
		this.beschreibungFeuerwehr = beschreibungFeuerwehr;
		this.beschreibungPolizei = beschreibungPolizei;
	}

	/**
	 * Gibt den Status als Zahl zurück. Verwendung für UI-Anzeige.
	 * 
	 * @return den FMS Status als Zahl.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Gibt die Beschreibung des FMS-Status für das jeweilige Einsatzmittel zurück.
	 * Hierbei wird festgestellt, ob es sich beim Einsatzmittel um Feuerwehr/THW, Rettungsdienst
	 * oder Polizei handelt.
	 * 
	 * @return die Beschreibung des FMS-Status für das jeweilige Einsatzmittel zurück.
	 */
	public String getBeschreibungByEinsatzmittel(Einsatzmittel einsatzmittel) {
		String beschreibung = "";
		if (einsatzmittel.isFeuerwehrThw())
			beschreibung = beschreibungFeuerwehr;
		else if (einsatzmittel.isRettungsdienst())
			beschreibung = beschreibungRettungsdienst;
		else if (einsatzmittel.isPolizei())
			beschreibung = beschreibungPolizei;

		return beschreibung;
	}

}
