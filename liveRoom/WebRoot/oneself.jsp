<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<SCRIPT src="js/jquery-1.10.2.min.js" type="text/javascript"></SCRIPT>
	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript" src="js/oneself.js"></script>
	<style type="text/css">
		.input {
			width:200px;
			height:30px;
		}
		
		.leftTd {
			width: 200px;
			text-align: right;
			padding-right: 20px;
		}
		
		.rightTd {
			width: 250px;
			text-align: left;
			padding-left: 5px;
		}
		table {
			margin-top: 3%;
		}
	</style>
  </head>
  
  <body>
  	<center>
	    <form action="updateOneself.do" method="post">
	    	<input type="hidden" name="user_id" value="${sessionScope.user.user_id}">
	    	<table border="1" cellpadding="3" cellspacing="0">
	    		<thead>
	    			<tr><th colspan="2"><h2>个人中心</h2></th></tr>
	    		</thead>
	    		<tr>
	    			<td class="leftTd"><label>昵称：</label></td>
	    			<td class="rightTd">
	    				<input class="input" type="text" name="user_name" value="${sessionScope.user.user_name }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>真实姓名：</label></td>
	    			<td class="rightTd">
	    				<input class="input" type="text" name="user_realName" value="${sessionScope.user.user_realName }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>出生日期：</label></td>
	    			<td class="rightTd">
	    				<input class="input" type="text" name="user_age" 
	    				value="${sessionScope.user.user_age }" onclick="SelectDate(this,'yyyy-MM-dd')">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>出生地：</label></td>
	    			<td class="rightTd">
	    				<input type="text" name="user_address"  class="input"
	    				value="${sessionScope.user.user_address }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>手机号码：</label></td>
	    			<td class="rightTd">
	    				<input type="text" name="user_phone"  class="input"
	    				value="${sessionScope.user.user_phone }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>性别：</label></td>
	    			<td class="rightTd">
	    				<input type="radio" name="user_sex" checked="checked" value="0">男
	    				<input type="radio" name="user_sex" value="1" ${sessionScope.user.user_sex==1 ? 'checked="checked"' : ''}>女
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>邮箱：</label></td>
	    			<td class="rightTd">
	    				<input class="input" type="text" name="user_email" value="${sessionScope.user.user_email }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>等级：</label></td>
	    			<td class="rightTd">
	    				<input class="input" type="text" name="user_level" readonly="readonly"
	    				value="${sessionScope.user.user_level }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>积分：</label></td>
	    			<td class="rightTd">
		    			<input class="input" type="text" name="user_integral" readonly="readonly"
		    			value="${sessionScope.user.user_integral }">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="leftTd"><label>个人简介：</label></td>
	    			<td class="rightTd">
	    				<textarea cols="21" rows="10" name="user_introduction" >${sessionScope.user.user_introduction}</textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center">
	    				<button type="button" onclick="saveOneself()">保存信息</button>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
    </center>
  </body>
</html>
