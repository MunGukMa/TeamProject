package one.two.three.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import one.two.three.vo.Chart;

@Repository
public class ChartDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	public ArrayList<Chart> getGameInfo() {
		ChartMapper mapper = sqlsession.getMapper(ChartMapper.class);
		return mapper.getGameInfo();
	}

}
