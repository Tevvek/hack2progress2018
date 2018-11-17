package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.hack2progress.enumeraciones.ZonaClimatica;
import com.hack2progress.model.Caldera;
import com.hack2progress.model.ElementoConsumo;
import com.hack2progress.model.dto.ElementoDTO;
import com.hack2progress.util.Util;


public class PruebasCalculos {

	public static void main(String[] args) {
		
		ElementoDTO c1 = new ElementoDTO("bombillas", 80, 24);
		ElementoDTO c2 = new ElementoDTO("television", 75, 4);
		ElementoDTO c3 = new ElementoDTO("nevera", 600, 6);
		List<ElementoDTO> elems = new ArrayList<ElementoDTO>();
		elems.add(c1);
		elems.add(c2);
		elems.add(c3);
		
		Util util = new Util();

		Caldera caldera = new Caldera(Long.valueOf(1), "cald2", (double) 8000);
		System.out.println("Num paneles: " + util.getNumeroPanelesEstimacion(ZonaClimatica.Z15.getHorasSolaresPico() ,elems));
		
		System.out.println("Potencia conversor" +util.ponteciaConvertidor(elems));
		System.out.println("Num baterias: " +util.numeroBaterias(elems, 2,120));
	}

}
