package com.masp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/teste";
	private static final String USER = "root";
	private static final String PASS = "aluno";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static DBUtil instancia;
	private Connection con;
	
	private DBUtil() { 
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBUtil getInstancia() { 
		if (instancia == null) { 
			instancia = new DBUtil();
		}
		return instancia;
	}
	
	public Connection openConnection() { 
		if (con == null) { 
			try {
				con = DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void closeConnection() { 
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
	}
}