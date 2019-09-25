package team.hundred.fitc.dao;

import team.hundred.fitc.vo.MemberVO;

public interface MemberMapper {
	
	public void signUP(MemberVO vo);
	public int checkID(MemberVO vo);
	public MemberVO logIN(MemberVO vo);
	public MemberVO searchInfo(MemberVO vo);

}
