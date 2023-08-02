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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"), DateTimeFormatter.ISO_LOCAL_DATE);
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");

		Student s = new Student(name, email, address, qualification, dob);

		DatabaseManager databaseManager = DatabaseManager.getInstance();

		Connection connection = databaseManager.getConnection();

		StudentDAO dao = new StudentDAO(connection);

		HttpSession session = req.getSession();

		boolean result = dao.addStudent(s);

		if (result) {

			session.setAttribute("succMsg", "Record successfully inserted");
			resp.sendRedirect("add_student.jsp");
		} else {
			session.setAttribute("errorMsg", "Record not inserted successsfully");
			resp.sendRedirect("add_student.jsp");

		}

	}

}
