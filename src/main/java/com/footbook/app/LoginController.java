package com.footbook.app;

import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

}
