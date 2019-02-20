<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE> Mobile | Tablet | Desktop </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

  
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		
		
	
		
		<script type="text/javascript" src="js/jquery.1.10.2.min.js"></script>
		
	
<link rel="stylesheet" type="text/css" href="css/menu/reset.css">
    <link rel="stylesheet" type="text/css" href="css/menu/slimmenu.css">
	<script src="js/menu/jquery.slimmenu.js"></script>
<style type="text/css">

  body .slimmenu{
            font-family: 'Lucida Sans Unicode', 'Lucida Console', sans-serif;
            padding: 0;
        }
      .slimmenu a, a:active { text-decoration: none }

html{
	
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
       
        width: 1290px;
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
        background-color: #3C873C;
        width: 1280px;
        min-height: 25px;
		margin:auto;
    }
	  .slimmenu, .loginform{
        display: inline-block;
        vertical-align: top;
    }
    .content-wrapper {
        width: 1270px;
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
        height: 320px;
    }
    .content-wrapper .col2 {
        width: 987px;
        min-height: 320px;
        
    }
    .content-wrapper .col3 {
        width: 1275px;
        border: 1px solid #ffffff;
     /*   background-color: #ffffff;   */ 
        height: 80px;
        margin: 10px 0;
    }
    .footer {
        width: 1290px;;
       padding-left:10px;
	  padding-top:10px;
        height: 40px;
		 color: #f4f4f9;
    }
    .footer p {
		 
		 width: 1280px;
		  color: #f4f4f9;
        height: 30px;
        line-height: 30px;
    }
	
 /* Smartphones (portrait) ----------- */  
@media only screen   
and (max-width:750px) {  

        #container {
            width: 100%;
			border-radius: 3px; 
        }
        .banner {
            width: 100%;
			
            height: 50px;
			
			
        }
        .banner p {
			padding-left:0;
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
			height: auto;
        }
        .content-wrapper .col2 {
            width: 100%;
            margin: 20px 0 0;
			min-height:200px;
			overflow-x: auto;
			overflow-y:visible;
        }
        .content-wrapper .col3 {
            width: 100%;
            margin: 20px 0 0;
        }
        .footer {
            width: 98%;
        }
		.footer p{
			width: 100%;
            
        }
    }
	
	@media only screen and (min-width:750px) and (max-width: 980px) {


  #container {
       
        width:750px;    
        border-radius: 3px; 
		margin:auto;   
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
      /*  border: 1px solid #464646;*/
        background-color: #ffffff;        
    }
    .content-wrapper .col1 {
        width: 158px;
        height: 320px;
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
<!--table-->


<!--  form -->
<style type="text/css">
.wrapper {
    position: relative;
    background-color: #EFF0F0;
    border: 1px solid #E0E0E0;
    width: 240px;
    padding: 5px;
    font-family:calibri;
    font-size: 15px;
    color: #736F69;
    border-radius: 3px;
	margin:auto;
	
}
.wrapper div {
    padding-bottom:6px;
}
.wrapper label {
    width:80px;
    background-color: red;
    display: inline-block;
}
.wrapper input[type=text] {
    border: 1px solid #A0A0A0;
    width: 140px;
    padding: 0 8px 0 6px;
    height:20px;
    font-family:calibri;
    font-size: 15px;
}
.wrapper textarea {
    border: 1px solid #A0A0A0;
    padding: 0 8px 0 6px;
    width: 180px;
    font-family:calibri;
}
.wrapper .required {
    position: relative;
    display: inline-block;
    color: #E3001B;
    top: 1px;
    width: 10px;
    vertical-align: top;
    right: 10px;

}
.wrapper input[type=submit] {
    border: 0;
    background-color: #888888;
    border-radius: 5px;
    color: #FFFFFF;
    cursor: pointer;
    padding: 5px;
}
.wrapper .submit {
    text-align: right;
    width: 220px;
}

@media (min-width:750px) and (max-width: 980px) {
	 
    .wrapper {
         width: 140px;
		 position:static;
    }
    .wrapper label {
        width:80px;
        display: block;
    }
	.wrapper input[type=text] {
		width:90%;
		}
    .wrapper textarea {
        width: 90%;
		height:50px;
		resize:none;
    }
		.wrapper .required {
    position: static;

}
    .wrapper .submit {
        width: 130px;
    }
}
	
	
@media (max-width:750px) {
	#container{
  background-color: #3C873C;
       border: 1px solid #3C873C;
	}
    .wrapper {
         width: 95%;
		 position:static;
    }
    .wrapper label {
        width:30%;
        display: block;
    }
    .wrapper textarea {
        width:80%;
		height:10%;
		color: red;
    }
    .wrapper .submit {
        width: 80%;
    }
	.wrapper .required {
    position: static;
    


}
}
</style>
</HEAD>

