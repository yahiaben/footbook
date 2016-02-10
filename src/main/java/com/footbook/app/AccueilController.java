package com.footbook.app;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.footbook.app.dto.InscriptionDto;
import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Poste;
import com.footbook.app.entities.User;
import com.footbook.app.metier.JoueurMetier;
import com.footbook.app.metier.UserMetier;
import com.footbook.app.metier.VilleMetier;
import com.footbook.app.repository.JoueurRepository;

@Controller
public class AccueilController {
	

	/**
	 * joueur metier
	 */
	@Autowired
	private JoueurMetier jm;
	
	/**
	 * user metier
	 */
	@Autowired
	private UserMetier um;
	
	/**
	 * Methode pour recupérer les postes des joueurs sous forme d'une liste
	 * @param lj la liste des joueurs
	 * @return la liste des postes des joueurs
	 */
	public ArrayList<String> postesJoueurs(List<Joueur> lj){
		ArrayList<String> postes;
		postes = new ArrayList<String>();
		
		for(Joueur j : lj){
			for(Poste p : jm.postesJoueur(j.getIdJoueur())){
				String poste = p.name();
				if(!postes.contains(poste))
					postes.add(poste);
			}
		}
		
		return postes;
	}
	
	/**
	 * Methode pour transformer une liste en string
	 * @param m la chaine
	 * @param lp la liste
	 * @return la chaine de postes
	 */
	public String listToString(String m, List<Poste> lp){
		
		for(Poste p : lp){
			m+= p.toString();
		}
		
		return m;
	}
	
	
	/**
	 * Methodes pour recuppérer les joueur d'une région
	 * @param region 
	 * @param code : code postal
	 * @param model permet de stocker les informations necessaire pour la page
	 * @param principal permet de savoir qui est connecé
	 * @return vers la page joueurRegions
	 */
@RequestMapping("joueurs/{region}/{code}")
	public String getJoueursRegion(@PathVariable String region, @PathVariable String code, Model model, Principal principal){
	 	
	 	
		List<Joueur> lj = jm.listJoueurs(code);
		
		
		for(Joueur j : lj){
			Long id = j.getIdJoueur();
			
			List<Poste> lp;
			lp = jm.postesJoueur(id);
			j.setMesPostes(lp);
			
			List<Championnat> lc;
			lc = jm.championnatsJoueur(id);
			j.setMesChampionnats(lc);
		}
		
		model.addAttribute("joueurs", lj);
		Long joueurID;
		try {
			joueurID = jm.getIDJoueurFromUser(principal.getName());
		} catch (Exception e) {
			joueurID = (long) -1;
		}
		
		if(joueurID > 0){
			model.addAttribute("connecte", "true");
		}else{
			model.addAttribute("connecte", "false");
		}
		return "joueursRegion";
	}
	

/**
 * Méthode pour enregister les informations du profil d'un joueur aprés modification
 * @param nom du joueur
 * @param prenom du joueur
 * @param postes du joueur
 * @param championnats du joueur
 * @param description du joueur
 * @param ville du joueur
 * @param mdp du joueur
 * @param fileUpload photo du joueur
 * @param principal permet de savoir qui est conecter
 * @param model permet de stocker les informations necessire
 * @return vers la page du profil
 */
	@RequestMapping(value = "/upload-picture", method = RequestMethod.POST)
	public String uploadPicture(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("postes") Collection<String> postes, @RequestParam("championnats") Collection<String> championnats,
			@RequestParam("description") String description, @RequestParam("ville") String ville, 
			@RequestParam("mdp") String mdp, @RequestParam("file") final MultipartFile fileUpload, 
			final Principal principal, Model model) {
		
		
			//JE RECUPERE LES POSTES ET CHAMPIONNATS DU JOUEUR
			Collection<Poste> lesPostes;
			lesPostes = new ArrayList<Poste>();
			
			for(String poste : postes){
				Poste p = Poste.valueOf(poste);
				lesPostes.add(p);
			}
			
			Collection<Championnat> lesChampionnats;
			lesChampionnats = new ArrayList<Championnat>();
			
			for(String c1 : championnats){
				Championnat c2  = Championnat.valueOf(c1);
				lesChampionnats.add(c2);
			}
			
		
		Long idJoueur = jm.getIDJoueurFromUser(principal.getName());
		Joueur j = jm.getJoueur(idJoueur);
		j.setNom(nom);
		j.setPrenom(prenom);
		j.setMesPostes(lesPostes);
		j.setMesChampionnats(lesChampionnats);
		j.setVille(ville);
		j.setDescription(description);
		
		if(mdp.length() > 7){
			User u = um.getUser(j.getIdJoueur());
			u.setPassword(mdp);
			System.out.println("mot de passe a modifer");
			um.modifierUser(u);
		}
		
		jm.modifierJoueur(j);
		
		if (!fileUpload.isEmpty()) {
			j.setNomPhoto(principal.getName()+".jpg");
			final String[] ext = fileUpload.getOriginalFilename().split("\\.");
			final File file = new File("/Applications/MAMP/htdocs/img/" + principal.getName()+".jpg");
			try {
				FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), file);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

		jm.modifierJoueur(j);
		
		Long joueurID = jm.getIDJoueurFromUser(principal.getName());
		j = jm.getJoueur(joueurID); 
		model.addAttribute("joueur",j);
		
		return "redirect:/profil";
	}
	
	/**
	 * Methode pour récupérer les joueurs d'une ville
	 * @param ville
	 * @param model
	 * @param principal
	 * @return vers la page joueurVille
	 */
	@RequestMapping("joueursVille/")
	public String getJoueursVille(@RequestParam("ville") String ville, Model model, Principal principal){
	 	
	 	
		List<Joueur> lj = jm.listJoueursVille(ville);
		
		
		for(Joueur j : lj){
			Long id = j.getIdJoueur();
			
			List<Poste> lp;
			lp = jm.postesJoueur(id);
			j.setMesPostes(lp);
			
			List<Championnat> lc;
			lc = jm.championnatsJoueur(id);
			j.setMesChampionnats(lc);
		}
		
		model.addAttribute("joueurs", lj);
		
		Long joueurID;
		try {
			joueurID = jm.getIDJoueurFromUser(principal.getName());
		} catch (Exception e) {
			joueurID = (long) -1;
		}
		
		if(joueurID > 0){
			model.addAttribute("connecte", "true");
		}else{
			model.addAttribute("connecte", "false");
		}
		model.addAttribute("ville", ville);
		return "joueursVille";
	}

}
