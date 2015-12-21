<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>MySql 연결 테스트</h1>
<%
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/spring4fs";
		Connection con = DriverManager.getConnection(url, "root", "1111");
		
		if(con != null){
			out.println("연결 성공");
		}
		
	}
	catch(Exception err){
		System.out.println("연결 실패 : " + err);
	}
%>
</body>
</html>