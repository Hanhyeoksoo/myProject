<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main-style">
	<h2>상품 수정</h2>
	<form:form action="update.do" commandName="eveVO" 
	                                enctype="multipart/form-data">
		<form:hidden path="eve_num"/>
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
				<label for="eve_buy">진행 상태</label>
				<form:radiobutton path="eve_buy" value="1" />진행중
				<form:radiobutton path="eve_buy" value="2" />진행완료
				<form:errors path="eve_buy" cssClass="error-color"/>
			</li>
			<li>	
				<label for="upload1">이미지1</label>
				<input type="file" name="upload1" id="upload1" />
				<c:if test="${!empty eveVO.eve_filename1}">
				<br>
				<span>(${eveVO.eve_filename1})파일이 등록되어 있습니다.
				다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
			</li>
			<li>	
				<label for="upload2">이미지2</label>
				<input type="file" name="upload2" id="upload2" />
				<c:if test="${!empty eveVO.eve_filename2}">
				<br>
				<span>(${eveVO.eve_filename2})파일이 등록되어 있습니다.
				다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
			</li>
			<li>	
				<label for="upload3">이미지3</label>
				<input type="file" name="upload3" id="upload3" />
				<c:if test="${!empty eveVO.eve_filename3}">
				<br>
				<span>(${eveVO.eve_filename3})파일이 등록되어 있습니다.
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
