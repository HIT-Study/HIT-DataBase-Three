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
				<!-- <tr>
						<th>orderNo</th>
						<th>CustomerNo</th>
						<th>employeeNo</th>
						<th>orderDate</th>
						<th>orderSum</th>
						<th>invoiceNo</th>
						<th>删除</th>
				</tr> -->
	
		<c:forEach var="smallList" items="${bigList}" step="1">
		
				<c:forEach var="object" items="${smallList}" step="1">
			
				<form action="<%=path %>/deleteOrder.do" method="post" >
				<tr>
						<%-- 	<td>${object.orderno}</td>
							<td>${object.customerno}</td>
							<td>${object.employeeno}</td>
							<td>${object.orderdate}</td>
							<td>${object.ordersum}</td>
							<td>${object.invoiceno}</td> --%>
							<%-- <input type="hidden" name="orderno" value="${object.orderno}">
							<td> <input type="submit" value="删除"> </td>  --%>
							${object }
				</tr>
				</form>
				</c:forEach> 
		</c:forEach>
		</table>   
		</div>
         
  </body>
</html>
