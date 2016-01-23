package com.footbook.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarteController {

	
	@RequestMapping("joueurs/{region}")
	public String JoueursRegion(@PathVariable String region){
		System.out.println("voila la region" + region);
		return "joueursRegion";
	}
}
