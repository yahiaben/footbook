package com.footbook.app;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footbook.app.dto.EnvoiMailDto;
import com.footbook.app.service.MailMail;

@Controller
public class MailController {

	@RequestMapping(value="/contacterJoueur", method = RequestMethod.POST)
	public String contacterJoueur(@ModelAttribute("envoiMailDto") @Valid EnvoiMailDto emDto,BindingResult bindingResult, Model model, HttpServletRequest request ){
		if (!bindingResult.hasErrors()) {
			System.out.println(emDto.getEmailReceveur() + " email Receveur ");
			ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			mm.sendMail(emDto.getEmailEnvoyeur(),
				   		   emDto.getEmailReceveur(),
				   		   emDto.getObjet(), 
				   		   emDto.getContenu());	
		}
		return "redirect:"+request.getHeader("referer");
	}
}
