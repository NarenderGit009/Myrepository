<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/json2.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<script type="text/javascript" src="js/tableSearch.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/masters/purchaseForm.css" />
<style type="text/css">
html {
	font-family: calibri;
	color: #736F69;
}

.valueBoxes div {
	padding-top: 4px;
	display: inline-block;
}

.valueBoxes label {
	min-width: 90px;
	padding-left: 0px;
	text-align: right;
}

.valueBoxes select {
	width: 155px;
}

.valueBoxes input {
	padding-right: 30px;
}

.valueBoxes {
	border: #3C873C 0.5px solid;
}

.addButton {
	background: url("images/green.png") repeat scroll 0 0 transparent;
	color: #fff;
	font-weight: bold;
	font-size: 12px;
}

.addDiv {
	float: right;
	margin-right: 20px;
}

.submit_button {
	background: url("images/green.png") repeat scroll 0 0 transparent;
	float: right;
	color: white;
	font-size: 12px;
	font-weight: bold;
	margin-right: 10px;
}

.saveagency {
	display: none;
}

.remove {
	/*background: url("images/green.png") repeat scroll 0 0 transparent;*/
	margin: auto;
}
</style>
<style type="text/css">
/*	#contentbody{
	background-image:url(images/listbackground1.jpg);

	background-size: 100% 100%;
	background-repeat:no-repeat;
	background-position: left;

	}*/
#list {
	width: 100%;
	margin: auto;
	margin-top: 10px;
}

.listcaption {
	font-size: 30px;
	font-weight: bold;
}

.wrap {
	width: 100%;
	border: #3C873C 0.5px solid;
}

.wrap .cloumnheaders {
	
}

.amount {
	text-align: right;
}

.wrap table {
	width: 100%;
	table-layout: fixed;
}

.wrap table.head {
	background: url("images/green.png") repeat scroll 0 0 rgba(0, 0, 0, 0);
	font-weight: bold;
	color: #fff;
	word-wrap: break-word;
}

.wrap table tr td {
	padding: 5px;
	border: 1px solid #aaa;
	min-width: 100px;
	max-width: 100px;
	word-wrap: break-word;
}

.wrap table.head tr td {
	min-width: 85px;
	max-width: 85px;
	background: #eee;
}

.inner_table {
	height: 100px;
	overflow-y: auto;
	overflow-x: hidden;

	/*  background-image:url(images/listbackground1.jpg);

	background-size: 100% 100%;
	background-repeat:no-repeat;
	background-position: left;*/
}

.inner_table a {
	text-decoration: none;
	padding: 5%;
}

.wrap .foot {
	width: 100%;
	background: url("images/green.png") repeat scroll 0 0 rgba(0, 0, 0, 0);
	font-size: 13px;
	font-weight: bold;
	color: #fff;
	text-align: right;
	word-wrap: break-word;
	padding-top: 5px;
}
/*	.wrap .listfooter span{
	float: right;
	margin: auto;
	}*/
.wrap input {
	float: right;
}

.uppercase {
	text-transform: uppercase;
}

#next {
	float: right;
}

input[type="text"][readonly="readonly"] {
	pointer-events: none;
	background-color: lightgrey;
	color: white;
	border: 0px none;
	cursor: not-allowed;
	font-weight: bold;
}
</style>
<style>
.wrapper {
	font-family: calibri;
	font-size: 15px;
	color: #736F69;
}

.wrapper input[type=text] {
	width: 140px;
}

.wrapper input[type=password] {
	width: 140px;
}

.wrapper label {
	width: 80px;
	display: inline-block;
}

.wrapper input[type=submit] {
	float: right;
	background: url("images/green.png") repeat scroll 0 0 transparent;
	border: none;
	color: #fff;
	font-weight: bold;
}

@media only screen and (max-width:750px) {
	.wrapper {
		width: 97%;
	}
}

@media only screen and (min-width:750px) and (max-width: 980px) {
	.wrapper {
		width: 90%;
		margin: auto;
	}
	.wrapper input[type=text] {
		width: 120px;
	}
}
</style>

<script type="text/javascript">
/*function loadMedicalForm(){
	//alert("loadMedicalForm called");
	msg="Please wait...  Form is loading...";
	loadAjaxPopup(msg);
	$.get("openPurchaseEntryForm.html?task_type=sub&task_form_type=medical", function(medical_form){
		//alert(medical_form);
		$(".medical_form_container").html(medical_form);
		});
	disableAjaxPopup();
	}

function loadGeneralForm(){
	//alert("loadGeneralForm called");
	$.get("productEntryForm.html?task_type=main&task_form_type=general", function(general_form){
		//alert(general_form);
		$(".general_form_container").html(general_form);
	});
	
}*/
</script>
<style>
.resp-tab-content {
	border: none;
	padding: 0px;
}

.resp-tabs-list a {
	text-decoration: none;
}

.activemode {
	background-image: url("images/green.png");
}

.ProductStockEntry {
	width: 100%;
}

