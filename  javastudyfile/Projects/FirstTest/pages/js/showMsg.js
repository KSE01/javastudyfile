//显示提示消息 参数：消息内容
function showOperateMsg(msg){
	try{
		var obj = window.parent.frames[0];
		obj.showMsgBox(msg);
	} catch(err) {
		alert(err.description||err);
	}
}

function showMsg(){
	showOperateMsg("测消息测试消测消息测试消息测试测消息测试消息测试测消息测试消息测试测消息测试消息测试息测试消息");
}