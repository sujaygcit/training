package com.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			Statement st = con.createStatement();
			
			String query = "select * from tbl_author";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				System.out.println("Author ID: " + rs.getInt("authorId"));
				System.out.println("Author Name:" + rs.getString("authorName"));
			}
			
			Scanner in= new Scanner(System.in);
			System.out.println("Enter a new Author");
			String newAuthorName=in.next();
			st.executeUpdate("insert into tbl_author (authorName) values ('"+newAuthorName+"')");
			
			String updateQuery ="update tbl_author set authorName = ? where authorId = ?";
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1, "Johnson");
			ps.setInt(2,2);
			ps.executeUpdate();
			
			in.close();
			st.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
