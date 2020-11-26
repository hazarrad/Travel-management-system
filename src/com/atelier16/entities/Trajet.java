package com.atelier16.entities;

public class Trajet {

	
	private int IdTrajet ;
	private String AeroportDepart ;
	private String AeroportArrivee ;
	private int duree_vol ;
	
	public int getIdTrajet() {
		return IdTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		IdTrajet = idTrajet;
	}
	public String getAeroportDepart() {
		return AeroportDepart;
	}
	public void setAeroportDepart(String aeroportDepart) {
		AeroportDepart = aeroportDepart;
	}
	public String getAeroportArrivee() {
		return AeroportArrivee;
	}
	public void setAeroportArrivee(String aeroportArrivee) {
		AeroportArrivee = aeroportArrivee;
	}
	public int getDuree_vol() {
		return duree_vol;
	}
	public void setDuree_vol(int duree_vol) {
		this.duree_vol = duree_vol;
	}
	
	public Trajet(){
		
	}
	
	public Trajet(int idTrajet, String aeroportDepart, String aeroportArrivee, int duree_vol) {
		super();
		IdTrajet = idTrajet;
		AeroportDepart = aeroportDepart;
		AeroportArrivee = aeroportArrivee;
		this.duree_vol = duree_vol;
	}
	
	@Override
	public String toString() {
		return "Trajet [IdTrajet=" + IdTrajet + ", AeroportDepart=" + AeroportDepart + ", AeroportArrivee="
				+ AeroportArrivee + ", duree_vol=" + duree_vol + "]";
	}
	
	
}
