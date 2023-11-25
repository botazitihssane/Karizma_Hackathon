package com.karizma.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karizma.project.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	@Query("Select i from Ingredient i where i.id=:id")
	Ingredient getIngredientById(@Param("id") int id);
	
	List<Ingredient> getIngredientByNom(@Param("nom") String nom);
}