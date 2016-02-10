package com.footbook.app.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.Ville;

public class VilleMetierImpl implements VilleMetier {

	/**
	 * fbDao
	 */
	@Autowired
	private FootbookDao fbDao;
	
	/**
	 * renvoie la fbDao
	 * @return
	 */
	public FootbookDao getFbDao() {
		return fbDao;
	}
	
	/**
	 * modifie la fbDao
	 * @param nouvel fbDao
	 */
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}
	
	/**
	 * renvoie la liste des villes
	 */
	@Override
	public List<Ville> listVilles() {
		// TODO Auto-generated method stub
		return fbDao.listVilles();
	}
	
	/**
	 * renvoie la liste des villes commençant par "ville"
	 * @param nom du debut de la ville
	 * @return la liste des villes
	 */
	@Override
	public List<Ville> searchVilles(String ville) {
		// TODO Auto-generated method stub
		return fbDao.searchVilles(ville);
	}
	
	/**
	 * renvoie le de partement de la ville
	 * @param nom de la ville
	 * @return nom du departement
	 */
	@Override
	public String departementDeLaVille(String ville) {
		// TODO Auto-generated method stub
		return fbDao.departementDeLaVille(ville);
	}

}
