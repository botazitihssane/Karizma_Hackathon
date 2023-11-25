package com.karizma.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karizma.project.exception.NotFoundException;
import com.karizma.project.model.Etape;
import com.karizma.project.repository.EtapeRepository;
import com.karizma.project.service.EtapeService;

@Service
public class EtapeServiceImpl implements EtapeService {

	@Autowired
	private EtapeRepository etapeRepository;

	@Override
	public Etape createEtape(Etape etape) {
		return etapeRepository.save(etape);
	}

	@Override
	public void deleteEtape(int id) {
		etapeRepository.deleteById((long) id);
	}

	@Override
	public void updateEtape(Etape etape) {
		Etape e = getEtape(etape.getId());
		if (e != null) {
			e.setNumero_Etape(etape.getNumero_Etape());
			e.setDescription(etape.getDescription());
			etapeRepository.save(e);
		}
	}

	@Override
	public Etape getEtape(int id) {
		return etapeRepository.findById((long) id)
				.orElseThrow(() -> new NotFoundException("Étape non trouvée avec l'ID : " + id));
	}

}
