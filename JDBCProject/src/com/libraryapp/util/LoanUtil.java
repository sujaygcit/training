package com.libraryapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.libraryapp.db.DbConnect;
import com.libraryapp.models.Book;
import com.libraryapp.models.Borrower;
import com.libraryapp.models.Branch;

public class LoanUtil {

	Connection con = DbConnect.connect();
	PreparedStatement ps = null;

	/* Overriding due date for a book loan*/
	public void overrideDue(Book b, Branch br, Borrower bo, String date) {

		String query = "update tbl_book_loans set dueDate = ? where bookId = ? and branchId = ? and cardNo = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, date);
			ps.setInt(2, b.getBookId());
			ps.setInt(3, br.getBranchId());
			ps.setInt(4, bo.getCardNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
