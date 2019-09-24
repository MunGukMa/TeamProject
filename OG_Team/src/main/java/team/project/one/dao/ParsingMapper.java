package team.project.one.dao;

import java.util.ArrayList;

import team.project.one.vo.MainBoardVO;

public interface ParsingMapper {

	public void insertMainBoard(ArrayList<MainBoardVO> list);

	public int getnumber();

}
