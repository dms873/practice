package kh.test.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
//	이렇게 작성하면 get이어도 post여도 여기로 들어오게 됨
	@RequestMapping("/newmypage")
	public String mypage(Model model) {
		
		
	
		model.addAttribute("msg", "전달할 값");
		
		return "mypage/mypage";
		
	}
}
