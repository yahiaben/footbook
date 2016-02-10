package com.footbook.app.entities;

import java.io.Serializable;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Cette classe contient toute les information d'un user avec les methodes GET et SET
 * @author scof
 *
 */

@Entity
@Table(name="users")
public class User implements Serializable {
	
	/**
	 * ID de l'user
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long idUser;
	
	/**
	 * email de l'user
	 */
	@Column(name="email", unique = true)
	private String email;
	
	/**
	 * Mdp de l'user
	 */
	private String password;
	
	/**
	 * activation de l'user
	 */
	private boolean actived = true;
	
	/**
	 * role de l'user
	 */
	@OneToMany
	@JoinColumn(name="user_id")
	private Collection<Role> roles;
	
	/**
	 * joueur lié a l'user
	 */
	@OneToOne
	@JoinColumn(name="joueur_id")
	private Joueur joueur;
	
	/**
	 * constructeur de l'user
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * construeur de l'user
	 * @param email de l'user
	 * @param password de l'user
	 * @param actived de l'user
	 */
	public User(String email, String password, boolean actived) {
		super();
		this.email = email;
		this.password = password;
		this.actived = actived;
	}
	
	/**
	 * renvoie l'id de l'user
	 * @return id de l'user
	 */
	public Long getIdUser() {
		return idUser;
	}
	
	/**
	 * modifie l'ID de l'user
	 * @param idUser id de l'user
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * renvoie l'email de l'user
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Modifie l'email de l'user
	 * @param email de l'user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * renvoie le mdp de l'user
	 * @returnmdp de l'user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Modifie le mdp de l'user
	 * @param password nouveau mdp de l'user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * renvoie le joueur lié a l'user
	 * @return joueur lié a l'user
	 */
	public Joueur getJoueur() {
		return joueur;
	}
	
	/**
	 * modifie le joueur de l'user
	 * @param joueur
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	/**
	 * renvoie si l'user est actif
	 * @return renvoie si l'user est actif
	 */
	public boolean isActived() {
		return actived;
	}
	
	/**
	 * modifie l'activation de l'user
	 * @param actived
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	/**
	 * renvoie les roles lié a l'user
	 * @return les roles de l'user
	 */
	public Collection<Role> getRoles() {
		return roles;
	}
	
	/**
	 * modifie les role de l'user
	 * @param roles le nouveau de role de l'user
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
