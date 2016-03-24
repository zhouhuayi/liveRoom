// JavaScript Document

//<!-- 点击收缩换肤栏 -->
$(".but").click(function(){
	$("#hf").slideToggle("slow");  
});
//<!-- 点击换body图 -->
$(".scrollCon ul li").click(function(){
	var simg=$(this).find("img").attr("src");
	var bimg=simg.replace(/-\d*/,'');  //根据小图找到大图的名称
	$("body").css("background","url("+bimg+")");//url("+bimg+"),添加 变量的方法
	
});
//<!-- 点击左边按钮 -->
var click_num=0; //初始点击次数

$(".right").click(function(){
	click_num++;       //click_num+1
	if(click_num>1){
		click_num=0;
	}
	$(".scrollCon").animate({left:click_num*(-1080)},300);
});
$(".left").click(function(){
	click_num--;       //click_num+1
	if(click_num<0){
		click_num=1;
	}
	$(".scrollCon").animate({left:click_num*(-1080)},300);
});
/*=====================================变装切换=================================================*/

$("#exampleModal").on("show.bs.modal",function(event){
		var button = $(event.relatedTarget);
		var recipient = button.data("whatever");
		var modal = $(this);
		modal.find(".modal-title").text("评论"+recipient);
		modal.find(".modal-body input").val(recipient);
		});
$("#shuju").on("show.bs.modal",function(event){
		var button = $(event.relatedTarget);
		var recipient = button.data("whatever");
		var modal = $(this);
		modal.find(".modal-title").text("数据"+recipient);
		modal.find(".modal-body input").val(recipient);
		});
/*=====================================弹窗口=================================================*/		

	$(function(){
		$(".btn_re").click(function(){
			$(".main_left").slideToggle(0);
			$(".main_right").slideToggle(0);
			});
		});
		
		$(window).resize(function(e) {
			var a=$(window).width();
			var win_height =$(window).height();
			//console.info(win_height);
			if(a>1250){
				$(".main_left").show();
				$(".main_right").show();
				}
        });
/*=====================================左右板块出现隐藏=================================================*/		

	$(".foot1").click(function(){        //底部footer滑动隐藏显示
  		$(".footer").slideToggle("show");
	});
/*=====================================底部footer滑动隐藏显示=================================================*/		

/*=====================================分享=================================================*/		