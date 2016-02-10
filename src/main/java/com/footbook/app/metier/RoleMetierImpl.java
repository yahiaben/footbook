package com.footbook.app.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.Role;
@Transactional
public class RoleMetierImpl implements RoleMetier {

	/**
	 * fbDao 
	 */
	@Autowired
	private FootbookDao fbDao;
	
	
	/**
	 * renvoie la fbDao
	 * @return la fbao
	 */
	public FootbookDao getFbDao() {
		return fbDao;
	}
	
	/**
	 * modifie la fbDao
	 * @param fbDao nouvel fbDao
	 */
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}
	
	/**
	 * attribue un role a un user
	 * @param role a attribuer a l'user
	 * @param Id de l'user
	 */
	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		fbDao.attribuerRole(r, userID);
	}

}
