package kh.test.first.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.test.first.member.model.dao.MemberDao;
import kh.test.first.member.model.vo.MemberVo;

import static kh.test.first.common.jdbc.JdbcTemplate.*;

public class MemberService {
	
	private MemberDao dao = new MemberDao();

	// 멤버 추가
	public int insertMember(MemberVo mvo) {
		
		int result = 0;
		
		Connection conn = getConnection();
		result = dao.insertMember(conn, mvo);
		close(conn);
		
		return result;
		
	}
	
	// 멤버 수정
	public int updateMember(MemberVo mvo, String password) {

		int result = 0;
		
		Connection conn = getConnection();
		result = dao.updateMember(conn, mvo, password);
		close(conn);
		
		return result;
		
	}
	
	// 멤버 수정 전 체크
	public int checkUpdateMember(String password) {
		
		int result = 0;
		
		Connection conn = getConnection();
		result = dao.checkUpdateMember(conn, password);
		close(conn);
		
		return result;
		
	}
	
	// 멤버 삭제
	public int deleteMember(MemberVo mvo) {

		int result = 0;
		
		Connection conn = getConnection();
		result = dao.deleteMember(conn, mvo);
		close(conn);
		
		return result;
		
	}
	
	// 멤버리스트 개수 확인
	public int countMemberList() {
		
		Connection conn = getConnection();
		
		int result = dao.countMemberList(conn);
		close(conn);
		
		return result;
		
	}
	
	
	public ArrayList<MemberVo> listMember(){
		ArrayList<MemberVo> result = null;
		Connection conn = getConnection();
		result = dao.listMember(conn);
		close(conn);
		return result;
	}
	
	// 멤버 리스트 페이징처리
	public ArrayList<MemberVo> listMember(int startRnum, int endRnum) {
		
		Connection conn = getConnection();
		
		ArrayList<MemberVo> voList = dao.listMember(conn, startRnum, endRnum);
		close(conn);
		
		return voList;
		
	}
	
	public MemberVo readMember(String mId){
		MemberVo result = null;
		Connection conn = getConnection();
		result = dao.readMember(conn, mId);
		close(conn);
		return result;
	}
	
	// 로그인
	public MemberVo loginMember(String id, String password) {
		
		Connection conn = getConnection();
		MemberVo result = dao.loginMember(conn, id, password);
		close(conn);
		return result;
		
	}
	
	// 검색
	public ArrayList<MemberVo> searchMember(MemberVo mvo, String search) {
		
		Connection conn = getConnection();
		ArrayList<MemberVo> result = dao.searchMember(conn, mvo, search);
		close(conn);
		return result;
	}
	
}
