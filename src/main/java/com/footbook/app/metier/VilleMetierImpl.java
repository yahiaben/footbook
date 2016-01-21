package com.footbook.app.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.Ville;

public class VilleMetierImpl implements VilleMetier {

	@Autowired
	private FootbookDao fbDao;
	
	public FootbookDao getFbDao() {
		return fbDao;
	}
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}
	
	@Override
	public List<Ville> listVilles() {
		// TODO Auto-generated method stub
		return fbDao.listVilles();
	}
	@Override
	public List<Ville> searchVilles(String ville) {
		// TODO Auto-generated method stub
		return fbDao.searchVilles(ville);
	}

}
