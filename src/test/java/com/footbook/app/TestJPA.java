package com.footbook.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Role;
import com.footbook.app.entities.Sexe;
import com.footbook.app.entities.User;
import com.footbook.app.metier.JoueurMetier;
import com.footbook.app.metier.RoleMetier;
import com.footbook.app.metier.UserMetier;

public class TestJPA {

	/*@Test
	public void test1() {
		try{
			ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			JoueurMetier joueurMetier = (JoueurMetier) context.getBean("metier");
			String nom = "benali";
			String prenom = "yahia";
			String descritpion = "Salut ayant jouer en dh je recherche au minimum un club de phr";
			String email = "y@hotmail.fr";
			List<Championnat> mesChampionnats = new ArrayList();
			mesChampionnats.add(Championnat.DH);
			mesChampionnats.add(Championnat.PHR);
			
			
			Joueur j = new Joueur(nom,prenom, descritpion, email, null, "maPhoto",mesChampionnats, Sexe.MASCULIN );
			
			UserMetier userMetier = (UserMetier) context.getBean("UserMetier");
			List<Role> rList = new ArrayList();
			RoleMetier roleMetier = (RoleMetier) context.getBean("RoleMetier");
			User u = new User("y.ro@hotmail.fr", "yahia", true);
			joueurMetier.ajouterJoueur(j);
			userMetier.ajouterUser(u);
			u.setJoueur(j);
			u.setActived(true);
			Role r = new Role("ROLE_JOUEUR");
			userMetier.modifierUser(u);
			roleMetier.attribuerRole(r, u.getIdUser());
			j.setUser(u);
			joueurMetier.modifierJoueur(j);
			
			assertTrue(true);
		}
		catch (Exception e){
			assertTrue(e.getMessage(),false);
		}
	}*/

}
