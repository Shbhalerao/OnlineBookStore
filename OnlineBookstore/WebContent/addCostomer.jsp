<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>add detail</title>
<script type="text/javascript">


function validate(){
	var cname =document.getElementById("customerName").value;
	var cmobileno =document.getElementById("mobNo").value;
	var caddress =document.getElementById("address").value;
	var cemailId =document.getElementById("emailId").value;
	var cpassword=document.getElementById("password").value;
	if(cname==""){
		document.getElementById("ecustomerName").innerHTML="please enter customer name";
		return false;
	    }
	else
		{
		document.getElementById("ecustomerName").innerHTML=" ";
		}
	
		
		if(isNaN(cmobileno))
			{
			document.getElementById("ecustomermobileno").innerHTML="please enter valid customer mobile no ";
			
		
		
		return false;
	    }
	else
		{
		document.getElementById("ecustomermobileno").innerHTML=" ";
		}
	if(caddress==""){
		document.getElementById("ecustomeraddress").innerHTML="please enter customer address";
		return false;
	    }
	else
		{
		document.getElementById("ecustomeraddress").innerHTML=" ";
		}
	if(cemailId=="")
		//if(cemailId.indexOf("@")||cemailId.indexOf(".")<cemailId.indexOf("@")+2||cemailId.indexOf(".")+2>=cemailId.length)
		{
			
			document.getElementById("ecustomeremailId").innerHTML="please enter customer email Id";
		
		return false;
	    }
	else
		{
		document.getElementById("ecustomeremailId").innerHTML=" ";
		}
	if(cpassword==""){
		document.getElementById("ecustomerpassword").innerHTML="please enter customer password";
		return false;
	    }
	else
		{
		document.getElementById("ecustomerpassword").innerHTML=" ";
		}
return true;}
</script>
</head>
<body><center>
 <jsp:include page="header.jsp"></jsp:include>
<div align="center">
<form  onsubmit="return validate()" action="CustomerServlet" method="post" >
<h1><b>Add Customer Details</b></h1>
<table border="1" cellpading="3">
<tr>
<th>Enter Customer Name</th>
<th><input id="customerName" type="text" name="customerName"></th>
<td><span id="ecustomerName" style="color:red" ></span></td>
</tr>
<tr>
<tr>
<th>Enter Customer Mobile number </th>
<th><input id="mobNo" type="text" name="mobNo" maxlength="10"></th>
<td><span id="ecustomermobileno" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Customer Address</th>
<th><input id="address" rows="4" cols="4"></th>
<td><span id="ecustomeraddress" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Customer Email Id </th>
<th><input id="emailId" type="text" name="emailId"></th>
<td><span id="ecustomeremailId" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Customer Password</th>
<th><input id="password" type="password" name="password"></th>
<td><span id="ecustomerpassword" style="color:red" ></span></td>
</tr>
<tr>
<th><input type="Reset" value="cancel" ></th>
<th><input type="submit" value="add" name="action"></th>
</tr>
</th>
</tr>

</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</center>
</body>
</html>