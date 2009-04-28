<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS</title>
<style type="text/css">
<!--
p{text-indent:18pt;font-size:13px}
td{font-size:13px}
th{font-size:15px}
a:link{text-decoration:none;color:#0000ff}
a:visited{text-decoration:none;color:#0000ff}
a:hover{text-decoration:underline;color:#96CCFE}
.style1 {color: #FFFFFF}
.style6 {color: #0000FF}

.link {color:#585858}
.link a:link{text-decoration:none;color:#585858}
.link a:visited{text-decoration:none;color:#585858}
.link a:hover{text-decoration:underline;color:#96CCFE}
body {
	margin-bottom: 2px;
}
-->
</style>
<script type="text/javascript" src="pages/js/kindeditor.js"></script>
<script type="text/javascript">
	function submit(flag){
		document.formList.action="subjectDetail.action";
		document.formList.flag.value=flag;
		document.formList.submit();
	}
	KE.show({
        id : 'content4',
        wyswygMode : false
    });
</script>
</head>

<body>
<table width="750"  border="0" align="center">
  <tr>
    <td><div align="right" style="font-size:12px ">[<a href="backarticle.action" target="_blank">首页</a>] [<a href="backarticle.action">论坛首页</a>]
       [<a href="#"><font color="#FF0000\"></font></a>] [<a href="login.jsp">登录</a>] [<a href="reg.jsp">注册</a>] [<a href="#">离开</a>]
        &nbsp;&nbsp; </div></td>
  </tr>
</table>
<table width="750" border="0" align="center">
 <tr>
					<td width="40%">
						<img src="pages/images/header-stretch.gif" alt="" border="0" height="57" width="100%">
					</td>
					<td width="1%">
						<img src="pages/images/header-right.gif" alt="" height="57" border="0">
					</td>
				</tr>
  <tr>
    <td><table width="100%"  border="0" cellspacing="0">
      <tr>
        <td height="8">&nbsp;</td>
      </tr>
      <tr>
        <td height="20" bgcolor="#f8f8f8">&nbsp;&nbsp;<a href="#">BBS</a> &gt; <font color="#FF0000\"><s:property value="articlesubject" /></font></td>
      </tr>
    </table></td>
  </tr>
</table>
  <table width="750" border="0" align="center">
    <tr>
      <td><div align="right">
       <a href="#" onclick="submit('F')">首页</a><a href="#" onclick="submit('P')">上一页</a>
	   <a href="#" onclick="submit('N')">下一页</a><a href="#" onclick="submit('L')">末页</a>
        第<s:property value="nowPage" />页 共<s:property value="pageCount" />页 回复--帖&nbsp;&nbsp;</div></td>
    </tr>
</table>
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#f8f8f8" style="table-layout:fixed; BORDER-BOTTOM:  #d1d1df 1px solid; BORDER-LEFT:  #d1d1df 1px solid; BORDER-RIGHT:  #d1d1df 1px solid; BORDER-TOP: #d1d1df 1px solid">
  <tr>
    <td height="20" colspan="2"><table width="100%"  border="0" cellspacing="1">
        <tr>
          <td bgcolor="#7188e0" class="style1">&nbsp;&nbsp;&nbsp;主题：<s:property value="articlesubject" />
</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td width="345" height="20" class="link"> &nbsp; &nbsp;作者：[<s:property value="articleauthorid" />] 发表于<s:property value="articlecreatedate" /></td>
    <td width="405" height="20" class="link"><div align="right">[<a href="#reply1">回复</a>] [<a href="#">编辑</a>] &nbsp;&nbsp;</div></td>
  </tr>
  <tr>
    <td height="8" colspan="2"></td>
  </tr>
  <tr>
    <td colspan="2">
      <table width="98%"  border="0" align="center">
        <tr>
         	<td>
				<s:property value="articlebody" />
			</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="8"  colspan="2"></td>
  </tr>
</table><table width="750"  border="0" align="center" cellspacing="0">
  <tr>
    <td height="1"></td>
  </tr>
</table>

<s:iterator value="list" status="list">
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#f8f8f8" style="table-layout:fixed ;BORDER-BOTTOM:  #d1d1df 1px solid; BORDER-LEFT:  #d1d1df 1px solid; BORDER-RIGHT:  #d1d1df 1px solid; BORDER-TOP: #d1d1df 1px solid">
  <tr>
    <td height="20" colspan="2"><table width="100%"  border="0" cellspacing="1">
        <tr>
          <td bgcolor="#7188e0" class="style1">&nbsp;&nbsp;&nbsp;RE:主题：<s:property value="replysubject" /></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td width="347" height="20" class="link"> &nbsp; &nbsp;作者：[<s:property value="replyauthor" />] 发表于<s:property value="replycreatedate" /></td>
    <td width="403" height="20" class="link"><div align="right">
      [<a href="#reply1">回复</a>]&nbsp;[<a href="#">编辑</a>]&nbsp;&nbsp;</div></td>
  </tr>
  <tr>
    <td height="8" colspan="2"></td>
  </tr>
  <tr>
    <td colspan="2"><table width="98%"  border="0" align="center">
        <tr>
          <td>
          <s:property value="replybody" escape="false" />
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
<table width="750"  border="0" align="center" cellspacing="0">
  <tr>
    <td height="1"></td>
  </tr>
</table>
</s:iterator>
<table width="750" border="0" align="center" cellspacing="0" bgcolor="#f8f8f8">
  <tr>
    <td><table width="100%"  border="0" align="center">
      <tr>
        <td bgcolor="#e8e8f8">
        <div align="right">
       <a href="#" onclick="submit('F')">首页</a><a href="#" onclick="submit('P')">上一页</a>
	   <a href="#" onclick="submit('N')">下一页</a><a href="#" onclick="submit('L')">末页</a>
        第<s:property value="nowPage" />页 共<s:property value="pageCount" />页 回复--帖&nbsp;&nbsp;</div>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
 <tr>
 <td>
        <table width="100%"  border="0" cellspacing="0">
          <tr>
            <td bgcolor="#e8e8f8">&nbsp;</td>
          </tr>
        </table>
      </td>
      </tr>

  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
      <form action='replySubject.action?id=<s:property value="id" />' method="post">
        <table width="640"  border="0" align="center" cellspacing="1" bgcolor="#7188e0" style="BORDER-BOTTOM: #7188e0 1px solid; BORDER-LEFT: #7188e0 1px solid; BORDER-RIGHT: #7188e0 1px solid; BORDER-TOP: #7188e0 1px solid">
          <tr>
            <td colspan="2" bgcolor="#fefefe"><table width="100%"  border="0" cellspacing="1">
                <tr>
                  <th bgcolor="#7188e0"><span class="style1"><a name="1"></a>快速回复</span></th>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td width="13%" height="22" bgcolor="#fefefe"><div align="right">主&nbsp;&nbsp;题：</div></td>
            <td width="83%" bgcolor="#fefefe">&nbsp;<a name="reply1"><input type="text" name="replySubject" value="Re:" size="58" style="BORDER: #7188e0 1px solid;color:#1818FF;"></a>
        </td>
          </tr>
          <tr>
            <td valign="top" bgcolor="#fefefe"><div align="right">正&nbsp;&nbsp;文：</div></td>
            <td bgcolor="#fefefe">&nbsp;<div class="editor"><textarea id="content4" name="replyBody" cols="66" rows="8" style="width:700px;height:300px;visibility:hidden;"></textarea></div></td>
          </tr>
     		 <tr>
            <td bgcolor="#fefefe"></td>
            <td bgcolor="#fefefe">&nbsp;<input type="submit" value="提交回复" />&nbsp;<input type="reset" value="清空重写" /></td>
          </tr>
        </table>
        <input type="hidden" name="flag" />
		<input type="hidden" name="nowPage" value='<s:property value="nowPage" />' />
      </form>
</td>
  </tr>
  <tr>
    <td bgcolor="#ffffff">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#ffffff"><table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="20" bgcolor="#f0f0f0"><div align="center"><a href="http://hi.baidu.com/tyouseiryuu" target="_blank"><font color="#686868">版权所有</font></a>&nbsp;&nbsp;&copy; 2009-2010</div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#ffffff">&nbsp;</td>
  </tr>
</table>
<form action="#" name="formList">
	<input type="hidden" name="flag" />
	<input type="hidden" name="nowPage" value='<s:property value="nowPage" />' />
	<input type="hidden" name="id" value='<s:property value="id" />' />
</form>
</body>
</html>
