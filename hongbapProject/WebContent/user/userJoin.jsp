<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hong Bop</title>
</head>
<body>
	<form action="회원가입.do" method="post">
		<table border="1px">
			<tr>
				<th colspan="2" align="middle">회원가입창 입니다.</th>
			</tr>
			<tr>
				<th>회원가입 아이디 : </th>
				<td><input type="test" name="UserId" placeholder="ID" required></td>
			</tr>	
			<tr>
				<th>회원가입 비밀번호 : </th>
				<td><input type="password" name="UserPw" placeholder="PW" required></td>
			</tr>	
			<tr>
				<th>회원가입 이메일 : </th>
				<td><input type="email" name="UserEmail" placeholder="Email" required></td>
			</tr>	
			<tr>
				<th>회원가입 비밀번호 : </th>
				<td><input type="tel" name="UserPnum" placeholder="Pnum" required></td>
			</tr>	
		</table>
		<table >
			<tr >
				<th><input type ="submit" value="제출"></th>
				<th><input type ="reset" value="초기화"></th>
			</tr>
		</table>
	</form>

</body>
</html>