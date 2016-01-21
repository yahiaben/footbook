package com.footbook.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.User;
import com.footbook.app.entities.Ville;

public class FootbookDaoImpl implements FootbookDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long ajouterJoueur(Joueur j) {
		// TODO Auto-generated method stub
		//Championnat c = getChampionnat(idChampionnat);
		//j.getMesChampionnats().add(c);
		em.persist(j);
		return j.getIdJoueur();
	}

	@Override
	public void modifierJoueur(Joueur j) {
		// TODO Auto-generated method stub
		em.merge(j);
	}

	@Override
	public List<Joueur> listJoueurs() {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select * from joueurs j",Joueur.class);
		return req.getResultList();
	}

	/*@Override
	public Joueur getJoueur(Long idJoueur) {
		// TODO Auto-generated method stub
		return em.find(Joueur.class, idJoueur);
	}

	@Override
	public void supprimerJoueur(Long idJoueur) {
		// TODO Auto-generated method stub
		Joueur j = em.find(Joueur.class, idJoueur);
		em.remove(j);
		
	}

	@Override
	public void modifierJoueur(Joueur j) {
		// TODO Auto-generated method stub
		em.merge(j);
	}

	@Override
	public Championnat getChampionnat(long idChampionnat) {
		// TODO Auto-generated method stub
		return em.find(Championnat.class,idChampionnat);
	}*/
	
	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		User u = em.find(User.class, userID);
		u.getRoles().add(r);
		em.persist(r);
	}

	@Override
	public void modifierUser(User u) {
		// TODO Auto-generated method stub
		em.merge(u);
	}

	@Override
	public List<Ville> listVilles() {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select * from villes v", Ville.class);
		return req.getResultList();
	}
	
	@Override
	public List<Ville> searchVilles(String ville) {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select * from villes v where ville_nom like ('"+ville+"%')", Ville.class);
		return req.getResultList();
	}

}
