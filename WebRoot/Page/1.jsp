<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Css/myTable.css">


  </head>
  <%
  		List list = (List)request.getSession().getAttribute("list");
  %>
  <body>
  结果如下：
  	<div class="container">
  	<table >
				<tr>
						<th>CustomerNo</th>
						<th>Customer名称</th>
						<th>Customer电话</th>
						<th>Customer地址</th>
						<th>CustomerZip</th>
				</tr>
	
		<c:forEach var="object" items="${list}" step="1">
				<tr>
							<td>${object.customerno}</td>
							<td>${object.customername}</td>
							<td>${object.telephone}</td>
							<td>${object.address}</td>
							<td>${object.zip}</td>
				</tr>
		</c:forEach> 
		</table>   
		</div>
         
  </body>
</html>
