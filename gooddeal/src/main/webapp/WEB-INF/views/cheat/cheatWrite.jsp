<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>글쓰기</h2>
	<form:form action="write.do" commandName="cheatVO">
		<input type="hidden" name="che_pnum" value="41">
		<ul>
			<li>
				<label for="che_title">제목</label>
				<form:input path="che_title"/>
				<form:errors path="che_title" cssClass="error-color"/>
			</li>
			<li>
				<label for="che_content">내용</label>
				<form:textarea path="che_content"/>
				<form:errors path="che_content" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록"
			               onclick="location.href='list.do'">
		</div>
	</form:form>
</div>
<!-- 중앙 컨텐츠 끝 -->