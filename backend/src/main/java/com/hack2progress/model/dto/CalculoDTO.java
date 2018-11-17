package com.hack2progress.model.dto;

import java.util.List;

public class CalculoDTO {
	private int superficie;
	private String orientacion;
	private String aislamiento;
	private PosicionDTO posicion;
	private List<ElementoDTO> elementosConsumo;
	
	public int getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getOrientacion() {
		return orientacion;
	}
	public Double getValorOrientacion() {
		Double valor = new Double("0");
		switch(orientacion) {
			case "Norte":
				valor = new Double("1.12");
				break;
			case "Sur":
				valor = new Double("0.92");
				break;
			case "Este":
				valor = new Double("1");
				break;
			case "Oeste":
				valor = new Double("1");
				break;
			default:
				valor = new Double("1");
				break;
		}
		
		return valor;
	}
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}
	public String getAislamiento() {
		return aislamiento;
	}
	public Double getValorAislamiento() {
		Double valor = new Double("0");
		switch(aislamiento) {
			case "Bueno":
				valor = new Double("0.93");
				break;
			case "Sencillo":
				valor = new Double("1");
				break;
			case "Sin aislamiento":
				valor = new Double("1.10");
				break;
			default:
				valor = new Double("1.10");
				break;
		}
		
		return valor;
	}
	public void setAislamiento(String aislamiento) {
		this.aislamiento = aislamiento;
	}
	public PosicionDTO getPosicion() {
		return posicion;
	}
	public void setPosicion(PosicionDTO posicion) {
		this.posicion = posicion;
	}
	
	public List<ElementoDTO> getElementosConsumo() {
		return elementosConsumo;
	}
	public void setElementosConsumo(List<ElementoDTO> elementosConsumo) {
		this.elementosConsumo = elementosConsumo;
	}
}
