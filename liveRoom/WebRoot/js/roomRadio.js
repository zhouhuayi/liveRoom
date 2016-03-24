function roomRadioList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openRoomRadioEditPage("+row.id+")'" + ">修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne(" + row.id + ")'>删除</a>";
	};
	
	var time = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row.createtime);
	};
	
	var type = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.type == 1) {
			return "事件";
		} else {
			return "重要通知";
		}
	};

	if(!searchText) {
		searchText = '';
	}
	
	tableData("getRoomRadioList.do", searchText, 1, 10, "roomRadioTable", [ "content","room_name","createtime",
	    "user_realName","type", "action" ], {
		"action" : fun,
		"createtime" : time,
		"type" : type
	},"id");
}

/**
 * 搜索
 */
function search() {
	roomRadioList($("#search").val());
}

/**
 * 打开房间通知添加页面
 */
function openRoomRadioAddPage() {
	layer.open({
		title : "房间通知添加页面",
		type : 2,
		area : [ '650px', '500px' ],
		fix : false, // 不固定
		maxmin : false,
		offset : ['100px' , '500px'],
		content : '/liveRoom/pages/roomRadioAdd.jsp'
	});
}

/**
 * 打开房间通知修改页面
 * @param roomRadioId 房间通知ID
 */
function openRoomRadioEditPage(roomRadioId) {
	layer.open({
		title : "房间通知修改页面",
		type : 2,
		area : [ '650px', '500px' ],
		fix : false, // 不固定
		maxmin : false,
		offset : ['100px' , '500px'],
		content : 'openRoomRadioEdit.do?roomRadioId='+roomRadioId
	});
}

/**
 * 添加房间通知方法
 */
function addOrEditRoomRadio() {
	var form = $('form');
	var fd = form.serializeArray();
	var roomRadioMap = {};
	$.each(fd, function(j, n) {
		roomRadioMap[n['name']]=n['value'];
	});
	$.post(form.attr("action"),{mapVo:roomRadioMap},function(data) {
		if(data) {
			parent.refreshTable("保存成功");
		} else {
			parent.refreshTable("保存失败");
		}
	});
}

/**
 * 删除单条记录
 * @param roomRadioId 房间通知ID
 */
function deleteOne(roomRadioId) {
	layer.confirm('是否删除该房间通知？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteRoomRadio.do",{roomRadioId:roomRadioId},function(data) {
			if(data) {
				layer.msg("房间通知删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("房间通知删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 删除所选中的房间通知
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
	layer.confirm('你确定要删除选中的房间通知么？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteManyRoomRadio.do",{roomRadioIds:ids},function(data) {
			if(data) {
				layer.msg("房间通知删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("房间通知删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
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
		time : 1500,
		offset : ['100px' , '500px']
	}, function() {
		CommonRefreshTable();
	});
	layer.closeAll();
}

function selectBox(roomid) {
    /*获取推荐人下拉框列表 */
	$.post('roomSelectList.do', function(data) {
		//将字符串转换成json数据
		var json = data;
		
		//获取json长度（推荐人数量）
		var len = json.length;
		
		//定义推荐人下拉内容接受对象
		var content = "";
		/*循环拼接下拉内容*/
		for (var i = 0; i < len; i++) {
			content += "<option value=" + json[i]["room_id"] + ">" + json[i]["room_name"]
					+ "</option>";
		}
		$("#roomid").html(content);
		$("#roomid option[value='" + roomid + "']").attr("selected", true);
	});
}