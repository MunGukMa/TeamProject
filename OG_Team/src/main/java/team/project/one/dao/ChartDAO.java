package team.project.one.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.project.one.vo.GameVO;

@Repository
public class ChartDAO {

	@Autowired
	private SqlSession sqlsession;

	public ArrayList<GameVO> getGameList() 
	{
		ChartMapper mapper = sqlsession.getMapper(ChartMapper.class);
		return mapper.gamelist();
	}

	public GameVO selectOneGame(GameVO vo) {
		ChartMapper mapper = sqlsession.getMapper(ChartMapper.class);
		return mapper.selectOneGame(vo);
	}
	
}
