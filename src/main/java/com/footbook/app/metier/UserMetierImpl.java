package com.footbook.app.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.User;
@Transactional
public class UserMetierImpl implements UserMetier {

	@Autowired
	private FootbookDao fbDao;
	
	@Override
	public Long ajouterUser(User u) {
		// TODO Auto-generated method stub
		fbDao.ajouterUser(u);
		return u.getIdUser();
	}

	public FootbookDao getFbDao() {
		return fbDao;
	}
	
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}

	@Override
	public void modifierUser(User u) {
		// TODO Auto-generated method stub
		fbDao.modifierUser(u);
	}
}
