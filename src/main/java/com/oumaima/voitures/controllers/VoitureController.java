package com.oumaima.voitures.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumaima.voitures.entities.Voiture;
import com.oumaima.voitures.service.VoitureService;
;

@Controller
public class VoitureController {
	
	@Autowired
		VoitureService voitureService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createVoiture";
	}
	
	
	@RequestMapping("/saveVoiture")
	public String saveVoiture(@ModelAttribute("voiture") Voiture voiture,
	                                   @RequestParam("date") String date,
	                                            ModelMap modelMap) throws
	ParseException
	{
	
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 voiture.setDateCreation(dateCreation);

	Voiture saveVoiture = voitureService.saveVoiture(voiture);
	String msg ="produit enregistré avec Id "+saveVoiture.getVoitureId();
	modelMap.addAttribute("msg", msg);
	return "createVoiture";
	}
	
	@RequestMapping("/ListeVoitures")
	public String listeVoitures(ModelMap modelMap)
	{
	List<Voiture> voit =voitureService.getAllVoitures();
	modelMap.addAttribute("voitures", voit);
	return "listeVoitures";
	}
	
	@RequestMapping("/supprimerVoiture")
	public String supprimerVoiture(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
	voitureService.deleteVoitureById(id);
	List<Voiture> voit= voitureService.getAllVoitures();
	modelMap.addAttribute("produits", voit);
	return "listeVoitures";
	}
	
	
	@RequestMapping("/modifierVoiture")
	public String editerVoiture(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Voiture p= voitureService.getVoiture(id);
	modelMap.addAttribute("voiture", p);
	return "editerVoiture";
	}
	@RequestMapping("/updateVoiture")
	public String updateProduit(@ModelAttribute("produit") Voiture voiture,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		voiture.setDateCreation(dateCreation);

		 voitureService.updateVoiture(voiture);
		 List<Voiture> prods = voitureService.getAllVoitures();
		 modelMap.addAttribute("produits", prods);
		return "listeProduits";
		}
	

	}
