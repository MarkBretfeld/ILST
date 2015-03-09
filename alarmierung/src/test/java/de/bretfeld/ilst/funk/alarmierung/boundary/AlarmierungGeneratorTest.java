package de.bretfeld.ilst.funk.alarmierung.boundary;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import de.bretfeld.ilst.funk.basic.exception.TonePlayerException;
import de.bretfeld.ilst.stammdaten.control.AlarmTyp;
import de.bretfeld.ilst.stammdaten.entity.Alarmschleife;
import de.bretfeld.ilst.stammdaten.entity.Einsatzeinheit;
import de.bretfeld.ilst.stammdaten.entity.Einsatzmittel;

public class AlarmierungGeneratorTest {
	
	public static void main(String[] args) {
		
		Queue<Einsatzeinheit> einsatzeinheiten = new LinkedList<Einsatzeinheit>();
		Set<Alarmschleife> alarmschleifen = new HashSet<>();

		alarmschleifen.add(new Alarmschleife("36987", AlarmTyp.FME));
		alarmschleifen.add(new Alarmschleife("58341", AlarmTyp.FME));
		alarmschleifen.add(new Alarmschleife("58312", AlarmTyp.FME));
		alarmschleifen.add(new Alarmschleife("58620", AlarmTyp.FEUERALARM));
		alarmschleifen.add(new Alarmschleife("58621", AlarmTyp.FEUERALARM));
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
//		
		einsatzeinheiten.add(new Einsatzeinheit("TEST", Collections. <Einsatzmittel> emptySet(), alarmschleifen));
		
		AlarmGenerator gen = AlarmGenerator.getInstance();
		
		try {
			gen.alarm(einsatzeinheiten);
		} catch (TonePlayerException e) {
			e.printStackTrace();
		}
		
		
	}

}
