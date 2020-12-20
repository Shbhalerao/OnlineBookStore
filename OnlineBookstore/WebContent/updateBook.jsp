
<%@ page import="com.onlinebookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>add detail</title>


<script type="text/javascript">

$(document).ready(function()
{
//alert("naina");
$.ajax({
	url:"BookServlet?action=getCategory",
	type:"get",
	dataType:"json",
	success:function(responseJson){
		
		
		if(responseJson!=null){
			$.each(responseJson,function(index,obj){
			if(obj!=null){
			//alert("hiii");
			$("#category").append(
				
				'<option value="'+obj.category+'">'
				+ obj.category + '</option>');
		}
			
		
	});
			
		}}
	});
		
		
	

});





$(document).ready(function()
{
$.ajax({
	url:"BookServlet?action=getPublisher",
	type:"get",
	dataType:"json",
	success:function(responseJson){
		
		if(responseJson!=null){
			$.each(responseJson,function(index,obj){
			if(obj!=null){
			//alert("hiii");
			$("#publisher").append(
				
				'<option value="'+obj.publisher+'">'
				+ obj.publisher+ '</option>');
				
			}
			
			
			});
					
				}}
			});
				
				
			

		});

 
</script>
<script type="text/javascript"> 
function validate(){
	var bid=document.getElementById("bookId").value;
	var bname =document.getElementById("bookName").value;
	var bprice =document.getElementById("price").value;
	var bauthor =document.getElementById("author").value;
	var bdesc =document.getElementById("bookDesc").value;
	var bquantity =document.getElementById("quantity").value;

	if(bid==""){
		document.getElementById("ebookid").innerHTML="please enter book id";
		return false;
	    }
	else
		{
		document.getElementById("ebookid").innerHTML=" ";
		}
	
	
	if(bname==""){
		document.getElementById("ebookName").innerHTML="please enter book name";
		return false;
	    }
	else
		{
		document.getElementById("ebookName").innerHTML=" ";
		}
	
	
	
	if(bprice==""){
		document.getElementById("eprice").innerHTML="please enter book price";
		return false;
	}
	else
		{
		document.getElementById("eprice").innerHTML=" ";
		}
	
	if(bauthor==""){
		document.getElementById("ebookAuthor").innerHTML="please enter book author name";
		return false;
	    }
	else
		{
		document.getElementById("ebookAuthor").innerHTML=" ";
		}
	
	if(bdesc==""){
		document.getElementById("ebookdesc").innerHTML="please enter book description";
		return false;
	    }
	else
		{
		document.getElementById("ebookdesc").innerHTML=" ";
		}
	
	if(bquantity==""){
		document.getElementById("ebookquantity").innerHTML="please enter book quantity";
		return false;
	    }
	else
		{
		document.getElementById("ebookquantity").innerHTML=" ";
		}
	
	
	
	
	return true;
}
</script>
</head>
<body><center>
 <jsp:include page="header.jsp"></jsp:include>

<form onsubmit="return validate()" action="BookServlet" method="post" enctype="multipart/form-data">

<h1><b>Add Book Details</b></h1>
<table border="1" cellpading="3">
<% Book b=(Book)session.getAttribute("bookId"); %>

<tr>
<th>Enter Book id</th>
<th><input id="bookId" type="text" name="bookId" value="<%=b.getBookId()%>"></th>
<td><span id="ebookid" style="color:red" ></span></td>
</tr>

<tr>
<th>Enter Book Name</th>
<th><input id="bookName" type="text" name="bookName"  value="<%=b.getBookName()%>"></th>
<td><span id="ebookName" style="color:red" ></span></td>
</tr>
<tr>
<tr>
<th>Enter Book Price</th>
<th><input  id="price" type="text" name="price"  value="<%=b.getPrice()%>"></th>
<td><span id="eprice" style="color:red" ></span></td>
</tr>
<th>Enter Book Author</th>
<th><input id="author" type="text" name="author"  value="<%=b.getAuthor()%>"></th>
<td><span id="ebookAuthor" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Book Publisher</th>
<th>
<select name="publisher" id="publisher">

</select>
</th>
</tr>
<tr>
<th>Enter Book description</th>
<th><input id="bookDesc" type="text" name="bookdesc"></th>
<td><span id="ebookdesc" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Book Category</th>
<th><select name="category" id="category">

</select></th>
</tr>


<tr>
<th>Enter Book Quantity</th>
<th><input id="quantity" type="text" name="quantity"  value="<%=b.getQuantity()%>"></th>
<td><span id="ebookquantity" style="color:red" ></span></td>
</tr>

<tr>
<th><input type="Reset"  value="cancel" ></th>
<th><input type="submit" value="update" name="action"></th>
</tr>

</table>

<jsp:include page="footer.jsp"></jsp:include></center>
</body>

</html>