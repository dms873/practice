package kh.test.first.board.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BoardVo {
	
	/*------------ -------- -------------- 
	B_NO         NOT NULL NUMBER         
	B_TITLE      NOT NULL VARCHAR2(300)  
	B_CONTENT    NOT NULL VARCHAR2(3000) 
	B_COUNT      NOT NULL NUMBER         
	B_WRITE_DATE NOT NULL TIMESTAMP(6)   
	B_WRITER     NOT NULL VARCHAR2(60)   
	M_ID         NOT NULL VARCHAR2(20)   */

	// vo에 화면에 나타낼 컬럼 변수 선언하기!
	// 컬럼이름과 똑같이 (소문자로)작성해주어야 편하다. -> resultset에서 컬럼이름을 vo에 넣어줘야하기 때문에!
	// B_NO (대문자)로 작성하게되면 final 또는 상수로 인식하게 됨. 
	// getter, setter에서 변수를 역행으로 찾는 방법이 있는데, getB_NO 라면 b_NO라는 필드를 찾게 됨.
	// 변수명에서 _는 자바에서 잘 사용하지 않음.(써도 상관은 없지만..) 그래서 카멜케이스 방법으로 작성함.
	private int bNo;
	private String bTitle;
	private String bContent;
	private int bCount;
	private Timestamp bWriteDate;
	private String bWriter;
	private String mId;
	
	// 댓글 개수 확인 변수 선언
	private int reCommentCnt;
	
	// 검색
	private String searchWord;
	private StringTokenizer searchWordst;
	
	// 게시글 1개에 댓글이 여러개일 때(Map 사용하지 않고 싶을 때)
	private ArrayList<ReCommentVo> reVoList; // 생성자에 넣는건 비추! ( 생성시 초기값 설정 하지 않음 -> Setter사용 )
	
	public BoardVo() {
		super();
	}
	
	public BoardVo(String bTitle, String bContent) {
		super();
		this.bTitle = bTitle;
		this.bContent = bContent;
	}
	
	public BoardVo(StringTokenizer searchWordst) {
		super();
		this.searchWordst = searchWordst;
	}

	public BoardVo(String searchWord) {
		super();
		this.searchWord = searchWord;
	}

	public BoardVo(int bNo, String bTitle, String bContent, int bCount, Timestamp bWriteDate, String bWriter,
			String mId, int reCommentCnt) {
		super();
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bCount = bCount;
		this.bWriteDate = bWriteDate;
		this.bWriter = bWriter;
		this.mId = mId;
		this.reCommentCnt = reCommentCnt;
	}

	

	@Override
	public String toString() {
		return "BoardVo [bNo=" + bNo + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bCount=" + bCount
				+ ", bWriteDate=" + bWriteDate + ", bWriter=" + bWriter + ", mId=" + mId + ", reCommentCnt="
				+ reCommentCnt + ", searchWord=" + searchWord + ", reVoList=" + reVoList + "]";
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public Timestamp getbWriteDate() {
		return bWriteDate;
	}

	public void setbWriteDate(Timestamp bWriteDate) {
		this.bWriteDate = bWriteDate;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getReCommentCnt() {
		return reCommentCnt;
	}

	public void setReCommentCnt(int reCommentCnt) {
		this.reCommentCnt = reCommentCnt;
	}
	
	public ArrayList<ReCommentVo> getReVoList() {
		return reVoList; // 주소번지 저장
	}

	public void setReVoList(ArrayList<ReCommentVo> reVoList) {
		this.reVoList = reVoList; // 주소번지 저장 (최초 값 넣을 때 new 해야됨)
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public StringTokenizer getSearchWordst() {
		return searchWordst;
	}

	public void setSearchWordst(StringTokenizer searchWordst) {
		this.searchWordst = searchWordst;
	}

	
	
	
}
