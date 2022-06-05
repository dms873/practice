package kh.spring.myboard.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.myboard.board.model.service.BoardService;
import kh.spring.myboard.board.model.vo.Board;
import kh.spring.myboard.common.FileUpload;
import kh.spring.myboard.member.model.vo.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	@Autowired
	private FileUpload commonFile;
	
	@GetMapping("/write")
	public ModelAndView pageInsert(
			ModelAndView mv
			, @RequestParam(name = "refnum", defaultValue = "0") String refnumStr
			) {
		int refnum = 0;
		try {
			refnum = Integer.parseInt(refnumStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("refnum", refnum);
		mv.setViewName("board/insert");
		return mv;
	}
	
	@PostMapping("/write")
	public ModelAndView insert(
			ModelAndView mv
			, Board board
			, HttpSession session
			// MultipartFile 자료형
			, @RequestParam(name = "uploadfile", required = false) MultipartFile uploadfile
			, HttpServletRequest req
			) {
		
		// 로그인 정보 확인하여 작성자
		Member member = (Member) session.getAttribute("loginSsInfo");
		if(member == null) {
			mv.setViewName("redirect:/member/login");
			return mv;
		}
		board.setBoard_writer(member.getId());
		
		// 첨부파일이 있다면 저장
		if(uploadfile != null) {
			String rename_filename = commonFile.saveFile(uploadfile, req);
			if(rename_filename != null) {
				// 파일 저장에 성공하면 DB에 저장할 데이터를 채워줌
				board.setBoard_original_filename(uploadfile.getOriginalFilename());
				board.setBoard_rename_filename(rename_filename);
			}
		}
		
		// DB글 insert
		int result = service.insertBoard(board);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		
		// 굳이 변수 선언하지 않고 전달할 예정
		mv.addObject("boardlist", service.selectBoardListAll());
		
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/read")
	public ModelAndView selectRead(
			ModelAndView mv
			, @RequestParam(name = "board_num", required = false) String board_num
			, RedirectAttributes rttr
			) {
		
		if(board_num == null) {
			rttr.addFlashAttribute("msg", "해당 글이 없습니다. 글 목록으로 이동합니다.");
			mv.setViewName("redirect:/board/list");
		}
		
		mv.addObject("boardRead", service.selectBoardRead(board_num));
		
		mv.setViewName("board/read");
		
		return mv;
	}
	
	// get방식(a태그 또는 location.href)으로 하게되면 이렇게 써야됨(GetMapping일 때)
	
	@PostMapping("/update")
	public ModelAndView pageUpdateBoard(
			ModelAndView mv
			, @RequestParam("board_num") String board_num
			, RedirectAttributes rttr
			) {
		
		if(board_num == null) {
			rttr.addFlashAttribute("msg", "해당 글이 없습니다. 글 목록으로 이동합니다.");
			mv.setViewName("redirect:/board/list");
		}
		
		mv.addObject("boardRead", service.selectBoardRead(board_num));
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("/updateDo")
	public ModelAndView pageUpdateBoard(
			ModelAndView mv
			, Board board
			, @RequestParam(name = "uploadfile", required = false) MultipartFile uploadfile
			, HttpServletRequest req
			) {
		
		String before_rename_filename = board.getBoard_rename_filename();
		String before_original_filename = board.getBoard_original_filename();
		
		// 변경할 첨부파일이 있다면 저장
		if(uploadfile != null) {
			String rename_filename = commonFile.saveFile(uploadfile, req);
			if(rename_filename != null) {
				// 파일 저장에 성공하면 DB에 저장할 데이터를 채워줌
				board.setBoard_original_filename(uploadfile.getOriginalFilename());
				board.setBoard_rename_filename(rename_filename);
				
				// 기존 파일 있다면 파일서버에서 삭제함
				if(before_rename_filename != null && !before_rename_filename.equals("")) {
					commonFile.removeFile(before_rename_filename, req);
				}
			}
		} 
		// 변경할 첨부파일 없고 기존 첨부파일명도 삭제되었을 때 기존 파일 삭제
		else if(before_original_filename == null || before_original_filename.equals("")) {
			board.setBoard_original_filename(null);
			board.setBoard_rename_filename(null);
			if(before_rename_filename != null && !before_rename_filename.equals("")) {
				commonFile.removeFile(before_rename_filename, req);
			}
		}
		
		// DB글 update
		int result = service.updateBoard(board);
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@PostMapping("/delete")
	public ModelAndView pageDeleteBoard(ModelAndView mv) {
		// TODO
		mv.setViewName("board/delete");
		return mv;
	}
	
	
	
	
}
