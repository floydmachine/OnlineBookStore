<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<spring:url value="/resources/start.css" var="userlogin" />

<link href="${userlogin}" rel="stylesheet" />
</head>
<body>
<table>
<tr>
<th>
<div class="tablehead">Main Page</div>
</th>
</tr>
<tr>
<th>
<a href="/OnlineBookStor/home">Home</a> </th>
</tr>
<tr>
<th>
<a href="/OnlineBookStor/login">Admin Login</a> </th>
</tr>
<tr>
<th>
<a href="/OnlineBookStor/userlogin">User Login</a></th>
</tr>
</table>
</body>
</html>