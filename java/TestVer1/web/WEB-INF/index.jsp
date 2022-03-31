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
	안녕하세요 반갑습니다.<br><br>
	<button id="login">로그인</button>
	<button id="join">회원가입</button>
	
	<script>
	$("#login").click(function() {
			// 페이지 이동
			// get방식으로 링크가 걸리는 것과 동일함
			location.href = "login"; // a태그의 href와 동일 : get방식
		});
	
	$("#join").click(function() {
		// 페이지 이동
		// get방식으로 링크가 걸리는 것과 동일함
		location.href = "join"; // a태그의 href와 동일 : get방식
	});
	
	</script>
</body>
</html>