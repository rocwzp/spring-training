<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<script type="text/javascript" src="resources/js/app.js"></script>
</head>
<body>
	<c:if test="${error != null}">
		<p style="color: red;">Error: ${error}
	</c:if>
	
	<form:form action="login" method="post" modelAttribute="user">
		<p><spring:message code="label.email"/> : <form:input path="email"/></p>
		<p>Password: <form:password path="password"/></p>
		<p><input type="submit" value="Login"></p>
		<p>New User? <a href="#">Register</a></p>
		
	</form:form>
	
</body>
</html>