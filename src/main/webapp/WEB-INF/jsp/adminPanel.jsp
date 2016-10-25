<%@include file="include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<spring:url value="/resources/adminPanel.css" var="adminPanel" />

<link href="${adminPanel}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
</head>
<body>
<div class="panel">
<h3>Welcome ${adminloggedin.username}</h3>
<a href="/OnlineBookStor/crudpage">BOOK</a> 
<br/> <br/>
<a href="/OnlineBookStor/usercrud">USER</a>
<br/> <br/>
<a href="${pageContext.request.contextPath}/login/logout">Logout</a>
</div>
</body>
</html>