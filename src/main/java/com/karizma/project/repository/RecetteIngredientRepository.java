package com.karizma.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;
import com.karizma.project.model.RecetteIngredient;

@Repository
public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Long> {
	List<RecetteIngredient> findByRecette(Recette recette);

	List<RecetteIngredient> findByIngredient(Ingredient ingredient);

	@Query("Select ri from RecetteIngredient ri where ri.id=:id")
	RecetteIngredient getRecetteIngredientById(@Param("id") int id);
}