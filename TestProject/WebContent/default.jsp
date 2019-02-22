<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome home</title>
</head>
<body>
<form action="signup" method ="post">
  User name:<br>
  <input type="text" name="username">
  <br>
  email:<br>
  <input type="text" name="email" >
  <br><br>
  password:<br>
  <input type="text" name="password" >
  <br><br>
  authtoken:<br>
  <input type="text" name="authtoken" >
  <br><br>
  <input type="submit" value="Submit">
  
  <%
							if (request.getAttribute("errorMessage") != null) {
						%>

						<p>Admin registration failed
						<p>

							<%
								}
							%>
</form> 
</body>
</html>