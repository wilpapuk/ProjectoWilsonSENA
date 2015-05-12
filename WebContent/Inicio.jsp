<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<title>hola</title>
<head></head>
<body>
	<sec:authentication var="user" property="principal" />
	
	${user.username}
	
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
	
</body>
</html>