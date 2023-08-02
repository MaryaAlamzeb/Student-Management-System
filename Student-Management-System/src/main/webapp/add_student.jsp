<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="style.jsp"%>
<meta charset="UTF-8">
<title>Add Students</title>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">

					<div class="card-body">

						<p class="fs-3 text-center">Add Student</p>

						<c:if test="${not empty succMsg }">
							<p class="text-center text success">${succMsg }</p>
							<c:remove var="succMsg" />

						</c:if>

						<c:if test="${not empty succMsg }">
							<p class="text-center text success">${succMsg }</p>
							<c:remove var="succMsg" />

						</c:if>

						<form action="register" method="post">

							<div class="mb-3">

								<label class="form-label" name="name"> Full Name </label> <input
									tyoe="text" class="form-control" name="name">

							</div>
							<div>
								<label class="form-label"> Date of Birth </label> <input
									type="date" class="form-control" name="dob">

							</div>

							<div class="mb-3">
								<label class="form-label"> Address </label> <input type="text"
									class="form-control" name="address">

							</div>

							<div class="mb-3">
								<label class="form-label"> Qualification </label> <input
									type="text" class="form-control" name="qualification">

							</div>

							<div class="mb-3">
								<label class="form-label"> Email Address </label> <input
									type="email" class="form-control" name="email">

							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>


					</div>


				</div>


			</div>

		</div>
</body>
</html>