package com.footbook.app.metier;

import com.footbook.app.entities.Role;

public interface RoleMetier {
	public void attribuerRole(Role r, Long userID);
}
