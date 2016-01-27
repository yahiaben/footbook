package com.footbook.app.metier;

import java.util.List;

import com.footbook.app.entities.Joueur;

public interface JoueurMetier {
	public Long ajouterJoueur(Joueur j);
	public void modifierJoueur(Joueur j);
	public List<Joueur> listJoueurs();
	public Long getIDJoueurFromUser(String email);
	public Joueur getJoueur(Long idJoueur);


}
