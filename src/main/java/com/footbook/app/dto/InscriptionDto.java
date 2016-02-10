package com.footbook.app.dto;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Poste;
import com.footbook.app.entities.Sexe;

/**
 * @author yahia
 * la dto est utilisee pour l'inscription du joueur avec l'ensemble des infos
 */
public class InscriptionDto {
	

	/**
	 * Le nom du joueur
	 */
	@NotNull
	@Size(min=1, max=25, message="Le nom doit être compris entre 1 et 25 caractéres")
	private String nom;
    
	/**
	 * Le prenom du joueur
	 */
	@NotNull
	@Size(min=1, max=25, message="Le prenom doit être compris entre 1 et 25 caractéres")
	private String prenom;
	
	/**
	 * @return les postes du joueurs
	 */
	public Collection<Poste> getMesPostes() {
		return mesPostes;
	}

	
	/**
	 * @param mesPostes les postes du joueur
	 */
	public void setMesPostes(Collection<Poste> mesPostes) {
		this.mesPostes = mesPostes;
	}

	/**
	 * mesPostes, la liste de postes du joueur
	 */
	private Collection<Poste> mesPostes;
    
    /**
     * sexeJoueur, le genre du joueur
     */
    private Sexe sexeJoueur;
    
    /**
     * description, la description du joueur
     */
    @NotNull
	@Size(min=1, max=250, message="La description doit être comprise entre 10 et 250 caractéres")
    private String description;
    
    /**
     * email, le mail du joueur
     */
    @NotNull
    @Email(message="veuillez entrer un email valide !")
    private String email;
    
    /**
     * mesChampionnats, les championnats du joueur
     */
    private Collection<Championnat> mesChampionnats;
    
    /**
     * userName, le nom du joueur
     */
    private String userName;
    
    /**
     * password, le mot de passe du joueur
     */
    @NotNull
    @Size(min=8, max=15, message="Le mot de passe doit être compris entre 8 et 15 caractéres")
    private String password;
    
    /**
     * ville, la ville du joueur
     */
    @NotNull
    private String ville;

	/**
	 * @return le nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom le nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return le prenom du joueur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom le prenom du joueur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return le sexe du joueur
	 */
	public Sexe getSexeJoueur() {
		return sexeJoueur;
	}

	/**
	 * @param sexeJoueur le sexe du joueur
	 */
	public void setSexeJoueur(Sexe sexeJoueur) {
		this.sexeJoueur = sexeJoueur;
	}

	/**
	 * @return la description du joueur
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description, la description du joueur
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return le mail du joueur
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email, le mail du joueur
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return les championnats du joueur
	 */
	public Collection<Championnat> getMesChampionnats() {
		return mesChampionnats;
	}

	/**
	 * @param mesChampionnats, les championnats du joueur
	 */
	public void setMesChampionnats(Collection<Championnat> mesChampionnats) {
		this.mesChampionnats = mesChampionnats;
	}

	/**
	 * @return le nom de l'utilisateur
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName le nom de l'utilisateur
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return le password de l'utilisateur
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password, le password de l'utilisateur
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return la ville du joueur
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville, la ville du joueur
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
    
}
