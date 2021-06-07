<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>이벤트 당첨자 페이지</h2>
	<div class="align-center">
		<select name="school">
			<option value="제목">제목</option>
			<option value="내용">내용</option>
		</select>  
		<input type="text" name="text" title="검색어 입력" maxlength="255"
		autocomplete="off" placeholder="검색어를 입력해 주세요.">
		<input type="button" name="검색" title="검색" maxlength="255"
		autocomplete="off" value="검색" onclick="">
	</div>
	<div class="align-center">등록된 게시물이 없습니다.</div>
	<c:if test="${count > 0}">
	<table>
		<tr>
			<th>번호</th>
			<th width="400">제목</th>
			<th>작성자</th>
			<th>최근수정일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="event" items="${list}">
		<tr>
			<td>${event.eve_num}</td>
			<td><a href="detail.do?eve_num=${event.eve_num}">${event.eve_title}</a></td>
			<td>${event.eve_date}</td>
			<td>${event.hit}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
		<div class="align-center">
			<input type="submit" value="등록" onclick="location.href='write.do'">
		</div>
	</div>
<!-- 중앙 컨텐츠 끝 -->



