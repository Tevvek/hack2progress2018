package com.hack2progress.model.dto;

public class CalculoDTO {
	private int superficie;
	private String orientacion;
	private String aislamiento;
	private PosicionDTO posicion;
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}
	public String getAislamiento() {
		return aislamiento;
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
}
