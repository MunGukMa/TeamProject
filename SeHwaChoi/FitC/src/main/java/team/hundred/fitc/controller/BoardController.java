package team.hundred.fitc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import team.hundred.fitc.dao.BoardDAO;
import team.hundred.fitc.vo.CpuVO;
import team.hundred.fitc.vo.GpuVO;
import team.hundred.fitc.vo.MainBoardVO;
import team.hundred.fitc.vo.RamVO;

@Controller
public class BoardController {
		
	@Autowired
	private BoardDAO dao;	

	@RequestMapping(value = "/infoCheck", method = RequestMethod.GET)
	public String infoCheck() {
		return "/infoCheck";
	}
	
	@RequestMapping(value = "/comInfo", method = RequestMethod.GET)
	public String comInfo() {
		return "/comInfo";
	}
	
	@RequestMapping(value = "/tesseract", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ArrayList<String> tesseract(@RequestParam("uploadFile") MultipartFile file){
		ArrayList<String> list = dao.tesseract(file);
		if(list != null){
			return list;
		} else {
			System.out.println("Error");
			return list;
		}
	}
	
	@RequestMapping(value = "/searchCPU", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ArrayList<CpuVO> searchCPU(String cpuname){
		ArrayList<CpuVO> list = dao.searchCPU(cpuname);
		if(list == null) return null;
		return list;
	}
	
	@RequestMapping(value = "/searchCPU_window", method = RequestMethod.GET)
	public String searchCPU_window(){
		return "/searchCPU_window";
	}
	
	@RequestMapping(value = "/searchMB", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ArrayList<MainBoardVO> searchMB(String name){
		ArrayList<MainBoardVO> list = dao.searchMB(name);
		if(list == null) return null;
		return list;
	}
	
	@RequestMapping(value = "/searchMB_window", method = RequestMethod.GET)
	public String searchMB_window(){
		return "/searchMB_window";
	}
	
	@RequestMapping(value = "/searchGP", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ArrayList<GpuVO> searchGP(String product_name){
		ArrayList<GpuVO> list = dao.searchGP(product_name);
		if(list == null) return null;
		return list;
	}
	
	@RequestMapping(value = "/searchGP_window", method = RequestMethod.GET)
	public String searchGP_window(){
		return "/searchGP_window";
	}
	
	@RequestMapping(value = "/searchRAM", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ArrayList<RamVO> searchRAM(String name){
		ArrayList<RamVO> list = dao.searchRAM(name);
		if(list == null) return null;
		return list;
	}
	
	@RequestMapping(value = "/searchRAM_window", method = RequestMethod.GET)
	public String searchRAM_window(){
		return "/searchRAM_window";
	}
	
	@RequestMapping(value = "/compareAll", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ArrayList<String> compareAll(String cpu, String mainboard, String graphic, String ram){
		ArrayList<String> list = new ArrayList<String>();
		list.add(cpu);
		list.add(mainboard);
		list.add(graphic);
		list.add(ram);
		return list;
	}
	
	@RequestMapping(value = "/compareTo", method = RequestMethod.GET)
	public String compareTo(){
		return "/compareTo";
	}
}