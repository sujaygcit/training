package com.libraryapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	public static Connection connect() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			System.out.println("Successful");

		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return con;
	}
}

