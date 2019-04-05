<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
<script type="text/javascript" src="/resources/js/jquery-3.3.1.js"></script>
<script>
	var msg = "${msg}";
	$(function(){
		if(msg=="fail"){
			alert("탈퇴실패");
		}else if(msg=="success"){
			alert("탈퇴성공");
		}else if(msg=="changeSuccess"){
			alert("비밀번호 변경 성공. 재로그인하세요");
		}
	});
</script>
</head>
<body>
	<!-- http://localhost:8083 Servers-Modules탭에서 path설정-->
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">
				Spring WebMVC		
			</h1>
			<hr class="my-4" />
			<c:if test="${empty auth }">
				<a href="/regist/step1" class="btn btn-primary btn-lg" role="button">회원가입</a>
				<a href="/member/signin" class="btn btn-success btn-lg" role="button">로그인</a>
			</c:if>
			<c:if test="${!empty auth }">
				<a href="/member/logout" class="btn btn-success btn-lg" role="button">로그아웃</a>
				<a href="/member/changePwd" class="btn btn-primary btn-lg" role="button">비밀번호변경</a>
				<a href="/member/leave" class="btn btn-danger btn-lg" role="button">회원탈퇴</a>
			</c:if>
		</div>
		
	</div>
	

</body>
</html>