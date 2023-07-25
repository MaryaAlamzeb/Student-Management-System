package com.conn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckConnectionServlet")
public class CheckConnectionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatabaseManager dbManager = DatabaseManager.getInstance();
		boolean connectionStatus = dbManager.initializeConnection();
		String connectionString = dbManager.getConnectionString();

		request.setAttribute("connectionStatus", connectionStatus);
		request.setAttribute("connectionString", connectionString);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
