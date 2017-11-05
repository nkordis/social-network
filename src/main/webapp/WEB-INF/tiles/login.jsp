<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="loginUrl" value="/login" />
<c:set var="registerUrl" value="/register"/>

<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-3 register-prompt">
		Please log in or click <a href="${registerUrl}">here to create an account.</a>  It's free!</div>
</div>

<div class="row">

	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-3">

		<div class="panel panel-default">




			<div class="panel-heading">
				<div class="panel-title">User Log In</div>
			</div>

			<c:if test="${param.error != null }">
				<div class="login-error">Incorrect username or password.</div>
			</c:if>


			<form method="post" action="${loginUrl}" class="login-form">
				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }">

				<div class="input-groups">
					<input type="text" name="username" placeholder="Username"
						class="form-control">
				</div>
				<div class="input-groups">
					<input type="password" name="password" placeholder="Password">
				</div>
				<div class="input-groups">
					<button type="submit" class="btn-primary pull-right">Sign
						In</button>
				</div>
			</form>

			<div class="panel-body"></div>
		</div>

	</div>

</div>