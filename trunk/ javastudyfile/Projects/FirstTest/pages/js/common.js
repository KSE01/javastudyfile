//$(function(){
//	getCurrentTime();
//}); 
//function Test(){
//	msgOpacity = 100;
//	alert(msgOpacity)
//}
var msgOpacity = 1;
var hideSpeed = Math.ceil(100/20);
var timeOut;

function showMsgBox(msg){
	if(timeOut){
		clearTimeout(timeOut);
	}
	var msgBox = document.getElementById("hdiv_msgBox_comment");
	if(msg){
		var msgLen = msg.length;
		msgBox.style.width=""+(msgLen*17)+"px";
	}
	if(msgBox.innerText || msgBox.innerText == ""){			
		msgBox.innerText=msg;
	} else {
		msgBox.textContent=msg;
	}
	msgOpacity = 100;
	hideMsgBox();
}
function hideMsgBox(){
//	var myYear,myMonth,myDate,myDayIndex,myDay,myWeekArraytoday,dateString; 
//	var hours, minutes, seconds, xfile;var intHours, intMinutes, intSeconds;
//	myWeekArray = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
//	today = new Date();	intHours = today.getHours();
//	intMinutes = today.getMinutes();intSeconds = today.getSeconds();
//		
//	myYear = today.getFullYear();myMonth =today.getMonth() + 1;	myDate =today.getDate();
//	myDayIndex = today.getDay();		
//	for(var i = 0;i<myWeekArray.length;i++)	{if(myDayIndex == i){myDay = myWeekArray[i];}}
//		
//	hours = intHours + "时";if (intMinutes < 10){minutes = "0"+intMinutes+"分";} else {minutes = intMinutes+"分";}
//		
//	if (intSeconds < 10){seconds = "0"+intSeconds+"秒";} else{seconds = intSeconds+"秒";}
//		
//	dateString = "现在时刻：" + myYear +"年"+ myMonth +"月"+ myDate +"日" + " " + myDay + " " + hours+minutes+seconds;
//	$("#hdivTime").text(dateString);
	
	
	timeOut = setTimeout("hideMsgBox();", 200);
	
	//设定提示消息的状态 这个现在主要是导航页面在用	
	//var msgObj = $("#hdivMsgBox");
	var today = new Date();
	var intSeconds = today.getSeconds();
	document.getElementById("wang").innerHTML = intSeconds;
	var msgObj = document.getElementById("hdivMsgBox");
	var msgComObj = document.getElementById("hdiv_msgBox_comment");
	if(msgOpacity == 100){
		msgComObj.style.filter = "alpha(opacity=100)";
		msgComObj.style.opacity = "1";


		msgObj.style.display="block";
		msgComObj.style.display="block";
		
		msgOpacity -= hideSpeed;
	} else {
		if(msgOpacity<=0){			
			//msgObj.hide();
			msgObj.style.display="none";
			msgComObj.style.display="none";
			clearTimeout(timeOut);
			return;
		}
		var tempNum = msgOpacity/100;
		msgComObj.style.filter = "alpha(opacity="+msgOpacity+")";
		msgComObj.style.opacity = tempNum;
		msgOpacity -= hideSpeed;		
	}
}