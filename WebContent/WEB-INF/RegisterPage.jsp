<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>
</head>
  <body>

   <div align="center">
        <form:form action="register" method="post" commandName="userForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>

  </body>
</html>
