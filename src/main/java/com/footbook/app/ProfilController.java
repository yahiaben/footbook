package com.footbook.app;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footbook.app.entities.Joueur;
import com.footbook.app.metier.JoueurMetier;


@Controller
public class ProfilController {
	
	@Autowired
	private JoueurMetier jm;
	
	private Joueur j;
	
	@RequestMapping("/profil")
	public String login(Principal principal,Model model){
		System.out.println(principal.getName() + "voici le name");
		Long joueurID = jm.getIDJoueurFromUser(principal.getName());
		j = jm.getJoueur(joueurID); 
		model.addAttribute("joueur",j);
		return "profil";
	}
	
}
