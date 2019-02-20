
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
                    "sScrollY": "300px",
             //	   "sScrollX": "110%",
             	   "bScrollCollapse": true,
             	  "bPaginate": false,
                  //  "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
              //      "iDisplayLength": 10,
                } );
                
       
         	   $(".submit").click(function(){
             	   //alert("hi");
             	   if(!jQuery.isEmptyObject(map)){
        				objs=[];
        				 Object.keys(map).forEach(function (key) {
        			
        				    alert(map[key]['id']);
        				    objs.push(map[key]);
        			});
        				 var data= JSON.stringify(objs);
             	   objs.push(map[key]);
             	  divClone = $(".lineitems").clone(); 
             	   $.post('createSalesreturnOrder.html', data, function(result){
          		$(".lineitems").html(result);
             		   
          		  });
             	   
             	   }  
                });
         	    
         	    
         	    
                
                
                $(".qty").blur(function () {
                	//alert(this.value);
                	//alert(this.id);
                	//alert($('#'+this.id).attr('name'));
                	val2=$('#'+this.id).attr('name');
                	//alert(isInteger(this.value));
             	 //  var flag=isInteger(this.value);
             	   
             	   if((/^[0-9]+$/.test(this.value))){
            		   if(this.value>parseInt(val2)){
            			   console.log("Entered into this.value>parseInt(val2)");
            			   console.log("Entered into "+this.value+">"+parseInt(val2)+"");
             			  //this.value=val2;
            			/*   if(!jQuery.isEmptyObject(map)){
                   			var keys=Object.keys(map);
                       		if($.inArray(this.id, keys) > -1){
                       			
                       			delete map[this.id];
                       			var id=this.id+"1";
                       			jQuery('#'+id).removeClass('changed');
                       		}
                       		print_changes();
                      		 }*/
                      		popItem(this.id);
            			   this.value=0;
            		   }else if(this.value<0){
                        	console.log("Entered into this.value<0");
                        	this.value=0;
                        	return false;
                        }else if(this.value!=0 && this.value!=""){
                        	console.log("Entered into map creation");
                        	//alert("Entered into map creation");
                        	var obj = {
                    				"id":this.id,
                    				"qty":this.value
                        	};
                        	generate_SRO_Obj(obj,this.id);
                        	console.log(map);
                        	if(!jQuery.isEmptyObject(map)){
                    			var keys=Object.keys(map);
                    			//alert("keys.length()-"+keys.length);
                    		//alert(keys);
                    			keys.forEach(function (key) {
                    					// var temp=map[key]['qty'];
                    					 //alert(temp);
                    					});
                    			print_changes();
                    			}
                        	//.changed_items Object.keys(a).length;
                        	
                        	return true;
                        }else{
                        	if(!jQuery.isEmptyObject(map)){
                    			var keys=Object.keys(map);
                        		if($.inArray(this.id, keys) > -1){
                        			delete map[this.id];
                        			var id=this.id+"1";
                        			jQuery('#'+id).removeClass('changed');
                        		}
                        		print_changes();
                       		 }
                        };
                        
             	   }else if(this.value==0 && this.value!=""){
             		 // alert("Entered 0 section");
             		/* if(!jQuery.isEmptyObject(map)){
             			var keys=Object.keys(map);
                 		if($.inArray(this.id, keys) > -1){
                 			
                 			delete map[this.id];
                 			var id=this.id+"1";
                 			jQuery('#'+id).removeClass('changed');
                 		}
                 		print_changes();
                 		console.log(map);
                		 }*/
             		  popItem(this.id);
             	   }else{
             		  
             		  this.value=0;
             		  return false;
             	   }
                });
                
           } );
           var map={};
           function generate_SRO_Obj(obj,key){
        	   map[key]=obj;  
        	   
        	 }
         function popItem(val){
        	 if(!jQuery.isEmptyObject(map)){
      			var keys=Object.keys(map);
          		if($.inArray(val, keys) > -1){
          			
          			delete map[val];
          			var id=val+"1";
          			jQuery('#'+id).removeClass('changed');
          		}
          		print_changes();
          		console.log(map);
         		 }
         }
         function applayCss(){
        	 if(!jQuery.isEmptyObject(map)){
      			var keys=Object.keys(map);
      			keys.forEach(function (key) {
      				
      				var id=key+"1";
      				/*//alert(id);
      				(id).addClass("changed");*/
      				jQuery('#'+id).addClass('changed');
      			});
        	 }
         }
           
           function print_changes(){
        	   applayCss();
        	   $(".changed_items").html(Object.keys(map).length+" Itme(s) Changed.");   
           }
           
           function backToSalesOrder(flag,type){        	 
        	   $.get('salesOrderList.html?flag='+flag+'&task_type='+type, function(result){
        		   //alert(result);
        		   $('.col2').html(result);
        	   });
           }
           function isInteger(n) {
               return /^[0-9]+$/.test(n);
           }
           
           
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

.display{
word-wrap: break-word;
}
.display th{
background-image: url(images/green.png);
color: #fff;
text-align: center;
font-weight: bold;
}
   .content-wrapper .col1 {
display: none;
}

