<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
    
 

<script type="text/javascript" src="js/jquery-ui.min.js"></script>
      <script type="text/javascript" src="js/registration.js"></script>
   <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css"/>
       <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
        <script type="text/javascript" src="js/googleAddress.js"></script>
 <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
        <link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />
       
       <style type="text/css">

#ui-datepicker-div{
width: 13.5%;
 background-image:url(images/background1.png);
}
.ui-datepicker-year{
maxHeight: 3;
}
.ui-datepicker {
   background: #333;
   border: 1px solid #555;
   color: #EEE;
  margin-top: -10px;
   margin-left: -20px;
 }
div.ui-datepicker{ 
 font-size:12px;
 position: relative;
}
div.ui-datepicker select{

}


.pac-container{
/*width: 152px; position: absolute; left: 1036px; top: 474px; display: none;
background-image:url(images/background2.gif);*/
background-position: left;
font-style: oblique;
 position: relative;

overflow: auto;

 box-shadow: 1px 1px 10px 7px #555555 ;
 left: 20px;
}

.outletregisterform{
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
.outletregisterform .outletDetails h3, .outletregisterform .branchDetails h3{
font-weight: normal;
}
.outletregisterform .outletDetails, .outletregisterform .branchDetails{
border: 1px solid  grey;
    width: 340px;
    padding: 5px;

}
.outletregisterform .outletDetails .content, .outletregisterform .branchDetails .content{
margin-top: 5px;

}
 .wrapper {
 font-family:calibri;
    font-size: 15px;
    color: #736F69;
}

.wrapper #add{
    resize: none;
    width: 140px;
    height: 40px;
 }

.wrapper input[type=text] {
    
    width: 140px;
 }
.wrapper label {
    width:120px;
    
    display: inline-block;
}
 .wrapper input[type=submit]{
 float: right;
 background: url("images/green.png") repeat scroll 0 0 transparent;
 border: none;
 color: #fff;
 font-weight: bold;
 margin: 5px;
 }
@media only screen   
and (max-width:750px) {
#ui-datepicker-div{
width: auto;
}

.wrapper{
   width: 97%;
}
.branchregisterform{
width: 98%;
float: right;
}
.outletregisterform .outletDetails, .outletregisterform .branchDetails{
border: 1px solid  grey;
    width: 98%;
    padding: 1%;

}
}
@media only screen and (min-width:750px) and (max-width: 980px) {
.wrapper{
   width: 90%;
  margin: auto;
}
.outletregisterform .outletDetails, .outletregisterform .branchDetails{
border: 1px solid  grey;
    width: 98%;
    padding: 1%;

}
.wrapper input[type=text] {
    
    width: 120px;
 }
 .wrapper input[type=textarea] {
    
    width: 90px;
 }
}

.caption{
font-weight: bold;

font-size: 17px;
padding-right: 10px;
}
</style>
         <script>
         
       //----------------------------address--------
 
          
//google.maps.event.addDomListener(window, 'load', initialize);

       $(function() {
	$( "#dob" ).datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		autoclse: true,
		yearRange: "-100:+0"
		
	});
});

       
       function addBranch()
       {
       var data= $(".outletregistrastion").serialize();
       alert(data);

       $.post('validateOutletRegistration.html', data, function(result){
       //	alert(result);
       	$(".col2").html(result);
      
       });
     

       }
    </script>
  



