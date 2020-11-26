package com.database.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	
	public static ResultSet executeRequete(String sql) throws Exception{
		
		Statement s = ConnectionManager.getInstance().createStatement();
		ResultSet r = s.executeQuery(sql);
		return r;		
	}
	
	public static int executeRequeteLMD(String sql) throws Exception{
		
		Statement s = ConnectionManager.getInstance().createStatement();
		int r = s.executeUpdate(sql);
		return r;		
	}
}
