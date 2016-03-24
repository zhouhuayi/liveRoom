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
<script type="text/javascript" src="js/user.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
</style>
<body>
	<center>
		<form action="openUserDetails.do" enctype="multipart/form-data" method="post">
			<span>用户名：</span><input
				type="text" name="user_account" id="user_account" readonly="readonly" value="${user.user_account}" style="width: 150px;"><br />
			 <br /><span style="margin-left: 18px;">昵称：</span><input type="text" name="user_name"
				value="${user.user_name}" readonly="readonly" style="width: 150px;"><br />
				
			   <br><span style="margin-left: 38px;">真实姓名：</span><input type="text" name="user_realName"
				value="${user.user_realName}" readonly="readonly" id="user_realName" style="width: 150px;margin-right: 50px;"><br />
				
				 <br><span style="margin-left: 38px;">出生日期：</span><input type="text" name="user_age"
				value="${user.user_age}" readonly="readonly" id="user_age" style="width: 150px;margin-right: 50px;"><br />
				
				<br /><span style="margin-left: 20px;">性别：</span><input type="text"
				name="user_sex" id="user_sex" readonly="readonly"  value="${user.user_sex == 0 ?'男' : '女'}"style="width: 150px;"><br /> 
				
				<br /><span style="margin-left: 8px;">手机号：</span><input type="text"
				name="user_phone" id="user_phone" readonly="readonly" value="${user.user_phone}" style="width: 150px;"><br /> 
	
	           <br /><span style="margin-left: 23px;">邮箱：</span><input type="text"
				name="user_email" id="user_email" readonly="readonly" value="${user.user_email}" style="width: 150px;"><br /> 
	
	           <br /><span style="margin-left: 35px;">QQ：</span><input type="text"
				name="user_qq" id="user_qq" readonly="readonly"  value="${user.user_qq}" style="width: 150px;"><br /> 
	
	           <br /><span style="margin-left: 20px;">地址：</span><input type="text"
				name="user_address" id="user_address" readonly="readonly"  value="${user.user_address}" style="width: 150px;"><br /> 
	
				<br /><span style="margin-left: 20px;">等级：</span><input type="text" name="user_level"
				id="user_level" readonly="readonly" value="${user.user_level}" style="width: 150px;"><br />

				<br /><span style="margin-left: 20px;">积分：</span><input type="text" name="user_integral"
				id="user_integral" readonly="readonly" value="${user.user_integral}" style="width: 150px;"><br />
				
				<br /><span style="margin-left: 20px;">角色：</span><input type="text" name="role_name"
				id="role_name" readonly="readonly" value="${user.role_name}" style="width: 150px;"><br />				
				
			<br /><span style="margin-left: 13px;">头像：
			<span  id="img" style="margin-right:100px;"><img width="32" height="32" src="${user.user_head}"></span>
					<span id="progressNumber"></span>
					</span>
			<br/>
				<br><span style="margin-left: 40px;">注册日期：</span><input type="text" name="user_registerDate"
				value="${user.user_registerDate}" readonly="readonly" id="user_registerDate" style="width: 150px;margin-right: 50px;"><br />
				
				<br><div style="margin-right:165px;">个人简介：</div><br>
			<div style="margin-left: 140px;padding-right:35px;"><textarea rows="10" cols="20" name="user_introduction" style="margin-top:-40px;width: 190px;height: 192px;" readonly="readonly" id="user_introduction" >${user.user_introduction}</textarea></div><br />
		</form>
	</center>
</body>
</html>
