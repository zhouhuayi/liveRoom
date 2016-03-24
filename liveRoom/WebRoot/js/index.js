function leftList() {
    $(".ce > li > a").click(function(){
	     $(this).addClass("xz").parents().siblings().find("a").removeClass("xz");
		 $(this).parents().siblings().find(".er").hide(300);
		 $(this).siblings(".er").toggle(300);
		 $(this).parents().siblings().find(".er > li > .thr").hide().parents().siblings().find(".thr_nr").hide();
	});
	
    $(".er > li > a").click(function(){
        $(this).addClass("sen_x").parents().siblings().find("a").removeClass("sen_x");
        $(this).parents().siblings().find(".thr").hide(300);	
	    $(this).siblings(".thr").toggle(300);	
	});

    $(".thr > li > a").click(function(){
	     $(this).addClass("xuan").parents().siblings().find("a").removeClass("xuan");
		 $(this).parents().siblings().find(".thr_nr").hide();	
	     $(this).siblings(".thr_nr").toggle();
	});
}

function meunClick(powerUrl) {
	var frames=window.parent.window.document.getElementById("mainFrame");
	frames.contentWindow.location.href=powerUrl;
}

function meunList() {
	$.post("powerListByRole.do" , function(data) {
		if(!data) {
			return;
		}
		var powerList = '';
		var bool;
		var onePower = '';
		
		$.each(data, function(i, n) {
			bool = false;
			if(!n.power_parentId) {
				onePower = '<li> <a href="javaScript:meunClick(\'' + n.power_url + '\')">' + n.power_name + '</a></li>';
				var twoPower = '';
				$.each(data, function(j, m) {
					if(n.power_id == m.power_parentId) {
						bool = true;
						twoPower += '<li><a href="javaScript:meunClick(\'' + m.power_url + '\')">' + m.power_name + '</a> </li>';
					}
				});
				
				if(bool) {
					onePower = '<li> <a href="' + n.power_url + '">' + n.power_name + 
					'<img class="more" src="image/more.png"/> </a> <ul class="er">' + twoPower +
					'</ul></li>';
				} 
				powerList += onePower;
			}
		});
		$(".ce").append(powerList + '<div class="clear"></div>');
		$(".ce li:first a").addClass("xz");
		leftList();
	});
};