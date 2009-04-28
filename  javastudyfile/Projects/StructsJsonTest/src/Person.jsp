<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Insert title here</title>
<script type="text/javascript">
function createxmlhttp()
{
		//xmlhttpクラスを作成
		var xmlhttp = false;
		try	
		{	
			//サーバーに「ＨTTP」リクエストを発送するために、「XMLHttpRequest」クラスを創建しました
  		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e) 
		{
   		try 
   		{
   			//サーバーに「ＨTTP」リクエストを発送するために、「XMLHttpRequest」クラスを創建しました
    		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
   		} 
   		catch (e) 
   		{
    		xmlhttp = false;
   		}
	}
	if (!xmlhttp && typeof XMLHttpRequest != 'undefined') 
	{
			xmlhttp = new XMLHttpRequest();
	    if (xmlhttp.overrideMimeType)
   		{
  			xmlhttp.overrideMimeType('text/xml');
   		}
	}
	return xmlhttp;	
}

function showJson()
{
	var xmlhttp = createxmlhttp();
    xmlhttp.onreadystatechange=requestdata;
    var url = "JsonTest.action";
	xmlhttp.open("GET",url,true);
	xmlhttp.setRequestHeader("If-Modified-Since","0");
	xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlhttp.send(null);
	function requestdata()
	{
   		if (xmlhttp.readyState == 4)
   		{
       		if (xmlhttp.status == 200)
			{
               		//alert(xmlhttp.responseText);
           		var jsobj = eval('('+xmlhttp.responseText+')')
           		var htmlobj = document.getElementById("jsTest");
           		var ULobj = document.createElement("UL");
           		
           		var Liobj = document.createElement("Li");
           		Liobj.innerText = jsobj.name
           		ULobj.appendChild(Liobj);
           		
           		var Liobj1 = document.createElement("Li");
           		Liobj1.innerText = jsobj.PersonCode
           		ULobj.appendChild(Liobj1);

           		var Liobj2 = document.createElement("Li");
           		var ULobj1 = document.createElement("UL");
           		for(i=0;i<jsobj.personList.length;i++)
           		{
               		var Li = document.createElement("Li");
               		Li.innerText = jsobj.personList[i];
               		ULobj1.appendChild(Li);
           		}
           		Liobj2.appendChild(ULobj1);
           		ULobj.appendChild(Liobj2);
           		
           		htmlobj.appendChild(ULobj);
			}
		}
	}
	
}
</script>
</head>
<body>
<form>
<input type="button" onclick="showJson()" value="OK">
<div id="jsTest"></div>
</form>
</body>
</html>