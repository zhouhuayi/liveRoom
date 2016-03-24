var pagetotel=0;//总页数
var pageSize=10;

var file;
var fileType;
$(function() {
	//一开始进来所显示的信息
	$.ajax({
			url : 'roomlistAction.do',
			data : {
				"pageNum" : 1,
				"pageSize" : pageSize,
				//"mapVo" : {" r.room_id ":" desc"}
				"orderBy" : null
			},
			async:false,
			dataType : 'json',
			error : function() {
				alert("error occured!!!");
			},
			success : function(data){
				ReturnData(data);
			}
		});
//	$(".tcdPageCode").createPage({
//		pageCount : pagetotel,// 总页数
//		current : 1,// 当前页
//		backFn : function(p) {
//			$.post("roomlistAction.do",{"pageNum":p,"pageSize":pageSize,"orderBy":null},function(data){
//				ReturnData(data);
//			});
//		}
//	});
});
//获取数据进行分页操作
function ReturnData(data){
	var datatotal = data.total;// 总条数(房间总数)
	var type = data.userType;// 类型
	var datas = data.rows;// 房间信息
	var htmlstr = null;
	pagetotel = Math.ceil(datatotal/pageSize);//总页数
	$("#roomnumber").html(datatotal);//显示的是房间数
	var addroom = "<form id='RoomForm' name='RoomForm' action='' method='post'>"
		+ "<input type=button value='创建' id='Establishroom' onClick='RoomInformetion()' />"
		+ "房间名称：<input type='text' id='room_name' name='room_name' onblur='selectroomname()' />"
		+ "所属人：<select id='room_user' name='room_user'>"
		+ "<option value='0'>---选择所属人---</option>"
		+ "</select>"
		+ "类型：<select id='type_name' name='room_type'>"
		+ "		<option value='0'>---选择类型---</option>"
		+ "	</select>"
		+ "<input type=button value='搜索' id='Search_room' onClick='RoomSearch()' />"
		+ "	</form>";
		$("#addRoom").html(addroom);
		$.get("usertypeAction.do", {"roomuser":"FJGLY"}, function(data) {
			var teacher="<option value='0'>---选择所属人---</option>;"
				for(var d in data){
					teacher+="<option value="+data[d].user_id+">"+data[d].user_name+"</option>";
				}
			$("#room_user").html(teacher);
		});	
		$.get("roomtypeAction.do",null,function(data){
			var typroption="<option value='0'>---选择类型---</option>";
			for(var d in data){
				typroption+="<option value="+data[d].roomtype_Id+">"+data[d].roomtype_Name+"</option>";
			}
			$("#type_name").html(typroption);
		});
		if (type == 1) {
		var roomLogo="";
		for ( var d in datas) {
			if(!datas[d].room_logo){
				roomLogo="暂无Logo";
			}else{
				roomLogo="<img src='../"+datas[d].room_logo+"' style='height:10%;width:10%;'/>";
			}
			htmlstr += "<tr><td><input type='checkbox' name='items' value="
					+ datas[d].room_id
					+ "></td><td>"
					+ datas[d].room_name
					+ "</td><td>"
					+ datas[d].user_name
					+ "</td><td>"
					+ datas[d].room_videoUrl
					+ "</td><td>"
					+ roomLogo
					+ "</td><td>"
					+ datas[d].roomtype_name
					+"</td>><td ><a onClick='UpdateOneRoom("
					+ datas[d].room_id
					+ ")'>修改</a></td></tr>";
			$("#trContent").html(htmlstr);
		}
		$(".tcdPageCode").createPage({
			pageCount : pagetotel,// 总页数
			current : 1,// 当前页
			backFn : function(p) {
				$.post("roomlistAction.do",{"pageNum":p,"pageSize":pageSize,"orderBy":null},function(data){
					ReturnData(data);
				});
			}
		});
	} else {
		$("#Establishroom").hide();
		$("#checkItems").hide();
		$("#xh").html("序号");
		$("#deletebutton").hide();
		for ( var d in datas) {
			if(datas[d].room_state!=0){
				roomstate="开启";
			}else{
				roomstate="关闭";
			}
			htmlstr += "<tr><td>"
					+ (parseInt(d) + 1)
					+ "<input id='yc' type='hidden' name='items' value="
					+ datas[d].room_id
					+ "></td><td>"
					+ datas[d].room_name
					+ "</td><td>"
					+ datas[d].user_name
					+ "</td><td>"
					+ datas[d].videoUrl
					+ "</td><td>Logo</td><td>"
					+ datas[d].roomtype_name
					+"</td><td ><a onClick='UpdateOneRoom("
					+ datas[d].room_id
					+ ")'>修改</a></td></tr>";
			$("#trContent").html(htmlstr);
		}
		$(".tcdPageCode").attr("colspan", "6");
	}
}

