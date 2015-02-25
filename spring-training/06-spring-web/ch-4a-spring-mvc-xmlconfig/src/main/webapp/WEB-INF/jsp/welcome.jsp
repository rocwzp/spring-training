<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>Welcome</h2>
	<a href="logout">Logout</a>
	
	Countries : ${Countries}
	States: ${States}<br/>
	Email  : ${user.email}
	
	<br/>
	MyName: ${MyName}
</body>
</html>