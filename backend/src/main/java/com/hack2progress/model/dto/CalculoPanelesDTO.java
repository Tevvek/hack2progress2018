package com.hack2progress.model.dto;

import java.util.List;

public class CalculoPanelesDTO {
	private PosicionDTO posicion;
	private List<ElementoDTO> elementos;
	public PosicionDTO getPosicion() {
		return posicion;
	}
	public void setPosicion(PosicionDTO posicion) {
		this.posicion = posicion;
	}
	public List<ElementoDTO> getElementos() {
		return elementos;
	}
	public void setElementos(List<ElementoDTO> elementos) {
		this.elementos = elementos;
	}

}
