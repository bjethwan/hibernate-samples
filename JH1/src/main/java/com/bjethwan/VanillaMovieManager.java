package com.bjethwan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class VanillaMovieManager {
	private Connection connection = null;

	// Database properties
	private String url = "jdbc:mysql://localhost:3306/JH";
	private String driverClass = "com.mysql.jdbc.Driver";
	private String username = "bipin";
	private String password = "jethwani";

	private String insertSql = "INSERT INTO MOVIES VALUES (?,?,?,?)";
	private String selectSql = "SELECT * FROM MOVIES";

	private Connection getConnection() {
		try {
			Class.forName(driverClass).newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.err.println("Exception:"+ ex.getMessage());
		}
		return connection;
	}

	private void persistMovie() {
		try {
			PreparedStatement pst = getConnection().prepareStatement(insertSql);
			pst.setInt(1, 1001);
			pst.setString(2, "Top Gun");
			pst.setString(3, "Action Film");
			pst.setString(4, "Tony Scott");

			// Execute the statement
			pst.execute();
			System.out.println("Movie persisted successfully!");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void queryMovies() {
		try {
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				System.out.println("Movie Found: "
						+ rs.getInt("ID")
						+ ", Title:"
						+ rs.getString("TITLE"));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VanillaMovieManager movieManager = new VanillaMovieManager();
		movieManager.persistMovie();
		movieManager.queryMovies();
	}
}