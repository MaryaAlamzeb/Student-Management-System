
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="com.conn.*" %>
<%@ page import="com.dao.*" %>
<%@ page import="com.entity.*" %>
<%@ page import= "java.util.*" %>

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
        
        <c:if test= "${not empty succMsg }">
      					<p class="text-center text success"> ${succMsg }</p>
      					<c:remove var="succMsg"/>
      					
      					</c:if>
      					
      					<c:if test= "${not empty succMsg }">
      					<p class="text-center text success"> ${succMsg }</p>
      					<c:remove var="succMsg"/>
      					
      					</c:if>

        <div class="card">
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Full Name</th>
                            <th scope="col">Email</th>
                             
                              <th scope="col">Address</th>
                              <th scope="col">Qualification</th>
                            <th scope="col">DOB</th>
                           
                           
                            
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <% 
                   /*  StudentDAO studentDao = new StudentDAO(DatabaseManager.getConn()); */
                   
DatabaseManager databaseManager = DatabaseManager.getInstance();

// Then, get the database connection from the DatabaseManager instance
Connection connection = databaseManager.getConnection();

// Now, you can create your StudentDAO instance passing the database connection
StudentDAO studentDao = new StudentDAO(connection);
                    List<Student> studentList = studentDao.getAllStudents();
                    
                    for(Student s: studentList) {
                    %>
                        <tr>
                            <th scope="row"> <%= s.getName() %> </th>
                            <td> <%= s.getEmail() %> </td>
                            <td> <%= s.getQualification() %> </td>
                               <td> <%= s.getAddress() %> </td>
                            <td> <%= s.getDob() %> </td>
                         
                            
                            
                            <td>
                                <a href="edit_student.jsp?id=<%=s.getId() %>" class="btn btn-sm btn-primary">Edit</a>
                                <a href="delete?id=<%=s.getId() %>" class="btn btn-sm btn-danger ms-1">Delete</a>
                            </td>
                        </tr>
                    <% 
                    }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>

