package com.karizma.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Recette")
public class Recette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Le nom de la recette ne peut pas être vide")
	private String nom;
	private String photo;
	@Min(value = 1, message = "La durée de la recette doit être d'au moins 1 minute")
	private int duree;
	@ManyToMany
	private List<Etape> etapes;
	@OneToMany(mappedBy = "recette", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecetteIngredient> ingredients;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	public List<RecetteIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecetteIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Recette(int id, String nom, String photo, int duree, List<Etape> etapes,
			List<RecetteIngredient> ingredients) {
		super();
		this.id = id;
		this.nom = nom;
		this.photo = photo;
		this.duree = duree;
		this.etapes = etapes;
		this.ingredients = ingredients;
	}

	public Recette() {
	}

}
