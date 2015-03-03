/**
 * 
 */
package de.bretfeld.ilst.funk.fms.boundary;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.bretfeld.ilst.funk.alarmierung.control.AbstractAnalogAlarmierung;
import de.bretfeld.ilst.funk.basic.TonePlayer;
import de.bretfeld.ilst.funk.basic.exception.TonePlayerException;
import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;

/**
 * Kreiert FMS Töne, z.B. das Klacken im Funk.
 * 
 * @author Mark
 * 
 */
public class FMSTonCreator extends AbstractAnalogAlarmierung {

	@Override
	public ByteArrayOutputStream alarmierungstonErzeugen(
			Alarmschleife alarmschleife, ByteArrayOutputStream stream) {
		return stream;

	}

	private ByteArrayOutputStream createFMSTon(String fahrzeugCode)
			throws TonePlayerException {

		List<Character> charList = new ArrayList<>();

		String vorlaufAndBlock = "111111111100011010";

		for (char bit : vorlaufAndBlock.toCharArray()) {
			charList.add(bit);
		}

		char[] parseFahrzeugCode = parseFahrzeugCode(fahrzeugCode);

		for (char fahrzeugCodeBit : parseFahrzeugCode) {
			charList.add(fahrzeugCodeBit);
		}

		String lastBits = "1111";

		for (char bit : lastBits.toCharArray()) {
			charList.add(bit);
		}

		List<Double> frequencyForBits = getFrequencyForBits(charList);
		ByteArrayOutputStream stream = erzeugeToene(frequencyForBits,
				new ByteArrayOutputStream());

		TonePlayer.playTones(stream);

		return stream;
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

	private ByteArrayOutputStream erzeugeToene(List<Double> toene,
			ByteArrayOutputStream stream) {
		for (Double ton : toene) {
			stream = erzeugeToene(0.8, 100, stream, ton, 0.0);
		}
		return stream;
	}

	public static void main(String[] args) throws TonePlayerException {

		new FMSTonCreator().createFMSTon("796782822");
	}

	/**
	 * Generiert aus der übergebene 5-Tonfolge die entsprechenden Frequenzen,
	 * die zur Erzeugung der Töne verwendet werden. Die Frequenzen entsprechen
	 * den ZVEI-Standard.
	 * 
	 * @param fiveTone
	 *            die 5-Tonfolge
	 * @return Eine Liste mit den generierten Frequenzen der 5-Tonfolge.
	 */
	protected List<Double> getFrequencyForBits(List<Character> bits) {
		List<Double> fuenfToene = new ArrayList<>();

		double freq = 0;

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

	private String decimalToBinary(String dezimal) {
		int i = Integer.parseInt(dezimal);
		String bin = Integer.toBinaryString(i);
		return bin;
	}

	private String hexToBinary(String hex) {
		int i = Integer.parseInt(hex, 16);
		String bin = Integer.toBinaryString(i);
		return bin;
	}

}
