package one.two.three.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import one.two.three.dao.BoardMapper;
import one.two.three.vo.BoardVO;
import one.two.three.vo.CommentVO;
import one.two.three.vo.PCSetVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BoardVO> boardList(HashMap<String, String> map, int startRecord, int countPerPage){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		return mapper.boardList(map, rb);
	}
	
	public BoardVO boardRead(int b_num) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.hitCount(b_num);
		return mapper.boardRead(b_num);
	}
	
	public void hitCount(int b_num) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.hitCount(b_num);
	}
	
	public int boardWrite(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardWrite(vo);
	}
	
	public int boardDelete(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardDelete(vo);
	}
	
	public int boardUpdate(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardUpdate(vo);
	}

	public int getTotal(HashMap<String, String> map) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getTotal(map);
	}
	
	public ArrayList<CommentVO> commentList(int b_num){
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		return mapper.commentList(b_num);
	}
	
	public void commentWrite(CommentVO vo) {
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		mapper.commentWrite(vo);
	}
	
	public void commentUpdate(CommentVO vo) {
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		mapper.commentUpdate(vo);
	}
	
	public ArrayList<PCSetVO> pcsetList(String fitc_id){
		PCSetMapper mapper = sqlSession.getMapper(PCSetMapper.class);
		return mapper.pcsetList(fitc_id);
	}
}
