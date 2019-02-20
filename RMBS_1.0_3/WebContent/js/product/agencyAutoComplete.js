$(document).ready(function() {
/*$('#ageName').autocomplete({
		//source: '${pageContext. request. contextPath}/get_medical_agency_list.html',
		
			source: function (request, response) {
				//alert(request.term);
				var val=request.term;
				//var msg={"displaymsg":"Trying to display ajencies ... Please Wait...."};
				//	loadAjaxPopup(msg); 	
			
		        $.getJSON('${pageContext. request. contextPath}/get_purchase_medical_agency_list.html', {
		            term: val,
		       
		        }, response);
		    	
		      //   alert(response);
		      // disableAjaxPopup();
		    },
		    
		 		select: function( event, ui ) {
		 			
					 selectedObj = ui.item;
					// alert('event'+selectedObj.value);
					 //alert("selected object=" + selectedObj.value);
		            $( '#tags' ).val( ui.item.label );
		            
		            $( '#ageName' ).val( ui.item.value );
		            myArray= ui.item.value.split("-");
		            $( '#ageId' ).val( myArray[1] );
		            $( '#ageName' ).val( myArray[0] );
		           // alert(myArray);
		            return false;
		        },
		    focus: function( event, ui ) {
		            $( '#tags' ).val( ui.item.label );
		           // alert(ui.item.label);
		            return false;
		        },
		    change: function(event, ui) {
		        if (!ui.item) {
		            $('#tags').val("");
		           $('#ageName').val("");
		            $('#ageId').val("");
		        }
		    }
		});*/
	
	formReset();
});
	function formReset(){
		$("#invNo").val("");
		 $(".tot_dist_amt").html("");
	       $(".tot_vat_amt").html("");
  	   $(".tot_amt").html("");
  	   $(".tot_amt_wt_V_Dis").html("");
  	   $('#vFive').html("");  
  	   $('#vFrtnPF').html("");
  	   
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
	
	
	 $('#schD option').removeAttr("disabled");
	 
    $("#expD").val("");
	 $("#pName").val("");
    $("#noOfS").val("");
    $("#qPS").val("");
    $("#pPS").val("");

    $("#pId").val("");
    $("#batNo").val("");
    $("#dlP").val("");
    $( "#piId" ).val("");
    $("#brId").focus();
  /*  $("#dlprice1").val("").attr("readonly","true");
    $("#quantity1").val("").attr("readonly","true");
    $("#price1").val("").attr("readonly","true");*/

	 $('#tab1').show();
     $('#tab2').show();
	 $('#tab3').show();
	 $('#tab4').show();
	 $('#tab5').show();
	// $('#tab6').show();
	 $("#mFC").removeAttr("readonly");
   // $("#schD").removeAttr("readonly");
	 $("#pr").attr("readonly","true");
    $("#dlP").attr("readonly","true");
    $("#qntty").attr("readonly","true");
    $("#update1").attr("readonly", "true");
    $("#update1").css("display", "none");
    
    $("#submit1").css("display", "block");
	}
