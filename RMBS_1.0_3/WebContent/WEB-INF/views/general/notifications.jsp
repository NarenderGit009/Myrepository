<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">
	<script src="js/jquery.1.10.2.min.js"></script>
	<script src="js/tabs/easyResponsiveTabs.js"></script>

	<script>
	//${sessionScope.user.id}
	$(document).ready(function() {
		$(function() {
			
			var val=0;
			var status=0;
		
			 $.post('loadAccountReguests.html', {owner:val,flag:status}, function(result){
       		  if(result!=null){
       			//  alert(result);
                // $('.accountreq').html('Account');
              //  alert(result);
       			  $('#accountreq').html(result);
       		  
       		  }
       	  });
		});
		/*	$('.accountreq').click(function(e){
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
		});*/
		
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
<body onload="">
 
          
     
        
       
        <!--vertical Tabs-->
        <div id="verticalTab">
            <ul class="resp-tabs-list">
                <li><a class=".accountreq">Account Requests</a></li>
                <li><a>Payments</a></li>
                <li><a>Offers</a></li>
                <li><a>Mails</a></li>
                <li><a>Messages</a></li>
            </ul>
            <div class="resp-tabs-container">
                <div id="accountreq">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nibh urna, euismod ut ornare non, volutpat vel tortor. Integer laoreet placerat suscipit. Sed sodales scelerisque commodo. Nam porta cursus lectus. Proin nunc erat, gravida a facilisis quis, ornare id lectus. Proin consectetur nibh quis urna gravida mollis.</p>
                </div>
                <div>
                    <p>Payments</p>
                   
                </div>
                <div>
                    <p>Offers</p>
                </div>
                <div>
                    <p>Mails</p>
                </div>
                <div>
                    <p>Messages</p>    
                </div>
            </div>
        </div>
     
   <script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion           
            width: 'auto', //auto or any width like 600px
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