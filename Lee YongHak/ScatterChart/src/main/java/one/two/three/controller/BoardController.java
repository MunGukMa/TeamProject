package one.two.three.controller;

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

import one.two.three.util.PageNavigator;

import one.two.three.dao.BoardDAO;
import one.two.three.vo.BoardVO;
import one.two.three.vo.CommentVO;
import one.two.three.vo.PCSetVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	private final int countPerPage = 10;
	private final int pagePerGroup = 5;
	
	
	
	//게시판 글쓰기 화면
	@RequestMapping(value = "boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm(Model model, HttpSession session, PCSetVO vo) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);
			
		ArrayList<PCSetVO> pcsetList = dao.pcsetList(fitc_id);
		model.addAttribute("pcsetList", pcsetList);
		System.out.println(pcsetList);
		System.out.println(pcsetList.size());
		
		return "/board/boardWriteForm";
	}
	
	//게시판 글쓰기 화면
	@RequestMapping(value = "boardUpdateForm", method = RequestMethod.GET)
	public String boardUpdateForm() {
		return "/board/boardUpdateForm";
	}
	
	//게시판 글 리스트 
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchItem", defaultValue="title") String searchItem,
			@RequestParam(value="searchKeyword", defaultValue="") String searchKeyword) {
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
		System.out.println(list);
		return "/board/boardList";
	}
	
	//게시판 글읽기
	@RequestMapping(value = "boardRead", method = RequestMethod.GET)
	public String boardRead(Model model, int b_num,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchItem", defaultValue="title") String searchItem,
			@RequestParam(value="searchKeyword", defaultValue="") String searchKeyword) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchKeyword", searchKeyword);
		int totalRecordsCount = dao.getTotal(map);
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		ArrayList<BoardVO> list = dao.boardList(map, navi.getStartRecord(), navi.getCountPerPage());
		
		BoardVO vo = dao.boardRead(b_num);
		ArrayList<CommentVO> commentList = dao.commentList(b_num);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("commentList", commentList);
		return "/board/boardRead";
	}
	
	//게시판 글 쓰기
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWrite(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);
		boolean result;
		if(dao.boardWrite(vo) != 1) {
			result = false;
		}else {
			result = true;
		}
		
		ArrayList<PCSetVO> pcsetList = dao.pcsetList(fitc_id);
		
		rttr.addAttribute("w_result", result);
		rttr.addAttribute("pcsetList", pcsetList);
		
		System.out.println(pcsetList);
		return "redirect:/board/boardList";
	}
	
	// 게시글 수정
	@RequestMapping(value = "boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);
		boolean result;
		if(dao.boardUpdate(vo) !=1) {
			result = false;
		}else {
			result = true;
		}
		
		rttr.addAttribute("u_result", result);
		System.out.println(vo);
		return "redirect:/board/boardRead?b_num=" + vo.getB_num();
	}
		
	@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
	public String boardDelete(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);
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
	public String commentWrite(CommentVO vo, HttpSession session, RedirectAttributes rttr) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);
		rttr.addAttribute("b_num", vo.getB_num());
		
		return "redirect:/board/boardRead";
	}
	
	//댓글 삭제
	@RequestMapping(value = "commentDelete", method = RequestMethod.GET)
	public String commentDelete(CommentVO vo, HttpSession session) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);			
		
		return "redirect:/board/boardRead?b_num=" + vo.getB_num();
	}
	
	//댓글 삭제
	@RequestMapping(value = "commentUpdate", method = RequestMethod.GET)
	public String commentUpdate(CommentVO vo, HttpSession session, RedirectAttributes rttr) {
		String fitc_id = (String)session.getAttribute("fitc_id");
		vo.setFitc_id(fitc_id);			
	
		return "redirect:/board/boardRead?b_num=" + vo.getB_num();
	}
			
}