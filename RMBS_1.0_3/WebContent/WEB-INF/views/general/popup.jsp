<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="css/popup.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" charset="utf-8" src="js/popup.js"></script>
</head>
<body>
    <div id="toPopup" > 
    	
        <div class="close"></div>
       	<span class="ecs_tooltip">Press Esc to close <span class="arrow"></span></span>
       	
		<div id="popup_content"> <!--your content start-->
		 <div id="userdetails">
		 <img alt="loading.." src="css/images/popup/white.gif" align="middle">
		 </div>
		 <div class="actionlinks"></div>
          <span class="action_tooltip">Click here to activate/ deactivate the owner<span class="arrow1"></span></span>
         <p align="center" class="actionlink"><a href="#" >Click Here Trigger</a></p>
        </div> <!--your content end-->
    
    </div> <!--toPopup end-->
    
	<div class="loader"></div>
   	<div id="backgroundPopup"></div>
</body>
</html>