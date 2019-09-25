package team.hundred.fitc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.hundred.fitc.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void signUP(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.signUP(vo);
	}
	
	public int checkID(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.checkID(vo);
	}
	
	public MemberVO logIN(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.logIN(vo);
	}
	
	public MemberVO searchInfo(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.searchInfo(vo);
	}

}
