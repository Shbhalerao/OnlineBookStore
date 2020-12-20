<%@ page import="com.onlinebookstore.pojo.Customer"%>

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
	var cid =document.getElementById("customerId").value;
	var cname =document.getElementById("customerName").value;
	var cmobileno =document.getElementById("mobNo").value;
	var caddress =document.getElementById("address").value;
	var cemailId =document.getElementById("emailId").value;
	var cpassword=document.getElementById("password").value;
	if(cid==""){
		document.getElementById("ecustomerid").innerHTML="please enter customer id";
		return false;
	    }
	else
		{
		document.getElementById("ecustomerid").innerHTML=" ";
		}
	
	
	if(cname==""){
		document.getElementById("ecustomerName").innerHTML="please enter customer name";
		return false;
	    }
	else
		{
		document.getElementById("ecustomerName").innerHTML=" ";
		}
	if(cmobileno==""){
		document.getElementById("ecustomermobileno").innerHTML="please enter customer mobile no ";
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
	if(cemailId==""){
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

<form  onsubmit="return validate()" action="CustomerServlet" method="post" >
<h1><b>Add Customer Details</b></h1>
<table border="1" cellpading="3">
<% Customer c=(Customer)session.getAttribute("custId"); %>

<tr>

<tr>
<th>Enter Customer id</th>
<th><input id="customerId" type="text" name="customerId" value="<%=c.getCustomerId() %>"></th>
<td><span id="ecustomerid" style="color:red" ></span></td>
</tr>

<th>Enter Customer Name</th>
<th><input id="customerName" type="text" name="customerName" value="<%=c.getCustomerName() %>"></th>
<td><span id="ecustomerName" style="color:red" ></span></td>
</tr>
<tr>
<tr>
<th>Enter Customer Mobile number </th>
<th><input id="mobNo" type="text" name="mobNo" value="<%=c.getMobNo() %>"></th>
<td><span id="ecustomermobileno" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Customer Address</th>
<th><input id="address" type="text" name="address" value="<%=c.getAddress() %>"></th>
<td><span id="ecustomeraddress" style="color:red" ></span></td>
</tr>
<tr>  
<th>Enter Customer Email Id </th>
<th><input id="emailId" type="text" name="emailId" value="<%=c.getEmailID() %>"></th>
<td><span id="ecustomeremailId" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Customer Password</th>
<th><input id="password" type="password" name="password" value="<%=c.getPassword() %>"></th>
<td><span id="ecustomerpassword" style="color:red" ></span></td>
</tr>
<tr>
<th><input type="Reset" value="cancel" ></th>
<th><input type="submit" value="update" name="action"></th>
</tr>
</th>
</tr>
 
</table>

<jsp:include page="footer.jsp"></jsp:include></center>
</body>
</html>