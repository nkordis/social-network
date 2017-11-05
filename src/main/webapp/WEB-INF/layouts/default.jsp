<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="_csrf" content="${_csrf.token }">
<meta name="_csrf_header" content="${_csrf.headerName }">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title><tiles:insertAttribute name="title" /></title>

<!-- Bootstrap -->
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">

<link href="${contextRoot}/css/main.css" rel="stylesheet">

<!-- This is only for the javascript tagging on the profile -->
<link href="${contextRoot}/css/jquery.tagit.css" rel="stylesheet">

<script src="${contextRoot}/js/jquery-ui.min.js"></script>

<script src="${contextRoot}/js/tag-it.min.js"></script>


</head>

<body>

	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Social Network</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li><a href="/about">About</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<sec:authorize access="!isAuthenticated()">
					<li><a href="${contextRoot }/login">Login</a></li>
					<li><a href="${contextRoot }/register">Register</a></li>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<li><a href="${contextRoot}/profile">Profile</a></li>
					<li><a href="javascript:$('#logoutForm').submit();">Logout</a></li>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_ADMIN')">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Status <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${contextRoot }/addstatus">Add status</a></li>
							<li><a href="${contextRoot }/viewstatus">View status</a></li>
						</ul></li>

				</sec:authorize>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<c:url var="logoutLink" value="/logout"></c:url>
	<form id="logoutForm" method="post" action="${logoutLink }">
		<input type="hidden" name="${_csrf.parameterName }"
			value="${_csrf.token }">



	</form>

	<div class="container">
		<tiles:insertAttribute name="content" />
	</div>


	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>