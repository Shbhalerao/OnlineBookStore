<%@page import="com.onlinebookstore.pojo.Cart"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
<center>
<form action="MyCartServlet" method="post">
<table border="1">
<tr>
<th>Cart id</th>
<th>Book name </th>
<th>Book price</th>
<th>Book quantity</th>
<th>Action</th>
</tr>

<%-- <%
List<Cart>myCart=(List<Cart>)session.getAttribute("userCart");
if(myCart!=null && myCart.size()>0)
{
	for(int i=0;i<myCart.size();i++)
	{
		Cart c=(Cart)myCart.get(i);
	

%> --%>
<c:forEach var="c" items="${userCart}" >
<tr>
<td>${c.cartId } </td>
<td>${c.bookName}</td>

<td><input type="text" readonly name="price" value="${c.price }"></td>
<td><input type="number" min="1" name="bookQuantity" value="${c.bookQuantity}"></td>
<td><a href="MyCartServlet?action=delete&cartId=${c.cartId }">Delete</a></td>

</tr>
<%-- <%}} %> --%>

</c:forEach>
</table>


<%-- <%if(!myCart.isEmpty()) {%>
<input  type="submit" value="Place Order">
<%} %> --%>

<c:if test="${!usertCart.isEmpty() }">
<input  type="submit" value="Place Order">
</c:if>
</form>
<jsp:include page="footer.jsp"></jsp:include></center>
</center>

</body>
</html>