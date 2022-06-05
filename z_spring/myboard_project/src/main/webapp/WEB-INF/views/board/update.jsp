<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<button onclick="location.href='<%=request.getContextPath()%>/'">홈으로</button>
	<hr>
	<c:choose>
		<c:when test="${empty boardRead }">
			<script>
				alert("해당 글이 없습니다. 글 목록으로 이동합니다.");
				location.href="<%=request.getContextPath()%>/board/list";
			</script>
		</c:when>
		<c:otherwise>
			<form action="<%=request.getContextPath()%>/board/updateDo" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<td>level</td>
						<td>ref</td>
						<td>reply_ref</td>
						<td>seq</td>
						<td>번호</td>
						<td>작성일</td>
						<td>작성자</td>
						<td>조회수</td>
					</tr>
					<tr>
						<td>${boardRead.board_level }</td>
						<td>${boardRead.board_ref }</td>
						<td>${boardRead.board_reply_ref }</td>
						<td>${boardRead.board_reply_seq }</td>
						<td>${boardRead.board_num }</td>
						<td>${boardRead.board_date }</td>
						<td>${boardRead.board_writer }</td>
						<td>${boardRead.board_readcount }</td>
					</tr>
				</table>
				<input type="hidden" name="board_num" value="${boardRead.board_num }">
				<div>
					제목 : <input type="text" name="board_title" value="${boardRead.board_title }">
				</div>
				<div>
					내용 : <input type="text" name="board_content" value="${boardRead.board_content }">
				</div>
				<div>
					변경할 파일 : <input type="file" name="uploadfile">
				</div>
				
			</div>
			<c:if test="${not empty boardRead.board_original_filename }">
				<input type="hidden" name="board_rename_filename" value="${boardRead.board_rename_filename }">
				<div>기존 첨부파일 : <input type="text" name="board_original_filename" value="${boardRead.board_original_filename }" id="orgFile" readonly>
				<button type="button" onclick="document.getElementById('orgFile').value='';">기존파일삭제</button>
				</div>
				<div><img src="<%=request.getContextPath()%>/${boardRead.board_rename_filename}"></div>
			</c:if>
			<hr>
				<button onclick="location.href='<%=request.getContextPath()%>/board/list'">목록으로</button>
				<button type="reset">원래대로</button>
				<button>수정하기</button>
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>