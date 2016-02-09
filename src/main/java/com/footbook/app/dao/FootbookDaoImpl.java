package com.footbook.app.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.User;
import com.footbook.app.entities.Ville;
import com.footbook.app.entities.Poste;

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
	

	@Override
	public List<Joueur> listJoueurs(String departement) {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select * from joueurs j where departement = :dep",Joueur.class);
		req.setParameter("dep", departement);
		return req.getResultList();
	}

	@Override
	public Joueur getJoueur(Long idJoueur) {
		// TODO Auto-generated method stub
		return em.find(Joueur.class, idJoueur);
	}
	
	@Override
	public User getUser(Long idUser) {
		// TODO Auto-generated method stub
		return em.find(User.class, idUser);
	}
	
	/*
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

	@Override
	public String departementDeLaVille(String ville) {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select ville_departement from villes v where ville_nom = :ville");
		req.setParameter("ville", ville);
		Object dep = req.getSingleResult();
		String s = (String) dep;
		return s;
	}

	@Override
	public Long getIDJoueurFromUser(String email) {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select joueur_id from users where email = :email");
		req.setParameter("email", email);
		Object joueurID = req.getSingleResult();
		BigInteger joueurIDBig = (BigInteger) joueurID;
		System.out.println("voila le joueurID : "+joueurID + " de cette adresse mail  : " +email);
		long joueurIDLong = joueurIDBig.longValue();
		System.out.println("voila le joueurID : "+joueurIDLong + " de cette adresse mail  : " +email);
		return joueurIDLong;
	}
	
	public List<Poste> postesJoueur(Long idJoueur){
		Query req = em.createNativeQuery("select poste from Joueur_mesPostes p where Joueur_joueur_id = :id");
		req.setParameter("id", idJoueur);
		
		return req.getResultList();
	}
	
	public List<Championnat> championnatsJoueur(Long idJoueur){
		Query req = em.createNativeQuery("select championnat from Joueur_mesChampionnats c where Joueur_joueur_id = :id");
		req.setParameter("id", idJoueur);
		
		return req.getResultList();
	}

	@Override
	public List<Joueur> listJoueursVille(String ville) {
		// TODO Auto-generated method stub
		Query req = em.createNativeQuery("select * from joueurs j where ville = :vil",Joueur.class);
		req.setParameter("vil", ville);
		return req.getResultList();
	}

}
