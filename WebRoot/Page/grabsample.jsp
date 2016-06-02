<!DOCTYPE html>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.net.URI"%>
<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'inversion.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
  <body>
  <div>
		啊啊啊啊
	
	</div>
  
  
  <div>
     <%
     String tiaozhuanweizhi2 = (String)request.getSession().getAttribute("tiaozhuanweizhi2");
     String buff[] = tiaozhuanweizhi2.split("/");
     String location = buff[0];
     String prefix = buff[1];
     
  	response.reset();
	response.setContentType("text/html ");
	OutputStream output = response.getOutputStream();// 得到输出流  
	File file = new File("G:\\wst-1.2\\bin\\"+ location+"\\"+ prefix + "visualization_output.html");// 文件流  
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));// 输入缓冲流  
	BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流  
	byte data[] = new byte[2048];// 缓冲字节数  
	int size = 0;
	size = bis.read(data);
	while (size != -1) {
		bos.write(data, 0, size);
		size = bis.read(data);
	}
	bis.close();
	bos.flush();
	bos.close();
	output.close();
	out.clear();
	out = pageContext.pushBody();
	%>
	</div>
	
  </body>
</html>
