<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>change login</title>
<script type="text/javascript">

function validate()
{
	
	var uemailId =document.getElementById("emailId").value;
	var uoldpassword=document.getElementById("password").value;
	var unewpassword=document.getElementById("newpassword").value;
	var uconfirmpassword=document.getElementById("newpassword").value;
	
	
	if(uemailId=="")
	   {
		document.getElementById("eemailId").innerHTML="please enter email Id";
		return false;
	    }
	else
		{
		document.getElementById("eemailId").innerHTML=" ";
		}
	if(uoldpassword==""){
		document.getElementById("epassword").innerHTML="please enter old password";
		return false;
	    }
	else
		{
		document.getElementById("epassword").innerHTML=" ";
		}
	
	if(unewpassword==""){
		document.getElementById("newpassword").innerHTML="please enter new password";
		return false;
	    }
	else
		{
		document.getElementById("enewpassword").innerHTML=" ";
		}
	
	if(uconfirmpassword==""){
		document.getElementById("econfirmpassword").innerHTML="please enter password same password";
		return false;
	    }
	else
		{
		document.getElementById("econfirmpassword").innerHTML=" ";
		}
return true;
}





</script>
</head>
<body><center>
 <jsp:include page="header.jsp"></jsp:include>
<div align="center">
<form onsubmit="return validate()" action="LoginServlet" method="post" >
<h1><u><b>login Page</b></u></h1>
<table border="1" cellpading="3">

<tr>
<th> Admin Email Id</th>
<th><input id="emailId" type="text" name="emailId" value="${adminId}" readonly="readonly"></th>
<td><span id="eemailId" style="color:red" ></span></td>
</tr>

<tr>
<th> old password</th>
<th><input id="password" type="text" name="password"></th>
<td><span id="epassword" style="color:red" ></span></td>
</tr>

<tr>
<th> new password</th>
<th><input id="newpassword" type="text" name="newpassword"></th>
<td><span id="enewpassword" style="color:red" ></span></td>
</tr>

<tr>
<th> confirm password</th>
<th><input id="newpassword" type="text" name="newpassword"></th>
<td><span id="econfirmpassword1" style="color:red" ></span></td>
</tr>


<tr>
<th><input type="Reset" value="Reset" ></th>
<th><input type="submit" value="changepassword" name="action"></th>
</tr>

</table>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include></center>

</body>
</html>