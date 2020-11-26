package com.atelier16.modeltable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.atelier16.Dao.DaoVol;
import com.atelier16.entities.Avion;
import com.atelier16.entities.Trajet;
import com.atelier16.entities.VOL;



public class modelVol extends AbstractTableModel{

	String[] cols = {"Id vol","Date du vol","Heure Decalage","Aeroport Depart","Aeroport Arrivee","Duree Trajet","Compagnie","Type Avion"};
	ArrayList<VOL> vols;
	
	
	
	public modelVol(ArrayList<VOL> vols) {
		super();
		this.vols = vols;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.length;
	}

	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return cols[c];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vols.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Trajet t = DaoVol.getTrajet(vols.get(r).getIdVol());
			Avion a = DaoVol.getAvion(vols.get(r).getIdVol());
			
			switch(c) {
			case 0: return vols.get(r).getIdVol();
			case 1: return format.format(vols.get(r).getDatevol());
			case 2: return String.format("%dH : %dMin", vols.get(r).getHeureDecalage(),vols.get(r).getMinuteDecalage());
			case 3: return t.getAeroportDepart();
			case 4: return t.getAeroportArrivee();
			case 5: return t.getDuree_vol();
			case 6: return a.getCompagnie();
			case 7: return a.getType();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
