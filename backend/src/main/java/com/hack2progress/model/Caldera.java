package com.hack2progress.model;

import javax.persistence.*;

@Entity
public class Caldera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="description", nullable= false)
	private String description;
	
	@Column(columnDefinition="potencia", nullable= false)
	private Double potencia;

	public Caldera(Long id, String description, Double potencia) {
		super();
		this.id = id;
		this.description = description;
		this.potencia = potencia;
	}

	
	
	public Caldera() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public Double getPotencia() {
		return potencia;
	}



	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}
	
	

}
