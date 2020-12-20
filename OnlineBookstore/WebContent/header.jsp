<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Online book store</title>
</head>
<body>
<%--<%
String admin=(String)session.getAttribute("adminId");
String customer=(String)session.getAttribute("customerId");
--%>


<div id="templatemo_menu">
    	<ul>
    	<%--<%
    	if(admin==null && customer==null)
    	{--%>
    	
    	<c:if test="${adminId==null && customerId==null }">
    	    <li><a href="Home.jsp" class="current">Home</a></li>
            <li><a href="search.jsp">Search</a></li>          
            <li><a href="login.jsp">Login</a></li> 
            <li><a href="addCostomer.jsp">Register</a></li>
            
    	</c:if>
    	
    	
    	<%--<%}
    	
    	else if(admin!=null && customer==null)
    	{--%>
    	
    	<c:if test="${adminId!=null && customerId==null }">
    	     <li><a href="Home.jsp" class="current">Home</a></li>
            
             <li><a href="changePassword.jsp">change password</a></li> 
              <li><a href="search.jsp">Search</a></li>  
             <li><a href="CustomerServlet">View Customer</a></li>
              <li><a href="LoginServlet">Logout</a></li>  
             <li><a href="contactUs.jsp">Contact us</a></li>          
             <li><a href="aboutUs.jsp">About us</a></li>
              <li><a href="addBook.jsp">add book</a></li> 
            </c:if>
    	<%--<%}
    	
    	else if(admin==null && customer!=null)
    	{--%>
    	<c:if test="${adminId==null && customerId!=null }">
    	     <li><a href="Home.jsp" class="current">Home</a></li>
             <li><a href="search.jsp">Search</a></li> 
             <li><a href="MyCartServlet">My cart</a></li>           
             <li><a href="contactUs.jsp">Contact us</a></li>          
             <li><a href="aboutUs.jsp">About us</a></li>  
              <li><a href="LoginServlet">Logout</a></li> 
              
               
               </c:if> 
    	<%--<%}
    	
    	--%>
    </ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>15%</span> discounts for
        purchase over Rs.999 
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Edge of time by jean piere harrison</li>
                <li>Saraswati Park by Anjali Joseph</li>
                <li>beyond the Lines by Kuldip Nayar</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
</body>
</html>