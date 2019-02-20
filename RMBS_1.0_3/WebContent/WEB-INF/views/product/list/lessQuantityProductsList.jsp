
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
<script type="text/javascript" charset="utf-8"
	src="media/js/dataTables.js"></script>

<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">

<script type="text/javascript" charset="utf-8">
           $(document).ready( function () {
                $('#example3').dataTable( {
                    "bJQueryUI": true,    
                    "sScrollY": "100px",
                    "bScrollCollapse": true,
                    "bPaginate": false,
              //      "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
              //      "iDisplayLength": 10,
                } );
           } );
           
           
       
           </script>
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

.listcaption {
	background-image: url(images/green.png);
	color: #FFF;
	width: 100%;
	font-weight: bold;
	float: left;
}

.display {
	word-wrap: break-word;
}

html {
	font-family: calibri;
	color: #736F69;
}

.content-wrapper .col3 {
	min-height: 80px;
	width: 1275px;
	border: 1px solid #ffffff;
	margin: 10px 0;
}
/*.col3 .less_quantity{
width: 50%;
float: right;
}*/


</style>
</head>
<body>

<div class="less_quantity">
<c:if test="${!empty lessQuantityProducts}">	
		
		<div id="editform"></div>

		<h2 align="center" class="listcaption">Less Quantity Products List</h2>
		<table id="example3" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Product Name</th>
					<th>Agency</th>
					<th>Branch</th>						
					<th>Quantity</th>
					
				</tr>

			</thead>
			<tbody>

				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />

				<c:forEach items="${lessQuantityProducts}" var="lessQuantity">


					<tr id="<c:out value="${lessQuantity.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${lessQuantity.productBean.name}" /></td>		
						<td><c:out value="${lessQuantity.agencyBean.agencyName}" /></td>	
						<td><c:out value="${lessQuantity.branchBean.name}" /></td>	
						<td><c:out value="${lessQuantity.quantity}" /></td>
						

					</tr>
					<% i++; %>


				</c:forEach>
			</tbody>
		</table>


	</c:if>

	<c:if test="${empty lessQuantityProducts}"> Data is not available</c:if>


</div>

	
</body>
</html>
