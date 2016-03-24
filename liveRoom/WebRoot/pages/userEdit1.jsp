<%@page import="javax.swing.text.Document"%>
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

<body>
	<center>
		<form action="updateUser.do" enctype="multipart/form-data" method="post">
		<table border="0"> 
			<tr>
				<td>手机号：</td>
				<td>
					<input type="text" name="user_phone" value="${user.user_phone}" onblur="addPhoneValue()"
						id="user_phone" style="width: 150px;" onkeyup="value=value.replace(/[^0-9]/ig,'')">
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
				type="radio" name="user_sex" value="1" ${user.user_sex eq 1 ? 'checked="checked"' : ''}>女
			</td>
			</tr>
			<tr>
			<td>真实姓名：</td>
			<td>
				<input type="text" name="user_realName" id="user_realName" value="${user.user_realName}"
				style="width: 150px;margin-right: 23px;"></td>
			</tr>
			<tr>
				<td>账号类型：</td>
				<td>
					<select id="teacher" name="user_teacher"style="width: 150px;">
						${user.user_teacher == 0 ? '<option value="0">普通账号</option><option value="1">老师账号</option>' : '<option value="1">老师账号</option><option value="0">普通账号</option>'}
					</select>
				</td>
			</tr>
			<tr>
				<td>擅长领域：</td>
				<td>
					<input type="text" name="advantage" id = "advantage" value="${user.advantage}"
					style="width: 150px;margin-right: 23px;">
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
			<tr>
				<td>个人简介：</td>
				<td>
					<textarea rows="5" cols="30" name="user_introduction">${user.user_introduction}</textarea>
				</td>
			</tr>
			</table>
			<input type="hidden" name = "user_id" value="${user_user_id}">
			<input type="hidden" id ="account" name="user_account" value="${user.user_account}">
			 <br /><input
				type="button" onclick="editUser(${user.user_id},'${user.user_pwd}',${sessionScope.user.user_id},
				'${user.user_head }')" value="保存">&nbsp;
			<button type="reset">重置</button>
		</form>
	</center>
</body>
</html>
