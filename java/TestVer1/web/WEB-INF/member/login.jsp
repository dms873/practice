<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<form action="login" method="post">
		<p>로그인 페이지입니다.</p>
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="id" required></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="pwd" required></td>
			</tr>
		</table>
		<br>
		<button id="login">로그인</button>
		<button onclick="history.back()">뒤로가기</button>
	</form>
</body>
</html>