<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>论坛: 注册新帐号</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
A {
	
}

A:link {
	color: #003399;
}

A:visited {
	color: #003399;
}

A:hover {
	color: #99ccff;
	text-decoration: none;
}

A:active {
	color: #99ccff;
}
</style>
<script language="javascript" src="pages/js/jquery-1[1].3.1.min.js"
	type="text/javascript"></script>

<script language="JavaScript" type="text/javascript">

function String.prototype.Trim()    
{
  return this.replace(/(^\s*)|(\s*$)/g,"").replace(/(^　*)|(　*$)/g,"").replace(/(^\s+|\s+$)/g,"");     
}

function userErrorMessage(){
	 $("#errorUserId").empty().append("<font color='red' size='2'>用户名只能由数字、字母和 '_' 组成</font>");
}
function passwordErrorMessage(){
	 $("#errorPassword").empty().append("<font color='red' size='2'>密码只能由数字、字母和 '_' 组成</font>");
}
		$(document).ready(function() {
			userErrorMessage();
			passwordErrorMessage();
		  $('#registerUserId').click(function(){
			  userErrorMessage();
			  })
		  $('#registerUserId').blur(function(){
			  if($('#registerUserId').val().Trim()  == ""){
				    return false;
				  }
			  $.ajax({
	                type: "post",
	                url: "checkUser.action",
	                data: "registerUserId ="+encodeURI($('#registerUserId').val()),
	                success: function(data){
	                var companyMessage = eval('(' +data+ ')');
	                var errorMessage = companyMessage.errorMessage;
	                if(!errorMessage == ""){
	                	   $("#errorUserId").empty().append("<font color='red' size='2'>"+errorMessage+"</font>");
	                }
	                else{
	                	   $("#errorUserId").empty().append("<font color='green' size='2'>"+$('#registerUserId').val() +" 还没有被注册，请赶紧注册吧</font>");
		                }
	                },
	             error: function(){
	                   alert('error') //请求出错处理
	                }
	          
	        });
			  })
		});

		$(document).ready(function() {
			$('#registerPassword').click(function(){
				passwordErrorMessage();
                })
	          $('#registerPassword').blur(function(){
		          if($('#registerPassword').val().Trim()  == ""){
		        	    return false;
			          }
	        	  $.ajax({
	                    type: "post",
	                    url: "checkPassword.action?registerPassword ="+encodeURI($('#registerPassword').val()),
	                    success: function(data){
	        		  var companyMessage = eval('(' +data+ ')');
                      var errorMessage = companyMessage.errorMessage;
                      $("#errorPassword").empty();
                      if(!errorMessage == ""){
                          $("#errorPassword").append("<font color='red' size='2'>"+errorMessage+"</font>");
                   }
	        	  },
	                 error: function(){
	                       alert('error') //请求出错处理
	                    }
	              
	            });
	              })
	        });


		 $(document).ready(function(){
             $('#checkRegisterPassword').blur( function(){
            	 $("#errorCheckPassword").empty();
                         if($('#checkRegisterPassword').val() !=  $('#registerPassword').val()){
                        	 $("#errorCheckPassword").append("<font color='red' size='2'>两次输入的密码不一致</font>");
                             $('#checkRegisterPassword').attr('value','');
                             }
                         })
             })
             
       $(document).ready(function(){
             $('#registerUserName').blur( function(){
                 $("#errorUserNmae").empty();
                         if($('#registerUserName').val() == ""){
                             $("#errorUserNmae").append("<font color='red' size='2'>用户名是必填信息，请您一定要填写</font>");
                             }
                         })
             })      
             
    $(document).ready(function() {
       $('#createButton').click(function(){
    	   var checkColor = 0;
    	  $('#registerTable td > input:lt(2)').each(function(){
    		    if(this.value == ""){
        		    $(this).parent('td').next().children().empty().append("<font color='red' size='2'>这是必填信息，请您一定要填写</font>")
        		    checkColor++;
        		    }
        	  })
           $("#registerTable td > input[type = 'password']").each(function(){
                if(this.value == ""){
                	 $(this).parent('td').next().children().empty().append("<font color='red' size='2'>密码是必填信息，请您一定要填写</font>")
                	 checkColor++;
                	 }
              })
           if($('#checkRegisterPassword').val() !=  $('#registerPassword').val()){
               $("#errorCheckPassword").empty().append("<font color='red' size='2'>两次输入的密码不一致</font>");
               $('#checkRegisterPassword').attr('value','');
               return false;
               }
    	   $("label font").each(function(){
        	   if(this.color == "#ff0000"){
                 alert("您填写的信息有错误，请认真填写");
                 checkColor++;
                 return false;
        	   }
        	   })
        	   if(checkColor == 0){
        		   $('#accountform').submit();
            	   }
           })
     });
            	    
		</script>
