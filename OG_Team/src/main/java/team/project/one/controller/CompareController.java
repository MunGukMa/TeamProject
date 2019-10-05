package team.project.one.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import team.project.one.dao.CompareDAO;
import team.project.one.vo.CpuVO;
import team.project.one.vo.GpuVO;
import team.project.one.vo.MainBoardVO;
import team.project.one.vo.RamVO;

@Controller
public class CompareController {
		
	@Autowired
	private CompareDAO dao;	

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
	
	@RequestMapping(value = "/gameSpec", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Chart comRecommend(String cpuname, String memory, String gpuname, Model model) {
		Chart vo = new Chart();
		vo.setCpu(cpuname);
		vo.setVga(gpuname);
		vo.setRam(memory);

		return vo;
	}
	
	@RequestMapping(value = "/comRecommend", method = RequestMethod.GET)
	public String comRecommend2() {
		return "/comRecommend";
	}
	
	@RequestMapping(value = "/lowest", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public PcVO lowest(String cpu, String ram, String gpu, Model model) {
		PcVO vo = new PcVO();
		PcVO result = new PcVO();
		System.out.println(cpu);
		System.out.println(gpu);
		System.out.println(ram);
		vo.setCpu(cpu);
		if(ram.equalsIgnoreCase("16Gb"))
			vo.setRam("삼성전자 DDR4 16G");
		else if(ram.equalsIgnoreCase("8Gb"))
			vo.setRam("삼성전자 DDR4 8G");
		vo.setGpu(gpu);
		result = dao.lowestPrice(vo);
		return result;
	}
}
