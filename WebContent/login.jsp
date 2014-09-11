<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Login form</title>
	</head>
	<body>
		<h1>Login</h1>
		
		<c:if test="${!empty param.login_error}">
			<div style="color: red; margin-bottom:1em; font-size:large;"> Incorrect username and/or password </div>
		</c:if>
		
		<form action="<c:url value='/j_spring_security_check'/>" method="post">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="j_username"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="j_password"/></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="Login"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
