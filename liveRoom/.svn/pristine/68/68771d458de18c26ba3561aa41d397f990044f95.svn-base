var fileType;
var file;

/**
 * 广告列表查询
 * @author 周化益
 * @param searchText 搜索框的内容
 */
function adverList(searchText) {
	var fun = function formatterColumn(index) {
		var row = getRowData(index);
		return "<a href='javascript:openAdvertisementEditPage("+row.id+")'" + ">修改</a>&nbsp;&nbsp;\
				<a href='javascript:deleteOne("+ row.id + ")'>删除</a>";
	};
	
	var images = function formatterColumn(index) {
		var row = getRowData(index);
		return "<img src='" + row.images + "' width = '300px' height='50px'>";
	};

	if(!searchText) {
		searchText = '';
	}
	
	tableData("advertiseList.do", searchText, 1, 10, "advertiseTable", ["title", "images","url", "action"], {
		"action" : fun,
		"images" : images
	},"id");
}

/**
 * 搜索
 */
function search() {
	adverList($("#search").val());
}

/**
 * 打开广告添加页面
 */
function openAdvertisementAddPage() {
	layer.open({
		title : "广告添加页面",
		type : 2,
		area : [ 420, 400],
		fix : false, // 不固定
		maxmin : false,
		//offset : ['0' , '0'],
		content : '/liveRoom/pages/advertisementAdd.jsp'
	});
}

/**
 * 打开广告修改页面
 * @param newsId 广告ID
 */
function openAdvertisementEditPage(advertisementId) {
	layer.open({
		title : "广告修改页面",
		type : 2,
		area : [ 420, 400],
		fix : false, // 不固定
		maxmin : false,
//		offset : ['0' , '0'],
		content : 'openAdvertiseEdit.do?advertiseId='+advertisementId
	});
}

/**
 * 添加广告方法
 * addEdit 添加或修改1：添加，2修改
 */
function addOrEdit(userId) {
	var form = $('form');
	var fd = form.serializeArray();
	var advertisementMap = {};
	
	$.each(fd, function(j, n) {
		advertisementMap[n['name']]=n['value'];
	});
	
	var fileName = $("#fileName").val();
	var one=fileName.split(".");
	//获取数组中最后一个，即文件名
	var two=one[one.length-1];
	var mydate = new Date();
	var time = mydate.getTime();
	$.each(fd, function(j, n) {
		advertisementMap[n['name']]=n['value'];
	});
	if(file) {
		advertisementMap["images"] = time  + '.' + two;
	} 
	
	$.post(form.attr("action"),{mapVo:advertisementMap},function(data) {
		if(data > 0) {
			if(file) {
				var xhr = new XMLHttpRequest();
				var formData = new FormData();
				formData.append("fileData", file);
				formData.append("advertiseId", userId);
				formData.append("fileName", time  + '.' + two);
				//xhr.upload.addEventListener("progress", uploadProgress, false);
				xhr.addEventListener("load", uploadComplete, true);
				xhr.open("post", "uploadAdvertise.do");
				xhr.send(formData);
			} else {
				parent.refreshTable("操作成功!");
			}
		} else {
			validateInfo("添加失败");
		}
	});
}

/**
 * 删除单条记录
 * @param newsId 广告ID
 */
function deleteOne(advertisementId) {
	layer.confirm('是否删除该广告？', {icon: 3,offset : ['300px' , '800px']}, function() {
		$.post("deleteAdvertise.do",{advertiseId:advertisementId},function(data) {
			if(data) {
				refreshTable("广告删除成功!");
			} else {
				refreshTable("广告删除失败!");
			}
		});
	});
}

/**
 * 删除所选中的广告
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
	layer.confirm('你确定要删除选中的广告么？', {icon: 3,offset : ['300px' , '800px;']}, function() {
		$.post("deleteManyAdvertise.do",{advertiseIds:ids},function(data) {
			if(data) {
				refreshTable("广告删除成功!");
			} else {
				refreshTable("广告删除失败!");
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