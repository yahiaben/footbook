package com.footbook.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.footbook.app.entities.Ville;
import com.footbook.app.metier.VilleMetier;

@Controller
public class JSONController {
	
	@Autowired
	private VilleMetier vm; 
	
	/**
	 * Methode pour rechercher les joueur d'une ville
	 * @param ville
	 * @return
	 */
	@RequestMapping(value = "/rechercherVille/{ville}", method = RequestMethod.GET)
	public @ResponseBody List<Ville> getVilleEnJSON(@PathVariable String ville){
		/*System.out.println("Voila la ville " + ville);
		Ville v = new Ville();
		v.setVille_departement("59");
		v.setVille_nom("Lille");*/
		
		System.out.println(vm.searchVilles(ville).get(0).getVille_nom() + " voila le nom");
		return vm.searchVilles(ville);
		//return v;
	}
}
