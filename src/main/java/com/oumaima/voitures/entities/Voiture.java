package com.oumaima.voitures.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Voiture {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long voitureId;
	private String voitureCouleur;
	private Date dateCreation;
	private String marqueVoiture;
	private Double prixVoiture;
	
	public Voiture(String voitureCouleur, Date dateCreation, String marqueVoiture, Double prixVoiture) {
		super();
		this.voitureCouleur = voitureCouleur;
		this.dateCreation = dateCreation;
		this.marqueVoiture = marqueVoiture;
		this.prixVoiture = prixVoiture;
	}

	public Voiture() {
		super();
		
	}

	public Long getVoitureId() {
		return voitureId;
	}

	public void setVoitureId(Long voitureId) {
		this.voitureId = voitureId;
	}

	public String getVoitureCouleur() {
		return voitureCouleur;
	}

	public void setVoitureCouleur(String voitureCouleur) {
		this.voitureCouleur = voitureCouleur;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getMarqueVoiture() {
		return marqueVoiture;
	}

	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public Double getPrixVoiture() {
		return prixVoiture;
	}

	public void setPrixVoiture(Double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}

	@Override
	public String toString() {
		return "Voiture [voitureId=" + voitureId + ", voitureCouleur=" + voitureCouleur + ", dateCreation="
				+ dateCreation + ", marqueVoiture=" + marqueVoiture + ", prixVoiture=" + prixVoiture + "]";
	}
	
	
	
	
	
}
