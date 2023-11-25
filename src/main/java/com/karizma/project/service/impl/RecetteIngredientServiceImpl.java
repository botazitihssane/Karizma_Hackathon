package com.karizma.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;
import com.karizma.project.model.RecetteIngredient;
import com.karizma.project.repository.RecetteIngredientRepository;
import com.karizma.project.service.RecetteIngredientService;

@Service
public class RecetteIngredientServiceImpl implements RecetteIngredientService {

	@Autowired
	private RecetteIngredientRepository recetteIngredientRepository;

	@Override
	public RecetteIngredient createRecetteIngredient(RecetteIngredient recetteIngredient) {
		return recetteIngredientRepository.save(recetteIngredient);
	}

	@Override
	public List<RecetteIngredient> findByRecette(Recette recette) {
		return recetteIngredientRepository.findByRecette(recette);
	}

	@Override
	public List<RecetteIngredient> findByIngredient(Ingredient ingredient) {
		return recetteIngredientRepository.findByIngredient(ingredient);
	}

	@Override
	public List<RecetteIngredient> getAllRecetteIngredient() {
		return recetteIngredientRepository.findAll();
	}

	@Override
	public void deleteRecetteIngredient(int id) {
		recetteIngredientRepository.deleteById((long) id);
	}

	@Override
	public void updateRecetteIngredient(RecetteIngredient recetteIngredient) {
		RecetteIngredient ri = getRecetteIngredientByID(recetteIngredient.getId());
		if (ri != null) {
			ri.setRecette(recetteIngredient.getRecette());
			ri.setQuantite(recetteIngredient.getQuantite());
			ri.setIngredient(recetteIngredient.getIngredient());
			recetteIngredientRepository.save(ri);
		}
	}

	@Override
	public RecetteIngredient getRecetteIngredientByID(int id) {
		return recetteIngredientRepository.getRecetteIngredientById(id);
	}

}
