<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>글 수정</h2>
	<form:form action="update.do" commandName="boardVO" 
	                                enctype="multipart/form-data">
		<form:hidden path="board_num"/>
		<ul>
			<li>
				<label for="title">제목</label>
				<form:input path="title"/>
				<form:errors path="title" cssClass="error-color"/>
			</li>
			<li>
				<label for="content">내용</label>
				<form:textarea path="content"/>
				<form:errors path="content" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">파일 업로드</label>
				<input type="file" name="upload" id="upload">
				<c:if test="${!empty boardVO.filename}">
				<br>
				<span>(${boardVO.filename})파일이 등록되어 있습니다.
				다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
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




