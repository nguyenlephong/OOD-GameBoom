package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConnection {
	private static final String ResultSet = null;
	public static Connection conn;
	public static Statement stmt = null;

	public static Connection getConnection() {
		if (conn != null)
			return conn;
		String url = "jdbc:sqlite:LuuGame.db";
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
		}
		return conn;
	}
}
