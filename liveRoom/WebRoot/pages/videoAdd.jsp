<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>视频添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/video.js"></script>
	
  </head>
  
  <body onload="selectBox()">
  	<center>
	  <form action="addVideo.do" enctype="multipart/form-data" method="post">
	  	<div style="text-align: center;width: 50%">
			<div style="padding: 10px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">视频名称：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="video_Name" id="video_Name" style="height:30px;width:200px;">
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">视频描述：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" id="video_desc" name = "video_Describe" style="height:30px;width:200px;">
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">视频类型：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<select id="video_type" name="video_Type" style="height:30px;width:200px;">
					</select>
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">视频地址：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" id="fileName" style="height:30px;width:110px;" readonly="readonly">
					<button type="button" onclick="$('#fileData').click()">选择</button>
					<span id="progressNumber" style="color: red;"></span>
					<input accept="video/*" type="file" id="fileData" name = "fileData" 
					 onchange="fileSelect()" style="display:none">
				</div>
			</div>
			
			<!-- <div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">发布类型：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<select id="video_Type" name = "video_Type" style="height:30px;width:200px;">
						<option value="0">直播</option>
						<option value="1">点播</option>
					</select>
				</div>
			</div> -->
			
			<!-- <div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">播放时间：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="video_playTime" id="video_playTime"style="height:30px;width:200px;"
					 onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"/>
				</div>
			</div> -->
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="button"
  				onclick="addVideo(${sessionScope.user.user_id})">添加</button>
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="reset">重置
				</button>
			</div>
			</div>
		</form>
	</center>	
  </body>
</html>
