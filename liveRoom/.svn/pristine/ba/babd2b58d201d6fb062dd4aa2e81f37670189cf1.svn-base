	var pagetotel=0;//总页数
	var pageSize=10;
	$(function() {
		//一开始进来所显示的信息
		$.ajax({
				url : 'roomlistAction.do',
				data : {
					"pageNum" : 1,
					"pageSize" : pageSize,
					"whereSql" : '',
					"orderBy" : null
				},
				async:false,
				dataType : 'json',
				error : function() {
					alert("error occured!!!");
				},
				success : function(data){
					ReturnRoomData(data);
				}
			});
		//分页方法
		$(".tcdPageCode").createPage({
			pageCount : pagetotel,// 总页数
			current : 1,// 当前页
			backFn : function(p) {
				$.post("roomlistAction.do",{"pageNum":p,"pageSize":pageSize,"whereSql":'',"orderBy":null},function(data){
					ReturnRoomData(data);
				});
			}
		});
		//添加用户
		$("#adduser").click(function(){
			var adduser="<div class='tit'><span>房间详情</span><i class='close'>关闭</i></div>"
				+ "<form id='PerfectRoom' name='PerfectRoom' action='roomUpdateAction.do' method='post'>"
				+"<table width='637' height='422' border='1'>"
				+"<tr>"
				+"  <td width='149'><div align='center'>用户账号</div></td>"
				+"  <td width='472'><input type='text' id='user_name'/></td>"
				+"</tr>"
				+"<tr>"
				+"  <td><div align='center'>所属房间</div></td>"
				+"  <td><select id='roommembers_roomid' name='user_room'></select></td>"
				+"</tr>"
				+"<tr>"
				+"  <td><div align='center'>房间中的角色</div></td>"
				+"  <td><select id='roommembers_roleid' name='user_type'></select></td>"
				+"</tr>"
				+"<tr>"
				+"  <td><div align='center'>性别</div></td>"
				+"  <td>" +
						"<input type='radio' name='sexbutton' id='sex1' value='1'>男 " +
						"<input type='radio' name='sexbutton' id='sex2' value='2'>女 " +
					"<td>"

				+"</tr>"
				+"<tr>"
				+"  <td colspan='2'>" +
					"<input type='button' id='button1' value='取消'>" +
					"<input type='button' id='button2' value='提交'>" +
					"<td>"
				+"</tr>"
				+"</table></form>";
			$("#details").html(adduser);
			//所有房间
			$.get("roomSelectList.do",function(data){
				var allroom="<option value='0'>---选择所属房间---</option>";
				for(var d in data){
					allroom+="<option value="+data[d].room_id+">"+ data[d].room_name+"</option>";
				}
				$("#roommembers_roomid").html(allroom);
			});
			//所有房间中的角色
			var allroom='';
			$.ajax({
				url: "roomuserSelectList.do?roomId="+roomId,
				async: false,
				success : function(data1){
				for(var d in data1){
					if(data.name == data1[d].name) {
						allroom+="<option value="+data1[d].id+" selected='selected'>"+data1[d].name+"</option>";
					} else {
						allroom+="<option value="+data1[d].id+">"+data1[d].name+"</option>";
					}
				}
				}
			});
			//创建房间用户
			$("#button2").click(function(){
//				alert($("#roommembers_roomid").val());
				var map={"user_name":$("#user_name").val(),"roommembers_roomid":$("#roommembers_roomid").val(),"roommembers_roleid":$("#roommembers_roleid").val(),"user_sex":$('input[name="sexbutton"]:checked').val()};
				$.get("addroomuserList.do",map,function(data){
					if(data){
						alert("添加成功");
					}else{
						alert("添加失败");
					}
				});
//				alert({"user_name":$("#user_name").val(),"roommembers_roomid":$("#roomname").val(),"roommembers_roleid":$("#roommembers_roleid").val(),"user_sex":$('input[name="sexbutton"]:checked').val()});
			});
			popWin("details");
		});
		//禁用用户账号
		$("#disable").click(function(){
			if(confirm("确定禁用这些吗？")){
				var str="";//定义一个数组      
			    $('input[name="items"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数      
			    str+=$(this).val()+",";//将选中的值添加到数组chk_value中   
			    });
			    str=str.substring(0,(parseInt(str.length)-1));
			    alert("需要禁用的用户："+str);
			}
		});
		
	});