.valueBoxes {
	margin-top: 10px;
}

.valueBoxes div {
	display: inline-block;
}

.valueBoxes label {
	min-width: 90px;
	padding-right: 0px;
	text-align: right;
}

.valueBoxes select {
	width: 155px;
}

#msg {
	float: right;
	font-weight: bold;
}

.valueBoxes input {
	padding-right: 30px;
}

.wrapper input[type="submit"] {
	float: right;
	margin: 10px;
}

.content-wrapper .col1 {
	display: none;
}

.content-wrapper .col2 {
	width: 100%;
}

.content-wrapper .col3 {
	display: none;
}
</style>
<script type="text/javascript">
function validateSubcategories(){
	if ($("#sCatId option:selected").text() != 'TABLET') {
		$('#tab1').hide();
		$('#tab2').hide();
		$('#tab3').hide();
		$('#tab4').hide();
	//	$('#qntty').removeAttr("readonly");
		$('#dlP').removeAttr("readonly");
	//	$('#pr').removeAttr("readonly");
	} else {
		$('#tab1').show();
		$('#tab2').show();
		$('#tab3').show();
		$('#tab4').show();
	//	$('#qntty').attr("readonly", "true");
		$('#dlP').attr("readonly", "true");
	//	$('#pr').attr("readonly", "true");
	}
}

function validateCategories(){
	   var genral=11;
		
		if ($("#catId option:selected").text()!='MEDICAL') {
			$('#sCatId option').removeAttr("disabled");
			$("#sCatId").val(11);
			$('#schD').val('N');
			$('#sCatId option[value!='+genral+']').attr("disabled", "true");
			$('#schD option[value!=N]').attr("disabled", "true");
			$('#tab1').hide();
			$('#tab2').hide();
			$('#tab3').hide();
			$('#tab4').hide();
		//	$('#qntty').removeAttr("readonly");
			$('#dlP').removeAttr("readonly");
		//	$('#pr').removeAttr("readonly");
			validateSubcategories();
		} else {
			$('#sCatId option').removeAttr("disabled");
			$('#schD option').removeAttr("disabled");
			$("#sCatId").val(1);
			$('#schD').val('Y');
			$('#sCatId option[value='+genral+']').attr("disabled", "true");
			$('#tab1').show();
			$('#tab2').show();
			$('#tab3').show();
			$('#tab4').show();
			$('#noOfS').removeAttr("readonly");
			//$('#qntty').attr("readonly", "true");
			$('#dlP').attr("readonly", "true");
			//$('#pr').attr("readonly", "true");
			validateSubcategories();
		}
}
function removeItems(){
	
	$(".items").remove();
}
function clearFields(){
	$(".valueBoxes input[type=text]").val("");
	$('#batNo option').remove();
    $('#brId').removeAttr("disabled");
	$("#catId").removeAttr("disabled");
	$("#piId").val(""),
	$('#qntty').val(0);	
	$('#vat').val(0);	
	$('#dis').val(0);	
	$('#pr').val("0.00");
	$("#brId").focus();
}




	
	var divClone;	
	$(document).ready(function() {
		 clearFields();
		//$('#pName').val("");	
		//$("#pId").val("");
		
		$('.submit_button').click(function() {
			 divClone = $(".purchase_container").clone(); 
			alert(this.id);
			var ovdis=$('#overall_dis').val();
			if(ovdis==""){ovdis=0.00;}
			var data={flag:this.id,oDis:ovdis,dId:$('#doctor').val()};
				$.post('submitSalesOrder.html', data,
						function(result){
					alert(result);
					removeItems();
					
					 divClone = $(".purchase_container").clone();
					$(".purchase_container").html(result);
					//$("#msg").html(result);
				});
		
		});
		
		$('#sCatId').change(function() {
			validateSubcategories();
		});
		
		validateCategories();
		$(".branch").html($("#brId :selected").text());
		$('#brId').change(function() {
			$(".branch").html($("#brId :selected").text());
		});
		$('#catId').change(function() {
			var genral=11;
			if ($("#catId option:selected").text()!='MEDICAL') {
				$('#sCatId option').removeAttr("disabled");
				$("#sCatId").val(11);
				$('#schD').val('N');
				$('#sCatId option[value!='+genral+']').attr("disabled", "true");
				$('#schD option[value!=N]').attr("disabled", "true");
				$('#tab1').hide();
				$('#tab2').hide();
				$('#tab3').hide();
				$('#tab4').hide();
			//	$('#qntty').removeAttr("readonly");
				$('#dlP').removeAttr("readonly");
				//$('#pr').removeAttr("readonly");
			} else {
				$('#sCatId option').removeAttr("disabled");
				$('#schD option').removeAttr("disabled");
				$("#sCatId").val(1);
				$('#schD').val('Y');
				$('#sCatId option[value='+genral+']').attr("disabled", "true");
				$('#tab1').show();
				$('#tab2').show();
				$('#tab3').show();
				$('#tab4').show();
				$('#noOfS').removeAttr("readonly");
			//	$('#qntty').attr("readonly", "true");
				$('#dlP').attr("readonly", "true");
				//$('#pr').attr("readonly", "true");
			}
		});
		
		$('#mobile').blur(function() {
		alert("hi");
			if(this.value!=""){
				data={mobile:this.value};
				 $.post('getCustomer.html', data, function(result){
				 	if(result.id!=null){
				 		alert(result.id);////mobile,cst,ini,mail,add
				 		$('#cId').val(result.id);
				 		$('#mail').val(result.addressModel.email);
				 		$('#cst').val(result.name);
				 		$('#ini').val(result.gender);
				 		$('#mobile').val(result.addressModel.mobile);
				 		$('#add').val(result.addressModel.address);
				 	}else{
				 		alert("empty");
				 	}
				});
			}
		});
		
		

	/*	$( "#pName" ).autocomplete({
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
						loadAjaxPopup(msg);   
		        	  $.ajax({//6
		                  url: '${pageContext. request. contextPath}/get_medical_products_list.html?type='+$('#catId').val(),
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
		      */
		     
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
		            return false;
		        },
		     focus: function( event, ui ) {
		            $( "#tags" ).val( ui.item.label );
		            return false;
		        },
		     change: function(event, ui) {
		        if (!ui.item) {
     		       	 $("#tags").val("");
		            $("#pId").val("");
		            if($("#sOLId").val()=="" || $("#sOLId").val()==null){
		            clearFields();
		            }
		         }
		        else{
		       	 getProductDetails($.trim(myArray[2]));
		       
		            
		        }
		    }
		        
		     
		    });
		    
		function getProductDetails(val)
		 {
		 var brId=$("#brId").val();
		 var qntty=$('#qntty').val();
		 if(brId!="" && qntty!=0){
		 var msg={"displaymsg":"Gathering Product Batches Information. Please Wait..."};

		 loadAjaxPopup(msg);
		  data={pid:val,bId:brId,Qty:qntty}; 
		 $.post('getBatches.html', data, function(result){
			 
		 	if(!jQuery.isEmptyObject(result)){
		 		
		 		$('#batNo option').remove();
		 		var o = new Option("--Select Batch--", "0");
		 		$(o).html("--Select Batch--");
		 		$("#batNo").append(o);	
		 		$.each(result, function(obj) {   
		 			var o = new Option("Batch No: "+result[obj].batchNo+" (Availability: "+result[obj].quantity+"pcs)", result[obj].id);
			 		$(o).html("Batch No: "+result[obj].batchNo+" (Availability: "+result[obj].quantity+"pcs)");
			 		$("#batNo").append(o);	
		 		});
		 	
		 	}

		     });
		 }else{
			 
			 $('#pName').val("");	
				$("#pId").val("");
			if(brId==0) {alert("Please Select The Branch"); $('#brId').focus();return false;}
			if(qntty==0) {alert("Please Change The Quantity"); $('#qntty').focus();return false;}
	
			
		   }
		 disableAjaxPopup();
		 }
