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

	<div class="leftsidebar_box">
		<dl class="system_log">
			<dt onClick="changeImage()" id="polution">单表查询<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="<%=path %>/readInversionYaml.do" id="polution_edit_a" >编辑</a></dd>
			<dd><a href="<%=path %>/Inversion.do" id="degassing_count1">计算</a></dd>
		</dl>
	
		<dl class="custom">
			<dt onClick="changeImage()" id="sample">单表修改<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="<%=path %>/readGrabsampleYaml.do" id="sample_edit_a">编辑</a></dd>
			<dd><a href="<%=path %>/Grabsample.do" id="degassing_count2">计算</a></dd>
		</dl>
	
		<dl class="channel">
			<dt id="dispatch">组合查询<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="<%=path %>/readFlushingYaml.do" id="dispatch_edit_a">编辑</a></dd>
			<dd><a href="<%=path %>/Flushing.do" id="degassing_count3">计算</a></dd>
		</dl>
	
		<dl class="app">
			<dt onClick="changeImage()" id="degassing">消毒增压<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="<%=path %>/readBoosterYaml.do" id="degassing_edit_a">编辑</a></dd>
			<dd><a href="<%=path %>/booster_mip.do" id="degassing_count4">计算</a></dd>
		</dl>
		<div class="time_display">
			计算时间：
			<br><span id="yy004" >0时0分0秒</span>
		</div>
	</div>
	<div class="web_content">
	<div class="welcome">
		<img src="images/welcome.jpg" alt="welcome_logo">
		<span>哈工大数据库实验3</span>
	</div>
		<div class="" id="polution_edit_table_set">
				<form action="<%=path %>/selectAllTable.do" method="post" accept-charset="utf-8" >
					
					<caption>单表查询</caption>
					<table>
					<tr>		
						<input type="text"   name="table"></input>
					</tr>
						输入条件<br>
						
						<tr>	customerNo:<input type="text"   name="customerNo"></input></tr>
						<tr>	customerName:<input type="text"   name="customerName"></input></tr>
						<tr>	telephone:<input type="text"   name="telephone"></input></tr>
						<tr>address:<input type="text"   name="address"></input></tr>
						<tr>	zip:<input type="text"   name="zip"></input></tr>
					</table>
					<input id="submit" type="submit" value="查询"></input>
				</form>
			
		</div>
		
		
	</div>
</div>



<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript">
	var objWidth,objHeight;
		function bigger(obj) {
			objWidth = obj.style.width;
			objHeight = obj.style.height;
			obj.style.width = '300px';
			obj.style.height = '200px';
		}
		function smaller(obj) {
			obj.style.width = objWidth;
			obj.style.height = objHeight;
		}
	</script>


<script type="text/javascript">
//这是计时的程序

	var sec =0;
	var minu=0;
	var hou=0;

$('#degassing_count1').click(function(){
//每隔一秒刷新一次
window.setTimeout("uupdate()",1000);
});

function uupdate()
{
    sec++;    
    if(sec==60)
    {
        sec =0;
        minu +=1;
    }
    if(minu==60)
    {
        minu=0;
        hou+=1;
    }
    var ss04 =hou+ "时"+minu+"分"+sec+"秒";
    document.getElementById('yy004').innerHTML=ss04;
    window.setTimeout("uupdate()",1000);
}

$('#degassing_count2').click(function(){
//每隔一秒刷新一次
window.setTimeout("uupdate()",1000);
});

function uupdate()
{
    sec++;    
    if(sec==60)
    {
        sec =0;
        minu +=1;
    }
    if(minu==60)
    {
        minu=0;
        hou+=1;
    }
    var ss04 =hou+ "时"+minu+"分"+sec+"秒";
    document.getElementById('yy004').innerHTML=ss04;
    window.setTimeout("uupdate()",1000);
}

$('#degassing_count3').click(function(){
//每隔一秒刷新一次
window.setTimeout("uupdate()",1000);
});

function uupdate()
{
    sec++;    
    if(sec==60)
    {
        sec =0;
        minu +=1;
    }
    if(minu==60)
    {
        minu=0;
        hou+=1;
    }
    var ss04 =hou+ "时"+minu+"分"+sec+"秒";
    document.getElementById('yy004').innerHTML=ss04;
    window.setTimeout("uupdate()",1000);
}

$('#degassing_count4').click(function(){
//每隔一秒刷新一次
window.setTimeout("uupdate()",1000);
});

function uupdate()
{
    sec++;    
    if(sec==60)
    {
        sec =0;
        minu +=1;
    }
    if(minu==60)
    {
        minu=0;
        hou+=1;
    }
    var ss04 =hou+ "时"+minu+"分"+sec+"秒";
    document.getElementById('yy004').innerHTML=ss04;
    window.setTimeout("uupdate()",1000);
}
</script>









<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#e0edff"});
$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
$(function(){
	
	var basePath = "http://localhost:8080/WST";
	
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#e0edff"})
		$(this).css({"background-color": "#e0ebfd"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
	

	//污染源定位
	$("#polution").click(function(){
			$('.welcome').css({'display':'none'});
    		$('.sample_edit').css({'display':'none'});
    		$('.dispatch_edit').css({'display':'none'});
    		$('.degassing_edit').css({'display':'none'});
    		$('.polution_edit').css({'display':'block'}); 
				
	}); 
	
	
	$("#sample_edit_a").click(function(){
		$('.welcome').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.sample_edit').css({'display':'block'});
	});
	$("#dispatch_edit_a").click(function(){
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'block'});
	});
	$("#degassing_edit_a").click(function(){
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'block'});
	});
	
	
	//取样点优化点击编辑
	$("#sample").click(function(){
		
		$('.welcome').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.sample_edit').css({'display':'block'}); 
		
	});
	
	
	//阀门调度编辑
	$("#dispatch").click(function(){
		
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'block'});

	});
	
	
 	//消毒增压编辑
	$("#degassing").click(function(){
		
		$('.welcome').css({'display':'none'});
		$('.sample_edit').css({'display':'none'});
		$('.dispatch_edit').css({'display':'none'});
		$('.polution_edit').css({'display':'none'});
		$('.degassing_edit').css({'display':'block'});
		
	});
	
	
	
});
</script>

<script type="text/javascript">
	function myBigger(){
		 /*  var name=prompt("请输入您的名字","");//将输入的内容赋给变量 name ，
		    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值
		    if(name)//如果返回的有内容
		    {
		        alert("欢迎您："+ name)
		    } */
	}

</script>






</body>
</html>
