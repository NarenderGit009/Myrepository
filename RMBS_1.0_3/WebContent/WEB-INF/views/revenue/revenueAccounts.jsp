<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url value="/revenueAccounts.html" var="revenueAccounts"/>
<!DOCTYPE html>
<html>
<head>

 
<%--<link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />  --%>

<script type='text/javascript' src='<c:url value="/js/jquery-ui.min.js"/>'></script>
 <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" /> 
<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style type="text/css">
.container {
	border: 1px solid green;
	border-radius: 5px 5px 5px 5px;
	background-color: #EFF0F0;
	padding: 5px;
	font-family: calibri;
	font-size: 15px;
	color: #736F69;
}

#block {
	display: inline-block;
	padding: 5px;
}

button {
	font-size: 17px;
	font-weight: bold;
	background: url("../../images/green.png") repeat scroll 0 0 transparent;
	color: #FFF;
	height: 20px;
	padding-left: 10px;
}

label {
	display: inline-block;
	
}
</style>
<script type="text/javascript">
	
	$(document).ready(function() {
     
				$(".dp").datepicker({
					dateFormat : 'yy-mm-dd',
					changeMonth : true,
					changeYear : true
				});

				$(".div1").hide();
				$(".div2").hide();
				$("#fromdate").val('');
				$("#todate").val('');
				$('#rA').change(function() {

					if ($('#rA option:selected').text() == "Custom") {
						$(".div1").show("slow");
						$(".div2").show("slow");
					} else {
						$(".div1").hide("slow");
						$(".div2").hide("slow");
						$("#fromdate").val('');
						$("#todate").val('');

					}
				});

			
				$('#submit').click(function(){
					alert("hi");
					var formData = $("#formData").serialize();
					alert('form data ' + formData);
					$.post('${revenueAccounts}', formData, function(result) {
						alert(result);
						$(".reports_container").html(result);
				
					});
				//	});
			});
			});
</script>
<style>
.container form div {
	display: inline-block;
	padding: 5px;
}

.container form,.reports_container {
	margin: 10px;
	padding: 5px;
	border: 1px solid green;
	border-radius: 5px 5px 5px 5px;
}
.reports_container {
	min-height: 200px;
}
.listcaption {
	background-image: url(images/green.png);
	color: #FFF;
	width: 100%;
	font-weight: bold;
	float: left;
}
h3{
	font-size: 17px;
	font-weight: bold;
	background: url("images/green.png") repeat scroll 0 0 transparent;
	color: #FFF;
	height: 20px;
	padding-left: 10px;
	
}
.wrapper input[type=text] {
    border: 1px solid #A0A0A0;
    width: 140px;
    padding: 0 8px 0 6px;
    height:20px;
    font-family:calibri;
    font-size: 15px;
    border-radius: 5px 5px 5px 5px;
}
.wrapper select{
  border: 1px solid #A0A0A0;
  border-radius: 5px 5px 5px 5px;
}
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
.ui-state-default, .ui-widget-content .ui-state-default {
    background: url("images/green.png") repeat-x scroll 50% 50% #E6E6E6;
    border: 1px solid #D3D3D3;
    color: #FFFFFF;
    font-weight: bold;
    outline: medium none;
}

</style>
</head>
<body>
	<div class="container">
		<div class="listCaption" align="center">
			<h3>Revenue Accounts Form</h3>
		</div>
		<form:form class="wrapper" id="formData">
			<div>
				<form:label path="branchBean.id">Branch</form:label>
				<form:select path="branchBean.id" id='bId'>				
					<form:option value="${branchId}">${branch}</form:option>
					<form:options items="${branches}" />
				</form:select>
					
			</div>
			
			<div>
				<form:label path="type">Type</form:label>
				<form:select path="type" id='catId'>	
				<form:option value="${revenueId}">${select}</form:option>			
						<form:options items="${categories}" />
				</form:select>
			</div>
			
			<div>
				<label><form:label path="revenueAccount">Duration</form:label></label>
				<form:select path="revenueAccount" id="rA">
					<form:option value="${revenueId}">${select}</form:option>
					<form:options items="${timePeriod}" />
				</form:select>
			</div>

			<div class="div1">
				<label><form:label path="fromDate">From Date</form:label></label>
				<form:input path="fromDate" id="fromdate" placeholder="Select"
					class="dp" />
			</div>
			<div class="div2">
				<label><form:label path="toDate">To Date</form:label></label>
				<form:input path="toDate" id="todate" placeholder="Select"
					class="dp" />
			</div>
		<%--<div>
				<input type="button" value="Pdf" title="Pdf reports" id="pdf" /> 
				<input type="button" value="Excel" title="Excel reports" id="excel" /> 
			</div> --%>	 
			<div>
					<input type="button" value="View" id='submit'/>
			</div>
		</form:form>
			<div id='msgbox' title='' style='display:none'></div>

		<div class="reports_container"></div>
	</div>
</body>
</html>