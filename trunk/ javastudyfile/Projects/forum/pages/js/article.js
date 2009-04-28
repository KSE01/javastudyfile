$(document).ready(function(){
	
	$.getJSON('article.action?currentPage=1&shownum=3&random='+(new Date()).getTime(),function(data){
	//$.ajax({url:'article.action?currentPage=1&shownum=3',dataType:'json',ifModified:true, success:function(data){
		for(var i=0;i<data.articleList.length;i++){
			$('#wo').append('<tr id=tr'+i+'></tr>').addClass('jive-even');
			$('#tr'+i).append('<td id=td0'+i+'></td>').append('<td id=td1'+i+'></td>').append('<td id=td2'+i+'></td>')
			.append('<td id=td3'+i+'></td>').append('<td id=td4'+i+'></td>').append('<td id=td5'+i+'></td>').append('<td id=td6'+i+'></td>');
			$('#td0'+i).addClass('jive-first')
			.append('<div class="jive-bullet"><img src="pages/images/read-16x16.gif" alt="已读" border="0" height="16" width="16"></div>')
			.attr('width','1%').attr('nowrap','nowrap');
			$('#td1'+i).append('<span>del</span>');
			$('#td2'+i).addClass('jive-thread-name').attr('width','95%')
			.append('<a href="subjectDetail.action?id='+data.articleList[i].articleid+'">'+data.articleList[i].subject+'</a>')
			$('#td3'+i).addClass('jive-author').attr('width','1%').attr('nowrap','nowrap').append('<span>'+data.articleList[i].authorid+'</span>');
			$('#td4'+i).addClass('jive-view-count').attr('width','1%').append(data.articleList[i].readnum);
			$('#td5'+i).addClass('jive-msg-count').attr('width','1%').append(data.articleList[i].replynum);
			$('#td6'+i).addClass('jive-author').attr('width','1%').append('by:'+data.articleList[i].newreply);
		}
		$('#nowpage').before('页: 第');
		$('#nowpage').text($('#pagecount').val());
		$('#totalpage').before('页,共页');
		for(var j=0;j<=data.pageCount;j++){
			if(j==0){
				$('#pageselected').append('<option  value='+j+'>前选择页数</option>');
			}else{
				$('#pageselected').append('<option value='+j+'>'+j+'</option>');
			}
		}
		$('#totalpage').text(data.pageCount);
		$('#first').bind('click',{first:$('#pagecount').val()},show)
		$('#pre').bind('click',{pre:$('#pagecount').val()},show)
		$('#next').bind('click',{next:$('#pagecount').val()},show)
		$('#last').bind('click',{last:$('#pagecount').val()},show)
		$('#selected').bind('change',{page:'page'},show)
		$('#pageselected').bind('change',{selectpage:'selectpage'},show)
	});
});
function show(event){
	var currentPage=1;
	var shownum=$('#selected').val();
	if(event.data.page!=null){
		$('#pagecount').val('1');
	}
	if(event.data.selectpage!=null){
		currentPage=$('#pageselected').val();
		$('#pagecount').val(currentPage);
	}
	if(event.data.last!=null){
		currentPage=$('#totalpage').text();
		$('#pagecount').val(currentPage)
	}
	if(event.data.first!=null){
		$('#pagecount').val('1');
	}
	if(event.data.pre!=null){
		if($('#nowpage').text()>1){
			currentPage=$('#pagecount').val()-1
			$('#pagecount').val(currentPage)
		}else{
			currentPage=$('#pagecount').val()
		}
	}
	if(event.data.next!=null){
		if(parseInt($('#nowpage').text())<parseInt($('#totalpage').text())){
			currentPage=parseInt($('#pagecount').val())+1
			$('#pagecount').val(currentPage)
		}else{
			currentPage=$('#pagecount').val()
		}
	}
	$.ajax({url:'article.action?currentPage='+currentPage+'&shownum='+shownum,dataType:'json',ifModified:true, success:function(data){
		$('#wo').empty();
		$('#nowpage').text($('#pagecount').val());
		$('#totalpage').text(data.pageCount);
		if(event.data.page!=null){
			$('#pageselected').empty();
			for(var j=0;j<=data.pageCount;j++){
				if(j==0){
					$('#pageselected').append('<option value='+j+'>前选择页数</option>');
				}else{
					$('#pageselected').append('<option value='+j+'>'+j+'</option>');
				}
			}
		}
		for(var i=0;i<data.articleList.length;i++){
			$('#wo').append('<tr id=tr'+i+'></tr>').addClass('jive-even');
			$('#tr'+i).append('<td id=td0'+i+'></td>').append('<td id=td1'+i+'></td>').append('<td id=td2'+i+'></td>')
			.append('<td id=td3'+i+'></td>').append('<td id=td4'+i+'></td>').append('<td id=td5'+i+'></td>').append('<td id=td6'+i+'></td>');
			$('#td0'+i).addClass('jive-first')
			.append('<div class="jive-bullet"><img src="pages/images/read-16x16.gif" alt="已读" border="0" height="16" width="16"></div>')
			.attr('width','1%').attr('nowrap','nowrap');
			$('#td1'+i).append('<span>del</span>');
			$('#td2'+i).addClass('jive-thread-name').attr('width','95%')
			.append('<a href="subjectDetail.action?id='+data.articleList[i].articleid+'">'+data.articleList[i].subject+'</a>')
			$('#td3'+i).addClass('jive-author').attr('width','1%').attr('nowrap','nowrap').append('<span>'+data.articleList[i].authorid+'</span>');
			$('#td4'+i).addClass('jive-view-count').attr('width','1%').append(data.articleList[i].readnum);
			$('#td5'+i).addClass('jive-msg-count').attr('width','1%').append(data.articleList[i].replynum);
			$('#td6'+i).addClass('jive-author').attr('width','1%').append('by:'+data.articleList[i].newreply);
		}
	  }
	});
}