package one.two.three.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import one.two.three.dao.MemberDAO;
import one.two.three.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;	
		
	@RequestMapping(value = "signupForm", method = RequestMethod.GET)
	public String signupForm() {		
		return "signupForm";
	}
	
	@RequestMapping(value = "checkidForm", method = RequestMethod.GET)
	public String checkidForm() {		
		return "checkidForm";
	}
	
	@RequestMapping(value = "searchInfoForm", method = RequestMethod.GET)
	public String searchInfoForm() {		
		return "searchInfoForm";
	}
	
	@RequestMapping(value = "updateInfoForm", method = RequestMethod.GET)
	public String updateInfoForm() {		
		return "updateInfoForm";
	}
	
	@RequestMapping(value = "signUP", method = RequestMethod.POST)
	public String signUP(MemberVO vo) {
		dao.signUP(vo);
		System.out.println(vo);
		return "redirect:/";
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
	public String logIN(MemberVO vo, HttpSession session) {
		vo = dao.logIN(vo);
		session.setAttribute("fitc_id", vo.getFitc_id());
		session.setAttribute("fitc_pw", vo.getFitc_pw());
		session.setAttribute("fitc_name", vo.getFitc_name());
		session.setAttribute("fitc_email", vo.getFitc_email());
		
		System.out.println(dao.logIN(vo));
		System.out.println(session.getAttribute("fitc_id"));
		return "home";
	}
	
	@RequestMapping(value = "logOUT", method = RequestMethod.GET)
	public String logOUT(MemberVO vo, HttpSession session) {
		session.invalidate();
		return "home";
	}

	@RequestMapping(value = "searchInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody 
	public String searchInfo(MemberVO vo) {
		MemberVO member = dao.searchInfo(vo);
		String id = member.getFitc_id();

		if(id != null) {
			System.out.println("아이디 있지롱");
			return id;
		} else {
			System.out.println("응 없어.");
			return null;
		}

	}
	
	@RequestMapping(value = "searchPW", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody 
	public String searchPW(MemberVO vo) {
		vo = dao.searchPW(vo);
		System.out.println(vo.getFitc_pw());
		String pw = vo.getFitc_pw();
		System.out.println("통과함");
		if(pw != null) {
			System.out.println("비밀번호 있지롱");
			return pw;
		} else {
			System.out.println("스벌 없음.");
			return null;
		}
	}
	
	@RequestMapping(value = "updateInfo", method = RequestMethod.POST)
	public String updateInfo(MemberVO vo) {
		dao.updateInfo(vo);
		return "home";
	}

}
