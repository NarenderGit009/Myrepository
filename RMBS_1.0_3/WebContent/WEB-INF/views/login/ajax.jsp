<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Jquery Ajax Demo</title>
<style>
Table.GridOne {
	padding: 3px;
	margin: 0;
	background: lightyellow;
	border-collapse: collapse;	
	width:35%;
}
Table.GridOne Td {	
	padding:2px;
	border: 1px solid #ff9900;
	border-collapse: collapse;
}
</style>
<script type="text/javascript">
function madeAjaxCall(){
	alert( $("#lastname").val());
	$.ajax({
		type: "post",
		url: "http://localhost:8084/MedProj/employee/add.html",
		cache: false,				
		data:'firstname=' + $("#firstname").val() + "&lastname=" + $("#lastname").val() + "&email=" + $("#email").val(),
		
		success: function(user){
			$('#websitemenu').html("vxvcvx");
			// $(".registerform").html(" vxcvxcv");
			//document.getElementById('replace').innerHTML = '/wesitemenu.jsp'; 
			var obj = JSON.parse(user);
			$('#websitemenu').html("First Name:- " + obj.firstname +"</br>Last Name:- " + obj.lastname  + "</br>Email:- " + obj.email);
		},
		error: function(){						
			alert('Error while request..');
		}
	});
}
</script>
</head>
<body>

	<form name="employeeForm" method="post" id="replace">	
		<table cellpadding="0" cellspacing="0" border="1" class="GridOne">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname" id="firstname" value=""></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" id="lastname" value=""></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="madeAjaxCall();"></td>
			</tr>
		</table>
	</form>
	 <h1>Spring Framework Jquery Ajax Demo</h1>
	<div id="result"></div>
</body>
</html>