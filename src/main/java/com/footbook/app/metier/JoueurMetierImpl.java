package com.footbook.app.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.Joueur;
@Transactional
public class JoueurMetierImpl implements JoueurMetier {

	@Autowired
	private FootbookDao fbDao;
	
	public FootbookDao getFbDao() {
		return fbDao;
	}
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}
	@Override
	public Long ajouterJoueur(Joueur j) {
		// TODO Auto-generated method stub
		fbDao.ajouterJoueur(j);
		return j.getIdJoueur();
	}
	@Override
	public void modifierJoueur(Joueur j) {
		// TODO Auto-generated method stub
		fbDao.modifierJoueur(j);
	}
	@Override
	public List<Joueur> listJoueurs() {
		// TODO Auto-generated method stub
		return fbDao.listJoueurs();
	}

	@Override
	public List<Joueur> listJoueurs(String departement) {
		// TODO Auto-generated method stub
		return fbDao.listJoueurs(departement);
	}


}
