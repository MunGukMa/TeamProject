package team.project.one.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.project.one.vo.MainBoardVO;

@Repository
public class ParsingDAO {

	@Autowired
	private SqlSession session;
	
	
	public void insertMainBoard(ArrayList<MainBoardVO> list) 
	{
		for(MainBoardVO mbvo:list)
		{
			System.out.println(mbvo);
		}
		ParsingMapper mapper = session.getMapper(ParsingMapper.class);
		mapper.insertMainBoard(list);
	}


	public int getnumber() 
	{
		ParsingMapper mapper = session.getMapper(ParsingMapper.class);
		return mapper.getnumber();
	}

}
