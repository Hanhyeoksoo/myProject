<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("mem_address3").value = extraAddr;
                
                } else {
                    document.getElementById("mem_address3").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('mem_zipcode').value = data.zonecode;
                document.getElementById("mem_address1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("mem_address2").focus();
            }
        }).open();
    }
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
							<form:input path="mem_zipcode"/><br>
							<input class="button" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<form:errors path="mem_zipcode" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_address1">주소</label>
							<form:input path="mem_address1"/>
							<form:errors path="mem_address1" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_address2">상세주소1</label>
							<form:input path="mem_address2"/>
							<form:errors path="mem_address2" cssClass="error-color"/>
						</li>
						<li>
							<label for="mem_address3">상세주소2</label>
							<form:input path="mem_address3"/>
							<form:errors path="mem_address3" cssClass="error-color"/>
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