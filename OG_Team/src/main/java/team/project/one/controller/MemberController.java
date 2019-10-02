package team.project.one.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.project.one.dao.MemberDAO;
import team.project.one.servicce.MailSendService;
import team.project.one.vo.MemberVO;


@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;	
	
	
	@Autowired
	private MailSendService mailserv;
		
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
	public String signUP(MemberVO vo,String fitc_email_01,String fitc_email_02,HttpServletRequest request) {
		String mail = fitc_email_01+"@"+fitc_email_02;
		vo.setFit_usermail(mail);
		String keyvalue = mailserv.mailSendWithUserKey(mail, vo.getFit_userid(), request);
		vo.setFit_userkeyvalue(keyvalue);
		/*dao.signUP(vo);*/
		System.out.println(vo);
		System.out.println(vo.getFit_userpwd());
		return "redirect:/";
	}
	
	@RequestMapping(value = "checkID", method = RequestMethod.GET)
	public String checkID(MemberVO vo, RedirectAttributes rttr) {
		boolean result = false;
		
		if(dao.checkID(vo) == 1) {
			rttr.addFlashAttribute("fitc_id", vo.getFit_userid());			
			result = false;
		}else {
			rttr.addFlashAttribute("fitc_id", vo.getFit_userid());			
			result = true;
		}
		if(vo.getFit_userid() == null || vo.getFit_userid().equals("")) {
			result = false;
		}
				
		rttr.addFlashAttribute("result", result);
		rttr.addFlashAttribute("vo", vo);
		
		return "redirect:/checkidForm";
	}
	
	@RequestMapping(value = "logIN", method = RequestMethod.POST)
	public String logIN(MemberVO vo, HttpSession session) {
		boolean result = false;
		
		if(dao.logIN(vo) != null) {
			vo = dao.logIN(vo);
			session.setAttribute("fitc_id", vo.getFit_userid());
			session.setAttribute("fitc_pw", vo.getFit_userpwd());
			session.setAttribute("fitc_nickname", vo.getFit_usernick());
			session.setAttribute("fitc_email", vo.getFit_usermail());
			
			System.out.println("로그인 멤버 확인"+dao.logIN(vo));
			System.out.println(session.getAttribute("fitc_id"));
			result = true;
			
		}else {
			System.out.println("로그인 멤버 확인"+dao.logIN(vo));
			result = false;
			
		}		
		
		return "home";
	}
	
	@RequestMapping(value = "logOUT", method = RequestMethod.GET)
	public String logOUT(MemberVO vo, HttpSession session) {
		session.invalidate();
		return "home";
	}	
	
	@RequestMapping(value = "keycheck", method = RequestMethod.GET)
	public String keycheck(MemberVO vo,Model model) {
		System.out.println(vo);
		model.addAttribute("fit_userid",vo.getFit_userid());
		return "test";
	}	
	
	

	@RequestMapping(value = "searchInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody 
	public String searchInfo(MemberVO vo) {
		MemberVO member = dao.searchInfo(vo);
		String id = member.getFit_userid();
		if(id != null) {
			return id;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "searchPW", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody 
	public String searchPW(MemberVO vo) {
		vo = dao.searchPW(vo);
		String pw = vo.getFit_userpwd();
		if(pw != null) {
			return pw;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "updateInfo", method = RequestMethod.POST)
	public String updateInfo(MemberVO vo, HttpSession session, String fitc_email_01, String fitc_email_02) {
		String mail = fitc_email_01+"@"+fitc_email_02;
		vo.setFit_usermail(mail);;
		System.out.println(vo);
		dao.updateInfo(vo);
		System.out.println(vo);
		return "home";
	}

}
