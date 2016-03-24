/**
 * @author 周化益
 */
var fileType;
var file;
var isIE = false;
var fileId;
/**
 * 获取角色列表信息
 */
function roleList(searchValue) {
	/**
	 * 添加操作列
	 */
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openRoleEditPage("+row.role_id+")'>修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne("+ row.role_id + ")'>删除</a>";
	};
	
	/**
	 * 图片显示
	 */
	var image = function formatterColumn(index) {
		var row = getRowData(index);
		return '<img width="32" height="32" src="'+row.role_icon+'">';
	};
	
	if(!searchValue) {
		searchValue = "";
	}
	
	/**
	 * 调用通用表格
	 */
	tableData("getAllRole.do", searchValue, 1, 10, "roleTable", ["role_icon", "role_name", "action" ],{
		"action" : fun,
		"role_icon" : image
	},"role_id");
}

/**
 * 删除单条记录
 * @param role_id 角色ID
 */
function deleteOne(role_id) {
	layer.confirm('是否删除该角色？', {icon: 3 ,offset : ['300px' , '800px']}, function() {
		$.post("deleteRole.do",{roleId:role_id},function(data) {
			if(data == 0) {
				layer.msg("角色删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			} else if(data == 1) {
				layer.msg("请先删除所属该角色的用户！！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			} else {
				layer.msg("角色删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			}
		});
	});
}

/**
 * 删除所选中的角色
 */
function deleteMany() {
	var ids = $("input:checkbox[name='ck']:checked").map(
			function(index, elem) {
				return $(elem).val();
			}).get().join(',');
	if(ids=="") {
		layer.msg("请选择要删除数据！", {
			icon : 6,
			time:1000,
			offset : ['300px' , '800px']
		});
		return;
	}
	layer.confirm('你确定要删除选中的角色么？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteManyRole.do",{roleIds:ids},function(data) {
			if(data == 0) {
				layer.msg("角色删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			} else if(data == 1) {
				layer.msg("请先删除所属该角色的用户！！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			} else {
				layer.msg("角色删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			}
		});
	});
}

/**
 * 打开角色添加页面
 */
function openRoleAddPage() {
	layer.open({
		title : "角色添加页面",
		type : 2,
		area : [ '700px', '550px' ],
		fix : false, // 不固定
		maxmin : true,
		offset : ['100px' , '500px'],//上左距离
		content : '/liveRoom/pages/roleAdd.jsp'
	});
}

/**
 * 打开修改页面
 * @param roleId 角色ID
 */
function openRoleEditPage(roleId) {
	layer.open({
		title : "角色添加修改",
		type : 2,
		area : [ '700px', '550px' ],
		fix : false, // 不固定
		maxmin : true,
		offset : ['100px' , '500px'],
		content : 'updateRole.do?roleId='+roleId
	});
}

/**
 * 添加角色数据
 */
function addRole(userId) {
	var power = $("input:checked");
	if(!$('#role_name').val() || $('#role_name').val() == '') {
		validateInfo("请输入角色名！");
		return;
	}
	
	var ids = '';
	if(power.length > 0) {
		power.each(function() {
			ids += this.id.replace('t', ',');
		});
		ids = ids.substring(1, ids.length);
	}
	if(!file) {
		validateInfo("请上传图片!");
		return;
	} else {
		var form = $('form');
		var xhr = new XMLHttpRequest();
		fileName = file.name;
		var one=fileName.split(".");
		//获取数组中最后一个，即文件名
		var two=one[one.length-1];
		var mydate = new Date();
		var time = mydate.getTime();
		var formData = new FormData();
		formData.append("fileData", file);
		formData.append("roleId", userId);
		formData.append("powerIds", ids);
		formData.append("fileName", time  + '.' + two);
		formData.append("role_name", $("#role_name").val());
		xhr.addEventListener("load", uploadComplete, true);
		xhr.open("post", form.attr("action"));
		xhr.send(formData);
	}
}

/**
 * 修改角色数据
 */
function editRole(roleId,userId,rolePath) {
	var power = $("input:checked");
	if(!$('#role_name').val() || $('#role_name').val() == '') {
		validateInfo("请输入角色名！");
		return;
	}
	var ids = '';
	if(power.length > 0) {
		power.each(function() {
			ids += this.id.replace('t', ',');
		});
		ids = ids.substring(1, ids.length);
	}
	
	var form = $('form');
	
	var fd = form.serializeArray();
	var fileName = $("#fileName").val();
	var roleMap = {};
	
	$.each(fd, function(j, n) {
		roleMap[n['name']]=n['value'];
	});
	var one=fileName.split(".");
	//获取数组中最后一个，即文件名
	var two=one[one.length-1];
	var mydate = new Date();
	var time = mydate.getTime();
	if(file) {
		roleMap['role_icon'] = time + "." + two;
	}
	roleMap['rolePath'] = rolePath;
	roleMap['role_id'] = roleId;
	roleMap['powerIds'] = ids;
	
	$.post(form.attr("action"),{mapVo:roleMap},function(data) {
		if(data) {
			if(file) {
				if(isIE) {
					$.ajaxFileUpload({
						url : 'uploadRole.do',
						data : {
							roleId : userId,
							fileName : time + "." + two
						},
						dataType:"text",// 用于文件上传的服务器端请求地址
						secureuri : false, // 一般设置为false
						fileElementId : fileId,
						success : function(data) // 服务器成功响应处理函数
						{
							alert(data);
						},
						error : function() {
							alert("上传异常");
						}
					});
				} else {
					var xhr = new XMLHttpRequest();
					var formData = new FormData();
					formData.append("fileData", file);
					formData.append("roleId", userId);
					formData.append("fileName", time + "." + two);
					xhr.addEventListener("load", uploadComplete, true);
					xhr.open("post", "uploadRole.do");
					xhr.send(formData);
				}
			} else {
				parent.refreshTable("保存成功!");
			}
		} else {
			alert("添加失败！");
		}
	});
}

/**
 * 选择文件后进行验证
 */
function fileSelect() {
	var agent = window.navigator.userAgent;
	var isIE7 = agent.indexOf('MSIE 7.0') != -1;
    var isIE8 = agent.indexOf('MSIE 8.0') != -1;
    //IE7和IE8获得文件路径
    if (isIE7 || isIE8) {
    	file = document.getElementById("fileData");
		fileId = "fileData";
		isIE = true;
    	file.select();
        filepath = document.selection.createRange().text;
        console.info(filepath);
        $("#img").html('<img src="'+filepath+'" width="30px" height="30px"/>');
    } else {
    	file = document.getElementById("fileData").files[0];
    	$("#img").html('<img src="'+window.URL.createObjectURL(file)+'" width="30px" height="30px">');
    	fileType = file.type;
    	if(fileType.split("/")[0] != "image") {
    		alert("格式不正确，请重新选择！");
    		return;
    	}
    	if(file.size > 10*1024*1024) {
    		alert("上传文件不能大于10M");
    		return;
    	}
    }
    $("#fileName").val(file.name);
}

/**
 * 上传完成调用的方法
 */
function uploadComplete(evt) {
	var loadResult = eval("("+evt.target.responseText+")");
	if(loadResult) {
		parent.refreshTable("操作成功!");
	}
}

/**
 * 获取树形权限列表
 * 
 * @author 周化益
 * @param acceptId 内容接受ID
 * @param roleId 角色ID
 */
function getPowerList(acceptId,roleId) {
	$.post("powerList.do", function(data) {
		$("#" + acceptId).html(treeList(data));
		$("#browser").treeview({});
		if(roleId) {
			initPower(roleId);
		}
	});
}

/**
 * 根据角色ID获取权限并选中给角色所拥有的权限
 * @author 周化益
 * @param roleId 角色ID
 */
function initPower(roleId) {
	$.post("getPowerIdByRole.do?roleId="+roleId, function(data) {
		$.each(data, function(j, n) {
			document.getElementById("t"+n).checked = true;
		});
	});
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
 * 搜索
 */
function search() {
	roleList($("#search").val());
}