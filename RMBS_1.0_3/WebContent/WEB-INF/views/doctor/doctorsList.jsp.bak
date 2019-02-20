
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
           
           
           function editDoctor(val){
        		
        	//	alert(val);
        		var data=val;
        		$.post('getDoctor.html?id='+val, data, function(result){
        		
        			 $("#editform").html(result);
        		});
        	}
           
            function updateDoctorStatus(val1,val2,val3){
            	
            //	alert(val1+"-"+val2+"-"+val3);
            	var data;
            	$.post('changeDoctorStatus.html?id='+val1+'&flag='+val2+'&uid='+val3, data, function(result){
            	
            		
            		$(".col2").html(result);
            	});
            }
            function updateDoctors(val1,val2){
            	
            	//alert(val1,val2);
            	var data=val1;
            	$.post('updateDoctors.html?uid='+val1+'&flag='+val2, data, function(result){
            	//	alert(result);
            		$(".col2").html(result);
            	});
            }

            function getDoctorsListByCategory(val1,val2){
            	
            	//alert(val1,val2);
            	var data=val1;
            	$.post('getDoctorssByCategory.html?uid='+val1+'&flag='+val2, data, function(result){
            	//	alert(result);
            		$(".col2").html(result);
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
    .wrap .listfooter{
 	width: 700px;
 	height: 30px;
 	background-color: #aaa;
 	font-size: 15px;
 	font-weight: bold;
	}
	.wrap .listfooter span{
	float: right;
	margin: auto;
	}

</style>
</head>
<body>

<jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>

<c:if test="${!empty doctors}">
<div id="editform"></div>
<% int count=0; int d=0;int e=0;%>
<h2 align="center" id="listcaption">Doctors List</h2> 
  <table  id="example" class="display" style="text-align: center;border-color: grey;" border="1">
                   <thead>
                   	<tr>
            <th>S.No</th>
            <th>DoctorName</th>
            <th>Qualification</th>
			<th>Specialization</th>
			<th>HospitalName</th>
			<th>Contact No</th>
			<th>Address</th>
			 <th>Action</th> 
			<%--<th>Email</th>	--%>		
		 
          	</tr>
                   	 
        		   </thead>
        		   <tbody><% int i=1; %>
        		   
        		    <c:set value="${sessionScope.user.id}" var="id"/>  		  
        		   
        		   
		<c:forEach items="${doctors}" var="doctor">
		  <c:set value="${Delete}" var="Del"/>
  <c:if test="${doctor.resourceBean.accountStatusBean.id!= Del }" >
		     
			   
	    <tr id="<c:out value="${doctor.id}"/>1">
	            <td><%=i%></td>
				<td><c:out value="${doctor.doctorName}"/></td>
				<td><c:out value="${doctor.qualification}"/></td>
				<td><c:out value="${doctor.specialization}"/></td>
				<td><c:out value="${doctor.hospitalName}"/></td>
				<td><c:out value="${doctor.resourceBean.addressBean.mobile}"/></td>
				<td><c:out value="${doctor.resourceBean.addressBean.address}"/></td>
				
			<%--	<td><c:out value="${doctor.resourceBean.addressBean.email}"/></td>--%>
				
		<c:if test='${doctor.resourceBean.createdBy ==id}'> 	
				 
				<c:set value="${Enable}" var="E"/>
		      <c:if test="${doctor.resourceBean.accountStatusBean.id == E}" >
				<td align="center"><a href="#" onclick="editDoctor(<c:out value="${doctor.id}"/>);"><img src="images/edit.png" alt="edit" height="20px" width="20px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateDoctorStatus(<c:out value="${doctor.id}"/>,0,<c:out value="${doctor.resourceBean.createdBy}"/>);"><img src="images/Delete.png" alt="delete"  height="20px" width="20px"/></a></td>
			    <% e++; %>
			    </c:if>
		 <c:set value="${Disable}" var="D"/>
			<c:if test="${doctor.resourceBean.accountStatusBean.id == D}" >
		         <td align="center"><a href="#" onclick="updateDoctorStatus(<c:out value="${doctor.id}"/>,1,<c:out value="${doctor.resourceBean.createdBy}"/>);"><img src="images/correct.png" alt="edit" height="20px" width="20px"/></a>&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateDoctorStatus(<c:out value="${doctor.id}"/>,2,<c:out value="${doctor.resourceBean.createdBy}"/>);"><img src="images/pdelete1.png" alt="delete"  height="20px" width="20px"/></a></td>  
			    <% d++; %>
			    </c:if>   	   
			  
		 </c:if>
			 <c:if test='${doctor.resourceBean.createdBy !=id}'><td>No Actions</td></c:if>
					 
			 </tr>
			   <% i++; %> 
			       <% count++; %>             
                 </c:if>    
                            
		</c:forEach>
		</tbody>
	</table>
	 <div class="listfooter">
	&nbsp;
	<%if(e!=0){ %>
	<input type="button" value="Activated <%=e %>" onclick="getDoctorsListByCategory(<c:out value="${sessionScope.user.id}"/>,'0');"/>
	<% }if(d!=0){ %>
	<input type="button" value="Disabled <%=d %>" onclick="getDoctorsListByCategory(<c:out value="${sessionScope.user.id}"/>,'1');"/>
	<% }if(count!=0){ %>
	<input type="button" value="Total" onclick="getDoctorsListByCategory(<c:out value="${sessionScope.user.id}"/>,'T');"/>
	<%} %>
	Displayed&nbsp;<%=count%>
	<span>
	
	<% if(d>0){ %>Enable All&nbsp;<a href="#" onclick="updateDoctors(<c:out value="${sessionScope.user.id}"/>,0);"><img src="images/correct.png" alt="edit" height="20px" width="20px" align="middle"/></a>&nbsp;&nbsp;<%} %>
    <% if(e>0){ %>Disable All&nbsp;<a href="#" onclick="updateDoctors(<c:out value="${sessionScope.user.id}"/>,1);"><img src="images/Delete.png" alt="edit" height="20px" width="20px" align="middle"/></a>&nbsp;&nbsp;<%} %>
	<% if(count>0){ %>Delete All&nbsp;<a href="#" onclick="updateDoctors(<c:out value="${sessionScope.user.id}"/>,2);"><img src="images/pdelete1.png" alt="edit" height="20px" width="20px" align="middle"/></a>&nbsp;&nbsp;<%} %>
	</span>
	
	</div>

</c:if>



</body>
</html>
