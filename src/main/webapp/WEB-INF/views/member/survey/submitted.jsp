<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<p>응답 내용</p>
	<ul>
		<c:forEach var="answs" varStatus="status" items="${answ.getResponses()}">
		<!-- items: 반복데이터(ex list), var:현재 아이템의 변수 이름, vatStatus:반복 상태 값을 지닌 변수, begin: 시작번호 기본값은 0, end: 종료기호, step: 증가분 -->
			
			
			<li>${status.count}번 문항:${answs}</li><br/>
		
		</c:forEach>
		
	</ul>
	<p>응답자의 위치:${answ.getRes().getLocation()}</p>
	<p>응답자의 나이:${answ.getRes().getAge() }</p>
</body>
</html>