package com.atelier16.entities;

import java.util.Date;

public class Pilote {

	
	private int IdPilote;
	private String Nom ;
	private String Prenom ;
	private String Adresse ;
	private String tel ;
	private Date DateNaissance;
	private Date DateEmbauche ;
	public int getIdPilote() {
		return IdPilote;
	}
	public void setIdPilote(int idPilote) {
		IdPilote = idPilote;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDateNaissance() {
		return DateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		DateNaissance = dateNaissance;
	}
	public Date getDateEmbauche() {
		return DateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}
	
	public Pilote(){
		
	}
	
	public Pilote(int idPilote, String nom, String prenom, String adresse, String tel, Date dateNaissance,
			Date dateEmbauche) {
		super();
		IdPilote = idPilote;
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		this.tel = tel;
		DateNaissance = dateNaissance;
		DateEmbauche = dateEmbauche;
	}
	@Override
	public String toString() {
		return "Pilote [IdPilote=" + IdPilote + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse
				+ ", tel=" + tel + ", DateNaissance=" + DateNaissance + ", DateEmbauche=" + DateEmbauche + "]";
	}
	
	
	
}
