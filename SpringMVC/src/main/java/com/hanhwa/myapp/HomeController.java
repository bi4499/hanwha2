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
	
		// redirect: ���ָ� redirect ���־�� 
		@RequestMapping("/redirecttest")
		public String retest() {
			System.out.println("redirecttest �Դϴ�.");
			return "redirect:test";
		}
	
	
	
	
	
	
	// �̰� update ����
	@RequestMapping("/paramtest")
	// ���������� request.getParameter ����
	public ModelAndView paramtest(Integer userid, String username) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", userid + 100);
		mv.addObject("username", username + "��");
		mv.setViewName("paramtestResult");
		
		return mv;
	}
	
	// get / set �̿�
	@RequestMapping("/paramtest2")
	// ���������� request.getParameter ����
	public ModelAndView paramtest2(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", user.getUserid() + 100);
		mv.addObject("username", user.getUsername() + "��");
		mv.setViewName("paramtestResult");
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value = "/han", method = RequestMethod.GET)
	public ModelAndView han() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("company", "��ȭict##");
		mv.addObject("dept", "���ߺ�##");
		mv.addObject("myname", "BJ##");
		mv.setViewName("test3");
		
		return mv;
	}
	// select ����
	@RequestMapping(value = ("/test3"), method = RequestMethod.GET)
	public String test2(Model model) {
		model.addAttribute("company", "��ȭict");
		model.addAttribute("dept", "���ߺ�");
		model.addAttribute("myname", "BJ");
		// jsp�� �̸�
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
		// ��Ű� home.jsp��
		return "home";
	}
	
}
