package com.karizma.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karizma.project.model.Ingredient;
import com.karizma.project.repository.IngredientRepository;
import com.karizma.project.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Ingredient createIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	@Override
	public void deleteIngredient(int id) {
		ingredientRepository.deleteById((long) id);
	}

	@Override
	public void updateIngredient(Ingredient ingredient) {
		Ingredient i = getIngredientById(ingredient.getId());
		if (i != null) {
			i.setNom(ingredient.getNom());
			ingredientRepository.save(i);
		}
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}

	@Override
	public Ingredient getIngredientById(int id) {
		return ingredientRepository.getIngredientById(id);
	}

	@Override
	public List<Ingredient> getIngredientByNom(String nom) {
		return ingredientRepository.getIngredientByNom(nom);
	}

}
