package com.atelier16.Dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.atelier16.entities.Avion;
import com.atelier16.entities.Trajet;
import com.atelier16.entities.VOL;
import com.database.utils.DBUtils;

public class DaoTrajet {

	public static ArrayList<Trajet> getAllTrajet() throws Exception {
		ArrayList<Trajet> Trajets = new ArrayList<>();
		String sql = "SELECT * FROM Trajet";

		ResultSet rs = DBUtils.executeRequete(sql);

		while (rs.next()) {
			Trajet t = new Trajet();
			t.setIdTrajet(rs.getInt(1));
			t.setAeroportDepart(rs.getString(2));
			t.setAeroportArrivee(rs.getString(3));
			t.setDuree_vol(rs.getInt(4));

			Trajets.add(t);

		}
		return Trajets;

	}
	
	
	public static ArrayList<Integer> getAllidTrajet() throws Exception{
		
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT idtrajet FROM trajet";
		
		ResultSet r = DBUtils.executeRequete(sql);
		
		while(r.next()) {
			ids.add(r.getInt(1));
		}
		return ids;
	}
	
	public static ArrayList<Integer> getAlldureeTrajet() throws Exception{
		
		ArrayList<Integer> duree = new ArrayList<>();
		String sql = "SELECT duree_vol FROM trajet";
		
		ResultSet r = DBUtils.executeRequete(sql);
		
		while(r.next()) {
			duree.add(r.getInt(1));
		}
		return duree;
	}


	public static Trajet getOneTrajet(int idtrajet) throws Exception {
		String sql = "SELECT * FROM Trajet WHERE idtrajet=" + idtrajet;
		Trajet t = null;
		ResultSet rs = DBUtils.executeRequete(sql);

		while (rs.next()) {
			t=new Trajet();
			t.setIdTrajet(rs.getInt(1));
			t.setAeroportDepart(rs.getString(2));
			t.setAeroportArrivee(rs.getString(3));
			t.setDuree_vol(rs.getInt(4));

		}
		return t;

	}

	public static ArrayList<VOL> getAllVol(int idavion) throws Exception {

		ArrayList<VOL> vols = new ArrayList<>();

		String sql = "SELECT * FROM VOL WHERE IDTRAJET =" + idavion;

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

	public static int AddTrajet(Trajet t) throws Exception {

		String sql = "INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('" + t.getAeroportDepart()+"','" + t.getAeroportArrivee() + "'," + t.getDuree_vol() + ")";                                
		return DBUtils.executeRequeteLMD(sql);
	}

	public static int UpdateTrajet(Trajet t) throws Exception {

		
		
		
		
		
		String sql = "UPDATE trajet"
				+ " SET AeroportDepart = '" + t.getAeroportDepart()+"' , "
				+ " AeroportArrivee = '" + t.getAeroportArrivee()+"',"
				+ " duree_vol = " + t.getDuree_vol()+""
				+ " WHERE idtrajet = " + t.getIdTrajet();
		
		return DBUtils.executeRequeteLMD(sql);
	}

	public static int RemoveTrajet(int id) throws Exception {
		String sql = "DELETE FROM TRAJET WHERE IDTRAJET =" + id;
		return DBUtils.executeRequeteLMD(sql);

	}

}
