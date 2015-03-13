package de.bretfeld.ilst.funk.fms.boundary;

import org.junit.Test;

import de.bretfeld.ilst.stammdaten.control.FMSStatusLeitstelle;
import de.bretfeld.ilst.stammdaten.entity.Fahrzeug;

/**
 * Testklasse für {@link FMSProcessor}.
 * 
 * @author Mark Bretfeld
 */
public class FMSProcessorTest {
	
	@Test
	public void testGenerateOutgoingFMSMessageSimple() {
		Fahrzeug einsatzmittel = new Fahrzeug("Akkon Dieburg 10/82-1", "Akkon Dieburg 10/82-1", "Wache", 2, false, true, false);
		
		FMSProcessor classUnderTest = new FMSProcessor();
		classUnderTest.generateOutgoingFMSMessage(einsatzmittel, FMSStatusLeitstelle.STATUS_c);
	}

}
