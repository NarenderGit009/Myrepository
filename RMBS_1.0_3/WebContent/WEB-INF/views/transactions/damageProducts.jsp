
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
                $('#example').dataTable( {
                    "bJQueryUI": true,                     
                    "sPaginationType": "full_numbers",
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

</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>

	<c:if test="${!empty productDamages}">
		<c:set value="${createdRole}" var="role"></c:set>
		<c:set value="${productCreatedBy}" var="cby"></c:set>
		<div id="editform"></div>

		<h2 align="center" class="listcaption">Product Damage List</h2>
		<table id="example" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Product Name</th>
					<th>Damaged Date</th>
					<th>Quantity</th>
					<th>Created By</th>
					<th>Agency</th>
					<th>Reason</th>
						
				</tr>

			</thead>
			<tbody>
			
				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />


				<c:forEach items="${productDamages}" var="productDamage">
			

					<tr id="<c:out value="${productDamage.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${productDamage.productInventoryBean.productBean.name}" /></td>
						<td><c:out value="${productDamage.damagedDate}" /></td>
						<td><c:out value="${productDamage.quantity}" /></td>
						<td><c:out value="${productDamage.creatorName}" /></td>
						<td><c:out value="${productDamage.agencyBean.agencyName}" /></td>
						<td><c:out value="${productDamage.reasonBean.reason}" /></td>				

						
				
					</tr>
					<% i++; %>

				
				</c:forEach>
			</tbody>
		</table>
	
	</c:if>
<c:if test="${empty productDamages}"> Data is not available</c:if>



</body>
</html>
