<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <form method="POST" action="survy.form">
      <p>
         1.당신의 역할은?<br />
         <label>
            <input type="radio" name="responses[0]" value="서버">
            서버 개발자
         </label>
         <label>
            <input type="radio" name="responses[0]" value="프론트">
            프론트 개발자
         </label>
         <label>
            <input type="radio" name="responses[0]" value="풀스택">
            풀스택 개발자
         </label>
      </p>
      <hr />
      <p>
         3.가장 많이 사용하는 개발 도구는?<br />
         <label>
            <input type="radio" name="responses[1]" value="망치">
            망치
         </label>
         <label>
            <input type="radio" name="responses[1]" value="하청">
            하청업자
         </label>
         <label>
            <input type="radio" name="responses[1]" value="안함">
            배째
         </label>
      </p>
      <hr />
      <p>
         3.하고 싶은 말<br />
         <input type="text" name="responses[2]" />
      </p>
      <p>
         <label>응답자의 위치</label>
         <input type="text" name="res.location" />
      </p>
      <p>
         <label>응답자의 나이</label>
         <input type="text" name="res.age" />
      </p>
      <input type="submit" value="전송" />
      <!-- 
      DTO를 두개 만들것. 응답자의 위치와 나이만을 저장하는 B DTO와 B DTO까지 포함해서 모든 설문내역을 저장하는 A DTO를 만들것이다.
      Has a 관계 형성. 우선은 B DTO - respondent 의 이름으로 만들도록 하겠다.
       -->
   </form>
</body>
</html>