<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	게시글 쓰기
	<!-- boardVo 기준으로 생각함. 글쓰기 기준으로 변수선언한거 참고하기 -->
	<!-- 
	private String bTitle;
	private String bContent;

	// 로그인 정보로부터 전달
	private String bWriter;
	private String mId;
	-->
	
	<!-- .do는 그냥 db갔다오는 역할 -->
	<form action="boardwrite.do" method="post">
	<br><br>
	<input type="text" name="bTitle" required placeholder="제목을 입력하세요.">
	<br><br>
	<textarea rows="5" cols="50" name="bContent" required id="bContent" placeholder="내용을 입력하세요."></textarea>
	<br><br>
	<button type="submit">글등록</button>
	</form>
	
	
	<script>
	// TODO: 유효성 체크
	// 스페이스바만 입력 되었을 때 입력 받은걸로 인식하지 않음.(trim 사용)
		
	</script>
	
	
</body>
</html>