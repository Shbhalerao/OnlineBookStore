<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.onlinebookstore.pojo.Book"%>
<%@ page import="java.util.List"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, CSS Website Layout</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<script
	src="js/jquery.min.js"></script>

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
	type="text/javascript"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryyui/1.7.2/jquery.-ui-min.js"
	type="text/javascript"></script> -->
<script  src="js/app.ajax.js"   type="text/javascript"></script>


<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
	 <jsp:include page="header.jsp"></jsp:include>
	<%-- <%
String admin=(String)session.getAttribute("adminId");
String customer=(String)session.getAttribute("customerId");

String success=(String)request.getAttribute("success");
if(success!=null)
{
	out.print(success);}

--%>
<div style="color:red;">

	 ${success }
	 </div>
    <div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<jsp:include page="SlideBar.jsp"></jsp:include>
                  
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
			</div> 
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right">
      <%--  <%
        
        List<Book> bookList=(List<Book>)session.getAttribute("Book");
        if(bookList!=null && bookList.size()>0)
        {
        	for(int i=0;i<bookList.size();i++)
        	{
        		Book book=(Book)bookList.get(i);
        	
        if(i%2==0){
        
        
        --%>
        
        
           <c:forEach var="b" items="${Book}" >
           
           
        	<div class="templatemo_product_box">
            	<h1>${b.bookName}<span> by ${b.author}</span></h1>
       	    <img src="images/${b.filename}" alt="image" width="100" height="100" />
                <div class="product_info">
                	<p>${b.bookDesc} </p>
                	
                  <h3>Rs${b.price}</h3>

                 <%--<%
                 if(admin==null && customer!=null){
                  --%> 
                  <c:if test="${adminId==null && customerId!=null }">
                  <div class="buy_now_button"><a href="MyCartServlet?action=addToCart&bookId=${ b.bookId}">Add to cart</a></div>
                  <div><button value="${b.bookId }" id="countrycode">Details</button></div>
              </c:if>
              
              <%--<%} --%>
               <%--<%
               if(admin!=null && customer==null){
            	--%>  
            	<c:if test="${adminId!=null && customerId==null }">
                  <div class="detail_button"><a href="BookServlet?action=delete&id=${b.bookId }">Delete</a></div>
               <div class="detail_button"><a href="BookServlet?action=edit&id=${b.bookId }">Edit</a></div>
              
              </c:if>
                <%--<%} --%>  
                  
                 
               
               
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            
              <%--<%}else{ --%>
         <!--    <div class="cleaner_with_width">&nbsp;</div> -->
            
          
            
            <%--  <div class="templatemo_product_box">
           <h1>${b.bookName} <span>  by  ${b.author}</span></h1>

       	    <img src="images/${b.filename}" alt="image" width="100" height="100" />
                <div class="product_info">
                	<p>${b.bookDesc }</p>
                	
                  <h3>Rs${b.price}</h3>
                   <%
                 if(admin==null && customer!=null){
                  
                      
                  <c:if test="${adminId==null && customerId!=null }">
                  <div class="buy_now_button"><a href="MyCartServlet?action=addToCart&bookId=${ b.bookId}">Add to cart</a></div>
                  <div><button value="${b.bookId }" id="countrycode">Details</button></div>
              </c:if>
              <%}
               <%
               if(admin!=null && customer==null){
            	  
                  <c:if test="${adminId!=null && customerId==null }">
                   <div class="detail_button"><a href="BookServlet?action=delete&id=${b.bookId }">Delete</a></div>
               <div class="detail_button"><a href="BookServlet?action=edit&id=${b.bookId }">Edit</a></div>
              </c:if>
              
               <%}  
                  
                 
               
                </div>
                
               
                <div class="cleaner">&nbsp;</div>
            </div> --%>
              </c:forEach>             
             <%--<%}}}--%>
            <div class="cleaner_with_height">&nbsp;</div>
            
            
            
            
           
            
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    <jsp:include page="footer.jsp"></jsp:include>
    
<!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>
