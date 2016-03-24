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

<title>角色添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/role.js"></script>
<link rel="stylesheet" href="css/jquery.treeview.css" />
<script src="js/jquery.treeview.js" type="text/javascript"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body onload="getPowerList('main','${role.role_id}')">
	<div style="width:50%;float:left;">
		<form action="editRole.do" enctype="multipart/form-data" method="post">
			<div style="padding: 10px 10px 10px 10px;width: 100%;">
				<div style="text-align: right;float:left;">角色名称：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" value="${role.role_name}" name="role_name" id="role_name" style="height:30px;width:200px;">
				</div>
			</div>
			
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
				<div style="text-align: right;float:left;">角色图标：</div>
				<div style="text-align: left;float: left;margin-left: 3px;">
					<input type="text" id="fileName" style="height:30px;width:150px;"
					 value = "${role.role_icon}" readonly="readonly">
					<button type="button" onclick="$('#fileData').click()">选择照片</button>
					<span id="img"><img width="32" height="32" src="${role.role_icon}"></span>
					<input accept="image/*" style="display:none" type="file" id="fileData" onchange="fileSelect()">
				</div>
			</div>
			<div style="padding: 10px 10px 10px 10px;float:left;width: 100%;">
			<button style="padding: 3px 15px 3px 15px;cursor: pointer;right:0px;" type="button"
  				onclick="editRole(${role.role_id},${sessionScope.user.user_id},'${role.role_icon}')">保存</button></div>
		</form>
		</div>
	<div style="width:50%;float:left;" id="main"></div>
</body>
</html>
