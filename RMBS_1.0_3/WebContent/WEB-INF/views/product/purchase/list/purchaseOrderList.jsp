
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/purchaseOrderListReports/download.html" var="downloadUrl"/>
<c:url value="/download/token.html" var="downloadTokenUrl"/>
<c:url value="/download/progress.html" var="downloadProgressUrl"/>
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
<script type='text/javascript' src='<c:url value="/js/jquery-ui.min.js"/>'></script>

<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">

<script type="text/javascript" charset="utf-8">
           $(document).ready( function () {
                $('#example').dataTable( {
                    "bJQueryUI": true,    
                    "sScrollY": "300px",
                    "bPaginate": false,
           //  	   "sScrollX": "100%",
             	   "bScrollCollapse": true,
                  //  "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
              //      "iDisplayLength": 10,
                } );
                footerHTML="<input type='button' value='Pdf' id='pdf'></input>",
                footerHTML+="<input type='button' value='Excel' id='excel' ></input>";
                 $('.dataTables_info').append(footerHTML);
                   
                   
                 $('#pdf').click(function() {download('pdf');});
                 $('#excel').click(function() {download('xls');});
           } );
           
           function download(type) {
            	  alert("hmmmmmmm calling "+type);
           		// Retrieve download token
           		// When token is received, proceed with download
           		$.get('${downloadTokenUrl}', function(response) {
           			// Store token
           			var token = response.message[0];
           			alert("token value "+token);
           			// Show progress dialog
           		$('#msgbox').text('Processing download...');
           			$('#msgbox').dialog( 
           					{	title: 'Download',
           						modal: true,
           						buttons: {"Close": function()  {
           							$(this).dialog("close");} 
           						}
           					});
           			
           			// Start download
           		window.location = '${downloadUrl}'+'?token='+token+'&type='+type;
           			alert("frequency"+token+" "+type);
           			// Check periodically if download has started
           			var frequency = 1000;
           			
           			var timer = setInterval(function() {
           				$.get('${downloadProgressUrl}', {token: token}, 
           						function(response) {
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
           function purchaseOrderIdByPurchaseLineItems(val,val1){
        	   alert('calling'+val+' '+val1);
        	   var data = {id:val,flag:val1};
        	   $.post('getPurchaseLineItems.html',data, function(result){
        	     alert(result);
        		   $('.col2').html(result);
        	   });
           }//
           
           var divClone;
           function getInvoice(val){
        	   divClone = $(".orderLIst").clone(); 
        	   var data = val;
        	   $.post('loadInvoiceByPurchase.html?id='+val, data, function(result){
        	  //   showInvoice(result);
        	  $(".orderLIst").html(result); 
			  });
           }
           
       
           </script>
<style>

html {
	font-family: calibri;
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

.display {
	word-wrap: break-word;
}

.display th {
	background-image: url(images/green.png);
	color: #fff;
	text-align: center;
	font-weight: bold;
}

.content-wrapper .col1 {
	display: none;
}

.content-wrapper .col2 {
	width: 100%;
}

.listcaption {
	background-image: url(images/green.png);
	color: #FFF;
	width: 100%;
	font-weight: bold;
	float: left;
}

table {
	word-wrap: break-word;
}



</style>
</head>
<body>
<div class="orderLIst">
	<jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>

	<c:if test="${!empty purchaseOrders}">
		<c:set value="${createdRole}" var="role"></c:set>
		<c:set value="${purchaseCreatedBy}" var="cby"></c:set>
		<div id="editform"></div>

		<h2 align="center" class="listcaption">Purchase Order List</h2>
		<table id="example" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Agency Name</th>
					<th>Branch</th>
					<th>Billing Date</th>
					<th>Delivery Date</th>
					<th>Order No.</th>
					<th>Amount</th>
					<th>Discount Price</th>
					<th>Vat</th>
					<th>Net Amount</th>
					<th>Invoice No.</th>
					<th>Action</th>


				</tr>

			</thead>
			<tbody>

				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />

				<c:forEach items="${purchaseOrders}" var="purchaseOrder">


					<tr id="<c:out value="${purchaseOrder.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${purchaseOrder.agencyBean.agencyName}" /></td>
						<td><c:out value="${purchaseOrder.branchBean.name}" /></td>
						<td><c:out value="${purchaseOrder.billingDateAndTime}" /></td>
						<td><c:out value="${purchaseOrder.deliveryDate}" /></td>
						<td><c:out value="${purchaseOrder.orderIdByDate}" /></td>
						<td><c:out value="${purchaseOrder.amount}" /></td>
						<td><c:out value="${purchaseOrder.discountPrice}" /></td>
						<td><c:out value="${purchaseOrder.totalVAT}" /></td>
						<td><c:out value="${purchaseOrder.payAmount}" /></td>
						<td><c:out value="${purchaseOrder.invoiceNo}" /></td>

						<td align="center"><a href="#" title="View Purchase Line Items"
							onclick="purchaseOrderIdByPurchaseLineItems(<c:out value="${purchaseOrder.id}"/>,0);"><img
								src="images/open1.jpg" alt="open" height="20px" width="20px" /></a>&nbsp;&nbsp;<a
							href="#" title="View Purchase Order Invoice Print Copy"
							onclick="getInvoice(<c:out value="${purchaseOrder.id}"/>);"><img
								src="images/print2.png" alt="print" height="20px" width="20px" /></a>
							<a href="#" title="View purchase return" onclick="purchaseOrderIdByPurchaseLineItems(<c:out value="${purchaseOrder.id}"/>,1);"><img
								src="images/SRO.png" alt="open" height="20px" width="20px" /></a>
								</td>

						<%--<c:if test='${product.createdBy == cby && product.creatorRoleBean.id == role}'>
 					
						</c:if>
						 <c:if test='${product.createdBy != cby || product.creatorRoleBean.id != role}'>No Actions</c:if>
						</td> --%>
					</tr>
					<% i++; %>


				</c:forEach>
			</tbody>
		</table>


	</c:if>

	<c:if test="${empty purchaseOrders}"> Data is not available</c:if>
	<div id='msgbox' title='' ></div>
	
</div>
</body>
</html>
