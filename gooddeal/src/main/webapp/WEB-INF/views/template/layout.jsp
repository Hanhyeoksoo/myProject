<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   	<link rel="favicon" href="${pageContext.request.contextPath}/resources/assets/css/gooddeal_1.ico">
    <title>GoodDeal</title>

        <!-- Required CSS files -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/barfiller.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/slicknav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css">
</head>

<body>
    <div class="preloader">
        <span class="preloader-spin"></span>
    </div>
    <div class="site">
	    <tiles:insertAttribute name="header"/>     
	    <tiles:insertAttribute name="header_content"/>       
		<tiles:insertAttribute name="body"/>   
		<tiles:insertAttribute name="footer"/>
	</div>

    <!--Required JS files-->
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/jquery.barfiller.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/loopcounter.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/slicknav.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/active.js"></script>

</body>

</html>
