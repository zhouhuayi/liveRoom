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

<title>My JSP 'userList.jsp' starting page</title>
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
<script type="text/javascript" src="js/user.js"></script>
</head>

<body onload="lookList1()">
	<div
		style="width:100%;background-color: #F0F8FF;height: 3%;padding: 5px 20px 5px 0px;">
		&nbsp;&nbsp;首页&lt;&lt;用户管理</div>
		<div style="height: 5%;">
	  	<div style="margin-top: 5px;margin-bottom: 5px;padding-left: 5px;width: 100%">
	  	<div style="float:left;">
			<button
				style="background-color: #4169E1;padding: 5px 15px 5px 15px;cursor: pointer;"
				onclick="openUserAddPage1()">
				<font color="white">添加</font>
			</button>
			<button
				style="background-color: red;padding: 5px 5px 5px 5px;cursor: pointer;"
				onclick="deleteMany()">
				<font color="white">删除所选</font>
			</button>
			<button
				style="background-color: red;padding: 5px 5px 5px 5px;cursor: pointer;"
				onclick="restoreMany()">
				<font color="white">还原所选</font>
			</button>
		</div>
			<div style="float:right;padding-right: 20px;padding-top: 5px;">
				<span>状态：</span>&nbsp;&nbsp;
				<select class="state" id="teacher"style="height:30px;width:150px;" onchange="teacherCombox()">
					<option value="2">查看所有用户</option>
					<option value="1">老师</option>
					<option value="0">普通用户</option>
				</select>
				<select class="state" id="state"style="height:30px;width:150px;" onchange="beforeUser()">
					<option value="0">未删</option>
					<option value="1">已删</option>
					<option value="2">查封</option>
					<option value="6">查看所有状态</option>
				</select> 
				<input type="text" id="search" style="height:30px;width:150px;">
				<button onclick="search1()">查询</button>        
			</div>
		</div>
</div>
	<table id="userTable" class="main_table" border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>用户账号</th>
				<th>用户昵称</th>
				<th>真实姓名</th>
				<th>手机号</th>
				<th>最后登录时间</th>
				<th>用户注册时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div id="padding"
		style="border-top: 1px solid #A9A9A9;padding-top: 5px;position:absolute;bottom:5px;"></div>
	<script type="text/javascript">
		$("#search").keydown(function(event) {
			if (event.keyCode == 13) {
				search1();
			}
		});
	</script>
</body>
</html>