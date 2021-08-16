<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hong Bop Login</title>
	<style>
		td{
			color : blue;
		}
	
	</style>
</head>
<body>
	<form action="로그인.do" method="post">
		<table border="1">
			<tr >
				<th align="middle"  >HongBob 로그인!!</th>
			</tr>
			<tr>
				<td><strong>ID</strong> : <input type="text" name="UserId" placeholder="ID"></td>
			</tr>
			<tr>
				<td><strong>PW</strong> : <input type="password" name="UserPw" placeholder="PW"></td>
			</tr>
		</table>
		<table >
			<tr >
				<th><input type ="submit" value="로그인"></th>
				<th><a href="회원가입.do"><input type ="button" value="회원가입"></a></th>
				<th></th>
			</tr>
		</table>
	</form>

</body>
</html>
