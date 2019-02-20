<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <script>
         function validatePass(password, cmpwd) {
    //alert("Cs")
    if (password.value != cmpwd.value || password.value == '' || cmpwd.value == '') {
        //cmpwd.setCustomValidity('Password incorrect');
        alert("Password Incorrect");
        cmpwd.setCustomValidity('Password incorrect');
    } else {
        cmpwd.setCustomValidity('');
    }
}

function passwordStrength(password)
{
	var desc = new Array();
	desc[0] = "Very Weak";
	desc[1] = "Weak";
	desc[2] = "Better";
	desc[3] = "Medium";
	desc[4] = "Strong";
	desc[5] = "Strongest";

	var score   = 0;

	//if password bigger than 6 give 1 point
	if (password.length > 6) score++;

	//if password has both lower and uppercase characters give 1 point	
	if ( ( password.match(/[a-z]/) ) && ( password.match(/[A-Z]/) ) ) score++;

	//if password has at least one number give 1 point
	if (password.match(/\d+/)) score++;

	//if password has at least one special caracther give 1 point
	if ( password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/) )	score++;

	//if password bigger than 12 give another 1 point
	if (password.length > 12) score++;

	 document.getElementById("passwordDescription").innerHTML = desc[score];
         
	 document.getElementById("passwordStrength").className = "strength" + score;
}

function passchk()
{
    if(document.getElementById("passwordDescription").innerHTML != "Strongest")
{
    if(document.getElementById("passwordDescription").innerHTML != "Strong")
    {
    alert("Please change your password as strong");
    return false;  
}
}
return true;
}
</script>
         <style>
             #pwd{
                 color: #000;
                 
                 
             }
         </style>
         <style>
     #passwordStrength
{
	height:10px;
	display:block;
	
}

.strength0
{
    margin-left: 5%;
	width:240px;
	background:#cccccc;
}

.strength1
{
    margin-left: 5%;
	width:50px;
	background:#ff0000;
}

.strength2
{
        margin-left: 5%;    
        width:100px;	
	background:#ff5f5f;
}

.strength3
{
    margin-left: 5%;
	width:150px;
	background:#56e500;
}

.strength4
{
    margin-left: 5%;
	background:#4dcd00;
	width:200px;
}

.strength5
{
    margin-left: 5%;
	background:#399800;
	width:250px;
}
#pwdheader{
color: white;
background-color: #777;
margin-top: 0px;
font-weight: bold;
font-size: 20px;

}
#pwd h3{
color: green;

}
 </style>
    </head>
    <body>
        
        <h3 ><font color="orange"></font></h3>
        <div id="pwd">
       
            <form:form name="chapwd" method="POST" action="changepwd" style="border: 7px #777 solid; width: 40%;margin-left: 20%;background-image:url(images/background2.gif);" onsubmit="return passchk()">
             <div id="pwdheader">Change Password</div>
            <table  align="center">
            <tr>
                <td><h3><c:out value="${Logger.username}"/></h3>
                    </td>
            
                
            </tr>
            <tr>
            <td><form:label path="password">Old Password</form:label></td>
			        <td><form:input path="password" value="${Logger.password}" readonly="true" id="pwd"/></td>
            
            </tr>
            <tr>
            
            <td><form:label path="password">New Password</form:label></td>
			        <td><form:input path="password"  id="newpassword" onkeyup="passwordStrength(this.value);"/></td>
            
            </tr>
          

                
            <tr><td><tr><td>Password Strength:</td><td style="width: 300px"> <div id="passwordDescription">&nbsp;&nbsp;&nbsp;Password not entered</div>
                
			<div id="passwordStrength" class="strength0"></div>
		</td></tr></td></tr>
            <tr>
            
             <td><form:label path="confirmpassword">Confirm Password</form:label></td>
			        <td><form:input path="confirmpassword" name="cmpwd" id="cmpwd" onblur="validatePass(document.getElementById('newpassword'), cmpwd);"/></td>
             </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit">
                    
                </td>
            </tr>
        </table>
            </form:form></div>   
    </body>
</html>
