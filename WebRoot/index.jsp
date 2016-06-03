<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html >
<head>
<link rel="Shortcut Icon" href="images/bg.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据库实验</title>
<link rel="stylesheet" type="text/css" href="Css/index.css">
<link rel="stylesheet" type="text/css" href="Css/table_set.css">
</head>

<body id="bg">
<div class="web_title">
	<span>哈工大数据库实验3---By 孙鹏</span>
</div>
<div class="container">

	
		<div class="" id="polution_edit_table_set">
				<form action="<%=path %>/selectCustomerTable.do" method="post" accept-charset="utf-8" >
					
					<caption>Customer单表查询</caption>
					<table>
					<tr>		
						<input type="text"   name="table"></input>
					</tr>
					<b>	输入条件</b><br>
						<tr>	customerNo:<input type="text"   name="customerNo"></input></tr>
						<tr>	customerName:<input type="text"   name="customerName"></input></tr>
						<tr>	telephone:<input type="text"   name="telephone"></input></tr>
						<tr>address:<input type="text"   name="address"></input></tr>
						<tr>	zip:<input type="text"   name="zip"></input></tr>
					</table>
					<input id="submit" type="submit" value="查询"></input>
				</form>
			
		</div>
		
		<div class="" id="polution_edit_table_set">
				<form action="<%=path %>/updateProductTable.do" method="post" accept-charset="utf-8" >
					
					<caption>产品单表修改</caption>
					<table>
					<tr>		
						<input type="text"   name="table"></input>
					</tr>
					<!-- <b>	输入条件</b><br>
						<tr>	productNo:<input type="text"   name="customerNo"></input></tr>
						<tr>	productName:<input type="text"   name="customerName"></input></tr>
						<tr>	telephone:<input type="text"   name="telephone"></input></tr>
						<tr>address:<input type="text"   name="address"></input></tr>
						<tr>	zip:<input type="text"   name="zip"></input></tr> -->
					</table>
					<input id="submit" type="submit" value="查询所有并且修改"></input>
				</form>
			
		</div>
		
		
		
		
		<div class="" id="polution_edit_table_set">
				<form action="<%=path %>/selectOrderTable.do" method="post" accept-charset="utf-8" >
					
					<caption>订单删除</caption>
					<table>
					<tr>		
						<input type="text"   name="table"></input>
					</tr>
			
					</table>
					<input id="submit" type="submit" value="查询訂單并且刪除"></input>
				</form>
			
		</div>
	</div>
</div>



</body>
</html>
