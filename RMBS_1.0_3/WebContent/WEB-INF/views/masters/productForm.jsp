<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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



</head>
<body>

 <!--Horizontal Tab-->
        <div id="horizontalTab">
            <ul class="resp-tabs-list">
                <li>Medical Products Entry Form</li>
                <li>General Products Entry Form</li>
               
            </ul>
            <div class="resp-tabs-container">
                <div>
                   <p><jsp:include page="/WEB-INF/views/masters/medicalProductForm.jsp"></jsp:include></p>
 				</div>
                <div>
                  <p>2</p>
                </div>
              
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