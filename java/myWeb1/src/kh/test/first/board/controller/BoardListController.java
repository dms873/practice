package kh.test.first.board.controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.first.board.model.service.BoardService;
import kh.test.first.board.model.vo.BoardVo;
/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet /boardList");
		// DB에서 board list 데이터 가져온 후 setAttribute에 넣어줌
			int currentPage = 1; // TODO : 임시 코드로 listView에서 scanner 동작 처리 후 삭제 예정
			
			final int pageSize = 3; // 한 페이지 당 3개씩 나타내기
			final int pageBlock = 3; 
			// 1 2 3 >>
			// << 4 5 6 >>
			// << 7 8 9 >>
			// << 10 11
			
			int totalCnt = countBoardList();
			// paging 처리
			int pageCnt = (totalCnt / pageSize) + (totalCnt % pageSize == 0 ? 0 : 1); // 나머지가 0이면 0을 더하기, 나머지가 0이 아니면 1을 더하기
			// 1 2 3 >> 를 먼저 표시할지, << 4 5 6 >>를 먼저 표시할지 정하기
			// 초기값 아무거나 설정
			int startPage = 1;
			int endPage = 1;
			
			if(currentPage % pageBlock == 0) {
				startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
			} else {
				startPage = ((currentPage / pageBlock)) * pageBlock + 1;
			}
			
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCnt) 
				endPage = pageCnt;
			System.out.println("paging > startPage : " + startPage + ", endPage : " + endPage);
			
			// rownum 처리
			int startRnum = 0;
			int endRnum = 0;
			
			startRnum = (currentPage - 1) * pageSize + 1;
			endRnum = startRnum + pageSize - 1;
			if(endRnum > totalCnt) 
				endRnum = totalCnt;
			
			ArrayList<BoardVo> voList = new BoardService().listBoard(startRnum, endRnum);
			
			System.out.println(voList);
			request.setAttribute("boardVolist", voList);
			request.getRequestDispatcher("WEB-INF/view/board/boardList.jsp").forward(request, response);
			
	}
	// 게시글리스트 개수
	public int countBoardList() {
		int result = new BoardService().countBoardList();
		return result;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
