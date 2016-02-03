package com.footbook.app.entities;

public enum Poste {
	BU("BU"),AG("AG"),AD("AD"),MD("MD"),
	MG("MG"),MOC("MOC"),MDC("MDC"),DD("DD"),
	DG("DG"),DC("DC"),G("G");
	
	public String name = "";

	  Poste(String name){
	    this.name = name;
	  }

	   

	  public String toString(){

	    return name;

	  }
}
