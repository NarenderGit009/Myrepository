<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
<style type="text/css">

.loginbodycontents{
width: 100%;
min-height: 100%;
table-layout: fixed;

}
.welcomecontent{
width: 50%;

}
.registrationcontent{

}
.websitemenu{
width: 5%;
min-height: 100%;

}
.welcomecontent div{
 display: none;
 box-shadow: 1px 1px 10px 7px #555555 ;

height: 400px;
width: 80%;
overflow: auto;
padding-left:10px;
padding-bottom: 10px;
padding-right:10px;
border-radius: 5px 5px 5px 5px;
}

</style>
</head>
<body class="">
<div class="loginbody">
<table class="loginbodycontents" border="0">
<tr>
<td id="websitemenu">
<!--<jsp:include page="/WEB-INF/views/login/websitemenu.jsp"></jsp:include>-->
<!--<jsp:include page="/WEB-INF/views/login/ajax.jsp"></jsp:include>-->
</td>
<td class="welcomecontent">
<div id="homediv"><jsp:include page="/WEB-INF/views/website/home.jsp"></jsp:include></div>
<div id="aboutusdiv"><jsp:include page="/WEB-INF/views/website/aboutUs.jsp"></jsp:include></div>
<div id="productsdiv"><jsp:include page="/WEB-INF/views/website/products.jsp"></jsp:include></div>
<div id="servicesdiv"><jsp:include page="/WEB-INF/views/website/careers.jsp"></jsp:include></div>
<div id="contactusdiv"><jsp:include page="/WEB-INF/views/website/contactUs.jsp"></jsp:include></div>


</td>
<td class="registrationcontent"><jsp:include page="/WEB-INF/views/login/registrationform.jsp"></jsp:include></td>
</tr>
</table>
</div>
</body>
</html>