
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
                $('#example2').dataTable( {
                    "bJQueryUI": true,    
                    "sScrollY": "100px",
                    "bScrollCollapse": true,
                    "bPaginate": false,
              //      "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
              //      "iDisplayLength": 10,
                } );
           } );
           
           
           $.get("lessQuantityProducts.html", function(result){
		  		  if(result!=null){
		  		//	productNotifications+=result;
		  			$('.less_quantity').html(result);
		  		  
		  		  }
		  	  });
       
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
table.display thead th div.DataTables_sort_wrapper {
    padding-right: 20px;
    text-align: center;
}
table.display td {
    padding: 3px 10px;
    text-align: center;
}
/*.col3 .expairy_products{
width: 50%;
}*/

</style>
</head>
<body>
     
<div class="expairy_products">
<c:if test="${!empty productsOfNotification}">	
		
		<div id="editform"></div>

		<h2 align="center" class="listcaption">Products Notification List</h2>
		<table id="example2" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Product Name</th>
					<th>Agency</th>
					<th>Branch</th> 	
					<th>Quantity</th>
					<th>Expiry Date</th>
					<th>Expire in</th>
				</tr>

			</thead>
			<tbody>

				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />

				<c:forEach items="${productsOfNotification}" var="notification">


					<tr id="<c:out value="${notification.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${notification.productBean.name}" /></td>
					 <td><c:out value="${notification.agencyBean.agencyName}" /></td>
						<td><c:out value="${notification.branchBean.name}" /></td>	
						<td><c:out value="${notification.quantity}" /></td>
						<td><c:out value="${notification.expiryDate}" /></td>
						<td><c:out value="Expire in ${notification.expiryDays} days " /></td>

					</tr>
					<% i++; %>


				</c:forEach>
			</tbody>
		</table>


	</c:if>	


</div>
  			
<%-- <c:if test="${empty productsOfNotification}"> Data is not available</c:if>  --%>            
 
</body>
</html>
