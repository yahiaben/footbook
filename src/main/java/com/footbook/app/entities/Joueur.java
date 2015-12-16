package com.footbook.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="joueurs")
public class Joueur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="joueur_id")
	private Long idJoueur;
	@NotEmpty
	@Size(min=4, max=20)
	private String pseudo;
	@NotEmpty
	@Size(min=10)
	private String description;
	
	private String email;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ElementCollection
	@Column(name = "championnat", nullable = false)
	@Enumerated(EnumType.STRING)
	private Collection<Championnat> mesChampionnats;
	
	@Enumerated(EnumType.STRING)
	private Sexe sexeJoueur; 
	
	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Joueur(String pseudo, String description, String email, byte[] photo, String nomPhoto,Collection<Championnat> mesChampionnats, Sexe sexeJoueur) {
		super();
		this.pseudo = pseudo;
		this.description = description;
		this.email = email;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
		this.mesChampionnats = mesChampionnats;
		this.sexeJoueur = sexeJoueur;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Championnat> getMesChampionnats() {
		return mesChampionnats;
	}

	public void setMesChampionnats(Collection<Championnat> mesChampionnats) {
		this.mesChampionnats = mesChampionnats;
	}
	
	public Long getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
}
