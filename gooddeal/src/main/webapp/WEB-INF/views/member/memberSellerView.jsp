<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<ul>
		<li>
			<input class="button" type="button" value="정보 수정" onclick="location.href='update.do'">
			<input class="button" type="button" value="비밀번호 변경" onclick="location.href='changePassword.do'">
			<input class="button" type="button" value="회원 탈퇴" onclick="location.href='delete.do'">
			<input class="button" type="button" value="판매내역" onclick="location.href='mysell.do'">	
			<hr width="100%" size="1" noshade="noshade">
		</li>
		<li>
			<div>
				<h2>판매 내역</h2>
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
								<a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${product.pro_num}">
								<img src="${pageContext.request.contextPath}/product/imageView.do?pro_num=${product.pro_num}&img_num=1"
								                           style="max-width:100px"></a>
							</div>
							</c:if>
						</p>
						<p class="align-center">
							<a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${product.pro_num}">${product.pro_title}</a>
						</p>
						<P class="align-center">
							<c:if test="${product.pro_buy == 1}">판매중</c:if>
							<c:if test="${product.pro_buy == 2}">판매완료</c:if>
							<c:if test="${product.pro_buy == 3}">판매중지</c:if>
						</P>
					</div>
					</c:forEach>
				</div>
				<div class="align-center">${pagingHtml}</div>
				</c:if>
			</div>
		</li>
	</ul>
</div>
<!-- 중앙 컨텐츠 끝 -->