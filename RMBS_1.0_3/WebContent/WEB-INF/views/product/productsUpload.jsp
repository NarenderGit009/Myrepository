
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>import</title>
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/masters/productentryform.css" />
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/jquery1.9.1.js"></script>
  <script type="text/javascript" src="js/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
/*function insertProductData(val){
alert("Hey wats up");
//var data= $('form').serialize();
 var formData = new FormData($(this)[0]);
$('#result').html(formData);
//var formData = new FormData($("#ProductEntry")[0]);
alert("form data "+formData);
alert('file data '+val);
$.post('upload.html?uid='+val,formData, function(result){
	
});
}


$(document).ready(function(){
$(".ProductEntry1").submit(function(){

	//var data= $('.ProductEntry1').serialize();
	//var formData = new FormData($('form')[0]); 
	 var formData = new FormData($('files')[0]);

	alert("sds "+formData);
	
	// var data=$(".ProductEntry1").serialize();
	 //formData=append("file",data);
	 
	 alert("after "+formData);
	 var val=$('#createdById1').val();
	 alert('created by id '+val);
$.ajax({
    url: 'upload.html?uid='+val,
    type: 'POST',
    data: formData,
    async: false,
    success: function (data) {
        alert("sucess"+data);
    },
    cache: false,
    contentType: false,
    processData: false
});
return false;
});});*/

</script>
<style type="text/css">
.wrapper {
	/* position: relative;*/
	background-color: #EFF0F0;
	border: 1px solid #3C873C;
	width: 350px;
	padding: 5px;
	font-family: calibri;
	font-size: 15px;
	color: #736F69;
	border-radius: 3px;
	/*float: right;*//*action="javascript:insertProductData(${createdby});"  action="'upload.html?uid=${createdby}"*/
}
</style>
</head>
<body>
	<div class="wrapper"> 
		<form:form method="post"  action="upload.html?uid=${createdby}"
			enctype="multipart/form-data" commandName="command" id="ProductEntry"
			class="ProductEntry1">
			<div><h3>Bulk Products Upload Form</h3></div>
			<div>
				<form:input path="createdBy" id="createdById1" value="${createdby}"
					readonly="true" placeholder="createdBy id" hidden="true" />
			</div>
			<div>
				<form:label path="agencyBean.id">Agency Name</form:label>
				<form:select path="agencyBean.id" id="agencyname1">

					<form:option value="${agencyId}">${agency}</form:option>
					<form:options items="${agencyList}" />
				</form:select>
			</div>
			<div>
				<form:label for="fileData" path="fileData">Select file</form:label>
				<form:input name="file"  path="fileData" type="file" />
			</div>
			<div id="result"></div>
			<input type="submit" />
			<div>message:${message}</div>
		</form:form>
	</div>
</body>
</html>