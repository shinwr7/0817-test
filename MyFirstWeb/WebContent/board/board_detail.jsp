<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table border="1">
		<tr>
			<td>글 번호</td>	
			<td><input value="${board.bid }" readonly></td>	
			<td>조회수</td>	
			<td>${board.bhit}</td>	
		</tr>
		<tr>
			<td>쓴 날짜</td>	
			<td><input type="text" value="${board.bdate }" readonly></td>	
		</tr>
		<tr>
			<td>글 제목</td>	
			<td><input type="text" value="${board.btitle }" readonly></td>	
		</tr>
		
		<tr>
			<td>본문</td>	
			<td><textarea cols="50" rows="10" readonly>${board.bcontent }</textarea></td>	
		</tr>
		<tr>
			<td>글쓴이</td>	
			<td><input type="text" value="${board.bname }" readonly></td>	
		</tr>
		<tr>
			<td colspan='3'><a href ="/MyFirstWeb/boardselect.do" ><input type ="button" value="돌아가기"></a>
			<form action="/MyFirstWeb/boarddelete.do" method ="post">
					<input type ="hidden" value="${board.bid }" name="bid">
					<input type ="submit" value="삭제하기">
			</form>
			<form action="/MyFirstWeb/boardupdate.do" method="post">
				<input type = "hidden" value="${board.bid }" name = "bid">
				<input type = "submit" value="수정하기">
			</form>
			</td>
		</tr>

	
	</table>

</body>
</html>