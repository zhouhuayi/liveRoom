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
<script type="text/javascript" src="js/power.js"></script>
</head>

<body onload="selectBox(${power.power_parentId})">
	<center>
		<form action="editPower.do" enctype="multipart/form-data" method="post">
			<span>&nbsp;&nbsp;权限名称：</span>&nbsp;<input
				type="text" name="power_name" id="power_name" value="${power.power_name}" style="width: 150px;"><br />
				
			<br /> <span>&nbsp;&nbsp;&nbsp;权限地址：</span>&nbsp;<input
				type="text" name="power_url" id="power_url" value="${power.power_url}" style="width: 150px;"><br />
				
				<br /> <span>&nbsp;&nbsp;关联父类：</span>&nbsp;<select
				 id="power" name="power_parentId" class="power" style="width: 150px;">
				 <option></option>
				 </select><br />
			 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="button" onclick="EditPower(${power.power_id})" value="保存">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset">重置</button>
		</form>
	</center>
</body>
</html>
