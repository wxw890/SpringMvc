<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>list hello~</title>
</head>
<body>
<h2>글수정 페이지</h2>
<form action="update.board" method="post">
	제목:<input type="text" name="b_title" value="${dto['b_title']}"/><br/><br/>
	작성자:<input type="text" name="b_writer" value="${dto['b_writer']}"/><br/><br/>
	내용:<input type="5" cols="50" name="b_content" value="${dto['b_content']}"></textarea><br/><br/>
	<input type="submit" value="저장"/>
	<input type="button" value="리스트 페이지로 이동"/>
</form>

</table>
</body>
</html>