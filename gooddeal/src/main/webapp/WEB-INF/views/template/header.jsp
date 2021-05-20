<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 상단 시작 -->
<h2 class="align-center">Good Deal</h2>
<div class="align-right">
	<c:if test="${!empty user_num}">
		[<span class="user_name">${user_id}</span>]
		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
		<a href="${pageContext.request.contextPath}/member/myPage.do">MY페이지</a>
	</c:if>
	<c:if test="${empty user_num}">
		<a href="${pageContext.request.contextPath}/member/registerUser.do">회원가입</a>
		<a href="${pageContext.request.contextPath}/member/login.do">로그인</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/main/main.do">홈으로</a>
</div>
<!-- 상단 끝 -->




