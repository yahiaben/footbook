package com.footbook.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfilController {
	
	@RequestMapping("/profil")
	public String login(){
		return "profil";
	}
}
