<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Main hello~</h2>
<ul>
	<c:if test="${name==null}">
	<li><a href="register.member">회원가입</a></li>
	<li><a href="login.member">로그인</a></li>
	</c:if>
	
	<c:if test="${name!=null}">
	${name}님 환영합니다.
	<li><a href="logout.member">로그아웃</a></li>
	<li><a href="">비밀번호 변경하기</a></li>
	</c:if>
	<li><a href="survy.form">설문조사</a></li>
	<li><a href="list.board">게시판</a></li>
</ul>
</body>
</html>
