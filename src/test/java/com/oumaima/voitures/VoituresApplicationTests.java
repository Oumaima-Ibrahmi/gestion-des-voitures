package com.oumaima.voitures;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oumaima.voitures.entities.Voiture;
import com.oumaima.voitures.repos.VoitureRepository;
import java.util.Date;
import java.util.List;

@SpringBootTest
class VoituresApplicationTests {

	@Autowired
	private VoitureRepository voitureRepository;
	
	@Test 
	public void testsaveVoiture() {
		Voiture v1=new Voiture("Black",new Date(),"Toyota",700.500);
		
		voitureRepository.save(v1);
		
	}
	
	@Test 
	public void testCreateVoiture2() {
		
		Voiture v2=new Voiture("Red",new Date(),"Audi",121.00);
		
		voitureRepository.save(v2);
	}
	
	
	@Test
	public void testGetVoiture() {
		Voiture v=voitureRepository.findById(1L).get();
		System.out.println(v);
		
		
	}
	
	@Test
	public void testUpdateVoiture() {
		Voiture voiture=voitureRepository.findById(1L).get();
		voiture.setVoitureCouleur("purple");
		voitureRepository.save(voiture);	
		System.out.println(voiture);
	}
	
	@Test
	public void testDeleteVoitureById() {
		voitureRepository.deleteById(1L);
	}
	
	@Test
	public void testGetAllVoitures() 
	{
		List<Voiture> voit=voitureRepository.findAll();
		for(Voiture v:voit)
			System.out.println(v);
	}
	
	
	
	
	

}
