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

<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/index_three.css" type="text/css" />
<style type="text/css">
body {
	FONT-SIZE: "12px";
	COLOR: "#000";
	BACKGROUND-COLOR: " #fff";
	margin: 0;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 18px;
	line-height: 20px;
	color: #333;
	background-color: #fff;
}

a {
	color: #fff;
	text-decoration: none
}

a:hover,a:focus {
	color: #A1A2A2;
	text-decoration: underline;
	text-decoration: none
}

.dropdown-toggle {
	*margin-bottom: -3px;
	font-size: 18px;
}
</style>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>

</head>
<body>
	<FORM id="Form1" name="Form1" method="post">
		<table border="0" width="100%" height="50px" cellspacing="0"
			cellpadding="0">
			<tr>
				<td width="20%" height="19" bgcolor="#283DF0">
					<table border="0" width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td width="47%" align="center"><span class="STYLE1"><font
									color="#FFF">后台管理</font></span></td>
							<td width="41%" align="center"><FONT color="#FFF"> <b>
										<SCRIPT language="JavaScript">
										function topClick(powerUrl) {
											var frames=window.parent.window.document.getElementById("mainFrame");
											frames.contentWindow.location.href=powerUrl;
										}
										<!--
											tmpDate = new Date();
											date = tmpDate.getDate();
											month = tmpDate.getMonth() + 1;
											year = tmpDate.getFullYear();
											document.write(year);
											document.write("年");
											document.write(month);
											document.write("月");
											document.write(date);
											document.write("日 ");

											myArray = new Array(6);
											myArray[0] = "星期日";
											myArray[1] = "星期一";
											myArray[2] = "星期二";
											myArray[3] = "星期三";
											myArray[4] = "星期四";
											myArray[5] = "星期五";
											myArray[6] = "星期六";
											weekday = tmpDate.getDay();
											if (weekday == 0 | weekday == 6) {
												document.write(myArray[weekday])
											} else {
												document
														.write(myArray[weekday])
											};
										// -->
										</SCRIPT>
								</b>
							</FONT></td>
							<td width="12%" align="center"><font color="#FFF"><b>|</b></font></td>
						</tr>
					</table>
				<td width="16%" height="19" bgcolor="#283DF0">
					<table cellSpacing="2" height="19px" cellPadding="0" width="100%"
						border="0">
						<tr>
							<td valign="top">
								<h3>
									<font color="#FFF">欢迎您!&nbsp;&nbsp;&nbsp;</font><span
										class="STYLE3">${sessionScope.user.user_name}</span>
								</h3>
							</td>
						</tr>
					</table>
				</td>
				<td width="46%" height="19" bgcolor="#283DF0"></td>
				<td width="18%" height="19" bgcolor="#283DF0" align="center">
					<table border="0" width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td width="50%" align="center"><a href="javascript:topClick('oneself.jsp')"
								class="dropdown-toggle"> <span class="name" title="个人中心">个人中心</a>

							</td>
							<td width="50%" align="center"><a href="javascript:topClick('editPwd.jsp')"
								class="dropdown-toggle"> <span class="name" title="修改密码">修改密码</span></a>
							</td>
							<td width="100%" align="center"><a
								href="javascript:logout()"><img src="image/close.jpg"
									style="height:50px; float:right" /></font></a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</FORM>
</body>
</html>
