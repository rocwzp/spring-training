<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#deleteBtn').click(function(){
			//alert('Delete UserId: '+$('#userId').val());
			
			$.ajax({
			    url: 'deleteUser?id='+$('#userId').val(),
			    type: 'DELETE',
			    success: function(result) {
			        window.location = 'showUsers';
			    }
			});
			
		});
	});
</script>
</head>
<body>
<h2>User Details Form</h2>
	
	<form:form id="userForm" action="updateUser" method="post" commandName="user">
		<div>
			<form:errors path="*"></form:errors>
		</div>
		<form:hidden path="id" id="userId"/>
		<p>Name: <form:input path="name"/></p>
		<p>Email: <form:input path="email"/> </p>
		<p>Age: <form:input path="age"/></p>
		<p>DOB: <form:input path="dob"/></p>
		<p><input type="submit" value="Update">	<input type="button" id="deleteBtn" value="Delete"> </p>
	</form:form>
	<p><a href="showUsers">Back</a></p>
</body>
</html>