<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
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

<!-- Validate form -->
<script src="js/jquery-2.2.3.js"></script>
<script type="text/javascript" src="js/validateForm.js"></script>


</head>

<body>
	<!--login-->
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center">Login</h1>
				</div>
				<div class="modal-body">
					<form:form id="loginForm" method="post" action="login"
						class="form col-md-12 center-block" modelAttribute="loginBean">
						<div class="form-group">
							<form:input type="text" path="username" name="username"
								id="username" cssClass="form-control input-lg"
								placeholder="Username" />
						    <font color='red'><p id="displayUsernameError"></p></font>
						</div>
						<div class="form-group">
							<form:password name="password" id="password" path="password"
								class="form-control input-lg" placeholder="Password" />
                             <font color='red'><p id="displayPasswordError"></p></font>
						</div>
						<div class="form-group">
							<button id="signInButton" class="btn btn-primary btn-lg btn-block">Sign In</button>
							<span class="pull-right"><a
								href="<spring:url value="/register" />">Register</a></span>
						</div>
					</form:form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

</body>

</html>
