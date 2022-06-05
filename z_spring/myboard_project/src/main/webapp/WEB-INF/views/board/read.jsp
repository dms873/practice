<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 읽기</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<button onclick="location.href='<%=request.getContextPath()%>/'">홈으로</button>
	<!-- 본인이 작성한 글만 수정하기 버튼 보이도록 -->
	<c:if test="${boardRead.board_writer eq loginSsInfo.id}">
		<!-- 이렇게 get방식(a태그 또는 location.href)으로 작성하게 되면 url에 직접 치면은 접속이 됨 : 절대 이렇게 작성 XXX !! -->
		<%-- <button onclick="location.href='<%=request.getContextPath()%>/board/update?board_num=${boardRead.board_num }'">수정하기</button> --%>
		<form id="frmNum">
			<input type="hidden" name="board_num" value="${boardRead.board_num }">
			<button type="button" class="s_btn update">수정하기</button>
			<button type="button" class="s_btn delete">삭제하기</button>
		</form>
	</c:if>
	
	<!-- js사용하여 post방식으로 작성(데이터 여러개 들고 가야될 때 이렇게 하는게 편함) -->
	<script>
		<%-- action="<%=request.getContextPath()%>/board/update?board_num=${boardRead.board_num }" method="post" --%>
		$(".s_btn").click(function() {
			if ($(this).hasClass("update")) {
				frmNum.action = "<%=request.getContextPath()%>/board/update";
			} else {
				frmNum.action = "<%=request.getContextPath()%>/board/delete";
			}
			frmNum.method = "post";
			frmNum.submit();
		});
	</script>
	
	<!-- 1개 데이터만 들고 갔을 땐 이렇게 하는게 편함 -->
	<%-- <c:if test="${boardRead.board_writer eq loginSsInfo.id}">
		<form action="<%=request.getContextPath()%>/board/delete?board_num=${boardRead.board_num }" method="post">
			<input type="hidden" name="board_num" value="${boardRead.board_num }">
			<button>삭제하기</button>
		</form>
	</c:if> --%>
	<hr>
	<c:choose>
		<c:when test="${empty boardRead }">
			<script>
				alert("해당 글이 없습니다. 글 목록으로 이동합니다.");
				location.href="<%=request.getContextPath()%>/board/list";
			</script>
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
						<td>내용</td>
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
						<td>${boardRead.board_title }</td>
						<td>${boardRead.board_content }</td>
						<td>${boardRead.board_date }</td>
						<td>${boardRead.board_writer }</td>
						<td>${boardRead.board_readcount }</td>
					</tr>
				</table>
			</div>
			<c:if test="${not empty boardRead.board_original_filename }">
				<div>첨부파일 : ${boardRead.board_original_filename }</div>
				<div><img src="<%=request.getContextPath()%>/${boardRead.board_rename_filename}"></div>
			</c:if>
			<hr>
			<button onclick="location.href='<%=request.getContextPath()%>/board/write?refnum=${boardRead.board_num }'">답글쓰기</button>
			<button onclick="location.href='<%=request.getContextPath()%>/board/list'">목록으로</button>
		</c:otherwise>
	</c:choose>

</body>
</html>