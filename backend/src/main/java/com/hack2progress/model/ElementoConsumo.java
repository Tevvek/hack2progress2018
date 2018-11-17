package com.hack2progress.model;

public class ElementoConsumo {
	private String nombre;
	private int potencia;
	private int horasUso;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public int getHorasUso() {
		return horasUso;
	}
	public void setHorasUso(int horasUso) {
		this.horasUso = horasUso;
	}
	
	public ElementoConsumo(String nombre, int i, int j) {
		super();
		this.nombre = nombre;
		this.potencia = i;
		this.horasUso = j;
	}
	

}
