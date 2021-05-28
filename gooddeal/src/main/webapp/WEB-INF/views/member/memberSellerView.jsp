<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<table border="1">
		<tr>
			<th width="20">
				<p class="align-left">
					<input type="button" value="회원 정보 수정" onclick="location.href='update.do'"><br>
					<input type="button" value="비밀번호 변경" onclick="location.href='changePassword.do'"><br>
					<input type="button" value="회원 탈퇴" onclick="location.href='delete.do'"><br>
					<input type="button" value="판매내역" onclick="location.href='mysell.do'">
				</p>		
			</th>
			<th>
				<h2>판매 내역 보기</h2>
				<c:if test="${count == 0}">
				<div class="align-center">등록된 판매내역이 없습니다.</div>
				</c:if>
				<c:if test="${count > 0}">
				<table>
					<tr>
						<th>사진</th>
						<th width="400">제목</th>
						<th>가격</th>
						<th>판매상태</th>
					</tr>
					<c:forEach var="product" items="${list}">
					<tr>
						<td>
						<c:if test="${!empty product.pro_filename1}">
							<div class="align-center">
								<a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${product.pro_num}">
								<img src="${pageContext.request.contextPath}/product/imageView.do?pro_num=${product.pro_num}&img_num=1"
								                           style="max-width:100px"></a>
							</div>
							</c:if>
						</td>
						<td><a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${product.pro_num}">${product.pro_title}</a>
						<td>${product.pro_price}</td>
						<td>
						<c:if test="${product.pro_buy == 1}">판매중</c:if>
						<c:if test="${product.pro_buy == 2}">판매완료</c:if>
						<c:if test="${product.pro_buy == 3}">판매중지</c:if>
						</td>
					</tr>
					</c:forEach>
				</table>
				<div class="align-center">${pagingHtml}</div>
				</c:if>
			</th>
		</tr>
	</table>
</div>
<!-- 중앙 컨텐츠 끝 -->