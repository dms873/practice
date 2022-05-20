<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap header">
    <header>
<%
/* 	MemberVo ssmvo = (MemberVo)session.getAttribute("ssMemberVo");
	if(ssmvo == null){ */
%>
	<br><button id="login">로그인</button><br>
<%
/* 	} else { */
%>
	<button id="mypage">마이페이지</button><br>
	<button id="logout">로그아웃</button><br>
<%
/* 	} */
%>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
	        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
	        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
	        voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
	        cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
	        ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
	        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
	        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
	        voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
	        cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
	</header>
<script>
	$("#login").click(function(){
		location.href = "login";   // a href 동일 get 방식
	});
	$("#logout").click(function(){
		location.href = "logout";
	});
	$("#mypage").click(function(){
		location.href = "mypage";
	});
</script>
</div>