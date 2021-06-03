<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<ul>
		<li>
			<input type="button" value="정보 수정" onclick="location.href='update.do'">
			<input type="button" value="비밀번호 변경" onclick="location.href='changePassword.do'">
			<input type="button" value="회원 탈퇴" onclick="location.href='delete.do'">
			<input type="button" value="판매내역" onclick="location.href='mysell.do'">	
			<hr width="100%" size="1" noshade="noshade">
		</li>
		<li>
			<div>
				<h2>회원 탈퇴</h2>
				<form:form action="delete.do" commandName="memberVO">
					<form:errors elememt="div" cssClass="error-color"/>
					<ul>
						<li>
							<label for="mem_id">아이디</label>
							<form:input path="mem_id"/>
							<form:errors path="mem_id" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_password">비밀번호</label>
							<form:password path="mem_password"/>
							<form:errors path="mem_password" cssClass="error-color"/>
						</li>
					</ul>
					<div class="align-center">
						<form:button>탈퇴</form:button>
						<input type="button" value="MyPage" onclick="location.href='myPage.do'">
					</div>
				</form:form>
			</div>
		</li>
	</ul>
</div>
<!-- 중앙 컨텐츠 끝 -->