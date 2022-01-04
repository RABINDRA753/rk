<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/forms.css">
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
  <h2 style="background-color:skyblue">Login Here</h2>
     <form action="verifyLogin" method="post">
     <pre>

     <label>Email</label>
    <input type="text" id="email" name="email" required="required" placeholder="Enter your email..">

    <label>password</label>
    <input type="password" id="password" name="password" required="required" placeholder="Enter your password..">
    <input type="submit" value="login">
      </pre>
      </form>
  <p style="color:red;">
     <%	
       if(request.getAttribute("errorMsg")!=null){
	   out.println(request.getAttribute("errorMsg"));
       }
     %>
     
      <%	
       if(request.getAttribute("sessionMsg")!=null){
	   out.println(request.getAttribute("sessionMsg"));
       }
     %>
  </p>

</body>
</html>