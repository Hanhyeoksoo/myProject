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
					<input type="button" value="판매내역" onclick="location.href='mysell.do'">
				</p>		
			</th>
			<th>
				<h2>회원 정보 수정</h2>
				<form:form action="update.do" commandName="memberVO"  enctype="multipart/form-data">
					<ul>
						<li>
							<label for="mem_name">이름</label>
							<form:input path="mem_name"/>
							<form:errors path="mem_name" cssClass="error-color"/>
						</li>
						<li>
							<label for="upload">프로필 사진</label>
							<input type="file" name="upload" id="upload" accept="image/gif,image/png,image/jpeg">
						</li>
						<li>
							<label for="mem_phone">전화번호</label>
							<form:input path="mem_phone"/>
							<form:errors path="mem_phone" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_email">이메일</label>
							<form:input path="mem_email"/>
							<form:errors path="mem_email" cssClass="error-color"/>
						</li><li>
							<label for="mem_zipcode">우편번호</label>
							<form:input path="mem_zipcode"/>
							<form:errors path="mem_zipcode" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_address1">주소</label>
							<form:input path="mem_address1"/>
							<form:errors path="mem_address1" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_address2">상세주소</label>
							<form:input path="mem_address2"/>
							<form:errors path="mem_address2" cssClass="error-color"/>
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