<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
	<!--register-->
	<div id="registerModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center">Registration Successful!</h1>
				</div>
				<div class="modal-body">
					<form:form id="linkForm" method="get" action="login"
						class="form col-md-12 center-block" commandName="userForm">
						
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">Login</button>
						</div>
					</form:form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

</body>
</html>