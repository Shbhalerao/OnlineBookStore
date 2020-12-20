<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.onlinebookstore.pojo.Book"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<%@ page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Slide bar</title>
</head>
<body>
<div class="templatemo_content_left_section">
            	<h1>Categories</h1>
            	
           <%--  	
         	<%
 List<Book> categoryList=(List<Book>)session.getAttribute("Bookcategory");
if(categoryList!=null && categoryList.size()>0)
{
	for(int i=0;i<categoryList.size();i++)
	{
		Book book=(Book)categoryList.get(i);
	
%>  --%>
            	
          <c:forEach var="s" items="${Bookcategory}" >
                <ul>
                    <li><a href="BookServlet?action=SearchByCategory&category=${s.category }">${s.category }</a></li>
                    
            	</ul>
            	</c:forEach>
            	<%-- <%}} %> --%>
            </div>

			<div class="templatemo_content_left_section">
            	<h1>Publisher</h1>
            		<%-- <%
             List<Book> publisherList=(List<Book>)session.getAttribute("Bookpublisher");
             if(publisherList!=null && publisherList.size()>0)
                {
	              for(int i=0;i<publisherList.size();i++)
	                  {
		               Book book=(Book)publisherList.get(i);
	
%>
            	 --%>
            	 <c:forEach var="p" items="${Bookpublisher}" >
                <ul>
                    <li><a href="BookServlet?action=SearchByPublisher&publisher=${p.publisher }">${p.publisher }</a></li>
                    
            	</ul>
            	</c:forEach>
            	<%-- <%}} %> --%>
            </div>

            

            
</body>
</html>