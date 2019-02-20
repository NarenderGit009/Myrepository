
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
.content-wrapper .col1 {
	display: none;
}

.content-wrapper .col2 {
	width: 100%;
}

</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>

	<c:if test="${!empty productLogs}">
		<c:set value="${createdRole}" var="role"></c:set>
		<c:set value="${productCreatedBy}" var="cby"></c:set>
		<div id="editform"></div>

		<h2 align="center" class="listcaption">Product Log List</h2>
		<table id="example" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Product Name</th>
					<th>Updated Date</th>
					<th>Branch</th>
					<th>Updated By</th>
					<th>Updater Role</th>
					<th>Field Name</th>
					<th>Old Value</th>
					<th>New Value</th>
				<%--	<th>Action</th>
						<th>Email</th>	--%>

				</tr>

			</thead>
			<tbody>
			
				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />


				<c:forEach items="${productLogs}" var="productLog">
			

					<tr id="<c:out value="${productLog.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${productLog.productInventoryBean.productBean.name}" /></td>
						<td><c:out value="${productLog.date}" /></td>
						<td><c:out value="${productLog.branchBean.name}" /></td>
						<td><c:out value="${productLog.updaterName}" /></td>
						<td><c:out value="${productLog.creatorRoleBean.role}" /></td>
						<td><c:out value="${productLog.feildName}" /></td>
						<td><c:out value="${productLog.oldValue}" /></td>
						<td><c:out value="${productLog.newValue}" /></td>

						
				<%--  <td align="center">
						<c:if test='${productLog.createdBy == cby && productLog.creatorRoleBean.id == role}'>

							<a href="#"
								onclick="editProduct(<c:out value="${productLog.id}"/>);"><img
									src="images/edit.png" alt="edit" height="20px" width="20px" /></a>

						</c:if>
						 <c:if test='${productLog.createdBy != cby || productLog.creatorRoleBean.id != role}'>No Actions</c:if>
						</td> --%>		
					</tr>
					<% i++; %>

				
				</c:forEach>
			</tbody>
		</table>
	
	</c:if>
<c:if test="${empty productLogs}"> Data is not available</c:if>



</body>
</html>
