package de.bretfeld.ilst.stammdaten.control;


/**
 * Die Klasse {@link FMSStatusFahrzeug} enth�lt alle nach BOS gültigen
 * FMS-Status für die Richtung Einsatzeinheit --> Leitstelle. Die Unterteilung
 * zwischen Rettungsdienst, Feuerwehr und Polizei ist nötig, da hier jeweils
 * andere Möglichkeiten der Benutzung vorgegeben sind.
 *
 * @author Mark Bretfeld
 *
 */
public enum FMSStatusFahrzeug {

    // Meldeweg Einsatzeinheit --> Leitstelle
    // Für die Werte müssen die Status an sich verwendet werden, da es hier pro Orga eine andere
    // Belegung gibt.
    STATUS_1(1, "1", "Einsatzbereit über Funk", "Einsatzbereit über Funk", "Einsatzbereit über Funk"),
    STATUS_2(2, "2", "Einsatzbereit auf Wache", "Einsatzbereit auf Wache", "Einsatzbereit auf Wache"),
    STATUS_3(3, "3", "Einsatz übernommen", "Einsatz übernommen", "Einsatz übernommen"),
    STATUS_4(4, "4", "Ankunft am Einsatzort", "Ankunft am Einsatzort", "Ankunft am Einsatzort"),
    STATUS_5(5, "5", "Sprechwunsch", "Sprechwunsch", "Sprechwunsch"),
    STATUS_6(6, "6", "Nicht einsatzbereit", "Nicht einsatzbereit", "Temporär ausbuchen"),
    STATUS_7(7, "7", "Patient aufgenommen", "", "Infowunsch"),
    STATUS_8(8, "8", "am Transportziel", "", "Einsatz übernommen"),
    STATUS_9(9, "9", "Handquittung", "Handquittung", "Handquittung"),
    STATUS_0(0, "0", "Notruf", "Notruf", "Notruf");

    private final Integer statusNummer;
    private final String status;
    private final String beschreibungRettungsdienst;
    private final String beschreibungFeuerwehr;
    private final String beschreibungPolizei;

    private FMSStatusFahrzeug(Integer statusNummer, String status, String beschreibungRettungsdienst,
            String beschreibungFeuerwehr, String beschreibungPolizei) {
        this.statusNummer = statusNummer;
        this.status = status;
        this.beschreibungRettungsdienst = beschreibungRettungsdienst;
        this.beschreibungFeuerwehr = beschreibungFeuerwehr;
        this.beschreibungPolizei = beschreibungPolizei;
    }

    /**
     * @return die Status Nummer.
     */
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
