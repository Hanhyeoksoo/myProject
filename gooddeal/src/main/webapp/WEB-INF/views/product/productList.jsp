<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>상품 목록</h2>
	<div class="align-right">
		<c:if test="${!empty user_num}">
		<input type="button" value="상품 등록" onclick="location.href='write.do'">
		</c:if>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th width="400">상품제목</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="product" items="${list}">
		<tr>
			<td>${product.pro_num}</td>
			<td><a href="detail.do?pro_num=${product.pro_num}">${product.pro_title}</a></td>
			<td>${product.pro_date}</td>
		</tr>
		</c:forEach>
	</table>
</div>  
<!-- 중앙 컨텐츠 끝 -->



