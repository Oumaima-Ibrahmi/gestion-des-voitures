package com.oumaima.voitures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumaima.voitures.entities.Voiture;
import com.oumaima.voitures.repos.VoitureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;




	
	
	@Service
	public class VoitureServiceImpl implements VoitureService {

		@Autowired
		VoitureRepository voitureRepository;
		@Override
		public Voiture saveVoiture(Voiture v) {
			// TODO Auto-generated method stub
			return voitureRepository.save(v);
		}

		@Override
		public Voiture updateVoiture(Voiture v) {
			// TODO Auto-generated method stub
			return voitureRepository.save(v);
		}

		@Override
		public void deleteVoiture(Voiture v) {
			// TODO Auto-generated method stub
			voitureRepository.delete(v);
		}

		@Override
		public void deleteVoitureById(Long id) {
			// TODO Auto-generated method stub
			voitureRepository.deleteById(id);
			
		}

		@Override
		public Voiture getVoiture(Long id) {
			// TODO Auto-generated method stub
			return voitureRepository.findById(id).get();
		}

		@Override
		public List<Voiture> getAllVoitures() {
			// TODO Auto-generated method stub
			return voitureRepository.findAll();
		}
		@Override
		public Page<Voiture> getAllVoituresParPage(int page, int size) {
		      return voitureRepository.findAll(PageRequest.of(page, size));
		}

	}
