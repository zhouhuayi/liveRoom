<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新闻添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/advertise.js"></script>
	<script type="text/javascript" src="js/date.js"></script>
  </head>
  
  <body>
	<form action="addAdvertise.do" method="post" enctype="multipart/form-data">
	  	<div style="text-align: center;width: 80%">
	  	
	  		<div style="padding: 10px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">广告标题：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="title" id="title" style="height:30px;width:200px;">
				</div>
			</div>
	  	
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">广告图片：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" id="fileName" style="height:30px;width:150px;" readonly="readonly">
					<button type="button" onclick="$('#fileData').click()">选择照片</button>
					<input accept="image/*" type="file" id="fileData" name = "fileData" 
					  onchange="fileSelect()" style="display:none">
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">图片展示：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<div style="border: 1px solid;height:100;width:200">
						<span id="img" ></span>
					</div>
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">广告地址：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="url" id="url" style="height:30px;width:200px;">
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="button"
  				onclick="addOrEdit(${sessionScope.user.user_id})">添加</button>
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="reset">重置
				</button>
			</div>
		</div>
	</form>
  </body>
</html>
