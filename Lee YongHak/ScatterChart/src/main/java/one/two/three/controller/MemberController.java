package one.two.three.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import one.two.three.dao.MemberDAO;
import one.two.three.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {		
		return "loginForm";
	}
	
	@RequestMapping(value = "signupForm", method = RequestMethod.GET)
	public String signupForm() {		
		return "signupForm";
	}
	
	@RequestMapping(value = "checkidForm", method = RequestMethod.GET)
	public String checkidForm() {		
		return "checkidForm";
	}
	
	@RequestMapping(value = "signUP", method = RequestMethod.POST)
	public String signUP(MemberVO vo) {
		dao.signUP(vo);
		System.out.println(vo);
		return "redirect:/loginForm";
	}
	
	@RequestMapping(value = "checkID", method = RequestMethod.GET)
	public String checkID(MemberVO vo, RedirectAttributes rttr, HttpSession session) {
		boolean result = false;
		
		if(dao.checkID(vo) == 1) {
			session.setAttribute("fitc_id", vo.getFitc_id());
			result = false;
		}else {
			session.setAttribute("fitc_id", vo.getFitc_id());
			result = true;
		}
		if(vo.getFitc_id() == null || vo.getFitc_id().equals("")) {
			result = false;
		}
				
		rttr.addFlashAttribute("result", result);
		rttr.addFlashAttribute("vo", vo);
		
		return "redirect:/checkidForm";
	}
	
	@RequestMapping(value = "logIN", method = RequestMethod.POST)
	public String logIN() {		
		return "home";
	}
	
	@RequestMapping(value = "searchInfo", method = RequestMethod.POST)
	public String searchInfo() {		
		return "signupForm";
	}

}
