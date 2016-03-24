<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>反馈列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/table.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/table.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/feedBack.js"></script>
  </head>
  
   <body onload="boardList()">
    <div style="background-color: #F0F8FF;height: 3%;padding: 5px 20px 5px;"> 	
  		首页&nbsp;&lt;&lt;反馈管理&nbsp;
  	</div>
  	<div style="height: 5%;">
	  	<div style="margin-top: 5px;margin-bottom: 5px;padding-left: 5px;width: 100%">
			<div style="float:left;">
<!-- 				<button style="background-color: #4169E1;padding: 5px 5px 5px 5px;cursor: pointer;" 
					onclick="openBoardAddPage()">
					<font color="white">添加</font>
				</button> -->
				<button style="background-color: red;padding: 5px 5px 5px 5px;cursor: pointer;"
				onclick="deleteMany()">
					<font color="white">删除</font>
				</button>
			</div>
<!-- 			<div style="float:right;padding-right: 20px;padding-top: 5px;">
				<input type="text" id="search" style="height:30px;width:150px;">
				<button onclick="search()">查询</button>
			</div> -->
		</div>
	</div>
	
  	<div style="text-align:ceter;height:90%;position:relative;">
  		<div>
	    	<table id="feedBackTable" class="main_table" border="1">
		    	<thead>
		    		<tr>
		    			<th><input type="checkbox" style="z-index: 10px;"></th>
			    		<th>反馈者联方式</th>
			    		<th>反馈时间</th>
			    		<th>反馈的内容</th>
			    		<th>反馈者的真实姓名</th>
			    		<th>操作</th>
		    		</tr>
		    	</thead>
		    	<tbody>
		    	
		    	</tbody>
			 </table>
		 </div>
		 <div id="padding" style="border-top: 1px solid #A9A9A9;
		 padding-left: 5px;padding-top: 10px;position:absolute;bottom:5px;"></div>
	 </div>
	 <script type="text/javascript">
		$("#search").keydown(function(event) {
			if(event.keyCode == 13) {
				search();
			}
		});
	 </script>
</html>
