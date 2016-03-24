
function lookList() {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		//<a href='javascript:void(0)' onclick='look(" + row.USER_ID + ")'>查看</a>&nbsp;&nbsp;\
		return "<a href='javascript:void(0) onclick='deleteOne(" + row.room_message_id + ")'>删除</a>";
	};
		
	var stateFun = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.room_message_state == 0) {
			return "已删除";
		} else if(row.room_message_state ==1) {
			return "正常";
		}
		else if(row.room_message_state ==2) {
			return "屏蔽";
		}
	};	
	var roommessageTime = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row["room_message_date"]);
	};
	tableData("getAllRoomChat.do",{}, 1, 10, "roomchatTable", [ "room_message_id",
			"room_message_user", "room_message_room", "room_message_date", "room_message_content",
			"room_message_state","action"],
			{"action":fun,"room_message_date":roommessageTime,"user_state":stateFun});
	};
function deleteOne(room_message_id) {
	alert("删除单条数据");
}   