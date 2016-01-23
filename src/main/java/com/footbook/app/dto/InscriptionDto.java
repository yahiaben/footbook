package com.footbook.app.dto;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Sexe;

public class InscriptionDto {
	
	@NotNull
	@Size(min=1, max=25, message="Le nom doit être compris entre 1 et 25 caractéres")
	private String nom;
    
	@NotNull
	@Size(min=1, max=25, message="Le prenom doit être compris entre 1 et 25 caractéres")
    private String prenom;
    
    private Sexe sexeJoueur;
    
    @NotNull
	@Size(min=1, max=250, message="La description doit être comprise entre 10 et 250 caractéres")
    private String description;
    
    @NotNull
    @Email(message="veuillez entrer un email valide !")
    private String email;
    
    private Collection<Championnat> mesChampionnats;
    
    private String userName;
    
    @NotNull
    @Size(min=8, max=15, message="Le mot de passe doit être compris entre 8 et 15 caractéres")
    private String password;
    
    private String ville;

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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
    
}
