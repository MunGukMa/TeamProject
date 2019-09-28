package one.two.three.dao;

import java.util.ArrayList;

import one.two.three.vo.CommentVO;

public interface CommentMapper {
	
	public ArrayList<CommentVO> commentList(int b_num);
	public void commentWrite(CommentVO vo);
	public void commentUpdate(CommentVO vo);
	public void commentDelete(CommentVO vo);
}
