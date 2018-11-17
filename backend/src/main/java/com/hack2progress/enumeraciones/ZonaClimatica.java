
package com.hack2progress.enumeraciones;

public enum ZonaClimatica {
	Z01("Álava",  new Double(1.12), new Double(3.79197)),
	Z02("Albacete",  new Double(1.12), new Double(4.37535)),
	Z03("Alicante",  new Double(0.95), new Double(3.50028)),
	Z04("Almeria",  new Double(0.88), new Double(2.33352)),
	Z33("Asturias",  new Double(1.04), new Double(4.37535)),
	Z05("Ávila",  new Double(1.19), new Double(1.75014)),
	Z06("Badajoz",  new Double(1.04), new Double(2.9169)),
	Z07("Baleares",  new Double(0.88), new Double(6.12549)),
	Z08("Barcelona",  new Double(1.04), new Double(1.895985)),
	Z48("Vizcaya",  new Double(1.04), new Double(1.895985)),
	Z09("Burgos",  new Double(1.19), new Double(4.66704)),
	Z10("Cáceres",  new Double(1.04), new Double(2.9169)),
	Z11("Cádiz",  new Double(0.88), new Double(2.9169)),
	Z39("Cantabria",  new Double(1.04), new Double(1.45845)),
	Z12("Castellón",  new Double(0.95), new Double(2.33352)),
	Z51("Ceuta",  new Double(0.88), new Double(3.20859)),
	Z13("Ciudad Real",  new Double(1.12), new Double(2.04183)),
	Z14("Córdoba",  new Double(0.95), new Double(2.100168)),	
	Z15("A Coruña",  new Double(1.04), new Double(2.33352)),
	Z16("Cuenca",  new Double(1.12), new Double(6.41718)),
	Z20("Guipúzcoa",  new Double(1.04), new Double(1.45845)),
	Z17("Gerona",  new Double(1.04), new Double(1.45845)),
	Z18("Granada",  new Double(1.04), new Double(2.275182)),
	Z19("Guadalajara",  new Double(1.12), new Double(4.08366)),
	Z21("Huelva",  new Double(0.95), new Double(1.45845)),
	Z22("Huesca",  new Double(1.12), new Double(4.66704)),
	Z23("Jaén",  new Double(1.04), new Double(5.25042)),
	Z24("León",  new Double(1.19), new Double(2.04183)),
	Z25("Lérida",  new Double(1.12), new Double(1.75014)),
	Z27("Lugo",  new Double(1.12), new Double(1.75014)),
	Z28("Madrid",  new Double(1.12), new Double(7.58394)),
	Z29("Málaga",  new Double(0.88), new Double(2.33352)),
	Z30("Murcia",  new Double(0.95), new Double(2.946069)),
	Z31("Navarra",  new Double(1.12), new Double(1.45845)),
	Z32("Orense",  new Double(1.04), new Double(4.08366)),
	Z34("Palencia",  new Double(1.12), new Double(2.62521)),
	Z35("Las Palmas",  new Double(0.88), new Double(3.266928)),	
	Z36("Pontevedra",  new Double(1.04), new Double(3.79197)),
	Z26("La Rioja",  new Double(1.12), new Double(1.633464)),
	Z37("Salamanca",  new Double(1.12), new Double(1.779309)),
	Z40("Segovia",  new Double(1.12), new Double(1.662633)),
	Z41("Sevilla",  new Double(0.95), new Double(6.70887)),
	Z42("Soria",  new Double(1.19), new Double(1.720971)),
	Z43("Tarragona",  new Double(0.95), new Double(2.129337)),
	Z44("Teruel",  new Double(1.12), new Double(3.20859)),
	Z45("Toledo",  new Double(1.04), new Double(4.08366)),
	Z46("Valencia",  new Double(0.95), new Double(3.50028)),
	Z47("Valladolid",  new Double(1.12), new Double(6.70887)),
	Z49("Zamora",  new Double(1.12), new Double(6.41718)),
	Z50("Zaragoza",  new Double(1.12), new Double(1.837647));
	
	private String nombre;
	private Double zona;
	private Double horasSolaresPico;
	
	private ZonaClimatica(String nombre, Double zona, Double horasSolaresPico) {
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

	public Double getZona() {
		return zona;
	}

	public void setZona(Double zona) {
		this.zona = zona;
	}

	public Double getHorasSolaresPico() {
		return horasSolaresPico;
	}

	public void setHorasSolaresPico(Double horasSolaresPico) {
		this.horasSolaresPico = horasSolaresPico;
	}
	
	public static ZonaClimatica getByNombre(String nombre) {
		ZonaClimatica zona=null;
		for(ZonaClimatica zc: ZonaClimatica.values()) {
			if(zc.getNombre().equalsIgnoreCase(nombre)) {
				zona= zc;
				break;
			}
		}
		return zona;
	}
	
}
