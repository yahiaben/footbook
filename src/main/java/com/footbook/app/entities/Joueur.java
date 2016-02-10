package com.footbook.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	/**
	 * ID du joueur
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="joueur_id")
	private Long idJoueur;
	
	/**
	 * nom du joueur
	 */
	@NotEmpty
	@Size(min=4, max=20)
	private String nom;
	
	/**
	 * prenom du joueur
	 */
	@NotEmpty
	@Size(min=4, max=20)
	private String prenom;
	
	/**
	 * description du joueur
	 */
	@NotEmpty
	@Size(min=10)
	private String description;
	
	/**
	 * email du joueur
	 */
	private String email;
	
	@Lob
	private byte[] photo;
	
	/**
	 * nom de la photo du joueur
	 */
	private String nomPhoto;
	@OneToOne
	@JoinColumn(name="user_id")
	
	/**
	 * user lié au joueur
	 */
	private User user;
	
	/**
	 * championnats du joueur
	 */
	@ElementCollection
	@Column(name = "championnat", nullable = false)
	@Enumerated(EnumType.STRING)
	private Collection<Championnat> mesChampionnats;
	
	/**
	 * sexe du joueur
	 */
	@Enumerated(EnumType.STRING)
	private Sexe sexeJoueur; 
	
	/**
	 * departement du joueur
	 */
	private String departement;
	
	/**
	 * ville du joueur
	 */
	private String ville;
	
	/**
	 * postes du joueur
	 */
	@ElementCollection
	@Column(name = "poste", nullable = false)
	@Enumerated(EnumType.STRING)
	private Collection<Poste> mesPostes;
	
	
	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructeur d'un joueur
	 * @param nom du joueur
	 * @param prenom du joueur
	 * @param postes du joueur
	 * @param description du joueur
	 * @param email du joueur
	 * @param photo du joueur
	 * @param nomPhoto du joueur
	 * @param mesChampionnats du joueur
	 * @param sexeJoueur du joueur
	 * @param departement du joueur
	 * @param ville du joueur
	 */
	public Joueur(String nom,String prenom, Collection<Poste> postes, String description, String email, byte[] photo, String nomPhoto,Collection<Championnat> mesChampionnats, Sexe sexeJoueur, String departement, String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mesPostes = postes;
		this.description = description;
		this.email = email;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
		this.mesChampionnats = mesChampionnats;
		this.sexeJoueur = sexeJoueur;
		this.ville = ville;
		this.departement = departement;
	}
	
	/**
	 * renvoie les postes du joueur
	 * @return
	 */
	public Collection<Poste> getMesPostes() {
		return mesPostes;
	}

	/**
	 * Modifie la liste des postes du joueur
	 * @param mesPostes les nouveaux postes du joueur
	 */
	public void setMesPostes(Collection<Poste> mesPostes) {
		this.mesPostes = mesPostes;
	}
	
	/**
	 * renvoie l'utilisateur lié au joueur
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * modifie l'user du joueur
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * renvoie la liste des championnats du joueur
	 * @return
	 */
	public Collection<Championnat> getMesChampionnats() {
		return mesChampionnats;
	}

	/**
	 * modifie la liste des championnats du joueur
	 * @param mesChampionnats les nouveaux championnats
	 */
	public void setMesChampionnats(Collection<Championnat> mesChampionnats) {
		this.mesChampionnats = mesChampionnats;
	}
	
	/**
	 * renvoie l'id du joueur
	 * @return
	 */
	public Long getIdJoueur() {
		return idJoueur;
	}
	
	/**
	 * modifie l'id du joueur
	 * @param idJoueur
	 */
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	/**
	 * renvoie la description du joueur
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * modifie la description du joueur
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * renvoie le mail du joueur
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * modifie l'email du joueur
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	/**
	 * renvoie le nom de la photo du joueur
	 * @return nom du joueur
	 */
	public String getNomPhoto() {
		return nomPhoto;
	}
	
	/**
	 * modifie le nom de la photo du joueur
	 * @param nomPhoto nouveau nom du joueur
	 */
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	/**
	 * renvoie le sexe du joueur
	 * @return le sexe du joueur
	 */
	public Sexe getSexeJoueur() {
		return sexeJoueur;
	}
	
	/**
	 * modifie le sexe du joueur
	 * @param sexeJoueur sexe du joueur
	 */
	public void setSexeJoueur(Sexe sexeJoueur) {
		this.sexeJoueur = sexeJoueur;
	}

	/**
	 * renvoie le nom du joueur
	 * @return le nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * modifie le nom du joueur
	 * @param nom nouveau nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * renvoie le prenom du joueur
	 * @return prenom du joueur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * modifie le prenom du joueur
	 * @param prenom du joueur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * renvoie le departement du joueur
	 * @return departement du joueur
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * modifie le departement du joueur
	 * @param departement nouveau deparrtement du joueur
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * renvoie la ville du joueur
	 * @return ville du joueur
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * modifie la ville du joueur
	 * @param ville nouvel ville du joueur
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * verifie si le joueur contient le poste
	 * @param poste
	 * @return selected si le joueur contient le poste
	 */
	public String hasPoste(String poste){
		if(this.mesPostes.contains(poste)){
			return "selected";
		}
		return "";
	}
	
	/**
	 * verifie si le joueur contient le championnat c
	 * @param c
	 * @return selected si le jpoueur contient le championnats
	 */
	public String hasChampionnat(String c){
		if(this.mesChampionnats.contains(c)){
			return "selected";
		}
		return "";
	}
	
}
