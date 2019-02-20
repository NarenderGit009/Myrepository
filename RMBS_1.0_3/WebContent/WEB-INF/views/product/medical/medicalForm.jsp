
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
	 if($("#piId").val()==""){
		 if($("#sCatId").text()=="TABLET"){
			// var letters = /^[A-Za-z\s]+$/;//!c.match(letters);
			 if($("#ageName").val()==""){alert("Please choose one registered agency");$("#ageName").focus();return false;}
			 if($("#ageId").val()==""){alert("Some Errors in form filling, Please refresh and try again");return false;}
			 if($("#pName").val()==""){alert("Please choose product from products or enter new product");$("#pName").focus();return false;}
			 //else if($("#pName").val().){return false;}
			 if($("#brId").val()==0){alert("Please select the branch");$("#brId").focus();return false;}
			 if($("#mFC").val()==""){alert("Please fill the manifacturing company");$("#mFC").focus();return false;}
			 if($("#schD").val()==""){alert("Please fill the schedule drug type");$("#schD").focus();return false;}
			 if($("#batNo").val()==""){alert("Please fill the Product Batch No");$("#batNo").focus();return false;}
			 if($("#sCatId").val()==""){alert("Please choose one category");$("#sCatId").focus();return false;}
			 if($("#noOfS").val()=="" || $("#noOfS").val()=="0"){alert("Please fill the no of sheets");$("#noOfS").focus();return false;}
			 if($("#qPS").val()=="" || $("#qPS").val()=="0"){alert("Please fill the quantity per sheet");$("#qPS").focus();return false;}
			 if($("#pPS").val()=="" || $("#pPS").val()=="0"){alert("Please fill the one sheet price");$("#pPS").focus();return false;}
			 if($("#pr").val()=="" || $("#pr").val()=="0"){alert("Some problem, please enter manually");$("#pr").removeAttr("readonly").focus();return false;}
//			 if($("#pId").val()==""){alert("Please fill the product expiry date");$( "#pId" ).focus();return false;}
			 if($("#dlPPS").val()=="" || $("#dlPPS").val()=="0"){alert("Please fill the one sheet dealer price");$("#dlPPS").focus();return false;}
			 if($("#dlP").val()=="" || $("#dlP").val()=="0"){alert("Some problem please enter dealer price manually");$("#dlP").removeAttr("readonly").focus();return false;}
			 if($("#qntty").val()=="" || $("#qntty").val()=="0"){alert("Some problem, please enter manually");$("#qntty").removeAttr("readonly").focus();return false;}
			 if($("#expD").val()=="" || $("#expD").val()=="0"){alert("Please fill the product expiry date");$("#expD").focus();return false;}
			 
//			 if($("#piId").val()==""){alert("Please fill the product expiry date");$( "#piId" ).focus();return false;}			 
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
		 if($("#sCatId").text()=="TABLET"){
			 if($("#brId").val()==0){alert("Please select the branch");$("#brId").focus();return false;}
			 if($("#pName").val()==""){alert("Please choose product from products or enter new product");$("#pName").focus();return false;}
			 if($("#mFC").val()==""){alert("Please fill the manifacturing company");$("#mFC").focus();return false;}
			 if($("#schD").val()==""){alert("Please fill the schedule drug type");$("#schD").focus();return false;}
			 if($("#batNo").val()==""){alert("Please fill the Product Batch No");$("#batNo").focus();return false;}
			 if($("#sCatId").val()==""){alert("Please choose one category");$("#sCatId").focus();return false;}
			// if($("#expD").val()==""){alert("Please fill the product expiry date");$("#expD").focus();return false;}
			 if($("#noOfS").val()==""){alert("Please fill the no of sheets");$("#noOfS").focus();return false;}
			 if($("#qPS").val()==""){alert("Please fill the quantity per sheet");$("#qPS").focus();return false;}
			 if($("#pPS").val()==""){alert("Please fill the one sheet price");$("#pPS").focus();return false;}
			 if($("#pr").val()=="" || $("#pr").val()=="0"){alert("Some problem, please enter manually");$("#pr").removeAttr("readonly").focus();return false;}
//			 if($("#pId").val()==""){alert("Please fill the product expiry date");$( "#pId" ).focus();return false;}
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
}

function addProduct(val2){
	 var val1=$('#catId :selected').val();
	 alert('category id '+val1);
	 alert('createdby id '+val2);
var data= $('.ProductEntry1').serialize();
alert(data);
	   loadAjaxPopup(msg);
$.post('saveProduct.html?flag='+val1+'&uid='+val2, data, function(result){
	
	$(".medical_form_container").html(result);
// $('#msg').html(result.msg).css("color", "orange");
});
//$("#msg").css("width", "200px");

disableAjaxPopup();
}

function getProductDetails(val)
 {
 //alert(val); $.trim(str)
 var text=$("#pName").val();
 var type=$("#catId").val();
 if(text!=""){
 var data=val;
 var msg={"displaymsg":"Gathering Product Information. Please Wait..."};

 loadAjaxPopup(msg);
   
 $.post('getProduct.html?pid='+val+"&flag="+type, data, function(productModel){
 	//alert(result.mfcompany);
 	if(productModel.id!=null){
 		
 		$("#mFC").val(productModel.mFCompanay);
 	    $("#schD").val(productModel.schDrug);
 	   // $("#subcatId").val(productModel.subCategoryModel.id);
 	    $("#sCatId").val(''+productModel.subCategoryModel.id+'');
 	    $('#sCatId option[value!='+productModel.subCategoryModel.id+']').attr("disabled", "true");
 	    // if($("#sCatId option:selected").text()!="Tablet"){
 	   // $("#piId").val(productModel.pinvid);
 		//$("#pr").val(productModel.price);
 	   // $("#dlP").val(productModel.dlprice);
 	    alert('subcatrgory value>>>>>>>>>>> '+productModel.subCategoryModel.category);
 	// if(productModel.categoryBean.category!="MEDICAL"){
 	    if(productModel.subCategoryModel.category!="TABLET"){
 		    	$('#tab1').hide();
 		    	$('#tab2').hide();
 		    	$('#tab3').hide();
 		    	$('#tab4').hide();
 		    	alert("general calling");
 		      /*  if($("#batNo").val()!=""){
 		        	
 	  	    	        $('#pr').focus();
 	  	           }else{
 	  	    	        $('#batNo').focus(); 
 	  	          }
 		       */
 		    	// $('#batNo').val("").focus();
 		       
 		       $('#noOfS').attr("readonly", "true");
 			   $("#pPS").attr("readonly", "true");
 	           $('#dlPPS').attr("readonly", "true");
 	           $('#qPS').attr("readonly", "true");
 	         	 
			 //  $("#sCatId").val(''+productModel.subCategoryModel.id+'');
		    //   alert('productModel.subCategoryModel.id '+productModel.subCategoryModel.id);
			 //  $('#sCatId option[value!='+productModel.subCategoryModel.id+']').attr("disabled", "true");
		
		
 	           $("#qntty").removeAttr("readonly");
 	 		  $('#pr').removeAttr("readonly");
 	 		  $("#dlP").removeAttr("readonly");
 		       
 	    	$('#pr').focus();
 		   }else{
 		    	$('#tab1').show();
 		    	$('#tab2').show();
 		    	$('#tab3').show();
 		    	$('#tab4').show();
 		   /*     if($("#batNo").val()!=""){
 		    	    	 $('#noOfS').focus();
 		    	    }else{
 		    	    	 $('#batNo').focus(); 
 		    	     }
 		   */  
 		    	// $('#batNo').val("").focus();
 		  alert("medical calling");
 		      $("#qntty").attr("readonly", "true");
 			  $('#pr').attr("readonly", "true");
 			  $("#dlP").attr("readonly", "true");
 		   
 			  $('#qPS').removeAttr("readonly");
 			  $('#noOfS').removeAttr("readonly");
 			  $("#pPS").removeAttr("readonly");
 	          $('#dlPPS').removeAttr("readonly");
 			  
 			   $('#noOfS').focus();
 		   }
 		
 	}//$("#sCatId option").removeAttr("disabled");
 	   // }
     });
 }else{
	$('#tab1').show();
	$('#tab2').show();
	$('#tab3').show();
	$('#tab4').show();
	$('#tab5').show();
	$('#tab6').show();
	
	alert("syrup calling");
   }
 disableAjaxPopup();
 }

/*************************************************************************/
  function validateBatchNo(user)
 {
	//alert($("#brId").val());
		if($("#brId").val()!=0){
			//$("#brId : selected").val();
			//var cate=$('#catId :selected').val();
			var data = { bId: $("#brId").val(),batchNo:$("#batNo").val(),type:$("#catId").val(),aId:$("#ageId").val()};
			var bID=data.bId;
		 //var data=$("#batNo"+val+"").val();
		// var type=$("#catId").val();
		if(data!=""){
			
			 var msg={"displaymsg":"Validating Batch Number. Please Wait..."};
			 
			loadAjaxPopup(msg); 
		  $.post('validateBatchNo.html', data, function(result){
			  
			  resultHtml="Message "+result.message+"<br>",
			  resultHtml+="Branch Id "+$("#brId").val()+"<br>",
			  resultHtml+="name "+result.productBean.name+"<br>",
			  resultHtml+="pid "+result.productBean.id+"<br>",
			  resultHtml+="piid "+result.id+"<br>",
			  resultHtml+="category "+result.productBean.categoryBean.category+"<br>",
			  resultHtml+="category id "+result.productBean.categoryBean.id+"<br>",
			  resultHtml+="MFG "+result.productBean.mFCompanay+"<br>",
			  resultHtml+="schDrug "+result.productBean.schDrug+"<br>",
			  resultHtml+="Price "+result.productBean.schDrug+"<br>",
			  resultHtml+="DlPP "+result.dlPrice+"<br>";
			  resultHtml+="AID "+result.agencyBean.id+"<br>";
			  resultHtml+="AgencyName "+result.agencyBean.agencyName+"<br>";
			  
			//alert(resultHtml);
			$('.col1').html(resultHtml);
		  
		//  var id=11;var gc=8;var mc=7;
			   if(result.productBean.categoryBean.id!=8){
				   if(result.batchNo!==null){
					   
				   
					   $("#submit1").css("display", "none");
					   $("#update1").css("display", "block");
					   
					   $('#catId option[value!='+result.productBean.categoryBean.id+']').attr("disabled", "true");
						$("#catId").val(result.productBean.categoryBean.id);
						
						
						$('#schD option[value!='+result.productBean.schDrug+']').attr("disabled", "true");
						$("#schD").val(result.productBean.schDrug);
						
						$('#sCatId option').removeAttr("disabled");
						//$('#schD option').removeAttr("disabled");
						$("#sCatId").val(1);
						$('#tab1').show();
						$('#tab2').show();
						$('#tab3').show();
						$('#tab4').show();
				   clearAttributes();
					   
					$("#piId").val(result.id);
					$("#pr").val(result.price);
				    $("#dlP").val(result.dlPrice);
					$("#expD").val(result.expiryDate);
					$("#brId").attr("readonly", "true");
					$('#brId option[value!='+bID+']').attr("disabled","true");
				  //  $('#tab5').hide();
				 //   $('#tab6').hide();
				      if(result.productBean.id!=$("#pId").val()){
				    	  if($("#pName").val()!="" && $("#pName").val()!=result.productBean.name){
					    	   alert("selected batchno not in the choosen product details");
				    	  }
				    	  alert('batch not eq null');
						   $("#pId").val(result.productBean.id);
						   $("#ageId").val(result.agencyBean.id);

		                   $("#pName").val(result.productBean.name);
				    	   $("#ageName").val(result.agencyBean.agencyName);
				    	   $("#mFC").val(result.productBean.mFCompanay);
				           $("#schD").val(result.productBean.schDrug);
				           $("#sCatId").val(result.productBean.subCategoryBean.id);
				           alert("product name "+result.productBean.name);
						   $("#pName").attr("readonly", "true");
						   $("#ageName").attr("readonly", "true");
				           $("#mFC").attr("readonly", "true");
				           $("#schD").attr("readonly", "true");
				           $('#sCatId option[value!='+result.productBean.subCategoryBean.id+']').attr("disabled", "true");

		                  //   alert("result.productBean.subCategoryBean.subCategory"+result.productBean.subCategoryBean.subCategory);
				    	  
			                  if(result.productBean.subCategoryBean.subCategory!="TABLET"){
								
									  $('#noOfS').attr("readonly", "true");
									  $("#pPS").attr("readonly", "true");
						              $('#qPS').attr("readonly", "true");
						              $('#pr').attr("readonly", "true");
						              $('#dlPPS').attr("readonly", "true");
						              $("#dlP").attr("readonly", "true");
						              $("#expD").attr("readonly", "true");

			     	    			  $('#tab1').hide();
			     	    	          $('#tab2').hide();
			     	    	          $('#tab3').hide();
			     	    	          $('#tab4').hide();
									  $("#qntty").removeAttr("readonly");
								
			     	                  $('#qntty').focus();
			     	                  
			                  }else{             
			                	  alert('result.productBean.subCategoryBean.subCategory!="General"');
			                	 
									  $('#noOfS').removeAttr("readonly");
									  $('#qPS').removeAttr("readonly");
		                              $('#pr').removeAttr("readonly");
						              $('#dlPPS').removeAttr("readonly");
									  $("#qntty").removeAttr("readonly");
									  $('#pr').attr("readonly", "true");
									  $("#dlP").attr("readonly", "true");
									  $('#dlPPS').attr("readonly", "true");
									  $("#pPS").attr("readonly", "true");
						              $("#expD").attr("readonly", "true");						  
									  $('#tab1').show();
			     	    	          $('#tab2').show();
			     	    		      $('#tab3').show();
			     	    	          $('#tab4').show();
			     	    	          $("#pr").attr("readonly","true");
			    		              $("#dlP").attr("readonly","true");
			    		              $("#qntty").attr("readonly","true");

									  $('#noOfS').focus();
			                	  
			     	         }
			          $("#submit1").attr("disabled", "true");
			          $("#update1").removeAttr("disabled");
				     }
				}else{
						/*	$('#tab5').show();
							$('#tab6').show();*/
							$('#brId option').removeAttr("disabled");
							$("#sCatId option").removeAttr("disabled");
					//$("#brId").removeAttr("remove");
							 $("#submit1").css("display", "block");
							   $("#update1").css("display", "none");
							  var id=11;
							  $("#sCatId option").removeAttr("disabled");
							 	$("#schD option").removeAttr("disabled");
							 	 $("#sCatId").val(1);
							 	 $("#schD").val('Y');
							// 	 $("#schD option[value=Y]").attr("disabled", "true");
								$('#sCatId option[value='+id+']').attr("disabled", "true");
				//	alert("-----"+$("#sCatId :selected").text());
				   if($("#sCatId :selected").text()!="TABLET"){
				//	if($("#sCatId").text()!=7){
					
					alert('$("#sCatId :selected").text()!="general")');
				    	$("#piId").val("");
						$("#pId").val("");
					 //   $("#ageId").val("");
						$("#pName").val("");
					 //   $("#ageName").val("");
				        $('#mFC').val("");
						$("#pr").val("");
					    $("#dlP").val("");
					    $("#qntty").val("");
						 $("#expD").val("");
					 
					    $("#ageName").removeAttr("readonly");
		                $("#pName").removeAttr("readonly");
		                $("#sCatId").removeAttr("readonly");
					    $("#mFC").removeAttr("readonly");
		                $("#schD").removeAttr("readonly");
						 $("#expD").removeAttr("readonly");
						 $("#pr").removeAttr("readonly");
						    $("#dlP").removeAttr("readonly");

									  $('#noOfS').attr("readonly", "true");
									  $("#pPS").attr("readonly", "true");
						              $('#dlPPS').attr("readonly", "true");
						           
					    $('#tab1').hide();
			  	        $('#tab2').hide();
			  	        $('#tab3').hide();
			  	        $('#tab4').hide();
					    $("#pr").removeAttr("readonly");
					    $("#dlP").removeAttr("readonly");
					    $("#qntty").removeAttr("readonly");
					    $('#pName').focus();
					}else{
						alert('$("#sCatId :selected").text()!="TABLET")');
						$("#piId").val("");
						$("#pId").val("");
					 //   $("#ageId").val("");
						$("#pName").val("");
					//    $("#ageName").val("");
				        $('#mFC').val("");
						$("#pr").val("");
					    $("#dlP").val("");
					    $("#qntty").val("");
						$("#sCatId").val(1);
		                $("#expD").val("");

					    $('#tab1').show();
			  	        $('#tab2').show();
			  	        $('#tab3').show();
			  	        $('#tab4').show();   
			  	        
			  	        $("#ageName").removeAttr("readonly");
			  	      $("#pName").removeAttr("readonly");
			  	    $("#mFC").removeAttr("readonly");
		             $("#pr").removeAttr("readonly");
		             $("#pPS").removeAttr("readonly");
					  $("#pPS").removeAttr("readonly");
					   $("#expD").removeAttr("readonly");
					   $("#qPS").removeAttr("readonly");
					   $("#schD").removeAttr("readonly");
					   $("#sCatId").removeAttr("readonly");
					   
					   $('#dlPPS').removeAttr("readonly");
			  	      //  $("#sCatId").attr("readonly","true");
			          //  $("#mFC").attr("readonly","true");
			          //  $("#qntty").attr("readonly","true");
						 $("#pr").attr("readonly","true");
		               $("#dlP").attr("readonly","true");
		               $("#qntty").attr("readonly","true");
		               
		                $("#submit1").removeAttr("disabled");

						$('#pName').focus();
					}
				}
			   
				/*else{
				   if(result.message!==null){alert(result.message);};
				   $("#batNo"+val+"").val("").focus();
			   	}*/
			
		 }else{
			 if(result.batchNo!==null){
				   
				   $("#submit1").css("display", "none");
				   $("#update1").css("display", "block");
				   var id=11;
				   $('#catId option[value!='+result.productBean.categoryBean.id+']').attr("disabled", "true");
					$("#catId").val(result.productBean.categoryBean.id);
					
					
					$('#schD option[value!='+result.productBean.schDrug+']').attr("disabled", "true");
					$("#schD").val(result.productBean.schDrug);

					$('#sCatId option').removeAttr("disabled");
					$("#sCatId").val(11);
				//	$('#schD').val('N');
					$('#sCatId option[value!='+id+']').attr("disabled", "true");
					
			 clearAttributes();
				  		$('#tab1').hide();
						$('#tab2').hide();
						$('#tab3').hide();
						$('#tab4').hide();
				$("#piId").val(result.id);
				$("#pr").val(result.price);
			    $("#dlP").val(result.dlPrice);
				$("#expD").val(result.expiryDate);
				$("#brId").attr("readonly", "true");
				$('#brId option[value!='+bID+']').attr("disabled","true");
			  //  $('#tab5').hide();
			 //   $('#tab6').hide();
			      if(result.productBean.id!=$("#pId").val()){
			    	  if($("#pName").val()!="" && $("#pName").val()!=result.productBean.name){

				    	   alert("selected batchno not in the choosen product details");
			    	  }
			    	  alert('batch not eq null');
					   $("#pId").val(result.productBean.id);
					   $("#ageId").val(result.agencyBean.id);

	                   $("#pName").val(result.productBean.name);
			    	   $("#ageName").val(result.agencyBean.agencyName);
			    	   $("#mFC").val(result.productBean.mFCompanay);
			           $("#schD").val(result.productBean.schDrug);
			           $("#sCatId").val(result.productBean.subCategoryBean.id);
			          
			           alert("product name"+result.productBean.name);
					   $("#pName").attr("readonly", "true");
					   $("#ageName").attr("readonly", "true");
			           $("#mFC").attr("readonly", "true");
			           $("#schD").attr("readonly", "true");
			           $('#sCatId option[value!='+result.productBean.subCategoryBean.id+']').attr("disabled", "true");

	                  //   alert("result.productBean.subCategoryBean.subCategory"+result.productBean.subCategoryBean.subCategory);
			    	  
		                  if(result.productBean.subCategoryBean.subCategory!="TABLET"){
							
								  $('#noOfS').attr("readonly", "true");
								  $("#pPS").attr("readonly", "true");
					              $('#qPS').attr("readonly", "true");
					              $('#pr').attr("readonly", "true");
					              $('#dlPPS').attr("readonly", "true");
					              $("#dlP").attr("readonly", "true");
					              $("#expD").attr("readonly", "true");

		     	    			  $('#tab1').hide();
		     	    	          $('#tab2').hide();
		     	    	          $('#tab3').hide();
		     	    	          $('#tab4').hide();
								  $("#qntty").removeAttr("readonly");
							
		     	                  $('#qntty').focus();
		     	                  
			                  }else{             
		                	  alert('result.productBean.subCategoryBean.subCategory!="General"');
		                	
								  $('#noOfS').removeAttr("readonly");
								  $('#qPS').removeAttr("readonly");
	                              $('#pr').removeAttr("readonly");
					              $('#dlPPS').removeAttr("readonly");
								  $("#qntty").removeAttr("readonly");
								  $('#pr').attr("readonly", "true");
								  $("#dlP").attr("readonly", "true");
								  $('#dlPPS').attr("readonly", "true");
								 
								  $("#pPS").attr("readonly", "true");
					              $("#expD").attr("readonly", "true");						  
							  
								  $('#tab1').show();
		     	    	          $('#tab2').show();
		     	    		      $('#tab3').show();
		     	    	          $('#tab4').show();
		     	    	          
		     	    	          $("#pr").attr("readonly","true");
		    		              $("#dlP").attr("readonly","true");
		    		              $("#qntty").attr("readonly","true");

								  $('#noOfS').focus();
		                	 
		     	         }
		          $("#submit1").attr("disabled", "true");
		          $("#update1").removeAttr("disabled");
			     }
			}else{
					/*	$('#tab5').show();
						$('#tab6').show();*/
						
						$('#brId option').removeAttr("disabled");
						$("#sCatId option").removeAttr("disabled");
				//$("#brId").removeAttr("remove");
						 $("#submit1").css("display", "block");
						   $("#update1").css("display", "none");
						 var id=11;
						 $("#sCatId option").removeAttr("disabled");
						 $("#sCatId").val(''+id+'');
						 $("#schD").val('N');
						 $('#sCatId option[value!='+id+']').attr("disabled", "true");
						 $("#schD option[value!=N]").attr("disabled", "true");
			//	alert("-----"+$("#sCatId :selected").text());
			  if($("#sCatId :selected").text()!="TABLET"){
			//	if($("#sCatId").text()!=7){
				
				
			    	$("#piId").val("");
					$("#pId").val("");
				 //   $("#ageId").val("");
					$("#pName").val("");
				 //   $("#ageName").val("");
			        $('#mFC').val("");
					$("#pr").val("");
				    $("#dlP").val("");
				    $("#qntty").val("");
					 $("#expD").val("");
				    $("#ageName").removeAttr("readonly");
	                $("#pName").removeAttr("readonly");
	                $("#sCatId").removeAttr("readonly");
				    $("#mFC").removeAttr("readonly");
	                $("#schD").removeAttr("readonly");
					 $("#expD").removeAttr("readonly");
					 $("#pr").removeAttr("readonly");
					    $("#dlP").removeAttr("readonly");
								  $('#noOfS').attr("readonly", "true");
								  $("#pPS").attr("readonly", "true");
					              $('#dlPPS').attr("readonly", "true");
					      
				    $('#tab1').hide();
		  	        $('#tab2').hide();
		  	        $('#tab3').hide();
		  	        $('#tab4').hide();
				    $("#pr").removeAttr("readonly");
				    $("#dlP").removeAttr("readonly");
				    $("#qntty").removeAttr("readonly");
				    $('#pName').focus();
				    
				}else{
					alert('$("#sCatId :selected").text()!="TABLET")');
					$("#piId").val("");
					$("#pId").val("");
				 //   $("#ageId").val("");
					$("#pName").val("");
				//    $("#ageName").val("");
			        $('#mFC').val("");
					$("#pr").val("");
				    $("#dlP").val("");
				    $("#qntty").val("");
					$("#sCatId").val(1);
	                $("#expD").val("");

				    $('#tab1').show();
		  	        $('#tab2').show();
		  	        $('#tab3').show();
		  	        $('#tab4').show();   
		  	        
		  	        $("#ageName").removeAttr("readonly");
		  	      $("#pName").removeAttr("readonly");
		  	    $("#mFC").removeAttr("readonly");
	             $("#pr").removeAttr("readonly");
	             $("#pPS").removeAttr("readonly");
				  $("#pPS").removeAttr("readonly");
				   $("#expD").removeAttr("readonly");
				   $("#qPS").removeAttr("readonly");
				   $("#schD").removeAttr("readonly");
				   $("#sCatId").removeAttr("readonly");
				   
				   $('#dlPPS').removeAttr("readonly");
		  	      //  $("#sCatId").attr("readonly","true");
		          //  $("#mFC").attr("readonly","true");
		          //  $("#qntty").attr("readonly","true");
					 $("#pr").attr("readonly","true");
	               $("#dlP").attr("readonly","true");
	               $("#qntty").attr("readonly","true");
	          	                $("#submit1").removeAttr("disabled");

					$('#pName').focus();
				}
			}
		//else{
			   if(result.message!==null){alert(result.message);};
			   $("#batNo"+val+"").val("").focus();
		   }
	 
		 });
		}
		disableAjaxPopup();
		}else{
			alert("Please Select Branch");
			$("#brId").focus();
		}
}
function clearAttributes(){
	
}

 /***************************************************************************/
 
	$(function() {
		$( "#expD" ).datepicker({
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
	
	/*$('#brId').change(function() {
		  //alert($(this).text());
		  alert($('#brId').text()+" branch selected");
		});*/
	
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
	$('#batNo').keyup(function(e) {
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
	
	
/*	$('.double').keyup(function(e) {
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
	
	
	
	$('.number').keyup(function(e) {
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
	*/
	//trimming the input fields
   $('#ProductEntry').submit(function(){
	   
	  
   	$("#pPS").val(Math.round($("#pPS").val() * 100) / 100);
   	 $("#dlPPS").val(Math.round($("#dlPPS").val() * 100) / 100);
        $("#dlP").val(Math.round($("#dlP").val() * 100) / 100);
         $("#pr").val(Math.round($("#pr").val() * 100) / 100);	
       $(this).find('input:text').each(function(){
       //	alert($.trim($(this).val()));
             $(this).val($.trim($(this).val()));
       });
 });
	
	 $( "#ageId" ).val("");
	 $( "#ageName" ).val("");
	 $( "#ageName" ).removeAttr("readonly");
	 $("#pName").removeAttr("readonly");
	 $("#noOfS").removeAttr("readonly");
	 $("#qPS").removeAttr("readonly");
	 $("#pPS").removeAttr("readonly");
	 $("#dlPPS").removeAttr("readonly");
	 $("#expD").removeAttr("readonly");
	 $("#mFC").val("").removeAttr("readonly");
	 $("#schD").val("").removeAttr("readonly");
	 $("#sCatId").val("").removeAttr("readonly");
	
    $("#expD").val("");
	 $("#pName").val("");
    $("#noOfS").val("");
    $("#qPS").val("");
    $("#pPS").val("");

    $("#pId").val("");
    $("#batNo").val("");
    $("#dlPPS").val("");
    $( "#piId" ).val("");
    $("#brId").focus();
  /*  $("#dlP").val("").attr("readonly","true");
    $("#qntty").val("").attr("readonly","true");
    $("#pr").val("").attr("readonly","true");*/

	 $('#tab1').show();
     $('#tab2').show();
	 $('#tab3').show();
	 $('#tab4').show();
	 $('#tab5').show();
	// $('#tab6').show();
	 $("#mFC").removeAttr("readonly");
    $("#schD").removeAttr("readonly");
    $("#sCatId").removeAttr("readonly");
	 $("#pr").attr("readonly","true");
    $("#dlP").attr("readonly","true");
    $("#qntty").attr("readonly","true");
    $("#update1").attr("readonly", "true");
    $("#update1").css("display", "none");
    
    $("#submit1").css("display", "block");
	
	$('#sCatId').change(function() {
		//alert($("#sCatId :selected").text());
	
	    if($("#sCatId :selected").text()!="TABLET"){
	    	$('#tab1').hide();
	    	$('#tab2').hide();
	    	$('#tab3').hide();
	    	$('#tab4').hide();
	    	 $("#pr").removeAttr("readonly");
	         $("#dlP").removeAttr("readonly");
	         $("#qntty").removeAttr("readonly");
	         $('#noOfS').attr("readonly", "true");
			  $("#pPS").attr("readonly", "true");
             $('#dlPPS').attr("readonly", "true");
             $('#qPS').attr("readonly", "true");
	         
	    }else{
	         $('#noOfS').removeAttr("readonly");
			  $("#pPS").removeAttr("readonly");
            $('#dlPPS').removeAttr("readonly");
            $('#qPS').removeAttr("readonly");
            
	    	 $("#pr").attr("readonly","true");
	         $("#dlP").attr("readonly","true");
	         $("#qntty").attr("readonly","true");
	         
	    	$('#tab1').show();
	    	$('#tab2').show();
	    	$('#tab3').show();
	    	$('#tab4').show();
	    	
	    }
	  });
	//**************Calling when form loded*************
	var id=11;
	
	if($('#catId :selected').text()!="MEDICAL"){
		
		 $("#sCatId option").removeAttr("disabled");
		 $("#schD").val('N');
		
		$('#sCatId option[value!='+id+']').attr("disabled", "true");
		 $("#schD option[value!=N]").attr("disabled", "true");
		 $("#sCatId").val(''+id+'');
		 $("#pr").removeAttr("readonly");
			$("#dlP").removeAttr("readonly");
			$("#qntty").removeAttr("readonly");
		$('#tab1').hide();
    	$('#tab2').hide();
    	$('#tab3').hide();
    	$('#tab4').hide();
	}else{
	
	 	$("#sCatId option").removeAttr("disabled");
	 	 $("#sCatId").val(1);
	 	 $("#schD").val('Y');
		$('#sCatId option[value='+id+']').attr("disabled", "false");
		
		$('#tab1').show();
    	$('#tab2').show();
    	$('#tab3').show();
    	$('#tab4').show();	
	}
	//*********when Medical/general dropdown seleted***********
	$('#catId').change(function(){
		alert('calling general haha');
		var id=11;
		
	if($('#catId :selected').text()!="MEDICAL"){
		
		 $("#sCatId option").removeAttr("disabled");
		 $("#sCatId").val(''+id+'');
		 $("#schD").val('N');
		 $('#sCatId option[value!='+id+']').attr("disabled", "true");
		 $("#schD option[value!=N]").attr("disabled", "true");
		$("#pr").removeAttr("readonly");
		$("#dlP").removeAttr("readonly");
		$("#qntty").removeAttr("readonly");
		$('#tab1').hide();
    	$('#tab2').hide();
    	$('#tab3').hide();
    	$('#tab4').hide();
    	$('#ageName').focus();
	}else{
		
	 	$("#sCatId option").removeAttr("disabled");
	 	$("#schD option").removeAttr("disabled");
	 	 $("#sCatId").val(1);
	 	 $("#schD").val('Y');
	// 	 $("#schD option[value=Y]").attr("disabled", "true");
		$('#sCatId option[value='+id+']').attr("disabled", "true");
		$('#tab1').show();
    	$('#tab2').show();
    	$('#tab3').show();
    	$('#tab4').show();	
	}
	});
	/*if($('#catId option:selected').text()=="General"){
		$('#tab1').hide();
   	$('#tab2').hide();
   	$('#tab3').hide();
   	$('#tab4').hide();
	}else{
		$('#tab1').show();
   	$('#tab2').show();
   	$('#tab3').show();
   	$('#tab4').show();
	}*/
	
/*	if(document.getElementById('Medical').checked){
		$('.general').hide(); $('.Medical').show();
		
	}else{
		$('.Medical').hide();$('.general').show();
	}
*/	

   var cache = {};
     
   $( "#ageName" ).autocomplete({


   source: function (request, response) {
     var term          = request.term.toLowerCase(),
           element       = this.element,
           cache         = this.element.data('autocompleteCache') || {},
           foundInCache  = false;

       $.each(cache, function(key, data){//3
         if (term.indexOf(key) === 0 && data.length > 0) {//4
           response(data);
           foundInCache = true;
           return;
         }//4
       });//3

         if (foundInCache) return;

   		var msg={"displaymsg":"Trying to display ajencies ... Please Wait...."};
   			loadAjaxPopup(msg); 	
   	
          
               $.ajax({//6
             url: '${pageContext. request. contextPath}/get_medical_agency_list.html',
             dataType: "json",
             data: request,
             success: function(data) {//5
                 cache[term] = data;
                 element.data('autocompleteCache', cache);
                 response(data);
             }//5
         });//6

           disableAjaxPopup();
       },
       
    		 select: function( event, ui ) {
    			 
   			 selectedObj = ui.item;
   			 //alert("selected object=" + selectedObj.value);
               $( "#tags" ).val( ui.item.label );
               $( "#ageName" ).val( ui.item.value );
               myArray= ui.item.value.split("_");
               $( "#ageId" ).val( myArray[1] );
               $( "#ageName" ).val( myArray[0] );
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
              $("#ageName").val("");
               $("#ageId").val("");
           }
       }
   	});

/*$( "#pName" ).autocomplete({
	//source: '${pageContext. request. contextPath}/get_medical_products_list.html',
	  source: function (request, response) {
     var term          = request.term.toLowerCase(),
           element       = this.element,
           cache         = this.element.data('autocompleteCache') || {},
           foundInCache  = false;

       $.each(cache, function(key, data){//3
    	  
       
         if (term.indexOf(key) === 0 && data.length > 0) {//4
           response(data);
           foundInCache = true;
           return;
         }//4
       });//3

         if (foundInCache) return;
		  var msg={"displaymsg":"Trying to display products ... Please Wait...."};
		  var cat=$('#catId :selected').val();
				loadAjaxPopup(msg);   
	            $.ajax({//6
	                  url: '${pageContext. request. contextPath}/get_products_list.html?type='+cat+'&term='+term+"&bId="+$("#brId").val()+"&flag="+"PI",
                  dataType: "json",
                  data: request,
                  success: function(data) {//5
                      cache[term] = data;
                      element.data('autocompleteCache', cache);
                      response(data);
                  }//5
              });//6
          disableAjaxPopup();
      },*/
      $('#pName').autocomplete({
			source: function (request, response) {
				var val=request.term;
		        $.getJSON('${pageContext. request. contextPath}/get_products_list.html', {
		            term: val,
		            type:$('#catId').val(),
		            bId:$("#brId").val(),
		            flag:"PI"
		        }, response);
		    },      
   select: function( event, ui ) {
            $( "#tags" ).val( ui.item.label );
            $( "#pName" ).val( ui.item.value );
            myArray= ui.item.value.split("_");
            $( "#pId" ).val( myArray[2] );
            $( "#pName" ).val( myArray[0] );
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
            $("#pId").val("");
            $("#mFC").removeAttr("readonly");
            $("#schD").removeAttr("readonly");
            $("#sCatId").removeAttr("readonly");
            $("#mFC").val("");
            $("#schD").val("");
            $("#sCatId").val("");
         }
        else{
       	 getProductDetails($.trim(myArray[2]));
            $("#mFC").attr("readonly", "true");
            $("#schD").attr("readonly", "true");
            $("#sCatId").attr("readonly", "true");
             
        }
    }
    });
    
/***********************************General**********************************/  

});

$(function() {
	$( "#expD0" ).datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true
	});
});
	
//Math.round(num * 100) / 100
function getSheetPrice(val){
	
	if($('#piId').val()!=""){
		var pr=$('#pr').val();
		var qps=$('#qPS').val();
		var nos=$('#noOfS').val();
		var dlprice=$('#dlP').val();
		//alert($('#piId').val());
		$('#pPS').val(Math.round((qps*pr) * 100) / 100);
		$('#qntty').val(Math.round((nos*qps) * 100) / 100);
		$('#dlPPS').val(Math.round((dlprice*qps) * 100) / 100);
	}
}

function getPrice(val){
	//noofsheets,quantitypersheet,pricepersheet,quantity,price
	var nos=$('#noOfS').val();
	var qps=$('#qPS').val();
	var pps=$('#pPS').val();
	var pr=$('#pr').val();
	var piid=$('#piId').val();
	var dlprice=$('#dlP').val();
	if(nos!="" && qps!=""){
		$('#qntty').val(Math.round((nos*qps) * 100) / 100);
		if(pps!="" && piid==""){
			$('#pr').val(Math.round((pps/qps) * 100) / 100);
		}else if(piid!=""){
	//	alert(piid);
			$('#pPS').val(Math.round((qps*pr) * 100) / 100);
			$('#qntty').val(Math.round((nos*qps) * 100) / 100);
			$('#dlPPS').val(Math.round((dlprice*qps) * 100) / 100);
		}
	}
}

function getDlPrice(val){
	var qps=$('#qPS').val();
	var dlpp=$('#dlPPS').val();
	if(qps!="" && dlpp!=""){
		$('#dlP').val(dlpp/qps);
	}
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
	            event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 190) {
	        	
	 	        }
	        	 
	        else {
	            event.preventDefault();	       
	            $(this).css("background-color", "rgb(245, 203, 203)");
	             $(this).css("border", "1px solid #FF0000");    
	             $(this).attr("placeholder", "Enter only numericals");
	        } 
  

	        if($(this).val().indexOf('.') !== -1 && event.keyCode == 190){
	            event.preventDefault(); 
	            
	        }
	      
	      
	    });
	  
	
	});



