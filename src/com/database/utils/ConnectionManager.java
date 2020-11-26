package com.database.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConnectionManager {

	
	public static Connection conn;
	
	
	private ConnectionManager(){
		
	}
	
	public static Connection getInstance() throws Exception{
		
		
		if(conn==null){
			Properties p=new Properties();
			p.load(new FileInputStream("src/com/database/utils/db.properties"));
			Class.forName("com.mysql.jdbc.Driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");

			conn = DriverManager.getConnection(url, user, pwd);

		}
		return conn;
		
	}
}
