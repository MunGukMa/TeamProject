package team.project.one.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.project.one.dao.AutoDAO;
import team.project.one.dao.ChartDAO;
import team.project.one.dao.ParsingDAO;
import team.project.one.servicce.ParsingService;
import team.project.one.vo.GameVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ChartDAO chartdao;
	
	@Autowired
	ParsingDAO parsingdao;
	
	@Autowired
	AutoDAO autodao;
	
	@Autowired
	ParsingService parser;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() 
	{
		return "home";
	}
	
	@RequestMapping(value="/dbchk",method=RequestMethod.GET)
	@ResponseBody
	public String dbchk()
	{
		boolean cpuflag = parser.getCnt("fit_cpu");
		boolean caseflag = parser.getCnt("fit_case");
		boolean ramflag = parser.getCnt("fit_ram");
		boolean gpuflag = parser.getCnt("fit_gpu");
		boolean powerflag = parser.getCnt("fit_power");
		boolean mainboardflag = parser.getCnt("fit_mainboard");
		
		System.out.println("cpuflag = "+cpuflag);
		System.out.println("caseflag = "+caseflag);
		System.out.println("ramflag = "+ramflag);
		System.out.println("gpuflag = "+gpuflag);
		System.out.println("powerflag = "+powerflag);
		System.out.println("mainflag = "+mainboardflag);
		
		if(cpuflag==false||caseflag==false||ramflag==false||gpuflag==false||powerflag==false||mainboardflag==false)
		{
			return "false";
		} else {
			return "true";
			}
	}
	
	
	
	
	@RequestMapping(value="gamelist", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<GameVO> gamelist()
	{
		ArrayList<GameVO> gameList = chartdao.getGameList();
		for(GameVO gmvo : gameList)
		{
			System.out.println(gmvo);
		};
		return gameList;
		
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = "/makelist", method = RequestMethod.GET)
	public String makelist(GameVO vo,Model model) {
		vo = chartdao.selectOneGame(vo);
		System.out.println();
		System.out.println(vo);
		System.out.println();
		model.addAttribute("game", vo);
		return "testpage";
	}
	
	@RequestMapping(value = "getauto", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> getouto(String keyvalue) {
		System.out.println(keyvalue);
		ArrayList<String> list = new ArrayList<>();
		list = autodao.getlist(keyvalue);
		return list;
	}
	
	
	
}
