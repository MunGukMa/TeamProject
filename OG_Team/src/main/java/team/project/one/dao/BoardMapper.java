package team.project.one.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import team.project.one.vo.BoardVO;
import team.project.one.vo.CommentVO;
import team.project.one.vo.PCEstimateVO;


public interface BoardMapper {
	public ArrayList<BoardVO> boardList(HashMap<String, String> map, RowBounds rb);
	public BoardVO boardRead(int fit_boardnum);
	public void hitCount(int fit_boardnum);
	public int boardWrite(BoardVO vo);
	public int boardDelete(BoardVO vo);
	public int boardUpdate(BoardVO vo);
	public int getTotal(HashMap<String, String> map);
	public ArrayList<CommentVO> commentList(int fit_boardnum);
	public void commentWrite(CommentVO vo);
	public void commentUpdate(CommentVO vo);
	public void commentDelete(CommentVO vo);
	public ArrayList<PCEstimateVO> pcsetList(String fit_userid);
	public PCEstimateVO getpc(PCEstimateVO vo);
	public PCEstimateVO getPcOne(BoardVO vo);
}
