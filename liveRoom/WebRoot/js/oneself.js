function saveOneself() {
	var data = $("form").serializeArray();
	var userMap = {};
	console.info(data);
	$.each(data, function(j, n) {
		userMap[n['name']]=n['value'];
	});
	$.post($("form").attr("action"),{mapVo:userMap},function(result) {
		if(result) {
			parent.layer.msg("保存成功！", {
				icon : 6,
				time : 1500,
				offset : ['100px' , '500px']
			});
		} else {
			parent.layer.msg("保存失败！", {
				icon : 6,
				time : 1500,
				offset : ['100px' , '500px']
			});
		}
	});
}

function updatePwd() {
	var old = $("#oldPwd").val();
	var now = $("#pwd").val();
	var newPwd = $("#newPwd").val();
	
	if(!old) {
		validateInfo("原始密码不能为空！");
		return;
	}
	
	if(!now) {
		validateInfo("新密码不能为空！");
		return;
	}
	
	if(now != newPwd) {
		validateInfo("两次密码输入不一致！");
		return;
	}
	
	$.post("updatePwd.do",{oldPwd:old,newPwd:newPwd},function(result) {
		if(result == 0) {
			validateInfo("原始密码错误");
		} else if(result == 1) {
			validateInfo("保存失败");
		} else {
			window.parent.window.location.href="denglu.html";
		}
	});
}