package kh.test.first.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.first.member.model.service.MemberService;
import kh.test.first.member.model.vo.MemberVo;


/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jsp의 name과 같은 이름으로 넣어야함.
		// request 인자 확인
		String mId = request.getParameter("id");
		String password = request.getParameter("pwd");
		System.out.println(mId);
		
		// 한글깨짐현상 방지
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// DB 확인
		MemberVo vo = new MemberService().loginMember(mId, password);
		if(vo == null) {
			System.out.println("로그인 실패");
			response.sendRedirect("login");
		} else {
			// 세션의 setAttribute의 첫 번째 인자의 이름은 오래도록 쓰기 때문에 중요하게 지어줘야 함.(브라우저 닫을 때까지 유지)
			request.getSession().setAttribute("ssMemberVo", vo);
			// response.sendRedirect("./"); // 상대경로
			response.sendRedirect(request.getContextPath()+"/"); // 절대경로 사용 시
			// !!! 절대 하면 안됨!!! 
			// response.sendRedirect("myWeb1"+"/"); // ContextRoot는 myWeb1 직접 작성 X 자주 바뀔 수 있음.
		}
				
	}
	
//  controller 에서 page 이동 방법
//  1. respose.sendRedirect("서블릿url");
  // url에 이동한페이지가 나타남. 이전페이지를 누르면 login이 나타나지않음. 즉, login이라는 url이 이동할 페이지로 replace됨.
  // 이동할페이지 = 서블릿url
  // 데이터를 저장가능 단, session, application
//  2. request.getRequestDispatcher("jsp파일").forward(request, response);
  // url에 이동한페이지가 나타나지 않음. //즉, 컨트롤러의 url이 나타남
  // 이동할페이지 = jsp파일
  // 데이터를 전달가능 단, request, page, context, session, application
//  3. ajax - 이동할 페이지 정하지 않음. why-왔던곳으로 돌아가므로 이동할 페이지 작성하지 않음. TODO


//  html에서 page 이동방법
//  1. <a href="서블릿url">    ==>    method는 항상 get방식
//  2. <form action="서블릿url" method="get/post"></form>  ==> 메소드 선택가능
//  2-1. js submit() 2번과 같은 방식
//  3. ajax TODO "서블릿url"  ==> 메소드 선택가능

}
