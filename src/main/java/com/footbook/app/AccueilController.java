package com.footbook.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AccueilController {

	
	@RequestMapping("joueurs/{region}")
	public String getJoueursRegion(@PathVariable String region){
		System.out.println("voila la region" + region);
		return "joueursRegion";
	}
}
