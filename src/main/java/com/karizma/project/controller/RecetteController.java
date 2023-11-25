package com.karizma.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karizma.project.exception.NotFoundException;
import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;
import com.karizma.project.service.RecetteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecetteController {
	@Autowired
	private RecetteService recetteService;

	@PostMapping(value = "/recette", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Recette> createRecette(@Valid @RequestBody Recette recette) {
		Recette result = recetteService.createRecette(recette);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@DeleteMapping(value = "/recette/{recetteId}")
	public ResponseEntity<Void> deleteRecette(@PathVariable int recetteId) {
		recetteService.deleteRecette(recetteId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/recette", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateRecette(@Valid @RequestBody Recette recette) {
		recetteService.updateRecette(recette);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/recette/nom/{nom}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getRecettesByNom(@PathVariable String nom) {
		try {
			List<Recette> recettes = recetteService.getRecettesByNom(nom);
			return ResponseEntity.ok(recettes);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recette non trouvée avec le nom : " + nom);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}

	@GetMapping(value = "recette/duree/{duree}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getRecettesByDuree(@PathVariable int duree) {
		try {
			List<Recette> recettes = recetteService.getRecettesByDuree(duree);
			return ResponseEntity.ok(recettes);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recette non trouvée avec la duree : " + duree);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}

	@GetMapping(value = "recette/ingredient", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getRecettesByIngredient(@RequestBody List<Ingredient> ingredients) {
		try {
			List<Recette> recettes = recetteService.getRecettesByIngredient(ingredients);
			return ResponseEntity.ok(recettes);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recette non trouvée avec les ingredients spécifiés : " );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}
}