//房间搜索
function RoomSearch(){
	alert("房间搜索");
	var formDate=$("#RoomForm").serializeArray();
	$.post("getroomsearch.do",formDate,function(data){
		ReturnData(data);
	});
	
}

//初步添加房间
function RoomInformetion() {
	if ($("#room_name").val() == "") {
		alert("房间名为空");
		return false;
	} else if ($("#room_user").val() == "0") {
		alert("为选择房间所属人");
		return false;
	} else if ($("#type_name").val() == "0") {
		alert("为选择房间类型");
		return false;
	} else {
		var formData = $("#RoomForm").serializeArray();
		$.post("roomInitialAction.do",formData,function(data){
			ReturnData(data);
		});
	}
}
//验证房间名是否存在
function selectroomname(){
	$("#room_name").val();
	$.get("roomnameAction.do",{"roomname":$("#room_name").val()},function(data){
		if(data>0){
			alert("房间名已存在");
		}
	});
}

//查看单个房间信息
function SelectOneRoom(roomID) {
	$.get("roomoneAction.do",{"roomID":roomID},function(data){
		var roomdetails="<div class='tit'><span>房间详情</span><i class='close'>关闭</i></div>"
			+"<table width='637' height='422' border='1'>"
			+"<tr>"
			+"  <td width='149'><div align='center'>房间名称</div></td>"
			+"  <td width='472'><div id='roomname'>"+data.room_name+"</div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>房间所属人</div></td>"
			+"  <td><div id='roomuser'>"+data.user_name+"</div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>所属类型</div></td>"
			+"  <td><div id='roomtype'>"+data.roomtype_name+"</div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>客服电话</div></td>"
			+"  <td><div id='roomphone'>"+data.user_phone+"</div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>Logo</div></td>"
			+"  <td><div id='roomlogo'><img src='../"+data.room_logo+"'/></div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>创建时间</div></td>"
			+"  <td><div id='roomlogo'>"+data.room_createDate+"</div></td>"
			+"</tr>"
			+"</table>";
		$("#details").html(roomdetails);
	});
	popWin("details");
}

