
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
<title>Doctor Form</title>

<script type="text/javascript">
/*function addDoctor()
{
	alert('sdddoctor called');
var data= $("#RegisterDoctor").serialize();
alert(data);

$.post('addDoctor.html?flag=0', data, function(result){
	alert(result);
	$(".col2").html(result);
	//clearVals();

//$('#msg').html(obj.model.msg).css("color", "orange");
});
//$("#msg").css("width", "200px");

}*/
</script>
<style type="text/css">
.RegisterDoctorForm{

}
.RegisterDoctorForm{
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
.RegisterDoctorForm{
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

<div class="RegisterDoctorForm">

<h3>Doctor Registration</h3>
<div id=""></div>
<div class="wrapper">

<form:form method="POST" action="javascript:addDoctor();"  commandName="command" id="RegisterDoctor" >
     
	<div id="msg" align="center">${msg}</div>
	
   <form:input type="hidden"   path="resourceBean.createdBy" id="createdBy" value="${sessionScope.user.id}" readonly="true" />
   <input type="hidden"   id="addr" value="${doctor.resourceBean.addressBean.address }"/>
     <div>
		<form:input type="hidden" path="id" id="id" value="${doctor.id }" class="" />
		
	</div>
	<div>
	<label><form:label path="doctorName" >Doctor Name</form:label></label>
		<form:input path="doctorName" id="dname" value="${doctor.doctorName }" class="names"/>
		<form:errors path="doctorName" cssClass="error" />
	</div>
	
	<div>
	<label><form:label path="initial" >Initial</form:label></label>
	      <form:select path="initial" id="init"  value="" >
                    <form:options items="${initials}"/>
                </form:select>
                <form:errors path="initial" cssClass="error" />
     </div>
                
     <div  style="display: none;">
		<label><form:label path="gender" >Gender</form:label></label>
		<form:input path="gender" id="sex" value="${doctor.gender}" hidden=""/>
		<form:errors path="gender" cssClass="error" />
	</div>
	<div>
	<label><form:label path="qualification" >Qualification</form:label></label>
		<form:input path="qualification" id="qualification" class="names" value="${doctor.qualification}"/>
		<form:errors path="qualification" cssClass="error" />
	</div>
	 <div>
	<label><form:label path="specialization" >Specialization</form:label></label>
		<form:input path="specialization" id="specialization" class="names" value="${doctor.specialization }"/>
		<form:errors path="specialization" cssClass="error" />
	</div>
	<div>
	<label><form:label path="hospitalName" >Hospital Name</form:label></label>
		<form:input path="hospitalName" id="hname" class="names" value="${doctor.hospitalName }"/>
		<form:errors path="hospitalName" cssClass="error" />
	</div>
	<div>
	<label><form:label path="resourceBean.addressBean.mobile" >PhoneNo</form:label></label>
		<form:input path="resourceBean.addressBean.mobile" id="phno" class="phno" value="${doctor.resourceBean.addressBean.mobile }"/>
		<form:errors path="resourceBean.addressBean.mobile" cssClass="error" />
	</div>
	<div>
	<label><form:label path="resourceBean.addressBean.email" >Email</form:label></label>
		<form:input path="resourceBean.addressBean.email" id="email" class="email" placeholder="abcd@gmial.com" value="${doctor.resourceBean.addressBean.email }"/>
		<form:errors path="resourceBean.addressBean.email" cssClass="error" />
	</div>    
	
    <div>
	<label><form:label path="resourceBean.addressBean.address" >Address</form:label></label>
		<form:textarea  path="resourceBean.addressBean.address" id="add"/>
		<form:errors path="resourceBean.addressBean.address" cssClass="error" />
	</div>    
	<div>		
	<input type="submit" id="submit" value="Register" />
		
		<!-- <input type="button" value="Register" onclick="addAgency();"/> -->	
		</div>

<div id="map-canvas"></div>
</form:form>
<script>
var address=$('#addr').val();
//alert(address);
$('#add').val(address);
</script>

</div>

</div>


</body>
</html>