<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/guest/insert" method="get">
		<table border="1" width="400">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>

	<br>
	
	<c:forEach items="${guestList }" var="vo">
	<table border="1">
		<tr>
			<td>${vo.no }</td>
			<td>${vo.name }</td>
			<td>${vo.regDate }</td>
			<td><a href="/guestbook3/guest/deleteForm?${vo.no }">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">${vo.content }</td>
		</tr>
	</table>
	</c:forEach>
	



</body>
</html>