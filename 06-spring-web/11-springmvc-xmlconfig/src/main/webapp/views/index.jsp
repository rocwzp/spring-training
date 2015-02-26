<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h2>Create User</h2>
	<%-- <form action="saveUser.do" method="post">
		<p>Name: <input type="text" name="name" value="${user.name}"></p>
		<p>Email: <input type="text" name="email" value="${user.email}"></p>
		<p>Age: <input type="text" name="age" value="${user.age}"></p>
		
		<p><input type="submit" value="Submit"></p>
	</form>
	 --%>
	<form:form action="saveUser.do" method="post" commandName="user">
	<h2>Spring Form</h2>
		<div>
			<form:errors path="email"></form:errors>
		</div>
		<p>Name: <form:input path="name"/></p>
		<p>Email: <form:input path="email"/> </p>
		<p>Age: <form:input path="age"/><form:errors path="age"></form:errors></p>
		<p>DOB: <form:input path="dob"/></p>
		<p><input type="submit" value="Submit">	</p>
	</form:form>
	
	
	<h2>Submitted Details</h2>
	<p>Name: ${user.name }</p>
	<p>Email: ${user.email}</p>
	<p>Age: ${user.age}</p> 
	
</body>
</html>