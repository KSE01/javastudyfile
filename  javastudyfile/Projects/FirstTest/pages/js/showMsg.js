//显示提示消息 参数：消息内容
function showOperateMsg(msg){
	try{
		var obj = window.parent.frames[0];
		obj.showMsgBox(msg);
	} catch(e) {
		//alert(e);
	}
}

function showMsg(obj){
	showOperateMsg("测试消息");
}