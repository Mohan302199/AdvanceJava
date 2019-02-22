<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="login" method ="post">
  
  email:<br>
  <input type="text" name="email" >
  <br><br>
  password:<br>
  <input type="text" name="password" >
  <br><br>
  
  <input type="submit" value="Submit">
  <%
							if (request.getAttribute("errorMessage") != null) {
						%>

						<p>login failed
						<p>

							<%
								}
							%>
</form> 
</body>
</html>