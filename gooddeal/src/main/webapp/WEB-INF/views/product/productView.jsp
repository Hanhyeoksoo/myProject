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
				location.replace('delete.do?pro_num=${product.pro_num}');
			}
		};
	};
</script>
<div class="page-main-style">
	<h2>${product.pro_title}</h2>
	<ul>
		<li>판매자 : ${product.mem_id}</li>
		<li>연관 태그 : ${product.pro_tag}</li>
		<li>상품 금액 : ${product.pro_price}</li>
		<!-- 사진 넣을 자리 -->
		<li>내용 : ${product.pro_content}</li>
		<li>상품 상태 : 
		<c:if test="${product.pro_status == 1}">새상품</c:if>
		<c:if test="${product.pro_status == 2}">중고</c:if>
		</li>
		<li>판매 상태 : 
		<c:if test="${product.pro_buy == 1}">판매중</c:if>
		<c:if test="${product.pro_buy == 2}">판매완료</c:if>
		<c:if test="${product.pro_buy == 3}">판매중지</c:if>
		</li>
		<li>작성일 : ${product.pro_date}</li>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${!empty product.pro_filename1}">
	<div class="align-center">
		<img src="imageView.do?pro_num=${product.pro_num}&img_num=1"
		                           style="max-width:500px">
	</div>
	</c:if>
	<c:if test="${!empty product.pro_filename2}">
	<div class="align-center">
		<img src="imageView.do?pro_num=${product.pro_num}&img_num=2"
		                           style="max-width:500px">
	</div>
	</c:if>
	<c:if test="${!empty product.pro_filename3}">
	<div class="align-center">
		<img src="imageView.do?pro_num=${product.pro_num}&img_num=3"
		                           style="max-width:500px">
	</div>
	</c:if>
	<p>
		${product.pro_content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty user_num && user_num == product.mem_num}">
		<input type="button" value="수정"
		 onclick="location.href='update.do?pro_num=${product.pro_num}'">
		<input type="button" value="삭제" id="delete_btn">
		</c:if>
		<input type="button" value="목록으로"
		                        onclick="location.href='list.do'">
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->