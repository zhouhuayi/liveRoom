function roomPrivateMessageList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:void(0)' onclick='deleteOne("+ row.room_private_message_id + ")'>删除</a>";
	};
	
	var time = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row.room_private_message_date);
	};
	
	if(!searchText) {
		searchText = '';
	}
	
	tableData("getAllRoomPrivateMessage.do",searchText, 1, 10, "roomPrivateMessageTable", ["user_name","uname","room_private_message_date",
	    "room_private_message_content","room_name","action" ], {
		"action" : fun,
		"room_private_message_date" : time},"room_private_message_id");
}

/**
 * 搜索
 */
function search() {
	roomPrivateMessageList($("#search").val());
}

/**
 * 删除单条聊天记录
 * @param roomprivateMessageId 聊天记录ID
 */
function deleteOne(roomprivateMessageId) {
	layer.confirm('是否删除该条聊天记录？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteroomprivateMessage.do",{roomprivateMessageId:roomprivateMessageId},function(data) {
			if(data) {
				layer.msg("删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("删除失败！", {
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
	layer.confirm('你确定要删除选中的聊天记录吗？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deletesroomprivateMessage.do",{roomprivateMessageIds:ids},function(data) {
			if(data) {
				layer.msg("删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("删除失败！", {
					icon : 5,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
		}
}
