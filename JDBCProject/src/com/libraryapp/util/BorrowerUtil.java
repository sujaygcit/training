package com.libraryapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.libraryapp.db.DbConnect;
import com.libraryapp.models.Borrower;

public class BorrowerUtil {

	Connection con = DbConnect.connect();
	PreparedStatement ps = null;

	/* Add, Update , Delete Publisher */

	public void addBorrower(Borrower b) {

		String addQuery = "insert into tbl_borrower(name,address,phone) values (?,?,?)";
		try {
			ps = con.prepareStatement(addQuery);
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBorrower(Borrower b) {

		String updateQuery = "update tbl_borrower set name = ?, address=?, phone=? where cardNo = ?";
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteBorrower(Borrower b) {
		String deleteQuery = "delete from tbl_borrower where cardNo = ?";
		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, b.getCardNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
