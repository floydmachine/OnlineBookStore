<%@include file="include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login</title>
<spring:url value="/resources/adminlogin.css" var="admin" />

<link href="${admin}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
</head>
<body>
	<form:form id="loginForm" method="post" modelAttribute="loginAdmin">
<p class="home"><a href="/OnlineBookStor/start">Main Page</a>						
<h1>Admin Login</h1>
<h4>${error}</h4>
 <label>Username <span>*</span></label>
<form:input id="username" name="username" path="username" value="username" /> 
 
  <label>Password <span>*</span></label>
  <form:password id="password" name="password" path="password" value="password" /> 
   
  
		
<input type="Submit" name="Submit" value="Login">
	</form:form>
</body>
</html>