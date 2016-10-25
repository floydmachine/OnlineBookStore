<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<spring:url value="/resources/userlogin.css" var="userlogin" />

<link href="${userlogin}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
</head>
<body>


<form:form id="user" method="post" modelAttribute="user">
<p class="home"><a href="/OnlineBookStor/start">Main Page</a>					
<h1>User Login</h1>
<h4>${error}</h4>
 <label>Email Address <span>*</span></label>
<form:input id="email" name="email" path="email" value="email address" /> 
 
  <label>Password <span>*</span></label>
  <form:password id="password" name="password" path="password" value="password" /> 
    
<input type="Submit" name="Submit" value="Login">

<p class="message">Not registered? <a href="/OnlineBookStor/signup">Register</a></p>
						</form:form>
					
</body>
</html>