.content-wrapper .col2 {
width:100%;
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
html{
font-family:calibri;
    color: #736F69;
}
.display .submit{
float: right;
}
.display .changed_items{
font-size: 12px;
vertical-align: middle;
}
.display .changed{
font-weight: bold;
}
.display .changed input{
background-color: lightgray;
color: #fff;
font-weight: bold;
text-align: center;
}
</style>
</head>
<body>
<div class="lineitems">
<c:forEach items="${salesLineItems}" var="salesOrderLineItem">	
<c:set var="ctype" value='${salesOrderLineItem.salesOrderBean}' scope="page"></c:set>
</c:forEach>
<c:set value='${sale}' var = 'sales'></c:set>
<c:set value='${preSale}' var = 'preSales'></c:set>

<c:if test="${ctype.categoryBean.id == sales}">
<div><a href="#" onclick="backToSalesOrder('task_sub','sales')">
Sales OrderList</a>&gt;&gt;Line Items List</div>
</c:if>
<c:if test="${ctype.categoryBean.id == preSales}">
<div><a href="#" onclick="backToSalesOrder('task_sub','preSales')">
PreSales OrderList</a>&gt;&gt;Line Items List</div>
</c:if>
	
	<c:if test="${!empty salesLineItems}">
	
		<div id="editform"></div>

		<h2 align="center" class="listcaption">
		 <c:if test="${flag==0}">Sales Line Items List</c:if>
		
		 <c:if test="${flag==1}">Sales Returns Line Items List</c:if>		 
		 
		 <c:if test="${ctype.categoryBean.id == preSales}">Pre Sales Line Items List</c:if>
		</h2>		
		
		<table id="example1" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Product</th>
					
					 
					<th>Amount</th>
					<th>Unit Price</th>
					<th>Discount</th>
					<th>Vat</th>		
					<th>Net Price</th>
					
					<th>Quantity</th>
					<c:if test="${flag==1}">
					<th>Returnable Qty</th>	
					<th>Return Qty</th>							
					</c:if>
					
				<%-- 	 <c:if test="${flag==1}">
					<th>Action</th>								
					</c:if>
				<th>Pay Amount</th>--%>	
					
				
						

				</tr>

			</thead>
			<tbody>
			
				<% int i=1; %>

				<c:set value="${sessionScope.user.id}" var="id" />

				<c:forEach items="${salesLineItems}" var="salesOrderLineItems">			
                 <c:if test="${flag==0}">
                 <tr id="<c:out value="${salesOrderLineItems.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${salesOrderLineItems.productInventoryBean.productBean.name}" /></td>
						
						<td><c:out value="${salesOrderLineItems.amount}" /></td>
						<td><c:out value="${salesOrderLineItems.unitPrice}" /></td>
						<td><c:out value="${salesOrderLineItems.discount}" /></td>
						<td><c:out value="${salesOrderLineItems.vat}" /></td>
						<td><c:out value="${salesOrderLineItems.netPrice}" /></td>
						<td><c:out value="${salesOrderLineItems.quantity}" /></td>
					<%--<td><c:out value="${salesOrderLineItems.payAmount}" /></td>	 --%>						
				
			
					</tr>
                 </c:if>
                 <c:if test="${flag==1}">
                 <tr id="<c:out value="${salesOrderLineItems.id}"/>1">
						<td><%=i%></td>
						<td><c:out value="${salesOrderLineItems.productInventoryBean.productBean.name}" /></td>
						
						<td><c:out value="${salesOrderLineItems.amount}" /></td>
						<td><c:out value="${salesOrderLineItems.unitPrice}" /></td>
						<td><c:out value="${salesOrderLineItems.discount}" /></td>
						<td><c:out value="${salesOrderLineItems.vat}" /></td>
						<td><c:out value="${salesOrderLineItems.netPrice}" /></td>
						<td><c:out value="${salesOrderLineItems.quantity}" /></td>
						<td><c:out value="${salesOrderLineItems.deliverableQuantity}" /></td>
						<td>
			<%-- <c:if test="${salesOrderLineItems.deliverableQuantity==0}">There is no Qty available in this order to return</c:if>
						<c:if test="${salesOrderLineItems.deliverableQuantity!=0}"><input type="text" name="<c:out value="${salesOrderLineItems.deliverableQuantity}" />" class="qty" value="0" id="<c:out value="${salesOrderLineItems.id}"/>"/>
						</c:if>--%>			
						<c:choose>
						<c:when test="${salesOrderLineItems.deliverableQuantity==0}">This item Qty is not available in this order to return</c:when>
						<c:otherwise><input type="text" name="<c:out value="${salesOrderLineItems.deliverableQuantity}" />" class="qty" value="0" id="<c:out value="${salesOrderLineItems.id}"/>"/>
						</c:otherwise>
						</c:choose>
						</td>
					<%--	<td><a href="#" onclick="createReturnOrder(<c:out value="${salesOrderLineItems.id}"/>,<c:out value="${salesOrderLineItems.quantity}" />)">Update</a></td>
					<td><c:out value="${salesOrderLineItems.payAmount}" /></td>	 --%>						
				
			
					</tr>
                 </c:if>
					
					<% i++; %>

				
				</c:forEach>
			</tbody>
			<c:if test="${flag==1}">
			<tfoot><tr><td colspan="2"><span class="changed_items"></span></td><td colspan="7"><button class="submit">Submit</button></td></tr></tfoot>
			</c:if>
		</table>
		

	</c:if>
<c:if test="${empty salesLineItems}"> Data is not available</c:if>
</div>

</body>
</html>
