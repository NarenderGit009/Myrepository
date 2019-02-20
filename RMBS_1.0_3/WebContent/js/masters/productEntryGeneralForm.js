
	$(function() {
		$( "#expirydate0" ).datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true
		});
	});
	

		 function getGeneralProductDetails(val)
		  {
		  //alert(val); $.trim(str)
		  var text=$("#pname0").val();
		  var type=$("#category0").val();
		  if(text!=""){
		  var data=val;
		  $.post('getProduct.html?pid='+val+"&flag="+type, data, function(result){
		  	//alert(result.mfcompany);
			 $("#mfcompany0").val(result.mfcompany);
		   
		  
			        if($("#batchNo0").val()!=""){
		   	    	        $('#price0').focus();
		   	           }else{
		   	    	        $('#batchNo0').focus(); 
		   	          }
			   
			    	    
			     
		      });
		  }
		  }
		  function validateGeneralProductBatchNo(val,user)
		  {
			  //alert(val);
		  var data=$("#batchNo"+val+"").val();
		  var type=$("#category0").val();
		 if(data!=""){
		   $.post('validateBatchNo.html?batchNo='+data+'&uid='+user+"&flag="+type, data, function(result){
			//alert(result.mfcompany);
			if(result.batchNo!==null){
				$("#piid0").val(result.pinvid);
				$("#price0").val(result.price);
			    $("#dlprice0").val(result.dlprice);
			 
			      if(result.pid!=$("#pid0").val()){
			    	  if($("#pname0").val()!="" && $("#pname0").val()!=result.pname){

				    	   alert("selected batchno not in the choosen product");
			    	  }
			    	   $("#pid0").val(result.pid);
			    	   $("#pname0").val(result.pname);
			    	   $("#mfcompany0").val(result.mfcompany);
			           $("#mfcompany0").attr("disabled", "true");
			           $("#price0").attr("readonly","true");
		    		   $("#dlprice0").attr("readonly","true");
		    		   $("#quantity0").removeAttr("readonly");
		    		   $('#quantity0').focus();
		               $("#submit0").attr("disabled", "true");
		               $("#update0").removeAttr("disabled");
			     }
			}else{
				
					$("#price0").focus();
		            $("#update0").attr("disabled", "true");
		            $("#submit0").removeAttr("disabled");
				}
			
		  });
		 }
		}
		 	
	
	
 function split(val) {
    return val.split(/,\s*/);
  }
 function extractLast(term) {
	 return split(term).pop();
  }
