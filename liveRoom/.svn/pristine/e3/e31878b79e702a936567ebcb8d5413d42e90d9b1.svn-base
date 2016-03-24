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
	<script type="text/javascript" src="<%=basePath%>js/roomRadio.js"></script>
	<script type="text/javascript" src="js/date.js"></script>
  </head>
  
  <body onload="selectBox()">
  	<center>
	  <form action="addRoomRadio.do" method="post">
	  	<input type="hidden" name="publisher" value="${sessionScope.user.user_id }">
	  	<div style="text-align: center;width: 80%">
			<div style="padding: 10px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">发布类型：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<select style="height:30px;width:200px;" id="type" name="type">
						<option value="1">事件</option>
						<option value="2">重要通知</option>
					</select>
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">所属房间：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<select style="height:30px;width:200px;" id="roomid" name="roomid">
						<option></option>
					</select>
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;">
				<div style="text-align: right;float:left;">广播内容：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<textarea rows="10" cols="43" id="content" name = "content"></textarea>
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="button"
  				onclick="addOrEditRoomRadio()">添加</button>
				<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="reset">重置
				</button>
			</div>
			</div>
		</form>
	</center>	
  </body>
</html>
