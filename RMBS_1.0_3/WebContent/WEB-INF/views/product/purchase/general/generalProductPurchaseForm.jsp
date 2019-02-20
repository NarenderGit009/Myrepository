<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/masters/purchaseForm.css" />

<link rel="stylesheet" href="css/tabs/easy-responsive-tabs.css">
<script src="js/tabs/easyResponsiveTabs.js"></script>
	<script type="text/javascript">
		function loadMedicalPurchaseForm() {
			alert(medical_form);
			$.get("openPurchaseEntryForm.html?task_type=sub&task_form_type=medical", function(medical_form){
				$(".medical_form_container").html(medical_form);				
			});
		}
		function loadGeneralForm() {
			alert(general_form);
			alert("general form calling");
			$.get("openPurchaseEntryForm.html?task_type=sub&task_form_type=medical", function(general_form){
				$(".general_form_container").html(general_form);
			});
		}
	</script>
</head>
<body>
<div id="horizontalTab">
	<ul class="resp-tabs-list">
		<li onclick="loadMedicalForm();">Medical Product Purchase Form</li>
		<li onclick="loadGeneralForm();">General Product Purchase Form</li>
	</ul>
	<div class="resp-tabs-container">
		<div class="medical_form_container">
			<P><jsp:include
					page="/WEB-INF/views/product/purchase/general/generalPurchaseForm.jsp"></jsp:include>
		</div>
		<div class="general_form_container">
			<p></p>
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