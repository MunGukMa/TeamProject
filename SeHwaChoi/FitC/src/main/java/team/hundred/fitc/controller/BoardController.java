package team.hundred.fitc.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.hundred.fitc.dao.BoardDAO;

@Controller
public class BoardController {
		
	@Autowired
	private BoardDAO dao;	

	@RequestMapping(value = "/infoCheck", method = RequestMethod.GET)
	public String infoCheck() {
		return "/infoCheck";
	}
	
	@RequestMapping(value = "/tesseract", method = RequestMethod.POST)
	public String tesseract(File formData){
		String str = dao.tesseract(formData);
		if(str != null){
			
			
			
			return str;
		} else {
			System.out.println("Error");
			return "error";
		}
	}
}