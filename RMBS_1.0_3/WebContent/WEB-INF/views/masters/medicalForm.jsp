
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <script type="text/javascript" language="javascript" src="js/jquery.js"></script>--%>
<script type="text/javascript" src="js/json2.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/masters/productentryform.css" />

<%-- <script type="text/javascript" src="js/jquery1.7.2.js"></script>--%>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Stock Entry</title>

<script type="text/javascript">


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
if(val1==0){$('.general').hide(); $('.Medical').show();}
if(val1==1){$('.Medical').hide();$('.general').show();}

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
    $("#piid1").val(result.pinvid);
	$("#price1").val(result.price);
    $("#dlprice1").val(result.dlprice);
    
 
    if(result.subcategory!="Tablet"){
	    	$('#tab1').hide();
	    	$('#tab2').hide();
	    	$('#tab3').hide();
	    	$('#tab4').hide();
	       /* if($("#batchNo1").val()!=""){
	        	
  	    	        $('#price1').focus();
  	           }else{
  	    	        $('#batchNo1').focus(); 
  	          }
	       */
	    	 $('#batchNo1').val("").focus();
	   }else{
	    	$('#tab1').show();
	    	$('#tab2').show();
	    	$('#tab3').show();
	    	$('#tab4').show();
	   /*     if($("#batchNo1").val()!=""){
	    	    	 $('#noofsheets1').focus();
	    	    }else{
	    	    	 $('#batchNo1').focus(); 
	    	     }
	   */  
	    	 $('#batchNo1').val("").focus();
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
	 // alert(user);
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
	 $( "#agencyname1" ).val("").focus();
	 $("#mfcompany1").val("").removeAttr("disabled");
    $("#schdrug1").val("").removeAttr("disabled");
    $("#subcategory1").val("").removeAttr("disabled");
    $("#expirydate1").val("");
	 $("#pname1").val("");
    $("#noofsheets1").val("");
    $("#quantitypersheet1").val("");
    $("#pricepersheet1").val("");
    $("#quantity1").val("").attr("readonly","true");
    $("#price1").val("").attr("readonly","true");
    $("#pid1").val("");
    $("#batchNo1").val("");
    $("#dlpp1").val("");
    $("#dlprice1").val("").attr("readonly","true");
    $( "#piid1" ).val("");
	 $('#tab1').show();
	 $('#tab2').show();
	 $('#tab3').show();
	 $('#tab4').show();
	 $('#tab5').show();
	 $('#tab6').show();
/*	 $("#mfcompany1").removeAttr("disabled");
    $("#schdrug1").removeAttr("disabled");
    $("#subcategory1").removeAttr("disabled");
	 $("#price1").attr("readonly","true");
    $("#dlprice1").attr("readonly","true");
    $("#quantity1").attr("readonly","true");*/
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
/*	if(document.getElementById('Medical').checked){
		$('.general').hide(); $('.Medical').show();
		
	}else{
		$('.Medical').hide();$('.general').show();
	}
*/	
	$( "#agencyname1" ).autocomplete({
		
		
	//source: '${pageContext. request. contextPath}/get_medical_agency_list.html',
	source: function (request, response) {
        $.getJSON('${pageContext. request. contextPath}/get_medical_agency_list.html', {
            term: extractLast(request.term),
            type: $("#category1").val(),
            shopid: $("#shopid").val(),
        }, response);
    },
	
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
	//source: '${pageContext. request. contextPath}/get_medical_products_list.html',
	  source: function (request, response) {
          $.getJSON("${pageContext. request. contextPath}/get_medical_products_list.html", {
              term: extractLast(request.term),
              type: $("#category1").val(),
              shopid: $("#shopid").val(),
          }, response);
      },
	
	
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
    $( "#agencyid0" ).val("");
	$( "#agencyname0" ).val("");
	$("#mfcompany0").val("");
	$("#expirydate0").val("").removeAttr("disabled");
	$("#pname0").val("");
    $("#quantity0").val("");
    $("#price0").val("").removeAttr("disabled");
    $("#pid0").val("");
    $("#batchNo0").val("");
    $("#dlprice0").val("").removeAttr("disabled");
    $( "#piid0" ).val("");
	$("#mfcompany0").removeAttr("disabled");
    $("#update0").attr("disabled", "true");
    $("#submit0").removeAttr("disabled");


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
	     	               }//alert(count);
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

$( "#agencyname0" ).autocomplete({
	//source: '${pageContext. request. contextPath}/get_medical_agency_list.html',
	source: function (request, response) {
        $.getJSON('${pageContext. request. contextPath}/get_medical_agency_list.html', {
            term: extractLast(request.term),
            type: $("#category0").val(),
          //  shopid: $("#shopid").val(),
        }, response);
    },
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
	source:  function (request, response) {
        $.getJSON("${pageContext. request. contextPath}/get_medical_products_list.html", {
            term: extractLast(request.term),
            type: $("#category0").val(),
            //shopid: $("#shopid").val(),
        }, response);
    },
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
	//alert(result.pinvid);
	if(result.category!="Medical"){
		
		if(result.batchNo!==null){
			$("#piid1").val(result.pinvid);
			$("#price0").val(result.price);
		    $("#dlprice0").val(result.dlprice);
		 
		      if(result.pid!=$("#pid0").val()){
		    	  if($("#pname0").val()!="" && $("#pname0").val()!=result.pname){

			    	   alert("selected batchno not in the choosen product");
		    	  }
		    	  
		    	  $("#tab7").hide();
		    	  $("#tab8").hide();
		    	   $("#pid0").val(result.pid);
		    	   $("#piid0").val(result.pinvid);
		    	   $("#pname0").val(result.pname);
		    	   $("#mfcompany0").val(result.mfcompany);
		    	  var myArray= result.expirydate.split(" ");
		    	  
		    	  $("#expirydate0").val(myArray[0]).attr("disabled","true");
		           $("#mfcompany0").attr("disabled", "true");
		           $("#price0").attr("disabled","true");
	  		   $("#dlprice0").attr("disabled","true");
	  		   $("#quantity0").removeAttr("readonly");
	  		   $('#quantity0').focus();
	             $("#submit0").attr("disabled", "true");
	             $("#update0").removeAttr("disabled");
		     }else{
		    	 $("#tab7").hide();
		    	  $("#tab8").hide();
		    	 $("#price0").attr("disabled","true");
		    	 $("#dlprice0").attr("disabled","true");
		    	 $("#expirydate0").attr("disabled","true");
		    	 $('#quantity0').focus();
		     }
		}else{
			  $("#tab7").show();
	    	  $("#tab8").show();
				
				  $("#expirydate0").removeAttr("disabled");
		    	  $("#price0").removeAttr("disabled").focus();
		    	  $("#dlprice0").removeAttr("disabled");
	          $("#update0").attr("disabled", "true");
	          $("#submit0").removeAttr("disabled");
			}
	}else{
		if(result.msg!=null){
			alert(result.msg);
			$("#tab7").show();
	    	  $("#tab8").show();
	    	  $("#expirydate0").removeAttr("disabled");
	    	  $("#price0").removeAttr("disabled");
	    	  $("#dlprice0").removeAttr("disabled");
			$("#batchNo"+val+"").val("").focus();
			 $("#update0").attr("disabled", "true");
	          $("#submit0").removeAttr("disabled");
		}
	}

	
});
}
}
	
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
</script>
</head>
<body>
	<style>
