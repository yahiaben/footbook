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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ville_id")
	private Long ville_id;
	
	private String ville_departement;
	
	private String ville_nom;

	
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Ville(String ville_departement, String ville_nom) {
		super();
		this.ville_departement = ville_departement;
		this.ville_nom = ville_nom;
	}



	public String getVille_departement() {
		return ville_departement;
	}

	public void setVille_departement(String ville_departement) {
		this.ville_departement = ville_departement;
	}

	public String getVille_nom() {
		return ville_nom;
	}

	public void setVille_nom(String ville_nom) {
		this.ville_nom = ville_nom;
	}
	
	
}
