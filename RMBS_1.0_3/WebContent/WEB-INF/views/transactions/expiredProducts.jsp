
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
<%-- <script type="text/javascript" charset="utf-8" src="js/jquery1.7.2.js"></script> --%>
<script type="text/javascript" charset="utf-8"
	src="media/js/dataTables.js"></script>

<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">

<script type="text/javascript" charset="utf-8">
         
$(document).ready( function () {
	 $('#example1').dataTable( {
         "bJQueryUI": true,
         "sScrollY": "200px",
   	   "sScrollX": "100%",
   	//	 "sScrollXInner": "100%",
 		"bScrollCollapse": true,
   	//   "bPaginate": false,
     //    "sPaginationType": "full_numbers",
         //"sDom": '<"H"Tfr>t<"F"ip>',
     //    "iDisplayLength": 5,
     } );
                                     
     } );

       
           </script>
            <c:if test="${type!='main'}">
           <style>
       	 .dataTables_filter,.fg-toolbar ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix {
  				display:none;  
				}
				
			.dataTables_length{
				display:none;  
				}
			#example1_paginate{
			display:none;
				}
				
			
           </style>
           </c:if>  
<style>


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

html {
	font-family: calibri;
	color: #736F69;
}
table.display thead th div.DataTables_sort_wrapper {
    padding-right: 20px;
    text-align: center;
}
table.display td {
    padding: 3px 10px;
    text-align: center;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>

	<c:if test="${!empty expiredProducts}">
		<c:set value="${createdRole}" var="role"></c:set>
		<c:set value="${productCreatedBy}" var="cby"></c:set>
		<c:set value="${type}" var="type"></c:set>
		<div id="editform"></div>

		<h2 align="center" class="listcaption">Expired Products</h2>
		<table id="example1" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Product Name</th>				
				<c:if test="${type=='main'}">
					<th>Quantity</th>								
					<th>Branch</th>					
					<th>Agency</th>						
				</c:if>
					<th>Expired Date</th>	
				</tr>

			</thead>
			<tbody>
			
				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />

				<c:forEach items="${expiredProducts}" var="expiredProducts">
			

					<tr id="<c:out value="${expiredProducts.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${expiredProducts.productBean.name}" /></td>
					<c:if test="${type=='main'}">
						<td> <c:out value="${expiredProducts.quantity}" /></td>									
						<td><c:out value="${expiredProducts.branchBean.name}" /></td>
						<td><c:out value="${expiredProducts.agencyBean.agencyName}" /></td>								
					</c:if>
						<td><c:out value="${expiredProducts.expiryDate}" /></td>									
					</tr>
					<% i++; %>				
				</c:forEach>
			</tbody>
		</table>
	

	</c:if>
	<c:if test="${empty expiredProducts}"> Data is not available</c:if>



</body>
</html>
