<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<script type="text/javascript" src="js/jquery-1.3.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){

	$('#showjquery').click(function(){
		$.ajax({
				type:"post",
				url:"JsonTest.action",
				success:function(data)
				{
					var jsobj = eval('('+data+')');
					var name = jsobj.name;
					var code = jsobj.personCode;
					var str = "<UL> <Li>"+name+"</Li><Li>"+code+"</Li>";
					var liststr = "<li><UL>";
					for(i=0;i<jsobj.personList.length;i++)
					{
						liststr += "<Li>";
						liststr += jsobj.personList[i];
						liststr += "</Li>"
					}
					liststr += "</UL></Li>";
					str = str + liststr + "</UL>"
					$('#jsTest').append(str);


					
					

					
				}
		});	
		});
})
</script>
</head>
<body>
	<input id="showjquery" type="button" value="OK">
	<div id="jsTest"></div>
</body>
</html>