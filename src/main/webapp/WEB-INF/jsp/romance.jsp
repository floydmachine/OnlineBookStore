<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Romance</title>
<spring:url value="/resources/div.css" var="divcss" />

<link href="${divcss}" rel="stylesheet" />
<!-- Finish adding tags -->

<style type="text/css">
</style>
</head>
<body>
	<div id="wrapper">
		<div id="inner">
			<div id="header">
				<h1>
					<img src="/OnlineBookStor/resources/images/SD.jpg" width="519"
						height="63" alt="Online Book Store" />
				</h1>
				<div id="nav">
					<a href="/OnlineBookStor/home">HOME</a> ||
					<c:choose> 
					<c:when test="${!empty userloggedin}"> 
					<a href="/OnlineBookStor/logout">LOGOUT</a> ||
					 
					</c:when>
					<c:otherwise>
					<a href="/OnlineBookStor/signup">SIGN UP</a>||
					</c:otherwise>
					</c:choose>
				
				<%-- 	<c:choose> 
					<c:when test="${!empty userloggedin}"> 
					  
					<a href="<c:url value='/OnlineBookStor/myprofile/${user.id}' var='mymprofile'>"My profile </a>
					<c:param name="id" value="${user}"/>
					</c:url> 
					<c:import url="${myprofile}"/>
					</c:when>
					<c:otherwise>
					<
					<a href="/OnlineBookStor/userlogin">LOGIN</a>
					</c:otherwise>
					</c:choose> --%>
				
				</div>
				<img src="/OnlineBookStor/resources/images/bsbanner.jpg" width="744"
					height="145" alt="banner" />
			</div>

			<dl id="browse">
				<dt>Full Category Lists</dt>
				<dd class="first">
					<a href="/OnlineBookStor/literature">Literature</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/comics">Comics</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/history">History</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/manga">Manga</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/sciencefiction">Science Fiction</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/romance">Romance </a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/drama">Drama</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/philosophy">Philosophy</a>
				</dd>
				<dd>
					<a href="/OnlineBookStor/fantasy">Fantasy</a>
				</dd>
		
		
			</dl>
			<div id="body">
			
					
					<c:forEach items="${listRomance}" var="book" begin="1" end="10" step="1">
					<div class="middlebox">
					
						<h3>${book.name}</h3>
						<div class="left">
				<img src="/OnlineBookStor/getImg${book.id}" height="70" width="50"/>
						</div>
						<p>
							<b>Price:</b> <b>${book.price }</b>
						</p>
						<p>
							<b>Author:</b> <b>${book.author}</b>
						</p>
						<p class="readmore">
						<c:if test="${! empty userloggedin}">

						
							<a href="/OnlineBookStor/buy?id=${book.id}" onClick="alert('Thank You for buying');">BUY <b>NOW</b></a>
						
							</c:if>
						</p>
						</div>
				</c:forEach>
					<div class="clear"></div>
				</div>

			</div>
		<!--	<div class="leftdown">
			</div>  -->
			<!-- end body -->
			<div class="clear"></div>
			<div id="footer">Copyright</div>

		</div>
		<!-- end footer -->
	<!-- </div>-->
	<!-- end inner -->

</body>
</html>
