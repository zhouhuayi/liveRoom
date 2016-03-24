<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房间信息</title>
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/layer.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/PageData.js"></script>
<script type="text/javascript" src="../js/tc.min.js"></script>
<!-- <script type="text/javascript" src="../js/user.js"></script> -->

<script type="text/javascript">
$(function(){
	$("#checkItems").click(function(){  
           $("input[name='items']").attr("checked",$(this).get(0).checked);  
          });
});
</script>
<link href="../css/RoomTable.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div style="height:850px; overflow-x:hidden;overflow-y:scroll">
<table id="tableSort">  
	<thead>
		<tr><td id="addRoom" colspan="9"></td></tr>  
		<tr>  
			<th id="xh"><input type="checkbox" id="checkItems" value=""></th>
			<th>房间名字</th>  
			<th>所属人</th>
			<th>推流地址</th> 
			<th>Logo</th> 
			<th>类型</th>  
			<th class="operation">操作</th> 
		</tr>  
	</thead>  
	<tbody id="trContent">
	</tbody>
	<tbody><tr><td colspan='6' class="tcdPageCode"></td><td style="font-size: 18px;font-weight: bold;">有<span id="roomnumber" style="color: #936;"></span>间房</td></tr></tbody>
</table>
<script type="text/javascript" src="../js/Page.js"></script>
<div id="details"></div>
<div id="detailsup"></div>
</div>
</body>
</html>