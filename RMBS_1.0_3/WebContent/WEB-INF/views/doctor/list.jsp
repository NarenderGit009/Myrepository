
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="js/tableSearch.js"></script>
 <script type="text/javascript" src="js/jquery1.7.2.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

$(document).ready(function() {
    noBack();
});

function noBack() {
   window.history.forward(1);
   }

    
  function editDoctor(val){
	  var data = val;
	  $.post('editDoctor.html?did=' +val, data, function(result){
		  $("#" + val + "2").html(result);
	  });
  }
  
  function deleteDoctor(val1,val2,val3){
	  alert('did:'+val1+';flag:'+val2+';uid:'+val3);
	  var data = val1;
	   $.post('deleteDoctor.html?did='+val1+'&flag='+val2+'&uid='+val3, data, function(result){
		  $(".col2").html(result);
	  });
  }
  function getDoctorsListByCategory(val1,val2){
	  var data = val1;
	  $.post('getDoctorssByCategory.html?uid='+val1+'&flag='+val2, data,function(result){
		  $(".col2").html(result);
	  });
  }
  function getUpdateDoctors(val1,val2){
	  var data = val1;
	  $.post('updateDoctors.html?uid='+val1+'&flag='+val2, data, function(result){
		  $(".col2").html(result);
	  });
  }
  

</script>
<style type="text/css">
#contentbody{
background-image:url(images/listbackground1.jpg);

background-size: 100% 100%;
background-repeat:no-repeat;
background-position: left;

}
#list{
width: 70%;

margin: auto;
margin-top: 10px;
}

#listcaption{
font-size: 30px;
font-weight: bold;
background-color:  #ddd;
}

.wrap {
    width: 850px;
}

.wrap table {
    width: 850px;
    table-layout: fixed;
   
}
.wrap table.head{
  background-color: #aaa;
}
.wrap table tr td {
    padding: 5px;
    border: 1px solid #eee;
    min-width: 100px;
    max-width: 100px;
    word-wrap: break-word;
}

.wrap table.head tr td {
   min-width: 85px;
   max-width: 85px;
    background: #eee;
}

.inner_table {
    height: 300px;
    overflow-y: auto;
    overflow-x: hidden;
  background-image:url(images/listbackground1.jpg);

background-size: 100% 100%;
background-repeat:no-repeat;
background-position: left;
}
.wrap .listfooter{
 width: 700px;
 height: 2px;
 background-color: #aaa;
 font-size: 15px;
 font-weight: bold;
}
.wrap .listfooter span{
float: right;
margin: auto;
}
#next{
float: right;
}
</style>
    <script>

    </script>

</head>
<body>
<div id="list">

<c:if test="${!empty doctors }">
<% int count=0; int d=0; int e=0; %>
<div class="wrap">
<table class="head">
<tr><th colspan="5" align="center" id="listcaptin">Doctors List</th>
<th colspan="2"><label id="search"></label>Search:<input id="input" name="filter" placeholder="search here" onkeyup="filter2(this,1)" type="text"/></th></tr>
<tr>
       <th>DId</th>
       <th>Doctor Name</th>
       <th>Initial</th>
       <th>Address</th>
       <th>PhNo</th>
       <th>Email</th>
       <th>Qualification</th>
       <th>Specialization</th>
       <th>Hospital Name</th>
    </tr>   
       
</table>
  <div class="inner_table">
  <table align="left" id="1" class="sortable">
  
  <thead><tr><th colspan="7"></th></tr></thead>
   <c:forEach items="${doctors }" var="doctor">
    <tr id="<c:out value="${doctor.did}"/>1">
         <td><c:out value="${doctor.did }"/></td>
         <td><c:out value="${doctor.doctorName }"/></td>
         <td><c:out value="${doctor.initial }"/></td>
         <td><c:out value="${doctor.phno }"/></td>
         <td><c:out value="${doctor.email }"/></td>
         <td><c:out value="${doctor.qualification }"/></td>
         <td><c:out value="${doctor.specialization }"/></td>
         <td><c:out value="${doctor.hospitalName }"/></td>
         <td>
         <c:if test="${doctor.status == 'E' }">
          <a href = "#" onclick="editDoctor(<c:out value="${doctor.did}"/>);"><img src="images/edit.png" alt="edit" height="20px" width="20px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href = "#" onclick = "deleteDoctor(<c:out value="${doctor.did }"/>);"><img src="images/Delete.png" alt="delete"  height="20px" width="20px"/></a>
          <% e++; %>
         </c:if>
         <c:if test="${doctor.status == 'D' }">
         <a href = "#" onclick="deleteDoctor(<c:out value="${doctor.did }"/>,2,<c:out value="${doctor.createdby }"/>);"><img src="images/correct.png" alt="edit" height="20px" width="20px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteDoctor(<c:out value="${doctor.did}"/>),1,<c:out value="${doctor.did }"/>);"><img src="images/pdelete1.png" alt="delete"  height="30px" width="30px"/></a>
         <% d++; %>
         </c:if>
         </td>
    </tr>
    <tr id="<c:out value="${doctor.did }"/>2"></tr>
    <% count++; %>
   </c:forEach>  
  </table>   
 <div class="listfooter">
  &nbsp; 
 <%if(e!=0){ %>
 <input type="button" value="Activated <%=e %>" onclick="getDoctorsListByCategory(<c:out value="${sessionScope.user.userId}"/>,'E');"/>
 <%}if(d!=0){ %>
  <input type="button" value="Disabled <%=d %>" onclick="getDoctorsListByCategory(<c:out value="${sessionScope.user.userId}"/>,'D');">
  <%}if(count!=0){%>
  <input type="button" value="Total" onclick="getDoctorsListByCategory(<c:out value="${sessionScope.user.userId}"/>,'T');"/>
  <%} %>
  Displayed&nbsp;<%=count %>
    <span>
    
    <%if(d>0){ %>Enable All&nbsp;<a href="#" onclick="getUpdateDoctors(<c:out value="${sessionScope.user.userId}"/>,0);"><img src="images/correct.png" alt="edit" height="20px" width="20px" align="middle"/></a>&nbsp;&nbsp;<%} %>
    <%if(e>0){ %>Disable All&nbsp;<a href="#" onclick="getUpdateDoctors(<c:out value="${sessionScope.user.userId}"/>,1);"><img src="images/Delete.png" alt="edit" height="20px" width="20px" align="middle"/></a>&nbsp;&nbsp;<%} %>
    <%if(count>0){ %>Delete All&nbsp;<a href="#" onclick="getUpdateDoctors(<c:out value="${sessionScope.user.userId}"/>,2);"><img src="images/pdelete1.png" alt="edit" height="20px" width="20px" align="middle"/></a>&nbsp;&nbsp; <%} %>
     </span> 
 </div>  
  </div>
</div>
</c:if>
</div>
</body>

</html>