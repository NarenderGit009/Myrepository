
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
function addAgency(val)
{
var data= $("#RegisterAgency"+val).serialize();
//alert(data);
$.post('addAgency.html?flag=1', data, function(result){
//	alert(result);
	$("#contentbody").html(result);

});


}


</script>
<style type="text/css">
#RegisterAgency input{
	width: 100px;
}

</style>

</head>
<body>


<form:form method="POST" action="javascript:addAgency();" commandName="command" id="RegisterAgency${agency.id}" name="${agency.id}">

	<table>
	<tr>
	
		<form:input path="id" id="id" value="${agency.id}" hidden="true"/>
	
  
		
		<form:input path="createdby" id="createdby" value="${agency.createdby}" hidden="true"/>

		<td><form:input path="agencyName" id="aname" value="${agency.agencyName}"/></td>
	
		<td><form:input path="address" id="add" value="${agency.address}"/></td>

		<td><form:input path="phno" id="phno" value="${agency.phno}"/></td>

		<td><form:input path="cstNo" id="cstNo" value="${agency.cstNo}"/></td>
	
		<td><form:input path="dlNo1" id="dlNo1" value="${agency.dlNo1}"/></td>
	
		<td><form:input path="dlNo2" id="dlNo2" value="${agency.dlNo2}"/></td>
	
	<td>
	<!-- <input type="submit" value="Update"/> <img src="images/save.png" alt="save" height="20px" width="20px" onclick="addAgency(<c:out value="${agency.id}"/>);"/></a>-->
		<input type="button" value="Update" onclick="addAgency(<c:out value="${agency.id}"/>);"/>	
		
		</td>
	</tr>
</table>

</form:form>

</body>
</html>