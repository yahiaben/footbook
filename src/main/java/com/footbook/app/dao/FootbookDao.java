package com.footbook.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Poste;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.User;
import com.footbook.app.entities.Ville;

public interface FootbookDao {
	//Methode pour ajouter un joueur
	public Long ajouterJoueur(Joueur j);
	
	//Methode pour modifier un joueur
	public void modifierJoueur(Joueur j);
	
	//Methode pour recupérer la liste des joueurs
	public List<Joueur> listJoueurs();
	
	//Methode pour récupérer un joueur
	public Joueur getJoueur(Long idJoueur);
	
	//Methode pour récupérer les postes d'un joueur
	public List<Poste> postesJoueur(Long idJoueur);
	
	/*public void supprimerJoueur(Long idJoueur);
	
	
	public Championnat getChampionnat(long idChampionnat);
	*/
	
	//Methode pour ajouter un user
	public void ajouterUser(User u);
	
	//Methode pour modifeir un user
	public void modifierUser(User u);
	
	//Methode pour attribuer un role a un user
	public void attribuerRole(Role r, Long userID);
	
	//Methode pour récupérer la liste des villes
	public List<Ville> listVilles();
	
	//Methode pour récupérer les villes commençant par "ville"
	public List<Ville> searchVilles(String ville);
	
	//Methode pour récuperer le departement d'une ville
	public String departementDeLaVille(String ville);
	
	//Methode pour récupérer l'ID d'un joueur depuis son mail
	public Long getIDJoueurFromUser(String email);
	
	//Methode pour récupérer les joueur d'un département
	public List<Joueur> listJoueurs(String departement);
	
	//Methode pour récupérer un user depuis un ID
	public User getUser(Long idUser);
	
	//Methode pour récupérer la liste de championnats  d'un joueur depuis son ID
	public List<Championnat> championnatsJoueur(Long idJoueur);
	
	//Methode pour récupérer les joueurs d'une ville
	public List<Joueur> listJoueursVille(String ville);
}