<BODY bgcolor="#333333">
<div id="container">
   <div class="banner"><p><img src="images/mainlogo.jpg" class="mainlogo" alt=""/><img src="images/applogo.jpg" class="applogo"  alt=""/></p>
   </div>
   <div class="nav"><p>
   <script src="js/menu/jquery.slimmenu.js"></script>
<script src="js/menu/easing.min.js"></script>
   <ul class="slimmenu">
    <li>
        <a href="#">Slim Menu 1</a>
        <ul>
            <li><a href="#">Slim Menu 1.1</a></li>
            <li><a href="#">Slim Menu 1.2</a></li>
            <li><a href="#">Slim Menu 1.3</a></li>
            <li><a href="#">Slim Menu 1.4</a></li>
            <li><a href="#">Slim Menu 1.5</a></li>
            <li><a href="#">Slim Menu 1.6</a></li>
        </ul>
    </li>
    <li><a href="#">Slim Menu 2</a>
      <ul>
            <li>
                <a href="#">Slim Menu 2.1</a>
                <ul>
                    <li><a href="#">Slim Menu 2.1.1</a></li>
                    <li>
                        <a href="#">Slim Menu 2.1.2</a>
                      <!--  <ul>
                            <li><a href="#">Slim Menu 1.1.2.1</a></li>
                            <li><a href="#">Slim Menu 1.1.2.2</a></li>
                        </ul>  -->
                    </li>
                </ul>
            </li>
            <li><a href="#">Slim Menu 2.2</a></li>
        </ul>
    
    </li>
    <li>
        <a href="#">Slim Menu 3</a>
        <ul>
            <li>
                <a href="#">Slim Menu 3.1</a>
                <ul>
                    <li><a href="#">Slim Menu 3.1.1</a></li>
                    <li><a href="#">Slim Menu 3.1.2</a></li>
                </ul>
            </li>
            <li><a href="#">Slim Menu 3.2</a></li>
        </ul>
    </li>
    <li><a href="#">Slim Menu 4</a>
        <ul>
            <li>
                <a href="#">Slim Menu 4.1</a>
                <ul>
                    <li><a href="#">Slim Menu 4.1.1</a></li>
                    <li>
                        <a href="#">Slim Menu 4.1.2</a>
                      <!--  <ul>
                            <li><a href="#">Slim Menu 1.1.2.1</a></li>
                            <li><a href="#">Slim Menu 1.1.2.2</a></li>
                        </ul>  -->
                    </li>
                </ul>
            </li>
           
        </ul>
    </li>
</ul>

<script>
$('ul.slimmenu').slimmenu(
{
    resizeWidth: '964',
    collapserTitle: 'Menu',
    easingEffect:'easeInOutQuint',
    animSpeed:'medium',
    indentChildren: true,
    childrenIndenter: '&raquo;'
});
</script>

   </p></div>
   <div class="content-wrapper">
      <div class="col1"><p>User Registration Form</p>
      
      <div class="wrapper">
<div><label>Name:</label><input type="text" name="fullname" value="" /><span class="required">*</span></div>
<div><label>Email:</label><input type="text" name="email" value="" /><span class="required">*</span></div>
<div><label>Phone:</label><input type="text" name="phone" value="" /><span class="required">*</span></div>
<div><label>Comments:</label></div>
<div><textarea name="comments"></textarea><span class="required">*</span></div>
<div><span style="color: #E3001B;">*</span> Required fields</div>
<div class="submit"><input type="submit" value="Submit" /></div>
</div>
      
      </div>
      <div class="col2"><p>Table</p>
      </div>
      <div class="col3"><p>Column Three</p></div>
   </div>
   <div class="footer"><p>&copy;Rely Services 2013</p></div>
</div>
</BODY>
</HTML>
