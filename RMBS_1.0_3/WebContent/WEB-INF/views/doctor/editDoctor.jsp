
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function addDoctor(val)
{
var data= $("#RegisterDoctor"+val).serialize();
//alert(data);
$.post('addDoctor.html?flag=1', data, function(result){
//	alert(result);
	$("#col2").html(result);

});


}


</script>
<style type="text/css">
#RegisterDoctor input{
	width: 100px;
}

</style>

</head>
<body>


<form:form method="POST" action="javascript:addDoctor();" commandName="command" id="RegisterDoctor${doctor.did}" name="${doctor.did}">

	<table>
	<tr>
	
		<form:input path="did" id="id" value="${doctor.did}" hidden=""/>
	
  
		
		<form:input path="createdby" id="createdby" value="${doctor.createdby}" hidden="true"/>

		<td><form:input path="doctorName" id="dname" value="${doctor.doctorName}"/></td>
		
		<td><form:input path="initial" id="init" value="${doctor.initial}"/></td>
	
		<td><form:input path="address" id="add" value="${doctor.address}"/></td>

		<td><form:input path="phno" id="phno" value="${doctor.phno}"/></td>
		
		<td><form:input path="email" id="email" value="${doctor.email}"/></td>

		<td><form:input path="qualification" id="qualification" value="${doctor.qualification}"/></td>
	
		<td><form:input path="specialization" id="specialization" value="${doctor.specialization}"/></td>
	
		<td><form:input path="hospitalName" id="hname" value="${doctor.hospitalName}"/></td>
	
	<td>
	<!-- <input type="submit" value="Update"/> <img src="images/save.png" alt="save" height="20px" width="20px" onclick="addAgency(<c:out value="${agency.id}"/>);"/></a>-->
		<input type="button" value="Update" onclick="addDoctor(<c:out value="${doctor.did}"/>);"/>	
		
		</td>
	</tr>
</table>

</form:form>

</body>
</html>