
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
                    "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
              //      "iDisplayLength": 10,
                } );
           } );
           </script>
<style>
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

	<jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>


	<c:if test="${!empty purchaseOrderBean}">
	<!-- 	<c:set value="${createdRole}" var="role"></c:set>
		<c:set value="${productCreatedBy}" var="cby"></c:set>
		<div id="editform"></div> -->

		<h2 align="center" class="listcaption">Purchase Reports Data</h2>
		<table id="example1" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Order Id</th>
					<th>Billing Date</th>
					<th>Amount</th>
					<th>Discount</th>
					<th>Vat</th>
					<th>Invoice No</th>
				</tr>

			</thead>
			<tbody>
				<% int i=1; %>

					<c:forEach items="${purchaseOrderBean}" var="purchaseOrder">
			

					<tr id="<c:out value="${purchaseOrder.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${purchaseOrder.orderIdByDate}" /></td>
						<td><c:out value="${purchaseOrder.billingDateAndTime}" /></td>
						<td><c:out value="${purchaseOrder.payAmount}" /></td>
						<td><c:out value="${purchaseOrder.discountPrice}" /></td>
						<td><c:out value="${purchaseOrder.totalVAT}" /></td>
						<td><c:out value="${purchaseOrder.invoiceNo}" /></td>
							
					</tr>
					<% i++; %>


				</c:forEach>
			</tbody>
		</table>
	
	</c:if>
<c:if test="${empty purchaseOrderBean}"> Data is not available</c:if>

</body>
</html>
