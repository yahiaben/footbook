package com.footbook.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.footbook.app.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long>{

	@Query("select * from joueurs j where departement = :dep")
	public Page<Joueur> listJoueurs(@Param("dep")String region, Pageable pageable);
}
