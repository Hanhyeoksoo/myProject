<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>

</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/product.reply.js"></script>
<!-- 중앙 컨텐츠 시작 -->
	<h2>${product.pro_title}</h2>
	<div id="wrap">
		<hr size="1" width="100%">
		<h3>상품 이미지</h3>
		
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
	</div>
	<hr size="1" width="100%">
	<ul>
		<li>판매자 : ${product.mem_id}</li>
		<li>연관 태그 : ${product.pro_tag}</li>
		<li>상품 금액 : ${product.pro_price}</li>
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
	<div>
		<h2>상품 내용</h2>
		<p>${product.pro_content}</p>
	</div>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty user_num && user_num == product.mem_num}">
		<input type="button" value="수정"
		 onclick="location.href='update.do?pro_num=${product.pro_num}'">
		<input type="button" value="삭제" id="delete_btn">
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
		<input type="button" value="목록으로"
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
<!-- 중앙 컨텐츠 끝 -->