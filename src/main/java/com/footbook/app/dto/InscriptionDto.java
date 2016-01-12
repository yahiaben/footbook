package com.footbook.app.dto;

import java.util.Collection;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Sexe;

public class InscriptionDto {
	private String nom;
    
    private String prenom;
    
    private Sexe sexeJoueur;
    
    private String description;
    
    private String email;
    
    private Collection<Championnat> mesChampionnats;
    
    private String userName;
    
    private String password;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Sexe getSexeJoueur() {
		return sexeJoueur;
	}

	public void setSexeJoueur(Sexe sexeJoueur) {
		this.sexeJoueur = sexeJoueur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Championnat> getMesChampionnats() {
		return mesChampionnats;
	}

	public void setMesChampionnats(Collection<Championnat> mesChampionnats) {
		this.mesChampionnats = mesChampionnats;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
