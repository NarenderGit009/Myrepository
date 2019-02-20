<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/purchaseReports/download.html" var="downloadUrl" />
<c:url value="/download/token.html" var="downloadTokenUrl" />
<c:url value="/download/progress.html" var="downloadProgressUrl" />
<c:url value="/openPurchaseOrdersView.html" var="purchaseViewUrl"/>
<!DOCTYPE html>
<html>
<head>

 
<link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />


<!--
 <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8" src="js/jquery1.7.2.js"></script> -->

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
	width: 100px;
}
</style>
<script type="text/javascript">
	
	$(document).ready(function() {
       //alert('hey i am ready');
	
		/*function requestSubmitionByAjax() {
			alert("hi");
			var formData = $("#formData").serialize();
			alert('form data ' + formData);
			$.post('purchaseFile.html', formData, function(result) {
				alert(result);
				$(".reports_container").html(result);
			});
		}*/

				$(".dp").datepicker({
					dateFormat : 'yy-mm-dd',
					changeMonth : true,
					changeYear : true
				});

				$(".div1").hide();
				$(".div2").hide();
				$("#fromdate").val('');
				$("#todate").val('');
				$('#report').change(function() {

					if ($('#report option:selected').text() == "Custom") {
						$(".div1").show("slow");
						$(".div2").show("slow");
					} else {
						$(".div1").hide("slow");
						$(".div2").hide("slow");
						$("#fromdate").val('');
						$("#todate").val('');

					}
				});

				$('#pdf').click(function() {
					download('pdf');
				});
				$('#excel').click(function() {
					download('xls');
				});

				function download(type) {
					alert("hmmmmmmm calling " + type);
					// Retrieve download token
					// When token is received, proceed with download
					$.get('${downloadTokenUrl}', function(response) {
						// Store token
						var token = response.message[0];
						alert("token value " + token);
						// Show progress dialog
				/* $('#msgbox').text('Processing download...');
         			$('#msgbox').dialog( 
         					{	title: 'Download',
         						modal: false,
         						buttons: {"Close": function()  {
         							$(this).dialog("close");} 
         						}
         					});*/
						var formData = $("#formData").serialize();
						alert(formData);
						// Start download
						var bid = $('#bId').val();
						var cat = $('#report :selected').text();
						alert('category '+cat);
						var frm = $('#fromdate').val();
						var todate = $('#todate').val();
						window.location = '${downloadUrl}' + '?token=' + token
								+ '&type=' + type + '&bId=' + bid + '&cat='
								+ cat + '&frm=' + frm + '&todate='+ todate;
						//	$.post('${downloadUrl}'+'?token='+token+'&type='+type, formData, function(result){
						//alert('*******branch Id' + $('#bId').val());
						//alert('*******category Id' + $('#report').val());
						//});
						/*$.ajax({
						url: '${downloadUrl}'+'?token='+token+'&type='+type,
						type: 'GET',
						data: formData,
						async: false,
						success: function (data) {
						    alert(data);
						},
						// cache: false,
						// contentType: false,
						// processData: false
						});*/
						alert("frequency" + token + " " + type);
						// Check periodically if download has started
						var frequency = 1000;

						var timer = setInterval(function() {
							$.get('${downloadProgressUrl}', {
								token : token
							}, function(response) {
								// If token is not returned, download has started
								// Close progress dialog if started
								if (response.message[0] != token) {
									$('#msgbox').dialog('close');
									clearInterval(timer);
								}
							});
						}, frequency);
					});
				}
				
				$('#submit').click(function(){
					//$('#formData').submit(function(){
						
					
					alert("hi");
					var formData = $("#formData").serialize();
					alert('form data ' + formData);
					$.post('${purchaseViewUrl}', formData, function(result) {
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
	paddnig: 5px;
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
</style>
</head>
<body>
	<div class="container">
		<div>
			<h3>Purchase Reports Form</h3>
		</div>
		<form:form class="wrapper" id="formData">
			<div>
				<form:label path="outletBean.id">UserId</form:label>
				<form:select path="outletBean.id" id='bId'>
					<form:option value="${branchId}">${branch}</form:option>
					<form:options items="${branches}" />
				</form:select>
			</div>

			<div>
				<label><form:label path="initial">Reports On</form:label></label>
				<form:select path="initial" id="report">
					<form:option value="${reportId}">${report}</form:option>
					<form:options items="${reportInitials}" />
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
			<div>
				<input type="button" value="Pdf" title="Pdf reports" id="pdf" /> 
				<input type="button" value="Excel" title="Excel reports" id="excel" /> 
			</div>
			<div>
					<input type="button" value="View" id='submit'/>
			</div>
		</form:form>
			<div id='msgbox' title='' style='display:none'></div>

		<div class="reports_container"></div>
	</div>
</body>
</html>