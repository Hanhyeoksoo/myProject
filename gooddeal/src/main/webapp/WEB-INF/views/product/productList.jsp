<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<script>
//	window.onload=function(){
//		var search_btn = document.getElementById('search_btn');
//		//이벤트 연결
//		search_btn.onclick=function(){
//				$.ajax({
//					
//				})
//			}
//		};
//	};
</script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>상품 목록</h2>
	<div class="align-right">
			<input type="text" value="검색 할 상품입력" size="15">
			<input id="search_btn" type="button" value="검색하기">
		<c:if test="${!empty user_num}">
			<input type="button" value="상품 등록" onclick="location.href='write.do'">
		</c:if>
	</div>
	<c:if test="${count == 0 }">
	<div class="align-center">등록된 상품이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0 }">
	<div id="wrap">
		<c:forEach var="product" items="${list}">
		<div class="list">
			<p>
				<c:if test="${!empty product.pro_filename1}">
				<div class="align-center">
					<a href="detail.do?pro_num=${product.pro_num}">
					<img src="imageView.do?pro_num=${product.pro_num}&img_num=1"
					                           style="max-width:300px"></a>
				</div>
				</c:if>
			</p>
			<p class="align-center">
				<a href="detail.do?pro_num=${product.pro_num}"><span>${product.pro_title}</span></a><br>
				<a href="detail.do?pro_num=${product.pro_num}"><span>${product.pro_price}</span></a>
			</p>
			
		</div>
		</c:forEach>
	</div>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>  
<!-- 중앙 컨텐츠 끝 -->



