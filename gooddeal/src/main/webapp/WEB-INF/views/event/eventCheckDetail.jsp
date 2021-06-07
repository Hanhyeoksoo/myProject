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
				location.replace('delete.do?eve_num=${event.eve_num}');
			}
		};
	};
</script>
<div class="page-main-style">
	<h2>${event.eve_title}</h2>
	<ul>
		<li>번호 : ${event.eve_num}</li>
		<li>조회수 : ${event.hit}</li>
		<li>작성일 : ${event.eve_date}</li>
	</ul>
	<p>
		${event.eve_content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty eve_user && eve_user == event.mem_num}">
		<input type="button" value="수정"
		 onclick="location.href='update.do?eve_num=${event.eve_num}'">
		<input type="button" value="삭제" id="delete_btn">
		</c:if>
		<input type="button" value="목록으로"
		                        onclick="location.href='list.do'">
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->