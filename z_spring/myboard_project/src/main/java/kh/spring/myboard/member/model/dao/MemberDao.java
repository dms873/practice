package kh.spring.myboard.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.myboard.member.model.vo.Member;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int insertMember(Member member) {
		return sqlsession.insert("Member.insertMember", member);
	}
	
	public Member selectLogin(Member member) {
		return sqlsession.selectOne("Member.selectLogin", member);
	}

}