var stockObj=[];
		$('#batNo').change(function() {
			
			
				if($("#batNo").val()!=0){
					//$("#branchId : selected").val();
					var data = {bNo:$("#batNo").val()};
			
					if(data!=""){
						alert("-batchNo : "+data.bNo);
						var msg={"displaymsg":"Validating Batch Number. Please Wait..."};

					//	loadAjaxPopup(msg); 
						$.post('loadProductInventory.html', data, function(result){
							if(!jQuery.isEmptyObject(result)){
								
							//alert(result.agencyBean.agencyName);
								$("#piId").val(result.id),
								$("#ageName").val(result.agencyBean.agencyName);
								$("#mFC").val(result.productBean.mFCompanay);
								$("#schD").val(result.productBean.schDrug);
								$("#sCatId").val(result.productBean.subCategoryBean.id);
								$("#pr").val((result.price).toFixed(2));
								$("#expD").val(result.expiryDate);
								$("#dis").focus();
								$('#brId').attr("disabled","true");
								$("#catId").attr("disabled","true");
								stockObj.push(result);
								
							}else{
								$('#brId').removeAttr("disabled");
								$("#catId").removeAttr("disabled");
								stockObj=[];
							}
							 console.log(stockObj);
						});
					//	 disableAjaxPopup();
						}
					}	
						
		});
		//*******************
		var itemCount = 0;
		var objs = [];
		var status=false;
		var html;
	   $('.addButton').click(function(){
		   
		   //mobile,cst,ini,mail,add
		   
		   /*if($("#mobile").val()=="" && $("#cst").val()=="" && $("#ini").val()=="" && $("#mail").val()=="" && $("#add").val()==""){
			   
		   }else if(cstId!=""){
			   
		   }else{
			   alert("Please fill all customer fields are remove all")
		   }*/
	
		   var data= $("#salesOrderForm").serialize();
		   var flag=false;
		   alert(data);
		   var returnData;
			$.post('createSalesOrder.html', 
					data, 
					function(result){
				alert(result.rowId);
				//removeItems();
				console.log(result);
				listObjects=result;
				html="";
				    createDisplayForm(listObjects);
				    $(".addButton").val("ADD");
				   
			});
		
		   
		  
	});
	});
	
	$.post('getUnCompletedSalesOrder.html',
			function(result){
		//removeItems();
		console.log(result);
		listObjects=result;
		html="";
		createDisplayForm(listObjects);
		 
	});

	
	
     function createDisplayForm(listObjects){
    html='';
    itemCount=0;
   if(!jQuery.isEmptyObject(listObjects)){
    	vatMap= {};
    	       $.each(listObjects, function(i, returnData) {
				    alert(returnData.sOId);
				    itemCount=i;
				    if(returnData.sOId!=null){
							flag=true;
							/******************************************/
							 if(flag){
								var quantity=0;
									var vat= 0.00;
									dis=returnData.disPrcnt;
									vat=returnData.vat;
									itemCount=i;
									if(itemCount==0){
										Ord_Tot_Amt_Wt_Vat_Dis=0.00;
										Ord_Tot_vatAmmount=0.00;
										Ord_Tot_disAmmount=0.00;
										Ord_Tot_Ammount=0.00;
										vat_Amnt=0;
										tot_Vat_On_Vat_Amnt=0;
									}
									quantity=returnData.qntty;
									var upr_bfr_apply_vat=returnData.uPr-(returnData.uPr*returnData.disPrcnt/100);
									ammount=returnData.lAmt;
									vat_apply_Amnt=((upr_bfr_apply_vat*quantity));
									vat_amount=(upr_bfr_apply_vat*vat/100)*quantity;
									if(vat!="" || vat!=0){
										if(!jQuery.isEmptyObject(vatMap)){
											var keys=Object.keys(vatMap);
											var vatValue=""+vat+"";
											if($.inArray(vatValue, keys) > -1){
												keys.forEach(function (key) {
												     if(key==vat){
													    	alert();
													    	 var tempvat=vatMap[key]['vat'];
													    	 if(tempvat==vat){
													    		 vatMap[key]['vat_apply_Amnt'] =vatMap[key]['vat_apply_Amnt']+vat_apply_Amnt;
													    		 vatMap[key]['vat_amount'] =vatMap[key]['vat_amount']+vat_amount;
													    		 console.log("vatMap in updateing "+vatMap);
													    		 console.log(vatMap);
													    	 }
													     }
												  });
											 }else{
										    	 var vatObj={
															"vat":vat,	
															"vat_apply_Amnt":vat_apply_Amnt,
															"vat_amount":vat_amount
													};
													 vatMap[vat]=vatObj;
													 console.log("vatMap"+vatMap);
													 console.log(vatMap);
										     }
										}else{
												var vatObj={
														"vat":vat,	
														"vat_apply_Amnt":vat_apply_Amnt,
														"vat_amount":vat_amount
												};
												 vatMap[vat]=vatObj;
												 console.log("vatMap"+vatMap);
												 console.log(vatMap);
											}
									}
									var roundedAmount=returnData.lAmt;
									itemCount++;
								 	var temp=null;
										var obj = {
											"rowId":returnData.rowId, 
											"cat":returnData.cat,
											"cById":temp,
											"cRId":temp,
											"cDate":temp,
											"pName":returnData.pName,
											"mFC":returnData.mFC,
											"qntty":returnData.qntty,
											"batNo":returnData.batNo,
											"expDate":returnData.expDate,
											"pr":returnData.pr,
											"vat":returnData.vat,
											"sOId":returnData.sOId,
											"ordAmt":returnData.ordAmt,
											"ordAmt_wt_vat_and_Dis":returnData.ordAmt_wt_vat_and_Dis,
											"blDtAndTm":temp,
											"dlvDt":"",
											"ordIdByDt":temp,
											"totVat":returnData.totVat,
											"totDis":returnData.totDis,
											"sOLId":returnData.sOLId,
											"lAmt":returnData.lAmt,
											"uPr":returnData.uPr,//(price before dis and vat)
											"disPrcnt":returnData.disPrcnt,//
											"overall_disPrcnt":returnData.overall_disPrcnt,
											"nPr":returnData.nPr,//(M.R.P)
											"pprChrgs":returnData.pprChrgs
									};
										var map=createJSON(obj,itemCount) ;	
										if(!jQuery.isEmptyObject(map)){
											$('#brId option[value!='+map[itemCount]["brId"]+']').attr("disabled","true");
										}
										html += "<tr id='tr"+ itemCount + "' class='items'><td class='middle'>" 
										 		+ itemCount
												+ "</td> <td>" + map[itemCount]['pName']
												+ "</td> <td>" + map[itemCount]['qntty'] 
												+ "</td> <td>" + map[itemCount]['mFC'] 
												+ "</td> <td>" + map[itemCount]['batNo']
												+ "</td> <td>" + map[itemCount]['expDate']
												+ "</td> <td class='amount'>" + map[itemCount]['nPr'] 
												+ "</td> <td class='amount'>" + map[itemCount]['uPr'] 
												+ "</td> <td>" + map[itemCount]['disPrcnt']
												+ "</td> <td>" + map[itemCount]['vat']
												+ "</td> <td>" + obj['cat'] 
												//	+ "</td> <td>" + obj['ITEM_SUB_CAT'] 
												+ "</td> <td class='amount'>" + roundedAmount
												+"</td>"
												+"<td>"
												/*+"<input type='button' class='remove' id='"
												+ itemCount + "' value='remove' onclick='removerow("
												+ itemCount + ");'>"
												*/
												+"<a href='#' class='remove' id='"
												+ map[itemCount]['sOLId'] + "' onclick='removeItem("
												+ map[itemCount]['sOLId'] + ");'><img src='images/Delete.png' alt='REMOVE'  height='20px' width='20px'/></a>"
											    +"<a href='#' class='edit' id='"
											   + map[itemCount]['sOLId'] + "' onclick='editItem("
											   + map[itemCount]['sOLId'] + ");'><img src='images/edit.png' alt='EDIT'  height='20px' width='20px'/></a></td> </tr>";

										$('#sOId').val(returnData.sOId);
										
								   }
							
							/*******************************************/
						}
				    
				});   
    	       
    	       
    	       removeItems();
    	       $(".sortable").append(html);
    	      
				printVatDetails(vatMap);
				clearFields();
				$(".tot_dist_amt").html(""+map[itemCount]['totDis'].toFixed(2)+"");
			     $(".tot_vat_amt").html(""+map[itemCount]['totVat'].toFixed(2)+"");
				 $(".tot_amt").html(""+map[itemCount]['ordAmt'].toFixed(2)+"");
				  $(".tot_amt_wt_V_Dis").html(""+map[itemCount]['ordAmt_wt_vat_and_Dis'].toFixed(2)+"");
    	       }else{
    	    	   removeItems();
    	    	   $('#vFive').html("");
    	    	   clearFields();
   				$(".tot_dist_amt").html("0.00");
   			     $(".tot_vat_amt").html("0.00");
   				 $(".tot_amt").html("0.00");
   				  $(".tot_amt_wt_V_Dis").html("0.00");
    	       }
    	 
     
     
     }
     
	var vatMap= {};
	
	function printVatDetails(vatObj){
		if(!jQuery.isEmptyObject(vatObj)){
			var keys=Object.keys(vatObj);
			var vatHtml="";
			keys.forEach(function (key) {
					 var tempvat=vatObj[key]['vat'];
					    	vatHtml+="VAT ON Rs: "+(vatObj[key]['vat_apply_Amnt']).toFixed(2)+" @ "+tempvat+"% = "+(vatObj[key]['vat_amount']).toFixed(2)+"<br>";
					    		$('#vFive').html(vatHtml);
					});
			}else{
				$('#vFive').html("");
			};
	}

	function removeItem(val1) {
		var data={solid:val1};
		$.post('removeLineItem.html',data,function(result){
			console.log(result);
			listObjects=result;
			html="";
			createDisplayForm(listObjects);
			 
		});
	}
	function editItem(val1) {
		var data={solid:val1};
		$.post('getLineItem.html',data,function(result){
			console.log(result);
			
			var selectOptionText = result.cat;
			$("#catId").find("option").filter(function(index) {return selectOptionText === $(this).text();}).attr("selected", "selected");
			var selectOptionText = result.sCat;
			$("#sCatId").find("option").filter(function(index) {return selectOptionText === $(this).text();}).attr("selected", "selected");
			var o = new Option(result.batNo, result.sOId);
	 		$(o).html(result.batNo);
	 		$("#piId").val(result.sOId);
	 		$("#sOLId").val(result.sOLId);
	 		$("#batNo").append(o);
	 		$("#qntty").val(result.qntty);
	 		$("#pName").val(result.pName);
	 		$("#dis").val(result.disPrcnt);
	 		$("#vat").val(result.vat);
			$("#mFC").val(result.mFC);
			$("#pr").val(result.pr);
			$("#expD").val(result.expDate);
			$(".addButton").val("UPDATE");
			
			/*
			
	private Integer rowId; 
	private String pName;
	private String mFC;
	private String schD;
	private String cat;
	private String sCat;
	private Integer qntty;
	private String expDate;
	private String batNo;
	private double pr;
	private double vat;
	private double vatPr;
	private double pWVat;
	private Integer sOId;
	private double ordAmt;
	private double ordAmt_wt_vat_and_Dis;
	private String blDtAndTm;
	private String dlvDt;
	private double disPr;
	private double totVat;
	private double totDis;
	private Integer sOLId;
	private double lAmt;
	private double uPr;
	private double disPrcnt;
	private double overall_disPrcnt;
	private double nPr;
	private double pprChrgs;
			
			
			*/
		});
	}
	$(function() {
		
		$("#expD").datepicker({
			dateFormat : 'dd-mm-yy',
			minDate: 1, maxDate: "+10Y" ,
			changeMonth : true,
			changeYear : true
		});
	});


	var map = {}; 
	function createJSON(obj,count) {
	   jsonObj = [];
	   map[count]=obj;
	   jsonObj.push(map);
	   console.log("***************************************************************");
       console.log("map"+map);
	   console.log(map);
	   console.log("***************************************************************");   
	return map;
	}
	function removeObjFromMap(row){
		removeValFromMapByKey(map,row);
		$('#dataMap').val(map);
		console.log("*****************deleted row "+row+"**********************************************");   
		 console.log(map);
		 if(jQuery.isEmptyObject(map)){
				$('#brId option').removeAttr("disabled");
				}
	}
	function updateVatDeatails(lineObject){
		var deductionAmt=lineObject['lAmt'];
   	 var deductionQntty=lineObject['qntty'];
   	 var deductionVat=lineObject['vatPr'];
   	 var deductionVatPrcnt=lineObject['vat'];
   	 vatMap[deductionVatPrcnt]['vat_amount'] =vatMap[deductionVatPrcnt]['vat_amount']-(deductionQntty*deductionVat);
	 deductionAmt=deductionAmt-(deductionQntty*deductionVat);
	 vatMap[deductionVatPrcnt]['vat_apply_Amnt'] =vatMap[deductionVatPrcnt]['vat_apply_Amnt']-deductionAmt;
	 console.log("vatMap in updateing "+vatMap);
	 console.log(vatMap);
	 if(vatMap[deductionVatPrcnt]['vat_apply_Amnt']<=0){
	
		 delete vatMap[deductionVatPrcnt];
	}
	 printVatDetails(vatMap);
	}
	function removeValFromMapByKey(obj,objKey) {
		  Object.keys(obj).forEach(function (key) {
		     if(key[0]==objKey){
		    	updateVatDeatails(obj[key]);
		    	delete obj[key];
			       if(!jQuery.isEmptyObject(obj)){
			       calOrd(obj);
			       }else{
			    	   Ord_Tot_Ammount=0;
			    	   Ord_Tot_vatAmmount=0;
				   	   Ord_Tot_disAmmount=0;
					   Ord_Tot_Amt_Wt_Vat_Dis=0;
				   	   $(".tot_dist_amt").html(""+Ord_Tot_disAmmount+"");
				       $(".tot_vat_amt").html(""+Ord_Tot_vatAmmount+"");
			    	   $(".tot_amt").html(""+Ord_Tot_Ammount+"");
			    	   $(".tot_amt_wt_V_Dis").html(""+Ord_Tot_Amt_Wt_Vat_Dis+"");
			    	   vatAsFive=0;
			    	   $('#vFive').html("");
			    	   vatAsFrtn=0;
			    	   $('#vFrtnPF').html("");
			    	   $("#oDisc").removeAttr("readonly");
			       }
		     } 
		  });
		}




