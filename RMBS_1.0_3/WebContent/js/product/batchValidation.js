function validateBatchNo(user)
{
	//alert($("#branchId1").val());
	if($("#brId").val()!=0){
		//$("#branchId : selected").val();
		var data = { bId: $("#brId").val(),batchNo:$("#batNo").val(),type:$("#catId").val(),aId:$( '#ageId' ).val()};
		var bID=data.bId;
		//var data=$("#batchNo"+val+"").val();
		// var type=$("#category1").val();
		if(data!=""){
			alert("branch : "+data.bId+"-batchNo : "+data.batchNo+"-Type : "+data.type+" aid :"+data.aId);
			var msg={"displaymsg":"Validating Batch Number. Please Wait..."};

		//	loadAjaxPopup(msg); 
			$.post('validateBatchNo.html', data, function(result){

			/*	resultHtml="Message "+result.message+"<br>",
				resultHtml+="Branch Id "+$("#brId").val()+"<br>",
				resultHtml+="name "+result.productBean.name+"<br>",
				resultHtml+="pId "+result.productBean.id+"<br>",
				resultHtml+="piid "+result.id+"<br>",
				resultHtml+="category "+result.productBean.categoryBean.category+"<br>",
				resultHtml+="category id "+result.productBean.categoryBean.id+"<br>",
				resultHtml+="MFG "+result.productBean.mFCompanay+"<br>",
				resultHtml+="schDrug "+result.productBean.schDrug+"<br>",
				resultHtml+="Price "+result.productBean.schDrug+"<br>",
				resultHtml+="DlPP "+result.dlPrice+"<br>";
				resultHtml+="AID "+result.agencyBean.id+"<br>";
				resultHtml+="AgencyName "+result.agencyBean.agencyName+"<br>";

				alert(resultHtml);
				//	$('.col1').html(resultHtml);*/
				var genral=11;var gc=8;var mc=7;

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
						//$('#schD').val('Y');
						//$('#sCatId option[value='+genral+']').attr("disabled", "true");
						$('#tab1').show();
						$('#tab2').show();
						$('#tab3').show();
						$('#tab4').show();
						$("#piId").val(result.id);
						$("#pr").val(result.price);
						$("#vat").val("");
						$("#dis").val("");
						$("#vat").attr("readonly", "true");
						$("#dis").attr("readonly", "true");
						
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
							$("#pId").val(result.productBean.id);
							////$("#ageId").val(result.agencyBean.id);
							$("#pName").val(result.productBean.name);
							$("#ageName").val(result.agencyBean.agencyName);
							$("#mFC").val(result.productBean.mFCompanay);
							
							$("#sCatId").val(result.productBean.subCategoryBean.id);
							$("#pName").attr("readonly", "true");
							$("#ageName").attr("readonly", "true");
							$("#mFC").attr("readonly", "true");
							
							$('#sCatId option[value!='+result.productBean.subCategoryBean.id+']').attr("disabled", "true");
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
								$("#mFC").val(result.productBean.mFCompanay);
								$("#mFC").attr("readonly", "true");
							}
							$("#submit1").attr("disabled", "true");
							$("#update1").removeAttr("disabled");
						}
					}else{//IF RETURN BATCH NO IS EMPTY 
						/*	$('#tab5').show();
							$('#tab6').show();*/
						if(jQuery.isEmptyObject(map)){
							$('#brId option').removeAttr("disabled");
							}
						$("#vat").removeAttr("disabled");
						$("#dis").removeAttr("disabled");
						$("#sCatId option").removeAttr("disabled");
						$("#schD option").removeAttr("disabled");
						$("#catId option").removeAttr("disabled");
						
						//$("#branchId1").removeAttr("remove");
						$("#submit1").css("display", "block");
						$("#update1").css("display", "none");
						//	alert("-----"+$("#subcategory1 :selected").text());
						if($("#sCatId :selected").text()!="TABLET"){
							//	if($("#subcategory1").text()!=7){
							$("#piId").val("");
							$("#pId").val("");
							//$("#ageId").val("");
							$("#pName").val("");
							//$("#ageName").val("");
							$('#mFC').val("");
							$("#pr").val("");
							$("#dlP").val("");
							$("#qntty").val("");
							$("#expD").val("");
							$("#ageName").removeAttr("readonly");
							$("#pName").removeAttr("readonly");
					//		$("#sCatId").removeAttr("readonly");
							$("#mFC").removeAttr("readonly");
					//		$("#schD").removeAttr("readonly");
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
							///$('#ageName').focus();
						}else{
							$("#piId").val("");
							$("#pId").val("");
							//$("#ageId").val("");
							$("#pName").val("");
							//$("#ageName").val("");
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
							$('#noOfS').removeAttr("readonly");
							$("#pPS").removeAttr("readonly");
							$("#expD").removeAttr("readonly");
							$("#qPS").removeAttr("readonly");
					//		$("#schD").removeAttr("readonly");
							$("#sCatId").removeAttr("readonly");
							$('#dlPPS').removeAttr("readonly");
							//  $("#subcategory1").attr("readonly","true");
							//  $("#mfcompany1").attr("readonly","true");
							//  $("#quantity1").attr("readonly","true");
							$("#pr").attr("readonly","true");
							$("#dlP").attr("readonly","true");
							$("#qntty").attr("readonly","true");
							$("#submit1").removeAttr("disabled");
							///$('#ageName').focus();
						}
					}
				}else{
					// IF RETURN CATEGORY AS GENERAL
					
					if(result.batchNo!==null){
						$("#submit1").css("display", "none");
						$("#update1").css("display", "block");
						
						$("#schD").val(result.productBean.schDrug);
						$('#schD option[value!='+result.productBean.schDrug+']').attr("disabled", "true");
							
							$('#catId option[value!='+result.productBean.categoryBean.id+']').attr("disabled", "true");
							$("#catId").val(result.productBean.categoryBean.id);
						
						$('#sCatId option').removeAttr("disabled");
						$("#sCatId").val(11);
					//	$('#schD').val('N');
						$('#sCatId option[value!='+genral+']').attr("disabled", "true");
					//	$('#schD option[value!=N]').attr("disabled", "true");
						$('#tab1').hide();
						$('#tab2').hide();
						$('#tab3').hide();
						$('#tab4').hide();
						$("#vat").val("");
						$("#dis").val("");
						$("#vat").attr("readonly", "true");
						$("#dis").attr("readonly", "true");
						$("#piId").val(result.id);
						$("#pr").val(result.price);
						$("#vat").val(result.vat);
					
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
							$("#pId").val(result.productBean.id);
							///$("#ageId").val(result.agencyBean.id);
							$("#pName").val(result.productBean.name);
							$("#ageName").val(result.agencyBean.agencyName);
							$("#mFC").val(result.productBean.mFCompanay);
							$("#schD").val(result.productBean.schDrug);
							$("#sCatId").val(result.productBean.subCategoryBean.id);
							$("#pName").attr("readonly", "true");
							$("#ageName").attr("readonly", "true");
							$("#mFC").attr("readonly", "true");
						//	$("#schD").attr("readonly", "true");
							$('#sCatId option[value!='+result.productBean.subCategoryBean.id+']').attr("disabled", "true");
						//	if(result.productBean.subCategoryBean.subCategory!="TABLET"){
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
						/*	}else{             
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
							}*/
							$("#submit1").attr("disabled", "true");
							$("#update1").removeAttr("disabled");
						}
					}else{//IF RETURN BATCH NO IS EMPTY
						/*	$('#tab5').show();
							$('#tab6').show();*/
						if(jQuery.isEmptyObject(map)){
						$('#brId option').removeAttr("disabled");
						}
						
						$("#sCatId option").removeAttr("disabled");
						
						$("#schD option").removeAttr("disabled");
						$("#catId option").removeAttr("disabled");
						$("#vat").removeAttr("disabled");
						$("#dis").removeAttr("disabled");
						
						$("#submit1").css("display", "block");
						$("#update1").css("display", "none");
						//	alert("-----"+$("#subcategory1 :selected").text());
					//	if($("#sCatId :selected").text()!="TABLET"){
							//	if($("#subcategory1").text()!=7){
							$("#piId").val("");
							$("#pId").val("");
							//$("#ageId").val("");
							$("#pName").val("");
							//$("#ageName").val("");
							$('#mFC').val("");
							$("#pr").val("");
							$("#dlP").val("");
							$("#qntty").val("");
							$("#expD").val("");
							$("#ageName").removeAttr("readonly");
							$("#pName").removeAttr("readonly");
							$("#sCatId").removeAttr("readonly");
							$("#mFC").removeAttr("readonly");
					//		$("#schD").removeAttr("readonly");
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
							//$('#ageName').focus();
					/*	}else{
							$("#piId").val("");
							$("#pId").val("");
							$("#ageId").val("");
							$("#pName").val("");
							$("#ageName").val("");
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
							$("#expD").removeAttr("readonly");
							$("#qPS").removeAttr("readonly");
							$("#schD").removeAttr("readonly");
							$("#sCatId").removeAttr("readonly");
							$('#dlPPS').removeAttr("readonly");
							//  $("#subcategory1").attr("readonly","true");
							//  $("#mfcompany1").attr("readonly","true");
							//  $("#quantity1").attr("readonly","true");
							$("#pr").attr("readonly","true");
							$("#dlP").attr("readonly","true");
							$("#qntty").attr("readonly","true");
							$("#submit1").removeAttr("disabled");
							$('#ageName').focus();
						}*/
					}
					
					
				
					if(result.message!==null){alert(result.message);};
					//  $("#batNo").val("").focus();
				}

			});
		}
	//	disableAjaxPopup();
		//validateSubcategories();
	}else{
		alert("Please Select Branch");
		$("#brId").focus();
	}
}