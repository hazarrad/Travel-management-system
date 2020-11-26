package com.atelier16.Dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.atelier16.entities.Avion;
import com.atelier16.entities.Pilote;
import com.atelier16.entities.Trajet;
import com.atelier16.entities.VOL;
import com.database.utils.DBUtils;

public class DaoVol {

	public static ArrayList<VOL> getAllVol() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		ArrayList<VOL> vols = new ArrayList<>();
		String sql = "SELECT * FROM vol";

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
	
	
	public static ArrayList<Integer> getAllidVol() throws Exception{
		
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT idvol FROM vol";
		
		ResultSet r = DBUtils.executeRequete(sql);
		
		while(r.next()) {
			ids.add(r.getInt(1));
		}
		return ids;
	}


	public static VOL getOneVol(int idvol) throws Exception {
		String sql = "SELECT * FROM vol WHERE idvol=" + idvol;
		VOL v = null;
		ResultSet rs = DBUtils.executeRequete(sql);

		while (rs.next()) {
			
			v = new VOL();

			v.setIdVol(rs.getInt(1));
			v.setDatevol(rs.getDate(2));
			v.setHeureDecalage(rs.getInt(3));
			v.setMinuteDecalage(rs.getInt(4));
			v.setIdPilote(rs.getInt(5));
			v.setIdAvion(rs.getInt(6));
			v.setIdTrajet(rs.getInt(7));

		}
		return v;

	}


	
	
	
	public static Pilote getPilote(int idVol) throws Exception {
		String sql = "select p.* " + 
				" from vol v " + 
				"     inner join pilote p on v.idpilote = p.idpilote " + 
				" where v.idvol =" +idVol;
		
		Pilote p = null;
		ResultSet res = DBUtils.executeRequete(sql);
		
		if(res.next()) {
			
			p= new Pilote();
			p.setIdPilote(res.getInt(1));
			p.setNom(res.getString(2));
			p.setPrenom(res.getString(3));
			p.setAdresse(res.getString(4));
			p.setTel(res.getString(5));
			p.setDateEmbauche(res.getDate(6));
			p.setDateEmbauche(res.getDate(7));
		}
		
		return p;
	}

	public static Avion getAvion(int idVol) throws Exception {
		
		String sql = "select a.* " + 
				"from vol v " + 
				"     inner join avion a on v.idavion = a.idavion " + 
				"where v.idvol ="+idVol;
		
		Avion av = null;
		ResultSet res = DBUtils.executeRequete(sql);
		
		if(res.next()) {
			
			av = new Avion();
			av.setIdAvion(res.getInt(1));
			av.setCompagnie(res.getString(2));
			av.setType(res.getString(3));
			av.setDateMiseMarche(res.getDate(4));	
		}
		
		return av;
	}
	
public static Trajet getTrajet(int idVol) throws Exception {
		
		String sql="select t.* " + 
				"from vol v " + 
				"     inner join trajet t on v.idtrajet = t.idtrajet " + 
				"where v.idvol ="+idVol;
		Trajet t = null;
		ResultSet res = DBUtils.executeRequete(sql);

		if (res.next()) {
			t = new Trajet();

			t.setIdTrajet(res.getInt(1));
			t.setAeroportDepart(res.getString(2));
			t.setAeroportArrivee(res.getString(3));
			t.setDuree_vol(res.getInt(4));
		}

		return t;
	}
	
	/*public static ArrayList<VOL> getAllVol(int idavion) throws Exception {

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
	}*/

	public static int AddVol(VOL v) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		String sql = "INSERT INTO VOL(Datevol,HeureDecalage,MinuteDecalage,idPilote,idAvion,idTrajet) VALUES('"+format.format(v.getDatevol())+"',"+v.getHeureDecalage()+","+v.getMinuteDecalage()+","+v.getIdPilote()+","+v.getIdAvion()+","+v.getIdTrajet()+")";
		return DBUtils.executeRequeteLMD(sql);
	}

	public static int UpdateVols(VOL v) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		String sql = "UPDATE vol"
				+ " SET Datevol = '" + format.format(v.getDatevol())+"' , "
				+ " HeureDecalage = " + v.getHeureDecalage()+","
				+ " MinuteDecalage = " + v.getMinuteDecalage()+","
				+ " idPilote = " + v.getIdPilote()+","
				+ " idAvion = " + v.getIdAvion()+","
				+ " idTrajet = " + v.getIdTrajet()+""
				+ " WHERE idvol = " + v.getIdVol();
		



		return DBUtils.executeRequeteLMD(sql);
	}

	public static int RemoveVol(int id) throws Exception {
		String sql = "DELETE FROM VOL WHERE IDVOL =" + id;
		return DBUtils.executeRequeteLMD(sql);

	}

}