</script>
</head>
<body>
	<div class="purchase_container">
		<jsp:include page="/WEB-INF/views/general/ajaxpopup.jsp"></jsp:include>
		<div class="purchaseEntryForm" style="float: left;">
			<h3>Product Sales Orgder Form</h3>
			<div class="BranchDetails">
				&nbsp;Organization :${organization},&nbsp;&nbsp;&nbsp; Branch :<span
					class="branch"></span>
			</div>
			<div class="purchaseStock">
				<div class="wrapper">
					<form:form method="POST" commandName="command" id="salesOrderForm">
						<%--<div><input type="button"  onClick="window.print()" value="Print This Page"/></div> --%>
						<div id="msg"></div>
						<div class="valueBoxes">

							<form:input path="productInventoryBean.id" id="piId"
								readonly="true" hidden="true" placeholder="Prod inv id" />
							<form:input path="id" id="sOLId" readonly="true" hidden="true"
								placeholder="solid" />
							<form:input path="salesOrderBean.customerBean.id" id="cId"
								readonly="true" hidden="true" placeholder="custid" />
							<%--	 	<div>
							<form:label path="">Organization</form:label>
							<form:input path="" value="${organization}" />
						</div>--%>

							<div>
								<form:label path="productInventoryBean.branchBean.id">Branch</form:label>
								<form:select path="productInventoryBean.branchBean.id" id="brId">
									<form:option value="${branchId}">${branch}</form:option>
									<form:options items="${branches}" />
								</form:select>
							</div>
							<div>
								<form:label
									path="productInventoryBean.productBean.categoryBean.id">Category</form:label>
								<form:select
									path="productInventoryBean.productBean.categoryBean.id"
									id="catId">
									<form:option value="7">MEDICAL</form:option>
									<form:option value="8">GENERAL</form:option>
								</form:select>
							</div>

							<div>
								<form:label path="quantity">Quantity</form:label>
								<form:input path="quantity" id="qntty" />
							</div>
							<div>
								<form:label path="productInventoryBean.productBean.name">Product Name</form:label>
								<form:input path="productInventoryBean.productBean.name"
									id="pName" />
							</div>
							<div>
								<form:label path="productInventoryBean.batchNo">Batch No</form:label>
								<form:select path="productInventoryBean.batchNo" id="batNo">
									<form:option value="0">--Select--</form:option>
								</form:select>
							</div>

							<div>
								<form:label path="discount">Discount %</form:label>
								<form:input path="discount" id="dis" />
							</div>
							<div>
								<form:label path="vat">Vat %</form:label>
								<form:input path="vat" id="vat" />
							</div>

							<div class="agencySelection">
								<form:label path="productInventoryBean.agencyBean.agencyName">Agency Name</form:label>
								<form:input path="productInventoryBean.agencyBean.agencyName"
									id="ageName" class="names" value="" disabled="true"
									data-value="" />
							</div>
							<div>
								<form:label path="productInventoryBean.productBean.mFCompanay">MFC</form:label>
								<form:input path="productInventoryBean.productBean.mFCompanay"
									id="mFC" disabled="true" />
							</div>
							<div>
								<form:label path="productInventoryBean.productBean.schDrug">SCH</form:label>
								<form:select path="productInventoryBean.productBean.schDrug"
									disabled="true" id="schD">
									<form:option value="Y">Y</form:option>
									<form:option value="N">N</form:option>
								</form:select>
							</div>
							<div>
								<form:label
									path="productInventoryBean.productBean.subCategoryBean">Sub Category</form:label>
								<form:select
									path="productInventoryBean.productBean.subCategoryBean"
									disabled="true" id="sCatId">
									<form:options items="${categories}" />
								</form:select>
							</div>
							<%-- 			<div id="tab1">
								<form:label path="productInventoryBean.noOfstrips">Strips</form:label>
								<form:input path="productInventoryBean.noOfstrips" id="noOfS"
									onblur="getSheetPrice();" />
							</div>
							<div id="tab2">
								<form:label path="productInventoryBean.quantityPerStrip">Quantity Per Strip</form:label>
								<form:input path="productInventoryBean.quantityPerStrip"
									id="qPS" onchange="getSheetPrice();" />
							</div>

							<div id="tab3">
								<form:label path="productInventoryBean.dlPricePerstrip">DL Strip Price</form:label>
								<form:input path="productInventoryBean.dlPricePerstrip"
									id="dlPPS" onblur="" />
							</div>
							<div id="tab4">
								<form:label path="productInventoryBean.pricePerStrip">Price Per Strip</form:label>
								<form:input path="productInventoryBean.pricePerStrip" id="pPS"
									onblur="" />
							</div>
							<div>
								<form:label path="productInventoryBean.dlPrice">Dealer Price</form:label>
								<form:input path="productInventoryBean.dlPrice" id="dlP" />
							</div>--%>
							<div>
								<form:label path="productInventoryBean.price">Price</form:label>
								<form:input path="productInventoryBean.price" id="pr"
									disabled="true" />
							</div>

							<%--<div>
							<form:label path="vat">Vat </form:label>
							<form:select path="vat" id="vat">
								<form:option value="14.5">14.5%</form:option>
								<form:option value="5">5%</form:option>
							</form:select>
						</div>
						
									<div>
								<form:label path="">Free Quantity</form:label>
								<form:input path="" id="fQntty" />
							</div>
						--%>

							<div>
								<form:label path="expiryDate">Expiry Date</form:label>
								<form:input path="expiryDate" id="expD" disabled="true" />
							</div>
							<div>
								<form:label
									path="salesOrderBean.customerBean.addressBean.mobile">Mobile</form:label>
								<form:input
									path="salesOrderBean.customerBean.addressBean.mobile"
									id="mobile" />
							</div>
							<div>
								<form:label path="salesOrderBean.customerBean.name">Cust Name</form:label>
								<form:input path="salesOrderBean.customerBean.name" id="cst"/>
							</div>
							<div>
								<form:label path="salesOrderBean.customerBean.gender">Gender</form:label>
								<form:select path="salesOrderBean.customerBean.gender" id="ini">
									<form:options items="${initials}" />
								</form:select>
							</div>
							<div>
								<form:label path="salesOrderBean.customerBean.addressBean.email">Email</form:label>
								<form:input path="salesOrderBean.customerBean.addressBean.email" id="mail"/>
							</div>
							<div>
								<form:label
									path="salesOrderBean.customerBean.addressBean.address">Adderss</form:label>
								<form:input
									path="salesOrderBean.customerBean.addressBean.address" id="add"/>
							</div>
							
							<div class="addDiv">
								<input type="button" title="Add Line Item To The Order"
									value="ADD" class="addButton" />
							</div>

						</div>

					</form:form>

					<div id="list">


						<div class="wrap">
							<table class="head">
								<tr>
									<th colspan="10" align="center" class="listcaptin">Entered
										Products List</th>
									<th colspan="3" class="search"><span class="search">Search:<input
											id="input" name="filter" placeholder="search here"
											onkeyup="filter2(this,1)" type="text" /></span></th>
								</tr>
								<tr class="cloumnheaders">
									<th class="main">&nbsp;<input type="checkbox" />S.No
									</th>
									<th class="main">Product Name</th>
									<th class="main">Qty</th>
									<th class="main">MFC</th>
									<th class="main">Batch No</th>
									<th class="main">Exp Date</th>
									<th class="main">M.R.P</th>
									<th class="main">Rate</th>
									<th class="main">Dis %</th>
									<th class="main">Vat %</th>
									<th class="main">Category</th>
									<th class="main">Ammount</th>
									<th class="main">Action</th>
								</tr>

							</table>
							<div class="inner_table">
								<table align="left" id="1" class="sortable">

									<thead>
										<tr>
											<th colspan="13"></th>
										</tr>
									</thead>

									<%--	<tr>
			 <td>dolo<input type="checkbox"/></td>
			 <td>amar</td>
			 <td>Mr</td>
			 <td>hyd</td>
			 <td>9959953073</td>
			 <td>mczmnb@gmail.com</td>
			 <td>MCA</td>
			 <td>CS</td>
			 <td>zkxnckn</td>
			 <td>zkxnckn</td>
			 <td>zkxnckn</td>
			 <td>zkxnckn</td>
			 <td><a href="#"><img src="images/Delete.png" alt="delete"  height="20px" width="20px"/></a>
			 <a href="#"><img src="images/edit.png" alt="delete"  height="20px" width="20px"/></a>
			 </td>
		 
		</tr>
	 --%>

								</table>
								<style>
