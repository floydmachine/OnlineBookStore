<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserCrud Operation</title>
<spring:url value="/resources/crud.css" var="crud" />

<link href="${crud}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
</head>
<body>



<form:form action="/OnlineBookStor/home" >
<h1> My Profile </h1>

<table>
	<c:if test="${!empty user}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstname">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstname" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastname">
				<spring:message text="Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastname" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="age">
				<spring:message text="Age"/>
			</form:label>
		</td>
		<td>
			<form:input path="age" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="gender">
				<spring:message text="Gender"/>
			</form:label>
		</td>
		<td>
			<form:radiobutton path="gender" value="male"/>Male 
			<form:radiobutton path="gender" value="female"/>Female 
			
		</td>
		
	</tr>
		<tr>
		<td>
			<form:label path="phoneno">
				<spring:message text="Phone No"/>
			</form:label>
		</td>
		<td>
			<form:input path="phoneno" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty user}">
				<input type="submit"
					value="<spring:message text="Edit User"/>" />
			</c:if>
			
		</td>
	</tr>
</table>	
</form:form>
</body>
</html>