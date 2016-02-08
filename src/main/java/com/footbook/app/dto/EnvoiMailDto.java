package com.footbook.app.dto;

public class EnvoiMailDto {
	
	private String nom;
	private String emailEnvoyeur;
	private String emailReceveur;
	private String objet;
	private String contenu;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmailEnvoyeur() {
		return emailEnvoyeur;
	}
	public void setEmailEnvoyeur(String emailEnvoyeur) {
		this.emailEnvoyeur = emailEnvoyeur;
	}
	public String getEmailReceveur() {
		return emailReceveur;
	}
	public void setEmailReceveur(String emailReceveur) {
		this.emailReceveur = emailReceveur;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	
	
	
}
