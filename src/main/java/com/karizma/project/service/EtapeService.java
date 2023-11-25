package com.karizma.project.service;

import com.karizma.project.model.Etape;

public interface EtapeService {
	Etape createEtape(Etape etape);

	void deleteEtape(int id);

	void updateEtape(Etape etape);

	Etape getEtape(int id);
}
