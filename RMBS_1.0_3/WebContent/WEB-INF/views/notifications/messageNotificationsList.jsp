
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
                $('#example4').dataTable( {
                    "bJQueryUI": true,                     
                    "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
              //      "iDisplayLength": 10,
                } );
           } );
           
    function convertArrayToSritng(ids){
    	var idString="";
    	var i=0;
    //	alert(ids);
    	for(i;i<ids.length;i++){
    		idString=idString+ids[i]+",";
    //		alert(idString);
    	}
   /* 	ids.each(function(){
    		idString=idString+ids[i]+",";
    		i++;
    	});*/
    	return idString;
    }      
           
           jQuery('.checkAll').click(function(){        	 
        	               var parentTable = jQuery(this).parents('table');        	
        	               var ch = parentTable.find('#checkbox');        
        	               if(jQuery(this).is(':checked')) { 
        	                   //check all rows in table
        	  
        	                   ch.each(function(){        
        	                       jQuery(this).attr('checked',true);       
        	                       jQuery(this).parent().addClass('checked'); //used for the custom checkbox style
        	                      jQuery(this).parents('tr').addClass('selected'); // to highlight row as selected
        	
        	                   });
        
        	               } else {        	
        	                   //uncheck all rows in table
        	                  ch.each(function(){
        	                       jQuery(this).attr('checked',false);
        	                       jQuery(this).parent().removeClass('checked');   //used for the custom checkbox style
        	                       jQuery(this).parents('tr').removeClass('selected');
        	  
        	                   });
        	
        	               }
        
        	           });
           
           
           
           jQuery('#mark_read').click(function(){ 
        	   var c = false;
        	   var selected = [];
        	   $('.display input:checked').each(function() {
        		  selected.push($(this).attr('id'));
        	   });
        	//   alert(selected);
        	   if(selected.length>0){ c = true;}
        	 /*      var c = false;        
        	       var cn = 0;      
        	       var o = new Array();        	
        	       jQuery('.display input:checkbox').each(function(){        	  
        	           if(jQuery(this).is(':checked')) {        	   
        	               c = true;    
        	               alert(jQuery(this).value);
        	               o[cn] = jQuery(this);
        	               console.log(o);
        	               cn++;
        	                     	               
        	           }
        	           }); */
        	             var data= {ids:convertArrayToSritng(selected)};
      	      	//	 alert(data);
      	      			  $.post('updateMessageStatus.html?flag=read', data, function(result){
          					 $("#messages").html(result);
          	   });
      	      
        	       if(!c) {        	
        	           alert('No selected message');
                	       } else {
               	           var msg = (selected.length > 1)? 'messages' : 'message';        	  
        	           if(confirm('Mark '+selected.length+' '+msg+' to read')) {        
        	               for(var a=0;a<selected.length;a++) {        	  
        	                  jQuery(selected[a]).parents('tr').removeClass('unread');   
        	                  
        	               }
        	  
        	           }
        	           
        	       }
        
        	   });
      /*     function applyCss(rows){
        	   
        	   alert(rows);
       			$(this).css("color","red");
           }
           */
           jQuery('#mark_unread').click(function(){        	
        	             var c = false;
        	        	   var selected = [];
        	        	   $('.display input:checked').each(function() {
        	        		  selected.push($(this).attr('id'));
        	        	   });
        	        	
        	        	   if(selected.length>0){ c = true;}
        	        	
        	        	      var data= {ids:convertArrayToSritng(selected)};        	      	      	
        	      	        $.post('updateMessageStatus.html?flag=unread', data, function(result){
        	          		 $("#messages").html(result);
        	          	   });
        	      	      
        	         if(!c) {        	   
        	             alert('No selected message');        	   
        	         } else {        	   
        	             var msg = (selected.length > 1)? 'messages' : 'message';        	
        	             if(confirm('Mark '+selected.length+' '+msg+' to unread')) {        
        	                 for(var a=0;a<selected.length;a++) {         	                	
        	                     jQuery(selected[a]).parents('tr').addClass('unread');      
        	                 }
        	            }
        	  
        	         }
        
        	   });
           
           if(jQuery('#del').length > 0) {        	  
        	   jQuery('#del').click(function(){        
        		   var c = false;
	        	   var selected = [];
	        	   $('.display input:checked').each(function() {
	        		  selected.push($(this).attr('id'));
	        	   });
	        	
	        	   if(selected.length>0){ c = true;}
	        	
	        	      var data= {ids:convertArrayToSritng(selected)};        	      	      	
	      	        $.post('updateMessageStatus.html?flag=hide', data, function(result){
	          		 $("#messages").html(result);
	          	   });
	      	      
        	       if(!c) {
        	           alert('No selected message');        	
        	       } else {        	
        	           var msg = (selected.length > 1)? 'messages' : 'message';        
        	           if(confirm('Delete '+selected.length+' '+msg+'?')) {
        	        	   for(var a=0;a<selected.length;a++) {        	  
        	                   jQuery(selected[a]).parents('tr').remove();	
        	
        	           }
        	
        	       }
        	       }
        	   });
        	 
        	   }


       
           </script>
<style>
.UNREAD {
	font-weight: bold;
	color: black;
}

.READ {
	font-weight: normal;
	color: gray;
}

html {
	font-family: calibri;
	color: #000000;
	font: bold;
}

.resp-tabs-container {
	color: #000000;
	font-family: calibri;
	font-size: 15px;
}

display.mark_read {
	color: #736F69;
	font-family: calibri;
	font-size: 15px;
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

.list td,th {
	text-align: center;
}

.buttons {
	background-image: url(images/green.png);
}
</style>
</head>
<body>

	<c:if test="${!empty messageNotificationsToAdmin}">		
		
		<div class="messageNotificationsList"></div>

		<h2 align="center" class="listcaption">Inbox of messages</h2>
		<table id="example4" class="display"
			style="text-align: center; border-color: grey;" border="1">
			<div class="buttons">
				<input type="submit" id="mark_read" class="mark_read"
					value="Mark as Read" /> <input type="submit" id="mark_unread"
					value="Mark as Unread" /> <input type="submit" id="del"
					value="Delete" />
			</div>
			<thead>
				<tr>
					<th><input type="checkbox" class="checkAll"></th>
					<th>From</th>
					<th>Status</th> 
					<th>Message</th>
					<th>Date</th>

				</tr>

			</thead>
			<tbody>			
				<c:set value="${sessionScope.user.id}" var="id" />


				<c:forEach items="${messageNotificationsToAdmin}" var="msgNotification">
				<c:set value="${hide}" var="hide" />
					<c:if test="${msgNotification.statusBean.id!= hide }">
				

					<tr class="<c:out value="${msgNotification.statusBean.flag}" />">
						<%-- <td><%=i%></td> --%>
						<td><input type="checkbox"
							id="<c:out value="${msgNotification.id}"/>"></td>
						<td><c:out value="${msgNotification.creatorName}" /></td>
						<td><c:out value="${msgNotification.statusBean.flag}" /></td>	
						<td><c:out value="${msgNotification.message}" /></td>
						<td><c:out value="${msgNotification.createdDate}" /></td>


					</tr>
				

				</c:if>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	<c:if test="${empty messageNotificationsToAdmin}"> Data is not available</c:if>



</body>
</html>
