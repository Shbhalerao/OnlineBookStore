<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.onlinebookstore.pojo.Book"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>search</title>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
	type="text/javascript"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryyui/1.7.2/jquery.-ui-min.js"
	type="text/javascript"></script> -->
	
	
	<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function()
		{
	$("table").hide();
	$("button").click(function(e)
		{
		
			e.preventDefault();
	
	var BookName=$("input#bookname").val();
	//alert("Hello!!!"+BookName);
	$.ajax({
		
		url:"BookServlet?action=searchByName&bookname="+BookName,
	    type:"get",
	    data:BookName,
	    dataType:"json",
	    
	    
	    success:function(responseJson)
	    
	    	{
	    	if(responseJson!=null){
	    		//alert("DONE DONE");
	    	
	    	$("tbody").html("");
	    	$.each(responseJson,function(index,obj)
	    		{
	    		
	    		if(obj!=null){
	    			
	    			
	    			$("table").css("display","block");
	    		
	    			$("tbody").append("<tr><td>"+obj.bookId+"</td>"+"<td>"+obj.bookName+"</td>"+"<td>"+obj.price+"</td>"+"<td>"+obj.author+"</td>"+"<td>"+obj.publisher+"</td>"+"<td>"+obj.bookDesc+"</td>"+"<td>"+obj.category+"</td>"+"<td>"+obj.quantity+"</td></tr>");
	    			/* $("tbody").append("<td>"+obj.bookName+"</td>");
	    			$("tbody").append("<td>"+obj.price+"</td>");
	    			$("tbody").append("<td>"+obj.author+"</td>");
	    			$("tbody").append("<td>"+obj.publisher+"</td>");
	    			$("tbody").append("<td>"+obj.bookDesc+"</td>");
	    			$("tbody").append("<td>"+obj.category+"</td>");
	                $("tbody").append("<td>"+obj.quantity+"</td></tr>"); */
	    			}
	    		});
	          }
	
	
	}
	});

	});
});



</script>














</head>

<body>
	<center>
		<jsp:include page="header.jsp"></jsp:include>
		<h1><u><b>Search</b></u></h1>
		
		
		<input type="t" name="bookname" id="bookname">
		<button>search</button>
		<table border="1">
			
			<tbody>
			</tbody>
			
			<thead>
				<tr>

					<td>bookId</td>
					<td>bookName</td>
					<td>price</td>
					<td>author</td>
					<td>publisher</td>
					<td>bookDesc</td>
					<td>category</td>
					<td>quantity</td>
				</tr></thead>
			
		</table>

		<center><jsp:include page="footer.jsp"></jsp:include></center>
</body>

</html>