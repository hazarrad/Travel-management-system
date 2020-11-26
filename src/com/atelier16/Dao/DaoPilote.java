package com.atelier16.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.atelier16.entities.Pilote;
import com.atelier16.entities.VOL;
import com.database.utils.DBUtils;

public class DaoPilote {

	public static ArrayList<Pilote> getAllPilote() throws Exception {

		ArrayList<Pilote> pilotes = new ArrayList<>();
		String sql = "SELECT * FROM Pilote";

		ResultSet rs = DBUtils.executeRequete(sql);
		while (rs.next()) {
			Pilote p = new Pilote();
			p.setIdPilote(rs.getInt(1));
			p.setNom(rs.getString(2));
			p.setPrenom(rs.getString(3));
			p.setAdresse(rs.getString(4));
			p.setTel(rs.getString(5));
			p.setDateNaissance(rs.getDate(6));
			p.setDateEmbauche(rs.getDate(7));

			pilotes.add(p);
		}

		return pilotes;

	}
	
	public static ArrayList<Pilote> getAllFiltreDateEmbauche(Date dd, Date df) throws Exception{
		ArrayList<Pilote> pilotes = new ArrayList<>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		String sql = "SELECT * FROM PILOTE where dateEmbauche between Date('"+format.format(dd)+"') and Date('"+format.format(df)+"')";
		
		ResultSet res = DBUtils.executeRequete(sql);
		
		while(res.next()) {
			Pilote p = new Pilote();
			
			p.setIdPilote(res.getInt(1));
			p.setNom(res.getString(2));
			p.setPrenom(res.getString(3));
			p.setAdresse(res.getString(4));
			p.setTel(res.getString(5));
			p.setDateNaissance(res.getDate(6));
			p.setDateEmbauche(res.getDate(7));
			
			pilotes.add(p);
		}
		
		return pilotes;
	}

	public static ArrayList<VOL> GetAllVol(int idpilote) throws Exception {

		ArrayList<VOL> vols = new ArrayList<>();
		String sql = "SELECT * FROM VOL WHERE idpilote =" + idpilote;
		ResultSet rs = DBUtils.executeRequete(sql);

		while (rs.next()) {

			VOL v = new VOL();
			v.setIdVol(rs.getInt(1));
			v.setDatevol(rs.getDate(2));
			v.setHeureDecalage(rs.getInt(3));
			v.setMinuteDecalage(rs.getInt(4));
			v.setIdPilote(rs.getInt(5));
			v.setIdAvion(rs.getInt(6));
			v.setIdTrajet(rs.getInt(7));

			vols.add(v);

		}
		return vols;

	}
	
	
	
		public static ArrayList<Integer> getAllidPilote() throws Exception{
				
				ArrayList<Integer> ids = new ArrayList<>();
				String sql = "SELECT idpilote FROM pilote";
				
				ResultSet r = DBUtils.executeRequete(sql);
				
				while(r.next()) {
					ids.add(r.getInt(1));
				}
				return ids;
			}
	

	public static Pilote getonePilote(int idpilote) throws Exception {

		String sql = "SELECT * FROM PILOTE WHERE IDPILOTE=" + idpilote;
		Pilote p = null;
		ResultSet rs = DBUtils.executeRequete(sql);
		while (rs.next()) {
			p= new Pilote();

			p.setIdPilote(rs.getInt(1));
			p.setNom(rs.getString(2));
			p.setPrenom(rs.getString(3));
			p.setAdresse(rs.getString(4));
			p.setTel(rs.getString(5));
			p.setDateNaissance(rs.getDate(6));
			p.setDateEmbauche(rs.getDate(7));

		}
		return p;

	}

	public static int AddPilote(Pilote p) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql = "insert into pilote(Nom,prenom,adresse,tel,DATENAISSANCE,DATEEMBAUCHE)\r\n" + 
				"  values ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getAdresse()+"','"+p.getTel()+"','"+format.format(p.getDateNaissance())+"','"+format.format(p.getDateEmbauche())+"')" ; 
		
		return DBUtils.executeRequeteLMD(sql);

	}

	/*public static int UpdatePilote(){
		String sql = "INSERT INTO Pilote " + "set nom='" + p.getNom() + "'," + "Prenom ='" + p.getPrenom() + "',"
				+ "Adresse='" + p.getAdresse() + "'," + "tel ='" + p.getTel() + "'," + "DateNaissance ='"
				+ format.format(p.getDateNaissance()) + "'," + "DateEmbauche ='" + format.format(p.getDateEmbauche())
				+ "'";
	}*/
	
	
	public static int UpdatePilote(Pilote p) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String sql = "Update Pilote " + "set nom='" + p.getNom() + "'," + "Prenom ='" + p.getPrenom() + "',"
				+ "Adresse='" + p.getAdresse() + "'," + "tel ='" + p.getTel() + "'," + "DateNaissance ='"
				+ format.format(p.getDateNaissance()) + "'," + "DateEmbauche ='" + format.format(p.getDateEmbauche())
				+ "'where idpilote ="+p.getIdPilote();

		return DBUtils.executeRequeteLMD(sql);

	}

	public static int RemovePilote(int idpilote) throws Exception {

		String sql = "DELETE FROM PILOTE WHERE IDPILOTE =" + idpilote;
		return DBUtils.executeRequeteLMD(sql);

	}
}
