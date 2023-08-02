package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDAO {

	Connection conn;

	public StudentDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean addStudent(Student student) {
		boolean f = false;
		try {
			String insertQuery = "INSERT INTO students (name, email, qualification, address, dob) VALUES (?, ?, ?, ?, ?)";

			// resources defined within the try block are automatically closed
			try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
				preparedStatement.setString(1, student.getName());
				preparedStatement.setString(2, student.getEmail());
				preparedStatement.setString(3, student.getQualification());
				preparedStatement.setString(4, student.getAddress());

				// converting LocalDate to java.sql.Date
				Date dobDate = Date.valueOf(student.getDob());
				preparedStatement.setDate(5, dobDate);

				int rowsInserted = preparedStatement.executeUpdate();

				if (rowsInserted == 1) {
					f = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean updateStudent(Student student) {
		boolean f = false;
		try {
			String updateQuery = "UPDATE students SET name=?, email=?, qualification=?, address=?, dob=?  WHERE id=?";

			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getQualification());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, java.sql.Date.valueOf(student.getDob()));
			preparedStatement.setInt(6, student.getId());
			int rowsInserted = preparedStatement.executeUpdate();

			if (rowsInserted == 1) {
				return f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteStudent(int id) {

		boolean f = false;

		PreparedStatement ps = null;

		try {
			String sql = "DELETE FROM students WHERE id = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return f;
	}

	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<>();
		Student s = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM students";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				s = new Student();

				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setQualification(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setDob(rs.getDate(6).toLocalDate());
				studentList.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return studentList;
	}

	public Student getStudentById(int id) throws SQLException {
		Student s = null;
		String query = "SELECT * FROM students WHERE id = ?";

		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					s = new Student();

					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setEmail(rs.getString(3));
					s.setQualification(rs.getString(4));
					s.setAddress(rs.getString(5));
					s.setDob(rs.getDate(6).toLocalDate());

				}
			}
		}

		return s;
	}
}
