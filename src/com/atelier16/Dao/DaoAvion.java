package com.atelier16.Dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.atelier16.entities.Avion;
import com.atelier16.entities.VOL;
import com.database.utils.DBUtils;

public class DaoAvion {

	public static ArrayList<Avion> getAllAvion() throws Exception {
		ArrayList<Avion> avions = new ArrayList<>();
		String sql = "SELECT * FROM AVION";

		ResultSet rs = DBUtils.executeRequete(sql);

		while (rs.next()) {
			Avion v = new Avion();
			v.setIdAvion(rs.getInt(1));
			v.setCompagnie(rs.getString(2));
			v.setType(rs.getString(3));
			v.setDateMiseMarche(rs.getDate(4));

			avions.add(v);

		}
		return avions;

	}

	
	public static ArrayList<Integer> getAllidAvion() throws Exception{
		
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT idavion FROM avion";
		
		ResultSet r = DBUtils.executeRequete(sql);
		
		while(r.next()) {
			ids.add(r.getInt(1));
		}
		return ids;
	}

	
	public static Avion getOneAvion(int idavion) throws Exception {
		String sql = "SELECT * FROM AVION WHERE IDAVION=" + idavion;
		Avion v = null;
		ResultSet rs = DBUtils.executeRequete(sql);

		while (rs.next()) {
			v=new Avion();
			v.setIdAvion(rs.getInt(1));
			v.setCompagnie(rs.getString(2));
			v.setType(rs.getString(3));
			v.setDateMiseMarche(rs.getDate(4));

		}
		return v;

	}

	public static ArrayList<VOL> getAllVol(int idavion) throws Exception {

		ArrayList<VOL> vols = new ArrayList<>();

		String sql = "SELECT * FROM VOL WHERE IDAVION =" + idavion;

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

	public static int AddAvion(Avion v) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		String sql = "INSERT INTO Avion(Compagnie,Type,DateMiseMarche) VALUES('" + v.getCompagnie() + "','"+ v.getType() + "','" + format.format(v.getDateMiseMarche()) + "')";
		return DBUtils.executeRequeteLMD(sql);
	}

	public static int UpdateAvion(Avion v) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String sql = "Update Avion " 
				+ "set compagnie ='" + v.getCompagnie() + "'," 
				+ "type ='" + v.getType() + "',"
				+ "DateMiseMarche='" + format.format(v.getDateMiseMarche())+"'"
				+ "where idavion=" + v.getIdAvion();
	
		

		return DBUtils.executeRequeteLMD(sql);
	}

	public static int RemoveAvion(int id) throws Exception {
		String sql = "DELETE FROM AVION WHERE IDAVION =" + id;
		return DBUtils.executeRequeteLMD(sql);

	}


}
