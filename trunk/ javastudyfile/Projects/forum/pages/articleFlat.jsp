<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*, java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%
	response.addHeader("Cache-Control", "no-cache");
	response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
%>
<html>
	<head>
		<title>论坛主题</title>
		 <META   HTTP-EQUIV="Cache-Control"   CONTENT="no-cache">
		 <META   http-equiv="Pragma"   content="no-cache">
		<meta http-equiv="content-type" content="text/html; charset=utf8">
		<link rel="stylesheet" type="text/css" href="pages/images/style.css" title="Integrated Styles">
		<script type="text/javascript" src="pages/js/jquery-1[1].3.1.min.js"></script>
		<script type="text/javascript" src="pages/js/article.js"></script>
	</head>
	
	<body>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  			<tbody>
    			<tr>
      				<td width="40%"><img src="pages/images/header-stretch.gif" alt="" border="0" height="57" width="100%"></td>
      				<td width="1%"><img src="pages/images/header-right.gif" alt="" height="57" border="0"></td>
    			</tr>
  			</tbody>
		</table>
		<br>
		<div id="jive-forumpage">
  			<table border="0" cellpadding="0" cellspacing="0" width="100%">
    			<tbody>
      				<tr valign="top">
        				<td width="98%">
        					<p class="jive-breadcrumbs">论坛: Java语言*初级版(模仿)</p>
          					<p class="jive-description"> 探讨Java语言基础知识,基本语法等 大家一起交流 共同提高！谢绝任何形式的广告 </p>
          				</td>
      				</tr>
    			</tbody>
  			</table>
  			<div class="jive-buttons">
    			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      				<tbody>
        				<tr>
          					<td class="jive-odd">
          						<a href="post.jsp">
          							<img src="pages/images/post-16x16.gif" alt="发表新主题" border="0" height="16" width="16">
          						</a>
          					</td>
          					<td class="jive-icon-label">
          						<a id="newsubject" href="changeaddSubject.action">发表新主题</a>
          						<a href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;isBest=1"></a>
          					</td>
        				</tr>
      				</tbody>
    			</table>
  			</div>
  			<div style="width:600px;height:80px;position:absolute;right:20px;top:80px;font-size:20px">
  			<img src="pages/images/my.gif" height="25" width="25" ></img>
  				<%=session.getAttribute("username") %>：您好。欢迎访问本论坛。。。。
  			</div>
  			<br>
  			<table border="0" cellpadding="3" cellspacing="0" width="100%">
    			<tbody>
      				<tr valign="top">
        				<td>
        					<span id="total" class="nobreak"><span id="nowpage"></span><span id="totalpage"></span><span class="jive-paginator"> [</span></span>
          					<span class="nobreak"><span class="jive-paginator">	<a href="#" id="first">第一页</a></span></span>
							<span class="nobreak"><span class="jive-paginator">|</span></span>
          					<span class="nobreak"><span class="jive-paginator"><a href="#" id="pre">上一页</a></span></span>
							<span class="nobreak"><span class="jive-paginator">| </span></span>
							<span class="nobreak"><span class="jive-paginator"><a href="#" id="next">下一页</a>|&nbsp; 
          						<a href="#" id="last">最末页</a> ] </span> </span>
          						<span>察看的的页数
          					<select style="width:100px" id="pageselected">
          					</select></span> 
          					<span>选择分页显示数
          					<select style="width:50px" id="selected">
          						<option  value="2">2</option>
          						<option selected="true" value="3">3</option>
          						<option value="4">4</option>
          						<option value="5">5</option>
          						<option value="6">6</option>
          						<option value="7">7</option>
          						<option value="8">8</option>
          						<option value="9">9</option>
          						<option value="10">10</option>
          					</select></span> 
          					
          				</td>
      				</tr>
    			</tbody>
  			</table>
  			<input type="text" name="pagecount" id="pagecount" style="display: none" value="1" />
  			<table border="0" cellpadding="0" cellspacing="0" width="100%">
    			<tbody>
      				<tr valign="top">
        				<td width="99%">
        				<div class="jive-thread-list">
            				<div class="jive-table">
              					 <table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                					<thead>
                  						<tr>
                    						<th class="jive-first" colspan="3" width="95%"> 主题 </th>
                    						<th class="jive-author" width="1%"> <nobr> 作者&nbsp; </nobr> </th>
                    						<th class="jive-view-count" width="1%"> <nobr> 浏览&nbsp; </nobr> </th>
                    						<th class="jive-msg-count" width="1%" nowrap="nowrap"> 回复 </th>
											<th class="jive-last" width="1%" nowrap="nowrap"> 最新回复 </th>
										</tr>
									</thead>
									<tbody id="wo">
									</tbody> 
								</table>
							</div>
						</div>
          				<div class="jive-legend"></div>
          				</td>
					</tr>
				</tbody>
			</table>
			<br>
			<br>
		</div>
	</body>
</html>
