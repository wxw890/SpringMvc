<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>list hello~</title>
</head>
<body>
<h2>리스트 페이지</h2>
<a href="write.board">글쓰기</a>
<br/><br/>
<table border="1">
<tr>
	<tr><td>번호</td><td>제목</td><td>등록자</td>
	<td>등록일</td><td>조회수</td>
</tr>
<c:forEach var="dto" items="${list}">
	<tr>
		<td>${dto.b_seq}</td>
		<td><a href="read.board?b_seq=${dto.b_seq}">${dto.b_title}</td>
		<td>${dto.b_writer}</td>
		<td>${dto.b_regdate}</td>
		<td>${dto.b_hitcount}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>