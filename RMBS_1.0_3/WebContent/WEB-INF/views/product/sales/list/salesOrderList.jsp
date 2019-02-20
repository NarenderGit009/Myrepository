
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
           });  
         
           function salesOrderIdBySalesLineItems(val1,val2){
        	   var data = {sOId:val1,flag:val2};
        	   $.post('getSalesLineItems.html', data, function(result){
        	     alert(result);
        		   $('.col2').html(result);
        	   });
           }//
           var divClone;
           function getInvoice(val){
        	   divClone = $(".orderLIst").clone(); 
        	   var data = {sOId:val};
        	   $.post('loadInvoiceBySales.html', data, function(result){
        	  //   showInvoice(result);
        	  $(".orderLIst").html(result); 
			  });
           }
           
          function loadPreSalesIntoSalesForm(val){
        	  var data = {pSOId:val};
        	  $.post('loadPreSales.html', data, function(result){
            	  //   showInvoice(result);
            	  if(result){
            		  location.assign('${pageContext. request. contextPath}/openSalesOrderEntryForm.html?task_type=main&task_form_type=medical');
            	  }else{
            		  alert("Sorry..Some problem is occured...Check if have any incompleted sales order. If you have please complete that incompleted order first.");
            	  }
            //	  $(".orderLIst").html(result); 
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
	<c:forEach items="${salesOrders}" var="salesOrder">	
<c:set var="ctype" value='${salesOrder.categoryBean}' scope="page"></c:set>
</c:forEach>

	<c:if test="${!empty salesOrders}">
		<c:set value='${sale}' var = 'sales'></c:set>
		<c:set value='${preSale}' var = 'preSales'></c:set>
		
	
		<c:if test="${ctype.id == sales}">
		<h2 align="center" class="listcaption">Sales Order List</h2>
		</c:if>
		<c:if test="${ctype.id == preSales}">
		<h2 align="center" class="listcaption">Pre Sales Order List</h2>
		</c:if>
		<table id="example" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>					
					<th>Branch</th>					
					<th>Billing Date</th>					
					<th>Order No.</th>
					<th>Amount</th>
					<th>Discount Price</th>
					<th>Vat</th>
					<th>Net Amount</th>	
					<th>Customer Ph.No</th>					
					 <th>Action</th>


				</tr>

			</thead>
			<tbody>

				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />

				<c:forEach items="${salesOrders}" var="salesOrder">
<c:set value="${salesOrder}" var="salesOrder" scope="page"/>
                
					<tr id="<c:out value="${salesOrder.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${salesOrder.branchBean.name}" /></td>
						<td><c:out value="${salesOrder.billingDateAndTime}" /></td>						
						<td><c:out value="${salesOrder.orderIdByDate}" /></td>
						<td><c:out value="${salesOrder.amount}" /></td>
						<td><c:out value="${salesOrder.discountPrice}" /></td>
						<td><c:out value="${salesOrder.totalVAT}" /></td>
						<td><c:out value="${salesOrder.payAmount}" /></td>
						<td><c:if test="${salesOrder.customerBean.addressBean.mobile!=0}">
						<c:out value="${salesOrder.customerBean.addressBean.mobile}" />
						</c:if>
						<c:if test="${salesOrder.customerBean.addressBean.mobile==0}">
							Contact No. is not available
						</c:if>
						</td>
						

					<td align="center"><a href="#" title="View Sales Line Items"
							onclick="salesOrderIdBySalesLineItems(<c:out value="${salesOrder.id}"/>,0);"><img
								src="images/open1.jpg" alt="open" height="20px" width="20px" /></a>
								&nbsp;&nbsp;<a
							href="#" title="View Sales Order Invoice Print Copy"
							onclick="getInvoice(<c:out value="${salesOrder.id}"/>);"><img
								src="images/print2.png" alt="print" height="20px" width="20px" /></a>
								<c:if test="${salesOrder.categoryBean.id==10}">
								&nbsp;&nbsp;<a
							href="#" title="View Sales Order Invoice Print Copy"
							onclick="loadPreSalesIntoSalesForm(<c:out value="${salesOrder.id}"/>);"><img
								src="images/open.png" alt="print" height="20px" width="20px" /></a>
							</c:if>
								<c:if test="${salesOrder.categoryBean.id==9}">
								&nbsp;&nbsp;<a
							href="#" title="View Sales Order Invoice Print Copy"
							onclick="salesOrderIdBySalesLineItems(<c:out value="${salesOrder.id}"/>,1);"><img
								src="images/SRO.png" alt="print" height="25px" width="25px" /></a>
							</c:if>
						</td>

					</tr>
					<% i++; %>


				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<c:if test="${empty salesOrders}"> Data is not available</c:if>
	<div id='msgbox' title='' ></div>
	
</div>
</body>
</html>
