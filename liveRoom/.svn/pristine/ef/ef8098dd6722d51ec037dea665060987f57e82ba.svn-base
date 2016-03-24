var fileType;
var file;

function lookList(searchText,roles,state) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		var action = "<a href='javascript:openUserDetailsPage("+row.user_id+")'" + ">查看</a>&nbsp;&nbsp;\
		<a href='javascript:openUserEditPage("+row.user_id+")'" + ">修改</a>&nbsp;&nbsp;";
		if(row.user_state == 1 || row.user_state == 2) {
			action += "<a href='javascript:restoreOne("+row.user_id+")'" + ">还原</a>&nbsp;&nbsp;";
		} else {
			action += "<a href='javascript:deleteOne("+row.user_id+")'" + ">删除</a>&nbsp;&nbsp;";
		}
		return action;
	};
	
	var lastTime = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row["user_lastTime"]);
	};
	
	if(!searchText) {
		searchText = '';
	}
	
	if(!roles) {
		roles = 0;
	}
	
	if(!state) {
		state = 0;
	}
	
	var stateFun = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.user_state == 1) {
			return "已删";
		} else if(row.user_state ==0) {
			return "未删";
		}
	};	
	
	tableData("getAllUser.do?user_teacher=0&roles="+roles+"&state="+state,
			searchText,1, 10, "userTable", [ "user_account",
			"user_name", "user_address", "user_realName",
			"user_phone","user_email","user_level","user_integral","role_name",
			"user_lastTime","user_registerDate","user_state","action"],
			{"action":fun,"user_lastTime":lastTime,"user_state":stateFun},"user_id");
}

