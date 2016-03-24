/**
 * 动态列表查询
 * @author 周化益
 * @param searchText 搜索框的内容
 */
function blogList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openBlogEditPage("+row.id+")'" + ">修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne("+ row.id + ")'>删除</a>";
	};
	
	var content = function formatterColumn(index) {
		var row = getRowData(index);
		if(row.content.length > 30) {
			return row.content.substring(0,30) + "......";
		} else {
			return row.content;
		}
	};

	if(!searchText) {
		searchText = '';
	}
	
	tableData("getBlogAll.do", searchText, 1, 10, "blogTable", ["title","times","user_realName","content","praise", "action" ], {
		"action" : fun,
		"content" : content
	},"id");
}

/**
 * 搜索
 */
function search() {
	blogList($("#search").val());
}

/**
 * 打开动态添加页面
 */
function openBlogAddPage() {
	layer.open({
		title : "动态添加页面",
		type : 2,
		area : [ getPageWidth(1), getpageHeight()],
		fix : false, // 不固定
		maxmin : false,
		offset : ['0' , '0'],
		content : '/liveRoom/pages/blogAdd.jsp'
	});
}

/**
 * 打开动态修改页面
 * @param newsId 动态ID
 */
function openBlogEditPage(blogId) {
	layer.open({
		title : "动态修改页面",
		type : 2,
		area : [ getPageWidth(1), getpageHeight()],
		fix : false, // 不固定
		maxmin : false,
		offset : ['0' , '0'],
		content : 'openBlogPage.do?blogId='+blogId
	});
}

/**
 * 添加动态方法
 * addEdit 添加或修改1：添加，2修改
 */
function addOrEditNews(addEdit) {
	var form = $('form');
	var fd = form.serializeArray();
	var blogMap = {};
	
	$.each(fd, function(j, n) {
		blogMap[n['name']]=n['value'];
	});
	
	blogMap["content"] = UE.getEditor("content").getContentTxt();
	
	$.post(form.attr("action"),{mapVo:blogMap},function(data) {
		if(data > 0) {
			if(addEdit == 1) {
				var socket;
				if(!window.WebSocket) {
					window.WebSocket = window.MozWebSocket;
				} 
				if(window.WebSocket) {
					socket = new WebSocket("ws://192.168.0.33:3333");
					socket.onmessage = function(event) {
						parent.refreshTable("操作成功!");
					};
					socket.onopen = function(event) {
						console.info("连接开启");
//						if(socket.readyState = WebSocket.OPEN) {
							var json = "{'type':'Teacherdynamic',"+
	/*								"'username':"+account +","+
									"'password':" + password+","+*/
									"'blogId':"+  data + "}";
							socket.send(json);
//						} else {
//							console.info("WebSocket没有连接成功！");
//						}
					};
					socket.onclose = function(event) {
						console.info("连接关闭");
					};
					if(!window.WebSocket) {
						console.info("连接失败");
					}
				} else {
					console.info("抱歉，您的浏览器不支持WebSocket协议！");
				}
			}
		} else {
			validateInfo("添加失败");
		}
	});
}

/**
 * 删除单条记录
 * @param newsId 动态ID
 */
function deleteOne(blogId) {
	layer.confirm('是否删除该动态？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteBlog.do",{blogId:blogId},function(data) {
			if(data) {
				layer.msg("动态删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("动态删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 删除所选中的动态
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
	layer.confirm('你确定要删除选中的动态么？', {icon: 3,offset : ['300px' , '800px;']}, function() {
		$.post("deleteManyBlog.do",{blogIds:ids},function(data) {
			if(data) {
				layer.msg("动态删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("动态删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
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

function selectBox(userId) {
    /*获取推荐人下拉框列表 */
	$.post('getAllBlogUser.do', function(data) {
		//将字符串转换成json数据
		var json = data;
		
		//获取json长度（推荐人数量）
		var len = json.length;
		
		//定义推荐人下拉内容接受对象
		var content = "";
		/*循环拼接下拉内容*/
		for (var i = 0; i < len; i++) {
			content += "<option value=" + json[i]["user_id"] + ">" + json[i]["user_RealName"]
					+ "</option>";
		}
		$("#person").html(content);
		$("#person option[value='" + userId + "']").attr("selected", true);
	});
}