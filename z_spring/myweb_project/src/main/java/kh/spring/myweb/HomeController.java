package kh.spring.myweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.spring.myweb.member.model.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	위나 아래나 같은 코드!(doGet, doPost 다 허용)
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("/login");
		// /WEB-INF/views/ 와 .jsp를 쓰지 않음 : servlet-context.xml의 ViewResolver쪽에 써있기 때문!
		return "member/login";
	}
	
	// 여러 매개인자 줄 때는 속성명 = 값 으로 넣어줘야 한다, 위치 바뀌어도 상관 없다
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		logger.info("/login POST id : [{}], pwd : [{}]", id, pwd);
		
		// String result = new MemberService().login(id, pwd);
		String result = memberService.login(id, pwd);
		
		logger.info(result);
		
		return "index";
	}
	
}
