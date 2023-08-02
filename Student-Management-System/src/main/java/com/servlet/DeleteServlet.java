package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DatabaseManager;
import com.dao.StudentDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		DatabaseManager databaseManager = DatabaseManager.getInstance();

		Connection connection = databaseManager.getConnection();

		StudentDAO dao = new StudentDAO(connection);

		HttpSession session = req.getSession();

		boolean result = dao.deleteStudent(id);

		if (result) {

			session.setAttribute("succMsg", "Student Details Deleted Sccessfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "Student cannot be deleted");
			resp.sendRedirect("index.jsp");

		}

	}

}