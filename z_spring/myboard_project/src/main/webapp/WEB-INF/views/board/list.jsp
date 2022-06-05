<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<button onclick="location.href='<%=request.getContextPath()%>/'">홈으로</button>
	<c:choose>
		<c:when test="${empty boardlist }">
			<div>작성된 글이 없습니다.</div>
		</c:when>
		<c:otherwise>
			<div>
				<table border="1">
					<tr>
						<td>level</td>
						<td>ref</td>
						<td>reply_ref</td>
						<td>seq</td>
						<td>번호</td>
						<td>제목</td>
						<td>작성일</td>
						<td>작성자</td>
						<td>조회수</td>
					</tr>
		<c:forEach items="${boardlist }" var="i">
					<tr>
						<td>${i.board_level }</td>
						<td>${i.board_ref }</td>
						<td>${i.board_reply_ref }</td>
						<td>${i.board_reply_seq }</td>
						<td><a href="<%=request.getContextPath()%>/board/read?board_num=${i.board_num }">${i.board_num }</a></td>
						<td>
						<c:forEach begin="1" end="${i.board_level }">
							&#9755; 
						</c:forEach>
						${i.board_title }
						</td>
						<td>${i.board_date }</td>
						<td>${i.board_writer }</td>
						<td>${i.board_readcount }</td>
					</tr>
		</c:forEach>
				</table>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>