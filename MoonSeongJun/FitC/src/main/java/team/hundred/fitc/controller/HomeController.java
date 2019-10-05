package team.hundred.fitc.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import team.hundred.fitc.dao.ChartDAO;
import team.hundred.fitc.vo.Chart;

@Controller
public class HomeController {
		
	@Autowired
	private ChartDAO dao;	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Chart vo) {
		
		ArrayList<Chart> list = dao.getGameInfo();
		
		model.addAttribute("list", list);				
		model.addAttribute("listsize",list.size());
		System.out.println(list);
		
		return "home";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Chart> home(Chart vo) {
		
		ArrayList<Chart> list = dao.getGameInfo();
		return list;
	}

}