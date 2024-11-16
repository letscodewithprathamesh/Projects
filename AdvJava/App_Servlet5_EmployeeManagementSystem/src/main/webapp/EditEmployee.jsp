<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

AdminBean ab=(AdminBean)session.getAttribute("abean");

EmployeeBean eb=(EmployeeBean)request.getAttribute("ebean"); //we are using employeebean from request object instead session object is because the employee bean object will only hold the particular data field only based on employee id

out.println("Page belongs to Admin : "+ab.getfName()+"<br>");

%>

<form action="update" method="post">

<input type="hidden" name="eid" value=<%=eb.geteId() %>><br> <!-- here hidden form field will pass the eid with request which will help us to update particular field only from dataset -->

Basic Salaray : <input type="text" name="bsal" value=<%= eb.getbSal() %>><br>

HRA (1-100) : <input type="text" name="hra" value=<%= eb.getHra() %>><br>

DA (1-100) : <input type="text" name="da" value=<%= eb.getDa() %>><br>

<input type="submit" value="UpdateEmployee">

</form>


</body>
</html>