</head>
<body style="background-color: #f5ffff" oncopy="return false;" oncut="return false;">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tbody>
		<tr>
			<td width="40%"><img src="pages/images/header-stretch.gif" alt=""
				border="0" height="57" width="100%"></td>
			<td width="1%"><img src="pages/images/header-right.gif" alt=""
				height="57" border="0"></td>
		</tr>
	</tbody>
</table>
<br />
<br />
<div id="jive-accountbox" style="width: 100%; font-size: 13px;"
	align="right">欢迎, 游客 &nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/forum">登录
/ 注册</a>&nbsp;&nbsp;&nbsp; <a href="/guestsettings!default.jspa"
	class="jive-acc-cp">游客设置</a></div>
<div id="jive-body-intro-content">
<h1>注册新帐号</h1>
<p>请填写以下表单创建新帐号. 带<font color="red">*</font> 号的项表示必填项.</p>
</div>
<form action="register.action" method="post" name="accountform"
	id="accountform">
<div align="center">
<table cellpadding="1" cellspacing="1" border="1" width="90%"
	nowrap="nowrap" id="registerTable">
	<tr style="border: 0px;">
		<th colspan="3" style="background-color: #30f4ff">注册新帐号</th>
	</tr>
	<tr style="border: 0px;">
		<td width="20%" align="left"><label for="username01">用户名:<span>*</span></label>
		</td>
		<td width="20%" align="left"><input type="text" style="ime-mode:disabled;"
			name="registerUserId" size="30" maxlength="25" id="registerUserId"></td>
		<td valign="bottom" align="left">&nbsp;<label id="errorUserId"></label></td>
	</tr>
	<tr style="border: 0px;">
		<td align="left"><label for="name01">姓名:<span>*</span></label></td>
		<td align="left"><input type="text" name="registerUserName"
			size="30" maxlength="25" id="registerUserName"></td>
		<td align="left">&nbsp;<label id="errorUserNmae"></label></td>
	</tr>
	<tr>
		<td align="left"><label for="password01">密码:<span>*</span></label></td>
		<td align="left"><input type="password" name="registerPassword"
			size="32" maxlength="25" id="registerPassword"></td>
		<td align="left">&nbsp;<label id="errorPassword"></label></td>
	</tr>
	<tr>
		<td align="left"><label for="confirmpass01">确认密码:<span>*</span></label></td>
		<td align="left"><input type="password"
			name="checkRegisterPassword" size="32" maxlength="25"
			id="checkRegisterPassword"></td>
		<td valign="bottom" align="left">&nbsp;<label
			id="errorCheckPassword"></label></td>
	</tr>
	<tr>
		<td align="left"><label for="location01">来自:</label></td>
		<td align="left"><input type="text" name="location" size="30"
			maxlength="30" value="" onfocus="this.select();" id="location01"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left"><label for="occupation01">职业:</label></td>
		<td align="left"><input type="text" name="occupation" size="30"
			maxlength="30" value="" onfocus="this.select();" id="occupation01"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left"><label for="homepage01">主页:</label></td>
		<td align="left"><input type="text" name="homepage" size="30"
			maxlength="100" value="" onfocus="this.select();" id="homepage01"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left"><label for="biography01">简介:</label></td>
		<td align="left"><textarea name="biography" cols="30" rows="3"
			id="biography01"></textarea></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left"><label for="signature01">签名:</label></td>
		<td align="left"><textarea name="signature" cols="30" rows="3"
			id="signature01"></textarea></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left"><label for="profile_1__value">QQ:</label></td>
		<td align="left"><input type="text" name="profile[1].value"
			value="" id="profile_1__value" /></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left"><label for="profile_2__value">MSN:</label></td>
		<td align="left"><input type="text" name="profile[2].value"
			value="" id="profile_2__value" /></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align="left">自动登录:</td>
		<td align="left"><input type="checkbox" name="autoLogin"
			id="cb01"> <label for="cb01">记住我</label></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="button" name="createButton" id="createButton"
			class="jive-form-button jive-form-button-submit" value="创建帐号">
		<input type="submit" name="method:cancel"
			class="jive-form-button jive-form-button-cancel" value="取消">
		</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
</form>
</div>
</div>
<br />
<br />
<hr width="100%">
<table id="jive-footer" cellpadding="6" cellspacing="0" border="0"
	width="100%" align="center" style="font-size: 10px;">
	<tr>
		<td align="center"><a href="#">Forum Home</a>| <a href="#">Login
		/ Register</a>| <a href="#">Create Account</a>| <a href="#">Search</a> <br />
		<a href="http://www.baidu.com" target="_blank"><b> <font
			color="red">C</font></b>hina<b> <font color="green">J</font></b>ava<b>
		<font color="blue">W</font></b>orld.com</a></td>
	</tr>
</table>
</body>
</html>
