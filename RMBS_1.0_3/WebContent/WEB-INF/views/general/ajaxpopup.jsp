<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="css/ajaxpopup.css" rel="stylesheet" type="text/css" />
<%--  <script type="text/javascript" charset="utf-8" src="js/ajaxpopup.js"></script>--%>
<script type="text/javascript">
var popupStatus = 0; // set value

function loadAjaxPopup(msg) { 
	if(popupStatus == 0) { // if value is 0, show popup
		//closeloading(); // fadeout loading
		$("#toPopup").fadeIn(0500); // fadein popup div
		$("#backgroundPopup").css("opacity", "0.7"); // css opacity, supports IE7, IE8
		$(".ajaxmsg").html(msg.displaymsg).css("font_weight","bold");
		$("#backgroundPopup").fadeIn(0001); 
		popupStatus = 1; // and set value to 1
	}	
}
	
function disableAjaxPopup() {
	if(popupStatus == 1) { // if value is 1, close popup
		$("#toPopup").fadeOut("normal");  
		$("#backgroundPopup").fadeOut("normal");  
		popupStatus = 0;  // and set value to 0
	}
}
function showInvoice(invoive){
	if(popupStatus == 0) { // if value is 0, show popup
		//closeloading(); // fadeout loading
		$("#toPopup").fadeIn(0500); // fadein popup div
		$("#backgroundPopup").css("opacity", "0.7"); // css opacity, supports IE7, IE8
		$(".loadingImg").css("display","none");
		$(".ajaxmsg").html(invoive);
		$("#backgroundPopup").fadeIn(0001); 
		popupStatus = 1; // and set value to 1
	}	
}
function closeInvoice() {
		if(popupStatus == 1) { // if value is 1, close popup
			$("#toPopup").fadeOut("normal");  
			$("#backgroundPopup").fadeOut("normal");  
			popupStatus = 0;  // and set value to 0
		}

}
</script>
</head>
<body>
    <div id="toPopup" > 
    	
        
       	
		<div id="popup_content"> <!--your content start-->
		 <div id="information">
		 <div class="loadingImg"><img alt="loading.." src="css/images/popup/white.gif" align="middle"></div>
		 <div class="ajaxmsg"></div>
		 </div>
		 
        </div> <!--your content end-->
    
    </div> <!--toPopup end-->
    
	<div class="loader"></div>
   	<div id="backgroundPopup"></div>
</body>
</html>