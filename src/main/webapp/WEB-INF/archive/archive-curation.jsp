<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Local Lens</title>
<jsp:include page="/WEB-INF/include/bs4.jsp" />
<link rel="stylesheet" type="text/css" href="${ctp}/css/archive/archive.css" />
<link rel="stylesheet" type="text/css" href="${ctp}/css/common/basicAlert.css" />
<script src="${ctp}/js/common/basicAlert.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&display=swap" rel="stylesheet">
<script>
document.addEventListener("DOMContentLoaded", function() {
    const links = document.querySelectorAll('.archive-container ul li a');
    const currentPage = window.location.pathname.split('/').pop();

    links.forEach(link => {
        link.addEventListener('click', function() {
            links.forEach(l => l.classList.remove('active'));
            this.classList.add('active');
        });

        if (link.getAttribute('href').includes(currentPage)) {
            link.classList.add('active');
        }
    });
});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	<jsp:include page="/WEB-INF/include/nav.jsp" />
	<div class="container">
		<div class="archive-container">
			<div class="row mb-5">
				<div class="col-3">
					<div class="photo-placeholder">
						<c:choose>
							<c:when test="${not empty userVO.profileImage}">
								<img id="profile-photo" src="${ctp}/images/profileImage/${userVO.profileImage}" alt="Profile Photo" class="profile-photo" />
							</c:when>
							<c:otherwise>
								<span id="profile-icon" class="profile-icon">
									<i class="ph ph-user-focus" id="profileIcon"></i>
								</span>
								<img id="profile-photo" src="" alt="Profile Photo" class="profile-photo d-none" />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-9">
					<div class="mb-3" id="nickname">@ ${userVO.nickname}</div>
					<c:choose>
						<c:when test="${not empty userVO.introduction}">
							<div>${userVO.introduction}</div>
						</c:when>
						<c:otherwise>
							<div>
								<a href="checkPassword.u" id="updateProfileLink">클릭하고 소개 글을 입력해 보세요.</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<ul class="d-flex justify-content-between list-unstyled">
				<li>
					<a href="archive-localLog.a" id="localLog">로컬로그</a>
				</li>
				<li>
					<a href="archive-guestBook.a" id="guestBook">방명록</a>
				</li>
				<li>
					<a href="archive-curation.a" id="curation">큐레이션</a>
				</li>
			</ul>
			<div class="text-center" style="margin-top: 100px;">
				<div class="mb-2">추천하고 싶은 나만의 공간 가이드를 만들어보세요.</div>
				<button class="btn btn-custom" id="firstRecord">첫 큐레이션 작성하기</button>
			</div>
			<div class="text-center" style="margin-top: 100px;">
				<i class="ph ph-image" style="font-size: 48px"></i>
				<div class="mb-1 mt-3" style="font-weight: bold">콘텐츠가 없습니다.</div>
				<div style="color: dimgray">아직 콘텐츠가 존재하지 않습니다.</div>
			</div>
		</div>
	</div>
	<input type="hidden" id="message" value="${message}" />
	<input type="hidden" id="url" value="${url}" />
	<input type="hidden" name="sessionUserIdx" value="${sessionScope.sessionUserIdx}" />
</body>
</html>