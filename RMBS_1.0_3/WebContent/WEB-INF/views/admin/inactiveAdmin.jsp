<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><h2>Hello&nbsp;<c:out value="${Logger.firstname}"/>&nbsp;<c:out value="${Logger.lastname}"/></h2></p>
<p><c:out value="${Logger.email}"/></p>
<p><c:if test="${Logger.active =='N'}" >
 Your are registered successfully ....
 For your activation <a href="#">click here</a> for your activation......
</c:if> </p>
</body>
</html>