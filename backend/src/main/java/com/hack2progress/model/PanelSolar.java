package com.hack2progress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanelSolar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="description", nullable= false)
	private String description;
	
	@Column(columnDefinition="potencia", nullable= false)
	private String potencia;
	
	@Column(columnDefinition="voltaje", nullable= false)
	private String voltaje;

	public String getVoltaje() {
		return voltaje;
	}

	public PanelSolar(Long id, String description, String potencia, String voltaje) {
		super();
		this.id = id;
		this.description = description;
		this.potencia = potencia;
		this.voltaje = voltaje;
	}

	public void setVoltaje(String voltaje) {
		this.voltaje = voltaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

}
