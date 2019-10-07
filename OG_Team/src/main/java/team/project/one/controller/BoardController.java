package team.project.one.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.project.one.dao.BoardDAO;
import team.project.one.util.PageNavigator;
import team.project.one.vo.BoardVO;
import team.project.one.vo.CommentVO;
import team.project.one.vo.MemberVO;
import team.project.one.vo.PCEstimateVO;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	private final int countPerPage = 10;
	private final int pagePerGroup = 5;
	
	
	
	//게시판 글쓰기 화면
	@RequestMapping(value = "boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm(Model model, HttpSession session, PCEstimateVO vo) {
		MemberVO member = (MemberVO)session.getAttribute("fit_member");
		vo.setFit_userid(member.getFit_userid());
			
		ArrayList<PCEstimateVO> pcsetList = dao.pcsetList(member.getFit_userid());
		model.addAttribute("pcsetList", pcsetList);
		System.out.println(pcsetList);
		System.out.println(pcsetList.size());
		
		return "/board/boardWriteForm";
	}
	
	//게시판 수정 화면
	@RequestMapping(value = "boardUpdateForm", method = RequestMethod.GET)
	public String boardUpdateForm(Model model, HttpSession session, PCEstimateVO vo) {
		MemberVO member = (MemberVO)session.getAttribute("fit_member");
		vo.setFit_userid(member.getFit_userid());
			
		ArrayList<PCEstimateVO> pcsetList = dao.pcsetList(member.getFit_userid());
		model.addAttribute("pcsetList", pcsetList);
		System.out.println(pcsetList);
		System.out.println(pcsetList.size());
		
		return "/board/boardUpdateForm";
	}
	
	//게시판 글 리스트 
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchItem", defaultValue="fit_boardtitle") String searchItem,
			@RequestParam(value="searchKeyword", defaultValue="") String searchKeyword) 
	{
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchKeyword", searchKeyword);
		int totalRecordsCount = dao.getTotal(map);
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		
		ArrayList<BoardVO> list = dao.boardList(map, navi.getStartRecord(), navi.getCountPerPage());		
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchKeyword", searchKeyword);
		return "/board/boardList";
	}
	
	//게시판 글읽기
	@RequestMapping(value = "boardRead", method = RequestMethod.GET)
	public String boardRead(Model model, int fit_boardnum,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchItem", defaultValue="fit_boardtitle") String searchItem,
			@RequestParam(value="searchKeyword", defaultValue="") String searchKeyword) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchKeyword", searchKeyword);
		int totalRecordsCount = dao.getTotal(map);
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		ArrayList<BoardVO> list = dao.boardList(map, navi.getStartRecord(), navi.getCountPerPage());
		
		BoardVO vo = dao.boardRead(fit_boardnum);
		ArrayList<CommentVO> commentList = dao.commentList(fit_boardnum);
		PCEstimateVO pcvo = dao.getPcOne(vo);
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("vo", vo);
		model.addAttribute("pcvo",pcvo);
		model.addAttribute("commentList", commentList);
		return "/board/boardRead";
	}
	
	//게시판 글 쓰기
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWrite(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		System.out.println("글쓰기" + vo);
		boolean result = false;
		int temp = 0;
		temp = dao.boardWrite(vo);
		if(temp==1)
		{
			result = true;
		} 
		rttr.addAttribute("w_result", result);
		return "redirect:/board/boardList";
	}
	
	// 게시판 글 수정
	@RequestMapping(value = "boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		boolean result = false;
		int temp = 0;
		temp = dao.boardUpdate(vo);
		if(temp==1)	{
			result = true;
		}
		
		rttr.addAttribute("u_result", result);		
		return "redirect:/board/boardRead?fit_boardnum=" + vo.getFit_boardnum();
	}
	
	// 게시판 글 삭제
	@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
	public String boardDelete(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		MemberVO member = (MemberVO)session.getAttribute("fit_member");
		vo.setFit_userid(member.getFit_userid());
		boolean result;
		if(dao.boardDelete(vo) != 1) {
			result=false;
		}else {
			result=true;
		}
		rttr.addAttribute("d_result", result);
		return "redirect:/board/boardList";
	}
	
	//댓글 쓰기
	@RequestMapping(value = "commentWrite", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<CommentVO> commentWrite(CommentVO vo) {
		dao.commentWrite(vo);
		ArrayList<CommentVO> commentList = dao.commentList(vo.getFit_boardnum());
		for(CommentVO tmvo:commentList)
		{
			System.out.println(tmvo);
		}
		return commentList;
	}
	
	
	//댓글 삭제
	@RequestMapping(value = "commentDelete", method = RequestMethod.GET)
	public String commentDelete(CommentVO vo, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("fit_member");
		vo.setFit_userid(member.getFit_userid());
		return "redirect:/board/boardRead?b_num=" + vo.getFit_boardnum();
	}
	
	//댓글 수정
	@RequestMapping(value = "commentUpdate", method = RequestMethod.GET)
	public String commentUpdate(CommentVO vo, HttpSession session, RedirectAttributes rttr) {
		MemberVO member = (MemberVO)session.getAttribute("fit_member");
		vo.setFit_userid(member.getFit_userid());		
	
		return "redirect:/board/boardRead?b_num=" + vo.getFit_boardnum();
	}
			
	
	
}
