<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 상단 시작 -->
 <header>
            <div class="container">
                <div class="row">
                    <div class="col-6 col-sm-3 logo-column">
                        <a href="${pageContext.request.contextPath}/main/main.do" class="logo">
                            <img src="${pageContext.request.contextPath}/resources/assets/img/gd_logo.png" alt="logo" width="200px" height="100px">
                        </a>
                    </div>
                    <div class="col-6 col-sm-9 nav-column clearfix">
                        <div class="right-nav">
                            <span class="search-icon fa fa-search"></span>
                            <form action="${pageContext.request.contextPath}/product/list.do" class="search-form">
                                <input type="search" placeholder="상품명 입력" name="keyword">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                        <nav id="menu" class="d-none d-lg-block">
                            <ul>
                                <li class="current-menu-item">
                                    <a href="${pageContext.request.contextPath}/main/main.do">Home</a>
                                </li>
                               <li><a href="${pageContext.request.contextPath}/product/list.do">중고장터</a></li>
                               <li><a href="${pageContext.request.contextPath}/board/list.do">자유게시판</a></li>
                               <li><a href="${pageContext.request.contextPath}/event/list.do">이벤트게시판</a></li>
								<li><a href="${pageContext.request.contextPath}/cheat/list.do">신고게시판</a></li>
                                <c:if test="${!empty user_num}">
									<li><a href="${pageContext.request.contextPath}/member/logout.do">[<span class="user_name">${user_id}</span>]로그아웃</a></li>
									<li><a href="${pageContext.request.contextPath}/member/myPage.do">MY페이지</a></li>
								</c:if>
								<c:if test="${empty user_num}">
									<li><a href="${pageContext.request.contextPath}/member/registerUser.do">회원가입</a></li>
									<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
								</c:if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header>   
<!-- 상단 끝 -->




