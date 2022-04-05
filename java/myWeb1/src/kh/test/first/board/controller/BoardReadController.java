package kh.test.first.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.first.board.model.service.BoardService;
import kh.test.first.board.model.vo.BoardVo;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet("/boardRead")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet boardRead");
		String bNoStr = request.getParameter("bNo"); 
		int bno = 0;
		try {
			bno = Integer.parseInt(bNoStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(bno < 1) {
			// 읽어온 게시글 번호가 없으면
			// main page 이동할지, boardlist로 이동할지 요구사항에 명시
			response.sendRedirect("boardList");
			return;
		}
		BoardVo vo = new BoardService().readBoardAndReComment(bno);
		System.out.println(vo);
		if(vo == null) {
			response.sendRedirect("boardList");
			return;
		}
		request.setAttribute("bVo", vo);
		request.getRequestDispatcher("WEB-INF/view/board/boardRead.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
