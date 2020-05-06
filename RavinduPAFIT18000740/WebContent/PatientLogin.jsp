<%@page import="com.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

Patient patientObj = new Patient();

String username = request.getParameter("username");
String password = request.getParameter("password");





%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body>
      <div class="container-sm">
        <div class="p-3 border bg-light">
          <label class="display-4">Patient Login</label>
          <form class="px-4 py-3" action = "EditPatients.jsp" method = "post">
            <div class="form-group">
              <label for="exampleDropdownFormEmail1">Patient User Name:</label>
              <input type="text" id = "pusername" name = "pusername" class="form-control" placeholder="Patient User Name">
            </div>
            <div class="form-group">
              <label for="exampleDropdownFormPassword1">Password</label>
              <input type="password" class="form-control" id="ppassword" name = "ppassword" placeholder="Password">
            </div>
            <button name = "login" id = "login" type="submit" class="btn btn-primary btn-lg">Sign in</button>
          </form>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="PatientRegistration.jsp">Do you have a account? Sign up</a>
        </div>
      </div>
</body>
</html>