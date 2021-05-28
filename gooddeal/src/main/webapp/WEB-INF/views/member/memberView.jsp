<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h2>회원 상세 정보</h2>
					<ul>
					    <c:if test="${!empty member.mem_filename}">
						<li>
							<div class="align-center">
									<img src="imageView.do?mem_num=${member.mem_num}" style="max-width:40px">
								</div>
						</li>
						</c:if>		
						<li>이름 : ${member.mem_name}</li>
						<li>전화번호 : ${member.mem_phone}</li>
						<li>이메일 : ${member.mem_email}</li>
						<li>우편번호 : ${member.mem_zipcode}</li>
						<li>주소 : ${member.mem_address1} ${member.mem_address2} ${member.mem_address3}</li>
						<li>가입 날짜 : ${member.mem_date}</li>
					</ul>
			</div>
		</li>
	</ul>
</div>
<!-- 중앙 컨텐츠 끝 -->