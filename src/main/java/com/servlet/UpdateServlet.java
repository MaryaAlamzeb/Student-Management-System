package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DatabaseManager;
import com.dao.StudentDAO;
import com.entity.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"), DateTimeFormatter.ISO_LOCAL_DATE);
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		Student s = new Student(id, name, email, qualification, address, dob);
//		StudentDAO dao = new StudentDAO(DatabaseManager.getConn());

		DatabaseManager databaseManager = DatabaseManager.getInstance();

		Connection connection = databaseManager.getConnection();

		StudentDAO dao = new StudentDAO(connection);

		HttpSession session = req.getSession();
		boolean result = dao.updateStudent(s);

		if (result) {

			session.setAttribute("succMsg", "Record successfully updated");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "Record not inserted");
			resp.sendRedirect("index.jsp");

		}
	}

}
