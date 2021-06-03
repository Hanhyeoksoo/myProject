<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>진행중인 이벤트</h2>
	<div class="align-center">
		<a href="detail.do?eve_num=${event.eve_num}"><img src="${pageContext.request.contextPath}/resources/assets/images/버거.jpg" width="310" height="210"></a>
					
					<%-- <img src="imageView.do?eve_num=${event.eve_num}&img_num=1"
					                           style="width:240px"></a> --%>
				</div>
			<a href="#"><img src="${pageContext.request.contextPath}/resources/assets/images/추석맞이이벤트.jpg" width="310" height="210"></a>
			<a href="#"><img src="${pageContext.request.contextPath}/resources/assets/images/본죽.jpg" width="310" height="210"></a>
			<a href="#"><img src="${pageContext.request.contextPath}/resources/assets/images/회원가입.jpg" width="310" height="210"></a>
			<a href="#"><img src="${pageContext.request.contextPath}/resources/assets/images/5월.jpg" width="310" height="210"></a>
			<a href="#"><img src="${pageContext.request.contextPath}/resources/assets/images/스포츠.jpg" width="310" height="210"></a>
	</div>
	


