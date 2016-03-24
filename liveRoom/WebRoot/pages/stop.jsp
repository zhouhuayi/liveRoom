<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'stop.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/table.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/layer.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/table.js"></script>
<script type="text/javascript" src="js/disable.js"></script>
</head>
<body>
	<form action="disablewords.do" style="width: 100%">
		<center>
			<span>禁词设置：</span><br>
			<textarea rows="20" cols="50" name="disable" class="disable"
				id="disable">${disable}</textarea>
			<br> <br>
			<input id="tj" style="margin-left: 20px;" type="button"
				 value="添加"> &nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置">
		</center>
	</form>
</body>
</html>
