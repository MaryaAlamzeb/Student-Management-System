
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%@ page import="java.sql.Connection" %>
<%@ page import="com.conn.DatabaseManager" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="style.jsp" %>

    <meta charset="UTF-8">
    <title>Student Management System</title>
</head>
<body class="bg-light">

<%
DatabaseManager manager = DatabaseManager.getInstance();
Connection conn = manager.getConn();
out.print(conn);
%>
    <%@ include file="navbar.jsp" %>

    <div class="container p-3">
        <p class="text-center fs-1"> All Student Details</p>

        <div class="card">
            <div class="card-body">
             <table class="table">
			<thead>
				<tr>
					<th scope="col">Full Name</th>
					<th scope="col">DOB</th>
					<th scope="col">Address</th>
					<th scope="col">Qualification</th>
					<th scope="col">Email</th>
						<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>@fat</td>
						<td>
						<a href="edit_student.jsp " class="btn btn-sm btn-primary"> Edit</a>
<a href="delete_student.jsp " class="btn btn-sm btn-danger ms-1"> Delete</a>

						</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
					<td>@fat</td>
				</tr>
			
			</tbody>
		</table>
            </div>
        </div>

<%--        <div class="mt-3">
    Display connection status and connection string here
    <p>Connection Status: <%= request.getAttribute("connectionStatus") %></p>
    <p>Connection String: <%= request.getAttribute("connectionString") %></p>
</div> --%>

    </div>
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.conn.*" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="style.jsp" %>

    <meta charset="UTF-8">
    <title>Student Management System</title>
</head>
<body class="bg-light">

    <%@ include file="navbar.jsp" %>

    <div class="container p-3">
        <p class="text-center fs-1"> All Student Details</p>

        <div class="card">
            <div class="card-body">
                <table class="table">
               
                </table>
            </div>
        </div>

        <div class="mt-3">
            Display connection status and connection string here
            <p>Database Connection Status: <%= request.getAttribute("connectionStatus") %></p>
            <p>Connection String: <%= request.getAttribute("connectionString") %></p>
        </div>
    </div>
</body>
</html> --%>