function lookList1(searchText,roles,state,teacher) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		var action = "<a href='javascript:openUserDetailsPage1("+row.user_id+")'" + ">查看</a>&nbsp;&nbsp;\
			<a href='javascript:openUserEditPage1("+row.user_id+")'" + ">修改</a>&nbsp;&nbsp;";
			if(row.user_state == 1 || row.user_state == 2) {
				action += "<a href='javascript:restoreOne("+row.user_id+")'" + ">还原</a>&nbsp;&nbsp;";
			} else {
				action += "<a href='javascript:deleteOne("+row.user_id+")'" + ">删除</a>&nbsp;&nbsp;";
			}
		return action;
	};
	
	var lastTime = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row["user_lastTime"]);
	};
	
	if(!searchText) {
		searchText = '';
	}
	
	if(!roles) {
		roles = 0;
	}
	
	if(!state) {
		state = 0;
	}
	
	if(!teacher) {
		teacher = 2;
	}
	
	var stateFun = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.user_state == 1) {
			return "已删";
		} else if(row.user_state ==0) {
			return "未删";
		} else if(row.user_state == 2) {
			return "查封";
		}
	};	
	tableData("getAllUser.do?user_teacher=1&roles="+roles+"&state="+state+"&teacher="+teacher,
			searchText,1, 10, "userTable", [ "user_account",
			"user_name", "user_realName","user_phone","user_lastTime","user_registerDate","user_state","action"],
			{"action":fun,"user_lastTime":lastTime,"user_state":stateFun},"user_id");
}

	
	function openUserAddPage() {
		layer.open({
			title : "用户添加页面",
			type : 2,
			area : [ '700px', '400px' ],
			fix : false, // 不固定
			maxmin : true,
			maxmin : false,
			offset : ['100px' , '500px;'],
			content : '/liveRoom/pages/userAdd.jsp'
		});
	}
	
	/**
	 * 打开用户修改页面
	 * @param userId 用户ID
	 */
	function openUserEditPage(userId) {
		layer.open({
			title : "用户修改页面",
			type : 2,
			area : [ '700px', '400px' ],
			fix : false, // 不固定
			maxmin : true,
			maxmin : false,
			offset : ['100px' , '500px;'],
			content : 'openUserEdit.do?userId='+userId
		});
	}
	
	/**
	 * 打开用户详情页面
	 * @param userId 用户ID
	 */
	function openUserDetailsPage(userId) {
		layer.open({
			title : "用户详情页面",
			type : 2,
			area : [ '700px', '400px' ],
			fix : false, // 不固定
			maxmin : true,
			maxmin : false,
			offset : ['100px' , '500px;'],
			content : 'openUserDetails.do?userId='+userId
		});
	}
	
	function openUserAddPage1() {
		layer.open({
			title : "用户添加页面",
			type : 2,
			area : [ '700px', '500px' ],
			fix : false, // 不固定
			maxmin : true,
			maxmin : false,
			offset : ['100px' , '500px;'],
			content : '/liveRoom/pages/userAdd1.jsp'
		});
	}
	
	/**
	 * 打开用户修改页面
	 * @param userId 用户ID
	 */
	function openUserEditPage1(userId) {
		layer.open({
			title : "用户修改页面",
			type : 2,
			area : [ '700px', '500px' ],
			fix : false, // 不固定
			maxmin : true,
			maxmin : false,
			offset : ['100px' , '500px;'],
			content : 'openUserEdit1.do?userId='+userId
		});
	}
	
	/**
	 * 打开用户详情页面
	 * @param userId 用户ID
	 */
	function openUserDetailsPage1(userId) {
		layer.open({
			title : "用户详情页面",
			type : 2,
			area : [ '700px', '400px' ],
			fix : false, // 不固定
			maxmin : true,
			maxmin : false,
			offset : ['100px' , '500px;'],
			content : 'openUserDetails.do?userId='+userId
		});
	}
	
	/**
	 * 修改用户数据
	 */
	function editUser(userId,userPwd,dengluId,userPath) {
		var form = $('form');
		var files = document.getElementById("fileData").files;
		var file = files[0];
		var user_account = $("#user_account").val();
		var user_pwds = $("#user_pwds").val();
		var user_pwd = $("#user_pwd").val();
		var user_name = $("#user_name").val();
		var user_realName = $("#user_realName").val();
		var fileName=$("#fileName").val();
		if(user_account=="" && user_pwd=="" && user_name=="" && user_realName=="")
		{
			alert("请输入用户信息!");
			$("#user_account").focus();
			$("#user_pwd").focus();
			$("#user_name").focus();
			$("#user_realName").focus();
			return;
		}
		else if(user_pwds=="")
		{
		alert("请输入密码!");
		$("#user_pwds").focus();
		return;
		}
		else if(user_pwd==""){
			alert("请确认密码!");
			$("#user_pwd").focus();
		}
		else if(user_pwd!=user_pwds)
		{
			alert("两次输入密码不一致，请再次确认密码!");
			$("#user_pwd").focus();
			$("#user_pwds").focus();
			return;
		} else {
			var fd = form.serializeArray();
			var userMap = {};
			$.each(fd, function(j, n) {
				if(n['name'] == "user_pwds") {
					return true;
				} else if(n['name'] == "user_pwd") {
					if(n["value"] == userPwd) {
						return true;
					}
				} else if(n['name'] == "fileName") {
					if(n["value"] == "") {
						return true;
					}
				} else if(n['name'] == "user_head") {
					if(!file) {
						return true;
					}
				}
				
				userMap[n['name']]=n['value'];
			});
			var one=fileName.split(".");
			//获取数组中最后一个，即文件名
			var two=one[one.length-1];
			var mydate = new Date();
			var time = mydate.getTime();
			if(file){
			userMap['user_head'] = time  + '.' + two;
			userMap['user_path'] = userPath;
			}
			userMap['user_role'] = $("#role option:selected").val();
			userMap['user_id'] = userId;	
			$.post(form.attr("action"),{mapVo:userMap},function(data) {
				if(data) {
					if(file) {
						var xhr = new XMLHttpRequest();
						var formData = new FormData();
						formData.append("fileData", file);
						formData.append("userId", dengluId);
						formData.append("fileName", time  + '.' + two);
						//xhr.upload.addEventListener("progress", uploadProgress, false);
						xhr.addEventListener("load", uploadComplete, true);
						xhr.open("post", "uploaduserhead.do");
						xhr.send(formData);
					}
					alert("修改成功!");
					parent.refreshTable();
				} else {
					alert("修改失败!");
				}
			});
		}
	}
	
