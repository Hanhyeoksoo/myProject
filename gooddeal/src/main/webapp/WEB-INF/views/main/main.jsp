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

<div class="testimonial-area sp bg1">
    <div class="container">
        <div class="section-title white">
            <h2>자유게시판 꼭 와주세요</h2>
            <p>Malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
        </div>
        <div class="testimonial-slider">
            <div class="single-slide">
                <div class="inner">
                    <p>When I was just starting 6th grade I got my first job. Paperboy! Boy, was I excited. At that time I had spent a lot of time actually playing the video official.</p>
                    <div class="client-info">
                        <div class="client-img">
                            <img src="${pageContext.request.contextPath}/resources/assets/img/client.jpg" alt="client">
                        </div>
                        <div class="client-data">
                            <h4>Jhon Doe</h4>
                            <span>Designer</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single-slide">
                <div class="inner">
                    <p>When I was just starting 6th grade I got my first job. Paperboy! Boy, was I excited. At that time I had spent a lot of time actually playing the video official.</p>
                    <div class="client-info">
                        <div class="client-img">
                            <img src="${pageContext.request.contextPath}/resources/assets/img/client.jpg" alt="client">
                        </div>
                        <div class="client-data">
                            <h4>Jhon Doe</h4>
                            <span>Designer</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single-slide">
                <div class="inner">
                    <p>When I was just starting 6th grade I got my first job. Paperboy! Boy, was I excited. At that time I had spent a lot of time actually playing the video official.</p>
                    <div class="client-info">
                        <div class="client-img">
                            <img src="${pageContext.request.contextPath}/resources/assets/img/client.jpg" alt="client">
                        </div>
                        <div class="client-data">
                            <h4>Jhon Doe</h4>
                            <span>Designer</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single-slide">
                <div class="inner">
                    <p>When I was just starting 6th grade I got my first job. Paperboy! Boy, was I excited. At that time I had spent a lot of time actually playing the video official.</p>
                    <div class="client-info">
                        <div class="client-img">
                            <img src="${pageContext.request.contextPath}/resources/assets/img/client.jpg" alt="client">
                        </div>
                        <div class="client-data">
                            <h4>Jhon Doe</h4>
                            <span>Designer</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>