//开启房间
function deletedata(id) {
	
	if(confirm("确定开启"+id+"号房间吗？")){
		$.ajax({
			url:'roomdeloneAction.do',
			data:{"roomId":id,"roomstate":1},
			datatype:'json',
			success:function(data){
				ReturnData(data);
			}
			
		});
	}
}
// 批量关闭房间信息
function deletebutton(){
	var str="";//定义一个数组      
    $('input[name="items"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数      
    str+=$(this).val()+",";//将选中的值添加到数组chk_value中   
    });
    var sub=str.substring(0,(parseInt(str.length)-1));
    if(sub==""){
    	alert("请选择需要关闭的房间");
    }else if(confirm("确定关闭这些房间吗？")){
    	$.ajax({
    		url:'roomdellistAction.do',
    		data:{"roomId":sub,"roomstate":0},
    		datatype:'json',
    		success:function(data){
    			ReturnData(data);
    		}
    	});
    }
}
//修改房间信息
function UpdateOneRoom(roomID){
	$.get("roomoneAction.do",{"roomID":roomID},function(data){
		var room_logo="",roomheat="";
		if(!data.room_logo){
//			alert("房间无logo");
			room_logo="<input type='text' id='fileName' style='height:30px;width:150px;'value = '' readonly='readonly'>"
			+"		<button  onclick=$('#fileData').click() type='button'>选择照片</button>"
			+"		<span id='img'></span>"
			+"		<input accept='image/*' style='display:none' type='file' id='fileData' onchange='fileSelect()'>"
			+"		<span id='progressNumber'></span>";
		}else{
//			alert("房间logo");
			room_logo="<input type='text' id='fileName' style='height:30px;width:150px;'value = '"+data.room_logo+"' readonly='readonly'>"
			+"		<button  onclick=$('#fileData').click() type='button'>选择照片</button>"
			+"		<span id='img'><img width='20%' height='20%' src='../"+data.room_logo+"'></span>"
			+"		<input accept='image/*' style='display:none' type='file' id='fileData' onchange='fileSelect()'>"
			+"		<span id='progressNumber'></span>";
		}
		if(!data.room_heat){
			roomheat="-------无简介----------";
		}else{
			roomheat=data.room_heat;
		}
		var roomtyproption1 = "";
		
		$.ajax({
			url: "roomtypeAction.do",
			async: false,
			success : function(data1){
				roomtyproption1 ="<option value='0'>---选择类型---</option>";
				for(var d in data1) {
					if(data.room_type == data1[d].roomtype_Id) {
						roomtyproption1+="<option value="+data1[d].roomtype_Id+" selected='selected'>"+data1[d].roomtype_Name+"</option>";
					} else {
						roomtyproption1+="<option value="+data1[d].roomtype_Id+">"+data1[d].roomtype_Name+"</option>";
					}
				}
			}
		});
		
		var roomdetails=""
			+ "<form id='PerfectRoom' name='PerfectRoom' action='roomUpdateAction.do' method='post'>"
			+"<table width='637' height='422' border='1'>"
			+"<tr>"
			+"  <td width='149'><div align='center'>房间名称</div></td>"
			+"  <td width='472' ><div align='left' style='margin-left:20px' id='roomname'><input type='text' style='height:30px;' id='roomupdatename' value='"+data.room_name+"' name='room_name'/></div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>房间类型</div></td>"
			+"  <td align='left'><div align='left' style='margin-left:20px' id='roomtype'><select id='roomtypename' style='height:30px;' name='room_type'>"+roomtyproption1+"</select></div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>房间Logo</div></td>"
			+"  <td align='left'><div  align='left' style='margin-left:20px' id='roomuser'>"
			+	room_logo
			+"	</div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>推流地址</div></td>"
			+"  <td align='left'><div id='roomurl'  align='left' style='margin-left:20px'>"
			+ "<div id='roomname'><input type='text' id='roomvideoUrl' style='height:30px;' value='"+data.room_videoUrl+"' name='room_name'/></div>"
			+"	</div></td>"
			+"</tr>"
			+"<tr>"
			+"  <td><div align='center'>房间简介</div></td>"
			+"  <td align='left'>"
			+ "<div id='roomjj'  align='left' style='margin-left:20px'>" +
				
			
			"<textarea style='width:445px;height:108px' id='roomheat'>"+roomheat+"</textarea></div>"



			+"	</td>"
			+"</tr>"
			+"</tr>"
			+"<tr>"
			+"  <td colspan='2'><input type='button' style='height:30px;width:100px;' value='提交' onClick='RoomInformetionPerfect("+data.room_id+")'/></td>"
			+"</tr>"
			+"</table>"
			+"</from>";
		
		layer.open({
			title : "视频修改页面",
			type : 1,
			area : [ '650px', '480px' ],
			fix : false, // 不固定
			maxmin : false,
			content : roomdetails
		});
	});
}

function fileSelect() {
	var files = document.getElementById("fileData").files;
	file = files[0];  
	fileType = file.type;
	$("#img").html('<img src="'+window.URL.createObjectURL(file)+'" width="93px" height="93px">');
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
//修改房间信息
function RoomInformetionPerfect(id){
//	alert($("#roomheat").val());
	var roomMap={};
	var fileName=$("#fileName").val();
	roomMap["room_name"]=$("#roomupdatename").val();
	
	if($("#roomtypename").val()!=0){
		roomMap["room_type"]=$("#roomtypename").val();
	}
	var one=fileName.split(".");
	var two=one[one.length-1];
	var mydate = new Date();
	var time = mydate.getTime();
	if(file){
		roomMap['room_logo'] = time  + '.' + two;
		roomMap["room_path"]=fileName;
	}
	roomMap["room_id"]=id;
	roomMap["room_videoUrl"]=$("#roomvideoUrl").val(); 
	roomMap["room_heat"]=$("#roomheat").val(); 
	$.post("roomUpdateAction.do",{mapVo:roomMap},function(data) {
//		alert("返回数据："+data);
		if(data) {
			if(file){
			var xhr = new XMLHttpRequest();
			var formData = new FormData();
			formData.append("fileData", file);
			formData.append("roomId", id);
			formData.append("fileName", time  + '.' + two);
			//xhr.upload.addEventListener("progress", uploadProgress, false);
			//xhr.addEventListener("load", uploadComplete, true);
			xhr.open("post", "uploadroomhead.do");
			xhr.send(formData);
			}
			alert("添加成功!");
		} else {
			alert("添加失败!");
		}
		refreshTable();	
	});
}

/**
 * 刷新页面
 * 
 * @author 周化益
 * @param msg 提示信息
 */
function refreshTable(msg) {
	location.reload();
}

function uploadProgress(evt) {
    if (evt.lengthComputable) {
        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
    } else {
        document.getElementById('progressNumber').innerHTML = '上传成功';
    }
}

function uploadComplete(evt) {
	var loadResult = eval("("+evt.target.responseText+")");
	if(loadResult) {
		parent.refreshTable("操作成功!");
	}
}