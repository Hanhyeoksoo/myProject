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
	<c:if test="${count == 0 }">
	<div class="align-center">등록된 상품이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0 }">
	<table>
		<tr>
			<th>작성자번호</th>
			<th width="400">제목</th>
			<!-- 상품 사진 만들 자리-->
			<th>등록일</th>
		</tr>
		<c:forEach var="product" items="${list}">
		<tr>
			<td>${product.mem_num}</td>
			<td><a href="detail.do?pro_num=${product.pro_num}">${product.pro_title}</a></td>
			<!-- 상품 사진 만들 자리-->
			<td>${product.pro_date}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="algign-center">${pagingHtml}</div>
	</c:if>
</div>  
<!-- 중앙 컨텐츠 끝 -->



