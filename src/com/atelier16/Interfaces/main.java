package com.atelier16.Interfaces;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.atelier16.Dao.DaoAvion;
import com.atelier16.Dao.DaoPilote;
import com.atelier16.Dao.DaoTrajet;
import com.atelier16.Dao.DaoVol;
import com.atelier16.entities.Avion;
import com.atelier16.entities.Pilote;
import com.atelier16.entities.Trajet;
import com.atelier16.entities.VOL;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*this is for cheking getall fuction
		ArrayList<VOL> vv = DaoVol.getAllVol();
		
		for(VOL pp : vv)
			System.out.println(pp);*/

		/*this for cheking getone function 
		Pilote p = DaoPilote.getonePilote(1);
		Avion v=DaoAvion.getOneAvion(3);
		Trajet t=DaoTrajet.getOneTrajet(5);
		VOL vl=DaoVol.getOneVol(6);
		
		System.out.println(p);
		System.out.println(v);
		System.out.println(t);
		System.out.println(vl);*/
		
		/*for cheking remove function
		int p = DaoPilote.RemovePilote(9);
		int a=DaoAvion.RemoveAvion(3);
		int t=DaoTrajet.RemoveTrajet(5);
		int v=DaoVol.RemoveVol(4);
	
		System.out.println(p);
		System.out.println(a);
		System.out.println(t);
		System.out.println(v);*/
		
		
		/*
		try {
			
			DateFormat  format = new SimpleDateFormat("yyyy/MM/dd");
			
			Pilote p1 =new Pilote(2, "hola", "hassan", "tetouan", "076463633",format.parse("1997/08/11"), format.parse("1997/08/11"));
			
			int p = DaoPilote.AddPilote(p1);
			System.out.println("add succesful");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}*/

		
	/*try {
			
			DateFormat  format = new SimpleDateFormat("yyyy/MM/dd");
			
			Trajet t =new Trajet(33, "casa", "usa", 7);
			
			 DaoTrajet.AddTrajet(t);
			System.out.println("add succesful");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}*/
		
		
		
	/*try {
			
			DateFormat  format = new SimpleDateFormat("yyyy/MM/dd");
			
			Avion a =new Avion(44, "beign", "travel", format.parse("2019/03/22"));
			
			 DaoAvion.AddAvion(a);
			System.out.println("add succesful");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}*/

		
	/*	
		try {
			
			DateFormat  format = new SimpleDateFormat("yyyy/MM/dd");
			
			VOL v =new VOL(56, format.parse("2019/04/30"), 12, 45, 2, 3, 1);
			
			 DaoVol.AddVol(v);
			System.out.println("add succesful");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
*/
		
		/*DateFormat  format = new SimpleDateFormat("yyyy/MM/dd");

		Avion v=new Avion(1, "toooo", "trip", format.parse("2019/02/02"));
	int t=	DaoAvion.UpdateAvion(v);
		
		System.out.println(t);*/
		
		
		/*DateFormat  format = new SimpleDateFormat("yyyy/MM/dd");

		VOL v=new VOL(3, format.parse("2019/22/22"), 3, 03, 3, 3, 3);
	int t=	DaoVol.UpdateVols(v);
		
		System.out.println(t);*/

	


		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		System.out.print(date);
	


	}

}
















