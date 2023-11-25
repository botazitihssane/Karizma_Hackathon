package com.karizma.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karizma.project.exception.NotFoundException;
import com.karizma.project.model.Etape;
import com.karizma.project.service.EtapeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EtapeController {
	@Autowired
	EtapeService etapeService;

	@PostMapping(value = "/etape", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Etape> createAnnexe(@Valid @RequestBody Etape etape) {
		Etape result = etapeService.createEtape(etape);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@DeleteMapping(value = "/etape/{etapeId}")
	public ResponseEntity<Void> deleteEtape(@PathVariable int etapeId) {
		etapeService.deleteEtape(etapeId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/etape", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public ResponseEntity<Void> updateEtape(@Valid @RequestBody Etape etape) {
		etapeService.updateEtape(etape);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/etape/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getEtape(@PathVariable int id) {
		Etape etape;
		try {
			etape = etapeService.getEtape(id);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étape non trouvée avec l'ID : " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors du traitement de la requête : " + e.getMessage());
		}

		return ResponseEntity.ok(etape);
	}

}
