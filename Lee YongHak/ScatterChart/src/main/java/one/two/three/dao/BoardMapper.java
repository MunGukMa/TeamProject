package one.two.three.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import one.two.three.vo.BoardVO;

public interface BoardMapper {
	public ArrayList<BoardVO> boardList(HashMap<String, String> map, RowBounds rb);
	public BoardVO boardRead(int b_num);
	public void hitCount(int b_num);
	public int boardWrite(BoardVO vo);
	public int boardDelete(BoardVO vo);
	public int boardUpdate(BoardVO vo);
	public int getTotal(HashMap<String, String> map);	

}
