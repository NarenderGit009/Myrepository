/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
     
     //------------------------validation---------------------        
  /*   function validate(){
      var phno1=$('#phno1').val();
      if($('#init').val()== -1){alert("you should select intial from drop down");$('#init').focus();return false;}
      if($('#fname').val()== ""){alert("Please enter first name");$('#fname').focus();return false;}
      if($('#lname').val()== ""){alert("Please enter last name");$('#lname').focus();return false;}
      if($('#uname').val()== ""){alert("Please enter user name to login");$('#uname').focus();return false;}
      if($('#sname').val()== ""){alert("Please enter your shop name");$('#sname').focus();return false;}
      if($('#compadd').val()== ""){alert("Please enter your shop/residence address");$('#compadd').focus();return false;}
      if($('#sex').val()== ""){alert("Please enter your gender type");$('#sex').focus();return false;}
      if($('#dob').val()== ""){alert("Please enter your date of birth");$('#dob').focus();return false;}
      if($('#phno1').val()== ""){alert("Please enter your mobile number");$('#phno1').focus();return false;}
      else{if(phno1.length < 10){alert(" Your Mobile Number must between 10 to 15 Integers");$('#phno1').focus();return false;}}
      if($('#pmail').val()== ""){alert("Please enter your mail id for future refference");$('#pmail').focus();return false;}
   
      return true;
     }*/
     //-------------------------------------------------------------
    

