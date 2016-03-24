function PowerList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openPowerEditPage("+row.power_id+")'" + ">修改</a>&nbsp;\
		<a href='javascript:deleteOne("+row.power_id+")'" + ">删除</a>";
	};
	
	var parentFun = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.pname==null) {
			return " ";
		}
		else
		{
			return row.pname;
		}
			
	};
	if(!searchText) {
		searchText = '';
	}
	
	tableData("getAllPower.do",searchText,1,10,"powerTable",["power_name","power_url",
	   "pname","action" ], 
	   {"action" : fun,"pname" : parentFun},"power_id");
}

function openPowerAddPage() {
	layer.open({
		title : "权限添加页面",    
		type : 2,
		area : [ '400px', '300px' ],
		fix : false, // 不固定
		maxmin : true,
		offset : ['200px' , '600px'],
		maxmin : false,
		offset : ['200px' , '600px;'],
		content : '/liveRoom/pages/powerAdd.jsp'
	});
}
/**
 * 打开权限修改页面
 * @param powerId 权限ID
 */
function openPowerEditPage(powerId) {
	layer.open({
		title : "权限修改页面",
		type : 2,
		area : [ '400px', '300px' ],
		fix : false, // 不固定
		maxmin : true,
		offset : ['200px' , '600px'],
		maxmin : false,
		offset : ['200px' , '600px;'],
		content : 'openPowerEdit.do?powerId='+powerId
	});
}

/**
 * 搜索
 */
function search() {
	PowerList($("#search").val());
}

/**
 * 添加权限
 */
function addPower() {
	var form = $('form');
	var fd = form.serializeArray();
	var powerMap = {};
	var power_url=$("#power_url").val();
	var power_name=$("#power_name").val();
	var power_parentId=$("#power").val();
	console.info(fd);
		if(power_name=="")
		{
			alert("请输入权限名称!");
			$("#power_name").focus();
			return;
		}else{
	$.each(fd, function(j, n) {
		if("power_url"==n['name']){
			if(!n["value"]) {
				n["value"] = "#";				
			}
		}else if(n['name'] == "power_parentId") {
			if(n["value"] == "") {
				return true;
			}
		}
		powerMap[n['name']]=n['value'];
	});
	$.post(form.attr("action"),{mapVo:powerMap},function(data) {
		if(data) {
			alert("添加成功!");
			parent.refreshTable();
		} else {
			alert("添加失败!");
			parent.refreshTable();
		}
	});
		}
}

/**
 * 修改权限
 */
function EditPower(powerId) {
	var form = $('form');
	var fd = form.serializeArray();
	var powerMap = {};
	var power_url=$("#power_url").val();
	var power_name=$("#power_name").val();
	console.info(fd);
		if(power_name=="")
		{
			alert("请输入权限名称!");
			$("#power_name").focus();
			return;
		}else{
	$.each(fd, function(j, n) {
		if("power_url"==n['name']){
			if(!n["value"]) {
				n["value"] = "#";				
			}
		}
		powerMap[n['name']]=n['value'];
	});
	powerMap['power_id'] = powerId;
	$.post(form.attr("action"),{mapVo:powerMap},function(data) {
		if(data) {
			alert("修改成功!");
			parent.refreshTable();
		} else {
			alert("修改失败!");
			parent.refreshTable();
		}
	});
		}
}

/**
 * 删除单条权限
 * @param powerId 权限ID
 */
function deleteOne(powerId) {
	layer.confirm('是否删除该条权限？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deletePower.do",{powerId:powerId},function(data) {
			if(data) {
				layer.msg("权限删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("权限删除失败！", {
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
		$.post("deletePowers.do",{powerIds:ids},function(data) {
			if(data) {
				layer.msg("权限删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("权限删除失败！", {
					icon : 5,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
		}
}
var parent;
function selectBox(power_parentId) {
    /*获取推荐人下拉框列表 */
	$.post('powerList.do', function(data) {
		//将字符串转换成json数据
		var json = data;
		
		//获取json长度（推荐人数量）
		var len = json.length;
		
		//定义推荐人下拉内容接受对象
		var content = "";
		
		/*循环拼接下拉内容*/
		for (var i = 0; i < len; i++) {
			content += "<option value=" + json[i]["power_id"] + ">" + json[i]["power_name"]
					+ "</option>";
		}
		$("#power").append(content);
	/*	parent = power_parentId;*/
		$("#power option[value='" + power_parentId + "']").attr("selected", true);
	});
}
/**
 * 刷新页面
 * 
 * @author 李琼雅
 * @param msg 提示信息
 */
function refreshTable(msg) {
	layer.msg(msg, {
		icon : 1,
		time : 1500,
		offset : ['200px' , '550px;']
	}, function() {
		CommonRefreshTable();
	});
	layer.closeAll();
}
