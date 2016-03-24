var fileType;
var file;

/**
 * 新闻列表查询
 * @author 周化益
 * @param searchText 搜索框的内容
 */
function newsList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openNewsEditPage("+row.news_id+")'" + ">修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne("+ row.news_id + ")'>删除</a>";
	};
	
	var time = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row.news_uploadtime);
	};

	if(!searchText) {
		searchText = '';
	}
	
	tableData("getNewsList.do", searchText, 1, 10, "newsTable", ["news_title","news_address",
	    "news_uploadtime","user_realName","name","news_thumbup", "action" ], {
		"action" : fun,
		"news_uploadtime" : time
	},"news_id");
}

/**
 * 搜索
 */
function search() {
	newsList($("#search").val());
}

/**
 * 打开新闻添加页面
 */
function openNewsAddPage() {
	layer.open({
		title : "新闻添加页面",
		type : 2,
		area : [ getPageWidth(0.99), getpageHeight()],
		fix : false, // 不固定
		maxmin : false,
		offset : ['0' , '0'],
		content : '/liveRoom/pages/newsAdd.jsp'
	});
}

/**
 * 打开新闻修改页面
 * @param newsId 新闻ID
 */
function openNewsEditPage(newsId) {
	layer.open({
		title : "新闻修改页面",
		type : 2,
		area : [ getPageWidth(0.99), getpageHeight()],
		fix : false, // 不固定
		maxmin : false,
		offset : ['0' , '0'],
		content : 'openNewsEdit.do?newsId='+newsId
	});
}

/**
 * 添加新闻方法
 */
function addOrEditNews(userId,photoPath) {
	console.info(document.getElementById("content").innerHTML);
//	var form = $('form');
//	var fd = form.serializeArray();
//	var newsMap = {};
//	var fileName = $("#fileName").val();
//	var one=fileName.split(".");
//	//获取数组中最后一个，即文件名
//	var two=one[one.length-1];
//	var mydate = new Date();
//	var time = mydate.getTime();
//	$.each(fd, function(j, n) {
//		newsMap[n['name']]=n['value'];
//	});
//	
//	
//	newsMap['photoPath'] = photoPath;
//	if(file) {
//		newsMap["news_photo"] = time  + '.' + two;
//	} 
//	$.post(form.attr("action"),{mapVo:newsMap},function(data) {
//		if(data > 0) {
//			if(file) {
//				var xhr = new XMLHttpRequest();
//				var formData = new FormData();
//				formData.append("fileData", file);
//				formData.append("newsId", userId);
//				formData.append("fileName", time  + '.' + two);
//				//xhr.upload.addEventListener("progress", uploadProgress, false);
//				xhr.addEventListener("load", uploadComplete, true);
//				xhr.open("post", "uploadNews.do");
//				xhr.send(formData);
//			} else {
//				parent.refreshTable("操作成功!");
//			}
//		} else {
//			validateInfo("添加失败");
//		}
//	});
}

/**
 * 选择图片触发的时间
 */
function fileSelect() {
	var files = document.getElementById("fileData").files;
	file = files[0];
	fileType = file.type;
	$("#img").html('<img src="'+window.URL.createObjectURL(file)+'" width="200px" height="100px">');
	if(fileType.split("/")[0] != "image") {
		alert("格式不正确，请重新选择！");
		return;
	}
	if(file.size > 10*1024*1024) {
		alert("上传文件不能大于10M");
		return;
	}
	
	$("#fileName").val(file.name);
}

/**
 * 上传完成事件
 */
function uploadComplete(evt) {
	var loadResult = eval("("+evt.target.responseText+")");
	if(loadResult) {
		parent.refreshTable("操作成功!");
	}
}

/**
 * 删除单条记录
 * @param newsId 新闻ID
 */
function deleteOne(newsId) {
	layer.confirm('是否删除该新闻？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteNews.do",{newsId:newsId},function(data) {
			if(data) {
				layer.msg("新闻删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("新闻删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 删除所选中的新闻
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
	layer.confirm('你确定要删除选中的新闻么？', {icon: 3,offset : ['300px' , '800px;']}, function() {
		$.post("deleteManyNews.do",{newsIds:ids},function(data) {
			if(data) {
				layer.msg("新闻删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("新闻删除失败！", {
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

function selectBox(newstype) {
    /*获取推荐人下拉框列表 */
	$.post('newsTypeList.do', function(data) {
		//将字符串转换成json数据
		var json = data;
		
		//获取json长度（推荐人数量）
		var len = json.length;
		
		//定义推荐人下拉内容接受对象
		var content = "";
		/*循环拼接下拉内容*/
		for (var i = 0; i < len; i++) {
			content += "<option value=" + json[i]["id"] + ">" + json[i]["name"]
					+ "</option>";
		}
		$("#news_type").html(content);
		$("#news_type option[value='" + newstype + "']").attr("selected", true);
	});
}