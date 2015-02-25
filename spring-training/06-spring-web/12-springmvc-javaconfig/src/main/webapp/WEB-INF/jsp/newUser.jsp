<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
<h2>Create User Form</h2>
	
	<form:form action="createUser" method="post" commandName="user">
		<div>
			<form:errors path="*"></form:errors>
		</div>
		<p>Name: <form:input path="name"/></p>
		<p>Email: <form:input path="email"/> </p>
		<p>Age: <form:input path="age"/></p>
		<p>DOB: <form:input path="dob"/></p>
		<p><input type="submit" value="Submit">	</p>
	</form:form>
	<p><a href="showUsers">Back</a></p>
	
</body>
</html>