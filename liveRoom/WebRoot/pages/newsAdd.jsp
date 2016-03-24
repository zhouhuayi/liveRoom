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
	<script type="text/javascript" src="<%=basePath%>js/news.js?<%=new Date()%>"></script>
	<script type="text/javascript" src="js/date.js"></script>
  </head>
  
  <body onload="selectBox()">
  	<center>
	  <form action="addNews.do" method="post" enctype="multipart/form-data">
	  	<input type="hidden" name="news_Userid" value="${sessionScope.user.user_id }">
	  	<div style="text-align: center;width: 80%">
			<div style="padding: 10px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">新闻标题：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="news_Title" id="news_Title" style="height:30px;width:200px;">
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">新闻图片：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" id="fileName" style="height:30px;width:150px;" readonly="readonly">
					<button type="button" onclick="$('#fileData').click()">选择照片</button>
					<div style="border: 1px solid;height:100;width:200">
						<span id="img" ></span>
					</div>
					<input accept="image/*" type="file" id="fileData" name = "fileData" 
					  onchange="fileSelect()" style="display:none"><span id="img"></span>
				</div>
			</div>
			
			
			
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">发布时间：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="news_Uploadtime" id="news_Uploadtime" readonly="readonly"
					style="height:30px;width:200px;" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"/>
				</div>
			</div>
			
			<input type="hidden" id="news_Address" name="news_Address" style="height:30px;width:200px;">
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">新闻类型：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<select style="height:30px;width:200px;" id="news_type" name="news_Type">
						<option>请选择</option>
					</select>
				</div>
			</div>
		
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">新闻描述：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<textarea rows="3" cols="50" id="news_Describe" name = "news_Describe"></textarea>
				</div>
			</div>
			<div style="float:left;width: 100%"> </div>
			<div style="float:left;width:100%">
				<div style="text-align: right;float:left;">新闻内容：</div>
				<div style="text-align: left;float: left;margin-left: 3px;width: 80%">
				<!-- <iframe id="content" src="http://192.168.0.131:8080/fileProject/ueditor/index.html" width=100% height="50%"
				frameborder="0"> 
				</iframe>-->
				<textarea rows="5" cols="43" id="news_Content" name = "news_Content"></textarea>
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="button"
  				onclick="addOrEditNews(${sessionScope.user.user_id})">添加</button>
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="reset">重置
				</button>
			</div>
			</div>
		</form>
	<!-- 配置文件 -->
    <script type="text/javascript" src="<%=basePath%>ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=basePath%>ueditor/ueditor.all.min.js"></script>
	<!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('news_Content');
    </script>
	</center>	
  </body>
</html>
