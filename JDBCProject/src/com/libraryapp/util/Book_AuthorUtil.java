package com.libraryapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.libraryapp.db.DbConnect;
import com.libraryapp.models.Author;
import com.libraryapp.models.Book;

public class Book_AuthorUtil {

	Connection con = DbConnect.connect();
	PreparedStatement ps = null;

	/* Add, Update , Delete Books */

	public void addBook(Book b) {

		String addQuery = "insert into tbl_book(title,pubId) values (?,?)";
		try {
			ps = con.prepareStatement(addQuery);
			ps.setString(1, b.getTitle());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book b) {

		String updateQuery = "update tbl_book set title = ?, pubId = ? where bookId = ?";
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, b.getTitle());
			ps.setInt(2, b.getPubId());
			ps.setInt(3, b.getBookId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteBook(Book b) {
		String deleteQuery = "delete from tbl_book where bookId = ?";
		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, b.getBookId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* Add, Update, Delete author */

	public void addAuthor(Author a) {
		String addQuery = "insert into tbl_author(authorName) values (?)";
		try {
			ps = con.prepareStatement(addQuery);
			ps.setString(1, a.getAuthorName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAuthor(Author a) {
		String updateQuery = "update tbl_author set authorName = ? where authorId = ?";
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, a.getAuthorName());
			ps.setInt(2, a.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAuthor(Author a) {
		String deleteQuery = "delete from tbl_author where authorId = ?";
		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, a.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