.ProductStockEntry {
	width: 100%;
}

.valueBoxes div {
	display: inline-block;
}

.valueBoxes label {
	min-width: 120px;
	padding-right: 0px;
	text-align: right;
}

.valueBoxes select {
	width: 155px;
}

.valueBoxes input {
	padding-right: 30px;
}

.submit,.submit1 {
	float: right;
	background-color: none;
}
</style>
	<div class="ProductStockEntry" style="float: left;">
		<h3>Medical Product Stock Entry Form</h3>
		<div class="Medical">
			<div class="wrapper">
				<form:form method="POST"
					action="javascript:addProduct(1,${createdby});"
					onsubmit="return doFormValidate();" commandName="command"
					id="ProductEntry" class="ProductEntry1">


					<div id="msg">${msg}</div>



					<form:input path="pinvid" id="piid1" value="" readonly="true"
						hidden="true" />




					<form:input path="category" id="category1" class="" value="Medical"
						readonly="true" hidden="true" />

					<!-- <td><form:label path="shopid" >Shop Id</form:label></td> -->
					<form:input path="shopid" id="shopid" value="${createdby}"
						readonly="true" hidden="true" />

					<div id="tab5">
						<!-- <td><form:label path="agencyid" >Agency Id</form:label></td> -->
						<form:input path="agencyid" id="agencyid1" value=""
							readonly="true" hidden="true" />
					</div>
					<div class="valueBoxes">
						<div id="tab6">
							<label><form:label path="">Organization</form:label></label>
							<form:input path="" id="" class="" value="${organization}"
								readonly="true" />
						</div>
						<div>

							<label><form:label path="branchname">Branch</form:label></label>
							<form:select path="branchname">
								<form:option value="${branchId}">${branch}</form:option>
								<form:options items="${branches}" />
							</form:select>
						</div>
						<div id="tab6">
							<label><form:label path="agencyname">Agency Name</form:label></label>
							<form:input path="agencyname" id="agencyname1" class="names"
								value="" readonly="readonly" />
						</div>

						<div>
							<label><form:label path="pname">Product Name</form:label></label>
							<form:input path="pname" id="pname1" value="" class="names" />
						</div>
						<div>
							<label><form:label path="batchNo">Batch No</form:label></label>
							<form:input path="batchNo" id="batchNo1" value=""
								onchange="validateBatchNo(1,${createdby})" />
						</div>

						<div>
							<label><form:label path="subcategory">Category</form:label></label>
							<form:select path="subcategory" id="subcategory1">
								<form:options items="${categories}" />
							</form:select>
						</div>



						<div>
							<label><form:label path="mfcompany">MFC</form:label></label>
							<form:input path="mfcompany" id="mfcompany1" value=""
								class="names" />
						</div>

						<%-- 	<div>
							<label><form:label path="schdrug">SCH</form:label></label>
							<form:input path="schdrug" id="schdrug1" value="" />
						</div>--%>
						<div>
							<label><form:label path="schdrug">SCH</form:label></label>
							<form:select path="schdrug" id="schdrug1">
								<form:option value="Y">Y</form:option>
								<form:option value="N">N</form:option>
							</form:select>
						</div>


						<div id="tab1">
							<label><form:label path="noofsheets">Strips</form:label></label>
							<form:input path="noofsheets" class="integer" id="noofsheets1"
								value="" onchange="getPrice(1);" onblur="getSheetPrice(1);" />
						</div>
						<div id="tab2">
							<label><form:label path="quantitypersheet">Quantity Per Strip</form:label></label>
							<form:input path="quantitypersheet" class="integer"
								id="quantitypersheet1" value="" onchange="getSheetPrice(1);" />
						</div>
						<div id="tab3">
							<style>
										

