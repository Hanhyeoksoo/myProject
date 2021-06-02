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
				location.replace('delete.do?che_num=${cheat.che_num}');
			}
		};
	};
</script>
<div class="page-main-style">
	<h2>${cheat.che_title}</h2>
	<ul>
		<li>번호 : ${cheat.che_num}</li>
		<li>신고자 : ${cheat.mem_id}</li>
		<li>조회수 : ${cheat.che_view}</li>
		<li>작성일 : ${cheat.che_date}</li>
		<li>관리자 확인 여부 : 
		<c:if test="${cheat.che_admincheck == 1}"><span style="color:red;"><b>미확인</b></span></c:if>
		<c:if test="${cheat.che_admincheck == 2}">확인</c:if>
		</li>
	</ul>
	<hr size="1" width="100%">
	<p>부정행위자 : ${cheat.che_pid}</p>
	<p>
		${cheat.che_content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty user_num && user_now == 3 && cheat.che_admincheck == 1}">
		<form action="adminCheck.do" method="post" style="border:none;float:left;width:670px;margin-top:-10px">
		<input type="hidden" name="che_num" value="${cheat.che_num}">
		<input type="hidden" name="che_pnum" value="${cheat.che_pnum}">
		<input type="submit" value="관리자 확인">
		</form>
		</c:if>
		<c:if test="${!empty user_num && user_num == cheat.mem_num}">
		<input type="button" value="수정"
		 onclick="location.href='update.do?che_num=${cheat.che_num}'">
		<input type="button" value="삭제" id="delete_btn">
		</c:if>
		<input type="button" value="목록으로"
		                        onclick="location.href='list.do'">
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->