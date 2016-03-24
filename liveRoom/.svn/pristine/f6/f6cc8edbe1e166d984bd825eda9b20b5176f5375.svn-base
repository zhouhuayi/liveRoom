/**
 * 留言列表查询
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
	
	tableData("searchBoardList.do", searchText, 1, 10, "boardTable", ["address","times","content","phone", "action" ], {
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
 * 打开留言添加页面
 */
function openBoardAddPage() {
	layer.open({
		title : "留言添加页面",
		type : 2,
		area : [ getPageWidth(1), getpageHeight()],
		fix : false, // 不固定
		maxmin : false,
		//offset : ['0' , '0'],
		content : '/liveRoom/pages/boardAdd.jsp'
	});
}

/**
 * 打开留言修改页面
 * @param newsId 留言ID
 */
function openBoardEditPage(BoardId) {
	layer.open({
		title : "留言修改页面",
		type : 2,
//		area : [ getPageWidth(1), getpageHeight()],
		fix : false, // 不固定
		maxmin : false,
//		offset : ['0' , '0'],
		content : 'openBoardPage.do?boardId='+BoardId
	});
}

/**
 * 添加留言方法
 * addEdit 添加或修改1：添加，2修改
 */
function addOrEdit(addEdit,account,password) {
	var form = $('form');
	var fd = form.serializeArray();
	var BoardMap = {};
	
	$.each(fd, function(j, n) {
		BoardMap[n['name']]=n['value'];
	});
	
	$.post(form.attr("action"),{mapVo:BoardMap},function(data) {
		if(data > 0) {
			parent.refreshTable("操作成功!");
		} else {
			validateInfo("添加失败");
		}
	});
}

/**
 * 删除单条记录
 * @param newsId 留言ID
 */
function deleteOne(BoardId) {
	layer.confirm('是否删除该留言？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteBoard.do",{boardId:BoardId},function(data) {
			if(data) {
				refreshTable("留言删除成功!");
			} else {
				refreshTable("留言删除失败！!");
			}
		});
	});
}

/**
 * 删除所选中的留言
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
	layer.confirm('你确定要删除选中的留言么？', {icon: 3,offset : ['300px' , '800px;']}, function() {
		$.post("deleteBoards.do",{boardIds:ids},function(data) {
			if(data) {
				refreshTable("留言删除成功!");
			} else {
				refreshTable("留言删除失败！!");
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