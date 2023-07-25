package com.conn;

import java.sql.Connection;

/*
 * 
 * Testing db connection
 * 
 */

public class Test {

	public static void main(String[] args) {
		DatabaseManager dbManager = DatabaseManager.getInstance();
		Connection connection = dbManager.getConnection(); // Get the connection object

		if (connection != null) {
			System.out.println("Database Connection Status: Connected");
		} else {
			System.out.println("Database Connection Status: Not Connected");
		}

		System.out.println("Connection String: " + dbManager.getConnectionString());
	}
}
