package com.hanhwa.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
		// redirect: 해주면 redirect 해주어라 
		@RequestMapping("/redirecttest")
		public String retest() {
			System.out.println("redirecttest 입니다.");
			return "redirect:test";
		}
	
	
	
	
	
	
	// 이건 update 역할
	@RequestMapping("/paramtest")
	// 내부적으로 request.getParameter 해줌
	public ModelAndView paramtest(Integer userid, String username) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", userid + 100);
		mv.addObject("username", username + "님");
		mv.setViewName("paramtestResult");
		
		return mv;
	}
	
	// get / set 이용
	@RequestMapping("/paramtest2")
	// 내부적으로 request.getParameter 해줌
	public ModelAndView paramtest2(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", user.getUserid() + 100);
		mv.addObject("username", user.getUsername() + "님");
		mv.setViewName("paramtestResult");
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value = "/han", method = RequestMethod.GET)
	public ModelAndView han() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("company", "한화ict##");
		mv.addObject("dept", "개발부##");
		mv.addObject("myname", "BJ##");
		mv.setViewName("test3");
		
		return mv;
	}
	// select 역할
	@RequestMapping(value = ("/test3"), method = RequestMethod.GET)
	public String test2(Model model) {
		model.addAttribute("company", "한화ict");
		model.addAttribute("dept", "개발부");
		model.addAttribute("myname", "BJ");
		// jsp의 이름
		return "test3";
	}
	
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
		model.addAttribute("myname", "Jun");
		// 요거가 home.jsp임
		return "home";
	}
	
}
