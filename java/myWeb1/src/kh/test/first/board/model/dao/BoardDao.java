package kh.test.first.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import kh.test.first.board.model.vo.BoardVo;
import kh.test.first.board.model.vo.ReCommentVo;

import static kh.test.first.common.jdbc.JdbcTemplate.close;



//------------ -------- ------------- 
//R_NO         NOT NULL NUMBER        
//B_NO         NOT NULL NUMBER        
//R_WRITER     NOT NULL VARCHAR2(60)  
//R_WRITE_DATE NOT NULL TIMESTAMP(6)  
//R_CONTENT    NOT NULL VARCHAR2(900) 
//M_ID         NOT NULL VARCHAR2(20)  

public class BoardDao {
	
	private Statement stmt = null;
	private ResultSet rset = null;
	private PreparedStatement pstmt = null;
	private Scanner sc = new Scanner(System.in);
	
	
	// TODO : Member 회원가입 및 login 구현 먼저 해야됨
	// 로그인 하게되면 M_ID를 알게 됨.
	// 글쓰기 기능 구현
	public int insertBoard(Connection conn, BoardVo vo) {
		String mId = vo.getmId();
		int result = 0;
		String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD_B_NO.NEXTVAL,"
				+ "'" + vo.getbTitle()+"', '" + vo.getbContent() + "'" 
				+ ", DEFAULT, DEFAULT, (SELECT NICKNAME FROM MEMBER WHERE M_ID = '" + mId + "'), '" + mId + "')";
		
		try {
			// 만들 땐 매개인자 안줌
			stmt = conn.createStatement();
			// executeUpdate할 때 매개인자 줌
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		// view에서 결과를 알아야 하니까 result를 return 해준다.
		return result;
	}
	
	
	
	// 댓글 기능 구현(PreparedStatement 사용)
	public int insertReCommentBoard(Connection conn, ReCommentVo vo) {
		String mId = "aaa"; // TODO : 삭제 예정(임시로 만듬)
		int result = 0;
		

//		R_NO         NOT NULL NUMBER        
//		B_NO         NOT NULL NUMBER        
//		R_WRITER     NOT NULL VARCHAR2(60)  
//		R_WRITE_DATE NOT NULL TIMESTAMP(6)  
//		R_CONTENT    NOT NULL VARCHAR2(900) 
//		M_ID         NOT NULL VARCHAR2(20)  
		
		
		// 보통은 컬럼명 지정하여 INSERT를 함
//		String sql = "INSERT INTO RE_COMMENT (R_NO, B_NO, R_WRITER, R_WRITE_DATE, R_CONTENT, M_ID) VALUES (?, ?, ?, DEFAULT, ?, ?)";
//		String sql = "INSERT INTO RE_COMMENT VALUES (?, ?, ?, SYSDATE, ?, ?)";
		// ? 자리에 넣어도 됨. vo를 받아서 하지 않기 때문에!
		// 첫번째 인자 코드는 시퀀스 대신 많이 쓰는 코드임!
		String sql = "INSERT INTO RE_COMMENT VALUES ((SELECT NVL(MAX(R_NO),0) + 1 FROM RE_COMMENT)"
				+ ", ?"
				+ ", (SELECT NICKNAME FROM MEMBER WHERE M_ID = ?)"
				+ ", SYSDATE"
				+ ", ?"
				+ ", ?)";
		
		try {
			// sql문에서 ? 을 쓴다면 prepareStatement를 사용하는 것이고, 아래 코드가 세트!
			pstmt = conn.prepareStatement(sql);
			
			// 첫 번째 물음표에 1을 넣어줘
			// pstmt.setInt(1, 1); // TODO : 하드코딩한거임, 바꿔줄 거임 (SELECT NVL(MAX(R_NO),0) + 1 FROM RE_COMMENT) 의 결과를 넣고싶음!
			// 첫 번째 물음표에 23번글에 댓글남길거야
			pstmt.setInt(1, 1); // TODO : 하드코딩한거임, 바꿔줄 거임 (읽기화면의 B_NO를 넣어줄 예정)
			// 두 번째 물음표에 mId랑 같은 멤버테이블의 닉네임을 넣어주기
			pstmt.setString(2, mId); // TODO : SELECT NICKNAME FROM MEMBER WHERE M_ID = '" + mId + "'
			// 세 번째 물음표
			pstmt.setString(3, vo.getrContent());
			// 네 번째 물음표
			pstmt.setString(4, mId);
			
			// 실행할 때 매개인자 안줌!(prepareStstement를 사용했기 때문)
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		// view에서 결과를 알아야 하니까 result를 return 해준다.
		return result;
	}
	
	// 게시판 리스트 기능
	public ArrayList<BoardVo> listBoard(Connection conn) {
		
		ArrayList<BoardVo> voList = null;
		
		String sql = "SELECT * FROM BOARD ORDER BY B_WRITE_DATE DESC"; // 최근 작성된 것이 먼저 나오게 정렬
		
		//------------ -------- -------------- 
		//B_NO         NOT NULL NUMBER         
		//B_TITLE      NOT NULL VARCHAR2(300)  
		//B_CONTENT    NOT NULL VARCHAR2(3000) // ** 만약 자료형이 CHAR(300)이라면 rset.String으로 해주어야 함. (자바에서 char은 'A' 한글자니까!), 근데 만약 Varchar2(1) 이라면? char형에 넣을 수 있음.
		//B_COUNT      NOT NULL NUMBER         
		//B_WRITE_DATE NOT NULL TIMESTAMP(6)   
		//B_WRITER     NOT NULL VARCHAR2(60)   
		//M_ID         NOT NULL VARCHAR2(20)  
		
		try {
			pstmt = conn.prepareStatement(sql); // 물음표가 없어서 setString 이런거 안함!
			rset = pstmt.executeQuery(); 
			
			
			// 방법 1
			if(rset.next()) { // rset이 없으면 굳이 new를 할 필요 없으니 if로 조건 걸어주기
				
				// 1차원 배열처럼 new ArrayList<BoardVo>() 생성
				voList = new ArrayList<BoardVo>(); 
				// ArrayList에 기본자료형이 들어있다면, new ArrayList<BoardVo>()가 필요없음.
				// 현재는 참조 자료형<BoardVo>가 있으니 new ArrayList<BoardVo>()가 필요함.
				
				// 그냥 while(rset.next())를 하게되면 한줄타고 들어왔는데 첫 줄 생략하고 또 다음줄부터 읽기 때문에 do-while문 사용
				do { 
					// 2차원 배열처럼 new BoardVo() 생성
					// while + 참조자료형이다? new BoardVo() 해야됨
					BoardVo boardVoList = new BoardVo();
					boardVoList.setbNo(rset.getInt("B_NO"));
					boardVoList.setbTitle(rset.getString("B_TITLE"));
					boardVoList.setbContent(rset.getString("B_CONTENT"));
					boardVoList.setbCount(rset.getInt("B_COUNT"));
					boardVoList.setbWriteDate(rset.getTimestamp("B_WRITE_DATE"));
					boardVoList.setbWriter(rset.getString("B_WRITER"));
					boardVoList.setmId(rset.getString("M_ID"));
//					** 만약 자료형이 CHAR(300)이라면 rset.String으로 해주어야 함. (자바에서 char은 'A' 한글자니까!) 
//					근데 만약 Varchar2(1) 이라면? char형에 넣을 수 있음.
//					rset.getCharacterStream(2); // CHAR(1)이여도 getString으로 사용!
//					char a = rset.getString("M_ID").charAt(0); // 만약 자바의 char형에 담고 싶다면, 이렇게 작성해야 됨.(getCharacterStream()안쓰고!)
					
					// ArrayList에 데이터 add();
					voList.add(boardVoList);
					
				} while(rset.next());
			}
			
			
			// 방법 2, 강사님은 방법 1 선호 => 불필요한 new 생성을 최소화.
//			voList = new ArrayList<BoardVo>();
//			while(rset.next()) {
//				BoardVo boardVoList = new BoardVo();
//				boardVoList.setbNo(rset.getInt("B_NO"));
//				
//				voList.add(boardVoList);
//			}
			
			// 방법 3,
//			if(rset != null) { // rset을 close하지 않았으면 null일 가능성이 있다.
			// 그리고 0행이 조회되는 경우는 not null이 아님(try문 시작해서 sql execute 잘 됐기 때문에) => SQL문 오류가 아님!
			// SQL문이 오류가 났다면 null이 return이 됨.
			
//				voList = new ArrayList<BoardVo>(); 
//				while(rset.next()) {
//					BoardVo boardVoList = new BoardVo();
//					boardVoList.setbNo(rset.getInt("B_NO"));
//					boardVoList.setbTitle(rset.getString("B_TITLE"));
//					boardVoList.setbContent(rset.getString("B_CONTENT"));
//					boardVoList.setbCount(rset.getInt("B_COUNT"));
//					boardVoList.setbWriteDate(rset.getTimestamp("B_WRITE_DATE"));
//					boardVoList.setbWriter(rset.getString("B_WRITER"));
//					boardVoList.setmId(rset.getString("M_ID"));
//					
//					voList.add(boardVoList);
//				}
//			}
			
			// 방법 4, 생성자에 인자 전달(생성자 메소드에 있는 순서 꼭 맞춰주어야 함!) 
			// 현재 이런 방법이 있다고만 써서 이거대로 쓰려면 SQL문 수정해야됨(댓글 개수 확인까지 있기 때문에!) 
//			if(rset != null) { // rset을 close하지 않았으면 null일 가능성이 있다.
//			voList = new ArrayList<BoardVo>(); 
//			while(rset.next()) {
//				BoardVo boardVoList = new BoardVo(rset.getInt("B_NO"), rset.getString("B_TITLE"), rset.getString("B_CONTENT")
//												, rset.getString("B_COUNT"), rset.getTimestamp("B_WRITE_DATE"), rset.getString("B_WRITER")
//												, rset.getString("M_ID"), rs.getInt("reCommentCnt"));
//				
//				voList.add(boardVoList);
//			}
//		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return voList;
		
	}
	
	// 페이징 처리
	public ArrayList<BoardVo> listBoard(Connection conn, int startRnum, int endRnum) {

		ArrayList<BoardVo> voList = null;
		
//		String sql = "SELECT * FROM"
//				+ "(SELECT ROWNUM RNUM, T1.* FROM"
//				+ "(SELECT * FROM BOARD ORDER BY B_WRITE_DATE DESC) T1) A "
//				+ "WHERE A.RNUM BETWEEN ? AND ?"; // 최근 작성된 것이 먼저 나오게 정렬
		
		String sql = "SELECT * FROM"
					+ "(SELECT ROWNUM RNUM, T1.* FROM"
					+ "(SELECT B.*, (SELECT COUNT(*) FROM RE_COMMENT WHERE B_NO = B.B_NO) reCommentCnt\r\n"
					+ "FROM BOARD B\r\n"
					+ "ORDER BY B_WRITE_DATE DESC) T1) A "
					+ "WHERE A.RNUM BETWEEN ? AND ?"; // 최근 작성된 것이 먼저 나오게 정렬
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rset = pstmt.executeQuery(); 
			
			
			if(rset.next()) { // rset이 없으면 굳이 new를 할 필요 없으니 if로 조건 걸어주기 / if(rset != null) 이 조건으로는 판별 불가.
				
				// 1차원 배열처럼 new ArrayList<BoardVo>() 생성
				voList = new ArrayList<BoardVo>(); 
				// ArrayList에 기본자료형이 들어있다면, new BoardVo()가 필요없음.
				// 현재는 참조 자료형<BoardVo>가 있으니 new BoardVo()가 필요함.
				
				// 그냥 while(rset.next())를 하게되면 한줄타고 들어왔는데 첫 줄 생략하고 또 다음줄부터 읽기 때문에 do-while문 사용
				do { 
					// 2차원 배열처럼 new BoardVo() 생성
					BoardVo boardVoList = new BoardVo();
					boardVoList.setbNo(rset.getInt("B_NO"));
					boardVoList.setbTitle(rset.getString("B_TITLE"));
					boardVoList.setbContent(rset.getString("B_CONTENT"));
					boardVoList.setbCount(rset.getInt("B_COUNT"));
					boardVoList.setbWriteDate(rset.getTimestamp("B_WRITE_DATE"));
					boardVoList.setbWriter(rset.getString("B_WRITER"));
					boardVoList.setmId(rset.getString("M_ID"));
					boardVoList.setReCommentCnt(rset.getInt("reCommentCnt"));
//					** 만약 자료형이 CHAR(300)이라면 rset.String으로 해주어야 함. (자바에서 char은 'A' 한글자니까!) 
//					근데 만약 Varchar2(1) 이라면? char형에 넣을 수 있음.
//					rset.getCharacterStream(2); // CHAR(1)이여도 getString으로 사용!
//					char a = rset.getString("M_ID").charAt(0); // 만약 자바의 char형에 담고 싶다면, 이렇게 작성해야 됨.(getCharacterStream()안쓰고!)
					
					// ArrayList에 데이터 add();
					voList.add(boardVoList);
					
				} while(rset.next());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return voList;
		
	}

	// 행의 총 개수 구하기
	public int countBoardList(Connection conn) { // 여기의 int형 return은 DML 결과가 아니라 ResultSet으로 부터 읽은 후 int형으로 결과를 담아 준다.
		int result = 0;
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // 단일행이면 if문으로 사용, 다중행이면 while문 사용
				result = rset.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}
	
	// 게시판 1개 읽기
	public BoardVo readBoard(Connection conn, int bNo) {
		
		// 1. SQL문 실행
		String sql = "SELECT * FROM BOARD WHERE B_NO = ?";
		BoardVo bvo = new BoardVo();
		
//		------------ -------- -------------- 
//		B_NO         NOT NULL NUMBER         
//		B_TITLE      NOT NULL VARCHAR2(300)  
//		B_CONTENT    NOT NULL VARCHAR2(3000) 
//		B_COUNT      NOT NULL NUMBER         
//		B_WRITE_DATE NOT NULL TIMESTAMP(6)   
//		B_WRITER     NOT NULL VARCHAR2(60)   
//		M_ID         NOT NULL VARCHAR2(20)   
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				// sql 결과가 단일행이라 if문 사용해도 됨.
				bvo.setbNo(rset.getInt("B_NO"));
				bvo.setbTitle(rset.getString("B_TITLE"));
				bvo.setbContent(rset.getString("B_CONTENT"));
				bvo.setbCount(rset.getInt("B_COUNT"));
				bvo.setbWriteDate(rset.getTimestamp("B_WRITE_DATE"));
				bvo.setbWriter(rset.getString("B_WRITER"));
				bvo.setmId(rset.getString("M_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return bvo;
	}
	
	// 댓글 읽어오는 기능
	public ArrayList<ReCommentVo> readBoardReComments(Connection conn, int bNo) {

		ArrayList<ReCommentVo> rvo = new ArrayList<ReCommentVo>();
		
		// 1. SQL문 실행
		String sql = "SELECT * FROM RE_COMMENT WHERE B_NO = ? ORDER BY R_WRITE_DATE DESC, B_NO DESC";
		
//		R_NO         NOT NULL NUMBER        
//		B_NO         NOT NULL NUMBER        
//		R_WRITER     NOT NULL VARCHAR2(60)  
//		R_WRITE_DATE NOT NULL TIMESTAMP(6)  
//		R_CONTENT    NOT NULL VARCHAR2(900) 
//		M_ID         NOT NULL VARCHAR2(20)  
		
		ReCommentVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				vo = new ReCommentVo();
				vo.setrNo(rset.getInt("R_NO"));
				vo.setbNo(rset.getInt("B_NO"));
				vo.setrWriter(rset.getString("R_WRITER"));
				vo.setrWriteDate(rset.getTimestamp("R_WRITE_DATE"));
				vo.setrContent(rset.getString("R_CONTENT"));
				vo.setmId(rset.getString("M_ID"));
				
				rvo.add(vo);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rvo;
	}
	
	// 게시글 제목, 내용 변경하는 기능
	public int updateBoard(Connection conn, BoardVo vo, int bNo) {
		
		BoardVo bvo = null;
//		------------ -------- -------------- 
//		B_NO         NOT NULL NUMBER         
//		B_TITLE      NOT NULL VARCHAR2(300)  
//		B_CONTENT    NOT NULL VARCHAR2(3000) 
//		B_COUNT      NOT NULL NUMBER         
//		B_WRITE_DATE NOT NULL TIMESTAMP(6)   
//		B_WRITER     NOT NULL VARCHAR2(60)   
//		M_ID         NOT NULL VARCHAR2(20)
		String sql = "UPDATE BOARD SET B_TITLE = ?, B_CONTENT = ? WHERE B_NO = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbTitle());
			pstmt.setString(2, vo.getbContent());
			pstmt.setInt(3, bNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	// 게시글 지우는 기능
	public int deleteBoard(Connection conn, int bNo) {
		
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE B_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 댓글 몇 개인지 확인하는 기능 
	public int countReComment(Connection conn) { 
		int result = 0;
		String sql = "SELECT B_NO 글번호, COUNT(*) 댓글개수\r\n"
				+ "FROM RE_COMMENT\r\n"
				+ "WHERE R_NO IS NOT NULL\r\n"
				+ "GROUP BY B_NO";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}
	
	// 댓글 삭제 기능
	public int deleteReComment(Connection conn, int bNo) {
		
		int result = 0;
		String sql = "DELETE FROM RE_COMMENT WHERE B_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
public ArrayList<BoardVo> searchBoard(Connection conn, BoardVo bvo, int bNo) {
		
		ArrayList<BoardVo> result = null;
				
		result = new ArrayList<BoardVo>();
		
		// 변수로 선언하거나 연결자 || 사용
		// String like = "%" + bvo.getSearchWord() + "%";
		String sql = "SELECT * \r\n"
				+ "FROM BOARD \r\n"
				+ "WHERE (B_TITLE LIKE '%'||?||'%' OR B_CONTENT LIKE '%'||?||'%') OR (B_TITLE LIKE '%'||?||'%' OR B_CONTENT LIKE '%'||?||'%')"
				+ "ORDER BY B_NO DESC";
		
		
		BoardVo vo = null;
		String[] strArr = new String[100];
		StringTokenizer st = new StringTokenizer(bvo.getSearchWord(), ",| ");
		int num = 0;
		while(st.hasMoreTokens()) {
			strArr[num] = st.nextToken();
			num++;
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < num; i++) {
				pstmt.setString(1, strArr[i]);
				pstmt.setString(2, strArr[i]);
				pstmt.setString(3, strArr[i]);
				pstmt.setString(4, strArr[i]);
				rset = pstmt.executeQuery();
				rset.next();
			}
			
			while(rset.next()) {
				
				vo = new BoardVo();
				vo.setbNo(rset.getInt("B_NO"));
				vo.setbTitle(rset.getString("B_TITLE"));
				vo.setbContent(rset.getString("B_CONTENT"));
				vo.setbCount(rset.getInt("B_COUNT"));
				vo.setbWriteDate(rset.getTimestamp("B_WRITE_DATE"));
				vo.setbWriter(rset.getString("B_WRITER"));
				vo.setmId(rset.getString("M_ID"));
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
}
