package com.atelier16.modeltable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.atelier16.entities.Pilote;

public class modelPilote extends AbstractTableModel {

	
	String[] cols={"IdPilote", "Nom", "Prenom", "Adresse", "tel", "DateNaissance", "DateEmbauche"};
	ArrayList<Pilote> pilotes;
	
	public modelPilote(ArrayList<Pilote> pilotes) {
		super();
		this.pilotes = pilotes;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pilotes.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return cols[column];
	}

	@Override
	public Object getValueAt(int r, int c) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		switch (c) {
		case 0: return pilotes.get(r).getIdPilote();
		case 1: return pilotes.get(r).getNom();
		case 2: return pilotes.get(r).getPrenom();
		case 3: return pilotes.get(r).getAdresse();
		case 4: return pilotes.get(r).getTel();
		case 5: return format.format(pilotes.get(r).getDateNaissance());
		case 6: return format.format(pilotes.get(r).getDateEmbauche());
			

		}
		return null;
	}

}
