package com.footbook.app.metier;

import com.footbook.app.entities.User;

public interface UserMetier {
	public Long ajouterUser(User u);
	public void modifierUser(User u);
}
