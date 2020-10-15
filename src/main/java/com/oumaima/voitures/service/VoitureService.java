package com.oumaima.voitures.service;

import java.util.List;

import com.oumaima.voitures.entities.Voiture;

public interface VoitureService {
	
	Voiture saveVoiture(Voiture v);
	Voiture updateVoiture(Voiture v);
	void deleteVoiture(Voiture v);
	void deleteVoitureById(Long id );
	Voiture getVoiture(Long id );
	List<Voiture> getAllVoitures();
}