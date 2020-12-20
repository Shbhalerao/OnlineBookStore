<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head> 
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />      
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<%-- <%String success=(String)request.getAttribute("success");
out.print(success);
%> --%>

 ${success }
<%RequestDispatcher rd=request.getRequestDispatcher("BookServlet");
rd.forward(request, response); %>
</body>
</html>