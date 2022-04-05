package kh.test.first.board.model.vo;

import java.sql.Timestamp;

public class ReCommentVo {
	
//	------------ -------- ------------- 
//	R_NO         NOT NULL NUMBER        
//	B_NO         NOT NULL NUMBER        
//	R_WRITER     NOT NULL VARCHAR2(60)  
//	R_WRITE_DATE NOT NULL TIMESTAMP(6)  
//	R_CONTENT    NOT NULL VARCHAR2(900) 
//	M_ID         NOT NULL VARCHAR2(20)  

	private int rNo;
	private int bNo;
	private String rWriter;
	private Timestamp rWriteDate;
	private String rContent;
	private String mId;
	
	public ReCommentVo() {
		super();
	}

	public ReCommentVo(String rContent) {
		super();
		this.rContent = rContent;
	}

	public ReCommentVo(int bNo, String rContent) {
		super();
		this.bNo = bNo;
		this.rContent = rContent;
	}
	
	
	public ReCommentVo(int bNo) {
		super();
		this.bNo = bNo;
	}

	public ReCommentVo(int rNo, int bNo, String rWriter, Timestamp rWriteDate, String rContent, String mId) {
		super();
		this.rNo = rNo;
		this.bNo = bNo;
		this.rWriter = rWriter;
		this.rWriteDate = rWriteDate;
		this.rContent = rContent;
		this.mId = mId;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public Timestamp getrWriteDate() {
		return rWriteDate;
	}

	public void setrWriteDate(Timestamp rWriteDate) {
		this.rWriteDate = rWriteDate;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "ReCommentVo [rNo=" + rNo + ", bNo=" + bNo + ", rWriter=" + rWriter + ", rWriteDate=" + rWriteDate
				+ ", rContent=" + rContent + ", mId=" + mId + "]";
	}
	
	
	
	

}
