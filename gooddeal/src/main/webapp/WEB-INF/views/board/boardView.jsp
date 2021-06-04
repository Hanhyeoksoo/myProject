<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!-- 중앙 컨텐츠 시작 -->
<script type="text/javascript">
	window.onload=function(){
		var delete_btn = document.getElementById('delete_btn');
		//이벤트 연결
		delete_btn.onclick=function(){
			var choice = window.confirm('삭제하시겠습니까?');
			if(choice){
				location.replace('delete.do?board_num=${board.board_num}');
			}
		};
	};
</script>
<div class="page-main-style">
	<h2>${board.title}</h2>
	<ul>
		<li>번호 : ${board.board_num}</li>
		<li>작성자 : ${board.id}</li>
		<li>조회수 : ${board.hit}</li>
		<li>작성일 : ${board.reg_date}</li>
		<li>최근수정일 : ${board.modify_date}</li>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(board.filename,'.jpg') || 
	              fn:endsWith(board.filename,'.JPG') ||
	              fn:endsWith(board.filename,'.gif') ||
	              fn:endsWith(board.filename,'.GIF') ||
	              fn:endsWith(board.filename,'.png') ||
	              fn:endsWith(board.filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?board_num=${board.board_num}"
		                           style="max-width:500px">
	</div>
	</c:if>
	<p>
		${board.content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty user_num && user_num == board.mem_num}">
		<input type="button" value="수정"
		 onclick="location.href='update.do?board_num=${board.board_num}'">
		<input type="button" value="삭제" id="delete_btn">
		</c:if>
		<input type="button" value="목록으로"
		                        onclick="location.href='list.do'">
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->