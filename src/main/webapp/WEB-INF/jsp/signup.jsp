<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
  <head>
  <title>Sign Up</title>
<spring:url value="/resources/signup.css" var="signup" />

<link href="${signup}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
  </head>

  <body>

    
<form:form id="signup" method="post" modelAttribute="user">

<p class="home"><a href="/OnlineBookStor/start">Main Page</a>	
 
<h1>Sign Up </h1> 
  
	<label>First Name </label>
	<form:input id="firstname" name="firstname" path="firstname" value="firstname" /> 
	<form:errors path="firstname" cssClass="error" />
	<br/>
	<label>Last Name</label>
	<form:input id="lastname" name="lastname" path="lastname" value="lastname" />
	<form:errors path="lastname" cssClass="error" />
	<br/>
  	<label>Email </label>
	<form:input id="email" name="email" path="email" value="email address" />
	<form:errors path="email" cssClass="error" />
	<br/>
	
	<label>Password</label>
	<form:password id="password" name="password" path="password" value="password" />
	<form:errors path="password" cssClass="error" />
	<br/>
 	<label>Age </label>
  	<form:input id="age" name="age" path="age"  />
  	<form:errors path="age" cssClass="error" /> 
  	<br/>
  	<label>Gender : </label> 
  	<label>  <input type="radio" name="gender" value="male"> Male </label>
  	<label> <input type="radio" name="gender" value="female"> Female </label>
  	<br/>
  	<form:errors path="gender" cssClass="error" />
	<br/>
	<label>Phone no</label>
	<form:input name="phoneno" path="phoneno"  />
	<form:errors path="phoneno" cssClass="error" />
	<br/>
	<input type="Submit" name="Submit" value="Submit">
	
	<p class="message">Already registered? <a href="/OnlineBookStor/userlogin">Login</a></p>
	
</form:form>
    
</body>
</html>
