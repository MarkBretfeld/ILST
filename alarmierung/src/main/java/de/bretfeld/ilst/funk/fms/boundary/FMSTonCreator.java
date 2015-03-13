/**
 *
 */
package de.bretfeld.ilst.funk.fms.boundary;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.bretfeld.ilst.funk.alarmierung.control.AbstractTonerzeuger;
import de.bretfeld.ilst.funk.basic.control.TonePlayer;
import de.bretfeld.ilst.funk.basic.exception.TonePlayerException;

/**
 * Kreiert FMS Töne, z.B. das Klacken im Funk.
 *
 * @author Mark Bretfeld
 *
 */
public class FMSTonCreator extends AbstractTonerzeuger {
	
	private static FMSTonCreator instance;
	
	private FMSTonCreator() {
		
	}
	
	public static FMSTonCreator getInstance() {
		if (instance == null) {
			instance = new FMSTonCreator(); 
		}
		return instance;
	}
	

    public ByteArrayOutputStream createFMSTonLeitstelle(String fahrzeugCode)
            throws TonePlayerException {

        List<Character> charList = new ArrayList<>();

        generateVorlaufBlock(charList);
        generateFahrzeugCode(fahrzeugCode, charList);
        String lastBits = "1111";
        addBitsToCharList(charList, lastBits.toCharArray());

        List<Integer> frequencyForBits = getFrequencyForBits(charList);
        ByteArrayOutputStream stream = erzeugeToene(frequencyForBits,
                new ByteArrayOutputStream());

        TonePlayer.playTones(stream);

        return stream;
    }
    
    public ByteArrayOutputStream createFMSTonFahrzeug(String fahrzeugCode)
            throws TonePlayerException {

        List<Character> charList = new ArrayList<>();

        generateVorlaufBlock(charList);
        generateFahrzeugCode(fahrzeugCode, charList);
        String lastBits = "1011";
        addBitsToCharList(charList, lastBits.toCharArray());

        List<Integer> frequencyForBits = getFrequencyForBits(charList);
        ByteArrayOutputStream stream = erzeugeToene(frequencyForBits,
                new ByteArrayOutputStream());

        TonePlayer.playTones(stream);

        return stream;
    }

	public static void main(String[] args) throws TonePlayerException {

		new FMSTonCreator().createFMSTonFahrzeug("976782822");
        new FMSTonCreator().createFMSTonLeitstelle("9767828215");
    }

    private void generateVorlaufBlock(List<Character> charList) {
		String vorlaufAndBlock = "11111111111100011010";
	    addBitsToCharList(charList, vorlaufAndBlock.toCharArray());
	}

	private void generateFahrzeugCode(String fahrzeugCode,
			List<Character> charList) {
		char[] parseFahrzeugCode = parseFahrzeugCode(fahrzeugCode);
	
	    addBitsToCharList(charList, parseFahrzeugCode);
	}

	private char[] parseFahrzeugCode(String fahrzeugCode) {
	
	    // einstellig, hexadezimal
	    String bosKennung = fahrzeugCode.substring(0, 1);
	    // einstellig, hexadezimal
	    String landesKennung = fahrzeugCode.substring(1, 2);
	    // zweistellig, dezimal
	    String ortsKennung = fahrzeugCode.substring(2, 4);
	    // vierstellig, dezimal
	    String fahrzeugKennung = fahrzeugCode.substring(4, 8);
	    // einstellig, hexadezimal
	    String status = fahrzeugCode.substring(8, 9);
	
	    StringBuilder sb = new StringBuilder();
	    sb.append(hexToBinary(bosKennung));
	    sb.append(hexToBinary(landesKennung));
	    sb.append(decimalToBinary(ortsKennung));
	    sb.append(decimalToBinary(fahrzeugKennung));
	    sb.append(hexToBinary(status));
	    
	    return sb.toString().toCharArray();
	}

	/**
	 * Generiert aus der übergebenen 5-Tonfolge die entsprechenden Frequenzen,
	 * die zur Erzeugung der Töne verwendet werden. Die Frequenzen entsprechen
	 * den ZVEI-Standard.
	 *
	 * @param bits die 5-Tonfolge
	 * @return Eine Liste mit den generierten Frequenzen der 5-Tonfolge.
	 */
	private List<Integer> getFrequencyForBits(List<Character> bits) {
	    List<Integer> fuenfToene = new ArrayList<>();
	
	    int freq = 0;
	
	    // Zuweisung der Frequenzen zu den Ziffern
	    for (char c : bits) {
	        switch (c) {
	            case '1':
	                freq = 1200;
	                break;
	
	            case '0':
	                freq = 1800;
	                break;
	        }
	        fuenfToene.add(freq);
	    }
	    return fuenfToene;
	}

	private ByteArrayOutputStream erzeugeToene(List<Integer> toene,
	        ByteArrayOutputStream stream) {
	    for (Integer ton : toene) {
	        stream = erzeugeToene(0.8, 100, stream, ton, 0);
	    }
	    return stream;
	}

	private void format4BitDualCode(int number, StringBuilder sb) {
        final String toBinaryString = Integer.toBinaryString(number);
        StringBuilder formattedString = new StringBuilder(String.format("%4s", toBinaryString).replace(' ', '0'));
        formattedString.reverse();
        sb.append(formattedString.toString());
    }

    private void addBitsToCharList(List<Character> charList,
    		char[] bitArray) {
    	for (char bit : bitArray) {
    		charList.add(bit);
    	}
    }

	private String decimalToBinary(String dezimal) {
	    StringBuilder sb = new StringBuilder();
	
	    for (Character c : dezimal.toCharArray()) {
	        String numberString = c.toString();
	        int number = Integer.parseInt(numberString);
	        format4BitDualCode(number, sb);
	    }
	    return sb.toString();
	}

	private String hexToBinary(String hex) {
	    StringBuilder sb = new StringBuilder();
	
	    for (Character c : hex.toCharArray()) {
	        String numberString = c.toString();
	        int number = Integer.parseInt(numberString, 16);
	        format4BitDualCode(number, sb);
	    }
	    return sb.toString();
	}
}
