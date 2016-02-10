package com.footbook.app.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Poste;
@Transactional
public class JoueurMetierImpl implements JoueurMetier {

	/**
	 * Footbook Dao du joueurMetier
	 */
	@Autowired
	private FootbookDao fbDao;
	
	/**
	 *  renvoie le fbDao du joueurMetier
	 * @return fbDao du joueurMetier
	 */
	public FootbookDao getFbDao() {
		return fbDao;
	}
	
	/**
	 * Modifie le fbDao du joueurMetier
	 * @param fbDao nouveau fbDao
	 */
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}
	
	/**
	 * Ajoute un joueur a la fbDao
	 * @param joueur ajouter a la fbDao
	 */
	@Override
	public Long ajouterJoueur(Joueur j) {
		// TODO Auto-generated method stub
		fbDao.ajouterJoueur(j);
		return j.getIdJoueur();
	}
	
	/**
	 * modifie le joueur de la fbDao
	 */
	@Override
	public void modifierJoueur(Joueur j) {
		// TODO Auto-generated method stub
		fbDao.modifierJoueur(j);
	}
	
	/**
	 * renvoie la liste de joueurs de la fbDao
	 * @param liste de joueur de la fbDao
	 */
	@Override
	public List<Joueur> listJoueurs() {
		// TODO Auto-generated method stub
		return fbDao.listJoueurs();
	}
	
	/**
	 * renvoie l'ID du joueur lié a l'user
	 * @param email de l'user
	 * @return ID du joueur lié a l'user
	 */
	@Override
	public Long getIDJoueurFromUser(String email) {
		// TODO Auto-generated method stub
		return fbDao.getIDJoueurFromUser(email);
	}
	
	/**
	 * renvoie le joueur 
	 * @param ID du joueur
	 * @return le joueur
	 */
	@Override
	public Joueur getJoueur(Long idJoueur) {
		// TODO Auto-generated method stub
		return fbDao.getJoueur(idJoueur);
	}

	/**
	 * Renvoie la liste des joueurs lié au departement
	 * @param le département
	 * @param la liste des joueur du departement
	 */
	@Override
	public List<Joueur> listJoueurs(String departement) {
		// TODO Auto-generated method stub
		return fbDao.listJoueurs(departement);
	}
	
	/**
	 * renvoie la liste des postes du joueur
	 * @param id du joueur
	 * @return la liste des poste du joueur
	 */
	@Override
	public List<Poste> postesJoueur(Long idJoueur) {
		// TODO Auto-generated method stub
		return fbDao.postesJoueur(idJoueur);
	}

	/**
	 * renvoie la liste des championnats du joueur
	 * @param id du joueur
	 * @return la liste des championnats du joueur
	 */
	@Override
	public List<Championnat> championnatsJoueur(Long idJoueur) {
		// TODO Auto-generated method stub
		return fbDao.championnatsJoueur(idJoueur);
	}
	
	/**
	 * renvoie la liste des joueurs d'une ville
	 * @param nom de la ville
	 * @return liste des joueur de la ville
	 */
	@Override
	public List<Joueur> listJoueursVille(String ville) {
		// TODO Auto-generated method stub
		return fbDao.listJoueursVille(ville);
	}

}
