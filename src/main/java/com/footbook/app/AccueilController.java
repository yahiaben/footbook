package com.footbook.app;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

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
	

	@Autowired
	private JoueurMetier jm;
	
	@Autowired
	private UserMetier um;
	
@RequestMapping("joueurs/{region}/{code}")
	public String getJoueursRegion(@PathVariable String region, @PathVariable String code, Model model){
		
		model.addAttribute("joueurs", jm.listJoueurs(code));
		
		return "joueursRegion";
	}
	
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
			final File file = new File("/Users/scof/Sites/img/" + principal.getName()+".jpg");
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

}
