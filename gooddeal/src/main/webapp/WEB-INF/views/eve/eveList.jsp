<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<div class="align-right">
	        <form action="list.do" method="get" style="border:none;">
			<input type="text" placeholder="검색 할 이벤트 입력" name="keyword" size="15">
			<input class="button" type="submit" value="검색하기">
			<c:if test="${!empty user_num}">
			<input class="button-2" type="button" value="이벤트 등록" onclick="location.href='write.do'">
		</c:if>
			</form>
	</div>
	<div class="portfolio-area sp">
	    <div class="container">
	        <div class="section-title">
	            <h2>이벤트 목록</h2>
	            <p>등록된 이벤트 입니다.</p>
	        </div>
	        <div class="row">
	           <c:forEach var="eve" items="${list}">
	            <div class="single-portfolio col-md-4">
	                <div class="inner">
	                    <div class="portfolio-img">
	                        <img src="${pageContext.request.contextPath}/eve/imageView.do?eve_num=${eve.eve_num}&img_num=1">
	                        <div class="hover-content">
	                            <div>
	                                <a href="${pageContext.request.contextPath}/eve/detail.do?eve_num=${eve.eve_num}" class="button">이벤트 보기</a>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="portfolio-content">
	                        <a href="detail.do?eve_num=${eve.eve_num}"><h3>${eve.eve_title}</h3></a>
	                        <%-- <a href="detail.do?eve_num=${eve.eve_num}"><span>${eve.eve_price}</span></a> --%>
	                    </div>
	                </div>
	            </div>
	            </c:forEach>
	    	</div>
		</div>
	</div>  

	<c:if test="${count == 0 }">
	<div class="align-center">등록된 이벤트가 없습니다.</div>
	</c:if>
	<c:if test="${count > 0 }">

	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>  
<!-- 중앙 컨텐츠 끝 -->



