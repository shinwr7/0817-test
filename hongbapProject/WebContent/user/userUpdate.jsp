<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hong Bop 회원정보수정창</title>
	<style>
		td{
			color : blue;
		}
	
	</style>
</head>
<body>
	<table border-radius: 70% border="1">
		<h2>회원 정보 수정</h2>
	</table>
	<form action="업데이트.do" method="post">
	<%-- 	<input type="hidden" value="${ }" name="UserId">
		<input type="hidden" value="${ }" name="UserPw">
		<input type="hidden" value="${ }" name="UserEmail">
		<input type="hidden" value="${ }" name="UserPnum"> --%>
		<table border="1">
			<tr>
				<td><strong>ID</strong> : <input type="text" name="UserId" placeholder="ID"></td>
			</tr>
			<tr>
				<td><strong>PW</strong> : <input type="password" name="UserPw" placeholder="PW"></td>
			</tr>
			<tr>
				<td><strong>Email</strong> : 
				<input type="email" name="UserEmail" placeholder="email"></td>
			</tr>
			<tr>
				<td><strong>Pnum</strong> : 
				<input type="tel" name="UserPnum" placeholder="Pnum"></td>
			</tr>
		</table>
		<table>
			<tr>
				<th><input type ="submit" value="제출"></th>
				<th><input type ="reset" value="초기화"></th>
			</tr>
		</table>
	</form>

</body>
</html>
