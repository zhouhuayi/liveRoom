var file;
var videoType= ["rm", "rmvb", "mpeg", "mov", "mtv", "dat", "wmv", "avi", "3gp", "amv","dmv","flv"];
/**
 * 查询视频列表
 */
function videoList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openVideoEditPage("+row.video_id+")'"+ ">修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne("+ row.video_id + ")'>删除</a>";
	};
	
	var time = function formatterColumn(index) {
		var row = getRowData(index);
		return formatDate(row.video_uploadtime);
	};
	
	if(!searchText) {
		searchText = '';
	}
	
	tableData("getAllVideo.do", searchText, 1, 10, "videoTable", [ "video_name","video_describe","video_address",
	    "video_uploadtime","user_realName","video_type","video_plays","video_thumbup", "action" ], {
		"action" : fun,
		"video_uploadtime" : time
	},"video_id");
}

/**
 * 删除单条记录
 * @param videoId 视频ID
 */
function deleteOne(videoId) {
	layer.confirm('是否删除该视频？', {icon: 3}, function() {
		$.post("deleteVideo.do",{videoId:videoId},function(data) {
			if(data) {
				layer.msg("视频删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("视频删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 删除所选中的视频
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
	layer.confirm('你确定要删除选中的视频么？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteManyVideo.do",{videoIds:ids},function(data) {
			if(data) {
				layer.msg("视频删除成功！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				}, function() {
					CommonRefreshTable();
				});
			} else {
				layer.msg("视频删除失败！", {
					icon : 6,
					time:1000,
					offset : ['300px' , '800px']
				});
			}
		});
	});
}

/**
 * 打开视频添加页面
 */
function openVideoAddPage() {
	layer.open({
		title : "视频添加页面",
		type : 2,
		area : [ '650px', '450px' ],
		fix : false, // 不固定
		maxmin : false,
		offset : ['100px' , '500px;'],
//		content : '/liveRoom/pages/videoAdd.jsp'
		content : '/liveRoom/pages/addVideo.jsp'
	});
}

/**
 * 打开视频修改页面
 * @param videoId
 */
function openVideoEditPage(videoId) {
	layer.open({
		title : "视频修改页面",
		type : 2,
		area : [ '650px', '450px' ],
		fix : false, // 不固定
		maxmin : false,
		offset : ['100px' , '500px;'],
		content : 'openVideoEdit.do?videoId='+videoId
	});
}

/**
 * 添加视频数据
 */
function addVideo(userId) {
	var form = $('form');
	if(!$('#video_Name').val() || $('#video_Name').val() == '') {
		validateInfo("请输入视频名称！");
		return;
	}
	if(!file) {
		validateInfo("请选择上传的视频封面图！");
		return;
	} else {
		var fd = form.serializeArray();
		var fileName = $("#fileName").val();
		var videoMap = {};
		$.each(fd, function(j, n) {
			videoMap[n['name']]=n['value'];
		});
		var one=fileName.split(".");
		//获取数组中最后一个，即文件名
		var two=one[one.length-1];
		var mydate = new Date();
		var time = mydate.getTime();
		videoMap['video_images'] = time  + '.' + two;
		
		$.post(form.attr("action"),{mapVo:videoMap},function(data) {
			if(data) {
				var xhr = new XMLHttpRequest();
				var formData = new FormData();
				formData.append("fileData", file);
				formData.append("videoId", userId);
				formData.append("fileName", time  + '.' + two);
				//xhr.upload.addEventListener("progress", uploadProgress, false);
				xhr.addEventListener("load", uploadComplete, true);
				xhr.open("post", "uploadVideo.do");
				xhr.send(formData);
			} else {
				validateInfo("添加失败");
			}
		});
	}
}

/**
 * 修改视频数据
 */
function editVideo(videoId,userId,videoPath) {
	if(!$('#video_Name').val() || $('#video_Name').val() == '') {
		validateInfo("请输入视频名称！");
		return;
	}
	
	var form = $('form');
	var fd = form.serializeArray();
	var fileName = $("#fileName").val();
	var videoMap = {};
	
	$.each(fd, function(j, n) {
		videoMap[n['name']]=n['value'];
	});
	var one=fileName.split(".");
	//获取数组中最后一个，即文件名
	var two=one[one.length-1];
	var mydate = new Date();
	var time = mydate.getTime();
	if(file) {
		videoMap['video_images'] = time  + '.' + two;
		videoMap['video_path'] = videoPath;
	}
	videoMap['video_Id'] = videoId;
	$.post(form.attr("action"),{mapVo:videoMap},function(data) {
		if(data) {
			if(file) {
				var xhr = new XMLHttpRequest();
				var formData = new FormData();
				formData.append("fileData", file);
				formData.append("videoId", userId);
				formData.append("fileName", time  + '.' + two);
			//	xhr.upload.addEventListener("progress", uploadProgress, false);
				xhr.addEventListener("load", uploadComplete, true);
				xhr.open("post", "uploadVideo.do");
				xhr.send(formData);
			} else {
				parent.refreshTable("修改成功!");
			}
		} else {
			validateInfo("修改失败");
		}
	});
}

/**
 * 选择视频触发的时间
 */
function fileSelect() {
//	var files = document.getElementById("fileData").files;
//	file = files[0];
//	//对路径字符串进行剪切截取
//	var one=file.name.split(".");
//	//获取数组中最后一个，即文件名
//	var two=one[one.length-1];
////	if($.inArray(two, videoType) < 0) {
////		validateInfo("格式不正确，请重新选择！");
////		return;
////	}
//	if(file.size > 1*1024*1024) {
//		validateInfo("上传文件不能大于1M");
//		return;
//	}
//	
//	$("#fileName").val(file.name);
	
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

function uploadProgress(evt) {
    if (evt.lengthComputable) {
        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
        if(percentComplete == 100) {
        	parent.refreshTable("操作成功!");
        }
    } else {
        document.getElementById('progressNumber').innerHTML = '上传失败';
    }
    
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

/**
 * 搜索
 */
function search() {
	videoList($("#search").val());
}

/**
 * 初始化视频类型
 * 
 * @param videoType 视频类型ID
 */
function selectBox(videoType) {
    /*获取推荐人下拉框列表 */
	$.post('videoTypeList.do', function(data) {
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
		$("#video_type").html(content);
		if(videoType) {
			$("#video_type option[value='" + videoType + "']").attr("selected", true);
		}
	});
}
