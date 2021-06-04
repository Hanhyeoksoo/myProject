<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css">
</head>
<body>
<div class="one-page">
	<h2>안내</h2>
	<div class="result-display">
		잘못 된 접속입니다.<br>
		<input type="button" value="게시판 목록"
		  onclick="${pageContext.request.contextPath}/board/list.do">
	</div>
</div>
</body>
</html>