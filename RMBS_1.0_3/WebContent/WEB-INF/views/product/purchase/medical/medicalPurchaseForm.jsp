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
<script type="text/javascript" src="js/product/batchValidation.js"></script>
<script type="text/javascript" src="js/product/formValidate.js"></script>
<script type="text/javascript" src="js/product/agencyAutoComplete.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/masters/purchaseForm.css" />
<style type="text/css">
.errmsg {
	color: red;
	position: absolute;
	font-size: 15px;
	font-weight: bold;
	margin-top: 18px;
	margin-left: -100px;
	text-decoration: blink;
}

html {
	font-family: calibri;
	color: #736F69;
}

.valueBoxes div {
	padding-top: 4px;
	display: inline-block;
}

.valueBoxes label {
	min-width: 120px;
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

/*
.innertable {
	text-align: left;
	background-color: lightgrey;
	min-width: 98%;
	max-height: 150px;
	overflow: scroll;
	
	overflow-x: scroll;
	border: 1px solid green;
}

.innertable tr {
	border: 0.5px solid #fff;
}

th {
	background: url("images/green.png") repeat scroll 0 0 transparent;
	color: white;
	height: auto;

}

#dynamictable th {
	border-top: ridge;

	font-weight: bold;
	text-align: center;
	border-right: #fff solid 0.5px;
}

.innertable td {
	width: 140px;
	text-align: left;
	border-right: #fff solid 0.5px;
}

.outertable {
	margin: left;
	text-align: left;
	font-size: 12px;
	width: 98%;
	border-spacing: 0;
	border: 1px solid green;
}
.main{

width: 140px;
}
*/
.addButton {
	background: url("images/green.png") repeat scroll 0 0 transparent;
}

.addDiv {
	float: right;
	margin-right: 20px;
}

#submit,.saveagency {
	background: url("images/green.png") repeat scroll 0 0 transparent;
	float: right;
	color: white;
	font-weight: bold;
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
	min-width: 120px;
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
		$('#qntty').removeAttr("readonly");
		$('#dlP').removeAttr("readonly");
		$('#pr').removeAttr("readonly");
	} else {
		$('#tab1').show();
		$('#tab2').show();
		$('#tab3').show();
		$('#tab4').show();
		$('#qntty').attr("readonly", "true");
		$('#dlP').attr("readonly", "true");
		$('#pr').attr("readonly", "true");
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
			$('#qntty').removeAttr("readonly");
			$('#dlP').removeAttr("readonly");
			$('#pr').removeAttr("readonly");
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
			$('#qntty').attr("readonly", "true");
			$('#dlP').attr("readonly", "true");
			$('#pr').attr("readonly", "true");
			validateSubcategories();
		}
}
function removeItems(){
	
	$(".items").remove();
}
function clearFields(){
	var aname=$('#ageName').val();
	$(".valueBoxes input[type=text]").val("");
	$('#ageName').val(aname);
	$("#batNo").focus();
}

