package com.hack2progress.model;

public class ElementoConsumo {
	private Double potencia;
	
	private Double horasUso;

	public Double getPotencia() {
		return potencia;
	}

	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}

	public Double getHorasUso() {
		return horasUso;
	}

	public void setHorasUso(Double horasUso) {
		this.horasUso = horasUso;
	}

	public ElementoConsumo(Double potencia, Double horasUso) {
		super();
		this.potencia = potencia;
		this.horasUso = horasUso;
	}
	
	
	

}
