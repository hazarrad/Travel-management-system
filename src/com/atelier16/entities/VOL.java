package com.atelier16.entities;

import java.util.Date;

public class VOL {

	
	private int IdVol ;
	private Date Datevol ;
	private int HeureDecalage ;
	private int MinuteDecalage ;
	private int idPilote ;
	private int idAvion;
	private int idTrajet ;
	public int getIdVol() {
		return IdVol;
	}
	public void setIdVol(int idVol) {
		IdVol = idVol;
	}
	public Date getDatevol() {
		return Datevol;
	}
	public void setDatevol(Date datevol) {
		Datevol = datevol;
	}
	public int getHeureDecalage() {
		return HeureDecalage;
	}
	public void setHeureDecalage(int heureDecalage) {
		HeureDecalage = heureDecalage;
	}
	public int getMinuteDecalage() {
		return MinuteDecalage;
	}
	public void setMinuteDecalage(int minuteDecalage) {
		MinuteDecalage = minuteDecalage;
	}
	public int getIdPilote() {
		return idPilote;
	}
	public void setIdPilote(int idPilote) {
		this.idPilote = idPilote;
	}
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public int getIdTrajet() {
		return idTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}
	
	public VOL(){
		
	}
	
	public VOL(int idVol, Date datevol, int heureDecalage, int minuteDecalage, int idPilote, int idAvion,
			int idTrajet) {
		super();
		IdVol = idVol;
		Datevol = datevol;
		HeureDecalage = heureDecalage;
		MinuteDecalage = minuteDecalage;
		this.idPilote = idPilote;
		this.idAvion = idAvion;
		this.idTrajet = idTrajet;
	}
	
	@Override
	public String toString() {
		return "VOL [IdVol=" + IdVol + ", Datevol=" + Datevol + ", HeureDecalage=" + HeureDecalage + ", MinuteDecalage="
				+ MinuteDecalage + ", idPilote=" + idPilote + ", idAvion=" + idAvion + ", idTrajet=" + idTrajet + "]";
	}
	
	
	
}