</head>
<body>
<div class="outletregisterform">
<h3>Outlet Registration Form</h3>
<div class="wrapper">
<form:form method="POST" action="validateOutletRegistration.html;"  commandName="command" id="registerform1" class='outletregistrastion'>

	<div><p><c:out value="${message}"/></p></div>
	<div class="branchDetails">
	<h3>Branch Details</h3>
		<div class="content">
		<form:input path="id"  id="id" value="${sessionScope.user.id}" hidden="true"/>
	<%--<div>
		<label><form:label path="" >Organization Name</form:label></label>
		<form:input path="" class="shopnames" id="sname" value="${sessionScope.user}" disabled="true"/>
	</div>   BranchName,OrgnizationName,OrganizationId,BranchId--%>
	<div><span class="caption">Branch:</span><c:out value="${sessionScope.user.name}"/></div>
	<div><span class="caption">Organization:</span><c:out value="${sessionScope.user.organizationBean.name}"/></div>
	<div><span class="caption">Email: </span><c:out value="${sessionScope.user.resourceBean.addressBean.email}"/></div>
	<div><span class="caption">Contact No: </span><c:out value="${sessionScope.user.resourceBean.addressBean.mobile}"/></div>
	<div><span class="caption">Address: </span><c:out value="${sessionScope.user.resourceBean.addressBean.address}"/></div>
	<%--<form:hidden path="resourceBean.addressBean.id" />
	<form:hidden path="resourceBean.roleBean.id" />
	<form:hidden path="resourceBean.createdBy" />
	<form:hidden path="resourceBean.creatorRoleBean.id"/>
	<form:hidden path="resourceBean.accountStatusBean.id"/>
	<form:hidden path="resourceBean.loginStatusBean.id"/> --%>
	<%-- <div>
		<label><form:label path="branchBean.name" >Branch</form:label></label>
		<form:input path="branchBean.name" class="shopnames" id="sname" disabled="" value="${BranchName}"/>
	</div>
   <div>
		<label><form:label path="organizationBean.name" >Organization</form:label></label>
		<form:input path="organizationBean.name" class="shopnames" id="sname" disabled="" value="${OrgnizationName}"/>
	</div>
	 <div>
		<label><form:label path="resourceBean.addressBean.address" >Address</form:label></label>
		<form:input path="resourceBean.addressBean.address" id="add" disabled="" value="${sessionScope.user.resourceBean.addressBean.address}"/>
	</div>--%>
	</div>
	</div>
	<div class="outletDetails">
	<h3>Outlet Details</h3>
	<div class="content">
	<div>
		<label><form:label path="initial">Owner Initial</form:label></label>
		
		    <form:select path="initial" id="init">
                    <form:options items="${initials}"/>
                </form:select>

                </div> 

	<div>
		<label><form:label path="firstName" >Owner First Name</form:label></label>
		<form:input path="firstName" class="names" id="fname" onfocus="disableerror('fname');"/>
	</div>
	
    <div>
		<label><form:label path="lastName" >Owner Last Name</form:label></label>
		<form:input path="lastName" class="names" id="lname"  onfocus="disableerror('lname');"/>
	</div>
	<div>
		<label><form:label path="userName" >User Name</form:label></label>
		<form:input path="userName" id="uname"  onblur="return userid_validation(this,5,12);" onfocus="disableerror('uname');"/>
	</div>
	<div  style="display: ;">
		<label><form:label path="gender" >Gender</form:label></label>
		<form:input path="gender" id="sex" value="Male" readonly="true"/>
	</div>
		
	
	<div>
		<label><form:label path="password" >Password</form:label></label>
		<form:input path="password" id="pwd"/>
	</div>
	<div>
		<label><form:label path="confirmPassword" >Confirm Password</form:label></label>
		<form:input path="confirmPassword" id="cpwd"  onfocus="disableerror('cpwd');"/>
	</div>
	<div>
		<label><form:label path="dob" >Date of Birth</form:label></label>
		<form:input path="dob" id="dob" placeholder="Select" maxlength="0"/>
	</div>
	<div>
		<label><form:label path="resourceBean.addressBean.mobile" >Mobile</form:label></label>
	    <form:input path="resourceBean.addressBean.mobile" class="phno" id="phno1" maxlength="15"/>
	</div>
		<div>
		<label> <form:label path="resourceBean.addressBean.email" >Email Id</form:label></label>
		<form:input path="resourceBean.addressBean.email" id="pmail" class="email" placeholder="abcd@gmial.com"  onfocus="disableerror('pmail');"/>
	</div>
	</div>
	</div>
	<div>

		
			<input type="submit" value="Register" id="submit"/>
		
	</div>


	 <div id="map-canvas" style=""></div> 
</form:form>
</div>

</div>
<dir>

</dir>
</body>
</html>