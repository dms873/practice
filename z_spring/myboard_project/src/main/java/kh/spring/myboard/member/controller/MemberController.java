package kh.spring.myboard.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.myboard.member.model.service.MemberService;
import kh.spring.myboard.member.model.vo.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/enroll")
	public ModelAndView pageInsert(ModelAndView mv) {
		mv.setViewName("member/insert");
		return mv;
	}
	
	@PostMapping("/enroll")
	public ModelAndView insert(
			ModelAndView mv
			, Member member
			, RedirectAttributes rttr
			) {
		
		int result = service.insertMember(member);
		if(result < 1) {
			rttr.addFlashAttribute("msg", "회원가입에 실패하였습니다. 다시 회원가입을 시도해주세요.");
			mv.setViewName("redirect:/member/insert");
			return mv;
		}
		mv.setViewName("redirect:/");
		
		
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView pageLogin(ModelAndView mv) {
		mv.setViewName("member/login");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView selectLogin(
			ModelAndView mv
			, Member member
			, RedirectAttributes rttr
			, HttpSession session
			) {
		
		Member result = service.selectLogin(member);
		if(result == null) { // 로그인 실패했을 때
			rttr.addFlashAttribute("msg", "로그인에 실패하였습니다. 아이디와 패스워드를 확인해주세요.");
			mv.setViewName("redirect:/member/login");
			return mv;
		}
		
		session.setAttribute("loginSsInfo", result);
		rttr.addFlashAttribute("msg", result.getName() + "님, 로그인 되었습니다.");
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
