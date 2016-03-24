if (typeof console == "undefined") {
	this.console = {
		log : function(msg) {
		}
	};
}
var ws, username = {}, reconnect = false;
WEB_SOCKET_SWF_LOCATION = "js/WebSocketMain.swf";
WEB_SOCKET_DEBUG = true;
function init() {

	// 创建websocket
	ws = new WebSocket("ws://192.168.10.10:5069");
	// 当socket连接打开时，输入用户名
	ws.onopen = function() {
		if (reconnect == false) {

			// 登录
			console.log("连接成功！开始登陆...");
			var msg = "{\"type\":" + "\"touristLogin\",\"roomID\":\"10001\"}";
			ws.send(msg);
			reconnect = true;
		} else {
			// 断线重连
		}
	};
	// 当有消息时根据消息类型显示不同信息
	ws.onmessage = function(e) {
		console.log(e.data);
		var data = eval("(" + e.data + ")");
		switch (data.type) {
		case 'ping':
			ws.send("{\"type\" : \"pong\"}");
			break;
		// 登录成功
		case 'loginSession':
			username = data.username;
			$("#span_username").html(username);
			break;
		case 'allSession':
			getAllMsg(data);
			break;
		case 'msgSession':
			$("#content").val("");
			break;
		case 'allList':
			$("#Member").html("");
			var MemberList=data.list;
			for(var i in MemberList){
				var html="<li><div class='media-left nemeleft'><img src='img/jops.png'></div>"+
				"<div class='nemecont'>"+MemberList[i].name+"</div>"+
				"<div class='nemeright'>"+
				"<div class='progress progress2'>"+
				"<div class='progress-bar progress-bar-warning'"+
				"role='progressbar' aria-valuenow='20' aria-valuemin='0'"+
				"aria-valuemax='100' style='width: 20%'><span class='sr-only'>20%</span></div></div></div></li>"
				$("#Member").append(html);
			   };
			break;
		case 'Logonfailure':
			alert("用户名或密码错误");
		}
	};

	ws.onclose = function() {
		console.log("连接关闭，定时重连");
		// 定时重连
		//		window.clearInterval(timeid);
		//timeid = window.setInterval(init, 3000);
	};
	ws.onerror = function() {
		console.log("出现错误");
	};
}

/*******************************************************************************
 * 展示公聊消息
 */
function getAllMsg(obj) {
	var content = "<div class=\"media\">"
			+ "<a class=\"media-left\" href=\"#\"><img src=\"img/portrait.png\"></a>"
			+ "<div class=\"media-body tospeak\">"
			+ "<h4 class=\"media-heading\">" + "<span class=\"name_time\">"
			+ obj.username + "</span><span class=\"name_time\">" + obj.time
			+ "</span>" + "</h4>" + "<p class=\"speech-bubble one\">"
			+ obj.context + "<br />" + "</p>"
			/*
			 * + "<p class=\"inoger\">" + "<span class=\"ger_x\"><img
			 * src=\"img/Intothe.png\"></span>欢迎<span" + "class=\"ger_y\"><u>赢世界赢自己</u></span>加入房间" + "</p>"
			 */
			+ "</div>";
	if ($("#content_div [class=\"media\"]").html() == null) {
		$($("#content_div [id=\"mCSB_9_container\"]")).before(content);
	} else {
		$(($("#content_div [class=\"media\"]"))[0]).before(content);
	}

	//	$($("#content_div [id=\"mCSB_9_container\"]")).appendTo(content);
}

/*******************************************************************************
 * 发送公聊消息
 */
function send() {
	var context = $("#content").val();
	if (context.trim() != "") {
		var msg = "{\"type\":\"all\",\"roomID\":\"10001\",\"context\":\""
				+ context + "\",\"username\":\"" + username + "\"}";
		ws.send(msg);
	} else {
		alert("消息内容不能为空");
	}

}

$("#send").click(function() {
});
/**
 * 用户登录
 * @param 吴耀宗
 * @param value
 */
function login()
{
	var username=$("#dl_blur").val();
	var pwd=$("#pwd").val();
	if (username.trim() != ""&&pwd.trim()!="") {
		var msg = "{\"type\":\"login\",\"roomID\":\"10001\",\"username\":\"" + username + "\",\"pwd\":\""+pwd+"\"}";
		ws.send(msg);
	} else {
		alert("用户名或密码不能为空");
	}
	
		

}

function SetCookie(name, value)// 两个参数，一个是cookie的名子，一个是值
{
	var Days = 300; // 此 cookie 将被保存 30 天
	var exp = new Date(); // new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	// document.cookie = name + "="+ escape (value) + ";expires=" +
	// exp.toGMTString();
	document.cookie = name + "=" + value + ";expires=" + exp.toGMTString();
}
function getCookie(name)// 取cookies函数
{
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return (arr[2]);
	return null;
}
function delCookie(name)// 删除cookie
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}