.wrap .foot .foottable td {
	text-align: center;
	border: none;
}

.wrap .foot .calTable th,.wrap .foot .calTable td {
	text-align: center;
	border: 1px #fff solid;
	font-size: small;
	padding: 0px;
}

.wrap .foot .calTable th {
	width: 50%;
}

.wrap .foot .calTable td {
	text-align: right;
}

.wrap .foot .inv table {
	width: 250px;
}

.wrap .foot .inv select {
	width: 140px;
	border: 1px solid #A0A0A0;
	border-radius: 5px;
}

.wrap .foot .inv table td {
	text-align: left;
	vertical-align: middle;
}

.wrap .foot .inv table .lable {
	text-align: left;
	width: 50px;
}

.wrap .foot .calTable .empty {
	border-top: none;
	border-bottom: none;
	border-right: none;
}
</style>
							</div>
							<div class="foot">
								<table class="foottable">
									<tr>
										<%--<td class="inv">
											
												<table>
												<tr>
														<td class="lable">Customer:</td><td><input type="text" id="cst" /></td>
													</tr>
													<tr>
														<td class="lable">Mobile No:</td><td><input type="text" id="mob"/></td>
													</tr>
													<tr>
														<td class="lable">Mail Id:</td><td><input type="text" id="mail"/></td>
													</tr>
													
												
													</table>
													
														</td> --%>
										<td class="inv">
										<form:form  ><div>
										<form:label
												path="">Doctor</form:label>
											<form:select path="" id="doctor">
											<%--<form:option value="0">--Select--</form:option>--%>
											<form:options items="${doctors}" />
												</form:select></div>
										<div>
										<form:label	path="">Ovarall Dis%</form:label>
										<form:input path="" id="overall_dis"/>
										</div>
										
										</form:form>
											<%--<table>
												<%--doctors 
												<tr>
													<td class="lable">Doctor:</td>
													<td><form:form>
															
														</form:form></td>
												</tr>
												<tr>
													<td class="lable">Overall Dis%:</td>
													<td><input type="text" id="oDisc" /></td>
												</tr>


											</table>--%>
										</td>
										<td>
											<div id="vFive"></div>
											<div id="vFrtnPF"></div>
										</td>

										<td class="calTable">
											<table>
												<tr>
													<th class="amt_caption">Amnt excludes vat & Dis</th>
													<td class="tot_amt_wt_V_Dis"></td>
												</tr>
												<tr>
													<th class="amt_caption">Total Dis(-)</th>
													<td class="tot_dist_amt"></td>
												</tr>
												<tr>
													<th class="amt_caption">Total Vat(+)</th>
													<td class="tot_vat_amt"></td>
												</tr>
												<tr>
													<th class="amt_caption">Amnt includes Total Amt :</th>
													<td class="tot_amt"></td>
												</tr>

											</table>
										</td>
									<tr>
								</table>
							</div>
						</div>

					</div>
					<div>
						<button id="0" class="submit_button"
							title="Save As Pre-Sale Order">PRE-SALE</button>
						<button id="1" class="submit_button"
							title="Save As Sale Order And Print The Bill">SALE</button>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>