
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
                    "sScrollY": "100%",
               	   "sScrollX": "100%",
               	"bScrollCollapse": true,
               	 //  "bPaginate": false,
                 //   "sPaginationType": "full_numbers",
                    //"sDom": '<"H"Tfr>t<"F"ip>',
                 //   "iDisplayLength": 5,
                } );
           } );
    
           function saveMenu(uid){
        	  // var checkedValue = new Array();
        	   var checkedValue; 
        	   var inputElements = document.getElementsByTagName('input');
        	   var j=0;
        	   checkedValue=uid;
        	   for(var i=0; inputElements[i]; ++i){
        	         if(inputElements[i].className==="childOptions" && 
        	            inputElements[i].checked){
        	        	
        	       //	checkedValue[j+1] = inputElements[i].value.slice(1,inputElements[i].value.length);
        	       // 	 j++;
        	           if(j==0){
        	        	   checkedValue=inputElements[i].value.slice(1,inputElements[i].value.length);
        	        	   j++;
        	        	  
        	           }else{
        	        	   checkedValue+=",";
        	        	   checkedValue+=inputElements[i].value.slice(1,inputElements[i].value.length);
        	        	   j++;
        	           }
        	           
        	        	 
        	         }
        	   }
        	  // alert(checkedValue);
        	  // alert(uid);
        	 //  data=checkedValue;
        	//   $.post('saveMenu.html', {menu:checkedValue,flag:status}, function(user1){
        	//	   alert(user1);
          		//  if(result!=null){
          		//  $('#active'+val+'').html(result.active);
          		//  }
          	//  });
        	return checkedValue;
           }
           function updateOwner(val,status){
        	   var checkedValue=saveMenu(val);
        	   alert(checkedValue);
         	  $.post('updateOrgStatusByAdmin.html', {menu:checkedValue,owner:val,flag:status}, function(result){
         		  if(result!=null){
         			  alert(result.resourceModel.accountStatusModel.status);
         		  $('#active'+val+'').html(result.resourceModel.accountStatusModel.status);
         		  }
         	  });
            }
           function getUser(val){
        	//registeredDateTime;;lastLoginedDateTime;lastLoginedDateTime;
        	   $.post('getUser.html', {owner:val}, function(result){
        		   ownerHtml ='<div class="userdetailscol"><div class="userdetailsheader">'+result.userName+' details</div><table><tr><th>Owner Name:</th><td>'+result.userName+'</td></tr>',
           	       ownerHtml+='<tr><th>Shop Name:</th><td>'+result.name+'</td></tr>',
           	   	   ownerHtml+='<tr><th>Date Of Birth:</th><td>'+result.dob+'</td></tr>',
           	       ownerHtml+='<tr><th>License key:</th><td>'+result.licensekey+'</td></tr>',
           	    //if result.licensekey
           	       
           	       ownerHtml+='<tr><th>Address:</th><td>'+result.resourceModel.addressModel.address+'</td></tr>',
           	       ownerHtml+='<tr><th>Tinno:</th><td>'+result.tinNo+'</td></tr>',
           	  	   ownerHtml+='<tr><th>Registered Date & Time:</th><td>'+result.registeredDateTime+'</td></tr>',
        	       ownerHtml+='<tr><th>Expiry Days:</th><td>'+result.expirydays+'days</td></tr>',
        	       ownerHtml+='<tr><th>License Validity:</th><td>'+result.licensevaliddays+'days</td></tr>',
        	       ownerHtml+='<tr><th>License key:</th><td>'+result.licensekey+'</td></tr>',
        	       ownerHtml+='<tr><th>Used Days:</th><td>'+result.daysCount+'days</td></tr></table></div>',
        	       ownerHtml+='<div class="usermenu"><div class="usermenuheader">Assign Menu To '+result.userName+'</div><div class="usermenuoptions"></div>',
        	       ownerHtml+='<div class="save"></div></div>';
           	       if(result.resourceModel.accountStatusModel.id==1){
           	    	  
           	    	link1='<a href="#" onclick="updateOwner('+val+',0)">Activate</a>';  
           	       $('.actionlink').html(link1);
           	       }else{
           	    	
           	    	link2='<a href="#" onclick="updateOwner('+val+',1)">Deactivate</a>';
           	      $('.actionlink').html(link2);
           	       }
           	    
           	       $('#userdetails').html(ownerHtml);
           	      
           	});
        	  // loadMenuOptions(val);
        	   
           }
           var menuListHtml='<form>';
           function loadMenuOptions(uid){
        	   $.post('loadMenu.html',{flag:0}, function(menu){
          		  if(menu!=null){
          			//  alert(result);
          		 var menuListHtml='<form class="menusForm">';	
          			generateMenuList(menu,0,uid);
          		//	alert(menu);
          		//	$('.slimmenu').html(menu);
          		  }
     		
     			 });
           }
         
           
       	// var c=0;
       	 	
             function generateMenuList(menu,val1,uid){
           	//  c++;
        //  alert(uid);
                    var m=val1;
       			 var n=m;
       			 if(m<menu.length){
       				  parentItem=menu[m].parentMenu.parentmenucontent;
       				menuListHtml+='<div class="parent"><input type="checkbox" class="parentOptions" name="parent[]" class="'+menu[m].parentMenu.idparent+'"  id="'+menu[m].parentMenu.idparent+'"><label for="checkbox" style="font-weight:bold">'+parentItem+'</label></div>';
       				  do{
       					  n=m;
       					  if(parentItem == menu[n].parentMenu.parentmenucontent){
       						menuListHtml+='<div><input type="checkbox" class="childOptions" name="child[]" value="'+menu[n].parentMenu.idparent+''+menu[n].idchild+'" id="'+menu[n].parentMenu.idparent+''+menu[n].idchild+'"><label for="checkbox">'+menu[n].childmenucontent+'</label></div>';
       							 m++;
       					   }else{
       						 // alert(menuListHtml);
       						menuListHtml+='<div style="width=100%;height:10px;">&nbsp;</div>';
       						      break;    
       						 }
       					}while (m < menu.length);
       				  if(m < menu.length){
       					generateMenuList(menu,m,uid);
       				       }       				  
       				  else{       					
              			 menuListHtml+='</form>';
              			 alert(uid);
              		/*	save='<div class="submit"><input type="button" class="button" value="Save" onclick="saveMenu('+uid+')"/></div>';*/
              			 $('.usermenuoptions').html('');
              			 $('.usermenuoptions').html(menuListHtml);
              			$('.save').html('');
             			 $('.save').html(save);
       				  }
       			 }
       			
       	 }
           
 </script>
 <style>
   
