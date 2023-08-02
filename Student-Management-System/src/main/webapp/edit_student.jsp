<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="style.jsp"%>
<%@ page import="com.conn.*"%>
<%@ page import="com.dao.*"%>
<%@ page import="com.entity.*"%>
<%@ page import="java.sql.Connection"%>
<meta charset="UTF-8">
<title>Edit Students</title>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">

					<div class="card-body">

						<p class="fs-3 text-center">Edit Student</p>
						<%
						int id = Integer.parseInt(request.getParameter("id"));

						DatabaseManager databaseManager = DatabaseManager.getInstance();

						Connection connection = databaseManager.getConnection();

						StudentDAO studentDao = new StudentDAO(connection);
						
						Student s = studentDao.getStudentById(id);
						%>

						<form action="update" method="post">

							<div class="mb-3">

								<label class="form-label" name="name"> Full Name </label> <input
									tyoe="text" class="form-control" name="name"
									value=<%=s.getName()%>>

							</div>

							<div class="mb-3">
								<label class="form-label"> Email Address </label> <input
									type="email" class="form-control" name="email"
									value=<%=s.getEmail()%>>

							</div>

							<div class="mb-3">
								<label class="form-label"> Qualification </label> <input
									type="text" class="form-control" name="qualification"
									value=<%=s.getQualification()%>>

							</div>


							<div class="mb-3">
								<label class="form-label"> Address </label> <input type="text"
									class="form-control" name="address" value=<%=s.getAddress()%>>

							</div>

							<div class="mb-3">
								<label class="form-label"> Date of Birth </label> <input
									type="date" class="form-control" name="dob"
									value="<%=s.getDob().format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE)%>">
							</div>

							<input type="hidden" class="form-control" name="id"
								value=<%=s.getId()%>>

							<button type="submit" class="btn btn-primary col-md-12">
								Update</button>
						</form>


					</div>


				</div>


			</div>

		</div>
</body>
</html>