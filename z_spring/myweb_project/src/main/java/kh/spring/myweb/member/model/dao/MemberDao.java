package kh.spring.myweb.member.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 방법 2)
@Repository
public class MemberDao {

	// logger 사용하려면 아래 코드 필수! class는 내 클래스 작성해야 여기서 사용 가능
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	// root-context.xml에 만들어진 id="sqlSession" 객체를 static으로 하면 다른 클래스에서 사용이 가능하지만 그게 아니기 때문에
	// @Autowired 어노테이션을 사용하여 찾아달라고 하는 것
	// @Autowired 어노테이션의 기능 : SqlSession 자료형으로 객체가 만들어진 것이 있다면 찾아서 사용하겠다!
	@Autowired
	// SqlSessionTemplate으로 써도 됨. 근데 굳이 길게 안써도 됨.
	private SqlSession sqlSession;
	
	public String login(String id, String pwd) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		String result = sqlSession.selectOne("memberMapper.login", map);
		
		return result;
	}
	
	
}
