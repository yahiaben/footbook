package com.footbook.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Role {

	/**
	 * Id du role
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;

	/**
	 * nom du role
	 */
	private String roleName;
	
	/**
	 * constructeur du role
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * construteur du role
	 * @param roleName nom du role
	 */
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	/**
	 * Renvoie l'ID du role
	 * @return id du role
	 */
	public Long getIdRole() {
		return idRole;
	}
	
	/**
	 * Modifie l'ID du role
	 * @param idRole nouvel ID du role
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	/**
	 * renvoie le nom du role
	 * @return nom du role
	 */
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * modifie le nom du role
	 * @param roleName nouveau nom du role
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
