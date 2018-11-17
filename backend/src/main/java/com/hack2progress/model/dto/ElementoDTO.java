package com.hack2progress.model.dto;

public class ElementoDTO {
	public ElementoDTO(String nombre, Integer potencia, Integer horasUso) {
		super();
		this.nombre = nombre;
		this.potencia = potencia;
		this.horasUso = horasUso;
	}
	private String nombre;
	private Integer potencia;
	private Integer horasUso;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPotencia() {
		return potencia;
	}
	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	public Integer getHorasUso() {
		return horasUso;
	}
	public void setHorasUso(Integer horasUso) {
		this.horasUso = horasUso;
	}
}
