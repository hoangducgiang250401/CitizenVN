package com.citizen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AbstractDao {
	
	ResourceBundle app = ResourceBundle.getBundle("application");

	public Connection getConnection() {
		try {
			Class.forName(app.getString("driverName"));
			String url = app.getString("url");
			String user = app.getString("user");
			String password = app.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error : getConnection!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
