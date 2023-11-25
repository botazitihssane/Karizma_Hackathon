package com.karizma.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Etape")
public class Etape {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "La description de l'étape ne peut pas être vide")
	private String description;
	@Min(value = 1, message = "Le numéro de l'étape doit être supérieur à zéro")
	private int numero_Etape;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumero_Etape() {
		return numero_Etape;
	}

	public void setNumero_Etape(int numero_Etape) {
		this.numero_Etape = numero_Etape;
	}

	public Etape(int id, String description, int numero_Etape) {
		super();
		this.id = id;
		this.description = description;
		this.numero_Etape = numero_Etape;
	}

	public Etape() {
	}

}
