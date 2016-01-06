package com.footbook.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footbook.app.entities.Joueur;
import com.footbook.app.metier.JoueurMetier;
import com.footbook.app.metier.JoueurMetierImpl;
import com.footbook.app.metier.RoleMetierImpl;
import com.footbook.app.metier.UserMetierImpl;

@Controller
public class LoginController {
	@Autowired
	private JoueurMetier jm;
	
	//private RoleMetierImpl rmImpl;
	//private UserMetierImpl umImpl;
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("joueur", new Joueur());
		model.addAttribute("joueurs", jm.listJoueurs());
		return "login";
	}
	
	@RequestMapping("/saveJoueur")
	public String saveJoueur(@ModelAttribute("joueur") Joueur joueur,BindingResult bindingResult, Model model){
		jm.ajouterJoueur(joueur);
		//model.addAttribute("joueur", new Joueur());
		model.addAttribute("joueurs", jm.listJoueurs());
		return "login";
	}

	
	
}
