package com.footbook.app.metier;

import com.footbook.app.entities.Joueur;

public interface JoueurMetier {
	public Long ajouterJoueur(Joueur j);
	public void modifierJoueur(Joueur j);
}
