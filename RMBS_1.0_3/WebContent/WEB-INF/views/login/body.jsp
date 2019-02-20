<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">
<!-- 	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> -->
 <script src="js/tabs/jquery1.7.2.js"></script> 
	<script src="js/tabs/easyResponsiveTabs.js"></script>

	<script>
	
	$(document).ready(function() {
	
		$('.accountreq').click(function(e){
			var val=0;
			var status=0;
		
			 $.post('getAccountReguests.html', {owner:val,flag:status}, function(result){
       		  if(result!=null){
       	
       			  $('#accountreq').html(result);
       		  
       		  }
       	  });
			 
			 
			
		});
		$('.payments').click(function(e){
			 $.post('updateOwnerByAdmin.html', {owner:val,flag:status}, function(result){
       		  if(result!=null){
       		  $('#active'+val+'').html(result.active);
       		  }
       	  });
			
		});
		$('.expaccounts').click(function(e){
			alert("expaccounts");
		});
		
	});
	</script>

	 <style type="text/css">
        .demo {
            width: 100%;
            margin: auto;
        }
      
      
        @media only screen and (max-width: 780px) {
        .demo {
                margin: 0;
                width: 100%;
         }
      
        }
        #tabInfo {
            display: none;
        }
        .optional{
        display: none;
        }
 
    </style>
	
	
</head>
<body>
 
          
     
        
       
        <!--vertical Tabs-->
        <div id="verticalTab">
            <ul class="resp-tabs-list">
                <li><a class=".accountreq">Home</a></li>
                <li><a>About Us</a></li>
                <li><a>Products</a></li>
                <li><a>Careers</a></li>
                <li><a>Contact Us</a></li>
            </ul>
            <div class="resp-tabs-container">
                <div id="accountreq" class="content">
                  <p> <div id="homediv"><jsp:include page="/WEB-INF/views/website/home.jsp"></jsp:include></div></p>
              </div>
                <div>
                    <p><div id="aboutusdiv" class="content"><jsp:include page="/WEB-INF/views/website/aboutUs.jsp"></jsp:include></div></p>
                   
                </div>
                <div>
                    <p><div id="productsdiv" class="content"><jsp:include page="/WEB-INF/views/website/products.jsp"></jsp:include></div></p>
                </div>
                <div>
                    <p><div id="servicesdiv" class="content"><jsp:include page="/WEB-INF/views/website/careers.jsp"></jsp:include></div></p>
                </div>
                <div>
                    <p><div id="contactusdiv" class="content"><jsp:include page="/WEB-INF/views/website/contactUs.jsp"></jsp:include></div></p>    
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