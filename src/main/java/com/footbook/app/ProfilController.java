package com.footbook.app;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfilController {
	
	@RequestMapping("/profil")
	public String login(Principal principal){
		System.out.println(principal.getName() + "voici le name");
		return "profil";
	}
	
}
