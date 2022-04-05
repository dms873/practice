<%@page import="kh.test.first.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>


	<form action="login" method="post">
		<input type="text" name="id" required>
		<input type="password" name="pwd" required>
		<br><br>
		<button type="submit">로그인</button>
	</form>
		<button type="button" id="enroll">회원가입</button>
		<button type="button" id="findId">아이디찾기</button>
		<button type="button" id="findPwd">비밀번호찾기</button>
		
		<script>
		
		$("#enroll").click(function() {
			// 페이지 이동
			location.href = "enroll"; // a태그의 href와 동일 : get방식
			
		});
		
		$("#findId").click(function() {
			// 페이지 이동
			location.href = "findId"; // a태그의 href와 동일 : get방식
			
		});
		
		$("#findPwd").click(function() {
			// 페이지 이동
			location.href = "findPwd"; // a태그의 href와 동일 : get방식
			
		});
	</script>
</body>
</html>