/*	.usermenu ul{
	width: 100%;
		list-style:none;
    }
    .usermenu ul li ul li{
        display: inline-block;
        vertical-align: top;
      /*   border: 1px solid white;
		
       background-color: #ffffff;        */
    }
   /* .content-wrapper .col1 {
        width: 275px;
        min-height: 300px;
    }*/
   .usermenu .parent{
   width: 100%;
}

</style>
<style>
 html{
font-family:calibri;
    color: #736F69;
}

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
	margin: auto;
	witdh: 100%;
	background-image:url(images/listbackground1.jpg);
	}
/* #userdetails  .usermenucol, .#toPopup .userdetailscol {
        display: inline-block;
        vertical-align: top;
        border: 1px solid #ffffff;
        background-color: #ffffff;        
    }*/
 
    #userdetails .usermenu, #userdetails .userdetailscol {
        display: inline-block;
        vertical-align: top;
       /*   border: 2px solid #ffffff;
      background-color: #ffffff;        */
    }
       #userdetails .usermenu{
        width: 39%;
        border-right: none;
        height:350px;
    }
    #userdetails .usermenu .usermenuoptions{
        width: 100%;
        border-right: none;
        height:290px;overflow:auto;overflow-x:hidden;
    }
    #userdetails .userdetailscol {
       width: 56%;
       
        height:350px;overflow:auto;overflow-x:hidden;
    }
    #userdetails .usermenu .usermenuheader,  #userdetails .userdetailsheader{
     font-weight: bold;
     font-size:16px;
     background-color: transparent;
   
     margin-top: 5px;
     width: 100%;
     height: 20px;
     text-align: center;
    }
    #userdetails .usermenu .save{
    float: right;
    
    }
    #userdetails .usermenu .save .button{
    background-color: transparent;
    border: 2px solid white;
    margin: 2px;
    }
    #userdetails th{
    font-weight: bold;
   border: none;
    
    }
</style>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/general/popup.jsp"></jsp:include>
    <div id="bdy">
      
     <c:if test="${!empty users}">
    
    <%-- <c:set var="admin" value="1"></c:set>
     <c:if test="${sessionScope.user.resourceBean.roleBean.id =='1'}">--%> 
  
  <h2> <a href="#">Lists </a>&gt;&gt;<a href="#">Users List</a></h2>
<div style="height:20px;"></div>
     <c:out value="${userscount}"/>
        <div id="container" style="margin: auto;width:100%;">
            <div class="list">
                <table  id="example" class="display" style="text-align: center;border-color: grey;" border="1">
                   <thead>
                   	<tr>
                   		<th>Sl.No</th>
                   	 	<th>Owner</th>
                   	 	<th class="optional">Address</th>
       			   	 	<th>Mobile</th>
        			 	<th>Email</th>
         			 	<th>Account Status</th>
         			 	<th>Action</th>
                   	</tr>
                   	 
        		   </thead>
        		   <tbody id="userslist"> 
        		   <%int i=1; %>
        		    <c:set value="${sessionScope.user.id}" var="id"/>
        		   <c:forEach items="${users}" var="user">
        		  
        		   <c:if test='${user.id!=id}'>
                    <tr>
                        <td><%=i %></td>
                   		<td title="<c:out value="${user.userName}"/>"><c:out value="${user.userName}"/></td>
				        <td class="optional"><c:out value="${user.resourceModel.addressModel.address}"/></td>
				        <td title="<c:out value="${user.resourceModel.addressModel.mobile}"/>"><c:out value="${user.resourceModel.addressModel.mobile}"/></td>
				        <td title="<c:out value="${user.resourceModel.addressModel.email}"/>"><c:out value="${user.resourceModel.addressModel.email}"/></td>
				        <td id="active${user.id}" class="active"><c:out value="${user.resourceModel.accountStatusModel.status}"/></td>
				         <td><a href="#" class="topopup" onclick="getUser(${user.id})">Details</a></td>
                   </tr>
                   <%i++; %>
                   </c:if>
                
                 </c:forEach>
                 </tbody>
        </table>
  </div>
</div>
</c:if>
<c:if test="${empty users}"> Data is not available</c:if>
 <%-- </c:if> --%>
</div>
	
 </body>
</html>