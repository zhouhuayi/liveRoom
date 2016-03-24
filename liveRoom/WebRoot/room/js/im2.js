var ws = new WebSocket("ws:192.168.0.9:5069");

ws.onopen = function() {
	console.log("连接成功！开始登陆...");
	var msg = "{\"type\":" + "\"touristLogin\",\"roomID\":\"10002\"}";
	ws.send(msg);
};

ws.onmessage = function(evt) {
	console.log(evt.data);
	var obj = eval("(" + evt.data + ")");
	if (obj.type == "loginSession") {
		alert("登陆成功！");
	} else if (obj.type == "allSession") {

		var content = "<div class=\"media\">"
				+ "<a class=\"media-left\" href=\"#\"><img src=\"img/portrait.png\"></a>"
				+ "<div class=\"media-body tospeak\">"
				+ "<h4 class=\"media-heading\">"
				+ "<span class=\"name_time\">" +obj.username
				+"</span><span class=\"name_time\">20:27</span>"
				+ "</h4>"
				+ "<p class=\"speech-bubble one\">"
				+ obj.context+ "<br />"
				+ "</p>"
		/*		+ "<p class=\"inoger\">"
				+ "<span class=\"ger_x\"><img src=\"img/Intothe.png\"></span>欢迎<span"
				+ "class=\"ger_y\"><u>赢世界赢自己</u></span>加入房间"
				+ "</p>" */
				+ "</div>";
		
		//
//		alert($($("#content_div [id=\"mCSB_9\"]")).html());
		
		$($("#content_div [id=\"mCSB_9\"]")).append(content);
		//		  {"type":"allSession","roomID":"10001","context":"qqq"}
	}
	//	ws.close();
};

ws.onclose = function(evt) {
	console.log("连接关闭!");
};

ws.onerror = function(evt) {

	console.log("连接失败！");
};

function send() {
	var msg = "{\"type\":\"all\",\"roomID\":\"10002\",\"context\":\""
			+ $("#content").val() + "\"}";
	ws.send(msg);
}

$("#send").click(function() {
	alert();
});