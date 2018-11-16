package com.hack2progress.zonaClimatica;

public enum ZonaClimatica {
	Z15("A Coruña", 3, new Double("1.5")),
	Z36("Pontevedra", 3, new Double("1.5")),
	Z32("Ourense", 3, new Double("1.5")),
	Z27("Lugo", 4, new Double("1.5")),
	Z33("Asturias", 3, new Double("1.5")),
	Z39("Santander", 3, new Double("1.5"));
	
	private String nombre;
	private int zona;
	private Double horasSolaresPico;
	
	private ZonaClimatica(String nombre, int zona, Double horasSolaresPico) {
		this.nombre=nombre;
		this.zona=zona;
		this.horasSolaresPico=horasSolaresPico;
	}
	
	
}
