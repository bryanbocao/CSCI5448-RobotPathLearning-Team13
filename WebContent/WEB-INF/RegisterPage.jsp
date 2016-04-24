<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<!-- Custom styles for this page -->
<spring:url value="/css/signin.css" var="signinCSS" />

</head>

<body>
	<!--register-->
	<div id="registerModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center">Register</h1>
				</div>
				<div class="modal-body">
					<form:form id="registerForm" method="post" action="register"
						class="form col-md-12 center-block" commandName="userForm">
						<div class="form-group">
							<form:input type="text" path="username" name="username"
								id="username" cssClass="form-control input-lg"
								placeholder="Username" />
						</div>
						<div class="form-group">
							<form:password name="password" id="password" path="password"
								class="form-control input-lg" placeholder="Password" />
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">Register</button>
						</div>
					</form:form>
					
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	
	<c:if test="${errormessage != null}">
	<script>
		alert("${errormessage}");
	</script>
	</c:if>

</body>
</html>
