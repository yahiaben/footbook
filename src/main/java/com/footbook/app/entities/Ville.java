package com.footbook.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="villes")
public class Ville {

	/**
	 * id de la ville
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ville_id")
	private Long ville_id;
	
	/**
	 * nom du departemet de la ville
	 */
	private String ville_departement;
	
	/**
	 * nom de la ville
	 */
	private String ville_nom;

	
	/**
	 * construteur de la ville
	 */
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * constructeur de la ville
	 * @param ville_departement departement de la ville
	 * @param ville_nom nom de la ville
	 */
	public Ville(String ville_departement, String ville_nom) {
		super();
		this.ville_departement = ville_departement;
		this.ville_nom = ville_nom;
	}


	/**
	 * renvoie departement de la ville
	 * @return le departement de la ville
	 */
	public String getVille_departement() {
		return ville_departement;
	}

	/**
	 * modifie le departement de la ville
	 * @param ville_departement
	 */
	public void setVille_departement(String ville_departement) {
		this.ville_departement = ville_departement;
	}

	/**
	 * renvoie le nom de la ville
	 * @return nom de la ville
	 */
	public String getVille_nom() {
		return ville_nom;
	}

	/**
	 * modifie le nom de la ville
	 * @param ville_nom
	 */
	public void setVille_nom(String ville_nom) {
		this.ville_nom = ville_nom;
	}
	
	
}
