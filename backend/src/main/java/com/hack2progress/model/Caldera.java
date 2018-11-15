package com.hack2progress.model;

import javax.persistence.*;

@Entity
public class Caldera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="description", nullable= false)
	private String description;

	public Caldera(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
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
	
	

}
