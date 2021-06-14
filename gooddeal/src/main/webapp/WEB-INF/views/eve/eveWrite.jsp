<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>상품 등록</h2>
	<form:form action="write.do" commandName="eveVO"
	               enctype="multipart/form-data">
		<ul>
			<li>
				<label for="eve_title">이벤트 제목</label>
				<form:input path="eve_title"/>
				<form:errors path="eve_title" cssClass="error-color"/>
			</li>
			<li>
				<label for="eve_tag">이벤트 기간</label>
				<form:input path="eve_tag"/>
				<form:errors path="eve_tag" cssClass="error-color"/>
			</li>
			<li>
				<label for="eve_content">이벤트 내용</label>
				<form:textarea path="eve_content" cols="50" rows="5"/>
				<form:errors path="eve_content" cssClass="error-color"/>
			</li>
			<li>	
				<label for="eve_status">이벤트 상태</label>
				<form:radiobutton path="eve_status" value="1" />진행중
				<form:radiobutton path="eve_status" value="2" />종료
				<form:errors path="eve_status" cssClass="error-color"/>
			</li>
			<li>	
				<label for="upload1">이미지1</label>
				<input type="file" name="upload1" id="upload1" />
			</li>
			<li>	
				<label for="upload2">이미지2</label>
				<input type="file" name="upload2" id="upload2" />
			</li>
			<li>	
				<label for="upload3">이미지3</label>
				<input type="file" name="upload3" id="upload3" />
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