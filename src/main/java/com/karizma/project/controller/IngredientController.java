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
import com.karizma.project.service.IngredientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class IngredientController {
	@Autowired
	private IngredientService ingredientService;

	@PostMapping(value = "/ingredient", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Ingredient> createAnnexe(@Valid @RequestBody Ingredient ingredient) {
		Ingredient result = ingredientService.createIngredient(ingredient);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@DeleteMapping(value = "/ingredient/{ingredientId}")
	public ResponseEntity<Void> deleteIngredient(@PathVariable int ingredientId) {
		ingredientService.deleteIngredient(ingredientId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/ingredient/", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Void> updateIngredient(@Valid @RequestBody Ingredient ingredient) {
		ingredientService.updateIngredient(ingredient);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "ingredient/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getIngredient(@PathVariable int id) {
		try {
			Ingredient ingredient = ingredientService.getIngredientById(id);
			return ResponseEntity.ok(ingredient);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrédient non trouvé avec l'ID : " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}

	@GetMapping(value = "ingredient/nom/{nom}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getIngredientByNom(@PathVariable String nom) {
		try {
			List<Ingredient> ingredients = ingredientService.getIngredientByNom(nom);
			return ResponseEntity.ok(ingredients);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}
	}
}
