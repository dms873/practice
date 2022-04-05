package kh.test.first.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.first.board.model.service.BoardService;
import kh.test.first.board.model.vo.BoardVo;
import kh.test.first.member.model.vo.MemberVo;

/**
 * Servlet implementation class BoardWriteDoController
 */
@WebServlet("/boardwrite.do")
public class BoardWriteDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteDoController() {
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
		System.out.println("boardwrite.do 넘어왔니");
		
		// 한글 깨짐 현상 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		System.out.println("제목 : " + bTitle);
		System.out.println("내용 : " + bContent);
		
		String bWriter = "";
		String mId = "";
		
		// 로그인 정보 읽어오기
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		
		if(ssvo == null) { // 로그인이 되지 않은 상황 - 글 작성 불가함(애초에 글 등록 페이지를 들어갈 수 없게 하기)
			// 로그인 페이지로 이동
			response.sendRedirect("login");
			System.out.println("지금 너 null이니?");
			return; // 뒷줄 실행하지 않도록
		} else {
			bWriter = ssvo.getNickname();
			mId = ssvo.getmId();
		}
		BoardVo vo = new BoardVo();
		vo.setbTitle(bTitle);
		vo.setbContent(bContent);
		vo.setmId(mId);
		vo.setbWriter(bWriter);
		
		int result = new BoardService().insertBoard(vo);
		if(result < 1) { // 글쓰기 실패
			System.out.println("글쓰기 실패");
			response.sendRedirect("boardList");
		} else { // 성공 시 
			System.out.println("글쓰기 성공");
			response.sendRedirect("boardList");
		}
		
	}

}
