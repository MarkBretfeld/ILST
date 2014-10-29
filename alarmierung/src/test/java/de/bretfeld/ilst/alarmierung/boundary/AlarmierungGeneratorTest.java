package de.bretfeld.ilst.alarmierung.boundary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.bretfeld.ilst.alarmierung.boundary.AlarmGenerator;
import de.bretfeld.ilst.alarmierung.boundary.exception.AlarmierungException;
import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;
import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;
import de.bretfeld.ilst.stammdaten.entity.Einsatzmittel;

public class AlarmierungGeneratorTest {
	
	public static void main(String[] args) {
		
		
		Queue<Einsatzeinheit> einsatzeinheiten = new LinkedList<Einsatzeinheit>();
		List<Alarmschleife> alarmschleifen = new ArrayList<>();
		

		alarmschleifen.add(new Alarmschleife("58750", false, false, false, false,
				false, false));
//		alarmschleifen.add(new Alarmschleife("58341", false, false, false, false,
//				false, false));
//		alarmschleifen.add(new Alarmschleife("58312", false, false, false, false,
//				false, false));
//		alarmschleifen.add(new Alarmschleife("58620", false, false, false, false,
//				false, true));
//		alarmschleifen.add(new Alarmschleife("58621", false, false, false, false,
//				false, true));
//		alarmschleifen.add(new Alarmschleife("58625", true, false, false, false,
//				false, false));
//		alarmschleifen.add(new Alarmschleife("58626", false, true, false, false,
//				false, false));
//		alarmschleifen.add(new Alarmschleife("58627", false, false, true, false,
//				false, false));
//		alarmschleifen.add(new Alarmschleife("58628", false, false, false, true,
//				false, false));
//		alarmschleifen.add(new Alarmschleife("58628", false, false, false, true,
//				true, false));
		
		einsatzeinheiten.add(new Einsatzeinheit("TEST", new ArrayList<Einsatzmittel>(), alarmschleifen));
		
		AlarmGenerator gen = AlarmGenerator.getInstance();
		
		
		try {
			gen.alarmieren(einsatzeinheiten);
		} catch (AlarmierungException e) {
			e.printStackTrace();
		}
		
		
	}

}