.placeholder {
	font-size: 14px;
	left: 5px;
	position: relative;
	
	margin-right: -20px;
}
#pricepersheet1,#price1,#dlpp1{
padding-left: 20px;
width: 125px;
}
</style>
							<label><form:label path="pricepersheet">Price Per Strip</form:label></label>
							<span class="placeholder">Rs.</span> 
							<form:input path="pricepersheet" id="pricepersheet1"
								class="double" value="" onchange="getPrice(1);" />
							
						</div>


						<div id="tab3">
							<label><form:label path="price">Price</form:label></label>
							<span class="placeholder">Rs.</span>
							<form:input path="price" id="price1" value="" class="double"
								readonly="true" hidden="" onfocus="" />
								
						</div>

						<div id="tab4">
							<label><form:label path="dlpricepersheet">DL Strip Price</form:label></label>
							<span class="placeholder">Rs.</span>
							<form:input path="dlpricepersheet" id="dlpp1" class="double"
								value="" hidden="" onchange="getDlPrice(1);" />
								
						</div>

						<div>
							<label><form:label path="dlprice">Dealer Price</form:label></label>
							<form:input path="dlprice" id="dlprice1" value="" class="double"
								readonly="true" hidden="" onfocus="" />
						</div>

						<div>
							<label><form:label path="quantity">Quantity</form:label></label>
							<form:input path="quantity" class="integer" id="quantity1"
								value="" readonly="" hidden="" />
						</div>

						<div>
							<label><form:label path="expirydate">Expiry Date</form:label></label>
							<form:input path="expirydate" id="expirydate1" value="" hidden=""
								maxlength="0" placeholder="YYYY-MM-DD" />
						</div>
					</div>
					<div class="submit ">
						<input type="submit" id="submit1" value="SAVE" />
						<%-- <input type="submit" id="update1" disabled="true" value="Update" />--%>
						<%-- <input type="button" value="Register" onclick="addAgency();"/> --%>
					</div>








				</form:form>
			</div>

		</div>
	</div>
</body>
</html>