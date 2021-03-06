
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
       
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" />
         <script type="text/javascript" charset="utf-8" src="js/jquery1.7.2.js"></script>
        <script type="text/javascript" charset="utf-8" src="media/js/dataTables.js"></script>
        <link href="css/responsiveTable.css" rel="stylesheet"/>
        
          <script type="text/javascript" charset="utf-8">
           $(document).ready( function () {
                $('#example').dataTable( {
                    "bJQueryUI": true,                     
                    "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
                    "iDisplayLength": 5,
                } );
           } );
           
       /*    function updateOwner(val,status){
        	  $.post('updateOwnerByAdmin.html', {owner:val,flag:status}, function(users){
        		  if(users!=null){
        			  for (i in users){
        			 alert(users[i].user.username);
        			 usersTableBodyHtml='<tr><td>'+(i+1)+'</td>',
        			 usersTableBodyHtml+='<td>'+users[i].user.username+'</td>',
        			 usersTableBodyHtml+='<td>'+users[i].user.address+'</td>',
        			 usersTableBodyHtml+='<td>'+users[i].user.mobile+'</td>',
        			 usersTableBodyHtml+='<td>'+users[i].user.email+'</td>',
        			 usersTableBodyHtml+='<td>'+users[i].user.active+'</td>',
        			 usersTableBodyHtml+='<td><a href="#" class="topopup" onclick="getUser('+users[i].user.id+');">Details</a></td></tr>';
        			  }
        			  $('#userslist').html(usersTableBodyHtml);
        		  
        		  }
        	  });
           }
           */
           function updateBranch(val,status){
         	  $.post('updateBranchStatusByAdmin.html', {branch:val,flag:status}, function(result){
         		  if(result!=null){
         		  $('#active'+val+'').html(result.resourceModel.accountStatusModel.status);
         		  }
         	  });
            }
           function getBranch(val){
        	 //  var data=val;
       
        	// alert(val);
        	  $.post('getBranch.html', {branch:val}, function(result){
        		//  alert(result);
        		   ownerHtml ='<table><tr><th>Branch Owner Name:</th><td>'+result.firstName+' '+result.lastName+'</td></tr>',
           	       ownerHtml+='<tr><th>Branch Name:</th><td>'+result.name+'</td></tr>',
           	       ownerHtml+='<tr><th>Address:</th><td>'+result.resourceModel.addressModel.address+'</td></tr>',
           	       ownerHtml+='<tr><th>Tinno:</th><td>'+result.tinNo+'</td></tr>',
           	    ownerHtml+='<tr><th>Registered Date & Time:</th><td>'+result.registeredDateTime+'</td></tr></table>';
        	      
        	       
        	       if(result.resourceModel.accountStatusModel.status=='INACTIVE'){
           	    	  
           	    	link1='<a href="#" onclick="updateBranch('+val+',0)">Activate</a>';  
           	       $('.actionlink').html(link1);
           	       }else{
           	    	
           	    	link2='<a href="#" onclick="updateBranch('+val+',1)">Deactivate</a>';
           	      $('.actionlink').html(link2);
           	       }
           	      
           	       $('#userdetails').html(ownerHtml);
           	      
           	});
           }
           
           
           
 </script>
<style>
  
 

	.actionlink a{
	text-decoration: none;
	background-color: lightblue;
	text-decoration: blink;
	padding: 5px;
	color: white;
	font-weight: bold;
	margin: 10px;
	float: right;
	}   
	a{
	text-decoration: none;
	}  
	#userdetails{
	background-image:url(images/listbackground1.jpg);
	}


</style>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>
    <div id="bdy">
        
     <c:if test="${!empty branches}">
  
    
  <%-- Parent menu options: ${sessionScope.user.userMenu.parentmenu}<br>
     Child menu options: ${sessionScope.user.userMenu.childmenu} --%>   

     <c:if test="${sessionScope.user.resourceBean.roleBean.id==2}" >
  <h3> Branches List</h3>
</c:if>
     <c:if test="${sessionScope.user.resourceBean.roleBean.id==3}" >
  <h2> Outlets List</h2>
</c:if>
     
     
        <div id="container" style="margin: auto;width:100%;">
            <div class="list">
                <table  id="example" class="display" style="text-align: center;border-color: grey;" border="1">
                   <thead>
                   	<tr>
                   		<th>Sl.No</th>
                   	 	<th>Branch Owner</th>
                   	 	<th class="optional">Address</th>
       			   	 	<th>Mobile</th>
        			 	<th>Email</th>
        			 <%--<th>role</th> --%>	
         			 	<th>Activation Status</th>
         			 	<th>Action</th>
                   	</tr>
                   	 
        		   </thead>
        		   <tbody id="userslist"> 
        		   <%int i=1; %>
        		  
        		   <c:forEach items="${branches}" var="branch">
        		  
        	
                    <tr>
                        <td><%=i %></td>
                   		<td title="<c:out value="${branch.userName}"/>"><c:out value="${branch.userName}"/></td>
				       <td class="optional"><c:out value="${branch.resourceBean.addressBean.address}"/></td>
				        <td title="<c:out value="${branch.resourceBean.addressBean.mobile}"/>"><c:out value="${branch.resourceBean.addressBean.mobile}"/></td>
				        <td title="<c:out value="${branch.resourceBean.addressBean.email}"/>"><c:out value="${branch.resourceBean.addressBean.email}"/></td>
				       <%--    <td title="<c:out value="${branch.resourceBean.releBean.role}"/>"><c:out value="${branch.resourceBean.role}"/></td>--%>     
				        <td id="active${branch.id}" class="active"><c:out value="${branch.resourceBean.accountStatusBean.flag}"/></td>
				         <td><a href="#" class="topopup" onclick="getBranch(${branch.id})">Details</a></td>
                   </tr>
                   <%i++; %>
            
                
                 </c:forEach>
                 </tbody>
        </table>
  </div>
</div>
</c:if>

</div>
	
 </body>
</html>