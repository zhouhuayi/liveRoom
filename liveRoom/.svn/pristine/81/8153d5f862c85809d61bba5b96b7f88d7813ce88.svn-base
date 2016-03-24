var URL;	//请求地址
var WHERESQL;	//请求条件参数
var PAGENUM;	//起始页
var PAGESIZE;	//每页显示的条数
var TABLEID;	//表格ID
var COLUMNS;	//显示列所对应的属性字段名
var TOTAL;	//查询的总条数
var PAGETOTAL;	//总页数
var COLUMNFORMAT;	//显示的格式
var ROWSDATA;	//列表数据
var IDNAME;	//主键名称
/**
 * 分页列表
 * 
 * @author 周化益
 * @param url 请求地址
 * @param whereSql 请求条件参数
 * @param pageNum 起始页
 * @param pageSize 每页显示的条数
 * @param tableId 表格ID
 * @param columns 显示列所对应的属性字段名
 */
function tableData(url,whereSql,pageNum,pageSize,tableId,columns,columnFormat,IdName,orderBy) {
	if(url.indexOf("?") > 0) {
		url = url + "&";
	} else {
		url = url + "?";
	}
	URL = url; WHERESQL = whereSql; PAGENUM = pageNum; PAGESIZE = pageSize;
	TABLEID = tableId; COLUMNS=columns; IDNAME=IdName;COLUMNFORMAT = columnFormat;
	
	$.post(url+'pageNum='+pageNum+'&pageSize='+pageSize,{whereSql:WHERESQL,orderBy:orderBy}, function(data){
		var rowStr = '';
		var checkbox = $("#" + tableId + " thead th:first input");
		var ck = checkbox.attr("type") == "checkbox";
		
		ROWSDATA = data.rows;
		TOTAL = data.total;
		PAGETOTAL = parseInt(TOTAL/pageSize);
		if(TOTAL%pageSize > 0) {
			PAGETOTAL++;
		}
		
		$.each(ROWSDATA, function(i, n) {
			var row = ROWSDATA[i];
			if(i%2 == 0) {
				rowStr += '<tr class="altrow">';
			} else {
				rowStr += '<tr>';
			}
			
			if(ck) {
				rowStr += "<td><input type='checkbox' name='ck' value="+row[IdName]+"></td>";
			}
			
			$.each(columns, function(j, n) {
				if(columnFormat[n]) {
					rowStr += '<td>'+columnFormat[n](i)+'</td>';
				} else {
					if(row[n] || row[n]==0) {
						rowStr += '<td>'+row[n]+'</td>';
					} else {
						rowStr += '<td></td>';
					}
				}
			});
			rowStr += '</tr>';
		});
		
		if(ck) {
			checkbox.click(function() {
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox').each(function() {
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
			});
		}
		
		$('#' + tableId + ' tbody').html(rowStr);
		
		var padding = '<div style="float:left">\
			<input style="height: 30px;border: 1px solid #4bacff;background-color: white;"\
			type="button" id="upPage" value=" << 上一页  " onclick="upPage()"/>&nbsp;';
		var total_num = PAGETOTAL-PAGENUM;
		
		if(PAGENUM < 5 && PAGETOTAL > 8) {
			for (var i = 1; i < 8; i++) {
				padding += '<input class="button_border" type="button" id="page' + i + '" value = "' + i + '" \
				onclick="clickPadding(' + i + ')"/>&nbsp;';
			}
			padding += '...&nbsp;<input class="button_border" type="button" id="page' + PAGETOTAL + '" value = "' + PAGETOTAL + '" \
			onclick="clickPadding(' + PAGETOTAL + ')"/>&nbsp;';
		} else if(total_num > 4 && PAGETOTAL > 8) {
			padding += '<input class="button_border" type="button" id="page1" value ="1" \
			onclick="clickPadding(1)"/>&nbsp;...&nbsp;';
			for (var i = -3; i < 3 + 1; i++) {
				padding += '<input class="button_border" type="button" id="page' + (PAGENUM + i) + '" value = "' + (PAGENUM + i) + '" \
				onclick="clickPadding(' + (i + PAGENUM) + ')"/>&nbsp;';
			}
			padding += '...&nbsp;<input class="button_border" type="button" id="page' + PAGETOTAL + '" value = "' + PAGETOTAL + '" \
			onclick="clickPadding(' + PAGETOTAL + ')"/>&nbsp;';
		} else if(total_num <= 4 && PAGETOTAL > 8) {
			padding += '<input class="button_border" type="button" id="page1" value ="1" \
				onclick="clickPadding(1)"/>&nbsp;...&nbsp;';
				for (var i = -3; i < total_num + 1; i++) {
					padding += '<input class="button_border" type="button" id="page' + (PAGENUM + i) + '" value = "' + (PAGENUM + i) + '" \
					onclick="clickPadding(' + (i + PAGENUM) + ')"/>&nbsp;';
				}
		} else {
			for (var i = 1; i <= PAGETOTAL; i++) {
				padding += '<input class="button_border" type="button" id="page' + i + '" value = "' + i + '" \
				onclick="clickPadding(' + i + ')"/>&nbsp;';
			}
		}
		
		padding += '<input style="height: 30px;border: 1px solid #4bacff;background-color: white;"\
			 type="button" id="nextPage" value=" 下一页 >> " onclick="nextPage()"/></div>';
		padding += '<div style="float:right"><span class="align_left">按回车键跳转到指定\
			<input type="text" class="button_border" id="inputPage" style="width:40px;">页,共'+TOTAL+'条数</span></div>';
			
		$('#padding').html(padding);
		
		$('#' + tableId).css("width","100%");

		$('#padding').css("width","100%");
		
		if(PAGENUM == PAGETOTAL) {
			$('#nextPage').attr("disabled","disabled").css("background-color","#F5F5F5")
			.css("border","1px solid gray");
		}
		
		if(PAGENUM == 1){
			$('#upPage').attr("disabled","disabled").css("background-color","#F5F5F5")
			.css("border","1px solid gray");
		}
		
		$("#page"+PAGENUM).attr("disabled","disabled").css("background-color","#4bacff");

		 /*JQuery 限制文本框只能输入数字*/
	    $("#inputPage").keyup(function(event) {
	    	$(this).val($(this).val().replace(/[^0-9.]/g,''));
			if(event.keyCode == 13){
		    	var pageNum = $("#inputPage").val() > PAGETOTAL ? PAGETOTAL : $("#inputPage").val();
		    	pageNum = pageNum == 0 ? 1 : pageNum;
		    	tableData(URL, WHERESQL, pageNum, PAGESIZE, TABLEID, COLUMNS,COLUMNFORMAT);
		    }
	    }).bind("paste",function(){  //CTR+V事件处理    
	        $(this).val($(this).val().replace(/[^0-9.]/g,''));     
	    }).css("ime-mode", "disabled"); //CSS设置输入法不可用 
	});
}

/**
 * 下一页
 */
function nextPage() {
	PAGENUM = PAGENUM + 1;
	tableData(URL, WHERESQL, PAGENUM, PAGESIZE, TABLEID, COLUMNS,COLUMNFORMAT,IDNAME);
}

/**
 * 上一页
 */
function upPage() {
	PAGENUM = PAGENUM - 1;
	tableData(URL, WHERESQL, PAGENUM, PAGESIZE, TABLEID, COLUMNS,COLUMNFORMAT,IDNAME);
}

/**
 * 单击的页数
 * @param pageNum 点击的页数
 */
function clickPadding(pageNum) {
	tableData(URL, WHERESQL, pageNum, PAGESIZE, TABLEID, COLUMNS,COLUMNFORMAT,IDNAME);
}

/**
 * 刷新表格
 */
function CommonRefreshTable() {
	tableData(URL, WHERESQL, PAGENUM, PAGESIZE, TABLEID, COLUMNS,COLUMNFORMAT,IDNAME);
}

/**
 * 获取列表数据
 * @author 周化益
 * @param rowsData 
 * @param index
 * @returns 列表数据
 */
function getRowData(index) {
	if(index || index == 0) {
		return ROWSDATA[index];
	} else {
		return ROWSDATA;
	}
}