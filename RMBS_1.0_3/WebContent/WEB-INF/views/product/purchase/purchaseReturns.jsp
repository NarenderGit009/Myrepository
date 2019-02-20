<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"">
<html>
<head>
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/masters/productentryform.css" />

<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Return Form</title>

<style type="text/css">


.order_lineitems {
	min-height:200px; 
}
.container form,.order_lineitems {
	margin: 10px;
	padding: 5px;
	border: 1px solid green;
	border-radius: 5px 5px 5px 5px;
}
.container {
	border: 1px solid green;
	border-radius: 5px 5px 5px 5px;
	background-color: #EFF0F0;
	padding: 5px;
	font-family: calibri;
	font-size: 15px;
	color: #736F69;
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
	$(document).ready(function(){
		$( "#invoiceNum" ).autocomplete({
			//source: '${pageContext. request. contextPath}/get_medical_agency_list.html',
			source: function (request, response) {
		        $.getJSON('${pageContext. request. contextPath}/get_purchase_invoiceNo_list.html', {
		            term: extractLast(request.term),
		          //  type: $("#category0").val(),
		           // shopid: $("#shopid").val(),
		        }, response);
		    },
		  		 select: function( event, ui ) {
					 selectedObj = ui.item;
					 //alert("selected object=" + selectedObj.value);
		             $( "#tags" ).val( ui.item.label );
		             $( "#invoiceNum" ).val( ui.item.value );
		             myArray= ui.item.value.split("-");
		             $( "#agencyid0" ).val( myArray[1] );
		             $( "#invoiceNum" ).val( myArray[0] );
		            // alert(myArray);
		             return false;
		         },
		     focus: function( event, ui ) {
		             $( "#tags" ).val( ui.item.label );
		            // alert(ui.item.label);
		             return false;
		         },
		     change: function(event, ui) {
		         if (!ui.item) {
		             $("#tags").val("");
		             $("#invoiceNum").val("");
		             $("#agencyid0").val("");
		         }
		     }
			});
		
		
		//***************
		$("#go").click(function(){
			alert('go calling');
			var invoiceNo=$("#invoiceNum").val();
			var data = $(".porderlineitems").serialize();
			alert("data  "+data);
			$.post('dispalyPurchaseLineitems.html?invoiceNo='+invoiceNo,data,function(result) {
				alert(result);
				$(".order_lineitems").html(result);
			});	
		});
		
	});
	function split(val) {
		   return val.split(/,\s*/);
		 }
		function extractLast(term) {
			 return split(term).pop();
		 }
</script>
</head>
<body >
	<div class ="container">
		<form class="porderlineitems">
			<div>
				<label name="Invoice No">Invoice No</label> 
				<input type="text" value="" id="invoiceNum" />
			</div>
			<div>
				<input type="button" value="Go" id="go"/>
			</div>
		</form>
			<div class="order_lineitems"></div>
		
	</div>

</body>
</html>