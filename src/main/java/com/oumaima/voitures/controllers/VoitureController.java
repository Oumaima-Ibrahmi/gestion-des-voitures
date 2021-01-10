package com.oumaima.voitures.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import com.oumaima.voitures.entities.Voiture;
import com.oumaima.voitures.service.VoitureService;
;

@Controller
public class VoitureController implements CommandLineRunner {
	
	@Autowired
	VoitureService voitureService;
	
	@Override
	public void run(String... args) throws Exception {
		voitureService.saveVoiture(new Voiture("Range Rover", 3000.0, new Date()));
		voitureService.saveVoiture(new Voiture("BM", 5552.0, new Date()));
		voitureService.saveVoiture(new Voiture("Toyota", 4420.0, new Date()));
		
	}
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVoiture";
	}
	
	@RequestMapping("/saveVoiture")
		public String saveVoiture(@ModelAttribute("voiture") Voiture voiture,
				@RequestParam("date") String date,
				ModelMap modelMap) throws ParseException{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		voiture.setDateCreation(dateCreation);
		
		Voiture saveVoiture = voitureService.saveVoiture(voiture);
		String msg = "voiture enregistré avec Id"+saveVoiture.getIdVoiture();
		modelMap.addAttribute("msg",msg);
		List<Voiture> cars= voitureService.getAllVoitures();
		modelMap.addAttribute("voitures",cars);
		return "listeVoitures";
	}
	
	@RequestMapping("/ListeVoitures")
	public String listeVoiture(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Page<Voiture> cars = voitureService.getAllVoituresParPage(page, size);
		modelMap.addAttribute("voitures", cars);
		modelMap.addAttribute("pages", new int[cars.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVoitures";
	}
	@RequestMapping("/supprimerVoiture")
	public String supprimerVoiture(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		voitureService.deleteVoitureById(id);
		Page<Voiture> cars=voitureService.getAllVoituresParPage(page, size);
		modelMap.addAttribute("voitures", cars);
		modelMap.addAttribute("pages", new int[cars.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		
		
		return "listeVoitures";
	}
	
	@RequestMapping("/modifierVoiture")
	public String editerVoiture(@RequestParam("id") Long id,
			ModelMap modelMap) {
		Voiture v = voitureService.getVoiture(id);
		modelMap.addAttribute("voiture", v);
		return "editerVoiture";
	}
	
	@RequestMapping("/updateVoiture")
	public String updateVoiture(@ModelAttribute("voiture") Voiture voiture,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		voiture.setDateCreation(dateCreation);
		
		voitureService.updateVoiture(voiture);
		List<Voiture> cars= voitureService.getAllVoitures();
		modelMap.addAttribute("voitures",cars);
		return "listeVoitures";
	}

	
}
