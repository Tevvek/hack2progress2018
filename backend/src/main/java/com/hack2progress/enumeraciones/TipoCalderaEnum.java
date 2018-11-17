package com.hack2progress.enumeraciones;

public enum TipoCalderaEnum {
	BIOMASA("BIOMASA"),
	GASOLEO("GASOLEO"),
	GAS("GAS"),
	ELECTRICA("ELÉCTRICA"),
	GAS_NATURAL("GAS NATURAL");
	
	private String nombre;

	private TipoCalderaEnum(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
