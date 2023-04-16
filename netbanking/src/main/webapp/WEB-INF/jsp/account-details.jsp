<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Account Details</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
	
	
	   <h2>Account Information</h2>
	   <p style="font-size: 22px">
		   Account No: ${account.accountNo}<br/>
		   Account Holder Name: ${account.accountHolderName}<br/>
		   Account type : ${account.accountType }<br/>
		   IFsc Code: ${account.ifscCode }<br/>
		   Balance : ${account.balance}<br/>
	   </p>
	</body>
</html>