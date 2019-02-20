<!--  
<h2>Menu</h2>
1. <a href="employees.html">List of Employees</a><br/>
 2. <a href="add.html">Add Employee</a> -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <!DOCTYPE html>
<html>
<head>
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<script src='js/jquery.1.10.2.min.js'></script>
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
			url: "http://localhost:8084/MedProj/agencyForm.html?id="+val,
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
 <li ><a href='userHome.html' id="user" style="font-weight: bolder;background: url('images/home1.png') no-repeat scroll 120px -2px transparent;background-size:30px 30px;border: none;"><span>&nbsp;Hi&nbsp;${sessionScope.user.firstName}-${sessionScope.user.lastName}</span></a></li>
   <li class="Transactions" ><a href='#'>Transactions</a>
   <ul>
         <li ><a href='sales.html'>Sales</a></li>
      </ul>
   </li>
   <li class="Masters"><a href='#'>Masters</a>
      <ul>
       	<li><a href='#'> Revenue Accounts </a></li>
      </ul>
   </li>
   <li class="Reports"><a href='#'>Reports</a>
      <ul>
         <li><a href='#'> Sales </a></li>
      </ul>
   </li>
    <li class="List"><a href='#'>List</a>
        <ul>
         <li><a href='masterProductsList.html'> Master Products List </a></li>
         <li><a href='agenciesList.html'> Agencies List </a></li>
         <li><a href='doctorsList.html'> Doctors List </a></li>
         <li class='last'><a href='organizationsList.html'> Organizations List </a></li>
      </ul>
   </li>
   <li class="Settings"><a href='#'>Settings</a>
        <ul>
         <li><a href='#'> Dummy </a></li>
         <li><a href='#'> Dummy </a></li>
         <li><a href='changePassword.html?id=${sessionScope.user.id}'> Change Password </a></li>
        
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
<li style="float:right;"><a href='logout.html' > Logout </a></li>

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

 