</script>
	<style>


.ProductStockEntry {
	width: 100%;
}
.valueBoxes{
margin-top: 10px;
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
#msg{
float:right;
font-weight: bold;
}
.valueBoxes input {
	padding-right: 30px;
}

.wrapper input[type="submit"]{
	float: right;
	margin : 10px;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/general/ajaxpopup.jsp"></jsp:include>
	<div class="ProductStockEntry" style="float: left;">
		<h3>Medical Product Stock Entry Form</h3>
		<div class="Medical">
			<div class="wrapper">
				<form:form method="POST"
					action="javascript:addProduct(${createdby});"
					onsubmit="return doFormValidate();" commandName="command"
					id="ProductEntry" class="ProductEntry1">

					<div id="msg">${msg}</div>

					<form:hidden path="id" id="piId" />

					<form:input path="productBean.id" id="pId" readonly="true"
						hidden="true" placeholder="Product id" />

					<%-- <td><form:label path="shopid" >Shop Id</form:label></td> 
					<form:input path="createdBy" id="shopid" value="${createdby}"
						readonly="true" hidden="true"/>--%>

					<%-- <td><form:label path="agencyid" >Agency Id</form:label></td> --%>
					<form:input path="agencyBean.id" id="ageId" value="${createdby}"
						readonly="true" hidden="" placeholder="agency id" />

					<div class="valueBoxes">
						<div id="tab6">
							<label><form:label path="">Organization</form:label></label>
							<form:input path="" value="${organization}" readonly="true" />
						</div>
						<div>

							<label><form:label path="branchBean.id">Branch</form:label></label>
							<form:select path="branchBean.id" id="brId">
								<form:option value="${branchId}">${branch}</form:option>
								<form:options items="${branches}" />
							</form:select>
						</div>
						<div>
							<label><form:label path="productBean.categoryBean.id">Category</form:label></label>
							<form:select path="productBean.categoryBean.id" id="catId">
								<form:option value="7">MEDICAL</form:option>
								<form:option value="8">GENERAL</form:option>
							</form:select>
						</div>
						<div id="tab6">
							<label><form:label path="agencyBean.agencyName">Agency Name</form:label></label>
							<form:input path="agencyBean.agencyName" id="ageName"
								class="names" value="" readonly="readonly" data-value="" />
						</div>
						<div>
							<label><form:label path="batchNo">Batch No</form:label></label>
							<form:input path="batchNo" id="batNo" value=""
								onblur="validateBatchNo(${createdby})" />
						</div>
						

						<div>
							<label><form:label path="productBean.name">Product Name</form:label></label>
							<form:input path="productBean.name" id="pName" value=""
								class="names" />
						</div>
						<div>

							<label><form:label path="productBean.subCategoryBean.id">Category</form:label></label>
							<form:select path="productBean.subCategoryBean.id" id="sCatId">
								<form:options items="${categories}" />
							</form:select>
						</div>

						<div>
							<label><form:label path="productBean.mFCompanay">MFC</form:label></label>
							<form:input path="productBean.mFCompanay" id="mFC" value=""
								class="names" />
						</div>

						<div>
							<label><form:label path="productBean.schDrug">SCH</form:label></label>
							<form:select path="productBean.schDrug" id="schD">
								<form:option value="Y">Y</form:option>
								<form:option value="N">N</form:option>
							</form:select>
						</div>


						<div id="tab1">
							<label><form:label path="noOfstrips">Strips</form:label></label>
							<form:input path="noOfstrips" class="number" id="noOfS" value=""
								onchange="getPrice(1);" onblur="getSheetPrice(1);" />
						</div>
						<div id="tab2">
							<label><form:label path="quantityPerStrip">Quantity Per Strip</form:label></label>
							<form:input path="quantityPerStrip" class="number" id="qPS"
								value="" onchange="getSheetPrice(1);" />
						</div>
						<div id="tab3">
							<style>
.placeholder {
	font-size: 14px;
	left: 5px;
	position: relative;
	margin-right: -20px;
}

#pPS,#pr,#dlPPS,#dlP {
	padding-left: 20px;
	width: 125px;
}
</style>
							<label><form:label path="pricePerStrip">Price Per Strip</form:label></label>
							<span class="placeholder">Rs </span>
							<form:input path="pricePerStrip" id="pPS" class="double" value=""
								onchange="getPrice(1);" />

						</div>


						<div id="tab3">
							<label><form:label path="price">Price</form:label></label> <span
								class="placeholder">Rs </span>
							<form:input path="price" id="pr" value="" class="double"
								readonly="true" hidden="" onfocus="" />

						</div>

						<div id="tab4">
							<label><form:label path="dlPricePerstrip">DL Strip Price</form:label></label>
							<span class="placeholder">Rs </span>
							<form:input path="dlPricePerstrip" id="dlPPS" class="double"
								value="" hidden="" onchange="getDlPrice(1);" />
						</div>

						<div>
							<label><form:label path="dlPrice">Dealer Price</form:label></label>
							<span class="placeholder">Rs </span>
							<form:input path="dlPrice" id="dlP" value="" class="double"
								readonly="true" hidden="" onfocus="" />
						</div>

						<div>
							<label><form:label path="quantity">Quantity</form:label></label>
							<form:input path="quantity" class="number" id="qntty" value=""
								readonly="" hidden="" />
						</div>

						<div>
							<label><form:label path="expiryDate">Expiry Date</form:label></label>
							<form:input path="expiryDate" id="expD" value="" hidden=""
								maxlength="0" placeholder="YYYY-MM-DD" />
						</div>
					</div>
					<div class=" ">
						<input type="submit" id="submit1" value="SAVE" /> <input
							type="submit" id="update1" value="Update" />
						<%-- <input type="button" value="Register" onclick="addAgency();"/> --%>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</body>
</html>