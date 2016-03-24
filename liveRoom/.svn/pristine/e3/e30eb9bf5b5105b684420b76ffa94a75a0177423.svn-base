<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>动态修改页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/blog.js"></script>
		<script type="text/javascript" src="js/date.js"></script>
  </head>
  
  <body onload="selectBox(${blog.user_id})">
    <center>
	  <form action="editBlog.do" method="post" enctype="multipart/form-data">
	  	<input type="hidden" name="id" value="${blog.id}"> 
	  	<div style="text-align: center;width: 100%">
			<div style="padding: 3px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">动态标题：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" name="title" id="title" value="${blog.title}" style="height:30px;width:200px;">
				</div>
			</div>
			
			<div style="padding: 3px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">发布人：&nbsp;</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<select style="height:30px;width:200px;" id="person" name="user_Id">
						<option>请选择</option>
					</select>
				</div>
			</div>
			
			<div style="padding: 3px 10px 10px 10px;float:left;width:100%">
				<div style="text-align: right;float:left;">动态内容：</div>
				<div style="text-align: left;float: left;">
					<textarea style="height:50%;width:90%" id="content" name="content">${blog.content}</textarea>
				</div>
			</div>
			
			<div style="padding: 3px 10px 10px 10px;float:left;width: 100%;">
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="button"
  				onclick="addOrEditNews(2)">保存</button>
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
        var ue = UE.getEditor('content');
    </script>
	</center>
  </body>
</html>
