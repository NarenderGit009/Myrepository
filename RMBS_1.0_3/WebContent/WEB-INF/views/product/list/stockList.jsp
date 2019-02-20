<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/masters/productentryform.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">
<script src="js/tabs/easyResponsiveTabs.js"></script>
<style>

 .wrapper {
 font-family:calibri;
    font-size: 15px;
    color: #736F69;
}



.wrapper input[type=text] {
    
    width: 140px;
 }
 .wrapper input[type=password] {
    
    width: 140px;
 }
.wrapper label {
    width:80px;
    
    display: inline-block;
}
 .wrapper input[type=submit]{
 float: right;
 background: url("images/green.png") repeat scroll 0 0 transparent;
 border: none;
 color: #fff;
 font-weight: bold;
 }
@media only screen   
and (max-width:750px) {
.wrapper{
   width: 97%;
}
}
@media only screen and (min-width:750px) and (max-width: 980px) {
.wrapper{
   width: 90%;
  margin: auto;
}
.wrapper input[type=text] {
    
    width: 120px;
 }
}
</style>

<script type="text/javascript">
function loadProductStock(){
	//alert("loadMedicalForm called");
	msg="Please wait...  List is loading...";
	loadAjaxPopup(msg);
	$.get("productStockList.html", function(result){
		//alert(medical_form);
		$(".productStockList").html(result);
		});
	disableAjaxPopup();
	}
/*
function loadGeneralForm(){
	//alert("loadGeneralForm called");
	$.get("productEntryForm.html?task_type=main&task_form_type=general", function(general_form){
		//alert(general_form);
		$(".general_form_container").html(general_form);
	});
	
}*/
</script>
	<style>
.resp-tab-content{
border: none;
padding: 0px;	
	}
.resp-tabs-list a{
text-decoration: none;

}	
.activemode{
background-image: url("images/green.png");

}

.ProductStockEntry {
	width: 100%;
}
.valueBoxes{
margin-top: 10px;
}
.valueBoxes div {

	display: inline-block;
}

.valueBoxes label {
	min-width: 120px;
	padding-right: 0px;
	text-align: right;
}

.valueBoxes select {
	width: 155px;
}
#msg{
float:right;
font-weight: bold;
}
.valueBoxes input {
	padding-right: 30px;
}

.wrapper input[type="submit"]{
	float: right;
	margin : 10px;
}
</style>
</head>
<body>
<c:set value="${productLogs}" var="productLog"></c:set>
<c:set value="${createdRole}" var="role"></c:set>
<c:set value="${outlet}" var="outlet"></c:set>
 <!--Horizontal Tab-->
        <div id="horizontalTab">
            <ul class="resp-tabs-list">            
            <li onclick="loadProductStock();" class="activemode" style="color: #fff;border-color: #3C873C;">Product Stock List</li>
           <%-- <c:if test="${productLog.creatorRoleBean.id != outlet} "> --%>  
            <li ><a style="color: #3C873C;" href="productLogList.html">Move To Product Log List</a></li>
         <%--  </c:if> --%>  
               
                
               <%-- <li onclick="loadMedicalForm();"><a href="productEntryForm.html?task_form_type=medical" class="form_active">Medical Products Entry Form</a></li>
                <li onclick="loadGeneralForm();"><a href="productEntryForm.html?task_form_type=general" class="form_inactive">General Products Entry Form</a></li>--%> 
               
            </ul>
            <div class="resp-tabs-container">
                <div class="productStockList">
                   <p><jsp:include page="/WEB-INF/views/product/list/productStockList.jsp"></jsp:include></p>
 				</div>
            <c:if test="${productLog.creatorRoleBean.id != outlet}">
            <div class="productLogList">
                  <p></p>
                </div>
            </c:if>
                
              
            </div>
        </div>

   <script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion           
            width: '1000px', //auto or any width like 600px
            fit: true,   // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            activate: function(event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#tabInfo');
                var $name = $('span', $info);

                $name.text($tab.text());

                $info.show();
            }
        });

        $('#verticalTab').easyResponsiveTabs({
            type: 'vertical',
            width: '800px',
            fit: true
        });
    });
</script> 

</body>
</html>