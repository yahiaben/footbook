package com.footbook.app.dao;

import java.util.List;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.User;

public interface FootbookDao {
	public Long ajouterJoueur(Joueur j);
	/*public List<Joueur> listJoueurs();
	public Joueur getJoueur(Long idJoueur);
	public void supprimerJoueur(Long idJoueur);
	public void modifierJoueur(Joueur j);
	
	public Championnat getChampionnat(long idChampionnat);
	*/
	public void ajouterUser(User u);
	public void attribuerRole(Role r, Long userID);
	
}
