package team.hundred.fitc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import team.hundred.fitc.dao.BoardDAO;

@Controller
public class BoardController {
		
	@Autowired
	private BoardDAO dao;	

	@RequestMapping(value = "/infoCheck", method = RequestMethod.GET)
	public String infoCheck() {
		return "/infoCheck";
	}
	
	@RequestMapping(value = "/tesseract", method = {RequestMethod.POST, RequestMethod.GET})
	public ArrayList<String> tesseract(@RequestParam("uploadFile") MultipartFile file){
		ArrayList<String> list = dao.tesseract(file);
		if(list != null){
			return list;
		} else {
			System.out.println("Error");
			return list;
		}
	}
}