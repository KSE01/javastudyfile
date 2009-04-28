<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="pages/css/style.css" />
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<title>论坛: 用户登录</title>
<script language="JavaScript" type="text/javascript">
		</script>
</head>
<body>
<br />
<br />
<div id="jive-loginpage" style="position: absolute; right: 200px;">
<p>如果你还没有帐号，请先 <a href="changeregister.action">注册一个新帐号</a>.</p>
<br />
</div>
<div style="position: absolute; top: 300px; left: 300px;">
<form action="login.action" method="post" name="loginform">
<center>
<div class="jive-login-form">
<div class="jive-table">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<thead>
		<tr>
			<th colspan="3" class="jive-first">用户登录</th>
		</tr>
	</thead>
	<tbody>
		<tr height="50">
			<td  class="jive-label"><label for="username01">用户名:</label></td>
			<td width="150"><input style="width: 200px"
				type="text" name="txtEmployeeCD" size="30" maxlength="150"
				id="txtEmployeeCD"></td>
			<td align="left" valign="bottom">
			<s:fielderror>
				<s:param>txtEmployeeCD</s:param>
			</s:fielderror></td>
		</tr>
		<tr  height="50">
			<td class="jive-label"><label for="password01">密码:</label></td>
			<td><input style="width: 200px" type="password"
				name="txtPassword" size="30" maxlength="150"
				id="txtPassword"></td>
				<td align="left" valign="bottom">
				<s:fielderror>
                <s:param>txtPassword</s:param>
                <s:actionerror/>
                <a href="pages/register.jsp"> <s:actionmessage />
            </a>
            </s:fielderror></td>
		</tr>
	</tbody>
		<tr height="40">
			<td>&nbsp;</td>
			<td><span class="nobreak"> <input type="submit"
				name="login" value="登录" tabindex="4" class="jive-login-button">
			<input type="submit" name="doCancel" value="取消" tabindex="5">
			</span></td>
		</tr>
</table>
</div>
</div>
</center>
</form>
</div>
<div style="position: absolute; top: 400px; left: "><br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<table id="jive-footer" cellpadding="6" cellspacing="0" border="0"
	width="100%">
	<tr>
		<td><a href="#">论坛主页</a> | <a
			href="#">登录 / 注册</a> | <a
			href="#">创建帐号</a>| <a href="#">搜索</a>
		<br />
		<a href="#" target="_blank"><b> <font
			color="red">C</font></b>hina<b> <font color=“green”>J</font></b>ava<b>
		<font color=“blue”>W</font></b>orld.com</a></td>
	</tr>
</table>
</div>
</body>
</html>
