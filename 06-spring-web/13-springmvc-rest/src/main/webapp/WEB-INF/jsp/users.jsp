<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShowUsers</title>
</head>
<body>
	<div>
		<p>${msg}</p>
	</div>
	<div>
		<p><a href="createUser">Create New User</a></p>
	</div>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Edit</th>
			</tr>
		</thead>
	<tbody>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.email}</td>
			<td><a href="showUser?id=${user.id}">Edit</a></td>
		</tr>
	</c:forEach>
	
	</tbody>
	</table>
	
</body>
</html>