<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>

<title>Book Page</title>
<spring:url value="/resources/crud.css" var="crud" />

<link href="${crud}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
</head>
<body>
	<form:form action="/OnlineBookStor/addbook" method="POST" commandName="book" enctype="multipart/form-data">
		<h1>Add Book</h1>
		<table>
			<c:if test="${!empty book.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="author">
						<spring:message text="Author" />
					</form:label></td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:input path="category" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">
						<spring:message text="Quantity" />
					</form:label></td>
				<td><form:input path="quantity" /></td>
			</tr>
			
				<tr>
				<td> Image </td>
				<td><input type="file" name="file"></td>
			</tr>

			
			<tr>
				<td colspan="2"><c:if test="${!empty book.name}">
						<input type="submit" value="<spring:message text="Edit Book"/>" />
					</c:if> <c:if test="${empty book.name}">
						<input type="submit" value="<spring:message text="Add Book"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>

	<c:if test="${!empty listBooks}">
		<table>
			<tr>

				<th colspan="8">
					<div class="tablehead">Book List</div>
				</th>

			</tr>

			<tr>
				<th width="80">Book ID</th>
				<th width="160">Book Name</th>
				<th width="160">Author</th>
				<th width="120">Category</th>
				<th width="120">Price($)</th>
				<th width="120">Quantity</th>
				<th width="120">Image</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listBooks}" var="book">
				<tr>
					<td align="center" width="80">${book.id}</td>
					<td align="center" width="120">${book.name}</td>
					<td align="center" width="120">${book.author}</td>
					<td align="center" width="120">${book.category}</td>
					<td align="center" width="120">${book.price}</td>
					<td align="center" width="120">${book.quantity}</td>
					<td align="center" width="120">${book.image}</td>
					<td align="center" width="60"><a
						href="<c:url value='/editbook/${book.id}' />">Edit</a></td>
					<td align="center" width="60"><a
						href="<c:url value='/removebook/${book.id}' />">Delete</a></td>
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