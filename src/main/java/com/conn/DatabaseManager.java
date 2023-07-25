package com.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

	private static final String PROPERTIES_FILE = "/config.properties";
	private static DatabaseManager instance;

	private static String dbUrl;
	private static String dbUser;
	private static String dbPassword;
	
	private Connection connection;

	private DatabaseManager() {
		loadDatabaseProperties();
		initializeConnection();
	}

	public static  DatabaseManager getInstance() {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	private void loadDatabaseProperties() {
		try (InputStream input = getClass().getResourceAsStream(PROPERTIES_FILE)) {
			if (input == null) {
				throw new RuntimeException("config.properties file not found!");
			}
			// System.out.println("file found");
			Properties properties = new Properties();
			properties.load(input);

			dbUrl = properties.getProperty("db.url");
			dbUser = properties.getProperty("db.user");
			dbPassword = properties.getProperty("db.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean initializeConnection() {
		try {
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// method to get the connection string
	public String getConnectionString() {
		return dbUrl;
	}

	// method to check if the connection is successful
	public boolean isConnectionSuccessful() {
		return connection != null;
	}

	// ================ Direct testing connection=======//

	public static Connection conn = null;

	public  Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "admin");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
