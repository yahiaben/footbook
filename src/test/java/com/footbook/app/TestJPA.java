package com.footbook.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.footbook.app.entities.Championnat;
import com.footbook.app.entities.Joueur;
import com.footbook.app.entities.Sexe;
import com.footbook.app.metier.JoueurMetier;

public class TestJPA {

	@Test
	public void test1() {
		try{
			ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

			JoueurMetier joueurMetier = (JoueurMetier) context.getBean("metier");
			String pseudo = "yahia";
			String descritpion = "Salut ayant jouer en dh je recherche au minimum un club de phr";
			String email = "y@hotmail.fr";
			List<Championnat> mesChampionnats = new ArrayList();
			mesChampionnats.add(Championnat.DH);
			mesChampionnats.add(Championnat.PHR);
			Joueur j = new Joueur(pseudo, descritpion, email, null, "maPhoto",mesChampionnats, Sexe.MASCULIN );
			joueurMetier.ajouterJoueur(j);
			assertTrue(true);
		}
		catch (Exception e){
			assertTrue(e.getMessage(),false);
		}
	}

}
