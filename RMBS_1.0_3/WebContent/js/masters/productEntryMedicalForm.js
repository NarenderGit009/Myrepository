

 function doFormValidate(){
	//Form validating
	 if($("#piid1").val()==""){
		 if($("#subcategory1").val()=="Tablet"){
			// var letters = /^[A-Za-z\s]+$/;//!c.match(letters);
			 if($("#agencyname1").val()==""){alert("Please choose one registered agency");$("#agencyname1").focus();return false;}
			 if($("#agencyid1").val()==""){alert("Some Errors in form filling, Please refresh and try again");return false;}
			 if($("#pname1").val()==""){alert("Please choose product from products or enter new product");$("#pname1").focus();return false;}
			 //else if($("#pname1").val().){return false;}
			 if($("#mfcompany1").val()==""){alert("Please fill the manifacturing company");$("#mfcompany1").focus();return false;}
			 if($("#schdrug1").val()==""){alert("Please fill the schedule drug type");$("#schdrug1").focus();return false;}
			 if($("#batchNo1").val()==""){alert("Please fill the Product Batch No");$("#batchNo1").focus();return false;}
			 if($("#subcategory1").val()==""){alert("Please choose one category");$("#subcategory1").focus();return false;}
			 if($("#noofsheets1").val()=="" || $("#noofsheets1").val()=="0"){alert("Please fill the no of sheets");$("#noofsheets1").focus();return false;}
			 if($("#quantitypersheet1").val()=="" || $("#quantitypersheet1").val()=="0"){alert("Please fill the quantity per sheet");$("#quantitypersheet1").focus();return false;}
			 if($("#pricepersheet1").val()=="" || $("#pricepersheet1").val()=="0"){alert("Please fill the one sheet price");$("#pricepersheet1").focus();return false;}
			 if($("#price1").val()=="" || $("#price1").val()=="0"){alert("Some problem, please enter manually");$("#price1").removeAttr("readonly").focus();return false;}
//			 if($("#pid1").val()==""){alert("Please fill the product expiry date");$( "#pid1" ).focus();return false;}
			 if($("#dlpp1").val()=="" || $("#dlpp1").val()=="0"){alert("Please fill the one sheet dealer price");$("#dlpp1").focus();return false;}
			 if($("#dlprice1").val()=="" || $("#dlprice1").val()=="0"){alert("Some problem please enter dealer price manually");$("#dlprice1").removeAttr("readonly").focus();return false;}
			 if($("#quantity1").val()=="" || $("#quantity1").val()=="0"){alert("Some problem, please enter manually");$("#quantity1").removeAttr("readonly").focus();return false;}
			 if($("#expirydate1").val()=="" || $("#expirydate1").val()=="0"){alert("Please fill the product expiry date");$("#expirydate1").focus();return false;}
			 
//			 if($("#piid1").val()==""){alert("Please fill the product expiry date");$( "#piid1" ).focus();return false;}			 
		 }else{
			 if($("#agencyid1").val()==""){alert("Some Errors in form filling, Please refresh and try again");return false;}
			 if($("#agencyname1").val()==""){alert("Please choose one registered agency");$("#agencyname1").focus();return false;}
			 if($("#pname1").val()==""){alert("Please choose product from products or enter new product");$("#pname1").focus();return false;}
			 if($("#mfcompany1").val()==""){alert("Please fill the manifacturing company");$("#mfcompany1").focus();return false;}
			 if($("#schdrug1").val()==""){alert("Please fill the schedule drug type");$("#schdrug1").focus();return false;}
			 if($("#batchNo1").val()==""){alert("Please fill the Product Batch No");$("#batchNo1").focus();return false;}
			 if($("#subcategory1").val()==""){alert("Please choose one category");$("#subcategory1").focus();return false;}
			 if($("#price1").val()=="" || $("#price1").val()=="0"){alert("Please fill the price");$("#price1").removeAttr("readonly").focus();return false;}
			 if($("#dlprice1").val()=="" || $("#dlprice1").val()=="0"){alert("Please fill the dealer price");$("#dlprice1").removeAttr("readonly").focus();return false;}
			 if($("#quantity1").val()=="" || $("#quantity1").val()=="0"){alert("Please fill the product quantity");$("#quantity1").removeAttr("readonly").focus();return false;}	 
		 }
  
	 }else{
		 if($("#subcategory1").val()=="Tablet"){
			 if($("#pname1").val()==""){alert("Please choose product from products or enter new product");$("#pname1").focus();return false;}
			 if($("#mfcompany1").val()==""){alert("Please fill the manifacturing company");$("#mfcompany1").focus();return false;}
			 if($("#schdrug1").val()==""){alert("Please fill the schedule drug type");$("#schdrug1").focus();return false;}
			 if($("#batchNo1").val()==""){alert("Please fill the Product Batch No");$("#batchNo1").focus();return false;}
			 if($("#subcategory1").val()==""){alert("Please choose one category");$("#subcategory1").focus();return false;}
			// if($("#expirydate1").val()==""){alert("Please fill the product expiry date");$("#expirydate1").focus();return false;}
			 if($("#noofsheets1").val()==""){alert("Please fill the no of sheets");$("#noofsheets1").focus();return false;}
			 if($("#quantitypersheet1").val()==""){alert("Please fill the quantity per sheet");$("#quantitypersheet1").focus();return false;}
			 if($("#pricepersheet1").val()==""){alert("Please fill the one sheet price");$("#pricepersheet1").focus();return false;}
			 if($("#price1").val()=="" || $("#price1").val()=="0"){alert("Some problem, please enter manually");$("#price1").removeAttr("readonly").focus();return false;}
//			 if($("#pid1").val()==""){alert("Please fill the product expiry date");$( "#pid1" ).focus();return false;}
			 if($("#dlpp1").val()=="" || $("#dlpp1").val()=="0"){alert("Some problem, please enter manually");$("#dlpp1").focus();return false;}
			 if($("#dlprice1").val()=="" || $("#dlprice1").val()=="0"){alert("Please fill the one sheet dealer price");$("#dlprice1").removeAttr("readonly").focus();return false;}
			 if($("#quantity1").val()=="" || $("#quantity1").val()=="0"){alert("Some problem, please enter manually");$("#quantity1").removeAttr("readonly").focus();return false;}  
		 }else{
			 if($("#pname1").val()==""){alert("Please choose product from products or enter new product");$("#pname1").focus();return false;}
			 if($("#mfcompany1").val()==""){alert("Please fill the manifacturing company");$("#mfcompany1").focus();return false;}
			 if($("#schdrug1").val()==""){alert("Please fill the schedule drug type");$("#schdrug1").focus();return false;}
			 if($("#batchNo1").val()==""){alert("Please fill the Product Batch No");$("#batchNo1").focus();return false;}
			 if($("#subcategory1").val()==""){alert("Please choose one category");$("#subcategory1").focus();return false;}
			 if($("#price1").val()=="" || $("#price1").val()=="0"){alert("Some problem, please enter manually");$("#price1").removeAttr("readonly").focus();return false;}
			 if($("#dlprice1").val()=="" || $("#dlprice1").val()=="0"){alert("Some problem please enter manually");$("#dlprice1").removeAttr("readonly").focus();return false;}
			 if($("#quantity1").val()=="" || $("#quantity1").val()=="0"){alert("Please fill the product quantity");$("#quantity1").removeAttr("readonly").focus();return false;}
			
		 }
		 
	 }
 }

 function addProduct(val1,val2){
	 
 var data= $('.ProductEntry'+val1+'').serialize();
 //alert(data);
 $.post('saveProduct.html?flag='+val1+'&uid='+val2, data, function(result){
	//alert(result);
	$("#contentbody").html(result);
 // $('#msg').html(result.msg).css("color", "orange");
 });
 //$("#msg").css("width", "200px");
 }

 function getProductDetails(val)
  {
  //alert(val); $.trim(str)
  var text=$("#pname1").val();
  var type=$("#category1").val();
  if(text!=""){
  var data=val;
  $.post('getProduct.html?pid='+val+"&flag="+type, data, function(result){
  	//alert(result.mfcompany);
	 $("#mfcompany1").val(result.mfcompany);
     $("#schdrug1").val(result.schdrug);
     $("#subcategory1").val(result.subcategory);
  
     if(result.subcategory!="Tablet"){
	    	$('#tab1').hide();
	    	$('#tab2').hide();
	    	$('#tab3').hide();
	    	$('#tab4').hide();
	        if($("#batchNo1").val()!=""){
   	    	        $('#price1').focus();
   	           }else{
   	    	        $('#batchNo1').focus(); 
   	          }
	   }else{
	    	$('#tab1').show();
	    	$('#tab2').show();
	    	$('#tab3').show();
	    	$('#tab4').show();
	        if($("#batchNo1").val()!=""){
	    	    	 $('#noofsheets1').focus();
	    	    }else{
	    	    	 $('#batchNo1').focus(); 
	    	     }
	     }
      });
  }else{
	$('#tab1').show();
	$('#tab2').show();
	$('#tab3').show();
	$('#tab4').show();
	$('#tab5').show();
	$('#tab6').show();
    }
  }

  function validateBatchNo(val,user)
  {
	  //alert(val);
  var data=$("#batchNo"+val+"").val();
  var type=$("#category1").val();
 if(data!=""){
   $.post('validateBatchNo.html?batchNo='+data+'&uid='+user+"&flag="+type, data, function(result){
	   if(result.category!="General"){
		   if(result.batchNo!==null){
			$("#piid1").val(result.pinvid);
			$("#price1").val(result.price);
		    $("#dlprice1").val(result.dlprice);
		    $('#tab5').hide();
		    $('#tab6').hide();
		      if(result.pid!=$("#pid1").val()){
		    	  if($("#pname1").val()!="" && $("#pname1").val()!=result.pname){

			    	   alert("selected batchno not in the choosen product");
		    	  }
		    	   $("#pid1").val(result.pid);
		    	   $("#pname1").val(result.pname);
		    	   $("#mfcompany1").val(result.mfcompany);
		           $("#schdrug1").val(result.schdrug);
		           $("#subcategory1").val(result.subcategory);
		           $("#mfcompany1").attr("disabled", "true");
		           $("#schdrug1").attr("disabled", "true");
		           $("#subcategory1").attr("disabled", "true");
	                  if(result.subcategory!="Tablet"){
	     	    	       $('#tab1').hide();
	     	    	       $('#tab2').hide();
	     	    	       $('#tab3').hide();
	     	    	       $('#tab4').hide();
	     	               $('#quantity1').focus();
	     	               $("#quantity1").removeAttr("readonly");
	                 }else{             
	     	    	       $('#tab1').show();
	     	    	       $('#tab2').show();
	     	    		   $('#tab3').show();
	     	    	       $('#tab4').show();
	     	    	       $('#noofsheets1').focus();
	     	    	       $("#price1").attr("readonly","true");
	    		           $("#dlprice1").attr("readonly","true");
	    		           $("#quantity1").attr("readonly","true");
	     	         }
	             $("#submit1").attr("disabled", "true");
	             $("#update1").removeAttr("disabled");
		     }
		}else{
			$('#tab5').show();
	    	$('#tab6').show();
			if($("#subcategory1").val()!="Tablet"){
				$("#price1").val("");
			    $("#dlprice1").val("");
			    $("#quantity1").val("");
			    $('#tab1').hide();
	  	        $('#tab2').hide();
	  	        $('#tab3').hide();
	  	        $('#tab4').hide();
			    $("#price1").removeAttr("readonly");
			    $("#dlprice1").removeAttr("readonly");
			    $("#quantity1").removeAttr("readonly");
			    $('#price1').focus();
			}else{
				$("#price1").val("");
			    $("#dlprice1").val("");
			    $("#quantity1").val("");
			    $('#tab1').show();
	  	        $('#tab2').show();
	  	        $('#tab3').show();
	  	        $('#tab4').show();
	  	        $("#price1").attr("readonly","true");
	            $("#dlprice1").attr("readonly","true");
	            $("#quantity1").attr("readonly","true");
	            $('#noofsheets1').focus();
	            $("#update1").attr("disabled", "true");
	            $("#submit1").removeAttr("disabled");
			}
		}
	   }
	   else{
		   if(result.msg!==null){alert(result.msg);};
		   $("#batchNo"+val+"").val("").focus();
	   }
	
  });
 }
}
 
  
	$(function() {
		$( "#expirydate1" ).datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true
		});
	});

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
	$('.names').keyup(function(e) {

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
	$('#batchNo1').keyup(function(e) {
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
	
	
	$('.double').keyup(function(e) {
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
	
	
	
	$('.integer').keyup(function(e) {
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
    	
    	$("#pricepersheet1").val(Math.round($("#pricepersheet1").val() * 100) / 100);
    	 $("#dlpp1").val(Math.round($("#dlpp1").val() * 100) / 100);
         $("#dlprice1").val(Math.round($("#dlprice1").val() * 100) / 100);
          $("#price1").val(Math.round($("#price1").val() * 100) / 100);	
        $(this).find('input:text').each(function(){
        //	alert($.trim($(this).val()));
              $(this).val($.trim($(this).val()));
        });
  });
	
	 $( "#agencyid1" ).val("");
	 $( "#agencyname1" ).val("");
	 $("#mfcompany1").val("");
     $("#schdrug1").val("");
     $("#subcategory1").val("");
     $("#expirydate1").val("");
	 $("#pname1").val("");
     $("#noofsheets1").val("");
     $("#quantitypersheet1").val("");
     $("#pricepersheet1").val("");
     $("#quantity1").val("");
     $("#price1").val("");
     $("#pid1").val("");
     $("#batchNo1").val("");
     $("#dlpp1").val("");
     $("#dlprice1").val("");
     $( "#piid1" ).val("");
 	 $('#tab1').show();
	 $('#tab2').show();
	 $('#tab3').show();
	 $('#tab4').show();
	 $('#tab5').show();
	 $('#tab6').show();
	 $("#mfcompany1").removeAttr("disabled");
     $("#schdrug1").removeAttr("disabled");
     $("#subcategory1").removeAttr("disabled");
	 $("#price1").attr("readonly","true");
     $("#dlprice1").attr("readonly","true");
     $("#quantity1").attr("readonly","true");
     $("#update1").attr("disabled", "true");
     $("#submit1").removeAttr("disabled");
	
	$('#subcategory1').change(function() {
	    if($("#subcategory1 option:selected").text()!="Tablet"){
	    	$('#tab1').hide();
	    	$('#tab2').hide();
	    	$('#tab3').hide();
	    	$('#tab4').hide();
	    	 $("#price1").removeAttr("readonly");
	         $("#dlprice1").removeAttr("readonly");
	         $("#quantity1").removeAttr("readonly");
	    }else{
	    	$('#tab1').show();
	    	$('#tab2').show();
	    	$('#tab3').show();
	    	$('#tab4').show();
	    	
	    }
	  });
	if($('#subcategory1').val()!="Tablet"){
		$('#tab1').hide();
    	$('#tab2').hide();
    	$('#tab3').hide();
    	$('#tab4').hide();
	}else{
		$('#tab1').show();
    	$('#tab2').show();
    	$('#tab3').show();
    	$('#tab4').show();
	}
	if(document.getElementById('Medical').checked){
		$('.general').hide(); $('.Medical').show();
	}else{
		$('.Medical').hide();$('.general').show();
	}
	
	$( "#agencyname1" ).autocomplete({
	source: '${pageContext. request. contextPath}/get_medical_agency_list.html',
  		 select: function( event, ui ) {
			 selectedObj = ui.item;
			 //alert("selected object=" + selectedObj.value);
             $( "#tags" ).val( ui.item.label );
             $( "#agencyname1" ).val( ui.item.value );
             myArray= ui.item.value.split("-");
             $( "#agencyid1" ).val( myArray[1] );
             $( "#agencyname1" ).val( myArray[0] );
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
            $("#agencyname1").val("");
             $("#agencyid1").val("");
         }
     }
	});
    


$( "#pname1" ).autocomplete({
	source: '${pageContext. request. contextPath}/get_medical_products_list.html',
    select: function( event, ui ) {
             $( "#tags" ).val( ui.item.label );
             $( "#pname1" ).val( ui.item.value );
             myArray= ui.item.value.split("-");
             $( "#pid1" ).val( myArray[1] );
             $( "#pname1" ).val( myArray[0] );
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
             $("#pid1").val("");
             $("#mfcompany1").removeAttr("disabled");
             $("#schdrug1").removeAttr("disabled");
             $("#subcategory1").removeAttr("disabled");
             $("#mfcompany1").val("");
             $("#schdrug1").val("");
             $("#subcategory1").val("");
          }
         else{
        	 getProductDetails($.trim(myArray[1]));
             $("#mfcompany1").attr("disabled", "true");
             $("#schdrug1").attr("disabled", "true");
             $("#subcategory1").attr("disabled", "true");
             
             
         }
     }
     });
     
     


 /***********************************General**********************************/    

$( "#agencyname0" ).autocomplete({
	
		source: '${pageContext. request. contextPath}/get_general_agency_list.html',
		
		 select: function( event, ui ) {
			 $( "#tags1" ).val( ui.item.label );
             $( "#agencyname0" ).val( ui.item.value );
             myArray= ui.item.value.split("-");
             $( "#agencyid0" ).val( myArray[1] );
             $( "#agencyname0" ).val( myArray[0] );
             return false;
         },
     
     focus: function( event, ui ) {
             $( "#tags1" ).val( ui.item.label );
             return false;
         },
          
     change: function(event, ui) {
         if (!ui.item) {
             $("#agencyname0").val("");
             $("#tags1").val("");
             $("#agencyid0").val("");
             alert("Please select agency name from popup only");
         }
     }
        
	});
	

$( "#pname0" ).autocomplete({
	source: '${pageContext. request. contextPath}/get_general_products_list.html',
      select: function( event, ui ) {
         $( "#tags3" ).val( ui.item.label );
         $( "#pname0" ).val( ui.item.value );
         myArray= ui.item.value.split("-");
         $( "#pid0" ).val( myArray[1] );
         $( "#pname0" ).val( myArray[0] );
         return false;
     },
  focus: function( event, ui ) {
         $( "#tags3" ).val( ui.item.label );
         return false;
     },
  change: function(event, ui) {
     if (!ui.item) {
    	// alert(ui.item.value);
         $("#tags3").val("");
        $( "#pid0" ).val("");
     }
    }
  });
 });
//Math.round(num * 100) / 100
function getSheetPrice(val){
	
	if($('#piid1').val()!=""){
		var pr=$('#price1').val();
		var qps=$('#quantitypersheet1').val();
		var nos=$('#noofsheets1').val();
		var dlprice=$('#dlprice1').val();
		//alert($('#piid1').val());
		$('#pricepersheet1').val(Math.round((qps*pr) * 100) / 100);
		$('#quantity1').val(Math.round((nos*qps) * 100) / 100);
		$('#dlpp1').val(Math.round((dlprice*qps) * 100) / 100);
	}
}

function getPrice(val){
	//noofsheets,quantitypersheet,pricepersheet,quantity,price
	var nos=$('#noofsheets1').val();
	var qps=$('#quantitypersheet1').val();
	var pps=$('#pricepersheet1').val();
	var pr=$('#price1').val();
	var piid=$('#piid1').val();
	var dlprice=$('#dlprice1').val();
	if(nos!="" && qps!=""){
		$('#quantity1').val(Math.round((nos*qps) * 100) / 100);
		if(pps!="" && piid==""){
			$('#price1').val(Math.round((pps/qps) * 100) / 100);
		}else if(piid!=""){
	//	alert(piid);
			$('#pricepersheet1').val(Math.round((qps*pr) * 100) / 100);
			$('#quantity1').val(Math.round((nos*qps) * 100) / 100);
			$('#dlpp1').val(Math.round((dlprice*qps) * 100) / 100);
		}
	}
}

function getDlPrice(val){
	var qps=$('#quantitypersheet1').val();
	var dlpp=$('#dlpp1').val();
	if(qps!="" && dlpp!=""){
		$('#dlprice1').val(dlpp/qps);
	}
}

function formSelection(val){
	if(val==0){$('.general').hide(); $('.Medical').show(); }
	if(val==1){$('.Medical').hide();$('.general').show();}

}