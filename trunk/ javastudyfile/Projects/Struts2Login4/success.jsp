<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head><title>欢迎页面</title></head>
	<body>
		<h3>${sessionScope.user.username}，${requestScope.greeting}。<br>
		本站的访问量是：${applicationScope.counter}</h3>
	</body>
</html>