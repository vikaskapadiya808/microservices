<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Find Account</title>
</head>
<body>
	<h2>Find Account</h2>
	<form method="post"
		action="${pageContext.request.contextPath}/account/find.htm">
		Account No: <input type="text" name="accountNo" /><br> <input
			type="submit" value="show" />
	</form>
</body>
</html>