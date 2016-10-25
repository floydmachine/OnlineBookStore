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



<form:form action="/OnlineBookStor/usercrud/adduser" commandName="user">
<h1> Add User </h1>

<table>
	<c:if test="${!empty user.firstname}">
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
			<c:if test="${!empty user.firstname}">
				<input type="submit"
					value="<spring:message text="Edit User"/>" />
			</c:if>
			<c:if test="${empty user.firstname}">
				<input type="submit"
					value="<spring:message text="Add User"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>

<c:if test="${!empty listUsers}">
	<table>
	 <tr>
	
	<th colspan="10"> <div class="tablehead">User List</div> </th> 
	
	</tr> 
	<tr>
		<th width="80">User ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">Email</th>
		<th width="120">Password</th>
		<th width="120">Age</th>
		<th width="120">Gender</th>
		<th width="120">Phone No</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td align="center" width="80">${user.id}</td>
			<td align="center" width="120">${user.firstname}</td>
			<td align="center" width="120">${user.lastname}</td>
			<td align="center" width="120">${user.email}</td>
			<td align="center" width="120">${user.password}</td>
			<td align="center" width="120">${user.age}</td>
			<td align="center" width="120">${user.gender}</td>
			<td align="center" width="120">${user.phoneno}</td>
			<td align="center" width="60"><a href="<c:url value='/edituser/${user.id}' />" >Edit</a></td>
			<td align="center" width="60"><a href="<c:url value='/removeuser/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<div class="logout"> 	
<c:if test="${!empty adminloggedin}"> 
			<a href="/OnlineBookStor/login/logout">LOGOUT</a>
</c:if>
</div>
</body>
</html>