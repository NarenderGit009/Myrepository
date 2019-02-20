<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

 .wrapper {
 font-family:calibri;
    font-size: 15px;
    color: #736F69;
}



.wrapper input[type=text] {
    
    width: 140px;
 }
 .wrapper input[type=password] {
    
    width: 140px;
 }
.wrapper label {
    width:80px;
    
    display: inline-block;
}
 .wrapper input[type=submit]{
 float: right;
 background: url("images/green.png") repeat scroll 0 0 transparent;
 border: none;
 color: #fff;
 font-weight: bold;
 }
@media only screen   
and (max-width:750px) {
.wrapper{
   width: 97%;
}
}
@media only screen and (min-width:750px) and (max-width: 980px) {
.wrapper{
   width: 90%;
  margin: auto;
}
.wrapper input[type=text] {
    
    width: 120px;
 }
}
</style>



</head>
<body>

 <!--Horizontal Tab-->
        <div id="horizontalTab">
            <ul class="resp-tabs-list">
                <li>User Login</li>
                <li>Registration</li>
               
            </ul>
            <div class="resp-tabs-container">
                <div>
                <h3>Login here</h3>

<div class="wrapper">

<form:form method="POST" action="validateLogin.html">

	
	
	   <div>
	   <label><form:label path="userName">User Name</form:label></label>
	   <form:input path="userName" placeholder="Enter User Name"/>
	    </div>
	
	
	    <div>
	    <label><form:label path="password">Password</form:label></label>
	    <form:password path="password" placeholder="Enter Password"/>
	    </div>
		
		<div >
			<input type="submit" value="Login"/>
		</div>
         <div class="errormsg"><c:out value="${loginerrormessage}"/></div>
        
</form:form>
<%-- <div><a href="#">Create Account</a></div>--%>
</div> </div>
                <div>
                    <jsp:include page="/WEB-INF/views/login/registrationform.jsp"></jsp:include>
                </div>
              
            </div>
        </div>



</body>
</html>