$(document).ready(function() {
	
	
	
	/*var chars = /[,\/\w]/i; // all valid characters /^[A-Za-z\s]+$/
	$('input').keyup(function(e) {
	  var value = this.value;
	  var char = value[value.length-1];
	  if (!chars.test(char)) {
	    $(this).val(value.substring(0, value.length-1));
	  }
	});*/
	
//	var chars =/^[A-Za-z0-9\s]+$/;  all valid characters 
	$('.names0').keyup(function(e) {

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

	var chars = /[,\/\w]/i; // all valid characters 
	$('#batchNo0').keyup(function(e) {
	  var value = this.value;
	  var char = value[value.length-1];
	  if(value.length==1 && char==" "){$(this).val(value.substring(0, value.length-1));};
	  if (!chars.test(char)) {
		  if(value.length > 0){
	           alert('Special characters not allowed');
	              }
	              var count1=0;
	              for (var i=0;i<value.length;i++){
  	                var d1=value.charAt(value.length - i);
  	           //     alert("d1**"+d1);
  	                if(!d1.match(chars)){
  	                count1+=1;
  	                 }
  	               }//alert(count1);
	           
	    $(this).val(value.substring(0, value.length-count1-1));
	     if(value.substring(0, value.length-count1-1)==""){
	    	 $(this).focus();
	     }
	    
	  }else if(value[value.length-1]==" " && value[value.length-2]==" " && value.length>1){
		  $(this).val(value.substring(0, value.length-1));
	  }else{
		  
	  }
	});
	
	
	$('.double0').keyup(function(e) {
	 var value = this.value;
	  var char = value[value.length-1];
	     if(isNaN(value) || value == " "){
	    	 for (var i=0;i<value.length;i++){
	                var d=value.charAt(i);
	                if(isNaN(d)  || d==" "){
	                 value = value.substring(0,i); 
	                 }
	               }$(this).val(value);
	   }else if(value[value.length-1]=="." && value[value.length-2]=="." && value.length>1){
		  $(this).val(value.substring(0, value.length-1));
	   };
	  if(value.length==1 && char=="."){
		  $(this).val(value.substring(0, value.length-1));
	  }
	  else if(value[value.length-1]==" " && value.length>0){
		  $(this).val(value.substring(0, value.length-1));
	  }
	  else if(value[value.length-1]==" " && value[value.length-2]==" " && value.length>1){
		  $(this).val(value.substring(0, value.length-1));
	  }
	 });
	
	
	
	$('.integer0').keyup(function(e) {
		var value = this.value;
		var char = value[value.length-1];
		if(char=="."){$(this).val(value.substring(0, value.length-1));}
		else if(char==" "){$(this).val(value.substring(0, value.length-1));}
		 if(isNaN(value) || value == " "){
	    	 for (var i=0;i<value.length;i++){
	                var d=value.charAt(i);
	                if(isNaN(d) || d==" "){
	                 value = value.substring(0,i); 
	                 }
	               }$(this).val(value);
		 }
	});
	
	//trimming the input fields
    $('#ProductEntry').submit(function(){
    	
    	
    	 
         $("#dlprice0").val(Math.round($("#dlprice0").val() * 100) / 100);
          $("#price0").val(Math.round($("#price0").val() * 100) / 100);	
        $(this).find('input:text').each(function(){
        //	alert($.trim($(this).val()));
              $(this).val($.trim($(this).val()));
        });
  });
    
	$( "#agencyname0" ).autocomplete({
		source: '${pageContext. request. contextPath}/get_medical_agency_list.html',
	  		 select: function( event, ui ) {
				 selectedObj = ui.item;
				 //alert("selected object=" + selectedObj.value);
	             $( "#tags" ).val( ui.item.label );
	             $( "#agencyname0" ).val( ui.item.value );
	             myArray= ui.item.value.split("-");
	             $( "#agencyid0" ).val( myArray[1] );
	             $( "#agencyname0" ).val( myArray[0] );
	            // alert(myArray);
	             return false;
	         },
	     focus: function( event, ui ) {
	             $( "#tags" ).val( ui.item.label );
	            // alert(ui.item.label);
	             return false;
	         },
	     change: function(event, ui) {
	         if (!ui.item) {
	             $("#tags").val("");
	            $("#agencyname0").val("");
	             $("#agencyid0").val("");
	         }
	     }
		});
	    


	$( "#pname0" ).autocomplete({
		source: '${pageContext. request. contextPath}/get_medical_products_list.html',
	    select: function( event, ui ) {
	             $( "#tags" ).val( ui.item.label );
	             $( "#pname0" ).val( ui.item.value );
	             myArray= ui.item.value.split("-");
	             $( "#pid0" ).val( myArray[1] );
	             $( "#pname0" ).val( myArray[0] );
	           // alert(myArray);
	             return false;
	         },
	      focus: function( event, ui ) {
	             $( "#tags" ).val( ui.item.label );
	            // alert(ui.item.label);
	             return false;
	         },
	      change: function(event, ui) {
	         if (!ui.item) {
	        	// alert(!ui.item);
	        	 $("#tags").val("");
	             $("#pid0").val("");
	             $("#mfcompany0").removeAttr("disabled");
	              $("#mfcompany0").val("");
	          
	          }
	         else{
	        	 getGeneralProductDetails($.trim(myArray[1]));
	             $("#mfcompany0").attr("disabled", "true");
	     
	             
	             
	         }
	     }
	     });
	     
	     

});