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

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;
import com.karizma.project.model.RecetteIngredient;
import com.karizma.project.service.RecetteIngredientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecetteIngredientController {
	@Autowired
	RecetteIngredientService recetteIngredientService;

	@PostMapping(value = "/recetteingredient", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<RecetteIngredient> createRecetteIngredient(
			@Valid @RequestBody RecetteIngredient recetteIngredient) {
		RecetteIngredient result = recetteIngredientService.createRecetteIngredient(recetteIngredient);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@DeleteMapping(value = "/recetteingredient/{recetteingredientId}")
	public ResponseEntity<Void> deleteRecette(@PathVariable int recetteingredient) {
		recetteIngredientService.deleteRecetteIngredient(recetteingredient);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/recetteingredient", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateRecette(@Valid @RequestBody RecetteIngredient recetteIngredient) {
		recetteIngredientService.updateRecetteIngredient(recetteIngredient);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/recetteingredient/id/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getRecetteIngredientByID(@PathVariable int id) {
		try {
			RecetteIngredient r = recetteIngredientService.getRecetteIngredientByID(id);
			return ResponseEntity.ok(r);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}

	@GetMapping(value = "/recetteingredient/recette/{recette}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getByRecette(@PathVariable Recette recette) {
		try {
			List<RecetteIngredient> r = recetteIngredientService.findByRecette(recette);
			return ResponseEntity.ok(r);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}

	@GetMapping(value = "/recetteingredient/ingredient/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getByIngredient(@PathVariable Ingredient ingredient) {
		try {
			List<RecetteIngredient> r = recetteIngredientService.findByIngredient(ingredient);
			return ResponseEntity.ok(r);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}

	@GetMapping(value = "/recetteingredient/all", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getAll() {
		try {
			List<RecetteIngredient> r = recetteIngredientService.getAllRecetteIngredient();
			return ResponseEntity.ok(r);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}
}
