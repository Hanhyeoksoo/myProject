<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//submit 이벤트 발생시 비밀번호 일치 여부 확인
		$('#changepassword').submit(function(){
			if($('#mem_password').val().trim() != $('#mem_password2').val().trim()){
				$('#message_password').css('color','red').text('비밀번호가 일치하지 않습니다!');
				$('#mem_password2').val('');
				$('#mem_password').val('').focus();
				return false;
			}
		});
	});
</script>
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
				<h2>비밀번호 변경</h2>
				<form:form action="changePassword.do" commandName="memberVO" id="changepassword">
					<ul>
						<li>
							<label for="now_password">현재 비밀번호</label>
							<form:password path="now_password"/>
							<form:errors path="now_password" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_password">변경할 비밀번호</label>
							<form:password path="mem_password"/>
							<span id="message_password"></span>
							<form:errors path="mem_password" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_password2">비밀번호 확인</label>
							<form:password path="mem_password2"/>
						</li>
					</ul>
					<div class="align-center">
						<form:button class="button">변경</form:button>
						<input class="button" type="button" value="MyPage" onclick="location.href='myPage.do'">
					</div>
				</form:form>
			</div>
		</li>
	</ul>
</div>
<!-- 중앙 컨텐츠 끝 -->