package com.hack2progress.model.dto.response;

public class CalderaResponse {
	
	private String tipoCaldera;
	private Double potencia;
	private Double inversionInicialEstimada;
	private Double gastoAnualEstimado;

	public Double getPotencia() {
		return potencia;
	}

	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}

	public String getTipoCaldera() {
		return tipoCaldera;
	}

	public void setTipoCaldera(String tipoCaldera) {
		this.tipoCaldera = tipoCaldera;
	}

	public Double getInversionInicialEstimada() {
		return inversionInicialEstimada;
	}

	public void setInversionInicialEstimada(Double inversionInicialEstimada) {
		this.inversionInicialEstimada = inversionInicialEstimada;
	}

	public Double getGastoAnualEstimado() {
		return gastoAnualEstimado;
	}

	public void setGastoAnualEstimado(Double gastoAnualEstimado) {
		this.gastoAnualEstimado = gastoAnualEstimado;
	}
}
