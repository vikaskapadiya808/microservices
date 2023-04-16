<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<p>welcome user 
<security:authentication property="principal.username"/></p>
<a href="${pageContext.request.contextPath}/j_logout.htm">Logout</a>