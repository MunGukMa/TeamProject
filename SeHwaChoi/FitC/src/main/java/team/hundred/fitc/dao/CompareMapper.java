package team.hundred.fitc.dao;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import team.hundred.fitc.vo.CpuVO;
import team.hundred.fitc.vo.GpuVO;
import team.hundred.fitc.vo.MainBoardVO;
import team.hundred.fitc.vo.RamVO;

public interface CompareMapper {
	
	public ArrayList<String> tesseract(MultipartFile file);
	public ArrayList<CpuVO> searchCPU(String cpuName);
	public ArrayList<MainBoardVO> searchMB(String name);
	public ArrayList<GpuVO> searchGP(String product_name);
	public ArrayList<RamVO> searchRAM(String name);
}
