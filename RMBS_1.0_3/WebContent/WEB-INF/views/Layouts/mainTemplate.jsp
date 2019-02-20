<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<html id="html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


  <title><tiles:insertAttribute name="title" ignore="true" /></title>

<style type="text/css">

  body .slimmenu{
            font-family: 'Lucida Sans Unicode', 'Lucida Console', sans-serif;
            padding: 0;
        }
      .slimmenu a, a:active { text-decoration: none }

#html{
	padding-top: 1%;
	padding-bottom: 1%;
	width:98%;
	margin:auto;
	}
    #container {
    
        background-color: #f4f4f9;
       border: 1px solid #f4f4f9;
        width: 1300px;       
        border-radius: 3px; 
        
		margin:auto;   
    }
    #container p {
        font-family:calibri;
        font-size: 15px;
        
        text-align: center;
        margin:0;
    }
    .banner {
       
        width: 1250px;
        height: 70px;
		text-align: center;
		padding-left:10px;
		padding-top:7px;
    }
    .banner p {
		background-color: #FFFFFF;
		width: 1280px;
        height: 70px;
        line-height: 70px;
    }
	.banner p img{
		max-height:  100%;
		}
    .banner p .mainlogo{
		float:left;
		}
	.banner p .applogo{
		float:right;
		}
    .nav {
         background: url("images/green.png") repeat scroll 0 0 transparent;
        width: 1280px;
        min-height: 25px;
		margin:auto;
    }
	  .slimmenu, .loginform{
        display: inline-block;
        vertical-align: top;
    }
    .content-wrapper {
        width: 1280px;
        padding: 10px;
		margin:auto;
		background-color:#f4f4f9;
    }
    .content-wrapper .col1, .content-wrapper .col2 {
        display: inline-block;
        vertical-align: top;
        border: 1px solid #ffffff;
     /*   background-color: #ffffff;        */
    }
    .content-wrapper .col1 {
        width: 275px;
        min-height: 300px;
    }
    .content-wrapper .col2 {
        width: 987px;
        min-height: 300px;
        
    }
    .content-wrapper .col3 {
        width: 1275px;
        border: 1px solid #ffffff;
     /*   background-color: #ffffff;   */ 
        min-height: 50px;
        margin: 10px 0;
    }
    .footer {
        width: 1290px;;
       padding-left:10px;
	  padding-top:10px;
        height: 40px;
        color: #fff;
		 
    }
    .footer p {
		 
		 width: 1280px;
		background: url("images/green.png") repeat scroll 0 0 transparent;
        height: 30px;
        line-height: 30px;
    }
	
 /* Smartphones (portrait) ----------- */  
@media only screen   
and (max-width:750px) {  

        #container {
            width: 100%;
			border-radius: 3px; 
			height: auto;
			margin: auto;
        }
        .banner {
            width: 98%;
			
            height: 50px;
			
			
        }
        .banner p {
			
			width: 96%;
            height: 50px;
            line-height: 80px;
        }
			.banner p img{
		max-height:  80%;
		}
   
        .nav {
            width: 98%;
			height: auto;
			margin: auto;
        }
        .content-wrapper {
            width: 93%;
        }
        .content-wrapper .col1, .content-wrapper .col2 {
            display: block;
        }
        .content-wrapper .col1 {
            width: 100%;
            min-height: 10px;
			
        }
        .content-wrapper .col2 {
            width: 100%;
            margin: 20px 0 0;
           min-height: 700px;
			
        }
        .content-wrapper .col3 {
            width: 100%;
            margin: 20px 0 0;
            min-height: 50px;
        }
        .footer {
            width: 98%;
        }
		.footer p{
			width: 96%;
            
        }
        
    }
	
	@media only screen and (min-width:750px) and (max-width: 980px) {


  #container {
       
        width:750px;    
        border-radius: 3px; 
		margin:auto;
		height: auto;   
    }
  
    .banner {
        background-color: #FFFFFF;
        width: 720px;
		margin-top: 5px;
		margin-left: 10px;
        height: 70px;
		text-align:center;
    }
    .banner p {
		
		width: 700px;
        height: 70px;
        line-height: 70px;
    }
    .nav {
       
        width: 730px;
        min-height: 25px;
    }
    .content-wrapper {
        width: 720px;
        
		margin:auto;
    }
    .content-wrapper .col1, .content-wrapper .col2 {
        display: inline-block;
        vertical-align: top;
      /*  border: 1px solid #464646;
        background-color: #ffffff;    */    
    }
    .content-wrapper .col1 {
        width: 158px;
        min-height: 320px;
    }
    .content-wrapper .col2 {
        width: 550px;
        min-height: 320px;
        
    }
    .content-wrapper .col3 {
        width: 728px;
     /*   border: 1px solid #464646;*/
        background-color: #ffffff;    
        height: 80px;
        margin: 10px 0;
    }
    .footer {
        width: 730px;
        color: #f4f4f9;
		
        height: 40px;
    }
    .footer p {
		width: 730px;
		color: #f4f4f9;
        height: 30px;
        line-height: 30px;
    }
}
</style>
<script type="text/javascript" src="js/jquery1.7.2.js"></script>
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
<body id="body" onload="active();" bgcolor="#333333">
<div id="container">
	 <div class="banner">
	 <p>
	 <img src="images/mainlogo.jpg" class="mainlogo" alt="Rely Services"/>
	 <img src="images/applogo.jpg" class="applogo"  alt="RMBS"/>
	 </p>
   </div>
   <div class="nav"><p><tiles:insertAttribute name="menu" /></p></div>
   <div class="content-wrapper">
     <div class="col1"><p><tiles:insertAttribute name="notificatonContent"/></p></div>
      <div class="col2"><p><tiles:insertAttribute name="body"/></p></div>
      <div class="col3"><p>Column Three</p></div>
    </div>
       <div class="footer"><p>&copy;Rely Services 2013</p></div>
   </div>
   
    

</body>
</html>