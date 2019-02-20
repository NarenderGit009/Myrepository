
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<script type="text/javascript" src="js/masters/agencyFormValidation.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
<script type="text/javascript" src="js/googleAddress.js"></script>
<link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
//----------------------------address--------


//google.maps.event.addDomListener(window, 'load', initialize);


    </script>

<style type="text/css">
.RegisterAgencyForm{

}
.RegisterAgencyForm{
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
.RegisterAgencyForm{
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
</style>
</head>
<body>

<div class="RegisterAgencyForm">

<h3>Agency Registration</h3>
<div id=""></div>
<div class="wrapper">

<form:form method="POST" action="javascript:addAgency();"  commandName="command" id="RegisterAgency" >

	<div id="msg" align="center">${msg}</div>
	
   <form:input type="hidden" path="resourceBean.createdBy" id="createdBy" value="${sessionScope.user.id}" readonly="true" />
      <input type="hidden" id="addr" value="${agency.resourceBean.addressBean.address }"/>
   
   <div><form:input type="hidden"  path="id" id="id" value="${agency.id }" readonly="true" /></div>
	
	<div>
	<label><form:label path="agencyName" >Agency Name</form:label></label>
		<form:input path="agencyName" id="aname" value="${agency.agencyName }" class="names"/>
	</div>
	<div>
	<label><form:label path="cstNo" >CST NO</form:label></label>
		<form:input path="cstNo" id="cstNo" class="numbers" value="${agency.cstNo }"/>
	</div>
	<div>
	<label><form:label path="dlNo1" >DL NO1</form:label></label>
		<form:input path="dlNo1" id="dlNo1" class="numbers" value="${agency.dlNo1 }"/>
	</div>
	<div>
	<label><form:label path="dlNo2" >DL NO2</form:label></label>
		<form:input path="dlNo2" id="dlNo2" class="numbers" value="${agency.dlNo2 }"/>
	</div>
	<div>
	<label><form:label path="resourceBean.addressBean.mobile" >Contact No</form:label></label>
		<form:input path="resourceBean.addressBean.mobile" id="phno" class="phno" value="${agency.resourceBean.addressBean.mobile }"/>
	</div>
	<div>
		<label> <form:label path="resourceBean.addressBean.email" >Email Id</form:label></label>
		<form:input path="resourceBean.addressBean.email" id="email" class="email" placeholder="abcd@gmial.com" value="${agency.resourceBean.addressBean.email }" onfocus="disableerror('pmail');"/>
	</div>
    <div>
	<label><form:label path="resourceBean.addressBean.address" >Address</form:label></label>
		<form:textarea  path="resourceBean.addressBean.address" id="add"/>
	</div>     
	<div>
	
	<input type="submit" id="submit" value="Register"/>
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