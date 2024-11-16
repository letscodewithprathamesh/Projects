<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");

String msg=(String)request.getAttribute("msg");

out.println("Page Belongs to Admin : "+ab.getfName()+"<br>");

out.println(msg);
%>

<a href="Employee.html">Add Employee</a>
<a href="view">View All Employee</a>
<a href="logout">Logout</a>


</body>
</html>