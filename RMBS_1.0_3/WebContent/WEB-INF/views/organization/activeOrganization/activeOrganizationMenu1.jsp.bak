<!--  
<h2>Menu</h2>
1. <a href="employees.html">List of Employees</a><br/>
 2. <a href="add.html">Add Employee</a> -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:set value="${sessionScope.user.role}" var="id"/>
 <c:if test='${user.userId!="1"}'> 
 <!DOCTYPE html>
<html>
<head>
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	
	<style>
	
@media only screen and (min-width:980px) and (max-width: 1500px) {
.Transactions a{
width:100px;

}
.Masters a{
width:100px;
}
.Reports a{
width:100px;
}
.List a{
width:100px;
}
.Settings a{
width:80px;
}
.DataProcessing a{
width:100px;
}
.Help a{
width:50px;
}
}
</style>		
	
<link rel="stylesheet" type="text/css" href="css/menu/reset.css">
    <link rel="stylesheet" type="text/css" href="css/menu/slimmenu.css">
	<script src="js/menu/jquery.slimmenu.js"></script>
	<script type="text/javascript">
	function loadAgencyForm(val){
		alert(val);
		//alert( $("#lastname").val());
		$.ajax({
			type: "post",
			url: "http://localhost:8084/MedProj/agencyForm.html?userId="+val,
			cache: false,				
			//data:'id=' +val,
			
			success: function(data){
				alert(data);
				$('#regform').html(data);
				//$('#list').html(data);
				
				
				//var val1=data.model.createdby;
				//document.getElementById("createdby").value=val1;
				
				// $(".registerform").html(" vxcvxcv");
				//document.getElementById('replace').innerHTML = '/wesitemenu.jsp'; 
				//var obj = JSON.parse(user);
				//$('#websitemenu').html("First Name:- " + obj.firstname +"</br>Last Name:- " + obj.lastname  + "</br>Email:- " + obj.email);
			},
			error: function(){						
				alert('Error while request..');
			}
		});
		
	}
	</script>
</head>
<body>

 <script src="js/menu/jquery.slimmenu.js"></script>
<script src="js/menu/easing.min.js"></script>
   <ul class="slimmenu">
   <li ><a href='home.html?aid=${sessionScope.user.userId}' id="user" style="font-weight: bolder;background: url('images/home1.png') no-repeat scroll 90px -2px transparent;background-size:30px 30px;border: none;"><span>&nbsp;Hi&nbsp;${sessionScope.user.firstname}-${Logger.role}</span></a></li>
   <li class="Transactions" ><a href='#'>Transactions</a>
   <ul>
         <li ><a href='sales.html'>Sales</a></li>
         <li><a href='#'>Sales Returns</a></li>
         <li><a href='#'>Purchases</a></li>
         <li><a href='#'>Purchase Returns</a></li>
         <li><a href='#'>Damage/Breakages</a></li>
         <li><a href='#'>Expired Products</a></li>
      </ul>
   </li>
   <li class="Masters"><a href='#'>Masters</a>
      <ul>
         <li><a href='productEntryForm.html?userId=${sessionScope.user.userId}'> Product Stock Entry </a></li>
         <li><a href='#'> Products Upload </a></li>
         <li><a href='#'> Revenue Accounts </a></li>
         <li><a href='openBranchFrom.html?uid=${sessionScope.user.userId}'> Register Branch </a></li>
         <li><a href='doctorForm.html?userId=${sessionScope.user.userId}'> Register Doctor </a></li>
         <li class='last'><a href='agencyForm.html?userId=${sessionScope.user.userId}'> Register Agency </a></li>
         <!--  <li class='last'><a href='#' onclick="loadAgencyForm(<c:out value="${Logger.userId}"/>)"> Register Agency </a></li> -->
      </ul>
   </li>
   <li class="Reports"><a href='#'>Reports</a>
      <ul>
         <li><a href='#'> Sales </a></li>
         <li><a href='#'> Sales Returns </a></li>
         <li><a href='#'> Purchase </a></li>
         <li><a href='#'> Purchase Returns </a></li>
         <li><a href='#'> Product Sales </a></li>
      </ul>
   </li>
    <li class="List"><a href='#'>List</a>
        <ul>
         <li><a href='#'> Product Stock </a></li>
         <li><a href='#'> Sales Order </a></li>
         <li><a href='#'> Sales Return Order </a></li>
         <li><a href='#'> Purchase Order </a></li>
         <li><a href='#'> Purchase Return Order </a></li>
         <li><a href='#'> Master Products </a></li>
         <li><a href='agenciesList.html?userId=${sessionScope.user.userId}'> Agencies List </a></li>
         <li><a href='doctorsList.html?userId=${sessionScope.user.userId}'> Doctors List </a></li>
         <li><a href='#'> Users List </a></li>
      </ul>
   </li>
   <li class="Settings"><a href='#'>Settings</a>
        <ul>
         <li><a href='#'> Dummy </a></li>
         <li><a href='#'> Dummy </a></li>
         <li><a href='changePassword.html?userId=${sessionScope.user.userId}'> Change Password </a></li>
        
      </ul>
   </li>
    <li class="DataProcessing"><a href='#'> Data Processing </a>
      <ul>
         <li><a href='#'> Dummy </a></li>
         <li><a href='#'> Dummy </a></li>
         <li><a href='#'> Data Backup </a></li>
      </ul>
   </li>
   <li class="Help"><a href='#'>Help</a>
     <ul>
         <li><a href='#'> Mail </a></li>
         <li><a href='#'> Help Content </a></li>
         <li><a href='#'> Calculator </a></li>
      </ul>
   </li>
   
<!-- <li><img src="images/settings1.png" alt="loading" height="35px"/></li> -->
<li style="float:right;"><a href='logout.html'> Logout </a></li>

</ul>
<script>
$('ul.slimmenu').slimmenu(
{
    resizeWidth: '800',
    collapserTitle: 'Rely Services',
    easingEffect:'easeInOutQuint',
    animSpeed:'medium',
    indentChildren: true,
    childrenIndenter: '&raquo;'
});
</script>

</body>
</html>
</c:if>
<c:if test='${user.userId=="1"}'>
<jsp:include page="/WEB-INF/views/admin/adminMenu.jsp"></jsp:include>
</c:if>
 