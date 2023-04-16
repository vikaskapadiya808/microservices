<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
	</head>
	<body>
	   <form action="${pageContext.request.contextPath}/jLogin.htm" method="post">
		   User name : <input type="text" name="j_username"><br>
		   Password: <input type="text" name="j_password"><br>
		   <input type="submit" value="login">
	   </form>
	</body>
</html>