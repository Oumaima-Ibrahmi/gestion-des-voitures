package com.oumaima.voitures;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oumaima.voitures.entities.Voiture;
import com.oumaima.voitures.service.VoitureService;

@SpringBootApplication
public class VoituresApplication {
	VoitureService voitureService;

	public static void main(String[] args) {
		SpringApplication.run(VoituresApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		
		voitureService.saveVoiture(new Voiture("Kia",26000.0,new Date()));
		voitureService.saveVoiture(new Voiture("peugeot",26000.0,new Date()));
		voitureService.saveVoiture(new Voiture("Ford",26000.0,new Date()));
	}

}