var popupStatus = 0;
function selectAgency(){
	if(popupStatus == 0) { // if value is 0, show popup
		//closeloading(); // fadeout loading
		$("#toPopup").fadeIn(0500); // fadein popup div
		
		$("#backgroundPopup").css("opacity", "0.7"); // css opacity, supports IE7, IE8
		$(".loadingImg").css("display","none");
		agencyHTML= "<div class='agencyPopup'><div class='agencyPopupHeader'>Select Supplier Or Agency</div>Select Agency : <input type='text' id='ageName'></input>",
		agencyHTML+="<input type='button' class='saveagency' onClick='closeAgencySelection();' value='SAVE'></input></div>"; 
		$(".ajaxmsg").html(agencyHTML);
		$(".agencyPopup").css("width","300px");
		$(".agencyPopupHeader").css("width","100%").css("font-weight","bold").css("color","#fff").css("padding","3px").css("margin-bottom","10px")
		.css("background","url('images/green.png') repeat scroll 0 0 rgba(0, 0, 0, 0)");
		$("#backgroundPopup").fadeIn(0001); 
		$(".agencyPopup input").focus();
		popupStatus = 1; // and set value to 1
	}	
}
function closeAgencySelection() {
		if(popupStatus == 1) { // if value is 1, close popup
			$("#toPopup").fadeOut("normal");  
			$("#backgroundPopup").fadeOut("normal");  
			popupStatus = 0;  // and set value to 0
		}

}	
	var divClone;	
	$(document).ready(function() {
		selectAgency();
		$('#submit').click(function() {
			 divClone = $(".purchase_container").clone(); 
			 if($( '#ageId' ).val()!="" && $( '#ageId' ).val()!=null){
				
	           }else{ selectAgency();}
			if($("#invNo").val()==""){
				alert("Please enter invoice number");$("#invNo").focus();
				}else{
			//alert(map[1]['ITEM_NAME']);
			alert(jQuery.isEmptyObject(map));
			if(!jQuery.isEmptyObject(map)){
				objs=[];
				 Object.keys(map).forEach(function (key) {
					//// alert(map[key]['ordAmt']);
				    //// if(key[0]==objKey){
				    ////	alert(Ord_Tot_Ammount); 
				     map[key]['ordAmt']=Ord_Tot_Ammount.toFixed(2);
			    map[key]['totVat']=Ord_Tot_vatAmmount.toFixed(2);
			    map[key]['totDis']=Ord_Tot_disAmmount.toFixed(2);
			    map[key]['ordAmt_wt_vat_and_Dis']=Ord_Tot_Amt_Wt_Vat_Dis.toFixed(2);
			    map[key]['invNo']=$("#invNo").val();
				    alert(map[key]['ordAmt']);
				    objs.push(map[key]);
			});
				 var data= JSON.stringify(objs);
				$.post('createOrder.html', 
						data, 
						function(result){
					alert(result);
					removeItems();
					
					 divClone = $(".purchase_container").clone();
					$(".purchase_container").html(result);
				})/*.error(function(){
		            alert("submition failed");
		          });;	*/
			}else{
				alert("Error: Empty Invoice, Submition Prevented");
			}
		}
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
				$('#qntty').removeAttr("readonly");
				$('#dlP').removeAttr("readonly");
				$('#pr').removeAttr("readonly");
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
				$('#qntty').attr("readonly", "true");
				$('#dlP').attr("readonly", "true");
				$('#pr').attr("readonly", "true");
			}
		});
		
		
		$('#ageName').autocomplete({
			source: function (request, response) {
				var val=request.term;
		        $.getJSON('${pageContext. request. contextPath}/get_purchase_medical_agency_list.html', {
		            term: val,
		       
		        }, response);
		    },
		    
		 		select: function( event, ui ) {
					 selectedObj = ui.item;
		            $( '#tags' ).val( ui.item.label );
		            $( '#ageName' ).val( ui.item.value );
		            myArray= ui.item.value.split("_");
		            $( '#ageId' ).val( myArray[1] );
		            $( '#ageName' ).val( myArray[0] );
		            $( '#ageName1' ).val( myArray[0] );
		           if($( '#ageId' ).val()!="" && $( '#ageId' ).val()!=null){
		        	   $(".saveagency").css("display","block");
		           }
		            return false;
		        },
		    focus: function( event, ui ) {
		            $( '#tags' ).val( ui.item.label );
		            return false;
		        },
		    change: function(event, ui) {
		        if (!ui.item) {
		            $('#tags').val("");
		           $('#ageName').val("");
		            $('#ageId').val("");
		            $( '#ageName1' ).val("");
		        }
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
				            flag:P
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
		    
		function getProductDetails(val)
		 {
		 var text=$("#pname").val();
		 var type=$('#catId').val();
		 if(text!=""){
		 var data=val;
		 var msg={"displaymsg":"Gathering Product Information. Please Wait..."};

		 loadAjaxPopup(msg);
		   
		 $.post('getProduct.html?pid='+val+"&flag="+type, data, function(productModel){
		 	if(productModel.id!=null){
		 		$("#mFC").val(productModel.mFCompanay);
		 	    $("#schD").val(productModel.schDrug);
		 	 /*   if($("#pId").val("")!=""){
		 	    	 $('#catId').val(''+productModel.subCategoryModel.id+'');
				 	  $('#catId option[value!='+productModel.subCategoryModel.id+']').attr("disabled", "true");
		 	    }else{$('#catId option').removeAttr("readonly");}*/
		 	  
		 	    $("#sCatId").val(''+productModel.subCategoryModel.id+'');
		 	    $('#sCatId option[value!='+productModel.subCategoryModel.id+']').attr("disabled", "true");
		 	    alert(productModel.subCategoryModel.category);
		 	    if(productModel.subCategoryModel.category!="TABLET"){
		 		    	$('#tab1').hide();
		 		    	$('#tab2').hide();
		 		    	$('#tab3').hide();
		 		    	$('#tab4').hide();
		 		       $('#noOfS').attr("readonly", "true");
		 			   $("#pPS").attr("readonly", "true");
		 	           $('#dlPPS').attr("readonly", "true");
		 	           $('#qPS').attr("readonly", "true");
		 	           
		 	           $("#qntty").removeAttr("readonly");
		 	 		  $('#pr').removeAttr("readonly");
		 	 		  $("#dlP").removeAttr("readonly");
		 		       
		 	    	$('#noOfS').focus();
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
		 		    	// $('#batchNo1').val("").focus();
		 		   
		 		      $("#qntty").attr("readonly", "true");
		 			  $('#pr').attr("readonly", "true");
		 			  $("#dlP").attr("readonly", "true");
		 		   
		 			  $('#qPS').removeAttr("readonly");
		 			  $('#noOfS').removeAttr("readonly");
		 			  $("#pPS").removeAttr("readonly");
		 	          $('#dlPPS').removeAttr("readonly");
		 			  
		 			   $('#noOfS').focus();
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
		 disableAjaxPopup();
		 }


		//*******************
		var itemCount = 0;
		var objs = [];
	   $('.addButton').click(function(){
		   <%-- S.No ,Product Name, Qty, MFC, Batch No, Exp Date, M.R.P, Rate, Dis %, Vat %, Ammount, Action--%>
		   if($("#sCatId option:selected").val()=="1"){ 
		   doCal();
		   }
		   var validation=true;
		   validation=doFormValidate();
		   var ovr_al_dis=0.00;
		   if(validation){
			   if($('#oDisc').val()==""){
				   validation=false;
			   
					alert("Enter Ovreall Discount");
					$("#oDisc").focus();
				}else{
					ovr_al_dis=$("#oDisc").val();
					$("#oDisc").attr("readonly", "true");
					validation=true;
				}
		   }
		   if(validation){
			   
		   
		var html = "";
		var ammount=0.00;
		var quantity=0;
		var rate=0.00;
		var mrp=0.00;
		var fQunatity=0;
		var vat= 0.00;
		var dis=0.00;
		
		
		var uPrice=0.00;
		var nPrice=0.00;
		var disAmmount=0.00;
		var vAmmount=0.00;
        if($('#fQntty').val()!=""){fQunatity=$('#fQntty').val();}else{fQunatity=0;}
		if($("#dis").val()!=""){dis=($("#dis").val());}else{dis=0.00;}
		if($("#vat").val()!=""){vat= $("#vat").val();}else{vat=0.00;}
		
		dis=parseFloat(dis)+parseFloat(ovr_al_dis);
		
		if(itemCount==0){
			Ord_Tot_Amt_Wt_Vat_Dis=0.00;
			Ord_Tot_vatAmmount=0.00;
			Ord_Tot_disAmmount=0.00;
			Ord_Tot_Ammount=0.00;
			vat_Amnt=0;
			tot_Vat_On_Vat_Amnt=0;
		}
		if($("#sCatId option:selected").val()!="1"){
			rate= parseFloat($("#dlP").val());
			mrp= parseFloat($("#pr").val());
			quantity=  parseFloat($("#qntty").val());
		}else{
			rate=parseFloat($("#dlPPS").val()/$("#qPS").val()).toFixed(2);
			mrp= parseFloat($("#pPS").val()/$("#qPS").val()).toFixed(2);
			quantity= parseFloat($("#noOfS").val()*$("#qPS").val()).toFixed(2);
		}
		if(dis!="" && dis!=0 && dis!=null){
			disAmmount=(rate*(dis/100));
			uPrice=rate-disAmmount;
		}else{
			uPrice=rate;
			uPrice=parseFloat(uPrice);
		}
		var upr_bfr_apply_vat=uPrice;
		if(vat!="" && vat!=0 && vat!=null){
			vAmmount=(uPrice*(vat/100));
		}else{
			vat=0.00;
		}		
		
		if(uPrice!=0 && vAmmount!=0){
			uPrice=uPrice+parseFloat(vAmmount);
		}
		
		ammount=(uPrice*quantity);
		vat_apply_Amnt=((upr_bfr_apply_vat*quantity));
		vat_amount=vAmmount*quantity;
		
		if(!jQuery.isEmptyObject(vatMap)){
			var keys=Object.keys(vatMap);
			
			if($.inArray(vat, keys) > -1){
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
		var roundedAmount=(rate*quantity).toFixed(2);
		quantity=parseInt(quantity)+parseInt(fQunatity);
		itemCount++;
	 	var temp=null;
			var obj = {
				"rowId":itemCount, 
				"pId":$("#pId").val(),
				"pName":$("#pName").val(),
				"ageId":$("#ageId").val(),
				"pCode":temp,
				"mFC":$("#mFC").val(),
				"schD":$("#schD").val(),
				"catId":$("#catId").val(),
				"sCatId":$("#sCatId").val(),
				"cById":temp,
				"cRId":temp,
				"cDate":temp,
				"piId":$("#piId").val(),
				"qntty":$("#qntty").val(),
				"fQntty":fQunatity,
				"brId":$("#brId").val(),
				"expDate":$("#expD").val(),
				"batNo":$("#batNo").val(),
				"pr":($("#pr").val()),
				"vat":vat,
				"vatPr":vAmmount,
				"pWVat":uPrice-vAmmount,
				"upDate":temp,
				"pOId":temp,
				"ordAmt":Ord_Tot_Ammount,
				"ordAmt_wt_vat_and_Dis":temp,
				"blDtAndTm":temp,
				"dlvDt":"",
				"ordIdByDt":temp,
				"disPr":disAmmount,
				"totVat":Ord_Tot_vatAmmount,
				"totDis":Ord_Tot_disAmmount,
				"invNo":$("#invNo").val(),
				"pOLId":temp,
				"lAmt":ammount,
				"uPr":rate,//(price before dis and vat)
				"disPrcnt":dis,//
				"overall_disPrcnt":$("#oDisc").val(),
				"nPr":mrp,//(M.R.P)
				"pprChrgs":0
		};
			var map=createJSON(obj,itemCount) ;	
			if(!jQuery.isEmptyObject(map)){
				$('#brId option[value!='+map[itemCount]["brId"]+']').attr("disabled","true");
			}
	        html = "<tr id='tr"+ itemCount + "' class='items'><td>" 
			 		+ itemCount
					+ "</td> <td>" + map[itemCount]['pName']
					+ "</td> <td>" + map[itemCount]['qntty'] 
					+ "</td> <td>" + map[itemCount]['fQntty'] 
					+ "</td> <td>" + map[itemCount]['mFC'] 
					+ "</td> <td>" + map[itemCount]['batNo']
					+ "</td> <td>" + map[itemCount]['expDate']
					+ "</td> <td class='amount'>" + map[itemCount]['nPr'] 
					+ "</td> <td class='amount'>" + map[itemCount]['uPr'] 
					+ "</td> <td>" + map[itemCount]['disPrcnt']
					+ "</td> <td>" + map[itemCount]['vat']
					+ "</td> <td class='amount'>" + roundedAmount
				//	+ "</td> <td>" + obj['ITEM_SCH'] 
				//	+ "</td> <td>" + obj['ITEM_SUB_CAT'] 
					+"</td>"
					+"<td>"
					/*+"<input type='button' class='remove' id='"
					+ itemCount + "' value='remove' onclick='removerow("
					+ itemCount + ");'>"
					*/
					+"<a href='#' class='remove' id='"
					+ itemCount + "' onclick='removerow("
					+ itemCount + ");'><img src='images/Delete.png' alt='delete'  height='20px' width='20px'/></a>"
					 +/*"<a href='#'><img src='images/edit.png' alt='delete'  height='20px' width='20px'/></a>*/"</td> </tr>";
			$(".sortable").append(html);
			printVatDetails(vatMap);
			clearFields();
			$("#ageId").val(map[itemCount]['ageId']);
			calOrd(map);
	   }
	});
	});
	

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
	
	var Ord_Tot_vatAmmount;
	var Ord_Tot_disAmmount;
	var Ord_Tot_Ammount;
	var Ord_Tot_Amt_Wt_Vat_Dis;
	function calOrd(map){
		if(!jQuery.isEmptyObject(map)){
			
			Ord_Tot_Amt_Wt_Vat_Dis=0.00;
			Ord_Tot_vatAmmount=0.00;
			Ord_Tot_disAmmount=0.00;
			Ord_Tot_Ammount=0.00;	
			Ord_Tot_Amt_Wt_Vat_Dis=0.00;
			objs=[];
			 Object.keys(map).forEach(function (key) {
				
			    Ord_Tot_disAmmount=Ord_Tot_disAmmount+(map[key]['disPr']*map[key]['qntty']);
			    Ord_Tot_vatAmmount=Ord_Tot_vatAmmount+(map[key]['vatPr']*map[key]['qntty']);
			    Ord_Tot_Amt_Wt_Vat_Dis=Ord_Tot_Amt_Wt_Vat_Dis+(map[key]['qntty']*map[key]['uPr']);
			    Ord_Tot_Ammount=Ord_Tot_Ammount+map[key]['lAmt'];
			    
			    map[key]['ordAmt']=Ord_Tot_Ammount.toFixed(2);
			    map[key]['totVat']=Ord_Tot_vatAmmount.toFixed(2);
			    map[key]['totDis']=Ord_Tot_disAmmount.toFixed(2);
			    map[key]['invNo']=$("#invNo").val();
			   
		});
			 $(".tot_dist_amt").html(""+Ord_Tot_disAmmount.toFixed(2)+"");
		     $(".tot_vat_amt").html(""+Ord_Tot_vatAmmount.toFixed(2)+"");
			 $(".tot_amt").html(""+Ord_Tot_Ammount.toFixed(2)+"");
			  $(".tot_amt_wt_V_Dis").html(""+Ord_Tot_Amt_Wt_Vat_Dis.toFixed(2)+"");
	};
	}
	function removerow(val1) {
		var buttonId = val1;
		removeObjFromMap(val1);
		$("#tr" + buttonId).remove();
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
	function getSheetPrice(){
		
		if($('#piId').val()!=""){
			var pr=$('#pr').val();
			var qps=$('#qPS').val();
			var nos=$('#noOfS').val();
			var dlprice=$('#dlP').val();
			 $('#pPS').val((qps*pr).toFixed(2));
			$('#qntty').val(nos*qps);
			$('#dlPPS').val((dlprice*qps).toFixed(2));
		}
	}

	function getPrice(){
		var nos=$('#noOfS').val();
		var qps=$('#qPS').val();
		var pps=$('#pPS').val();
		var pr=($('#pr').val());
		var piid=$('#piId').val();
		var dlprice=($('#dlP').val());
		if(nos!="" && qps!=""){
			$('#qntty').val((nos*qps));
			if(pps!="" && piid==""){
				$('#pr').val((pps/qps).toFixed(2));
			}else if(piid!=""){
				$('#pPS').val((qps*pr).toFixed(2));
				$('#qntty').val(nos*qps);
				$('#dlPPS').val((dlprice*qps).toFixed(2));
			}
		}
	}

	function getDlPrice(){
		var qps=$('#qPS').val();
		var dlpp=$('#dlPPS').val();
		if(qps!="" && dlpp!=""){
			$('#dlP').val((dlpp/qps));
		}
	}
	function doCal(){
		if($('#piId').val()!=""){
			getSheetPrice();
		}else{
			getPrice();
			getDlPrice();
		}
	
	}
</script>
</head>
<body>
	<div class="purchase_container">
		<jsp:include page="/WEB-INF/views/general/ajaxpopup.jsp"></jsp:include>
		<div class="purchaseEntryForm" style="float: left;">
			<h3>Medical Purchase Stock Entry Form</h3>
			<div class="BranchDetails">
				&nbsp;Organization :${organization},&nbsp;&nbsp;&nbsp; Branch :<span
					class="branch"></span>
			</div>
			<div class="purchaseStock">
				<div class="wrapper">
					<form:form method="POST" commandName="command">
						<%--<div><input type="button"  onClick="window.print()" value="Print This Page"/></div> --%>
						<div id="msg"></div>
						<div class="valueBoxes">

							<form:input path="productInventoryBean.id" id="piId"
								readonly="true" hidden="true" placeholder="Prod inv id" />
							<form:input path="productInventoryBean.productBean.id" id="pId"
								readonly="true" hidden="true" placeholder="Product id" />
							<form:input path="productInventoryBean.agencyBean.id" id="ageId"
								readonly="true" hidden="true" placeholder="agency id" />

							<%-- 	<div>
							<form:label path="">Organization</form:label>
							<form:input path="" value="${organization}" />
						</div>--%>
							<div class="agencySelection">
								<form:label path="productInventoryBean.agencyBean.agencyName">Agency Name</form:label>
								<form:input path="productInventoryBean.agencyBean.agencyName"
									id="ageName1" class="names" value="" disabled="true"
									data-value="" />
								<form:errors path="productInventoryBean.agencyBean.agencyName"
									cssClass="error" />
							</div>
							<div>
								<form:label path="productInventoryBean.branchBean.id">Branch</form:label>
								<form:select path="productInventoryBean.branchBean.id" id="brId">
									<form:option value="${branchId}">${branch}</form:option>
									<form:options items="${branches}" />
								</form:select>
								<form:errors path="productInventoryBean.branchBean.id"
									cssClass="error" />
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
								<form:errors
									path="productInventoryBean.productBean.categoryBean.id"
									cssClass="error" />
							</div>
							<div>
								<form:label path="productInventoryBean.batchNo">Batch No</form:label>
								<form:input path="productInventoryBean.batchNo" id="batNo"
									class="uppercase" onblur="validateBatchNo(${createdby})" />
								<form:errors path="productInventoryBean.batchNo"
									cssClass="error" />
							</div>

							<div>
								<form:label path="productInventoryBean.productBean.name">Product Name</form:label>
								<form:input path="productInventoryBean.productBean.name"
									id="pName" />
								<form:errors path="productInventoryBean.productBean.name"
									cssClass="error" />
							</div>

							<div>
								<form:label path="productInventoryBean.productBean.mFCompanay">MFC</form:label>
								<form:input path="productInventoryBean.productBean.mFCompanay"
									id="mFC" />
								<form:errors path="productInventoryBean.productBean.mFCompanay"
									cssClass="error" />
							</div>
							<div>
								<form:label path="productInventoryBean.productBean.schDrug">SCH</form:label>
								<form:select path="productInventoryBean.productBean.schDrug"
									id="schD">
									<form:option value="Y">Y</form:option>
									<form:option value="N">N</form:option>
								</form:select>
								<form:errors path="productInventoryBean.productBean.schDrug"
									cssClass="error" />
							</div>
							<div>
								<form:label
									path="productInventoryBean.productBean.subCategoryBean">Sub Category</form:label>
								<form:select
									path="productInventoryBean.productBean.subCategoryBean"
									id="sCatId">
									<form:options items="${categories}" />
								</form:select>
								<form:errors
									path="productInventoryBean.productBean.subCategoryBean"
									cssClass="error" />
							</div>
							<div id="tab1">
								<form:label path="productInventoryBean.noOfstrips">Strips</form:label>
								<form:input path="productInventoryBean.noOfstrips" id="noOfS"
									onblur="getSheetPrice();" cssClass="number" />
								<span class="errmsg" id="noOfstrips"></span>
							</div>
							<div id="tab2">
								<form:label path="productInventoryBean.quantityPerStrip">Quantity Per Strip</form:label>
								<form:input path="productInventoryBean.quantityPerStrip"
									id="qPS" onchange="getSheetPrice();" cssClass="number" />
								<span class="errmsg" id="quantityPerStrip"></span>
							</div>

							<div id="tab3">
								<form:label path="productInventoryBean.dlPricePerstrip">DL Strip Price</form:label>
								<form:input path="productInventoryBean.dlPricePerstrip"
									id="dlPPS" onblur="" cssClass="double" />
								<span class="errmsg" id="dlPricePerstrip"></span>
							</div>
							<div id="tab4">
								<form:label path="productInventoryBean.pricePerStrip">Price Per Strip</form:label>
								<form:input path="productInventoryBean.pricePerStrip" id="pPS"
									onblur="" cssClass="double" />
								<span class="errmsg" id="pricePerStrip"></span>
							</div>
							<div>
								<form:label path="productInventoryBean.dlPrice">Dealer Price</form:label>
								<form:input path="productInventoryBean.dlPrice" id="dlP"
									cssClass="double" />
								<span class="errmsg" id="dlPrice"></span>
							</div>
							<div>
								<form:label path="productInventoryBean.price">Price</form:label>
								<form:input path="productInventoryBean.price" id="pr"
									cssClass="double" />
								<span class="errmsg" id="price"></span>
							</div>
							<div>
								<form:label path="productInventoryBean.quantity">Quantity</form:label>
								<form:input path="productInventoryBean.quantity" id="qntty"
									cssClass="number" />
								<span class="errmsg" id="quantity"></span>
							</div>
							<div>
								<form:label path="discount">Discount %</form:label>
								<form:input path="discount" id="dis" cssClass="double" />
								<span class="errmsg" id="discount"></span>
							</div>
							<div>
								<form:label path="vat">Vat %</form:label>
								<form:input path="vat" id="vat" cssClass="double" />
								<span class="errmsg" id="vat"></span>
							</div>
							<%--<div>
							<form:label path="vat">Vat </form:label>
							<form:select path="vat" id="vat">
								<form:option value="14.5">14.5%</form:option>
								<form:option value="5">5%</form:option>
							</form:select>
						</div>--%>
							<div>
								<form:label path="productInventoryBean.freeQuantity">Free Quantity</form:label>
								<form:input path="productInventoryBean.freeQuantity" id="fQntty"
									cssClass="number" />
								<span class="errmsg" id="freeQuantity"></span>
							</div>
							<div>
								<form:label path="expiryDate">Expiry Date</form:label>
								<form:input path="expiryDate" id="expD" />
								<form:errors path="expiryDate" cssClass="error" />
							</div>
							<div class="addDiv">
								<input type="button" value="ADD" class="addButton" />
							</div>

						</div>



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
										<th class="main">Free Qty</th>
										<th class="main">MFC</th>
										<th class="main">Batch No</th>
										<th class="main">Exp Date</th>
										<th class="main">M.R.P</th>
										<th class="main">Rate</th>
										<th class="main">Dis %</th>
										<th class="main">Vat %</th>
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

.wrap .foot .inv table td{
	text-align: center;
	vertical-align: middle;
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
											<td class="inv">
												<table>
													<tr>
														<td>Invoice No:</td>
														<td><input type="text" id="invNo" class="uppercase" /></td>
													</tr>
													<tr>
														<td>Overall<br>Discount:
														</td>
														<td><input type="text" id="oDisc" class="double" /></td>
													</tr>
												</table>
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
														<td class="empty"></td>
													</tr>
													<tr>
														<th class="amt_caption">Total Dis(-)</th>
														<td class="tot_dist_amt"></td>
														<td class="empty"></td>
													</tr>
													<tr>
														<th class="amt_caption">Total Vat(+)</th>
														<td class="tot_vat_amt"></td>
														<td class="empty"></td>
													</tr>
													<tr>
														<th class="amt_caption">Amnt includes Total Amt :</th>
														<td class="tot_amt"></td>
														<td class="empty"></td>
													</tr>

												</table>
											</td>
										<tr>
									</table>
								</div>
							</div>

						</div>
						<div>
							<input type="button" id="submit" value="SUBMIT" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>