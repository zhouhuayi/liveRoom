function friendChatList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:void(0)' onclick='deleteOne(" + row.id
				+ ")'>删除</a>";
	};

	var time = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row.createtime);
	};

	if (!searchText) {
		searchText = '';
	}

	tableData("getAllFriendChat.do", searchText, 1, 10, "friendChatTable", [
			"user_name", "uname", "createtime", "content", "action" ], {
		"action" : fun,
		"createtime" : time},"id");
}
/**
 * 搜索
 */
function search() {
	friendChatList($("#search").val());
}

/**
 * 删除单条聊天记录
 * 
 * @param friendchatId
 *            聊天记录ID
 */
function deleteOne(friendchatId) {
	layer.confirm('是否删除该条聊天记录？', {
		icon : 3
	}, function() {
		$.post("deletefriendchat.do", {
			friendchatId : friendchatId
		}, function(data) {
			if (data) {
				layer.msg("删除成功！", {
					icon : 6,
					time : 1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("删除失败！", {
					icon : 5,
					time : 1000,
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
	var ids = $("input:checkbox[name='ck']:checked").map(function(index, elem) {
		return $(elem).val();
	}).get().join(',');
	if (ids == null || ids == "") {
		layer.msg("请勾选", {
			icon : 1,
			time:1000,
			offset : ['300px' , '800px']
		});
	} else {
		layer.confirm('你确定要删除选中的聊天记录吗？', {
			icon : 3
		}, function() {
			$.post("deletesfriendchat.do", {
				friendchatIds : ids
			}, function(data) {
				if (data) {
					layer.msg("删除成功！", {
						icon : 6,
						time : 1000,
						offset : ['300px' , '800px']
					}, function() {
						CommonRefreshTable();
					});
				} else {
					layer.msg("删除失败！", {
						icon : 5,
						time : 1000,
						offset : ['300px' , '800px']
					});
				}
			});
		});
	}
}
