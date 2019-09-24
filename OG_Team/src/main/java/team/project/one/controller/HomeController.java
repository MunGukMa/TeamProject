package team.project.one.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import team.project.one.dao.ChartDAO;
import team.project.one.dao.ParsingDAO;
import team.project.one.parsing.ParsingMain;
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
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		int mainboardnum =parsingdao.getnumber(); 
		
			ParsingMain.main();
		
		return "home";
	}
	
	
	@RequestMapping(value="gamelist", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<GameVO> gamelist()
	{
		ArrayList<GameVO> gameList = chartdao.getGameList();
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
	
	
}
