<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>登录页面</title>
	</head>
	<body>
		<form action="login2.action" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="user.username"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="user.password"></td>
				</tr>
				<tr>
					<td><input type="reset" value="重填"></td>
					<td><input type="submit" value="登录"></td>
				</tr>
			</table>
		</form>
	</body>
</html>