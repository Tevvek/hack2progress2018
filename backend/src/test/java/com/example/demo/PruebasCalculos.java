package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.hack2progress.enumeraciones.ZonaClimatica;
import com.hack2progress.model.Caldera;
import com.hack2progress.model.ElementoConsumo;
import com.hack2progress.util.Util;


public class PruebasCalculos {

	public static void main(String[] args) {
		
		ElementoConsumo c1 = new ElementoConsumo("bombillas", 80, 24);
		ElementoConsumo c2 = new ElementoConsumo("television", 75, 4);
		ElementoConsumo c3 = new ElementoConsumo("nevera", 600, 6);
		List<ElementoConsumo> elems = new ArrayList<ElementoConsumo>();
		elems.add(c1);
		elems.add(c2);
		elems.add(c3);

		Caldera caldera = new Caldera(Long.valueOf(1), "cald2", (double) 8000);
		System.out.println("Num paneles: " + Util.getNumeroPanelesEstimacion(ZonaClimatica.Z15,elems));
		
		System.out.println("Potencia conversor" +Util.ponteciaConvertidor(elems));
		System.out.println("Num baterias: " +Util.numeroBaterias(elems, 2,120));
	}

}
