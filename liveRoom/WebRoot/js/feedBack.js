/**
 * 反馈列表查询
 * @author 周化益
 * @param searchText 搜索框的内容
 */
function boardList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
/*		return "<a href='javascript:openBoardEditPage("+row.id+")'" + ">修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne("+ row.id + ")'>删除</a>";*/
		return "<a href='javascript:deleteOne("+ row.id + ")'>删除</a>";
	};
	
	var content = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.content.length > 30) {
			return row.content.substring(0,30) + "......";
		} else {
			return row.content;
		}
	};
	
	var time = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row.times);
	};

	if(!searchText) {
		searchText = '';
	}
	
	tableData("searchFeedList.do", searchText, 1, 10, "feedBackTable", ["phone","times","content","user_realName", "action" ], {
		"action" : fun,
		"times" : time,
		"content" : content,
	},"id");
}

/**
 * 搜索
 */
function search() {
	boardList($("#search").val());
}

/**
 * 删除单条记录
 * @param feedBackId 反馈ID
 */
function deleteOne(feedBackId) {
	layer.confirm('是否删除该反馈？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteFeedBack.do",{feedBackId:feedBackId},function(data) {
			if(data) {
				refreshTable("反馈删除成功!");
			} else {
				refreshTable("反馈删除失败！!");
			}
		});
	});
}

/**
 * 删除所选中的反馈
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
	layer.confirm('你确定要删除选中的反馈么？', {icon: 3,offset : ['300px' , '800px;']}, function() {
		$.post("deleteFeedBacks.do",{feedBackIds:ids},function(data) {
			if(data) {
				refreshTable("反馈删除成功!");
			} else {
				refreshTable("反馈删除失败！!");
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