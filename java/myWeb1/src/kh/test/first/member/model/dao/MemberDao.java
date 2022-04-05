package kh.test.first.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.test.first.member.model.vo.MemberVo;

import static kh.test.first.common.jdbc.JdbcTemplate.close;




public class MemberDao {

	private ResultSet rset = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	// 멤버 추가
	public int insertMember(Connection conn, MemberVo mvo) {
		
		int result = 0;
		String sql = "INSERT INTO MEMBER (M_ID, NICKNAME, EMAIL, PHONE, PASSWORD)"
					+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mvo.getmId());
			pstmt.setString(2, mvo.getNickname());
			pstmt.setString(3, mvo.getEmail());
			pstmt.setString(4, mvo.getPhone());
			pstmt.setString(5, mvo.getPassword());
			
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
	
	// 멤버 수정
	public int updateMember(Connection conn, MemberVo mvo, String password) {
		
		int result = 0;
		
		String sql = "UPDATE MEMBER SET NICKNAME = ?, EMAIL = ?, PHONE = ?, PASSWORD = ? WHERE PASSWORD = ?";
		try { 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getNickname());
			pstmt.setString(2, mvo.getEmail());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getPassword());
			pstmt.setString(5, password);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally { 
			close(pstmt);
		}
		
		return result;
	}
	
	// 수정 전 체크
	public int checkUpdateMember(Connection conn, String password) {

		int result = 0;
		ArrayList<MemberVo> vo = new ArrayList<MemberVo>();
		vo = listMember(conn);

		String sql = "SELECT * FROM MEMBER";
		try { 

			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			String checkpass = "";
			for(int i = 0; i < vo.size(); i++) {
				checkpass = vo.get(i).getPassword();
				if(password.equals(checkpass)) {
					result = 1;
					break;
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally { 
			close(rset);
			close(pstmt);
		}

		return result;
	}
	
	// 멤버 삭제
	public int deleteMember(Connection conn, MemberVo mvo /* String mId, String password*/) {
		
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE M_ID = ? AND PASSWORD = ?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getCheckId());
			pstmt.setString(2, mvo.getCheckPassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return result;
		
	}
	
	// 멤버 리스트 개수 구하기
	public int countMemberList(Connection conn) {
		
		int result = 0;
		
		String sql = "SELECT COUNT(*) FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
	
	// 멤버 전체 조회
	public ArrayList<MemberVo> listMember(Connection conn) {
		
		ArrayList<MemberVo> memberList = null;
		
		String sql = "SELECT * FROM MEMBER";
	
	try {
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		memberList = new ArrayList<MemberVo>();
		
		while(rset.next()) {
			MemberVo mvo = new MemberVo();
			mvo.setEmail(rset.getString("EMAIL"));
			mvo.setmId(rset.getString("M_ID"));
			mvo.setNickname(rset.getString("NICKNAME"));
			mvo.setPassword(rset.getString("PASSWORD"));
			mvo.setPhone(rset.getString("PHONE"));
			
			memberList.add(mvo);
			
			
		}
//		for(int i = 0; i < memberList.size(); i++) {
//			System.out.println(i+"번째 저장되어 있는 ID,PW : " + memberList.get(i).getmId() + ", " + memberList.get(i).getPassword());
//		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
		
		return memberList;
		
	}
	
	// 페이징 처리
	public ArrayList<MemberVo> listMember(Connection conn, int startRnum, int endRnum) {
		
		ArrayList<MemberVo> voList = null;
		
		String sql = "SELECT * FROM(SELECT ROWNUM RNUM, M.* FROM MEMBER M)A WHERE A.RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				voList = new ArrayList<MemberVo>();
				
				do {
					MemberVo mvo = new MemberVo();
					mvo.setmId(rset.getString("M_ID"));
					mvo.setNickname(rset.getString("NICKNAME"));
					mvo.setEmail(rset.getString("EMAIL"));
					mvo.setPhone(rset.getString("PHONE"));
					mvo.setPassword(rset.getString("PASSWORD"));
					
					voList.add(mvo);
					
				} while (rset.next());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return voList;
		
		
	}
	
	
	// 멤버 1명 조회
	public MemberVo readMember(Connection conn, String mId /* 보통 pk있는거 가져옴 */) {
		
		MemberVo result = new MemberVo();
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result.setmId(rset.getString("M_ID"));
				result.setNickname(rset.getString("NICKNAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPhone(rset.getString("PHONE"));
				result.setPassword(rset.getString("PASSWORD"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rset);
			close(pstmt);
		}
		return result;
		
	}
	
	// 로그인
	public MemberVo loginMember(Connection conn, String id, String password) {
		

		MemberVo result = null;
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND PASSWORD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new MemberVo();
				result.setmId(rset.getString("M_ID"));
				result.setEmail(rset.getString("email"));
				result.setNickname(rset.getString("NICKNAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPhone(rset.getString("PHONE"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		return result;
	}
	
	// 검색
	public ArrayList<MemberVo> searchMember(Connection conn, MemberVo mvo, String search) {
		
		ArrayList<MemberVo> result = null;
		
		result = new ArrayList<MemberVo>();
		
		String sql = "SELECT * FROM MEMBER WHERE M_ID LIKE '%'||?||'%'";
		
		MemberVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				vo = new MemberVo();
				vo.setmId(rset.getString("M_ID"));
				vo.setNickname(rset.getString("NICKNAME"));
				vo.setEmail(rset.getString("EMAIL"));
				vo.setPhone(rset.getString("PHONE"));
				vo.setPassword(rset.getString("PASSWORD"));
				
				result.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} close(pstmt);
		
		return result;
		
	}
	
	
}

