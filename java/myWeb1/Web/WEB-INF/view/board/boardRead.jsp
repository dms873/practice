<%@page import="kh.test.first.board.model.vo.ReCommentVo"%>
<%@page import="kh.test.first.board.model.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Controller의 자료형과 맞추기 -->
<%
	BoardVo vo = (BoardVo)request.getAttribute("bVo");
if(vo.getbNo() <= 0)  {
%>
	<p>해당 글이 없습니다.</p>
	<button onclick="history.back()">이전페이지</button>
<%
} else {

%>	
<%-- <%=vo %> --%>
<%-- <p><%=vo.getbContent() %></p>
<p><%=vo.getReCommentCnt() %></p>
<p><%=vo.getbNo() %></p> --%>

<hr>
<%
	/* if(vo.getbContent() != null) { */
		// ArrayList<ReCommentVo> 자료형 맞추기
		for(ReCommentVo rvo : vo.getReVoList()) {
%>
			<p><%= rvo.getrNo() %></p>
			<p><%= rvo.getrContent() %></p>
			<p><%= rvo.getrWriter() %></p>
			<p><%= rvo.getrWriteDate() %></p>
			<hr>
<%
		/* } */
	}
}
%>

<form action="boardcomment" method="post">
	<input type="hidden" name="bNo" value="<%=vo.getbNo()%>">
	<input type="text" name="rContent">
	<button type="submit">댓글등록</button>
</form>


<p></p>
<p></p>
<p></p>
</body>
</html>