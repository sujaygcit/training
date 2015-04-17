package com.libraryapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.libraryapp.db.DbConnect;
import com.libraryapp.models.Branch;

public class BranchUtil {
	Connection con = DbConnect.connect();
	PreparedStatement ps = null;

	/* Add, Update , Delete Branch */

	public void addBranch(Branch b) {

		String addQuery = "insert into tbl_library_branch(branchName,branchAddress) values (?,?)";
		try {
			ps = con.prepareStatement(addQuery);
			ps.setString(1, b.getBranchName());
			ps.setString(2, b.getBranchAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBranch(Branch b) {

		String updateQuery = "update tbl_branch set branchName = ?, branchAddress=? where branchId = ?";
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, b.getBranchName());
			ps.setString(2, b.getBranchAddress());
			ps.setInt(3, b.getBranchId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteBranch(Branch b) {
		String deleteQuery = "delete from tbl_branch where branchId = ?";
		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, b.getBranchId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getAllBranches(){
		String query = "select * from tbl_library_branch";
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery(query);
			if(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
