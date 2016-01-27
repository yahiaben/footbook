package com.footbook.app.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.footbook.app.entities.Joueur;

public interface JoueurMetier{
	public Long ajouterJoueur(Joueur j);
	public void modifierJoueur(Joueur j);
	public List<Joueur> listJoueurs();
	public Long getIDJoueurFromUser(String email);
	public Joueur getJoueur(Long idJoueur);
	List<Joueur> listJoueurs(String departement);
}