function look(user_id) {
	location.href="userAdd.jsp";
}

/**
 * 删除单个用户
 * @param userId 用户ID
 */
function deleteOne(userId) {
	layer.confirm('是否删除该用户？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteUser.do",{userId:userId},function(data) {
			if(data) {
				layer.msg("用户删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("用户删除失败！", {
					icon : 5,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 删除所选中的用户
 */
function deleteMany() {
	var ids = $("input:checkbox[name='ck']:checked").map(
			function(index, elem) {
				return $(elem).val();
			}).get().join(',');
	if(ids==null || ids=="")
	{
		layer.msg("请勾选", {
			icon : 1,
			time:1000,
			offset : ['300px' , '800px']
		});
	}else
		{
	
	layer.confirm('你确定要删除选中的用户么？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deletesUser.do",{userIds:ids},function(data) {
			if(data) {
				layer.msg("用户删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("用户删除失败！", {
					icon : 5,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
		}
}


/**
 * 还原单个用户
 * @param userId 用户ID
 */
function restoreOne(userId) {
	layer.confirm('是否还原该用户？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("restoreUser.do",{userId:userId},function(data) {
			if(data) {
				layer.msg("用户还原成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("用户还原失败！", {
					icon : 5,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 还原所选中的用户
 */
function restoreMany() {
	var ids = $("input:checkbox[name='ck']:checked").map(
			function(index, elem) {
				return $(elem).val();
			}).get().join(',');
	if(ids==null || ids=="")
	{
		layer.msg("请勾选", {
			icon : 1,
			time:1000,
			offset : ['300px' , '800px']
		});
	}else
		{
	layer.confirm('你确定要还原选中的用户么？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post(" restoresUser.do",{userIds:ids},function(data) {
			if(data) {
				layer.msg("用户还原成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("用户还原失败！", {
					icon : 5,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
		}
}

function addUser(userId,userName) {
	var form = $('form');
	var files = document.getElementById("fileData").files;
	var file = files[0];
	var user_account = $("#user_account").val();
	var user_pwds = $("#user_pwds").val();
	var user_pwd = $("#user_pwd").val();
	var user_name = $("#user_name").val();
	var user_realName = $("#user_realName").val();
	var fileName=$("#fileName").val();
	if(user_account=="" && user_pwd=="" && user_name=="" && user_realName=="")
	{
		alert("请输入用户信息!");
		$("#user_account").focus();
		$("#user_pwd").focus();
		$("#user_name").focus();
		$("#user_realName").focus();
		return;
	}
	else if(user_pwds=="")
	{
	alert("请输入密码!");
	$("#user_pwds").focus();
	return;
	}
	else if(user_pwd==""){
		alert("请确认密码!");
		$("#user_pwd").focus();
		return;
	}
	else if(user_pwd!=user_pwds)
	{
		alert("两次输入密码不一致，请再次确认密码!");
		$("#user_pwd").focus();
		$("#user_pwds").focus();
		return;
	}else {
		var fd = form.serializeArray();
		var userMap = {};
		$.each(fd, function(j, n) {
			if(n['name'] == "user_pwds") {
				return true;
			}else if(n['name'] == "fileName") {
				if(n["value"] == "") {
					return true;
				}
			}
			userMap[n['name']]=n['value'];
		});
		var one=fileName.split(".");
		//获取数组中最后一个，即文件名
		var two=one[one.length-1];
		var mydate = new Date();
		var time = mydate.getTime();
		if(file){
			userMap['user_head'] = time  + '.' + two;	
		}
		
		$.post("validateAccount.do?account="+user_account,function(data) {
			if(data) {
				alert("该用户名已被注册！请重新填写");
				return;
			}
			userMap['user_role'] = $("#role option:selected").val();
			$.post(form.attr("action"),{mapVo:userMap},function(data) {
				if(data) {
					if(fileName!=""){
					var xhr = new XMLHttpRequest();
					var formData = new FormData();
					formData.append("fileData", file);
					formData.append("userId", userId);
					formData.append("fileName", time  + '.' + two);
					//xhr.upload.addEventListener("progress", uploadProgress, false);
					xhr.addEventListener("load", uploadComplete, true);
					xhr.open("post", "uploaduserhead.do");
					xhr.send(formData);
					}
					alert("添加成功!");
					parent.refreshTable();
				} else {
					alert("添加失败!");
				}
			});
		});
	}
}
function fileSelect() {
	var files = document.getElementById("fileData").files;
	file = files[0];
	fileType = file.type;
	$("#img").html('<img src="'+window.URL.createObjectURL(file)+'" width="30px" height="30px">');
	if(fileType.split("/")[0] != "image") {
		alert("格式不正确，请重新选择！");
		return;
	}
	if(file.size > 10*1024*1024) {
		alert("上传文件不能大于10M");
		return;
	}
	
	$("#fileName").val(file.name);
}

function uploadProgress(evt) {
    if (evt.lengthComputable) {
        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
    } else {
        document.getElementById('progressNumber').innerHTML = '上传成功';
    }
}

function uploadComplete(evt) {
	var loadResult = eval("("+evt.target.responseText+")");
	if(loadResult) {
		parent.refreshTable("操作成功!");
	}
}

function selectBox(user_role) {
    /*获取推荐人下拉框列表 */
	$.post('roleSelectList.do', function(data) {
		//将字符串转换成json数据
		var json = data;
		
		//获取json长度（推荐人数量）
		var len = json.length;
		
		//定义推荐人下拉内容接受对象
		var content = "";
		
		/*循环拼接下拉内容*/
		for (var i = 0; i < len; i++) {
			content += "<option value=" + json[i]["role_id"] + ">" + json[i]["role_name"]
					+ "</option>";
		}
		$("#role").append(content);
		$("#role option[value='" + user_role + "']").attr("selected", true);
	});
}

function select() {
    /*获取推荐人下拉框列表 */
	$.post('roleSelectList.do', function(data) {
		//将字符串转换成json数据
		var json = data;
		
		//获取json长度（推荐人数量）
		var len = json.length;
		
		//定义推荐人下拉内容接受对象
		var content = "<option value='0'>查看所有角色</option>";
		/*循环拼接下拉内容*/
		for (var i = 0; i < len; i++) {
			content += "<option value=" + json[i]["role_id"] + ">" + json[i]["role_name"]
					+ "</option>";
		}
		$("#roles").html(content);
	});
}

/**
 * 搜索
 */
function search() {
	lookList($("#search").val());
}

/**
 * 搜索
 */
function search1() {
	lookList1($("#search").val());
}

/**
 * 根据角色搜索
 */

function beforeUser() {
	lookList1('',0,$("#state option:selected").val());
}

function afterUser() {
	lookList('',0,$("#state option:selected").val());
}

function afterRole() {
	lookList('',$("#roles option:selected").val(),$("#state option:selected").val());
}

function teacherCombox() {
	lookList1('',0,$("#state option:selected").val(),$("#teacher option:selected").val());
}

/**
 * 刷新页面
 * 
 * @author 周化益
 * @param msg 提示信息
 */
function refreshTable(msg) {
	layer.msg(msg, {
		icon : 1,
		time : 1500
	}, function() {
		CommonRefreshTable();
	});
	layer.closeAll();
}

/**
 * 给手机号赋值
 */
function addPhoneValue() {
	$('#account').val($("#user_phone").val());
}
