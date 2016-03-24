function toDesktop(sUrl,sName){
try {
    var WshShell = new ActiveXObject("WScript.Shell");
    var oUrlLink = WshShell.CreateShortcut(WshShell.SpecialFolders("Desktop")     + "\\" + sName + ".url");
    oUrlLink.TargetPath = sUrl;
    oUrlLink.Save();
    }  
catch(e)  {  
          alert("当前IE安全级别不允许操作！");  
}
}
/*================================================================保存到桌面======================================================================*/

$(document).ready(function(){

	$(".side ul li").hover(function(){
		$(this).find(".sidebox").stop().animate({"width":"124px"},200).css({"background":"#2D2D2D"})	
	},function(){
		$(this).find(".sidebox").stop().animate({"width":"54px"},200).css({"background":"#2D2D2D"})	
	});
	
});

/*================================================================侧边栏======================================================================*/

$(document).ready(function(){
	current = 1;
	button = 1;
	ul = 7;
	width = 350;
	$('.p1').animate({"left":"0px"},200,"swing");
	$(".next").click(function(){
		button = current;
		current++
		if(current==(ul + 1)){
			current = 1
		}
		animateLeft(current, button)
	});
	
	$(".previous").click(function(){
		button = current;
		current--
		if(current == 0){
			current = ul
		}
		animateRight(current, button)
	});
	
	function animateLeft(current, button){
		$('.p' + current).css("left", width + "px");
		$('.p' + current).animate({"left": "0px"},200,"swing");
		$('.p' + button).animate({"left": -width + "px"},200,"swing");
		setbutton()
	}
	
	function animateRight(current, button) {
		$('.p' + current).css("left", -width + "px");
		$('.p' + current).animate({"left": "0px"},200,"swing");
		$('.p' + button).animate({"left": width + "px"},200,"swing");
		setbutton()
	}

});
/*================================================================用户消息横向切换======================================================================*/

jQuery(document).ready(function(){
	var qcloud={};
	$('[_t_nav]').hover(function(){
		var _nav = $(this).attr('_t_nav');
		clearTimeout( qcloud[ _nav + '_timer' ] );
		qcloud[ _nav + '_timer' ] = setTimeout(function(){
		$('[_t_nav]').each(function(){
		$(this)[ _nav == $(this).attr('_t_nav') ? 'addClass':'removeClass' ]('nav-up-selected');
		});
		$('#'+_nav).stop(true,true).slideDown(200);
		}, 150);
	},function(){
		var _nav = $(this).attr('_t_nav');
		clearTimeout( qcloud[ _nav + '_timer' ] );
		qcloud[ _nav + '_timer' ] = setTimeout(function(){
		$('[_t_nav]').removeClass('nav-up-selected');
		$('#'+_nav).stop(true,true).slideUp(200);
		}, 150);
	});
});
/*================================================================其它演播室和变装======================================================================*/


