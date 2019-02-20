
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>


<link href="media/dataTables/demo_table_jui.css" rel="stylesheet"
	type="text/css" />
	
<link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8" src="js/jquery1.7.2.js"></script>
<script type="text/javascript" charset="utf-8"
	src="media/js/dataTables.js"></script>
<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">

<script type="text/javascript" charset="utf-8">
           $(document).ready( function () {
                $('#example1').dataTable( {
                    "bJQueryUI": true,
                    "bPaginate": false,
                    
                
                } );
           } );
           </script>
<style>
 .dataTables_filter,.fg-toolbar ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix {
  				display:none;  
				}
				
			.dataTables_length{
				display:none;  
				}
html{
font-family:calibri;
    color: #736F69;
}
.actionlink a {
	text-decoration: none;
	background-color: lightblue;
	text-decoration: blink;
	padding: 5px;
	color: white;
	font-weight: bold;
	margin: 10px;
	float: right;
}

a {
	text-decoration: none;
}

#userdetails {
	background-image: url(images/listbackground1.jpg);
}

.wrap .listfooter {
	width: 700px;
	height: 30px;
	background-color: #aaa;
	font-size: 15px;
	font-weight: bold;
}

.wrap .listfooter span {
	float: right;
	margin: auto;
}
.listcaption{
background-image: url(images/green.png);
color: #FFF;
width:100%;
font-weight: bold;
float: left;
}
table{
word-wrap: break-word;
}

</style>
</head>
<body>

	<c:if test="${!empty purchaseRevenue}">
	
<c:set value="0.00" var="amount"></c:set>
<c:set value="0" var="noofprders"></c:set>
<c:set value="0.00" var="vat"></c:set>
<c:set value="0.00" var="dis"></c:set>
<c:set value="0.00" var="payAmount"></c:set>
<c:set value="${type}" var="orderType"></c:set>
		<h2 align="center" class="listcaption">Purchase Revenue Accounts</h2>
		<table id="example1" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>No.Of Orders</th>
					<th>Ordered Type</th>					
					<th>Amount</th>
					<th>Discount(-)</th>
					<th>Vat(+)</th>
					<th>Pay Amount</th>
				</tr>

			</thead>
			<tbody>
			

					<c:forEach items="${purchaseRevenue}" var="revenuePurchase">
			
			<c:set value="${noOfOrders+1}" var="noOfOrders"></c:set>			
			<c:set value="${amount+revenuePurchase.amount}" var="amount"></c:set>			
			<c:set value="${vat+revenuePurchase.totalVAT}" var="vat"></c:set>
			<c:set value="${dis+revenuePurchase.discountPrice}" var="dis"></c:set>
			<c:set value="${payAmount+revenuePurchase.payAmount}" var="payAmount"></c:set>
				

				</c:forEach>
				<tr id="<c:out value="${revenuePurchase.id}"/>1">
						
						<td><c:out value="${noOfOrders}" /></td>
						<td><c:out value="${orderType}" /></td>
						<td><c:out value="${amount}" /></td>
						<td><c:out value="${dis}" /></td>
						<td><c:out value="${vat}" /></td>
						<td><c:out value="${payAmount}" /></td>
							
					</tr>
			</tbody>
		</table>
	
	</c:if>
<c:if test="${empty purchaseRevenue}"> Data is not available</c:if>

</body>
</html>
