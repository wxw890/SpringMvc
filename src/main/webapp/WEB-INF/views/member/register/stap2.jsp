<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보입력</h2>
	<form action="stap3" method="POST">
		<p>
			<label>메일<br/>
				<input type="text" name="email" id="email">
			</label>
		</p>
		<p>
			<label>이름<br/>
				<input type="text" name="name" id="name">
			</label>
		</p>
		<p>
			<label>비밀번호<br/>
				<input type="password" name="password" id="password">
			</label>
		</p>
		<p>
			<label>비밀번호 확인<br/>
				<input type="password" name="confirmpassword" id="confirmpassword">
			</label>
		</p>
		<input type="submit" value="가입 완료"/>
	</form>
</body>
</html>