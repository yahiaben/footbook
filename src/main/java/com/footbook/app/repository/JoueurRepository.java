package com.footbook.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.footbook.app.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long>{

	/**
	 * renvoie une page de joueur de la region
	 * @param region nom de la region du joueur
	 * @param pageable contenant les joueur
	 * @return
	 */
	@Query("select * from joueurs j where departement = :dep")
	public Page<Joueur> listJoueurs(@Param("dep")String region, Pageable pageable);
}
