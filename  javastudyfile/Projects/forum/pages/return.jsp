<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Insert title here</title>
</head>
<body>

<input type="text" id="myurl" value=<%=request.getAttribute("returnUrl")%> />
<script type="text/javascript">
var myurl=document.getElementById("myurl").value;
parent.KE.plugin["image"].insert("content4",myurl,"0","0","0","0");
</script>

</body>
</html>