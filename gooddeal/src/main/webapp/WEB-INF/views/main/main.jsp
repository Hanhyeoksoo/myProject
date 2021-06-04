<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 중고상품 시작 -->
<div class="portfolio-area sp">
    <div class="container">
        <div class="section-title">
            <h2>최근 등록 상품</h2>
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
<!-- 중고상품 끝 -->    
<!-- 자유게시판 시작 -->
<div class="testimonial-area sp bg1">
    <div class="container">
        <div class="section-title white">
            <h2>자유게시판</h2>
            <p>동네 맛집, 볼거리 등 자유롭게 정보를 공유하세요.</p>
        </div>
        <div class="testimonial-slider">
             <c:forEach var="board" items="${board_list}">
            <div class="single-slide">
                <div class="inner">
                    <div class="client-info">
                        <div class="client-img">
                            <a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}"><img src="${pageContext.request.contextPath}/board/imageView.do?board_num=${board.board_num}"></a>
                        </div>
                        <div class="client-data">
                            <h4><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}">${board.title}</a></h4>
                            <a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}"><span>${board.id}</span></a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>  
</div>
<!-- 자유게시판 시작 -->