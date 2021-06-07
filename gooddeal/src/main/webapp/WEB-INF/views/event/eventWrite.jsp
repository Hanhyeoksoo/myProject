<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>상품 등록</h2>
	<form:form action="write.do" commandName="eventVO"
									enctype="multipart/form-data">
		<ul>
			<li>
				<label for="pro_title">상품 제목</label>
				<form:input path="pro_title"/>
				<form:errors path="pro_title" cssClass="error-color"/>
			</li>
			<li>
				<label for="pro_tag">연관 태그</label>
				<form:input path="pro_tag"/>
				<form:errors path="pro_tag" cssClass="error-color"/>
			</li>
			<li>
				<label for="pro_price">상품 금액</label>
				<form:input path="pro_price"/>
				<form:errors path="pro_price" cssClass="error-color"/>
			</li>
			<li>
				<label for="pro_content">상품 내용</label>
				<form:textarea path="pro_content" cols="50" rows="5"/>
				<form:errors path="pro_content" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="상품 등록">
			<input type="button" value="목록"
			               onclick="location.href='list.do'">
		</div>
	</form:form>
</div>
<!-- 중앙 컨텐츠 끝 -->