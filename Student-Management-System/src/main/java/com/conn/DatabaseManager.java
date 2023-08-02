package com.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 
 * Applied Singleton Pattern on Databse Manager So it can be only instantiated once by a single thread
 * 
 * 
 * */
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

	public static synchronized DatabaseManager getInstance() {
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
			Properties properties = new Properties();
			properties.load(input);

			dbUrl = properties.getProperty("db.url");
			dbUser = properties.getProperty("db.user");
			dbPassword = properties.getProperty("db.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initializeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
