<%@page import="com.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
<label class = "display-4">Submit Patient Details</label>

<form id="formItem" name="formItem" method="post" action="items.jsp">

<label class="h6 mb-3 font-weight-normal">Patient ID:</label><br>

<input id="patientID" name="patientID" type="text" class="form-control form-control-sm" disabled>

<label class="h6 mb-3 font-weight-normal">User Name:</label><br>

<input id="patientUsername" name="patientUsername" type="text" class="form-control form-control-sm">

<br> <label class="h6 mb-3 font-weight-normal">Password:</label><br>

<input id="patientPassword" name="patientPassword" type="text" class="form-control form-control-sm">

<br> <label class="h6 mb-3 font-weight-normal">Name:</label><br>

<input id="patientName" name="patientName" type="text" class="form-control form-control-sm">

<br> <label class="h6 mb-3 font-weight-normal">Address:</label><br>

<input id="patientAddress" name="patientAddress" type="text" class="form-control form-control-sm">

<br><label class="h6 mb-3 font-weight-normal">Contact:</label><br>

<input id="patientContact" name="patientContact" type="text" class="form-control form-control-sm">

<br><label class="h6 mb-3 font-weight-normal">Email:</label><br>

<input id="patientEmail" name="patientEmail" type="text" class="form-control form-control-sm">

<br>

<input id="insertPatient" name="insertPatient" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidPatientSIDSave" name="hidPatientIDSave" value="" +  + "">

</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

<br>

<div id="divItemsGrid">
 <%
 Patient patientObj = new Patient();
 out.print(patientObj.readItems());
 %>
</div>

</body>
</html>