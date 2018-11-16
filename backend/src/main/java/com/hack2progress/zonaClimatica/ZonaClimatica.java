package com.hack2progress.zonaClimatica;

public enum ZonaClimatica {
	Z15("A Coruña", 3),
	Z36("Pontevedra", 3),
	Z32("Ourense", 3),
	Z27("Lugo", 4),
	Z33("Asturias", 3),
	Z39("Santander", 3);
	
	private String nombre;
	private int zona;
	
	private ZonaClimatica(String nombre, int zona) {
		this.nombre=nombre;
		this.zona=zona;
	}
	
	
}
