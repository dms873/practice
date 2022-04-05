package kh.test.first.member.model.vo;

public class MemberVo {

//	-------- -------- ------------- 
//	M_ID     NOT NULL VARCHAR2(20)  
//	NICKNAME NOT NULL VARCHAR2(60)  
//	EMAIL    NOT NULL VARCHAR2(150) 
//	PHONE    NOT NULL VARCHAR2(30)  
//	PASSWORD NOT NULL VARCHAR2(20)  
	
	private String mId;
	private String nickname;
	private String email;
	private String phone;
	private String password;
	
	private String checkId;
	private String checkPassword;
	
	private String searchWord;
	
	public MemberVo() {
		super();
	}

	
	
	public MemberVo(String searchWord) {
		super();
		this.searchWord = searchWord;
	}



	public MemberVo(String checkId, String checkPassword) {
		super();
		this.checkId = checkId;
		this.checkPassword = checkPassword;
	}



	public MemberVo(String mId, String nickname, String email, String phone, String password) {
		super();
		this.mId = mId;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public MemberVo(String nickname, String email, String phone, String password) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}



	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [mId=" + mId + ", nickname=" + nickname + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + "]";
	}



	public String getCheckId() {
		return checkId;
	}



	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}



	public String getCheckPassword() {
		return checkPassword;
	}



	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}



	public String getSearchWord() {
		return searchWord;
	}



	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
}
