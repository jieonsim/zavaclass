<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" type="text/css" href="${ctp}/css/include/header.css" />
<header class="container-fluid mt-5">
	<div class="container">
		<div class="row align-items-center justify-content-between">
			<div class="col-auto">
				<a href="#" class="header-link" id="localLens">Local Lens</a>
			</div>
			<div class="col-auto position-relative">
				<input class="search-input" type="search" placeholder="find a lil spot? use me!" aria-label="Search">
				<button class="search-btn" type="submit">
					<i class="ph ph-magnifying-glass"></i>
				</button>
			</div>
			<div class="col-auto d-flex align-items-center">
				<c:if test="${empty sessionUserIdx}">
					<a href="signup.s" class="header-link">
						<i class="ph ph-user"></i>
						<span class="ml-2 mr-4">sign up</span>
					</a>
					<a href="login.l" class="header-link">
						<i class="ph ph-sign-in"></i>
						<span class="ml-2">login</span>
					</a>
				</c:if>
				<c:if test="${not empty sessionUserIdx}">
					<div class="dropdown">
						<button type="button" class="btn btn-custom btn-lg dropdown-toggle" data-toggle="dropdown" id="user">
							<i class="ph-fill ph-user"></i>
							<span class="ml-2">${userVO.nickname}</span>
						</button>
						<div class="dropdown-menu dropdown-menu-right">
							<c:if test="${sessionRole == 'admin'}">
								<a class="dropdown-item" href="adminPage.a">관리자 페이지</a>
							</c:if>
							<a class="dropdown-item" href="checkPassword.u">프로필 수정</a>
							<%-- <a class="dropdown-item" href="${ctp}/logout.l">로그아웃</a> --%>
							<a class="dropdown-item" href="${ctp}/main?action=logout">로그아웃</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<input type="hidden" name="sessionUserIdx" value="${sessionUserIdx}">
</header>