package com.footbook.app.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.User;
@Transactional
public class UserMetierImpl implements UserMetier {

	/**
	 * fbDao
	 */
	@Autowired
	private FootbookDao fbDao;
	
	/**
	 * ajoute un user a la fbDao
	 * @param User a ajouter
	 * @return renvoie l'id de l'user
	 */
	@Override
	public Long ajouterUser(User u) {
		// TODO Auto-generated method stub
		fbDao.ajouterUser(u);
		return u.getIdUser();
	}

	/**
	 * renvoie la fbDao
	 * @return fbDao
	 */
	public FootbookDao getFbDao() {
		return fbDao;
	}
	
	/**
	 * renvoie l'user lié a l'id
	 * @param ID de l'user
	 * @return l'user
	 */
	public User getUser(Long idUser) {
		return fbDao.getUser(idUser);
	}
	
	/**
	 * Modifie la fbDao
	 * @param fbDao
	 */
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}

	/**
	 * Modifie l'user
	 * @param nouvel user
	 */
	@Override
	public void modifierUser(User u) {
		// TODO Auto-generated method stub
		fbDao.modifierUser(u);
	}
}
