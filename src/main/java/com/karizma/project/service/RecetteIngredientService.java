package com.karizma.project.service;

import java.util.List;

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;
import com.karizma.project.model.RecetteIngredient;

public interface RecetteIngredientService {
	RecetteIngredient createRecetteIngredient(RecetteIngredient recetteIngredient);

	List<RecetteIngredient> findByRecette(Recette recette);

	List<RecetteIngredient> findByIngredient(Ingredient ingredient);

	List<RecetteIngredient> getAllRecetteIngredient();

	void deleteRecetteIngredient(int id);

	void updateRecetteIngredient(RecetteIngredient recetteIngredient);

	RecetteIngredient getRecetteIngredientByID(int id);
}
