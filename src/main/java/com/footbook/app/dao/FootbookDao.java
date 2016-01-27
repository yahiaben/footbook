package com.footbook.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.User;
import com.footbook.app.entities.Ville;

public interface FootbookDao {
	public Long ajouterJoueur(Joueur j);
	public void modifierJoueur(Joueur j);
	public List<Joueur> listJoueurs();
	/*public Joueur getJoueur(Long idJoueur);
	public void supprimerJoueur(Long idJoueur);
	
	
	public Championnat getChampionnat(long idChampionnat);
	*/
	public void ajouterUser(User u);
	public void modifierUser(User u);
	public void attribuerRole(Role r, Long userID);
	
	public List<Ville> listVilles();
	public List<Ville> searchVilles(String ville);
	public String departementDeLaVille(String ville);
	public List<Joueur> listJoueurs(String departement);
}
