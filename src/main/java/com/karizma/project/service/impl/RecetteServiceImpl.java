package com.karizma.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;
import com.karizma.project.repository.RecetteRepository;
import com.karizma.project.service.RecetteService;

@Service
public class RecetteServiceImpl implements RecetteService {

	@Autowired
	private RecetteRepository recetteRepository;

	@Override
	public Recette createRecette(Recette recette) {
		return recetteRepository.save(recette);
	}

	@Override
	public Recette getRecetteByID(int id) {
		return recetteRepository.getRecetteById(id);
	}

	@Override
	public List<Recette> getRecettesByNom(String nom) {
		return recetteRepository.findByNom(nom);
	}

	@Override
	public List<Recette> getRecettesByDuree(int duree) {
		return recetteRepository.findByDuree(duree);
	}

	@Override
	public List<Recette> getRecettesByIngredient(List<Ingredient> ingredients) {
		return recetteRepository.findByIngredients(ingredients);
	}

	@Override
	public void deleteRecette(int id) {
		recetteRepository.deleteById((long) id);
	}

	@Override
	public void updateRecette(Recette recette) {
		Recette r = getRecetteByID(recette.getId());
		if (r != null) {
			r.setDuree(recette.getDuree());
			r.setNom(recette.getNom());
			r.setPhoto(recette.getPhoto());
			r.setEtapes(r.getEtapes());
			r.setIngredients(r.getIngredients());
			recetteRepository.save(r);
		}
	}

	@Override
	public List<Recette> getAllRecettes() {
		return recetteRepository.findAll();
	}

}
