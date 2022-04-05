package kh.test.first.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kh.test.first.board.model.dao.BoardDao;
import kh.test.first.board.model.vo.BoardVo;
import kh.test.first.board.model.vo.ReCommentVo;

import static kh.test.first.common.jdbc.JdbcTemplate.*;

public class BoardService {
	// *Service 에서 하는 일 *DB연결 - DAO메소드호출(SQL문실행) - *DB해제
	
	private BoardDao dao = new BoardDao();

	// 게시글 추가
	public int insertBoard(BoardVo vo) {
		// 위에 import static에 .*을 붙여줘서 안해도 됨.
		// Connection conn = JdbcTemplate.getConnection();
		// DB 연결
		Connection conn = getConnection(); // 위와 같은 코드

		// 연결된 상태, vo 인자에 들고감
		int result = dao.insertBoard(conn, vo);

		close(conn);

		// view에서 결과를 알아야 하니까 result를 return 해준다.
		return result;
	}

	// 댓글 추가
	public int insertReCommentBoard(ReCommentVo vo) {
		// DB 연결
		Connection conn = getConnection();

		// 연결된 상태, vo 인자에 들고감
		int result = dao.insertReCommentBoard(conn, vo);

		close(conn);

		// view에서 결과를 알아야 하니까 result를 return 해준다.
		return result;

	}
	
	// 게시판 리스트
	public ArrayList<BoardVo> listBoard() {

		// DB 연결
		Connection conn = getConnection(); 
		// 연결된 상태(conn 매개인자는 꼭 들고가야함)
		ArrayList<BoardVo> voList = dao.listBoard(conn);
		close(conn);

		// view에서 결과를 알아야 하니까 voList를 return 해준다.
		return voList;

	}
	
	// 게시판리스트(페이징처리)
	public ArrayList<BoardVo> listBoard(int startRnum, int endRnum) {

		// DB 연결
		Connection conn = getConnection(); 
		// 연결된 상태(conn 매개인자는 꼭 들고가야함)
		ArrayList<BoardVo> voList = dao.listBoard(conn, startRnum, endRnum);
		close(conn);

		// view에서 결과를 알아야 하니까 voList를 return 해준다.
		return voList;

	}

	// 게시판리스트 개수 확인
	public int countBoardList() {
		// DB 연결
		Connection conn = getConnection(); 
		// 연결된 상태(conn 매개인자는 꼭 들고가야함)
		int result = dao.countBoardList(conn);
		close(conn);

		// view에서 결과를 알아야 하니까 voList를 return 해준다.
		return result;
	}
	
	// 게시글 읽기
	public BoardVo readBoard(int bNo) {

		BoardVo vo = null;

		// DB 연결
		Connection conn = getConnection();

		vo = dao.readBoard(conn, bNo);

		// 객체 닫기
		close(conn);

		return vo;
	}
	
	public ArrayList<ReCommentVo> readBoardReComments(int bNo) {

		ArrayList<ReCommentVo> rvo = null;

		// DB 연결
		Connection conn = getConnection();
		
		rvo = dao.readBoardReComments(conn, bNo);
		
		close(conn);

		return rvo;
	}
	
	// 둘 다 한번에 표시하고 싶을 때
	public Map<String, Object> readBoardAndReCommentMap(int bNo) {

		BoardVo vo = null;
		ArrayList<ReCommentVo> rvo = null;

		// DB 연결
		Connection conn = getConnection();

		vo = dao.readBoard(conn, bNo);
		rvo = dao.readBoardReComments(conn, bNo);
		// 객체 닫기
		close(conn);
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("board", vo);
		map.put("reComment", rvo);
		return map;
	}
	
	// 게시글과 댓글 함께 읽기
	public BoardVo readBoardAndReComment(int bNo) {
		
		// DB 연결
		Connection conn = getConnection();
		BoardVo vo = dao.readBoard(conn, bNo); // 원래 게시글 읽기
		// 댓글 읽어서 Vo의 set에 넣고 리턴리턴..
		ArrayList<ReCommentVo> rVolist = dao.readBoardReComments(conn, bNo);

		// 객체 닫기
		close(conn);
		
		vo.setReVoList(rVolist);
		
		return vo;
	}
	
	// 게시글(제목,내용) 수정
	public int updateBoard(BoardVo vo, int bNo) {
		// DB 연결
		Connection conn = getConnection();

		// 연결된 상태, vo 인자에 들고감
		int result = dao.updateBoard(conn, vo, bNo);

		close(conn);

		// view에서 결과를 알아야 하니까 result를 return 해준다.
		return result;

	}
	
	// 게시글 지우기
	public int deleteBoard(int bNo) {
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, bNo);
		
		close(conn);
		
		return result;
	}
	
	// 댓글 몇 개인지 확인
	public int countReComment() {
		// DB 연결
		Connection conn = getConnection(); 
		// 연결된 상태(conn 매개인자는 꼭 들고가야함)
		int result = dao.countReComment(conn);
		close(conn);

		// view에서 결과를 알아야 하니까 voList를 return 해준다.
		return result;
	}
	
	// 댓글 지우는 기능
	public int deleteReComment(int bNo) {
		
		Connection conn = getConnection();
		
		int result = dao.deleteReComment(conn, bNo);
		
		close(conn);
		
		return result;
		
	}
	
	public ArrayList<BoardVo> searchBoard(BoardVo bvo, int bNo) {
		
		Connection conn = getConnection();
		
		ArrayList<BoardVo> result = dao.searchBoard(conn, bvo, bNo);
		
		close(conn);
		
		return result;
		
	}
	
}
