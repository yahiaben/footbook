package com.footbook.app.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.footbook.app.dao.FootbookDao;
import com.footbook.app.entities.Role;
@Transactional
public class RoleMetierImpl implements RoleMetier {

	@Autowired
	private FootbookDao fbDao;
	
	public FootbookDao getFbDao() {
		return fbDao;
	}
	public void setFbDao(FootbookDao fbDao) {
		this.fbDao = fbDao;
	}
	
	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		fbDao.attribuerRole(r, userID);
	}

}
