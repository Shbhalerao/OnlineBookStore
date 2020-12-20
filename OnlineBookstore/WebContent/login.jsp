         <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>login</title>
<script type="text/javascript">
function validate()
{
	
	var uemailId =document.getElementById("emailId").value;
	var upassword=document.getElementById("password").value;
	if(uemailId==""){
		document.getElementById("eemailId").innerHTML="please enter email Id";
		return false;
	    }
	else
		{
		document.getElementById("eemailId").innerHTML=" ";
		}
	if(upassword==""){
		document.getElementById("epassword").innerHTML="please enter password";
		return false;
	    }
	else
		{
		document.getElementById("epassword").innerHTML=" ";
		}
return true;
}



</script>
</head>
<body><center>
 <jsp:include page="header.jsp"></jsp:include>

<form onsubmit="return validate()" action="LoginServlet" method="post" >
<h1><u><b>login Page</b></u></h1>
<table border="1" cellpading="3">
 <tr>
<th><input type="" name=""></th>
<th>
<select name="type">
<option value="admin">Admin</option>
<option value="user">User</option>
</select>
</th>
</tr> 


<tr>
<th>Email Id</th>
<th><input id="emailId" type="text" name="emailId" ></th>
<td><span id="eemailId" style="color:red" ></span></td>
</tr>


<tr>
<th>Password</th>
<th><input id="password" type="text" name="password"></th>
<td><span id="epassword" style="color:red" ></span></td>
</tr>

<tr>
<th><input type="Reset" value="clear" class="btn btn-danger"></th>
<th><input type="submit" value="login" name="action" class="btn btn-danger"></th>
</tr>

</table>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include></center>
</body>
</html>