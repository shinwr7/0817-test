<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<!-- 아이디, 비밀번호, 이름, 이메일 4개 요소를 users_join.jsp
	로 보내주는 form을 작성해주세요. -->
	<h1>회원가입 창입니다</h1>
	<form action="/MyFirstWeb/join.do" method="post"><br/>
		<input type="text" name="id" placeholder="ID" required><br/>
		<input type="password" name="pw" placeholder="PW" required><br/>
		<input type="text" name="name" placeholder="NAME" required><br/>
		<input type="text" name="email" placeholder="EMAIL"><br/>
		<input type="submit" value="가입하기">
	</form>

</body>
</html>