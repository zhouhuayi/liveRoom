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

<title>用户添加页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/layer.js"></script>
<script type="text/javascript" src="js/user.js"></script>
</head>

<body onload="selectBox(${user.user_role})">
	<center>
		<form action="updateUser.do" enctype="multipart/form-data" method="post">
			<table border="0"> 
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="user_account" value="${user.user_account}"
						id="user_account" style="width: 150px;" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')">
				</td>	
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="user_pwds" id="user_pwds" style="width: 150px;" value="${user.user_pwd}">
				</td>
			</tr>	
			<tr>
				<td>确认密码：</td>
			<td>
				<input type="password" name="user_pwd" id="user_pwd" value="${user.user_pwd}"
					style="width: 150px;margin-right: 23px;">
			</td>
			<tr>
				<td>昵称：</td>
				<td>
					<input type="text" name="user_name" id="user_name" style="width: 150px;" value="${user.user_name}">
				</td>
			</tr>
			<tr>
			 <td>性别：</td>
			 <td>
			 <input type="radio" name="user_sex" value="0" checked="checked">男 <input
				type="radio" name="user_sex" value="1" ${user.user_sex eq 1 ? 'checked="checked"' : ''} }>女
			</td>
			</tr>
			<tr>
			<td>真实姓名：</td>
			<td>
				<input type="text" name="user_realName" id="user_realName" value="${user.user_realName}"
				style="width: 150px;margin-right: 23px;"></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td>
					<select class="role" id="role" style="width: 150px;"></select>
				</td>
			</tr>
			<tr>
				<td>头像：</td>
				<td>
				<input type="text" id="fileName"style="width:150px;" value = "${user.user_head}" readonly="readonly">
					<button type="button" onclick="$('#fileData').click()">选择照片</button>
					<span id="img"><img width="32" height="32" src="${user.user_head}"></span>
					<input accept="image/*" style="display:none" type="file" id="fileData" onchange="fileSelect()">
					<span id="progressNumber"></span>
				</td>
			</tr>
			</table>
			<input type="hidden" name = "user_id" value="${user.user_user_id}}">
			 <br /><input
				type="button" onclick="editUser(${user.user_id},'${user.user_pwd}',${sessionScope.user.user_id},
				'${user.user_head }')" value="保存">&nbsp;
			<button type="reset">重置</button>
		</form>
	</center>
</body>
</html>
