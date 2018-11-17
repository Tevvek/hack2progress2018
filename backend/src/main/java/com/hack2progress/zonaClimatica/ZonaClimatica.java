
package com.hack2progress.zonaClimatica;

public enum ZonaClimatica {
	Z01("Álava", 4, new Double(3.79197)),
	Z02("Albacete", 4, new Double(4.37535)),
	Z03("Alicante", 2, new Double(3.50028)),
	Z04("Almeria", 1, new Double(2.33352)),
	Z33("Asturias", 3, new Double(4.37535)),
	Z05("Ávila", 5, new Double(1.75014)),
	Z06("Badajoz", 3, new Double(2.9169)),
	Z07("Baleares", 1, new Double(6.12549)),
	Z08("Barcelona", 3, new Double(1.895985)),
	Z48("Vizcaya", 3, new Double(1.895985)),
	Z09("Burgos", 5, new Double(4.66704)),
	Z10("Cáceres", 3, new Double(2.9169)),
	Z11("Cádiz", 1, new Double(2.9169)),
	Z39("Cantabria", 3, new Double(1.45845)),
	Z12("Castellón", 2, new Double(2.33352)),
	Z51("Ceuta", 1, new Double(3.20859)),
	Z13("Ciudad Real", 4, new Double(2.04183)),
	Z14("Córdoba", 2, new Double(2.100168)),	
	Z15("A Coruña", 3, new Double(2.33352)),
	Z16("Cuenca", 4, new Double(6.41718)),
	Z20("Guipúzcoa", 3, new Double(1.45845)),
	Z17("Gerona", 3, new Double(1.45845)),
	Z18("Granada", 3, new Double(2.275182)),
	Z19("Guadalajara", 4, new Double(4.08366)),
	Z21("Huelva", 2, new Double(1.45845)),
	Z22("Huesca", 4, new Double(4.66704)),
	Z23("Jaén", 3, new Double(5.25042)),
	Z24("León", 5, new Double(2.04183)),
	Z25("Lérida", 4, new Double(1.75014)),
	Z27("Lugo", 4, new Double(1.75014)),
	Z28("Madrid", 4, new Double(7.58394)),
	Z29("Málaga", 1, new Double(2.33352)),
	Z30("Murcia", 2, new Double(2.946069)),
	
	Z36("Pontevedra", 3, new Double(1.5)),
	Z32("Orense", 3, new Double(1.5)),
	
	;
	
	private String nombre;
	private int zona;
	private Double horasSolaresPico;
	
	private ZonaClimatica(String nombre, int zona, Double horasSolaresPico) {
		this.nombre=nombre;
		this.zona=zona;
		this.horasSolaresPico=horasSolaresPico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public Double getHorasSolaresPico() {
		return horasSolaresPico;
	}

	public void setHorasSolaresPico(Double horasSolaresPico) {
		this.horasSolaresPico = horasSolaresPico;
	}
	
	
}
