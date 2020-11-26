package com.atelier16.entities;

import java.util.Date;

public class Avion {

	private int IdAvion;
	private String Compagnie;
	private String Type;
	private Date DateMiseMarche;

	public int getIdAvion() {
		return IdAvion;
	}

	public void setIdAvion(int idAvion) {
		IdAvion = idAvion;
	}

	public String getCompagnie() {
		return Compagnie;
	}

	public void setCompagnie(String compagnie) {
		Compagnie = compagnie;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Date getDateMiseMarche() {
		return DateMiseMarche;
	}

	public void setDateMiseMarche(Date dateMiseMarche) {
		DateMiseMarche = dateMiseMarche;
	}

	public Avion() {

	}

	public Avion(int idAvion, String compagnie, String type, Date dateMiseMarche) {
		super();
		IdAvion = idAvion;
		Compagnie = compagnie;
		Type = type;
		DateMiseMarche = dateMiseMarche;
	}

	@Override
	public String toString() {
		return "Avion [IdAvion=" + IdAvion + ", Compagnie=" + Compagnie + ", Type=" + Type + ", DateMiseMarche="
				+ DateMiseMarche + "]";
	}

}
