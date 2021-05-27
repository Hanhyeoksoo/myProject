<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중안 컨테츠 시작 -->
<div class="page-main-style">
	<table border="1">
		<tr>
			<th width="20">
				<p class="align-left">
					<input type="button" value="회원 정보 수정" onclick="location.href='update.do'"><br>
					<input type="button" value="비밀번호 변경" onclick="location.href='changePassword.do'"><br>
					<input type="button" value="회원 탈퇴" onclick="location.href='delete.do'"><br>
					<input type="button" value="구매내역" onclick="location.href='mysell.do'"><br>
					<input type="button" value="판매내역" onclick="location.href='mybuy.do'">
				</p>		
			</th>
			<th>
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
						<form:button>전송</form:button>
						<input type="button" value="MyPage" onclick="location.href='myPage.do'">
					</div>
				</form:form>
			</th>
		</tr>
	</table>
</div>
<!-- 중안 컨테츠 끝 -->