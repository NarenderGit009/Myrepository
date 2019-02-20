<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
		<script>
	
		     function check() {
		    	 document.getElementById('eno').value="";
		    	 document.getElementById('ename').value="";
		    	 document.getElementById('eage').value="";
		    	 document.getElementById('esal').value="";
		    	 document.getElementById('eadd').value="";
		    	 
				
			} 
		</script>
		<style type="text/css">
		#addempform{
		margin-left: 20%;
		width: 20%;
		border: 5px solid graytext;
		}
		#emplist{
	
		border: 5px solid graytext;
		margin-left: 45%;
		width: 30%;
		margin-top: -19%;
		background-color: lightblue;
		}
		</style>
	</head>
	<body>
	<a href="employees.html">List of Employees</a><br/>
     <div id="addempform">
     <h2>Add Employee Data</h2>
		<form:form method="POST" action="save.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">Employee ID:</form:label></td>
			        <td><form:input path="id" value="${employee.id}" readonly="true" id="eno"/></td>
			       
			    </tr>
			    <tr>
			        <td><form:label path="name">Employee Name:</form:label></td>
			        <td><form:input path="name" value="${employee.name}" id="ename"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="age">Employee Age:</form:label></td>
			        <td><form:input path="age" value="${employee.age}" id="eage"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="salary">Employee Salary:</form:label></td>
			        <td><form:input path="salary" value="${employee.salary}" id="esal"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="address">Employee Address:</form:label></td>
                    <td><form:input path="address" value="${employee.address}" id="eadd"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/><input type="button" value="Clear" onclick="check();"/></td>
		      </tr>
			</table> 
		</form:form>
		</div>
		<div id="emplist">
  <c:if test="${!empty employees}">
		List Employees
	<table align="left" border="1">
	
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"/></td>
				<td><c:out value="${employee.name}"/></td>
				<td><c:out value="${employee.age}"/></td>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.address}"/></td>
				<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
     </div>
		
	</body>
</html>