$(function() {
	$("#tj").click(function() {
		var text = $("#disable").val();
		if (text == "") {
			alert("请输入内容!");
		} else {
			$.ajax({
				type : "post",
				url : "disableword.do",
				data : "disable=" + text,
				success : function(data) {
					if (data) {
						alert("添加成功!");
						location.replace(location)
					} else {
						alert("添加失败!");
						location.replace(location)
					}
				}
			});
		}
	});
});