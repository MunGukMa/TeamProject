package team.project.one.dao;

import java.util.ArrayList;

import team.project.one.vo.CpuVO;
import team.project.one.vo.GpuVO;
import team.project.one.vo.MainBoardVO;
import team.project.one.vo.RamVO;

public interface CompareMapper {
	public ArrayList<CpuVO> searchCPU(String cpuname);
	public ArrayList<MainBoardVO> searchMB(String name);
	public ArrayList<GpuVO> searchGP(String product_name);
	public ArrayList<RamVO> searchRAM(String name);

}
