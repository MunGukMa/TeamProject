package one.two.three.dao;

import java.util.ArrayList;

import one.two.three.vo.PCSetVO;

public interface PCSetMapper {
	
	public ArrayList<PCSetVO> pcsetList(String fitc_id);

}
