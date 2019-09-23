package one.two.three.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import one.two.three.dao.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {		
		return "loginForm";
	}

}
