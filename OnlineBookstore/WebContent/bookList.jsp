<%@ page import="com.onlinebookstore.pojo.Book"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body><center>
<%-- <%
String admin=(String)session.getAttribute("adminId");
String customer=(String)session.getAttribute("customerId");
%> --%>
 <jsp:include page="header.jsp"></jsp:include>
<table border="1">
<tr>
<th>BookId</th>
<th>Book Name</th>
<th>Author</th>
<th>Price </th>
<th>Publisher</th>
<th>Category</th>
<th>Book Description</th>
<th>Quantity</th>
<th colspan="3">Action</th>
</tr>


 <%-- <%
 List<Book> bookList=(List<Book>)session.getAttribute("Book");
if(bookList!=null && bookList.size()>0)
{
	for(int i=0;i<bookList.size();i++)
	{
		Book book=(Book)bookList.get(i);
	
%> --%>

 <c:forEach var="b" items="${Book}" >
 
<tr>
<td>${b.bookId}</td>
<td>${b.bookName}</td>
<td>${b.author}</td>
<td>${b.price}</td>
<td>${b.publisher}</td>
<td>${b.category}</td>
<td>${b.bookDesc}</td>
<td>${b.quantity}</td>
<%-- <imp src="image/<%=book.getFileName() %>" width="130" height="130"> --%>

 <%-- <%
    	if(admin!=null && customer==null)
    	{%> --%>
    	
    	<c:if test="${adminId!=null && customerId==null }">
<td><a href="BookServlet?action=delete&id=${b.bookId }">Delete</a></td>
<td><a href="BookServlet?action=edit&id=${b.bookId }">Edit</a></td>
</c:if>
<%-- <%}

 else if(admin==null && customer!=null)
 {%> --%>
<c:if test="${adminId==null && customerId!=null }">
<td><a href="BookServlet?action=addtocart&id=${b.bookId }">AddToCart</a></td>
</c:if>
</tr>
</c:forEach>
<%-- <%}}} %> --%>
</table>
<jsp:include page="footer.jsp"></jsp:include></center>
</body>
</html>