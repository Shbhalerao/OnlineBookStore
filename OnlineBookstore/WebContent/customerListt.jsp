<%@ page import="com.onlinebookstore.pojo.Customer"%>
<%@ page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body><center>
 <jsp:include page="header.jsp"></jsp:include>
<table border="1">

<tr>
<th> Customer Id</th>
<th> Customer Name</th>
<th> Customer mobile no</th>
<th> Customer Address</th>
<th>Emaild</th>
<th> password</th>
<th colspan="2">Action</th>
</tr>

<%-- <%
 List<Customer> customerList=(List<Customer>)session.getAttribute("Customer");
if(customerList!=null && customerList.size()>0)
{
	for(int i=0;i<customerList.size();i++)
	{
		Customer customer=(Customer)customerList.get(i);
	
%> --%>

 <c:forEach var="c" items="${Customer}" >
<tr>
<td>${c.customerId}</td>
<td>${c.customerName}</td>
<td>${c.mobNo}</td>
<td>${c.address}</td>
<td>${c.emailID}</td>
<td>${c.password}</td>
<td><a href="CustomerServlet?action=delete&id=${c.customerId}">Delete</a></td>
<td><a href="CustomerServlet?action=edit&id=${c.customerId}">Edit</a></td>
</tr>

</c:forEach>
<%-- <%}} %> --%>
</table>
<jsp:include page="footer.jsp"></jsp:include></center>
</body>
</html>