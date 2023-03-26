<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNIN</title>
</head>
<body style="background-color: tomato">

<form action="EmployeeController" method="get">

<input type="hidden" name="action" value="signin">
<%
    if(null!=request.getAttribute("message"))
    {
        out.println(request.getAttribute("message"));
    }
%>

<br><br>
Email<input type="text" name="empemailid"><br>
Password<input type="password" name="emppassword"><br>

<input type="submit" value="Login">
</form>

</body>
</html>