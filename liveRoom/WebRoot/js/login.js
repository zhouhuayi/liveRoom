$(function() {
	//得到焦点
	$("#password").focus(function() {
		$("#left_hand").animate({
			left : "150",
			top : " -38"
		}, {
			step : function() {
				if (parseInt($("#left_hand").css("left")) > 140) {
					$("#left_hand").attr("class", "left_hand");
				}
			}
		}, 2000);
		$("#right_hand").animate({
			right : "-64",
			top : "-38px"
		}, {
			step : function() {
				if (parseInt($("#right_hand").css("right")) > -70) {
					$("#right_hand").attr("class", "right_hand");
				}
			}
		}, 2000);
	});
	//失去焦点
	$("#password").blur(function() {
		$("#left_hand").attr("class", "initial_left_hand");
		$("#left_hand").attr("style", "left:100px;top:-12px;");
		$("#right_hand").attr("class", "initial_right_hand");
		$("#right_hand").attr("style", "right:-112px;top:-12px");
	});
	
	$("form").keydown(function(event) {
		if(event.keyCode == 13) {
			login();
		}
	});
	
	$("#account").focus();
});

/**
 * 登陆函数
 * 
 * @author 周化益
 */
function login() {
	var account = $("#account").val();
	var password = $("#password").val();
	if (!account) {
		$("#tip").html("请输入账号！");
		$("#account").focus();
		return;
	} else if (!password) {
		$("#tip").html("请输入密码！");
		$("#password").focus();
		return;
	}

	var form = $('form');
	var formData = form.serializeArray();
	$.post(form.attr("action"), formData, function(type) {
		if (type == 2) {
			location.href = "index.jsp";
		} else if (type == 1){
			$("#tip").html("用户名不存在！");
			$("#account").focus();
		} else {
			$("#tip").html("密码错误！");
			$("#password").focus();
		}
	});
}

function logout() {
	$.post("logout.do",function() {
		window.parent.window.location.href="denglu.html";
	});
}


/**
 * 赋值Cookie中
 * 
 * @author 周化益
 * @param cookName Cook名
 * @param cookValue Cook值
 */
function SetCookie(cookName, cookValue) {
	date = new Date();
	date.setDate(date.getDate() + 30);
	document.cookie = cookName + '=' + escape(cookValue)
			+ '; expires=' + date.toGMTString();
}

/**
 * 从Cook中取值
 * 
 * @author 周化益
 * @param cookName cook名
 * @returns
 */
function getCookie(cookName) {
	// 获取cookie字符串
	var strCookie=document.cookie;
	// 将多cookie切割为多个名/值对
	var arrCookie=strCookie.split("; ");
	// 遍历cookie数组，处理每个cookie对
	for(var i=0;i<arrCookie.length;i++){
		var arr=arrCookie[i].split("=");
		// 找到名称为userId的cookie，并返回它的值
		if(cookName==arr[0]){
			return userId=arr[1];
		}
	}
}