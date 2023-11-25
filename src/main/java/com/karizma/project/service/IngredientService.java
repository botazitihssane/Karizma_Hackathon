package com.karizma.project.service;

import java.util.List;

import com.karizma.project.model.Ingredient;

public interface IngredientService {
	Ingredient createIngredient(Ingredient ingredient);

	void deleteIngredient(int id);

	void updateIngredient(Ingredient ingredient);

	List<Ingredient> getAllIngredients();

	Ingredient getIngredientById(int id);
	
	List<Ingredient> getIngredientByNom(String nom);
}
