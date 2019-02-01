<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Princess Villa</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>
<div class="container">

<div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">

<div class="mx-auto mt-3" style="width: 200px;">

<h3>Add Admin</h3>
</div>
<form action ="addAdmin" method="post"> 
	<div class="form-group">
    <label for="UserName">User Name</label>
    <input type="Text" required class="form-control" name="userName" id="UserName" aria-describedby="userNAme" placeholder="Enter your Name">
    
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" required class="form-control" name="emailAddress" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" required class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="authToken">Auth Token</label>
    <input type="password" required class="form-control" name="authToken" id="authToken" placeholder="Auth Token">
  </div>
    
  <button type="submit" class="btn btn-primary">Sign Up</button>
  <button type="reset" class="btn btn-danger">Reset</button>
</form>


<%
if(request.getAttribute("wasStoredInDB") !=null){%>
	
 <p class="text-danger"> Admin registration failed <p>
 
 <%
}
%>
</div>
</div>
</div>
</div>
</div>

<style type="text/css">
  <%@include file="style.css" %>
</style>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>