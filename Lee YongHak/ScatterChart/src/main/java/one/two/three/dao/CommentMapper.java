package one.two.three.dao;

import java.util.ArrayList;

import one.two.three.vo.CommentVO;

public interface CommentMapper {
	
	public ArrayList<CommentVO> commentList(int b_num);
	public int commentWrite(CommentVO vo);
	public int commentUpdate(CommentVO vo);
	public int commentDelete(CommentVO vo);
}
