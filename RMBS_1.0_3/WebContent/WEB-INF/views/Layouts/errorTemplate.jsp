<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<html id="html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


  <title><tiles:insertAttribute name="title" ignore="true" /></title>

 <style>
#html { height: 97%;}
#body {
    height:100%;
    min-height: 100%;
    background: black;
    /*color: #FFFFFF;*/
    position:relative;
    color: #000;
    display: none;
    z-index: -1;
}
#header {
    height:70px;
    width:100%;
    top:0px;
    left:0px;
   
    position:absolute;
}
#footer {
    height:30px;
    width:100%;
    bottom:0px;
    left:0px;
  
    position:absolute;
    color: grey;
 /*     border: grey 1px solid;
    border-bottom: none;
    border-left: none;
    border-right: none;*/
     text-align:center
    
}
#content {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    height:100%;
	
    padding-top: 70px;
    padding-left: 0px;
    background-color: white;
}
#contentmenu {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    height: 36px;
	width:100%;
    overflow: hidden;
    
   
 
}
#contentbody {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    width:100%;
	height:87.3%;
    /*padding: 70px 20px;*/
   
    overflow: auto;
    overflow-x: hidden;
    color: #000;

}
</style>
<script type="text/javascript" src="js/jquery1.7.2.js"></script>
<script type="text/javascript">
function active(){
	
	$('#body').show();	

}

</script>
<script type="text/javascript">
function active(){
	
	$('#body').show();	
	window.history.forward(1);
}
$(document).ready(function() {
    noBack();
});

function noBack() {
   window.history.forward(1);
   }
</script>
</head>
<body id="body" onload="active();">

    <div id="header"><tiles:insertAttribute name="header" /></div>
  
    <div id="content">
	
	<div id="contentbody"><tiles:insertAttribute name="body" /></div>		
    </div>
    <div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>