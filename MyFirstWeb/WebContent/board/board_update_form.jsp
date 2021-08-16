<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정창</h1>
<form action="/MyFirstWeb/boardupdateok.do" method="post">

	
	<table border="1">
		<tr>
			<td>글 번호</td>	
			<td><input value="${board.bid }" readonly name ="bid"></td>	
			<td>조회수</td>	
			<td><input value="${board.bhit}" readonly name="bhit"></td>	
		</tr>
		<tr>
			<td>쓴 날짜</td>	
			<td><input type="text" value="${board.bdate }" readonly></td>	
		</tr>
		<tr>
			<td>글 제목</td>	
			<td><input type="text" value="${board.btitle }" name="btitle"></td>	
		</tr>
		
		<tr>
			<td>본문</td>	
			<td><textarea name="bcontent" cols="50" rows="10">${board.bcontent }</textarea></td>	
		</tr>
		<tr>
			<td>글쓴이</td>	
			<td><input type="text" value="${board.bname }" readonly name="bname"></td>	
		</tr>
		<tr>
			
			<td colspan='3'><a href ="/MyFirstWeb/boardselect.do" ><input type ="button" value="돌아가기"></a>
			
					
			</td>
		</tr>
	</table>
	<input type="hidden" name="bid" value="${board.bid }">
	<input type="hidden" name="btitle" value="${board.btitle }">
	<input type="hidden" name="bcontent" value="${board.bcontent }">
	<input type="hidden" name="bhit" value="${board.bhit }">
	<input type="hidden" name="bname" value="${board.bname }">
	
	
	<input type = "submit" value="수정하기">
	<input type = "reset" value="초기화">
	
	
	
</form>
</body>
</html>