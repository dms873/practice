package kh.test.first.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.first.board.model.service.BoardService;
import kh.test.first.board.model.vo.ReCommentVo;
import kh.test.first.member.model.vo.MemberVo;

/**
 * Servlet implementation class BoardRecommentController
 */
@WebServlet("/boardcomment")
public class BoardRecommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardRecommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		String bNoStr = request.getParameter("bNo");
		int bNo = 0;
		try {
			bNo = Integer.parseInt(bNoStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(bNo < 1) { // 게시글 번호가 온전하지 않은 상태로 봄. 오류 상황으로 판단함. 
			response.sendRedirect("boardList");
			return;
		}
		String rContent = request.getParameter("rContent");
		String rWriter = "";
		String mId = "";
		
		// 로그인 정보 읽어오기
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		
		if(ssvo == null) { // 로그인이 되지 않은 상황 - 글 작성 불가함(애초에 글 등록 페이지를 들어갈 수 없게 하기)
			// 로그인 페이지로 이동
			response.sendRedirect("login");
			System.out.println("지금 너 null이니?");
			return; // 뒷줄 실행하지 않도록
		} else {
			rWriter = ssvo.getNickname();
			mId = ssvo.getmId();
		}
		
		ReCommentVo rvo = new ReCommentVo();
		rvo.setbNo(bNo);
		rvo.setrContent(rContent);
		
		
		int result = new BoardService().insertReCommentBoard(rvo);
	}

}
