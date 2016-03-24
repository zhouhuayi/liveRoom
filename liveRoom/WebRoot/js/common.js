/**
 * 获取表格宽度
 * 
 * @author 周化益
 * @returns {Number}
 */
function getPageWidth(num) {
	var width = document.body.clientWidth*num;
	return width;
}

/**
 * 获取页面宽度
 * 
 * @author 周化益
 * @returns
 */
function getpageHeight() {
	return document.body.clientHeight;
}

/**
 * ajax一部提交函数
 */
function ajaxSubmit(successMessege, failMessege, successURL, failURL) {
	var form = $('form');
	var formData = form.serializeArray();
	$.post(form.attr("action"), formData, function(bool) {
		if (bool) {
			location.href = successURL;
		} else {
			if (failURL) {
				location.href = failURL;
			}
		}
	});
}

/**
 * 时间转换
 * 
 * @param date传入的日期
 * @returns {String} 返回字符串格式日期
 */
function formatDate(date) {
	var now = new Date(date);

	var year = now.getFullYear();

	var month = now.getMonth() + 1;

	var date = now.getDate();

	var hour = now.getHours();

	var minute = now.getMinutes();

	var second = now.getSeconds();

	return year + "-" + month + "-" + date + "   " + hour + ":" + minute + ":"
			+ second;
}

/**
 * 二级树形列表
 * 
 * @author 周化益
 * @param data
 */
function treeList(data) {
	var tree = "<ul id='browser' class='filetree'>";
	var bool = false;
	var parentPower = '';

	$.each(data,function(i, n) {
		if (!n.power_parentId) {
			parentPower = '<li><span class="folder">\
				<input type="checkbox" name="ids" id="t'+ n.power_id + '" pId="t0" \
				value="'+ n.power_id+ '" onchange="child(this)"/>'
									+ n.power_name + '</span></li>';
							var twoPower = '';
							$
									.each(
											data,
											function(j, m) {
												if (n.power_id == m.power_parentId) {
													bool = true;
													twoPower += '<li><span class="file">\
						<input type="checkbox" name="ids" id="t'
															+ m.power_id
															+ '" pId="t'
															+ n.power_id
															+ '" \
						value="'
															+ m.power_id
															+ '" onchange="child(this)"/>'
															+ m.power_name
															+ '</span></li>';
												}
											});

							if (bool) {
								parentPower = '<li><span class="folder">\
					<input type="checkbox" name="ids" id="t'
										+ n.power_id
										+ '" pId="t0" value="'
										+ n.power_id
										+ '" \
					onchange="child(this)"/>'
										+ n.power_name
										+ '</span><ul>'
										+ twoPower + '</ul></li>';
							}
							tree += parentPower;
						}
					});
	return tree + "</ul>";
}

/**
 * 单机复选框事件
 * 
 * @author 周化益
 * @param e
 */
function child(e) {
	var pId = e.id;
	var ck = e.checked;
	var p = $("#" + pId + "").attr("pId");

	if (p == "t0") {
		var children = $("input[pId='" + pId + "']");
		children.each(function() {
			this.checked = ck;
		});
	} else {
		var checkLevelLengh = $("input[pId='" + p + "']:checked").length;
		if (checkLevelLengh > 0) {
			document.getElementById(p).checked = true;
		} else {
			document.getElementById(p).checked = false;
		}
	}
}

/**
 * 提示
 * 
 * @author 周化益
 * @param msg 提示信息
 */
function validateInfo(msg) {
	parent.layer.msg(msg, {
		icon : 6,
		time : 1500,
		offset : ['100px' , '500px']
	});
}

function validateForm() {
	var reqs = $(".required");
	var bool = true;
	$.each(reqs,function(i, n) {
		if(n.val() == "" || !n.val()) {
			bool = false;
			return false;
		}
	});
	return bool;
}