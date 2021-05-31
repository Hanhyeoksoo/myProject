<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>게시판 목록</h2>
	<div class="align-right">
		<c:if test="${!empty user_num}">
		<input type="button" value="글쓰기" onclick="location.href='write.do'">
		</c:if>
	</div>
	<c:if test="${count == 0}">
	<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table>
		<tr>
			<th>번호</th>
			<th width="400">제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="cheat" items="${list}">
		<tr>
			<td>${cheat.che_num}</td>
			<td><a href="detail.do?che_num=${cheat.che_num}">${cheat.che_title}</a></td>
			<td>${cheat.mem_id}</td>
			<td>${cheat.che_date}</td>
			<td>${cheat.che_view}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
<!-- 중앙 컨텐츠 끝 -->



