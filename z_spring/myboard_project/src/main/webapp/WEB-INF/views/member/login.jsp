<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	메시지 : ${msg }
	<hr>
	<form action="<%=request.getContextPath()%>/member/login" method="post">
		<div>아이디 : <input type="text" name="id" required></div>
		<div>패스워드 : <input type="password" name="passwd" required></div>
		<button type="submit">로그인</button>
	</form>

</body>
</html>