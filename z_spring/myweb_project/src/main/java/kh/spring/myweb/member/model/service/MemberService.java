package kh.spring.myweb.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.myweb.member.model.dao.MemberDao;

// 방법 2)
@Service
public class MemberService {

	// private MemberDao dao = new MemberDao();
	@Autowired
	private MemberDao memberDao;
	
	public String login(String id, String pwd) {
		return memberDao.login(id, pwd);
	}
	
	
}
