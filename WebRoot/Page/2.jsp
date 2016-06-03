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
  结果如下，可以修改：
  	<div class="container">
  	<table >
				<tr>
						<th>ProductNo</th>
						<th>Product名称</th>
						<th>ProductClass</th>
						<th>ProductPrice</th>
						<th>inStock</th>
						<th>修改</th>
				</tr>
	
		<c:forEach var="object" items="${list}" step="1">
			<form action="<%=path %>/updateProductTableByone.do" method="post">
				<tr>
					<td><input type="text" name="productno" value="${object.productno}"></td>
				<td>	<input type="text" name="productname" value="${object.productname}"></td>
				<td>	<input type="text" name="productclass" value="${object.productclass}"></td>
				<td>	<input type="text" name="productprice" value="${object.productprice}"></td>
				<td>	<input type="text" name="instock" value="${object.instock}"></td>
						<%-- 
							<td>${object.productno}</td>
							<td>${object.productname}</td>
							<td>${object.productclass}</td>
							<td>${object.productprice}</td>
							<td>${object.instock}</td> --%>
				<td> <input type="submit" value="修改"> </td> 
				</tr>
				</form>
		</c:forEach> 
	
		</table>   
		</div>
         
  </body>
</html>
