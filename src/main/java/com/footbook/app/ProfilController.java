package com.footbook.app;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footbook.app.dto.EnvoiMailDto;
import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.metier.JoueurMetier;
import com.footbook.app.entities.Poste;


@Controller
public class ProfilController {
	
	@Autowired
	private JoueurMetier jm;
	
	private Joueur j;
	private List<Poste> lp;
	private List<Championnat> lc;
	
	/**
	 * Méthode pour recupérer les informations d'un profil
	 * @param principal : permet de savoir quel joueur est connecté
	 * @param model permet de transférer les informations a la vue
	 * @return
	 */
	@RequestMapping("/profil")
	public String login(Principal principal,Model model){
		Long joueurID = jm.getIDJoueurFromUser(principal.getName());
		j = jm.getJoueur(joueurID); 
		
		
		lp = jm.postesJoueur(joueurID);
		j.setMesPostes(lp);
		
		lc = jm.championnatsJoueur(joueurID);
		j.setMesChampionnats(lc);
		
		model.addAttribute("joueur",j);
		
		
		
		if(j.getNomPhoto() == "PhotoDefaut")
			model.addAttribute("nomPhoto","defaut.jpg");
		else
			model.addAttribute("nomPhoto",principal.getName()+".jpg");
		
		return "profil";
	}
	
	/**
	 * Methode pour rediriger vers le profil du joueur 
	 * @param idJoueur du joueur
	 * @param model permet de donner les élements a la vue
	 * @return
	 */
	@RequestMapping("/profilJoueur/{idJoueur}")
	public String voirProfil(@PathVariable String idJoueur, Model model){
		Long idJoueurLong = Long.parseLong(idJoueur);
		j = jm.getJoueur(idJoueurLong); 
		lp = jm.postesJoueur(idJoueurLong);
		j.setMesPostes(lp);
		
		lc = jm.championnatsJoueur(idJoueurLong);
		j.setMesChampionnats(lc);
		model.addAttribute("joueur",j);
		model.addAttribute("envoiMailDto", new EnvoiMailDto());
		return "profilJoueur";
	}
	
}
