<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/tabs/jquery.ui.all.css">
	<script src="js/tabs/jquery1.7.2.js"></script>
	<script src="js/tabs/jquery.ui.core.js"></script>
	<script src="js/tabs/jquery.ui.widget.js"></script>
	<script src="js/tabs/jquery.ui.tabs.js"></script>
	<link rel="stylesheet" href="css/tabs/demos.css">
	<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	
	$(document).ready(function() {
		$(function() {
			$( "#tabs-1" ).tabs();
			var val=0;
			var status=0;
		
			 $.post('getAccountReguests.html', {owner:val,flag:status}, function(result){
       		  if(result!=null){
       			//  alert(result);
                // $('.accountreq').html('Account');
       			  $('#tabs-1').html(result);
       		  
       		  }
       	  });
		});
		$('.accountreq').click(function(e){
			var val=0;
			var status=0;
		
			 $.post('getAccountReguests.html', {owner:val,flag:status}, function(result){
       		  if(result!=null){
       	
       			  $('#tabs-1').html(result);
       		  
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
	.notifications1{
	width: 20.2%;
	float: left;
	height: 90%;
	margin-top: 5px;
	margin-left: 5px;
	overflow: hidden;
	font-size: 12px;
	border-right-style: none;
	border: lightgrey 3px solid;
	border-right: none;
	
	/*background-image:url(images/listbackground1.jpg);
	box-shadow: 2px 2px 5px 3px white;*/
	
	}
.notifications2{
	width: 78%;
	float: right;
	height: 90%;
	margin-top: 5px;
	margin-right: 10px;
	
	border-left-style: none;
	border: lightgrey 3px solid;
	/*background-image:url(images/listbackground1.jpg);
	box-shadow: 2px 2px 5px 3px white;*/
	}
	#tabs{
	background: none;
	height: 98%;

	}
	#tabs .topopup{
	text-decoration: blink;
	color: blue;
	font-weight: bolder;
	}
	</style>
</head>
<body>
<div class="notifications1">
<div id="">
<marquee direction="up" scrollamount="3" height="20%" vspace="20px">
	<h3><a href="#">Section 1</a></h3>
	<div>
		<p>Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.</p>
	</div>
	<h3><a href="#">Section 2</a></h3>
	<div>
		<p>Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna. </p>
	</div>
	<h3><a href="#">Section 3</a></h3>
	<div>
		<p>Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui. </p>
		<ul>
			<li>List item one</li>
			<li>List item two</li>
			<li>List item three</li>
		</ul>
	</div>
	<h3><a href="#">Section 4</a></h3>
	<div>
		<p>Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. </p><p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. </p>
	</div></marquee>
</div>
</div>
<div class="notifications2">

<div id="tabs">
	<ul>
		<li><a href="#tabs-1" class="accountreq">Account Requests<c:out value="${userscount}"/></a></li>
		<li><a href="#tabs-2" class="payments">Payments</a></li>
		<li><a href="#tabs-3" class="expaccounts">Expired Acconuts</a></li>
	</ul>
	<div id="tabs-1">
		<p></p>
	</div>
	<div id="tabs-2">
		<p></p>
	</div>
	<div id="tabs-3">
		<p></p>
	</div>
	
</div>

</div>


</body>
</html>