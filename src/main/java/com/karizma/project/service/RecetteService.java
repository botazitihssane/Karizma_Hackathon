package com.karizma.project.service;

import java.util.List;

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;

public interface RecetteService {
	Recette createRecette(Recette recette);

	Recette getRecetteByID(int id);

	List<Recette> getRecettesByNom(String nom);

	List<Recette> getRecettesByDuree(int duree);

	List<Recette> getRecettesByIngredient(List<Ingredient> ingredients);

	void deleteRecette(int id);

	void updateRecette(Recette recette);

	List<Recette> getAllRecettes();
}
