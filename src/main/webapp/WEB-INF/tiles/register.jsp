<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="loginUrl" value="/login" />

<div class="row">

	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-3">

		<div class="panel panel-default">




			<div class="panel-heading">
				<div class="panel-title">Registration Form</div>
			</div>


			<div class="login-error">
				<form:errors path="user.*" />
			</div>

			<form:form method="post" modelAttribute="user" class="login-form">

				<div class="input-groups">
					<form:input type="text" path="firstname" placeholder="First name"
						class="form-control" />
					<span class="input-group-btn"></span>
					<form:input type="text" path="surname" placeholder="Surname"
						class="form-control" />
				</div>

				<div class="input-groups">
					<form:input type="text" path="email" placeholder="Email"
						class="form-control" />
				</div>
				<div class="input-groups">
					<form:input type="password" path="plainPassword"
						placeholder="Password" class="form-control" />
				</div>
				<div class="input-groups">
					<form:input type="password" path="repeatPassword"
						placeholder="Repeat Password" class="form-control" />
				</div>
				<div class="input-groups">
					<button type="submit" class="btn-primary pull-right">Register
					</button>
				</div>
			</form:form>

			<div class="panel-body"></div>
		</div>

	</div>

</div>