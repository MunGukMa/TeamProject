package team.project.one.dao;

import java.util.ArrayList;

import team.project.one.vo.GameVO;

public interface ChartMapper {
	public ArrayList<GameVO> gamelist();

	public GameVO selectOneGame(GameVO vo);
}
