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
	<!--  <link rel='stylesheet' type='text/css' href='css/styles.css' /> -->
	
	<link rel="stylesheet" type="text/css" href="css/menu/reset.css">
    <link rel="stylesheet" type="text/css" href="css/menu/slimmenu.css">
	<script src="js/menu/jquery.slimmenu.js"></script>
	<script src="js/menu/easing.min.js"></script>
	<style type="text/css">
	.slimmenu a{
            width:100px;
        }
	
	</style>
</head>

<body>
<div id='cssmenu'>
<ul class="slimmenu" style="">
 <li ><a href='home.html?aid=${sessionScope.user.id}' id="user" style="font-weight: bolder;background: url('images/home1.png') no-repeat scroll 90px -2px transparent;background-size:30px 30px;border: none;"><span>&nbsp;Hi&nbsp;${sessionScope.user.firstName}-${Logger.role}</span></a></li>
   <li class='has-sub'><a href='index.html'><span>&nbsp;&nbsp;Profile&nbsp;&nbsp;</span></a>
   <ul>
         <li><a href='#'><span>dummy</span></a></li>
         
         
         <li class='last'><a href='#'><span>Edit Profile</span></a></li>
      </ul>
   </li>
   <li class='has-sub'><a href='index.html'><span>&nbsp;&nbsp;Payments&nbsp;&nbsp;</span></a>
   <ul>
         <li><a href='#'><span>dummy</span></a></li>
         <li><a href='#'><span>dummy</span></a></li>
         
         <li class='last'><a href='#'><span>Payment Form</span></a></li>
      </ul>
   </li>
 
   <li class='has-sub'><a href='#'><span>&nbsp;&nbsp;Activation&nbsp;&nbsp;</span></a>
        <ul>
         <li><a href='#'><span>Enter License Key</span></a></li>
         <li><a href='#'><span>Dummy</span></a></li>
         <li class='last'><a href='#'><span>Dummy</span></a></li>
      </ul>
   </li>
    <li class='has-sub'><a href='#'><span>&nbsp;&nbsp;Offers&nbsp;&nbsp;</span></a>
      <ul>
         <li><a href='#'><span>Dummy</span></a></li>
         <li><a href='#'><span>Dummy</span></a></li>
         <li class='last'><a href='#'><span>Data Backup</span></a></li>
      </ul>
   </li>
   <li class='has-sub'><a href='#'><span>&nbsp;&nbsp;Contact&nbsp;&nbsp;</span></a>
        <ul>
         <li><a href='#'><span>Contact Info</span></a></li>
         <li><a href='#'><span>Mail</span></a></li>
         <li class='last'><a href='#'><span>Help</span></a></li>
      </ul>
   </li>
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
</div>
</body>
</html>

 