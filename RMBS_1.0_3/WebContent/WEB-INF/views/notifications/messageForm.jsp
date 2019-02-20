
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<script type="text/javascript" src="js/masters/doctorFormValidation.js"></script>
<link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message Form</title>

<script type="text/javascript">

function addMessage()
{
var data= $("#messageRequest").serialize();
alert(data);

$.post('saveMessage.html', data, function(result){
	alert(result);
	$("#messageRequest").get(0).reset();	
	$(".col2").html(result);
	
	

	//clearVals();

//$('#msg').html(obj.model.msg).css("color", "orange");
});
//$("#msg").css("width", "200px");

}

</script>
<style type="text/css">
.MessageForm{

}
.MessageForm{
   position: relative;
    background-color: #EFF0F0;
    border: 1px solid  #3C873C;
    width: 350px;
    padding: 5px;
    font-family:calibri;
    font-size: 15px;
    color: #736F69;
    border-radius: 3px;
	float: right;
}
@media only screen   
and (max-width:750px) {
.MessageForm{
   width: 90%;
}
}


.pac-container{
/*width: 152px; position: absolute; left: 1036px; top: 474px; display: none;*/
background-image:url(images/registeragency1.jpg);
background-position: center;
color: white;
margin-top: -20px;
}


.actionlink a{
	text-decoration: none;
	background-color: lightblue;
	text-decoration: blink;
	padding: 5px;
	color: white;
	font-weight: bold;
	margin: 10px;
	float: right;
	}   
	a{
	text-decoration: none;
	}  
	#userdetails{
	background-image:url(images/listbackground1.jpg);
	}
	.error {
	color: #ff0000;
	font-style: italic;
	}

</style>
</head>
<body>

<div class="MessageForm">

<h3>Activation Request Form</h3>
<div id=""></div>
<div class="wrapper">

<form:form method="POST" action="javascript:addMessage();"  commandName="command" id="messageRequest" >
     
	<div id="msg" align="center">${message}</div>
	
   <form:input type="hidden"   path="createdBy" id="createdBy" value="${sessionScope.user.id}" readonly="true" />

     <div>
		<form:input type="hidden" path="id" id="id" value="" class="" />
		
	</div>
	<div>
		<label><form:label path="responsibility">Send request to</form:label></label>
		<form:select path="responsibility" id="rUser">
				<form:options items="${sendTo}" />
							</form:select>
	
	
	</div>
	<div>
		<label><form:label path="message" >Message</form:label></label>
		<form:textarea  path="message" id="msg"/>
	</div>
	
	
	<div>		
	<input type="submit" id="send" value="Send" />
	</div>


</form:form>
<script>
</script>

</div>

</div>


</body>
</html>