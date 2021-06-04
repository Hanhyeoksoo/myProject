<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">  
<!-- <style> .carousel-inner > .carousel-item > img{ /* width: 640px; height: 720px; */ } </style>  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/product.reply.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#cheat_btn').click(function(){
			$('#cheat_form').submit();
		});
	});
</script>
<div class="page-main-style">
<!-- 중앙 컨텐츠 시작 -->
	<h2>${product.pro_title}</h2>
	<hr size="1" width="100%">
    <div style="width:600px;margin:20px auto;">
	<div id="demo" class="carousel slide" data-ride="carousel">
 	<div class="carousel-inner">
 <!-- 슬라이드 쇼 --> 
        <c:if test="${!empty product.pro_filename1}">
		<div class="carousel-item active">
<!--가로-->
	 		
			<img class="d-block w-100" src="imageView.do?pro_num=${product.pro_num}&img_num=1" alt="First slide">
		 <div class="carousel-caption d-none d-md-block"> 
	  	 </div> 
	 	 </div> 
	 	 </c:if>
	 	 <c:if test="${!empty product.pro_filename2}">
 		<div class="carousel-item">
			<img class="d-block w-100" src="imageView.do?pro_num=${product.pro_num}&img_num=2" alt="Second slide">
		</div> 
		</c:if>
		<c:if test="${!empty product.pro_filename3}">
		<div class="carousel-item"> 
			<img class="d-block w-100" src="imageView.do?pro_num=${product.pro_num}&img_num=3" alt="Third slide">
		</div>
		</c:if>
<!-- / 슬라이드 쇼 끝 -->
<!-- 왼쪽 오른쪽 화살표 버튼 -->
	<a class="carousel-control-prev" href="#demo" data-slide="prev"> 
	<span class="carousel-control-prev-icon" aria-hidden="true"></span></a>
	<a class="carousel-control-next" href="#demo" data-slide="next"> 
	<span class="carousel-control-next-icon" aria-hidden="true"></span> </a>
<!-- / 화살표 버튼 끝 -->
<!-- 인디케이터 -->
	<ul class="carousel-indicators"> 
		<li data-target="#demo" data-slide-to="0" class="active"></li> <!--0번부터시작--> 
		<li data-target="#demo" data-slide-to="1"></li> 
		<li data-target="#demo" data-slide-to="2"></li> 
	</ul> 
<!-- 인디케이터 끝 --> 
	</div>
	</div>
	</div>
	<hr size="1" width="100%">
	<ul>
		<li><b>판매자</b> : ${product.mem_id} 
		<c:if test="${product.mem_num != user_num}">
		<input type="button" value="신고" id="cheat_btn">
		</c:if>
		</li>
		<li><b>연관 태그</b> : ${product.pro_tag}</li>
		<li><b>상품 금액</b> : ${product.pro_price}</li>
		<li><b>상품 상태</b> : 
		<c:if test="${product.pro_status == 1}">새상품</c:if>
		<c:if test="${product.pro_status == 2}">중고</c:if>
		</li>
		<li><b>판매 상태</b> : 
		<c:if test="${product.pro_buy == 1}">판매중</c:if>
		<c:if test="${product.pro_buy == 2}">판매완료</c:if>
		<c:if test="${product.pro_buy == 3}">판매중지</c:if>
		</li>
		<li><b>작성일</b> : ${product.pro_date}</li>
	</ul>
	<form action="${pageContext.request.contextPath}/cheat/write.do" id="cheat_form" method="post" style="border:none;">
		<input type="hidden" name="che_pnum" value="${product.mem_num}">
		<input type="hidden" name="mem_id" value="${product.mem_id}">
	</form>
	<hr size="1" width="100%">
	<div>
		<h2>상품 내용</h2>
		<p>${product.pro_content}</p>
	</div>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty user_num && user_num == product.mem_num}">
		<input class="button" type="button" value="수정"
		 onclick="location.href='update.do?pro_num=${product.pro_num}'">
		<input class="button" type="button" value="삭제" id="delete_btn">
		<script type="text/javascript">
			var delete_btn = document.getElementById('delete_btn');
			//이벤트 연결
			delete_btn.onclick=function(){
				var choice = window.confirm('삭제하시겠습니까?');
				if(choice){
					location.replace('delete.do?pro_num=${product.pro_num}');
				}
			};
	</script>
		</c:if>
		<input class="button" type="button" value="목록으로"
		                        onclick="location.href='list.do'">
	</div>
	<hr size="1" width="100%">
	<div id="reply_div">
		<span class="reply-title">댓글 달기</span>
		<form id="re_form">
			<input type="hidden" name="pro_num"
			       value="${product.pro_num}" id="pro_num">
			<input type="hidden" name="mem_num"
			       value="${user_num}" id="mem_num">
			<textarea rows="3" cols="50"
			  name="rep_content" id="rep_content"
			  class="rep-content"
			  <c:if test="${empty user_num}">disabled="disabled"</c:if>
			  ><c:if test="${empty user_num}">로그인해야 작성할 수 있습니다.</c:if></textarea>              
			<c:if test="${!empty user_num}">
			<div id="re_first">
				<span class="letter-count">300/300</span>
			</div>
			<div id="re_second" class="align-right">
				<input type="submit" value="전송">
			</div>
			</c:if>
		</form>
	</div>
	<!-- 댓글 목록 출력 -->
	<div id="output"></div>
	<div class="paging-button" style="display:none;">
		<input type="button" value="다음글 보기">
	</div>
	<div id="loading" style="display:none;">
		<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->