//获取房间数据进行分页操作
function ReturnRoomData(data){
	var datatotal = data.total;// 总条数(房间总数)
	var type = data.userType;// 类型
	var datas = data.rows;// 房间信息
	var htmlstr = null;
	pagetotel = Math.ceil(datatotal/pageSize);//总页数
	$("#numbers").html("管理的房间有<span style='color: #936;'>"+datatotal+"</span>个");
		$("#disable").hide();
		$("#adduser").hide();
		$("#xh").html("序号");
		var roomstate="",Logo="";
		for ( var d in datas) {
			switch(datas[d].room_state){
				case 0 : roomstate="关闭";break;
				case 1 : roomstate="开放";break;
				case 2 : roomstate="会员";break;
				case 3 : roomstate="密码";break;
			}
			if(!datas[d].room_logo || datas[d].room_logo=="null"){
				Logo="暂无Logo";
			}else{
				Logo="<img style='height:20%;width:20%' src='../"+datas[d].room_logo+"'/>";
			}
			var roomphone="";
			if(!datas[d].room_phone){
				roomphone="房间暂无电话";
			}else{
				roomphone=datas[d].room_phone;
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
					+ roomphone
					+ "</td><td>" 
					+ Logo				
					+ "</td><td>"
					+ datas[d].roomtype_name
					+"</td><td>" 
					+ roomstate
					+ "</td><td ><a onclick='SelectRoomUser("
					+ datas[d].room_id
					+ ")'>查看房间成员</a></td></tr>";
			$("#trContent").html(htmlstr);
		$(".tcdPageCode").attr("colspan", "7");
	}
}
//查询房间用户
function SelectRoomUser(roomId){
	$.get("getRoomUserList.do",{"roomID":roomId,"pageNum" : 1,"pageSize" : pageSize},function(data){
		ReturnUserData(data);
	});
}
//获取用户数据进行分页操作
function ReturnUserData(data){
	var datatotal = data.total;// 总条数(房间总数)
	var datas = data.rows;// 房间信息
	var htmlstr = null;//表中的信息
	var htmltable = null;//表头的信息
	htmltable="<tr><td colspan='9'style='font-size:24px;'>所有房间用户信息</td></tr><tr><th><input type='checkbox' id='checkItems' value=''></th><th>账号</th><th>昵称</th><th>真实姓名</th><th>房间中的角色</th><th>性别</th><th>添加时间</th><th class='operation'>操作</th></tr>";
	$("#tablethead").html(htmltable);
	//  全选/反选
	$("#checkItems").click(function(){
		$("input[name='items']").attr("checked",$(this).get(0).checked); 
	});
	pagetotel = Math.ceil(datatotal/pageSize);//总页数
	$("#numbers").html("有<span style='color: #936;'>"+datatotal+"</span>位成员");//成员个数
		
		var roomstate="";
		if(datatotal==0){
			$("#disable").hide();
			$("#adduser").show();
			htmlstr="<tr><td colspan='8' style='font-size:24px;color:#F00;'>*房间暂无人员</td></tr>";
			$(".tcdPageCode").attr("colspan", "7");
		}else{
			$("#disable").show();
			$("#adduser").show();
			for ( var d in datas) {
				var sex="";
				if(datas[d].user_sex==1){
					sex="女";
				}else{
					sex="男";
				}
				var user_room_id='';
//				if(!datas[d].room_id){
//					user_room_id=datas[d].user_id
//				}else{
					user_room_id=datas[d].user_id+","+datas[d].room_id;
					//alert(datas[d].user_id+","+datas[d].room_id);
//				}
				htmlstr += "<tr><td>"
					+ "<input id='yc' type='checkbox' name='items' value="
					+ datas[d].user_id
					+ "></td><td>"
					+ datas[d].user_account
					+ "</td><td>"
					+ datas[d].user_name
					+ "</td><td>"
					+ datas[d].user_realName
					+ "</td><td>"
					+ datas[d].name
					+ "</td><td>"
					+ sex
					+ "</td><td>"
					+ datas[d].user_registerDate
					+"</td><td >" +
							"<a onclick='selectoneuser("
					+ user_room_id
					+ ")'>查看成员</a>" +
							"<a onclick='updateoneuser("
					+ user_room_id
					+ ")'>修改信息</a></td></tr>";
			}
			$(".tcdPageCode").attr("colspan", "6");
		}
		$("#trContent").html(htmlstr);
}
//查看用户信息
function selectoneuser(userId,roomId){
	var htmluser="";
	$.get("getUserOne.do",{"userId":userId,"roomId":roomId},function(data){
		var userphone="",usersex="";
		if(data.user_phone==""){
			userphone="无号码";
		}else{
			userphone=data.user_phone;
		}
		if(data.user_sex==1){
			usersex="女";
		}else{
			usersex="男";
		}
		var Landtime=""; 
		if(data.user_lastTime){
			var datatime=new Date(data.user_lastTime);
			Landtime=datatime.getFullYear()+"-"+(datatime.getMonth()+1)+"-"+datatime.getDate()+"		"+datatime.getHours()+":"+datatime.getMinutes()
		}else{
			Landtime="新账号，未使用";
		}
		htmluser="<table width='430'  border='1'>"
			+"  <tr>"
			+"    <td width='110'><div align='center'><span>账号</span></div></td>"
			+"    <td width='297'>"+data.user_account+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>昵称</span></div></td>"
			+"    <td>"+data.user_name+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>真实姓名</span></div></td>"
			+"    <td>"+data.user_realName+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>添加时间</span></div></td>"
			+"    <td>"+data.user_registerDate+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>最近登陆时间</span></div></td>"
			+"    <td>"+Landtime+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>性别</span></div></td>"
			+"    <td>"+usersex+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>角色</span></div></td>"
			+"    <td>"+data.name+"</td>"
			+"  </tr>"
			+"</table>";
		layer.open({
			title : "用户详情",
			type : 1,
			area : [ '650px', '271px' ],
			fix : false, // 不固定
			maxmin : false,
			content : htmluser
		});
	});
}



//修改用户信息
function updateoneuser(userId,roomId){
	
	
	var htmluser="";
	$.get("getUserOne.do",{"userId":userId,"roomId":roomId},function(data){
		var userphone="",usersex="";
		if(data.USER_PHONE==""){
			userphone="无号码";
		}else{
			userphone=data.USER_PHONE;
		}
		if(data.USER_SEX==1){
			usersex="男";
		}else{
			usersex="女";
		}
		var datatime=new Date(data.USER_LASTTIME);
		
		
		//所有房间中的角色
		var allroom='';
		$.ajax({
			url: "roomuserSelectList.do?roomId="+roomId,
			async: false,
			success : function(data1){
			for(var d in data1){
				if(data.name == data1[d].name) {
					allroom+="<option value="+data1[d].id+" selected='selected'>"+data1[d].name+"</option>";
				} else {
					allroom+="<option value="+data1[d].id+">"+data1[d].name+"</option>";
				}
			}
			}
		});
			
		htmluser="<from id='updateuser' name='updateuserfrom' methor='post'><table width='430'  border='1'>"
			+"  <tr>"
			+"    <td width='110'><div align='center'><span>账号</span></div></td>"
			+"    <td width='297'>"+data.user_account+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>昵称</span></div></td>"
			+"    <td><input type='text' value='"+data.user_name+"' id='nc'/></td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>真实姓名</span></div></td>"
			+"    <td>"+data.user_realName+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>添加时间</span></div></td>"
			+"    <td>"+data.user_registerDate+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>性别</span></div></td>"
			+"    <td>"+usersex+"</td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td><div align='center'><span>角色</span></div></td>"
			+"    <td><select id='roleid' onchange='xiala(this);'>"+allroom+"</select></td>"
			+"  </tr>"
			+"  <tr>"
			+"    <td colspan='2'><input type='button' onclick='submituser("+userId+","+roomId+")' value='提交' /></td>"
			+"  </tr>"
			+"</table></from>";
		$("#details").html(htmluser);
		
		layer.open({
			title : "用户详情",
			type : 1,
			area : [ '650px', '290px' ],
			fix : false, // 不固定
			maxmin : false,
			content : htmluser
		});
	});
}
var sel;
function xiala(a){
		sel=$(a).children('option:selected').val(); 
}

//修改用户的信息（提交）
function submituser(userId,roomId){
	$.get("roomuserUpdate.do",{"user_id":userId,"room_id":roomId,"grade":sel},function(data){
		if(data){
			SelectRoomUser(roomId);
			alert("修改成功！！！");
			layer.closeAll();
		}else{
			alert("修改失败！！！");
		}
	});
	
}