//--------------------------User id--------
       function userid_validation(uid,mx,my)  
       {  
    	   var letters = /^[A-Za-z0-9]+$/;
    	//   alert(uid.value);
       var uid_len = uid.value.length;  
     //  alert(uid_len);
       
       for (var i=0;i<uid_len;i++)
       {
       var d=uid.value.charAt(i);
       if(d==" "){
    	//   alert(i+"space");
       // count+=1;   
      //  a = a.substring(0,i);
    	   alert("User Id should not be contain spaces");  
    	   var a=uid.value;
    	   for (var i=0;i<uid_len;i++)
           {
    		   var c=a.charAt(i);
    		   if(c==" "){
    		   a = a.substring(0,i);
    		   }
           }
    	   $('#uname').val(a);
    	   $('#uname').focus();
    	   return false;
          }
      }
       
       if (uid_len == 0 || uid_len >= my || uid_len < mx)  
       {  
       alert("User Id should not be empty / length be between "+mx+" to "+my);  
       $("#uname").focus();
      
       return false;  
       }  
       if(!uid.value.match(letters)) 
       {
           if(uid.value.length > 0){
        alert('Special characters not allowed');
           }
           
        $('#uname').val("").focus();
       
         return true;  
        };
       return true;  
       }  
   
 
   //------------------------------error color disable------------
   function disableerror(val){
	  
	  //alert(val);
	   $("'#"+val+"'").css("borderColor","white");
	   $("'#"+val+"'").focus();
	   
   }

   $(document).ready(function() {
	   
	  
	   $('#registerform1').submit(function(){
		   
		  
		      if($('#init').val()== -1){alert("you should select intial from drop down");$('#init').focus().css("borderColor","red");return false;}
		      if($('#fname').val()== ""){alert("Please enter first name");$('#fname').focus().css("borderColor","red");return false;}
		      if($('#lname').val()== ""){alert("Please enter last name");$('#lname').focus().css("borderColor","red");return false;}
		      if($('#uname').val()== ""){alert("Please enter user name to login");$('#uname').focus().css("borderColor","red");return false;}
		      if($('#pwd').val()== ""){alert("Please enter your password");$('#pwd').focus().css("borderColor","red");return false;}
		      else  if($('#cpwd').val()== ""){alert("Please confirm your entered password");$('#cpwd').focus().css("borderColor","red");return false;}
			  if($('#sex').val()== ""){alert("Please enter your gender type");$('#sex').focus().css("borderColor","red");return false;}
			  if($('#dob').val()== ""){alert("Please enter your date of birth");$('#dob').focus().css("borderColor","red");return false;}
		      if($('#phno1').val()== ""){alert("Please enter your mobile number");$('#phno1').focus().css("borderColor","red");return false;}
		      else{if($('#phno1').val().length < 10 || $('#phno1').val().length > 15){alert(" Your Mobile Number must between 10 to 15 Integers");$('#phno1').focus().css("borderColor","red");return false;}}
		      if($('#pmail').val()== ""){alert("Please enter your mail id for future refference");$('#pmail').focus().css("borderColor","red");return false;}
		      if($('#sname').val()== ""){
		    	  alert("Please enter your shop name");
		    	  $('#sname').focus().css("borderColor","red");
                $('.sname').show();
				$('.tin').show();
				$('.sadd').show();
		    	  return false;}
		      if($('#add').val()== ""){alert("Please enter your shop/residence address");$('#add').focus().css("borderColor","red");return false;}
		       
		   
		$(this).find('input:text').each(function(){
        	
	        alert($.trim($(this).val()));
	              $(this).val($.trim($(this).val()));
	        });
	  });
	   
	   $('#init').change(function(e) {
	     var sex;
	       if(this.value == "Mr"){sex="Male";}
	       else if(this.value=="Mrs"){sex="Female";}
	       else if(this.value=="Other"){sex="Other";}
	       else{sex="";}
	       $('#sex').val(sex);
	   });
	   
	   $('#aname').change(function(e) {
			var aname=$('#aname').val();
			var id=$('#createdby').val();
			var data=null;
			$.post('validateagency.html?agency='+aname+'&id='+id, data, function(result){	
				//alert(result);
				if(result!="E"){
					$('#msg').html(""+result+" agency already existed").css("color","white").css("font-weight","bold");
					$('#aname').val("").focus();
				}else{
					
					$('#add').focus();
					$('#msg').html("");
				}
			});
			
		});
	   
	   $('#cpwd').change(function(e) {  
	   var pass1 = $("#pwd").val();
	    var pass2 = $("#cpwd").val();
	    var ok = true;
	    if (pass1 != pass2) {
	        alert("Passwords Do not match. Try again");
	        $("#pwd").css("borderColor","red");
	        $("#cpwd").css("borderColor","red");
	        $("#cpwd").val("");
	        
	        ok = false;
	    }
	    else {
	        alert("Passwords Match!!!");
	        $("#pwd").css("borderColor","white");
	        $("#cpwd").css("borderColor","white");
	        return true;
	    }
	    return ok;
	
   });
	   
	   $('.email').change(function(e) {  
		   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
           //   var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
          if (!reg.test(this.value)) 
       {
           alert('Invalid Email Address');
           var a ="";
       
       	$('#pmail').val(a);
       	$('#pmail').focus();
     
           return false;
       }

       return true;

		
	   });
			
			$('.names').keyup(function(e) {

		        var letters = /^[A-Za-z\s]+$/;
		        var c=this.value;
		         var v=c.charAt(c.length - 1);
		         if(v==" " && c.length > 1 ){
		              if(c.charAt(c.length - 1)==" " && c.charAt(c.length - 2)==" "){
		             	 var count=0;
		             //	 var formatted=c;
		             	 for (var i=0;i<c.length;i++){
		  	                var d1=c.charAt(c.length - i+1);
		  	              //  alert("1st"+d1);
		  	                var d2=c.charAt(c.length - i+2);
		  	              // alert("2nd"+d2);
		  	                if(d1==" " && d2==" "){
		  	                //	formatted = c.substring(0,i); 
		  	                count+=1;
		  	                 }
		  	               }alert(count);
		  	             //  alert("***"+c.substring(0, c.length - count)+"******");
		  	              $(this).val(c.substring(0, c.length - count)); 
		              
		                 return true;
		               }
		          }else{
		              if(v==" " && c.length == 1 ){
		               c = c.substring(0, c.length - 1);
		               $(this).val(c.substring(0, c.length - 1)); 
		               
		               return false;
		                }
		           }
		        if(!c.match(letters)) 
		       {
		           if(c.length > 0){
		        alert('Special characters not allowed');
		           }
		           
		        $(this).val("");
		       
		         return true;  
		        };
		        return true;

		});
			$('.shopnames').keyup(function(e) {

		        var letters = /^[A-Za-z0-9\s]+$/;
		        var c=this.value;
		         var v=c.charAt(c.length - 1);
		         if(v==" " && c.length > 1 ){
		              if(c.charAt(c.length - 1)==" " && c.charAt(c.length - 2)==" "){
		             	 var count=0;
		             //	 var formatted=c;
		             	 for (var i=0;i<c.length;i++){
		  	                var d1=c.charAt(c.length - i+1);
		  	              //  alert("1st"+d1);
		  	                var d2=c.charAt(c.length - i+2);
		  	              // alert("2nd"+d2);
		  	                if(d1==" " && d2==" "){
		  	                //	formatted = c.substring(0,i); 
		  	                count+=1;
		  	                 }
		  	               }alert(count);
		  	             //  alert("***"+c.substring(0, c.length - count)+"******");
		  	              $(this).val(c.substring(0, c.length - count)); 
		              
		                 return true;
		               }
		          }else{
		              if(v==" " && c.length == 1 ){
		               c = c.substring(0, c.length - 1);
		               $(this).val(c.substring(0, c.length - 1)); 
		               
		               return false;
		                }
		           }
		        if(!c.match(letters)) 
		       {
		           if(c.length > 0){
		        alert('Special characters not allowed');
		           }
		           
		        $(this).val("");
		       
		         return true;  
		        };
		        return true;

		});

		/*	$('.phno').change(function(e) {
				var a= this.value;
				if(isNaN(a) || a.lentgh<10 || a.length>15){
					alert("enter valid phno");
				//	$(this).val("").css("background-color", "orange").focus();
					$(this).val("").focus();
				}
			});*/
			$('.phno').change(function(e){
				var phno= this.value;
				if(isNaN(phno) || 15<phno.length || phno.length<10){
					
					  $(this).css("background-color", "rgb(245, 203, 203)");
			          $(this).css("border", "1px solid #FF0000");    
			          $(this).attr("placeholder", "Digits length b/w 10-15");
				           
						$(this).val("").focus();
						return false;
						
				}else{
					$(this).css("background-color", "#FFF");
			        $(this).css("border", "1px solid gray");    
			        $(this).removeAttr( "placeholder");
			       
				}
			});
				
			
			
			$('#shopdetails').click(function(e) {
				
				$('.sname').toggle();
			$('.tin').toggle();
			$('.sadd').toggle();
			
			});
			
   });