function addDoctor()
{
var data= $("#RegisterDoctor").serialize();
alert(data);
$("#RegisterDoctor").get(0).reset();

$.post('addDoctor.html?flag=0', data, function(result){
	alert(result);
	$(".col2").html(result);
	//clearVals();

//$('#msg').html(obj.model.msg).css("color", "orange");
});
//$("#msg").css("width", "200px");

}

function clearVals(){
	 $('#dname').val('');
	$('#add').val('');
		$('#phno').val('');
		$('#email').val('');
		$('#qualification').val('');
		$('#specialization').val('');
		$('#hname').val('');
		$('#sex').val('');
	
}


$(document).ready(function() {
	
$('#RegisterDoctor').submit(function(){
	 if($('#dname').val()==""){alert('Please fill the doctors name');$('#dname').focus();return false;}
		if($('#add').val()==""){alert('Please fill the doctor address');$('#add').focus();return false;}
		if($('#phno').val()== ""){alert("Please enter your mobile number");$('#phno').focus().css("borderColor","red");return false;}
	     else{if($('#phno').val().length < 10 || $('#phno').val().length > 15){alert(" Your Mobile Number must between 10 to 15 Integers");$('#phno').focus().css("borderColor","red");return false;}}
		if($('#email').val()==""){alert('Please fill the doctor email');$('#email').focus();return false;}
		if($('#qualification').val()==""){alert('Please fill the doctor qualification');$('#qualification').focus();return false;}
		if($('#specialization').val()==""){alert('Please fill the doctor specialization');$('#specialization').focus();return false;}
		if($('#hname').val()==""){alert('Please fill the Hospital Name');$('#hname').focus();return false;}
		if($('#init').val()==""){alert('Please fill the Initial');$('#init').focus();return false;}
		if($('#sex').val()== ""){alert("Please enter your gender type");$('#sex').focus();return false;}
        $(this).find('input:text').each(function(){
        	
        //	alert($.trim($(this).val()));
              $(this).val($.trim($(this).val()));
        });
  });

$('#init').change(function(e) {
    var sex;
    //alert(this.value);
      if(this.value == "Mr"){sex="Male";}
      else if(this.value=="Mrs"){sex="Female";}
      else if(this.value=="Other"){sex="Other";}
      else{sex="";}
      $('#sex').val(sex);
      alert($('#sex').val());
  });
  
	
$('#dname').change(function(e) {
	var dname=$('#dname').val();
	var id=$('#createdBy').val();
	var data=null;
	alert(dname);
	$.post('validateDoctor.html?doctorName='+dname+'&uid='+id, data, function(result){	
		//alert(result);
		if(result!="enable3"){
			$('#msg').html(""+result+" doctor already existed").css("color","white").css("font-weight","bold");
			$('#dname').val("").focus();
		}else{
			
			$('#add').focus();
			$('#msg').html("");
		}
	});
	
});
	
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
$('.numbers').keyup(function(e) {
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

/*$('.phno').change(function(e) {
	var a= this.value;
	if(isNaN(a) || 15<a.length || a.length<10){
		alert("enter valid phno\nLength should be between 10-15");
	//	$(this).val("").css("background-color", "orange").focus();
		$(this).val("").focus();
	}
});*/
$('.email').change(function(e) {  
	   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
 //   var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
if (!reg.test(this.value)) 
{
 alert('Invalid Email Address');
 var a ="";

	$('#email').val(a);
	$('#email').focus();

 return false;
}

return true;

	
});
		
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
	
});