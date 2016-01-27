package com.footbook.app;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

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
import com.footbook.app.entities.Joueur;
import com.footbook.app.metier.JoueurMetier;
import com.footbook.app.metier.VilleMetier;
import com.footbook.app.repository.JoueurRepository;

@Controller
public class AccueilController {
	

	@Autowired
	private JoueurMetier jm;
	
@RequestMapping("joueurs/{region}/{code}")
	public String getJoueursRegion(@PathVariable String region, @PathVariable String code, Model model){
		
		model.addAttribute("joueurs", jm.listJoueurs(code));
		
		return "joueursRegion";
	}
	
	@RequestMapping(value = "/upload-picture", method = RequestMethod.POST)
	public String uploadPicture(@RequestParam("file") final MultipartFile fileUpload, final Principal principal) {
		if (!fileUpload.isEmpty()) {
			final String[] ext = fileUpload.getOriginalFilename().split("\\.");
			final File file = new File("/Users/yahia/Desktop/img-footbook/" + "yahia.jpg");
			try {
				FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), file);
			} catch (final IOException e) {
				e.printStackTrace();
			}

		}

		return "redirect:/accueil";
	}

}
