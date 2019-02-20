function doFormValidate(){
	//Form validating
	
	 if($("#piId").val()==""){
		 if($("#sCatId").val()==1){
			// var letters = /^[A-Za-z\s]+$/;//!c.match(letters);
			 if($("#ageName").val()==""){alert("Please choose one registered agency");$("#ageName").focus();return false;}
			 if($("#ageId").val()==""){alert("Some Errors in form filling, Please refresh and try again");return false;}
			 if($("#pName").val()==""){alert("Please choose product from products or enter new product");$("#pName").focus();return false;}
			 //else if($("#pname1").val().){return false;}
			 if($("#brId").val()==0){alert("Please select the branch");$("#brId").focus();return false;}
			 if($("#mFC").val()==""){alert("Please fill the manifacturing company");$("#mFC").focus();return false;}
			 if($("#schD").val()==""){alert("Please fill the schedule drug type");$("#schD").focus();return false;}
			 if($("#batNo").val()==""){alert("Please fill the Product Batch No");$("#batNo").focus();return false;}
			 if($("#sCatId").val()==""){alert("Please choose one category");$("#sCatId").focus();return false;}
			 if($("#noOfS").val()=="" || $("#noOfS").val()=="0"){alert("Please fill the no of sheets");$("#noOfS").focus();return false;}
		//	 else if(isNaN($("#noOfS").val())){alert("Please enter valid no of strips");$("#noOfS").focus();return false;}
			 if($("#qPS").val()=="" || $("#qPS").val()=="0"){alert("Please fill the quantity per sheet");$("#qPS").focus();return false;}
			 if($("#pPS").val()=="" || $("#pPS").val()=="0"){alert("Please fill the one sheet price");$("#pPS").focus();return false;}
			 if($("#pr").val()=="" || $("#pr").val()=="0"){alert("Some problem, please enter manually");$("#pr").removeAttr("readonly").focus();return false;}
//			 if($("#pid1").val()==""){alert("Please fill the product expiry date");$( "#pid1" ).focus();return false;}
			 if($("#dlPPS").val()=="" || $("#dlPPS").val()=="0"){alert("Please fill the one sheet dealer price");$("#dlPPS").focus();return false;}
			 if($("#dlP").val()=="" || $("#dlP").val()=="0"){alert("Some problem please enter dealer price manually");$("#dlP").removeAttr("readonly").focus();return false;}
			 if($("#qntty").val()=="" || $("#qntty").val()=="0"){alert("Some problem, please enter manually");$("#qntty").removeAttr("readonly").focus();return false;}
			 if($("#expD").val()=="" || $("#expD").val()=="0"){alert("Please fill the product expiry date");$("#expD").focus();return false;}
			 
//			 if($("#piid1").val()==""){alert("Please fill the product expiry date");$( "#piid1" ).focus();return false;}			 
		 }else{
			 if($("#brId").val()==0){alert("Please select the branch");$("#brId").focus();return false;}
			 if($("#ageId").val()==""){alert("Some Errors in form filling, Please refresh and try again");return false;}
			 if($("#ageName").val()==""){alert("Please choose one registered agency");$("#ageName").focus();return false;}
			 if($("#pName").val()==""){alert("Please choose product from products or enter new product");$("#pName").focus();return false;}
			 if($("#mFC").val()==""){alert("Please fill the manifacturing company");$("#mFC").focus();return false;}
			 if($("#schD").val()==""){alert("Please fill the schedule drug type");$("#schD").focus();return false;}
			 if($("#batNo").val()==""){alert("Please fill the Product Batch No");$("#batNo").focus();return false;}
			 if($("#sCatId").val()==""){alert("Please choose one category");$("#sCatId").focus();return false;}
			 if($("#pr").val()=="" || $("#pr").val()=="0"){alert("Please fill the price");$("#pr").removeAttr("readonly").focus();return false;}
			 if($("#dlP").val()=="" || $("#dlP").val()=="0"){alert("Please fill the dealer price");$("#dlP").removeAttr("readonly").focus();return false;}
			 if($("#qntty").val()=="" || $("#qntty").val()=="0"){alert("Please fill the product quantity");$("#qntty").removeAttr("readonly").focus();return false;}	 
		 }
 
	 }else{
		 if($("#sCatId").val()==1){
			 if($("#brId").val()==0){alert("Please select the branch");$("#brId").focus();return false;}
			 if($("#pName").val()==""){alert("Please choose product from products or enter new product");$("#pName").focus();return false;}
			 if($("#mFC").val()==""){alert("Please fill the manifacturing company");$("#mFC").focus();return false;}
			 if($("#schD").val()==""){alert("Please fill the schedule drug type");$("#schD").focus();return false;}
			 if($("#batNo").val()==""){alert("Please fill the Product Batch No");$("#batNo").focus();return false;}
			 if($("#sCatId").val()==""){alert("Please choose one category");$("#sCatId").focus();return false;}
			// if($("#expirydate1").val()==""){alert("Please fill the product expiry date");$("#expirydate1").focus();return false;}
			 if($("#noOfS").val()==""){alert("Please fill the no of sheets");$("#noOfS").focus();return false;}
			 if($("#qPS").val()==""){alert("Please fill the quantity per sheet");$("#qPS").focus();return false;}
			 if($("#pPS").val()==""){alert("Please fill the one sheet price");$("#pPS").focus();return false;}
			 if($("#pr").val()=="" || $("#pr").val()=="0"){alert("Some problem, please enter manually");$("#pr").removeAttr("readonly").focus();return false;}
//			 if($("#pid1").val()==""){alert("Please fill the product expiry date");$( "#pid1" ).focus();return false;}
			 if($("#dlPPS").val()=="" || $("#dlPPS").val()=="0"){alert("Some problem, please enter manually");$("#dlPPS").focus();return false;}
			 if($("#dlP").val()=="" || $("#dlP").val()=="0"){alert("Please fill the one sheet dealer price");$("#dlP").removeAttr("readonly").focus();return false;}
			 if($("#qntty").val()=="" || $("#qntty").val()=="0"){alert("Some problem, please enter manually");$("#qntty").removeAttr("readonly").focus();return false;}  
		 }else{
			 if($("#brId").val()==0){alert("Please select the branch");$("#brId").focus();return false;}
			 if($("#pName").val()==""){alert("Please choose product from products or enter new product");$("#pName").focus();return false;}
			 if($("#mFC").val()==""){alert("Please fill the manifacturing company");$("#mFC").focus();return false;}
			 if($("#schD").val()==""){alert("Please fill the schedule drug type");$("#schD").focus();return false;}
			 if($("#batNo").val()==""){alert("Please fill the Product Batch No");$("#batNo").focus();return false;}
			 if($("#sCatId").val()==""){alert("Please choose one category");$("#sCatId").focus();return false;}
			 if($("#pr").val()=="" || $("#pr").val()=="0"){alert("Some problem, please enter manually");$("#pr").removeAttr("readonly").focus();return false;}
			 if($("#dlP").val()=="" || $("#dlP").val()=="0"){alert("Some problem please enter manually");$("#dlP").removeAttr("readonly").focus();return false;}
			 if($("#qntty").val()=="" || $("#qntty").val()=="0"){alert("Please fill the product quantity");$("#qntty").removeAttr("readonly").focus();return false;}
			
		 }
		 
	 }
	 return true;
	 

}
$(document).ready(function () {
	 
	  $(".number").keypress(function (e) {
	//	  var myArray= $(this).attr('name').split(".");
   //	$(".errmsg").html("");
	
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	     //   $("#"+myArray.pop()).html("Digits Only");
	        $(this).css("background-color", "rgb(245, 203, 203)");
            $(this).css("border", "1px solid #FF0000");    
            $(this).attr("placeholder", "Enter only numbers");
	               return false;
	    }else{
	    	 $(this).css("background-color", "#FFF");
	            $(this).css("border", "1px solid gray");    
	            $(this).removeAttr( "placeholder");
	    }
	   });
	  
	
	  $(".double").keydown(function (event) {


	        if (event.shiftKey == true) {
	            event.preventDefault();
	           
	        }else{
		    	 
			    	 $(this).css("background-color", "#FFF");
			            $(this).css("border", "1px solid gray");    
			            $(this).removeAttr( "placeholder");
			    }

	        if ((event.keyCode >= 48 && event.keyCode <= 57) || 
	            (event.keyCode >= 96 && event.keyCode <= 105) || 
	            event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 ||
	            event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 110 || event.keyCode == 190) {
	        	
	 	        }
	        	 
	        else {
	            event.preventDefault();	       
	            $(this).css("background-color", "rgb(245, 203, 203)");
	             $(this).css("border", "1px solid #FF0000");    
	             $(this).attr("placeholder", "Enter only numericals");
	        } 
    

	        if($(this).val().indexOf('.') !== -1 && event.keyCode == 110 || $(this).val().indexOf('.') !== -1 && event.keyCode == 190){
	            event.preventDefault(); 
	            
	        }
	      
	      
	    });
	  
	
	});


