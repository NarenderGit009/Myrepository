<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
#ErrorContent{
width: 50%;

border: 5px solid grey;
margin: auto;
z-index: 1;
border-radius: 5px 5px 5px 5px;
}
#ErrorContent a{
text-decoration: none;
text-align: center;
}
#ErrorContent h2{
background-color: grey;
color: white;

width: 100%;
margin-top: 0px;
}
</style>
</head>
<body>
<div id="ErrorContent">
<h2>Error Page</h2>
<h3 align="justify">Unauthorized Access<img src="images/error.png" alt="edit" height="20px" width="20px" align="middle"/></h3>
<br>
Invalid session or session expired.<br>Please login again.<br>
Thank you......<br>
<b><a href="index.html">Click here to re-login..........</a></b>
</div>
</body>
</html>