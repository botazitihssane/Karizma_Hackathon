package com.karizma.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karizma.project.model.Etape;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Long> {
	@Query("Select e from Etape e where e.id=:id")
	Etape getEtapeById(@Param("id") int id);

}