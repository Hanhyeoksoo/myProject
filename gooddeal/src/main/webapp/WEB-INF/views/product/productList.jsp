<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<div class="align-right">
	        <form action="list.do" method="get" style="border:none;">
			<input type="text" placeholder="검색 할 상품입력" name="keyword" size="15">
			<input class="button" type="submit" value="검색하기">
			<c:if test="${!empty user_num}">
			<input class="button-2" type="button" value="상품 등록" onclick="location.href='write.do'">
		</c:if>
			</form>
	</div>
	<div class="portfolio-area sp">
	    <div class="container">
	        <div class="section-title">
	            <h2>상품 목록</h2>
	            <p>최근에 등록된 상품들 입니다. 다양한 상품을 거래해 보세요</p>
	        </div>
	        <div class="row">
	           <c:forEach var="product" items="${list}">
	            <div class="single-portfolio col-md-4">
	                <div class="inner">
	                    <div class="portfolio-img">
	                        <img src="${pageContext.request.contextPath}/product/imageView.do?pro_num=${product.pro_num}&img_num=1">
	                        <div class="hover-content">
	                            <div>
	                                <a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${product.pro_num}" class="button">상품 보기</a>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="portfolio-content">
	                        <a href="detail.do?pro_num=${product.pro_num}"><h3>${product.pro_title}</h3></a>
	                        <a href="detail.do?pro_num=${product.pro_num}"><span>${product.pro_price}</span></a>
	                    </div>
	                </div>
	            </div>
	            </c:forEach>
	    	</div>
		</div>
	</div>  

	<c:if test="${count == 0 }">
	<div class="align-center">등록된 상품이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0 }">

	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>  
<!-- 중앙 컨텐츠 끝 -->



