package kh.test.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // /WEB-INF/views/home.jsp 역할
	}
	
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home! The client locale is {}.{}", 10000, 100);
		
		model.addAttribute("serverTime", "2022-22-22222" );
		
		return "home"; // /WEB-INF/views/home.jsp 역할
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
//	model : 전송하고 싶은 데이터
	public String myPage(Model model) {
		logger.info("Welcome home! The client locale is {}.{}", 10000, 100);
		
		model.addAttribute("serverTime", "2022-22-333333" );
		
		return "mypage/mypage"; // /WEB-INF/views/mypage/mypage.jsp 역할
	}
}
