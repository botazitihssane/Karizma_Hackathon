package com.karizma.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karizma.project.model.Ingredient;
import com.karizma.project.model.Recette;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
	@Query("Select r from Recette r where r.id=:id")
	Recette getRecetteById(@Param("id") int id);

	List<Recette> findByNom(String nom);

	List<Recette> findByDuree(int duree);

	@Query("SELECT DISTINCT r FROM Recette r JOIN r.ingredients i WHERE i IN :ingredients")
	List<Recette> findByIngredients(@Param("ingredients") List<Ingredient> ingredients);

}