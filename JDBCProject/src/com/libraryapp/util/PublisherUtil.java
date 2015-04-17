package com.libraryapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.libraryapp.db.DbConnect;
import com.libraryapp.models.Publisher;

public class PublisherUtil {

	Connection con = DbConnect.connect();
	PreparedStatement ps = null;

	/* Add, Update , Delete Publisher */

	public void addPublisher(Publisher p) {

		String addQuery = "insert into tbl_publisher(publisherName,publisherAddress) values (?,?)";
		try {
			ps = con.prepareStatement(addQuery);
			ps.setString(1, p.getPublisherName());
			ps.setString(2, p.getPublisherAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePublisher(Publisher p) {

		String updateQuery = "update tbl_publisher set publisherName = ?, publisherAddress=? where publisherId = ?";
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, p.getPublisherName());
			ps.setString(2, p.getPublisherAddress());
			ps.setInt(3, p.getPublisherId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deletePublisher(Publisher p) {
		String deleteQuery = "delete from tbl_publisher where publisherId = ?";
		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, p.getPublisherId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
