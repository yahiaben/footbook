package com.footbook.app.metier;

import java.util.List;

import com.footbook.app.entities.Ville;

public interface VilleMetier {
	
	public List<Ville> listVilles();
	public List<Ville> searchVilles(String ville);
}
