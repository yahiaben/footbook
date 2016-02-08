package com.footbook.app;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footbook.app.dto.InscriptionDto;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.User;
import com.footbook.app.entities.Ville;
import com.footbook.app.metier.JoueurMetier;
import com.footbook.app.metier.JoueurMetierImpl;
import com.footbook.app.metier.RoleMetier;
import com.footbook.app.metier.RoleMetierImpl;
import com.footbook.app.metier.UserMetier;
import com.footbook.app.metier.UserMetierImpl;
import com.footbook.app.metier.VilleMetier;

@Controller
public class LoginController {
	@Autowired
	private JoueurMetier jm;
	
	@Autowired
	private RoleMetier rm;
	
	@Autowired
	private UserMetier um;
	
	@Autowired
	private VilleMetier vm;
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("inscriptionDto", new InscriptionDto());
		model.addAttribute("joueurs", jm.listJoueurs());
		model.addAttribute("villes", vm.listVilles());

		return "login";
	}
	
	@RequestMapping("/accueil")
	public String boots(Model model){
		model.addAttribute("inscriptionDto", new InscriptionDto());
		/*Ville v = new Ville("59","Lille");
		Ville v2 = new Ville("59","Loos");
		List<Ville> lv = new ArrayList();
		lv.add(v);
		lv.add(v2);*/
		model.addAttribute("villes", vm.listVilles());
		return "boots";
	}
	
	@RequestMapping(value="/saveJoueur", method = RequestMethod.POST)
	public String saveJoueur(@ModelAttribute("inscriptionDto") @Valid InscriptionDto iDto,BindingResult bindingResult, Model model){
		String dpt = vm.departementDeLaVille(iDto.getVille());
		System.out.println(dpt + " departement " + iDto.getNom() + "  " + iDto.getPrenom() + "  " + iDto.getDescription() + "  " + iDto.getEmail());
		
		if (!bindingResult.hasErrors()) {
			Joueur j = new Joueur(iDto.getNom(),iDto.getPrenom(),iDto.getMesPostes(),iDto.getDescription(),iDto.getEmail(),null,"profil.jpg",iDto.getMesChampionnats(),iDto.getSexeJoueur(),dpt,iDto.getVille());
			User u = new User(iDto.getEmail(),iDto.getPassword(),true);
			jm.ajouterJoueur(j);
			um.ajouterUser(u);
			u.setJoueur(j);
			um.modifierUser(u);
			j.setUser(u);
			jm.modifierJoueur(j);
			Role r = new Role("ROLE_JOUEUR");
			rm.attribuerRole(r, u.getIdUser());
			//model.addAttribute("joueur", new Joueur());
			model.addAttribute("joueurs", jm.listJoueurs());
			
			return "profil";
		}
			
		return "boots";
	}
	
	
	
	
}
