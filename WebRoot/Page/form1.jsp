<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>form</title>
	<meta charset=utf-8>
	<meta name=description content="">
	<meta name=viewport content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../Css/form1.css">
</head>
<body>
	<div class="container">
	<form action="<%=path %>/saveInversionYAML.do" method="post" accept-charset="utf-8">
					<table>
					<caption>污染源定位参数设置</caption>
					<tbody>
						<tr>
							<td  class="catalogue" colspan="2">管网模型</td>
							<td class="catalogue" colspan="2">反馈</td>
						</tr>
						<tr>
							<td>EPANET管网模型：</td>
							<td><input type="text" value="${sessionScope.epanet }" name="epanet"></input></td>
							<td>模型：</td>
							<td><input type="text" value="${sessionScope.algorithm } " name="algorithm"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">监测数据</td>
							<td>注入类型：</td>
							<td><input type="text" value="${sessionScope.formulation }" name="formulation"></input></td>
						</tr>
						<tr>
							<td >取样数据：</td>
							<td><input type="text" value="${sessionScope.grab_samples}" name="grab_samples"></input></td>
							<td>模型格式：</td>
							<td><input type="text" value="${sessionScope.model_format}" name="model_format"></input></td>
						</tr> 
						<tr>
							<td class="catalogue" colspan="2">求解程序</td>
							<td>时间：</td>
							<td><input type="text" value="${sessionScope.horizon }" name="horizon"></input></td>
						</tr>
						<tr>
							<td>类型：</td>
							<td><input type="text" value="${sessionScope.type }" name="type"></input></td>
							<td>注入节点数量：</td>
							<td><input type="text" value="${sessionScope.num_injections }" name="num_injections"></input></td>
						</tr>
						<tr>
							<td>选项：</td>
							<td><input type="text" value="${sessionScope.options }" name="options"></input></td>
							<td>监测失败率：</td>
							<td><input type="text" value="${sessionScope.measurement_failure }" name="measurement_failure"></input></td>
						</tr>
						<tr>
							<td>记录文件：</td>
							<td><input type="text" value="${sessionScope.logfile }" name="logfile"></input></td>
							<td>正阕值：</td>
							<td><input type="text" value="${sessionScope.positive_threshold }" name="positive_threshold"></td>
						</tr>
						<tr>
							<td>冗余：</td>
							<td><input type="text" value="${sessionScope.verbose }" name="verbose"></input></td>
							<td>负阕值：</td>
							<td><input type="text" value="${sessionScope.negative_threshold }" name="negative_threshold"></input></td>
						</tr>
						<tr>
							<td>起始节点：</td>
							<td><input type="text" value="${sessionScope.initial_points }" name="initial_points"></input></td>
							<td>可行节点：</td>
							<td><input type="text" value="${sessionScope.feasible_nodes }" name="feasible_nodes"></input></td>
						</tr>
						<tr>
							<td class="catalogue" colspan="2">配置</td>
							<td>候选阕值：</td>
							<td><input type="text" value="${sessionScope.candidate_threshold }" name="candidate_threshold"></input></td>
						</tr>
						<tr>
							<td>输出前缀：</td>
							<td><input type="text" value="${sessionScope.output_prefix }" name="output_prefix"></input></td>
							<td>置信度：</td>
							<td><input type="text" value="${sessionScope.confidence }" name="confidence"></input></td>
						</tr>
						<tr>
							<td>调试：</td>
							<td><input type="text" value="${sessionScope.debug }" name="debug"></input></td>
							<td>输出影响节点：</td>
							<td><input type="text" value="${sessionScope.output_impact_nodes }" name="output_impact_nodes"></input></td>
						</tr>
					</tbody>
					</table>
					<input id="submit" type="submit" value="提交"></input>
					<input id="reset"   type="reset" value="取消"></input>
				</form>
			
		
		
	</div>
</body>
</html>